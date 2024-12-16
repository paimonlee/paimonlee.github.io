import axios from 'axios';
import fs from 'fs';
import path from 'node:path';

async function download(link: string, threadNum: number, filename: string) {
    axios.head(link).then(async (response) => {
        if (response.status == 200 && response.headers
            && response.headers instanceof axios.AxiosHeaders) {
            const contentSize = Number(response.headers.get('content-length'));
            const threadSize = Math.ceil(contentSize / threadNum)
            const downloadPromises = [];
            const arrayBuffers: Array<ArrayBuffer> = [];
            for (let i = 0; i < threadNum; i++) {
                const start = i * threadSize;
                const end = Math.min((i + 1) * threadSize - 1, contentSize - 1)
                console.log("Thread ", i, " download start:", start, " end:", end)

                const chunkDownload = axios.get(link, {
                    responseType: 'arraybuffer',
                    headers: {
                        "Range": `bytes=${start}-${end}`
                    }
                }).then(response => {
                    arrayBuffers[i] = response.data;
                })
                downloadPromises.push(chunkDownload)
            }
            // 等待下载
            await Promise.all(downloadPromises);
            // 计算合并后的 ArrayBuffer 的总大小
            const totalLength = arrayBuffers.reduce((sum, buffer) => sum + buffer.byteLength, 0);

            // 创建一个新的 ArrayBuffer 来存储合并后的数据
            const mergedArrayBuffer = new ArrayBuffer(totalLength);

            // 创建一个视图来操作新的 ArrayBuffer
            let offset = 0;

            // 遍历每个 ArrayBuffer，将其内容复制到新的 ArrayBuffer 中
            arrayBuffers.forEach(buffer => {
                // 创建当前 buffer 的 Uint8Array 视图
                const view = new Uint8Array(buffer);

                // 将当前 buffer 的数据复制到合并的 ArrayBuffer 中
                new Uint8Array(mergedArrayBuffer, offset, view.length).set(view);

                // 更新偏移量
                offset += view.length;
            });
            const buffer = Buffer.from(mergedArrayBuffer);
            const outputPath = path.join(__dirname, filename)
            fs.openSync(outputPath, 'a+'); // 打开文件以进行写入
            fs.writeFileSync(outputPath, buffer, { flag: 'r+' });
            return Promise.resolve()
        } else {
            return Promise.reject(0)
        }
    }).catch(error => Promise.reject(error))
}

const startTime = Date.now()
download("https://down-tencent.huorong.cn/sysdiag-all-x64-6.0.4.3-2024.12.10.1.exe", 8, "sysdiag-all-x64-6.0.4.3-2024.12.10.1.exe")
    .then(() => console.log("Success.Cost time:", Date.now() - startTime))
    .catch(error => console.log("FetchInfo error:", error));

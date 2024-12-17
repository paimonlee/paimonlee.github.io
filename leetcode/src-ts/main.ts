import axios from 'axios';
import fs from 'fs';
import path from 'node:path';
import { Stream } from 'node:stream';

async function download(link: string, threadNum: number, filename: string) {
    axios.head(link).then(async (response) => {
        if (response.status == 200 && response.headers
            && response.headers instanceof axios.AxiosHeaders) {
            const contentSize = Number(response.headers.get('content-length'));
            const chunkSize = Math.ceil(contentSize / threadNum)
            const downloadPromises: Promise<void>[] = [];
            for (let i = 0; i < threadNum; i++) {
                const start = i * chunkSize;
                const end = Math.min((i + 1) * chunkSize - 1, contentSize - 1)
                const partPath = path.join(__dirname, filename + ".part." + i)
                const downloadSize = fs.existsSync(partPath) ? fs.statSync(partPath).size : 0;
                const writer = fs.createWriteStream(partPath, { flags: 'a+' })

                if (downloadSize >= end - start + 1) {
                    continue;
                }

                const promise = axios.get(link, {
                    responseType: 'stream',
                    headers: {
                        "Range": `bytes=${start + downloadSize}-${end}`
                    }
                }).then(async (response) => {
                    response.data.pipe(writer)
                    const waitPromise = (writer: Stream) => {
                        return new Promise((resolve, rejects) => {
                            writer.on('end', resolve);
                            writer.on('error', rejects);
                        })
                    }
                    await waitPromise(writer);
                })
                downloadPromises.push(promise)
            }
            // 等待下载
            await Promise.all(downloadPromises);
            const writer = fs.createWriteStream(path.join(__dirname, filename), { flags: 'a+' })
            for (let i = 0; i < threadNum; i++) {
                const partPath = path.join(__dirname, filename + ".part." + i)
                const data: Buffer = fs.readFileSync(partPath)
                console.log("read buffer size:", data.length)
                writer.write(data);
            }
        }
    }).catch(error => Promise.reject(error))
}

const startTime = Date.now()
download("https://down-tencent.huorong.cn/sysdiag-all-x64-6.0.4.3-2024.12.10.1.exe", 8, "sysdiag-all-x64-6.0.4.3-2024.12.10.1.exe")
    .then(() => console.log("Success.Cost time:", Date.now() - startTime))
    .catch(error => console.log("FetchInfo error:", error));

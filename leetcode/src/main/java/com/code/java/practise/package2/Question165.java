package com.code.java.practise.package2;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月07日 20:56:07
 * @apiNote:
 */
public class Question165 {

    public static void main(String[] args) {
        Question165 question165 = new Question165();
        String version1 = "1.0.1";
        String version2 = "1";
        System.out.println(question165.compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {
        String[] version1Splited = version1.split("\\.");
        String[] version2Splited = version2.split("\\.");
        int len = Math.min(version1Splited.length, version2Splited.length);
        for (int i = 0; i < len; i++) {
            if (Integer.valueOf(version1Splited[i]) > Integer.valueOf(version2Splited[i])) {
                return 1;
            } else if (Integer.valueOf(version1Splited[i]) < Integer.valueOf(version2Splited[i])) {
                return -1;
            }
        }
        if (len < version1Splited.length) {
            for (int i = len; i < version1Splited.length; i++) {
                if (Integer.valueOf(version1Splited[i]) != 0) {
                    return 1;
                }
            }
        } else if (len < version2Splited.length) {
            for (int i = len; i < version2Splited.length; i++) {
                if (Integer.valueOf(version2Splited[i]) != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}

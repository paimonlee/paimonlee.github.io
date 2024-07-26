package com.code.java.practise.package1;

public class Question87 {
    public static void main(String[] args) {
        boolean scramble = new Question87().isScramble("great", "rgeat");
        System.out.println(scramble);
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        for (int i = 1; i < s1.length(); i++) {
            boolean b = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))
                    || (isScramble(s1.substring(0, i), s2.substring(s1.length()-i)) && isScramble(s1.substring(i), s2.substring(0, s1.length()-i)));
            if (b) {
                return true;
            }
        }
        return false;
    }

//    public boolean isScramble(String s1, String s2) {
//        char[] chs1 = s1.toCharArray();
//        char[] chs2 = s2.toCharArray();
//        int n = s1.length();
//        int m = s2.length();
//        if (n != m) {
//            return false;
//        }
//        boolean[][][] dp = new boolean[n][n][n + 1];
//        // 初始化单个字符的情况
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[i][j][1] = chs1[i] == chs2[j];
//            }
//        }
//
//        // 枚举区间长度 2～n
//        for (int len = 2; len <= n; len++) {
//            // 枚举 S 中的起点位置
//            for (int i = 0; i <= n - len; i++) {
//                // 枚举 T 中的起点位置
//                for (int j = 0; j <= n - len; j++) {
//                    // 枚举划分位置
//                    for (int k = 1; k <= len - 1; k++) {
//                        // 第一种情况：S1 -> T1, S2 -> T2
//                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
//                            dp[i][j][len] = true;
//                            break;
//                        }
//                        // 第二种情况：S1 -> T2, S2 -> T1
//                        // S1 起点 i，T2 起点 j + 前面那段长度 len-k ，S2 起点 i + 前面长度k
//                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
//                            dp[i][j][len] = true;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return dp[0][0][n];
//    }
}

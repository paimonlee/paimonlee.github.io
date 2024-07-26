package com.code.java.practise.package1;

/**
 * 		*	a	*	b
 * 	    1	1	0	0	0
 * a	0	1	1	1	0
 * d	0	1	0	1	0
 * c	0	1	0	1	0
 * e	0	1	0	1	0
 * b	0	1	0	1	1
 */
public class Question44Mine {
    public static void main(String[] args) {
        boolean result = new Question44Mine().isMatch("bbaaaabaaaaabbabbabbabbababaabababaabbabaaabbaababababbabaabbabbbbbbaaaaaabaabbbbbabbbbabbabababaaaaa"
                , "******aa*bbb*aa*a*bb*ab***bbba*a*babaab*b*aa*a****");
        System.out.println(result);
    }
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;//如果都是空的返回true
        for (int i = 1; i <= plen; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                //？表示直接和s相等，所以直接可以与p.charAt(j) == s.charAt(i)等价
                if (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j-1) == '*') {
                    //dp[i][j - 1] 不使用这个*号 表示变换成空格
                    //dp[i - 1][j] 使用这个*，变成一个或者多个字母
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[slen][plen];
    }
}

package com.code.java.practise.package1;

/**
 * 深度递归超时，使用动态规划才行
 */
public class Question44 {
    public static void main(String[] args) {
        boolean result = new Question44().isMatch("bbaaaabaaaaabbabbabbabbababaabababaabbabaaabbaababababbabaabbabbbbbbaaaaaabaabbbbbabbbbabbabababaaaaa"
                , "******aa*bbb*aa*a*bb*ab***bbba*a*babaab*b*aa*a****");
        System.out.println(result);
    }

    public boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int indexOfs = 0;
        int indexOfp = 0;
        return dfs(sChars, indexOfs, pChars, indexOfp);
    }

    private boolean dfs(char[] sChars, int indexOfs, char[] pChars, int indexOfp) {
        if (indexOfs >= sChars.length) {
            while (indexOfp < pChars.length) {
                if (pChars[indexOfp] == '*') {
                    indexOfp++;
                } else {
                    return false;
                }
            }
            return true;
        } else if (indexOfp >= pChars.length) {
            return false;
        }
        if (isEqualChar(sChars[indexOfs], pChars[indexOfp])) {
            //有两种情况
            if (dfs(sChars, indexOfs + 1, pChars, indexOfp + 1)) {
                //1、?代表空
                //2、?代表一个字符
                return true;
            } else {
                return false;
            }
        } else if (pChars[indexOfp] == '*') {
            if (indexOfp == pChars.length - 1
                    || dfs(sChars, indexOfs, pChars, indexOfp + 1)
                    || dfs(sChars, indexOfs + 1, pChars, indexOfp + 1)) {
                //如果此时*是pattern的最后一个字符
                return true;
            } else {
                char pChar = pChars[indexOfp + 1];
                //要找到所有的
                while (indexOfs < sChars.length) {
                    if (isEqualChar(sChars[indexOfs], pChar)
                            && dfs(sChars, indexOfs, pChars, indexOfp + 1)) {
                        return true;
                    }
                    indexOfs++;
                }
                return dfs(sChars, indexOfs + 1, pChars, indexOfp + 1);
            }
        } else {
            return false;
        }
    }

    private boolean isEqualChar(char c, char p) {
        return c == p || p == '?';
    }
}

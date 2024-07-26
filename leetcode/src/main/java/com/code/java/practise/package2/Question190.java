package com.code.java.practise.package2;


/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年8月09日 21:55:19
 * @apiNote:
 */
public class Question190 {
    public static void main(String[] args) {
        Question190 question190 = new Question190();
        int n = Integer.parseUnsignedInt("11111111111111111111111111111101",2);
        System.out.println(question190.reverseBits(n));
    }

    public int reverseBits(int n) {
        //以下是java的代码
        return Integer.reverse(n);
        //以下是我的代码
        // String hexString = Integer.toBinaryString(n);
        // StringBuilder stringBuilder = new StringBuilder(hexString);
        // stringBuilder = stringBuilder.reverse();
        // while(stringBuilder.length()<32){
        //     stringBuilder.append("0");
        // }
        // return Integer.parseUnsignedInt(stringBuilder.toString(),2);
    }
}

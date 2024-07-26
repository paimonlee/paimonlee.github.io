package com.code.java.practise.package3;

import java.util.List;

/**
 * 汉诺塔问题
 */
public class Interview0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int size = A.size();
        hanota1(size, A, B, C);
    }

    private void hanota1(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        //如果A上面只有一个元素，将A上面的元素移动到C
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        //把除开最大的那个元素之外的其他元素全部移动到B
        hanota1(n - 1, A, C, B);
        //把最大的元素移动到C
        C.add(A.remove(A.size() - 1));
        //忽略C上面的最大元素，将B上面的元素移动到C
        hanota1(n - 1, B, A, C);
    }
}

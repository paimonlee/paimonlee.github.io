package com.code.java.practise.package1;

import java.util.ArrayList;
import java.util.List;

public class Question68 {
    public static void main(String[] args) {
        String[] strings = {"What", "must", "be", "acknowledgment", "shall", "be"};
        List<String> strings1 = new Question68().fullJustify(strings, 16);
        for (String line : strings1) {
            System.out.println(line);
        }
    }

    private List<String> buffer = new ArrayList<>();
    private List<String> result = new ArrayList<>();

    public List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0;
        int lineWordCount = 0;
        while (index < words.length) {
            if ((lineWordCount + words[index].length() + buffer.size()) <= maxWidth) {
                buffer.add(words[index]);
                lineWordCount += words[index].length();
                index++;
            } else {
                if (lineWordCount == 0) {
                    result.add(words[index]);
                    index++;
                    continue;
                }
                result.add(joinString(maxWidth, lineWordCount, buffer, false));
                buffer.clear();
                lineWordCount = 0;
            }
        }
        //处理最后一行，清空buffer
        if (buffer.size() != 0) {
            result.add(joinString(maxWidth, lineWordCount, buffer, true));
        }
        return result;
    }

    private String getBlacks(int num) {
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < num; i++) {
            temp.append(" ");
        }
        return temp.toString();
    }

    private String joinString(int maxWidth, int lineWordCount, List<String> lineBuffer, boolean isLastLine) {
        if (lineBuffer.size() == 1) {
            return lineBuffer.get(0) + getBlacks(maxWidth - lineWordCount);
        }
        if (isLastLine) {
            StringBuffer tmp = new StringBuffer();
            for (String word : lineBuffer) {
                tmp.append(word);
                tmp.append(" ");
            }
            String result = tmp.toString().trim();
            return result + getBlacks(maxWidth - result.length());
        } else {
            //总共的空格数
            int blacks = maxWidth - lineWordCount;
            //平均除下来多出来的空格数
            int mod = blacks % (lineBuffer.size() - 1);
            //每个间隙的空格数
            int black = blacks / (lineBuffer.size() - 1);
            String tmp = getBlacks(black);
            StringBuffer stringBuffer = new StringBuffer();
            mod++;
            for (String word : lineBuffer) {
                if (mod > 0) {
                    stringBuffer.append(" ");
                    mod--;
                }
                stringBuffer.append(tmp);
                stringBuffer.append(word);
            }
            return stringBuffer.toString().trim();
        }
    }
}

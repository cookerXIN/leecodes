import java.io.*;
import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/4
 */
public class a {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        long count = countCuteStrings(n);
        System.out.println("长度为 " + n + " 的字符串中的可爱串数量为: " + count);
    }
    public static long countCuteStrings(int n) {
        if (n < 3) {
            return 0; // 长度小于3的字符串无法包含"red"子序列
        }
        return cal(n, "", 0);
    }
    public static long cal(int n, String cur, int index) {
        if (index == n) {
            if(judge(cur)){
                return 1;
            }
        }
        long count = 0;
        count += cal(n, cur + "r", index + 1);
        count += cal(n, cur + "e", index + 1);
        count += cal(n, cur + "d", index + 1);
        return count;
    }
    public static boolean judge(String str) {
        int index = 0; // 用于记录字符 'r' 在字符串中的位置
        // 依次查找字符 'r'、'e'、'd' 是否按顺序出现
        for (char c : "red".toCharArray()) {
            index = str.indexOf(c, index); // 查找字符 c 在字符串中的位置
            if (index == -1) {
                return false; // 如果字符 c 不存在或顺序不正确，返回false
            }
            index++; // 继续查找下一个字符
        }
        return true; // 所有字符按顺序出现，返回true
    }
}





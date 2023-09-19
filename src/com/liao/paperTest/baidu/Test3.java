package com.liao.paperTest.baidu;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/12
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q = Integer.parseInt(input.nextLine());
        MethodManager m = new MethodManager();
        while (q > 0) {
            int op = Integer.parseInt(input.nextLine());
            String str = input.nextLine();
            if (op == 1) {
                System.out.println(m.createMethod(str));
            } else if (op == 2) {
                System.out.println(m.callMethod(str));
            }

            q--;
        }
    }

    static class MethodManager {
        private Map<String, List<List<String>>> methods;

        public MethodManager() {
            methods = new HashMap<>();
        }

        public String createMethod(String strs) {
            String[] parts = strs.split("\\(");
            String methodName = parts[0].split(" ")[1];
            String[] params = parts[1].replace(")", "").split(",");
            List<String> paramTypes = new ArrayList<>();
            for (String param : params) {
                paramTypes.add(param.trim().split(" ")[0]);
            }
            methods.putIfAbsent(methodName, new ArrayList<>());
            for (List<String> list : methods.get(methodName)) {
                if (list.equals(paramTypes)) {
                    return "method " + methodName + " is already defined.";
                }
            }
            methods.get(methodName).add(paramTypes);
            return "ok.";
        }

        public String callMethod(String strs) {
            String[] parts = strs.split("\\(");
            String methodName = parts[0];
            String[] params = parts[1].replace(")", "").split(",");
            List<String> list = new ArrayList<>(Arrays.asList(params));
            if (!methods.containsKey(methodName)) {
                return "cannot find symbol " + methodName + ".";
            }

            for (List<String> strings : methods.get(methodName)) {
                if (strings.equals(list)) {
                    return "ok.";
                }
            }

            return "method " + methodName + " cannot be applied to given types.";
        }
    }
}

package com.liao.hot100;

import java.util.LinkedList;

/**
 * @author liaoguixin
 * @date 2023/8/7
 */
public class H155 {

    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


    static class MinStack {
        LinkedList<Integer> mainList;
        LinkedList<Integer> smallList;
        public MinStack() {
            mainList = new LinkedList<Integer>();
            smallList = new LinkedList<Integer>();
            smallList.add(Integer.MAX_VALUE);
        }

        public void push(int val) {
            mainList.add(val);
            if (val > smallList.peekLast()) {
                smallList.addLast(smallList.peekLast());
            } else {
                smallList.addLast(val);
            }

        }

        public void pop() {
            mainList.removeLast();
            smallList.removeLast();
        }

        public int top() {
            if (mainList.isEmpty()) {
                return -1;
            }
            return mainList.peekLast();
        }

        public int getMin() {
            return smallList.peekLast();
        }
    }

    // 不用辅助栈 采用与最小值差值来做
    static class MinStack1 {
        LinkedList<Long> stack;
        long min;

        public MinStack1() {
            stack = new LinkedList<Long>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(0L);
                min = val;
                return;
            }

            long dif = (long) val - min;
            stack.push(dif);
            min = Math.min(min, val);
        }

        public void pop() {
            long dif = stack.removeFirst();
            if (dif < 0) {
                min = min - dif;
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                return -1;
            }
            Long peek = stack.peek();
            if (peek <= 0) {
                return (int) min;
            }
            return (int) (min+peek);
        }

        public int getMin() {
            return (int) min;
        }
    }
}

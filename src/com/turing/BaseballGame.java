package com.turing;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        // Calculate the sum of all scores in the record
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        String[] ops = {"5", "2", "C", "D", "+"};
        int result = game.calPoints(ops);
        System.out.println("Sum of all scores: " + result);
    }
}

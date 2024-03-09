package ru.itis.example_reflection_api;

import java.util.Stack;

public class Sandbox {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushedIndex = 0;
        int poppedIndex = 0;
        int totalCount = 0;
        while(totalCount <= pushed.length + popped.length) {
            if (stack.isEmpty()) {
                if (pushedIndex >= pushed.length) {
                    return false;
                }
                int pushValue = pushed[pushedIndex];
                System.out.println("PUSH " + pushValue);
                stack.push(pushValue);
                totalCount++;
                continue;
            }
            int current = stack.lastElement();
            int popValue = popped[poppedIndex];
            if(current == popValue) {
                int poppedValue = stack.pop();
                System.out.println("POP " + poppedValue);
                poppedIndex++;
            } else {
                if (pushedIndex >= pushed.length) {
                     return false;
                }
                int pushValue = pushed[pushedIndex];
                System.out.println("PUSH " + pushValue);
                stack.push(pushValue);
                pushedIndex++;
            }
            totalCount++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, popped));
    }
}

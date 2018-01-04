package com.freeraven.unsorted;

import java.util.Stack;

/**
 * Created by zvlades on 5/19/17.
 */
public class BalancedBracesCheck {
    static String[] braces(String[] values)
    {
        String[] answer = new String[values.length];
        for (int i = 0; i < values.length; i++)
            if (isValid(values[i]))
                answer[i] = "YES";
            else
                answer[i] = "NO";
        return answer;
    }

    static boolean isValid(String bracesExp)
    {
        Stack<Character> stack = new Stack<>();
        int numberOfBraces = bracesExp.length();
        for (int i = 0; i < numberOfBraces; i++)
        {
            char a = bracesExp.charAt(i);
            if (a=='(' || a=='[' || a=='{') {
                stack.push(a);
                continue;
            }

            if (a == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if (top == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }

            if (a == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if (top == '[') {
                    stack.pop();
                } else {
                    return false;
                }

            }

            if (a == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                if (top == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

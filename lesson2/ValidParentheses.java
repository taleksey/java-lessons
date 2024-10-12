package lesson2;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println();
        String example1;
        example1 = "()";
        Boolean result = ValidParentheses.isValid(example1);
        System.out.println(result);

        String example2;
        example2 = "(]";
        result = ValidParentheses.isValid(example2);
        System.out.println(result);

        String example3;
        example3 = "([])";
        result = ValidParentheses.isValid(example3);
        System.out.println(result);

        String example4;
        example4 = "()[]{}";
        result = ValidParentheses.isValid(example4);
        System.out.println(result);
    }
    public static boolean isValid(String s) {

        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (char symbol : s.toCharArray()) {
            if ( symbol == '(' || symbol == '{' || symbol == '[') {
                stack.push(symbol);
            } else if (symbol == ')' || symbol == '}' || symbol == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                Character openElement =  stack.pop();
                //Check if it's  correct pairs of parentheses.
                if (openElement == '(' && symbol != ')') {
                    return false;
                }

                if (openElement == '{' && symbol != '}') {
                    return false;
                }

                if (openElement == '[' && symbol != ']') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

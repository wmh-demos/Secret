package me.wayne.leetcodetop100.string;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class LC20_IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                Character top = stack.peek();
                boolean match = isMatch(top, ch);
                if (match) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(Character one, Character another) {
        if (one.equals('(') && another.equals(')')) {
            return true;
        } else if (one.equals('{') && another.equals('}')) {
            return true;
        } else if (one.equals('[') && another.equals(']')) {
            return true;
        } else {
            return false;
        }
    }
}

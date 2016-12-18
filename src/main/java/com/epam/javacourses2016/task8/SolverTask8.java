package com.epam.javacourses2016.task8;

import java.util.Stack;

/**
 * Задана строка, возможно содержащая символы '(', ')', '[', ']', '{', '}'.
 * Проверить правильность расстановки скобок.
 * При реализации использовать стек.
 */
public class SolverTask8 {

    /**
     * Проверяет правильность расстановки скобок.
     * Правильная расстановка:
     * 1) Каждой открывающей скобке соответствует закрывающая того же типа.
     * 2) Нет пересечения областей, обрамленных скобками.
     *
     * @param string Анализируемая строка.
     * @return true - скобки расставлены верно, иначе - false.
     */
    public boolean isNormalBrackets(String string) {
        Stack<Character> stack = new Stack<>();
        char tmp;
        for (char c : string.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }

            if ((c == ']' || c == '}' || c == ')') && (stack.empty())) {
                return false;
            }

            if (c == ']') {
                tmp = stack.pop();
                if (tmp != '[') {
                    return false;
                }
            }

            if (c == '}') {
                tmp = stack.pop();
                if (tmp != '{') {
                    return false;
                }
            }

            if (c == ')') {
                tmp = stack.pop();
                if (tmp != '(') {
                    return false;
                }
            }
            System.out.println("char:" + c + " stack: " + stack);
        }
        return true;
    }
}

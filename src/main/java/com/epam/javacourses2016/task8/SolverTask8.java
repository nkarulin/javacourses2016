package com.epam.javacourses2016.task8;

import java.util.Stack;
import java.util.stream.Collector;

/**
 * Задана строка, возможно содержащая символы '(', ')', '[', ']', '{', '}'.
 * Проверить правильность расстановки скобок.
 * При реализации использовать стек.
 */
public class SolverTask8 {
    private final static char[] OPENING = {'(', '[', '{'};
    private final static char[] CLOSING = {')', ']', '}'};

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
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < OPENING.length; j++) {
                if (string.charAt(i) == OPENING[j]) {
                    stack.push(OPENING[j]);
                } else {
                    if (string.charAt(i) == CLOSING[j]) {
                        if (!stack.empty() && stack.peek() != OPENING[j]) {
                            if (!stack.pop().equals(OPENING[j])) {
                                return false;
                            }
                        } else {
                            if (!stack.empty()) stack.pop();
                        }
                    }
                }
            }
        }
        return stack.empty();
    }
}

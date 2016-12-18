package com.epam.javacourses2016.task8;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Stack<String> stack = new Stack<>();
        Pattern pattern = Pattern.compile("[\\(\\)\\{\\}\\[\\]]");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String current = matcher.group();
            if ("({[".contains(current)) {
                stack.push(current);
            } else {
                if (!stack.isEmpty() && checkPairs(current,stack.peek())) {
                    stack.pop();
                } else return false;
            }
        }

        return true;
    }

    public boolean checkPairs(String first, String second) {
        return (")".equals(first) && "(".equals(second) ||
                "]".equals(first) && "[".equals(second) ||
                "}".equals(first) && "{".equals(second));
    }
}

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
        Pattern p = Pattern.compile("[\\(\\)\\{\\}\\[\\]]");
        Matcher m = p.matcher(string);

        while (m.find()) {
            String current = m.group();
            if ("({[".contains(current)) {
                stack.push(current);
            } else {
                if ((!stack.isEmpty()) && (")".equals(current) && "(".equals(stack.peek()) ||
                        "]".equals(current) && "[".equals(stack.peek()) ||
                        "}".equals(current) && "{".equals(stack.peek()))) {
                    stack.pop();
                } else return false;
            }
        }

        return true;
    }

}
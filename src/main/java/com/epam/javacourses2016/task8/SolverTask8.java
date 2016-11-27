package com.epam.javacourses2016.task8;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Задана строка, возможно содержащая символы '(', ')', '[', ']', '{', '}'.
 * Проверить правильность расстановки скобок.
 * При реализации использовать стек.
 */
public class SolverTask8 {


    private boolean checkString(Deque<Integer> stack, int comp) {
        if (stack.size() > 0) {
           int last = stack.pop();
            if (last != comp)
                return false;
            else return true;
        } else return false;
    }
    /**
     * Проверяет правильность расстановки скобок.
     * Правильная расстановка:
     *      1) Каждой открывающей скобке соответствует закрывающая того же типа.
     *      2) Нет пересечения областей, обрамленных скобками.
     * @param string Анализируемая строка.
     * @return true - скобки расставлены верно, иначе - false.
     */
    public boolean isNormalBrackets(String string) {

        Deque<Integer> stack = new ArrayDeque<>();

        int circle = 1;
        int quad = 2;
        int fig = 3;
        int last = 0;
        boolean result = true;
        for(int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            switch (c) {
                case '(': stack.push(circle); last = circle; break;
                case '[': stack.push(quad); last = quad; break;
                case '{': stack.push(fig); last = fig; break;
                case ')': result = checkString(stack, circle); if (!result) return false; break;
                case ']': result = checkString(stack, quad); if (!result) return  false; break;
                case '}': result = checkString(stack, fig); if (!result) return false; break;
            }
        }
        return stack.size() < 1;
    }
}

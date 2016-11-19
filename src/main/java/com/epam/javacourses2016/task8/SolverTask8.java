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
    private Stack<Character> stack = new Stack<Character>();

    public boolean isNormalBrackets(String string) {
        for (char ch : string.toCharArray()) {
            if (isClosingBracket(ch) && stack.isEmpty()) {
                return false;
            }else if (isOpeningBracket(ch)) {
                stack.push(ch);
            }else if (isClosingBracket(ch)) {
                if (isPair(stack.peek(), ch)) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpeningBracket(char bracket) {
        return "({[".indexOf(bracket) != -1;
    }

    private boolean isClosingBracket(char bracket) {
        return ")}]".indexOf(bracket) != -1;
    }

    private boolean isPair(char open, char close) {
        return open == '(' && close == ')'|| open == '{' && close == '}' || open == '[' && close == ']' ;
    }

}

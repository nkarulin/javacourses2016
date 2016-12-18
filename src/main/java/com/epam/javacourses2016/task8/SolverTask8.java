package com.epam.javacourses2016.task8;

import java.util.ArrayList;
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
     *      1) Каждой открывающей скобке соответствует закрывающая того же типа.
     *      2) Нет пересечения областей, обрамленных скобками.
     * @param string Анализируемая строка.
     * @return true - скобки расставлены верно, иначе - false.
     */
    public boolean isNormalBrackets(String string) {
        Stack<String> brackets = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder(string);
        boolean error = false;
        for (int i = 0; i < stringBuilder.length(); ++i) {
            String sym = String.valueOf(stringBuilder.charAt(i));
            if ("([{}])".contains(sym)){
                if ("([{".contains(sym)) {
                    brackets.push(sym);
                } else if (")]}".contains(sym) && brackets.isEmpty()) {
                    error = true;
                } else if (!compareBrackets(brackets.peek(), sym)) {
                    error = true;
                } else {
                    brackets.pop();
                }

            }
        }

        if (error) {
            return false;
        } else if (!brackets.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    private boolean compareBrackets(String sym1, String sym2){
        if (("(".equals(sym1) && ")".equals(sym2)) || ("[".equals(sym1) && "]".equals(sym2)) || ("{".equals(sym1) && "}".equals(sym2))){
            return true;
        } else {
            return false;
        }
    }
}

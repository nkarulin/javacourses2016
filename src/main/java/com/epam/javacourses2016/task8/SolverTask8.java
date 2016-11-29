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
     *      1) Каждой открывающей скобке соответствует закрывающая того же типа.
     *      2) Нет пересечения областей, обрамленных скобками.
     * @param string Анализируемая строка.
     * @return true - скобки расставлены верно, иначе - false.
     */
    public boolean isNormalBrackets(String string) {
        Stack<Character> characters = new Stack<>();
        char[] symbols = string.toCharArray();
        for(char c : symbols) {
            if(c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}')
                characters.add(c);
        }
        for (int i = 0; i < characters.size()-1; i++)
        {
            if ((characters.get(i) == '(' && characters.get(i+1) == ')') || (characters.get(i) == '[' && characters.get(i+1) == ']') || (characters.get(i) == '{' && characters.get(i+1) == '}'))
            {
                characters.remove(i);
                characters.remove(i);
                i = -1;
            }
        }
        return characters.size() == 0;
    }

}

package com.epam.javacourses2016.task8;

import java.util.*;

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
        Deque<Character> characters = new ArrayDeque<>();
        char[] symbols = string.toCharArray();
        for(char c : symbols) {
            if(c == '(' || c ==  ')' || c ==  '[' || c ==  ']' || c ==  '{' || c ==   '}' )
                characters.addLast(c);
        }
        int count = 0;
        int beginSize = characters.size();
        for(;;) {
            Character a = characters.removeFirst();
            Character b = characters.removeFirst();
            if (! ( ( a == '(' && b == ')')
                    || (a == '[' && b == ']')
                    || (a == '{' && b == '}')  ) )
            {
                characters.addFirst(b);
                characters.addLast(a);
            }
            count++;
            if(count == beginSize - 1) {
                if(characters.size() == 0) {
                    return true;
                }
                else if(beginSize > characters.size()) {
                    beginSize = characters.size();
                    count = 0;
                } else if(beginSize == characters.size())
                    return false;
            } else if(characters.size() == 0) {
                return true;
            }
        }
    }

}

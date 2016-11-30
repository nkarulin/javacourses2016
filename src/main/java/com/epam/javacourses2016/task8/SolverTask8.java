package com.epam.javacourses2016.task8;

import java.text.StringCharacterIterator;
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
        final char OPEN_SQUARE_BRACKET = '[';
        final char CLOSED_SQUARE_BRACKET = ']';

        final char OPEN_CURLY_BRACKET = '{';
        final char CLOSED_CURLY_BRACKET = '}';

        final char OPEN_PARENTHESIS = '(';
        final char CLOSED_PARENTHESIS = ')';

        final Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(OPEN_SQUARE_BRACKET, CLOSED_SQUARE_BRACKET);
        bracketMap.put(OPEN_CURLY_BRACKET, CLOSED_CURLY_BRACKET);
        bracketMap.put(OPEN_PARENTHESIS, CLOSED_PARENTHESIS);

        Deque<Character> bracketStack = new LinkedList<>();

        StringCharacterIterator iterator = new StringCharacterIterator(string);
        boolean hasMatchingBracket = true;
        for (char ch = iterator.current(); ch != StringCharacterIterator.DONE && hasMatchingBracket; ch = iterator.next()) {

            if (bracketMap.keySet().contains(ch)) {
                bracketStack.addFirst(ch);
            } else if (bracketMap.values().contains(ch)) {
                if (!bracketStack.isEmpty()) {
                    hasMatchingBracket = !bracketMap.isEmpty() && ch == bracketMap.get(bracketStack.removeFirst());
                }
            }

        }
        return hasMatchingBracket && bracketStack.isEmpty();
    }
}

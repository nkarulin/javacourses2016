package com.epam.javacourses2016.task8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
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
        Stack<Character> characters = new Stack<>();

        char[] openTypes = new char[]{'(', '[', '{'};
        char[] closingTypes = new char[]{')', ']', '}'};

        boolean rightSequence = true;
        for (char ch : string.toCharArray()) {
            for(char openCh : openTypes) {
                if (ch == openCh) {
                    characters.push(ch);
                }
            }

            for (char closeCh : closingTypes) {
                if (ch == closeCh) {
                    if (characters.size() == 0) {
                        rightSequence = false;
                        return rightSequence;
                    }

                    char previousCh = characters.peek();

                    int openIndex = 0;
                    int closeIndex = 0;

                    for (int i = 0; i < openTypes.length; i++) {
                        if (previousCh == openTypes[i]) {
                            openIndex = i;
                        }
                        if (closeCh == closingTypes[i]) {
                            closeIndex = i;
                        }
                    }

                    if (openIndex == closeIndex) {
                        characters.pop();
                    } else {
                        characters.push(ch);
                    }
                }
            }
        }

        if (!characters.empty()) {
            rightSequence = false;
        }
        return rightSequence;
    }
}

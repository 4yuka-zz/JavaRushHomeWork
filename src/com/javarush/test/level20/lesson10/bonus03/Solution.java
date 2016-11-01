package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "rj");
        for (Word word : list)
            System.out.println(word);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        int dimX = crossword[0].length;
        int dimY = crossword.length;
        for (int n = 0; n < words.length; n++) {
            int len = words[n].length();
            if ((len < dimX || len < dimY) && len > 0)
            {
                int code = words[n].charAt(0);
                for (int y = 0; y < dimY; y++)
                {
                    for (int x = 0; x < dimX; x++)
                    {
                        if (code == crossword[y][x] && len > 1)
                        {
                            int i = x, j = y, k = 0, code1;
                            while (i >= 0 && j >= 0 && k < len) {
                                code1 = words[n].charAt(k);
                                if (code1 != crossword[j][i])
                                    i = -2;
                                k++;
                                i--;
                                j--;
                            }
                            if (i >= -1 && j >= -1 && k == len)
                            {
                                Word word1 = new Word(words[n]);
                                word1.setStartPoint(x,y);
                                word1.setEndPoint(i+1, j+1);
                                list.add(word1);
                            }
                            i = x; j = y; k = 0;
                            while (i < dimX && j >= 0 && k < len) {
                                code1 = words[n].charAt(k);
                                if (code1 != crossword[j][i])
                                    j = -2;
                                k++;
                                i++;
                                j--;
                            }
                            if (i <= dimX && j >= -1 && k == len)
                            {
                                Word word1 = new Word(words[n]);
                                word1.setStartPoint(x,y);
                                word1.setEndPoint(i-1, j+1);
                                list.add(word1);
                            }
                            i = x; j = y; k = 0;
                            while (i >= 0 && j < dimY && k < len) {
                                code1 = words[n].charAt(k);
                                if (code1 != crossword[j][i])
                                    i = -2;
                                k++;
                                i--;
                                j++;
                            }
                            if (i >= -1 && j <= dimY && k == len)
                            {
                                Word word1 = new Word(words[n]);
                                word1.setStartPoint(x,y);
                                word1.setEndPoint(i+1, j-1);
                                list.add(word1);
                            }
                            i = x; j = y; k = 0;
                            while (i < dimX && j < dimY && k < len) {
                                code1 = words[n].charAt(k);
                                if (code1 != crossword[j][i])
                                    i = dimX;
                                k++;
                                i++;
                                j++;
                            }
                            if (i <= dimX && k == len)
                            {
                                Word word1 = new Word(words[n]);
                                word1.setStartPoint(x,y);
                                word1.setEndPoint(i-1, j-1);
                                list.add(word1);
                            }
                            i = x; j = y; k = 0;
                            while (j >= 0 && k < len) {
                                code1 = words[n].charAt(k);
                                if (code1 != crossword[j][i])
                                    j = -2;
                                k++;
                                j--;
                            }
                            if (j >= -1 && k == len)
                            {
                                Word word1 = new Word(words[n]);
                                word1.setStartPoint(x,y);
                                word1.setEndPoint(i, j+1);
                                list.add(word1);
                            }
                            i = x; j = y; k = 0;
                            while (j < dimY && k < len) {
                                code1 = words[n].charAt(k);
                                if (code1 != crossword[j][i])
                                    j = dimY;
                                k++;
                                j++;
                            }
                            if (j <= dimY && k == len)
                            {
                                Word word1 = new Word(words[n]);
                                word1.setStartPoint(x,y);
                                word1.setEndPoint(i, j-1);
                                list.add(word1);
                            }
                            i = x; j = y; k = 0;
                            while (i < dimX && k < len) {
                                code1 = words[n].charAt(k);
                                if (code1 != crossword[j][i])
                                    i = dimX;
                                k++;
                                i++;
                            }
                            if (i <= dimX && k == len)
                            {
                                Word word1 = new Word(words[n]);
                                word1.setStartPoint(x,y);
                                word1.setEndPoint(i-1, j);
                                list.add(word1);
                            }
                            i = x; j = y; k = 0;
                            while (i >= 0 && k < len) {
                                code1 = words[n].charAt(k);
                                if (code1 != crossword[j][i])
                                    i = -2;
                                k++;
                                i--;
                            }
                            if (i >= -1 && k == len)
                            {
                                Word word1 = new Word(words[n]);
                                word1.setStartPoint(x,y);
                                word1.setEndPoint(i+1, j);
                                list.add(word1);
                            }
                        }
                        else if (code == crossword[y][x] && len == 1) {
                            Word word1 = new Word(words[n]);
                            word1.setStartPoint(x,y);
                            word1.setEndPoint(x,y);
                            list.add(word1);
                        }
                    }
                }
            }
        }
        return list;
    }

//    public static Word findWord(int[][] crossword, String word, int x, int y) {
//        int len = word.length();
//
//        return word1;
//    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

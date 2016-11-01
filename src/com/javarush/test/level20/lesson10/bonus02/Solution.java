package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
        byte[][] a1 = new byte[][]{
                {1}
        };
        count = getRectangleCount(a1);
        System.out.println("count = " + count + ". Должно быть 1");
        byte[][] a2 = new byte[][]{
                {0},
        };
        count = getRectangleCount(a2);
        System.out.println("count = " + count + ". Должно быть 0");
        byte[][] a3 = new byte[][]{
                {1, 1},
                {1, 1},
        };
        count = getRectangleCount(a3);
        System.out.println("count = " + count + ". Должно быть 1");
        byte[][] a4 = new byte[][]{
                {0, 1},
                {0, 0},
        };
        count = getRectangleCount(a4);
        System.out.println("count = " + count + ". Должно быть 1");
        byte[][] a5 = new byte[][]{
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 1, 0, 1}
        };
        count = getRectangleCount(a5);
        System.out.println("count = " + count + ". Должно быть 4");
        byte[][] a6 = new byte[][]{
                {1, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1}
        };
        count = getRectangleCount(a6);
        System.out.println("count = " + count + ". Должно быть 3");
    }

    public static int getRectangleCount(byte[][] a) {
        int size = a.length;
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (a[i][j] == 1) {
                    if (i != 0 && j != 0)
                    {
                        if (a[i - 1][j] != 1 && a[i][j - 1] != 1)
                            k++;
                    }
                    else if (i == 0 && j == 0)
                    {
                        k++;
                    }
                    else if (i == 0)
                    {
                        if (a[i][j - 1] != 1)
                            k++;
                    }
                    else if (j == 0)
                    {
                        if (a[i - 1][j] != 1)
                            k++;
                    }
                    j++;
                }
            }
        }
        return k;
    }
}

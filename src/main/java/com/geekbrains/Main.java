package com.geekbrains;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("\nЗадание 1. Меняем местами 1 и 0 в массиве");
        int[] arr1 = {1, 0, 0, 1, 0, 0, 0, 1};
        System.out.println(Arrays.toString(arr1));
        for(int i=0; i < arr1.length; i++){
            if(arr1[i] == 1){
                arr1[i] = 0;
            }else {
                arr1[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr1));

        System.out.println("\nЗадание 2. Заполняем массив числами от 1 до 100");
        int[] arr2 = new int[100];
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = i+1;
        }
        System.out.println(Arrays.toString(arr2));

        System.out.println("\nЗадание 3. Умножаем на 2 числа из массива, меньшие 6");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        for(int i = 0; i< arr3.length; i++){
            if(arr3[i]<6){
                arr3[i] = arr3[i]*2;
            }
        }
        System.out.println(Arrays.toString(arr3));

        System.out.println("\nЗадание 4. Рисуем диагонали из единиц в двумерном массиве");
        System.out.println("Введите размер будущей матрицы (целое число).");
        int userMatrix = scanner.nextInt();
        int[][] arr4 = new int[userMatrix][userMatrix];
        //рисуем первую диагональ
        for(int i=0;i< arr4.length; i++){
            for(int j=0;j< arr4.length; j++){
                if(i == j){
                    arr4[i][j] = 1;
                }else{
                    arr4[i][j] = 0;
                }
            }
        }
        //рисуем вторую диагональ
        int counter = 1;
        for(int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4.length; j++) {
                if (j == arr4.length - counter) {
                    arr4[i][j] = 1;
                    counter++;
                }
            }
        }
        //печатаем матрицу
        for(int i = 0; i< arr4.length; i++){
            for(int j = 0; j < arr4.length; j++){
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nЗадание 5. Получаем массив с заданными параметрами из метода");
        System.out.println("Введите длину массива (целое число).");
        int userLen = scanner.nextInt();
        System.out.println("Введите число, которым хотите заполнить массив.");
        int userNum = scanner.nextInt();
        arrayFromMethod(userLen, userNum);

        System.out.println("\nЗадание 6. Ищем минимальный и максимальный элементы массива");
        int[] arr6 = randomUserArray();
        Arrays.sort(arr6);
        System.out.println("Минимальный элемент массива = " + arr6[0] + ", максимальный = " + arr6[arr6.length-1]);

        System.out.println("\nЗадание 7. Ищем у массива баланс");
        int[] arr7 = randomUserArray();
        if(checkBalance(arr7)){
            System.out.println("Баланс найден!");
        } else{
            System.out.println("Баланс не найден :(");
        }

        System.out.println("\nЗадание 8. Сдвигаем элменты массива");
        int[] arr8 = randomUserArray();
        System.out.println("Введите, на сколько позиций сдвинуть элементы массива (целое число).");
        int userN = scanner.nextInt();
        arrayIndexMove(arr8, userN);
    }

    private static void arrayFromMethod(int len, int initialValue){
        int[] array = new int[len];
        for(int i = 0; i < len; i++){
            array[i] = initialValue;
        }
        System.out.println(Arrays.toString(array));
    }

    private static int[] randomUserArray(){
        System.out.println("Введите размер массива (целое число).");
        int userArrayLength = scanner.nextInt();
        int[] arr = new int[userArrayLength];
        System.out.println("Введите самое большое возможное число массива. Значения подставятся рандомно в диапазоне от 0 до этого числа.");
        int userMaxNum = scanner.nextInt();
        for (int i = 0; i<arr.length; i++){
            arr[i] = (int) (Math.random() *(userMaxNum+1));
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private static boolean checkBalance(int[] arr){
        int endCounter = arr.length-1;
        int startCounter = 0;
        int startSum = arr[startCounter];
        int endSum = arr[endCounter];
        for(int i = 0; i<arr.length-1; i++) {
            if (startSum > endSum) {
                endCounter -= 1;
                endSum = endSum + arr[endCounter];

            } else if (startSum < endSum) {
                startCounter += 1;
                startSum = startSum + arr[startCounter];

            } else {
                if (startCounter == endCounter-1) {
                    return true;
                }else{
                    startCounter += 1;
                    startSum = startSum + arr[startCounter];
                }
            }
        }
        return false;
    }

    private static void arrayIndexMove(int[]array, int n){
        if (n >= 0) {
            for (int i = n; i > 0; i--) {
                int arrayLostIndex = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length-1] = arrayLostIndex;
            }
        }else{
            for (int i = n; i < 0; i++){
                int arrayLostIndex = array[array.length - 1];
                for (int j = 0; j < array.length - 1; j++) {
                    array[array.length - j-1] = array[array.length - j-2];
                }
                array[0] = arrayLostIndex;
            }
        }
        System.out.println("Массив со сдвигом на " + n);
        System.out.println(Arrays.toString(array));
    }
}

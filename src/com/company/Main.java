package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Задать кол-во яблок от 1 и до ...
        final int APPLES_NUMBER = 100;

        List<Integer> calculationLevels = new ArrayList<>();
        calculationLevels.add(1);

        if(APPLES_NUMBER == 1) {
            showResults(calculationLevels);
            return;
        }
        int iteration = 2;
        while (iteration <= APPLES_NUMBER) {
            if (isTimeToExpandArray(calculationLevels, iteration)) {
                calculationLevels.add(0);
                for (int i = 0; i < calculationLevels.size(); i++) {
                    calculationLevels.set(i, 1);
                }
            } else {
                boolean calculateNextLevel = isNextLevelCalculationNeeded(calculationLevels, 0);
                changeValue(calculationLevels, 0);
                for (int i = 1; i < calculationLevels.size(); i++) {
                    if (calculateNextLevel) {
                        calculateNextLevel = isNextLevelCalculationNeeded(calculationLevels, i);
                        changeValue(calculationLevels, i);
                    }
                }
            }
            iteration++;
        }
        showResults(calculationLevels);
    }

    private static boolean isNextLevelCalculationNeeded(List<Integer> quantities, int i) {
        boolean bubble;
        bubble = quantities.get(i) != 1;
        return bubble;
    }

    private static void changeValue(List<Integer> list, int index) {
        if (list.get(index) == 1) {
            list.set(index, 2);
        } else {
            list.set(index, 1);
        }
    }

    public static boolean isTimeToExpandArray(List<Integer> list, int applesQuantity) {
        int arraySize = list.size();
        return Math.pow(2, (arraySize + 1)) - 1 == applesQuantity;
    }

    public static void showResults(List<Integer> list) {
        System.out.println("=== Результаты ===");
        int treeNumbers = 0;
        for (int i = 0; i < list.size(); i++) {
            treeNumbers += list.get(i);
            String times;
            if (list.get(i) == 1) {
                times = "раз";
            } else {
                times = "раза";
            }
            System.out.printf("Кол-во яблок %s - %s %s%n", (int) Math.pow(2, i), list.get(i), times);
        }
        System.out.printf("%nДеревьев - %s%n", treeNumbers);
    }
}

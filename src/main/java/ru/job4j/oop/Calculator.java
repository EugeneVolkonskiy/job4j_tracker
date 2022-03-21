package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public float divide(int c) {
        return (float) c / x;
    }

    public float sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sumResult = sum(12);
        System.out.println(sumResult);
        int multiplyResult = calculator.multiply(12);
        System.out.println(multiplyResult);
        int minusResult = minus(12);
        System.out.println(minusResult);
        float divideResult = calculator.divide(12);
        System.out.println(divideResult);
        float sumAll = calculator.sumAllOperation(12);
        System.out.println(sumAll);
    }
}

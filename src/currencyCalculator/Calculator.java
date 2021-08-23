package currencyCalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {

    private static double currencyRate;

        /* метод для конвертации валюты в рубли,
        конвертирует строку в дабл, при этом заменяет запятую на точку
         */
    private static double convertToRubles(String s) {
        return Double.parseDouble(s.replace(",", ".")) *
                currencyRate;
    }

        /* метод для конвертации рублей в доллары,
        конвертирует строку в дабл, при этом заменяет запятую на точку
        */
    private static double convertToDollars(String s) {
        return Double.parseDouble(s.replace(",", ".")) /
                currencyRate;
    }

    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();

        // в метод getCurrencyRate передаем буквенный код валюты (можно передавать любую валюту)
        currencyRate = parser.getCurrencyRate("USD");

        // создал переменную для округления double до 2х знаков после запятой
        DecimalFormat df = new DecimalFormat("#.##");

        // приветственное сообщение с актуальным курсом валюты
        System.out.println("Актуальный курс обмена валюты: " + df.format(currencyRate));

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // инициализируем массив из пользовательского ввода, в метод split передаем разделители
        String[] exchange = input.split("[($рp) ]+");

        if (exchange.length == 2) {
            switch (exchange[0]) {
                case "toRubles" -> System.out.println(df.format(convertToRubles(exchange[1])) + "р");
                case "toDollars" -> System.out.println("$" + df.format(convertToDollars(exchange[1])));
            }
        } else if (exchange[2].equals("+")) {
            switch (exchange[3]) {
                case "toRubles" -> System.out.println(
                        df.format(Double.parseDouble(exchange[1].replace(",", ".")) +
                                convertToRubles(exchange[4])) + "р");
                case "toDollars" -> System.out.println("$" +
                        df.format(Double.parseDouble(exchange[1].replace(",", ".")) +
                                convertToDollars(exchange[4])));
            }

            // с вычитанием не совсем было понятно из задания, я сделал проверку на то,
            // что уменьшаемое должно быть больше вычитаемого, чтобы получить положительное число после действия,
            // всегда можно убрать этот функционал, если что
        } else if (exchange[2].equals("-") &&
                Double.parseDouble(exchange[1].replace(",", ".")) > convertToRubles(exchange[4]) &&
                Double.parseDouble(exchange[1].replace(",", ".")) > convertToDollars(exchange[4])) {
            switch (exchange[3]) {
                case "toRubles" -> System.out.println(
                        df.format(Double.parseDouble(exchange[1].replace(",", ".")) -
                                convertToRubles(exchange[4])) + "р");
                case "toDollars" -> System.out.println("$" +
                        df.format(Double.parseDouble(exchange[1].replace(",", ".")) -
                                convertToDollars(exchange[4])));
            }
        } else {
            System.out.println("Отрицательное значение");
        }
    }
}
package HW_03;

public class Main {
    public static void main(String[] args) {
        // Пример использования методов калькулятора
        System.out.println("Сумма: " + Calculator.sum(5, 3));
        System.out.println("Произведение: " + Calculator.multiply(5, 3));
        System.out.println("Частное: " + Calculator.divide(5.0, 3.0));
        System.out.println("Разность: " + Calculator.subtract(5, 3));

        // Пример использования метода сравнения массивов
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};
        Integer[] array3 = {1, 2, 4};
        System.out.println("Массивы array1 и array2 одинаковы: " + Calculator.compareArrays(array1, array2));
        System.out.println("Массивы array1 и array3 одинаковы: " + Calculator.compareArrays(array1, array3));

        // Пример использования класса Pair
        Pair<String, Integer> pair = new Pair<>("Ключ", 123);
        System.out.println("Первый элемент пары: " + pair.getFirst());
        System.out.println("Второй элемент пары: " + pair.getSecond());
        System.out.println("Пара: " + pair);
    }
}


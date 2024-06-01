import java.util.Scanner;

public class TestGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minNumber = 1;
        int maxNumber = 100;
        int secretNumber = (int) (Math.random() * (maxNumber - minNumber + 1)) + minNumber;//Делаем явное преобразование
        int attempts = 0;
        int bestAttempts = Integer.MAX_VALUE; //Оставил макс значение для чистоты кода, чтобы гарантировать результат

        System.out.println("Добро пожаловать в игру \"Угадай число!\"");
        System.out.println("Компьютер загадал число от " + minNumber + " до " + maxNumber);

        while (true) {
            System.out.print("Введите ваше число (или 'result' для вывода результатов): ");
            String userInput = scanner.next();

            if (userInput.equalsIgnoreCase("result")) {
                System.out.println("Текущее количество попыток: " + attempts);
                System.out.println("Лучший результат: " + bestAttempts + " попыток.");
            } else if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Спасибо за игру!");
                break;
            } else if (userInput.matches("\\d+")) {
                int userGuess = Integer.parseInt(userInput);
                if (userGuess >= minNumber && userGuess <= maxNumber) {
                    attempts++;

                    if (userGuess == secretNumber) {
                        System.out.println("Поздравляю! Вы угадали число " + secretNumber + " за " + attempts + " попыток.");
                        if (attempts < bestAttempts) {
                            bestAttempts = attempts; //Опять же не хотел усложнять код новыми строками и переменными
                            System.out.println("Это ваш лучший результат!");
                        }
                        break;
                    } else if (userGuess < secretNumber) {
                        System.out.println("Я сам в шоке, но загаданное число больше, брат.");
                    } else {
                        System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат.");
                    }
                } else {
                    System.out.println("Пожалуйста, введите число от " + minNumber + " до " + maxNumber + ".");
                }
            } else {
                System.out.println("Пожалуйста, введите корректное целое число или команду 'result'.");
            }
        }
    }
}

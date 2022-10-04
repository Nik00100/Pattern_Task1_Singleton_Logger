import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите размер списка:");
            int length = scanner.nextInt();
            System.out.println("Введите верхнюю границу для значений:");
            int maxValue = scanner.nextInt();
            logger.log("Создаём и наполняем список");

            List<Integer> source = new ArrayList<>();
            for (int i=0; i<length; i++) {
                source.add(new Random().nextInt(maxValue));
            }
            System.out.println("Вот случайный список: " + source.toString());

            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.println("Введите порог для фильтра:");
            int treshold = scanner.nextInt();
            Filter filter = new Filter(treshold);
            List<Integer> result = filter.filterOut(source);
            logger.log("Выводим результат на экран");
            System.out.println("Отфильтрованный список: " + result.toString());
            logger.log("Завершаем программу");
        }
    }
}
import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "textfile.txt";

    public static void main(String[] args) {
        showMenu();
    }


    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВиберіть дію :");
            System.out.println("1. Записати в файл");
            System.out.println("2. Прочитати файл");
            System.out.println("3. Вихід");
            System.out.print("Ваш вибір: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Помилка вводу ! Введите число.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {
                writeToFile();
            } else if (choice == 2) {
                readFromFile();
            } else if (choice == 3) {
                System.out.println("Вихід із програми.");
                break;
            } else {
                System.out.println("Некоректний ввід! Спробуйте ще раз");
            }
        }
        scanner.close();
    }

    public static void writeToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть строку для запису в файл:");
        String input = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(input + "\n");
            System.out.println("Запис успішно додано.");
        } catch (IOException e) {
            System.out.println("Помилка запису в файл!");
        }
    }

    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nВміст файла:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайден! Запишить данні спочатку");
        } catch (IOException e) {
            System.out.println("Помилка читання файлу!");
        }
    }
}

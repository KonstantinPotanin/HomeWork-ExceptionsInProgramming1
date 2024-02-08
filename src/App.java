import java.util.Scanner;

/**
 * Класс, для запуска программы
 */
public class App {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные через пробел (Фамилия, Имя, Отчество, дата рождения, номер телефона и пол):");
            String input = scanner.nextLine().trim();

            UserInputParser userInputParser = new UserInputParser();
            UserValidator userValidator = new UserValidator();
            UserWriter userWriter = new UserWriter();

            User user = userInputParser.parseInput(input);
            userValidator.validateUser(user);
            userWriter.writeUserToFile(user);

            System.out.println("Данные успешно записаны в файл.");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

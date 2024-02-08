import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс, который отвечает за запись данных пользователя в файл
 */
public class UserWriter {
    public void writeUserToFile(User user) throws IOException {
        try (FileWriter fileWriter = new FileWriter(user.getLastName() + ".txt", true)) {
            fileWriter.write(user.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }
    }
}

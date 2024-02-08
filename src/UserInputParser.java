import java.time.LocalDate;

/**
 * Класс, который отвечает за парсинг введенных пользователем данных
 */
public class UserInputParser {
    public User parseInput(String input) {
        String[] userData = input.split(" ");
        if (userData.length < 6) {
            throw new IllegalArgumentException("Введено меньше данных чем требуется");
        } else if (userData.length > 6) {
            throw new IllegalArgumentException("Введено больше данных чем требуется");
        }
        String lastName = userData[0];
        String firstName = userData[1];
        String middleName = userData[2];
        LocalDate birthDate = parseBirthDate(userData[3]);
        long phoneNumber = parsePhoneNumber(userData[4]);
        char gender = parseGender(userData[5]);
        return new User(lastName, firstName, middleName, birthDate, phoneNumber, gender);
    }

    private LocalDate parseBirthDate(String dateString) {
        LocalDate birthDate = LocalDate.parse(dateString, java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        if (!dateString.equals(birthDate.format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")))) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }

        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Дата рождения не может быть в будущем времени");
        }

        if (birthDate.getYear() < 1900) {
            throw new IllegalArgumentException("Кажется Вы накинули себе пару лишних лет");
        }

        return birthDate;
    }

    private long parsePhoneNumber(String phoneNumber) {
        try {
            return Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Недопустимые символы в номере телефона " + phoneNumber);
        }
    }

    private char parseGender(String gender) {
        if (gender.length() != 1 || (gender.charAt(0) != 'm' && gender.charAt(0) != 'f')) {
            throw new IllegalArgumentException("Для корректного ввода пола необходимо ввести \"m\" либо \"f\"");
        }
        return gender.charAt(0);
    }
}

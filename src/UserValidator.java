/**
 * Класс, который отвечает за валидацию данных пользователя
 */
public class UserValidator {
    public void validateUser(User user) {
        validateName(user.getLastName());
        validateName(user.getFirstName());
        validateName(user.getMiddleName());
        validatePhoneNumber(user.getPhoneNumber());
    }

    private void validateName(String name) {
        if (!name.matches("[a-zA-Zа-яА-Я]+")) {
            throw new IllegalArgumentException("Недопустимые символы в имени: " + name);
        }
    }

    private void validatePhoneNumber(long phoneNumber) {
        String phoneNumberString = String.valueOf(phoneNumber);
        if (!phoneNumberString.matches("\\d{1,11}")) {
            throw new IllegalArgumentException("Превышено количество цифр в номере телефона");
        }
    }
}

# Проект "Управление данными пользователя"

Простое приложение на Java, которое принимает данные пользователя (ФИО, дату рождения, номер телефона и пол) через консольный ввод, выполняет их парсинг и записывает в файл.

## Использование

1. Запустите приложение, запустив класс `App`.
2. Введите данные пользователя в следующем формате через пробел:
    ```
    Фамилия Имя Отчество Дата рождения Номер телефона Пол
    ```
   Например: Иванов Иван Иванович 01.01.1990 1234567890 m
3. Данные будут записаны в файл с именем, соответствующим фамилии пользователя (например, `Иванов.txt`).

## Требования к формату ввода

- Фамилия, имя и отчество должны содержать только буквы.
- Дата рождения должна быть в формате `dd.mm.yyyy`.
- Номер телефона должен содержать от 1 до 11 цифр.
- Пол должен быть указан как `m` (мужской) или `f` (женский).

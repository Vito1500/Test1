Automation Tests

Автоматизированные UI-тесты страницы логина сайта
https://www.saucedemo.com/

Проект демонстрирует автоматизацию тестирования авторизации с использованием:

- Java 17
- Selenium WebDriver
- JUnit 5
- Allure Reports
- Maven
- Page Object Model (POM)

Тесты независимы друг от друга и покрывают основные сценарии логина.

Реализовано 5 тестов:

1. Успешный логин
2. Логин с неверным паролем
3. Логин заблокированного пользователя
4. Логин с пустыми полями
5. Логин пользователем performance_glitch_user
(проверка корректного перехода с возможной задержкой)

Архитектура проекта:
Используется Page Object Model (POM):
src;
 test;
    java;
      pages        // Page Objects;
      tests        // JUnit тесты;
      utils        // WebDriver setup;

Запуск тестов:

Тесты запускаются через IntelliJ IDEA с использованием встроенного Maven (Bundled Maven):

1. Открыть проект в IntelliJ IDEA
2. Убедиться, что выбран JDK 17
3. Открыть окно Maven
4. Запустить:   Lifecycle → test

Allure отчётность:

После запуска тестов:

1. Убедиться, что появилась папка: target/allure-results

2. В окне Maven выполнить: Plugins → allure → allure:serve

3. Ознакомиться с отчётом по пройденным тестам


Git workflow:

master — основная ветка;
dev — рабочая ветка;

Разработка велась в dev;
Создан Pull Request из dev → master;

Файлы отчётов (target, allure-results, allure-report)
исключены через .gitignore

Репозиторий:
https://github.com/Vito1500/Test1
     

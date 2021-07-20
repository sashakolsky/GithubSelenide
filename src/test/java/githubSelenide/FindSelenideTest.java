package githubSelenide;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest {

    @Test
    void shouldFindSelenideRepository() {

        // Arrange  ->  Given   (open page)             REQUIRED
        // Act      ->  When    (button click)          REQUIRED
        //-----------------------------------------//   OPTIONAL
        // Assert   ->  Then    (intermediate check)
        // Act      ->  When    (another button click)
        // Act      ->  When    (another button click)
        //-----------------------------------------//   OPTIONAL
        // Assert   ->  Then    (something happened)    REQUIRED

        // Базовые шаги в тесте:

        // Открыть страницу Github
        open("https://github.com/");
        // Ввести Selenide в строку поиска, нажать enter
        $("[name=q]").val("Selenide").pressEnter();

        // выбрать первый найденный проект из списка (кликнуть)
        $$(".repo-list div > a").first().click();

        // проверка: в заголовке встречается selenide
        Assertions.assertTrue(title().contains("selenide"));
    }
}

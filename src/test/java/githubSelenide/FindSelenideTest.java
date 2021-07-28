package githubSelenide;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
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

        // Открыть страницу Github
        open("https://github.com/");
        // Ввести Selenide в строку поиска, нажать enter
        $("[name=q]").val("Selenide").pressEnter();

        // выбрать первый найденный проект из списка (кликнуть)
        $$(".repo-list div > a").first().click();

        // проверка: в заголовке встречается selenide
        Assertions.assertTrue(title().contains("selenide"));
    }

    @Test
    void checkTopContributor() {

        open("https://github.com/selenide/selenide");

        $(".BorderGrid")
                .$(byText("Contributors"))
                .closest(".BorderGrid-cell")
                .$("li")
                .scrollIntoView(true)
                .hover();

        $$(".Popover-message")
                .findBy(visible)
                .shouldHave(text("Andrei Solntsev"));
    }

    @Test
    void checkSoftAssertionDocs() {

        // - Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions и открыть ее перейдя по ссылке.
        $("#wiki-pages-box li.wiki-more-pages-link button").click();
        $$("#wiki-pages-box li")
                .findBy(text("SoftAssertions"))
                .click();

        // - Проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body")
                .find(withText("Using JUnit5"))
                .parent().sibling(0)
                .$("pre")
                .shouldNotBe(empty);
    }
}

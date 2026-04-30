package param;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.BaseTest;
import pages.Language;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WikipediaLangEnumTest extends BaseTest {


    @EnumSource(Language.class)
    @ParameterizedTest
    @DisplayName("Википедия должна открыться в выбранном языке")
    void wikipediaShouldOpenInSelectedLanguage(Language language) {
        open("https://www.wikipedia.org/");
        $(String.format("[lang='%s']", language.code)).click();
        assertTrue(title().contains(language.expectedTitle));
        System.out.println("Язык " + language.buttonText + " — заголовок: " + language.expectedTitle);
    }
}
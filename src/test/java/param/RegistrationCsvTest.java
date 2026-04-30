package param;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Регистрация с разными доменами email (CsvSource)")
public class RegistrationCsvTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "gmail.com",
            "yandex.ru",
            "mail.ru"
    })
    void registrationShouldWorkForDifferentEmail(String domain) {
        open("https://demoqa.com/automation-practice-form");

        String firstName = "Test";
        String lastName = "User";
        String phone = "1234567890";

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + domain);
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue(phone);

        $("#submit").scrollTo().shouldBe(visible).click();

        $(".modal-title").shouldBe(visible);
        $(".modal-content").shouldBe(visible);
    }
}
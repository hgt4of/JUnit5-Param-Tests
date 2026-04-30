package param;

import org.junit.jupiter.api.DisplayName;

import com.github.javafaker.Faker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Регистрация с Faker данными и разными email")
public class RegistrationMethodTest {

    static Faker faker = new Faker();

    static Stream<Arguments> userDataProvider() {
        return Stream.of(
                Arguments.of(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        "@gmail.com",
                        faker.phoneNumber().subscriberNumber(10)
                ),
                Arguments.of(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        "@mail.ru",
                        faker.phoneNumber().subscriberNumber(10)
                ),
                Arguments.of(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        "@yandex.ru",
                        faker.phoneNumber().subscriberNumber(10)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("userDataProvider")
    void registrationShouldWorkForDifferentEmail(String firstName, String lastName, String domain, String phone) {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(firstName.toLowerCase() + "." + lastName.toLowerCase() + domain);
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue(phone);

        $("#submit").scrollTo().shouldBe(visible).click();

        $(".modal-title").shouldBe(visible);
        $(".modal-content").shouldBe(visible);
    }
}
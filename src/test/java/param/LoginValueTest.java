package param;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BaseTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Авторизация разных тестовых пользователей")
public class LoginValueTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "problem_user", "performance_glitch_user"})
    void loginShouldWorkForValidUsers(String username) {
        open("https://www.saucedemo.com");

        $("#user-name").setValue(username);
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        $(".inventory_list").shouldBe(visible);

        $("#react-burger-menu-btn").click();
        $("#logout_sidebar_link").click();
    }

    @Disabled
    @Test
    @DisplayName("Тест умер(")
    void noWorkTest() {
        System.out.println("Hello world!");
    }
}

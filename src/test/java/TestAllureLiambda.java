import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class TestAllureLiambda {
    private static final String PersonName = "Dmitro";
    private static final String PersonLastName = "Ivanov";
    private static final String PersonEmail = "ivanov@mail.com";
    private static final String PersonalGender = "Male"; //"Male" or "Female" or "Other";
    private static final String PersonalPhoneNumber = "9012223344";

    @Test
    void successSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open start Pages", () -> {
            open("https://demoqa.com/automation-practice-form");
        });
        step("Set First Name", () -> {
            $("#firstName").setValue(PersonName);
        });
        step("Set Last Name", () -> {
            $(byId("lastName")).setValue(PersonLastName);
        });
        step("Set email", () -> {
            $(byId("userEmail")).setValue(PersonEmail);
        });
        step("Set Gender", () -> {
            $(byTagAndText("Label", PersonalGender)).click();
        });
        step("Set Phonenumber", () -> {
            $(byId("userNumber")).setValue(PersonalPhoneNumber).pressEnter();
        });
        step("Test Name", () -> {
            $x("//div[@class='table-responsive']").shouldHave(Condition.text(PersonName));
        });
        step("Test Email", () -> {
            $x("//div[@class='table-responsive']").shouldHave(Condition.text(PersonEmail));
        });
        step("Test Gender", () -> {
            $x("//div[@class='table-responsive']").shouldHave(Condition.text("Male"));
        });
        step("Test PhoneNumber", () -> {
            $x("//div[@class='table-responsive']").shouldHave(Condition.text("999"));
        });//Тест специально сломан, кривой ожидаемый номер телефона. Подставить переменную или ее значение в shouldHave, чтобы тест прошел

        // $("#issue-tab").click();
    }
}

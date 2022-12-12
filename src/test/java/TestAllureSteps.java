import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class TestAllureSteps {
    @Feature("Test Steps, text for @Feature")
    @Owner("Fedoseev")
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @Test
    void successAllureStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        TestStepsForAllureSteps steps = new TestStepsForAllureSteps();
        steps.openPage();
        steps.takeSkrin();
        steps.setPersonName();
        steps.setPersonLastName();
        steps.setPersonEmail();
        steps.setPersonGender();
        steps.setPersonPhone();
        steps.takeSkrin();
        steps.testResultName();
        steps.takeSkrin();
        steps.testResultEmail();
        steps.testResultGender();
        steps.testResultPhone();

    }
}

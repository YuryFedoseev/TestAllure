import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class TestStepsForAllureSteps {
    private static final String PersonName = "Steppov";
    private static final String PersonLastName = "Ivanov";
    private static final String PersonEmail = "ivanov@mail.com";
    private static final String PersonalGender = "Male"; //"Male" or "Female" or "Other";
    private static final String PersonalPhoneNumber = "9012223344";

    @Step("Open start Pages")
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    ;

    @Attachment(value = "Take Skrinschot", type = "image/png", fileExtension = "png")
    public byte[] takeSkrin() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    ;

    @Step("Set First Name")
    public void setPersonName() {
        $("#firstName").setValue(PersonName);
    }

    ;

    @Step("Set Last Name")
    public void setPersonLastName() {
        $(byId("lastName")).setValue(PersonLastName);
    }

    ;

    @Step("Set email")
    public void setPersonEmail() {
        $(byId("userEmail")).setValue(PersonEmail);
    }

    ;

    @Step("Set Gender")
    public void setPersonGender() {
        $(byTagAndText("Label", PersonalGender)).click();
    }

    ;

    @Step("Set Phonenumber")
    public void setPersonPhone() {
        $(byId("userNumber")).setValue(PersonalPhoneNumber).pressEnter();
    }

    ;

    @Step("Test Name")
    public void testResultName() {
        $x("//div[@class='table-responsive']").shouldHave(Condition.text(PersonName));
    }

    ;

    @Step("Test Email")
    public void testResultEmail() {
        $x("//div[@class='table-responsive']").shouldHave(Condition.text(PersonEmail));
    }

    ;

    @Step("Test Gender")
    public void testResultGender() {
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Male"));
    }

    ;

    @Step("Test PhoneNumber")
    public void testResultPhone() {
        $x("//div[@class='table-responsive']").shouldHave(Condition.text(PersonEmail));
    }


}

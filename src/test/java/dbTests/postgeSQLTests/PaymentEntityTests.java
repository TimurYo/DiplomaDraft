package dbTests.postgeSQLTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static data.helpers.SQLHelper.cleanDB;
import static data.helpers.SQLHelper.getPaymentEntity;
import static data.helpers.TimeHelper.getDurationOfTimeForPaymentEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentEntityTests {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure",new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @Test
    void paymentAmountTest() {
        cleanDB();
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("25");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Timur");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Успешно")).parent().$("div.notification__content").shouldBe(Condition.visible, Duration.ofSeconds(20)).shouldHave(Condition.exactText("Операция одобрена Банком."));
        var expectedAmount = "4500000";
        var actualAmount = getPaymentEntity().getAmount();
        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void paymentTimeCreatedTest() throws ParseException {
        cleanDB();
       // Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("25");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Timur");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Успешно")).parent().$("div.notification__content").shouldBe(Condition.visible, Duration.ofSeconds(20)).shouldHave(Condition.exactText("Операция одобрена Банком."));

        long duration = getDurationOfTimeForPaymentEntity();
        assertTrue(duration <= 3000);
    }

    @Test
    void paymentStatusTestWithApprovedCard() {
        cleanDB();
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("25");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Timur");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Успешно")).parent().$("div.notification__content").shouldBe(Condition.visible, Duration.ofSeconds(20)).shouldHave(Condition.exactText("Операция одобрена Банком."));
        var expectedStatus = "APPROVED";
        var actualStatus = getPaymentEntity().getStatus();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    void paymentStatusTestWithDeclinedCard() {
        cleanDB();
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444442");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("25");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Timur");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Успешно")).parent().$("div.notification__content").shouldBe(Condition.visible, Duration.ofSeconds(20)).shouldHave(Condition.exactText("Операция одобрена Банком."));
        var expectedStatus = "DECLINED";
        var actualStatus = getPaymentEntity().getStatus();
        assertEquals(expectedStatus, actualStatus);
    }

}

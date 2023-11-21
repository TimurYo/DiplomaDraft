package apiTests;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static data.ApiBodyObject.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ApiTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure",new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void shouldReturnStatusPayApprovedCard() {
        var response = getGivenWithPayApprovedCard();
        assertTrue(response.contains("APPROVED"));
    }

    @Test
    public void shouldReturnStatusPayDeclinedCard() {
        var response = getGivenWithPayDeclinedCard();
        assertTrue(response.contains("DECLINED"));
    }

    @Test
    public void shouldReturnStatusCreditApprovedCard() {
        var response = getGivenWithCreditApprovedCard();
        assertTrue(response.contains("APPROVED"));
    }

    @Test
    public void shouldReturnStatusCreditDeclinedCard() {
        var response = getGivenWithCreditDeclinedCard();
        assertTrue(response.contains("DECLINED"));
    }


}

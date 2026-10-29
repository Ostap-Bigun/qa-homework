import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MtsPage;
import pages.PaymentPage;
import services.MtsService;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    private WebDriver driver;
    private MtsPage mtsPage;
    private PaymentPage paymentPage;
    private MtsService mtsService;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        mtsPage = new MtsPage(driver);
        paymentPage = new PaymentPage(driver);
        mtsService = new MtsService(mtsPage, paymentPage);

        mtsPage.acceptCookies();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка полей формы «Услуги связи»")
    @Description("Проверка placeholder-ов незаполненных полей формы оплаты услуг связи")
    @Feature("Онлайн-пополнение")
    @Severity(SeverityLevel.NORMAL)
    void connectionPlaceholdersTest() {
        List<String> expected = List.of(
                "Номер телефона",
                "Сумма",
                "E-mail для отправки чека"
        );

        assertEquals(expected, mtsService.getConnectionPlaceholders());
    }

    @Test
    @DisplayName("Проверка полей формы «Домашний интернет»")
    @Description("Проверка placeholder-ов незаполненных полей формы оплаты домашнего интернета")
    void internetPlaceholdersTest() {
        List<String> expected = List.of(
                "Номер абонента",
                "Сумма",
                "E-mail для отправки чека"
        );

        assertEquals(expected, mtsService.getInternetPlaceholders());
    }

    @Test
    @DisplayName("Проверка полей формы «Рассрочка»")
    @Description("Проверка placeholder-ов незаполненных полей формы оплаты рассрочки")
    void instalmentPlaceholdersTest() {
        List<String> expected = List.of(
                "Номер счета на 44",
                "Сумма",
                "E-mail для отправки чека"
        );

        assertEquals(expected, mtsService.getInstalmentPlaceholders());
    }

    @Test
    @DisplayName("Проверка полей формы «Задолженность»")
    @Description("Проверка placeholder-ов незаполненных полей формы оплаты задолженности")
    void arrearsPlaceholdersTest() {
        List<String> expected = List.of(
                "Номер счета на 2073",
                "Сумма",
                "E-mail для отправки чека"
        );

        assertEquals(expected, mtsService.getArrearsPlaceholders());
    }

    @Test
    @DisplayName("Проверка окна оплаты услуг связи")
    @Description("Проверка суммы, номера телефона, полей карты, платёжных систем и кнопки оплаты")
    @Feature("Онлайн-пополнение")
    @Severity(SeverityLevel.CRITICAL)
    void paymentWindowTest() {
        mtsService.openPaymentWindow(
                "297777777",
                "100",
                "test@test.com"
        );

        assertEquals("100.00 BYN", mtsService.getPaymentAmount());

        assertTrue(
                mtsService.getPaymentInfo().contains("375297777777")
        );

        assertEquals(
                List.of(
                        "Номер карты",
                        "ММ / ГГ",
                        "CVC",
                        "Имя и фамилия на карте"
                ),
                mtsService.getCardFieldLabels()
        );

        assertTrue(mtsService.getDisplayedPaymentIconsCount() >= 4);

        assertEquals(
                "Оплатить 100.00 BYN",
                mtsService.getPayButtonText()
        );
    }
}
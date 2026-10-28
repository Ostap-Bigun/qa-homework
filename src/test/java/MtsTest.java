import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MtsPage;
import pages.PaymentPage;
import services.MtsService;

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
    void connectionPlaceholdersTest() {
        List<String> expected = List.of(
                "Номер телефона",
                "Сумма",
                "E-mail для отправки чека"
        );

        assertEquals(expected, mtsService.getConnectionPlaceholders());
    }

    @Test
    void internetPlaceholdersTest() {
        List<String> expected = List.of(
                "Номер абонента",
                "Сумма",
                "E-mail для отправки чека"
        );

        assertEquals(expected, mtsService.getInternetPlaceholders());
    }

    @Test
    void instalmentPlaceholdersTest() {
        List<String> expected = List.of(
                "Номер счета на 44",
                "Сумма",
                "E-mail для отправки чека"
        );

        assertEquals(expected, mtsService.getInstalmentPlaceholders());
    }

    @Test
    void arrearsPlaceholdersTest() {
        List<String> expected = List.of(
                "Номер счета на 2073",
                "Сумма",
                "E-mail для отправки чека"
        );

        assertEquals(expected, mtsService.getArrearsPlaceholders());
    }

    @Test
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
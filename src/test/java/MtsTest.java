import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.mts.by/");

        WebElement cookieButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));

        cookieButton.click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void blockTitleTest() {
        String title = wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".pay__wrapper h2")))
                .getText();

        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ", title);
    }

    @Test
    void paymentLogosTest() {
        List<WebElement> logos = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.cssSelector(".pay__partners img")));

        assertEquals(5, logos.size());

        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    void detailsLinkTest() {
        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Подробнее о сервисе")));

        link.click();

        wait.until(ExpectedConditions.urlContains(
                "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));

        assertTrue(driver.getCurrentUrl().contains(
                "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    void continueButtonTest() {
        WebElement phone = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("connection-phone")));

        WebElement sum = driver.findElement(By.id("connection-sum"));
        WebElement email = driver.findElement(By.id("connection-email"));

        phone.sendKeys("297777777");
        sum.sendKeys("100");
        email.sendKeys("test@test.com");

        WebElement continueButton = driver.findElement(
                By.cssSelector("#pay-connection button[type='submit']"));

        continueButton.click();

        WebElement paymentFrame = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("iframe.payment-widget-iframe")));

        assertTrue(paymentFrame.isDisplayed());

        driver.switchTo().frame(paymentFrame);

        WebElement body = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        assertTrue(body.isDisplayed());

        driver.switchTo().defaultContent();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By amount =
            By.xpath("//span[normalize-space()='100.00 BYN']");

    private final By paymentInfo =
            By.xpath("//span[contains(text(), 'Номер:375297777777')]");

    private final By cardNumberLabel =
            By.xpath("//input[@id='cc-number']/following-sibling::label");

    private final By expirationInput =
            By.cssSelector("input[formcontrolname='expirationDate']");

    private final By cvcLabel =
            By.xpath("//input[@formcontrolname='cvc']/following-sibling::label");

    private final By holderLabel =
            By.xpath("//input[@formcontrolname='holder']/following-sibling::label");

    private final By paymentIcons =
            By.cssSelector(".cards-brands__container img");

    private final By payButton =
            By.cssSelector("button[type='submit'].colored");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getAmount() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(amount)
        ).getText().trim();
    }

    public String getPaymentInfo() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(paymentInfo)
        ).getText();
    }

    public List<String> getCardFieldLabels() {
        String cardNumber = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cardNumberLabel)
        ).getText();

        String expiration = driver.findElement(expirationInput)
                .getAttribute("placeholder");

        String cvc = driver.findElement(cvcLabel).getText();
        String holder = driver.findElement(holderLabel).getText();

        return List.of(cardNumber, expiration, cvc, holder);
    }

    public int getDisplayedPaymentIconsCount() {
        return (int) driver.findElements(paymentIcons)
                .stream()
                .filter(element -> element.isDisplayed())
                .count();
    }

    public String getPayButtonText() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(payButton)
        ).getText().replaceAll("\\s+", " ").trim();
    }
}
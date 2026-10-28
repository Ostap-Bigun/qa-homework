package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cookieButton = By.id("cookie-agree");

    private final By paymentTypeHeader =
            By.cssSelector(".select__header");

    private final By connectionPhone = By.id("connection-phone");
    private final By connectionSum = By.id("connection-sum");
    private final By connectionEmail = By.id("connection-email");

    private final By internetPhone = By.id("internet-phone");
    private final By internetSum = By.id("internet-sum");
    private final By internetEmail = By.id("internet-email");

    private final By instalmentAccount = By.id("score-instalment");
    private final By instalmentSum = By.id("instalment-sum");
    private final By instalmentEmail = By.id("instalment-email");

    private final By arrearsAccount = By.id("score-arrears");
    private final By arrearsSum = By.id("arrears-sum");
    private final By arrearsEmail = By.id("arrears-email");

    private final By continueButton =
            By.cssSelector("#pay-connection button[type='submit']");

    private final By paymentFrame =
            By.cssSelector("iframe.payment-widget-iframe");

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acceptCookies() {
        wait.until(
                ExpectedConditions.elementToBeClickable(cookieButton)
        ).click();
    }

    public void selectPaymentType(String paymentType) {
        wait.until(
                ExpectedConditions.elementToBeClickable(paymentTypeHeader)
        ).click();

        By option = By.xpath(
                "//p[contains(@class, 'select__option') and normalize-space()='" +
                        paymentType + "']"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(option)
        ).click();
    }

    public List<String> getConnectionPlaceholders() {
        return List.of(
                getPlaceholder(connectionPhone),
                getPlaceholder(connectionSum),
                getPlaceholder(connectionEmail)
        );
    }

    public List<String> getInternetPlaceholders() {
        return List.of(
                getPlaceholder(internetPhone),
                getPlaceholder(internetSum),
                getPlaceholder(internetEmail)
        );
    }

    public List<String> getInstalmentPlaceholders() {
        return List.of(
                getPlaceholder(instalmentAccount),
                getPlaceholder(instalmentSum),
                getPlaceholder(instalmentEmail)
        );
    }

    public List<String> getArrearsPlaceholders() {
        return List.of(
                getPlaceholder(arrearsAccount),
                getPlaceholder(arrearsSum),
                getPlaceholder(arrearsEmail)
        );
    }

    private String getPlaceholder(By locator) {
        return driver.findElement(locator)
                .getAttribute("placeholder");
    }

    public void fillConnectionForm(
            String phone,
            String sum,
            String email
    ) {
        driver.findElement(connectionPhone).sendKeys(phone);
        driver.findElement(connectionSum).sendKeys(sum);
        driver.findElement(connectionEmail).sendKeys(email);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void switchToPaymentFrame() {
        WebElement frame = wait.until(
                ExpectedConditions.visibilityOfElementLocated(paymentFrame)
        );

        driver.switchTo().frame(frame);
    }
}
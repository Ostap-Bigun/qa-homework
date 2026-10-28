package services;

import pages.MtsPage;
import pages.PaymentPage;

import java.util.List;

public class MtsService {

    private final MtsPage mtsPage;
    private final PaymentPage paymentPage;

    public MtsService(MtsPage mtsPage, PaymentPage paymentPage) {
        this.mtsPage = mtsPage;
        this.paymentPage = paymentPage;
    }

    public List<String> getConnectionPlaceholders() {
        mtsPage.selectPaymentType("Услуги связи");
        return mtsPage.getConnectionPlaceholders();
    }

    public List<String> getInternetPlaceholders() {
        mtsPage.selectPaymentType("Домашний интернет");
        return mtsPage.getInternetPlaceholders();
    }

    public List<String> getInstalmentPlaceholders() {
        mtsPage.selectPaymentType("Рассрочка");
        return mtsPage.getInstalmentPlaceholders();
    }

    public List<String> getArrearsPlaceholders() {
        mtsPage.selectPaymentType("Задолженность");
        return mtsPage.getArrearsPlaceholders();
    }

    public void openPaymentWindow(
            String phone,
            String sum,
            String email
    ) {
        mtsPage.selectPaymentType("Услуги связи");
        mtsPage.fillConnectionForm(phone, sum, email);
        mtsPage.clickContinue();
        mtsPage.switchToPaymentFrame();
    }

    public String getPaymentAmount() {
        return paymentPage.getAmount();
    }

    public String getPaymentInfo() {
        return paymentPage.getPaymentInfo();
    }

    public List<String> getCardFieldLabels() {
        return paymentPage.getCardFieldLabels();
    }

    public int getDisplayedPaymentIconsCount() {
        return paymentPage.getDisplayedPaymentIconsCount();
    }

    public String getPayButtonText() {
        return paymentPage.getPayButtonText();
    }
}
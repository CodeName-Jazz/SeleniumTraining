package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCategory(String category) {
        driver.findElement(By.linkText(category)).click();
    }

    public void selectProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }

    public String getProductTitle() {
        return driver.findElement(By.className("name")).getText();
    }
}
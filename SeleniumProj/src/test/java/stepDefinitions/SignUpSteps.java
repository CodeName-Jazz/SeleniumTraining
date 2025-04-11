package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ProductPage;

public class SignUpSteps {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jay\\Documents\\Practice\\ChromeWebdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Open the DemoBlaze homepage
            driver.get("https://www.demoblaze.com/index.html");
            System.out.println("Navigated to DemoBlaze homepage");

            // Scenario 1: Sign-Up Process
            HomePage homePage = new HomePage(driver);
            homePage.clickSignUp();
            Thread.sleep(2000);
            String randomUsername = "testUser" + (int) (Math.random() * 10000);
            homePage.enterUsername(randomUsername);
            homePage.enterPassword("password123");
            homePage.submitSignUpForm();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            System.out.println("Sign-up completed with username: " + randomUsername);

            // Scenario 2: Login Process
            driver.findElement(By.id("login2")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("loginusername")).sendKeys(randomUsername);
            driver.findElement(By.id("loginpassword")).sendKeys("password123");
            driver.findElement(By.xpath("//button[text()='Log in']")).click();
            Thread.sleep(2000);
            String loggedInUser = driver.findElement(By.id("nameofuser")).getText();
            System.out.println("Logged in as: " + loggedInUser);

            // Scenario 3: Browse and Select a Product
            ProductPage productPage = new ProductPage(driver);
            productPage.clickCategory("Phones");
            Thread.sleep(2000);
            productPage.selectProduct("Samsung galaxy s6");
            Thread.sleep(2000);
            String productTitle = productPage.getProductTitle();
            System.out.println("Product details page displayed for: " + productTitle);

        } finally {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
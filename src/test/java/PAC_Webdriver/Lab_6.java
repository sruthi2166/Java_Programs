package PAC_Webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Lab_6 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.meesho.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Log in with phone number
            WebElement phoneNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='tel']")));
            phoneNumberInput.sendKeys("your_phone_number"); // Replace with your phone number
            WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
            loginButton.click();

            // Add any necessary waiting for OTP if needed
            // wait.until(...); // Add here if you need to handle OTP

            // Navigate to Components tab
            WebElement componentsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Components']")));
            componentsTab.click();

            // Select Monitors
            WebElement monitorsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Monitors']")));
            monitorsLink.click();

            // Select 25 from 'Show' dropdown
            WebElement showDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='show']")));
            showDropdown.click();
            WebElement option25 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='25']")));
            option25.click();

            // Click on 'Add to cart' for the first item
            WebElement firstItemAddToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to cart')][1]")));
            firstItemAddToCartButton.click();

            // Click on 'Specification' tab
            WebElement specificationTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Specification']")));
            specificationTab.click();

            // Verify details present on the page
            // Add your verification logic here

            // Click on 'Add to Wish list' button
            WebElement addToWishlistButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to Wish List')]")));
            addToWishlistButton.click();

            // Verify success message for wishlist
            WebElement wishlistSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Success: You have added')]")));
            if (wishlistSuccessMessage.isDisplayed()) {
                System.out.println("Product successfully added to wish list.");
            }

            // Search for mobile
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search for products']")));
            searchBox.sendKeys("saree");
            searchBox.sendKeys(Keys.RETURN);

            // Click on 'Search in product descriptions' checkbox
            WebElement searchInDescriptionsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox' and @id='searchInDescriptions']")));
            searchInDescriptionsCheckbox.click();

            // Click on link 'HTC Touch HD'
            WebElement htcTouchHDLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'HTC Touch HD')]")));
            htcTouchHDLink.click();

            // Clear '1' from 'Qty' and enter '3'
            WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number']")));
            quantityInput.clear();
            quantityInput.sendKeys("3");

            // Click on 'Add to Cart' button
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to Cart')]")));
            addToCartButton.click();

            // Verify success message for adding mobile to cart
            WebElement mobileSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Success: You have added HTC Touch HD to your shopping cart!')]")));
            if (mobileSuccessMessage.isDisplayed()) {
                System.out.println("Mobile successfully added to cart.");
            }

            // Click on 'View cart' button
            WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'View cart')]")));
            viewCartButton.click();

            // Verify mobile name added to the cart
            WebElement mobileNameInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'HTC Touch HD')]")));
            if (mobileNameInCart.isDisplayed()) {
                System.out.println("Mobile name verified in the cart.");
            }

            // Click on 'Checkout' button
            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Checkout')]")));
            checkoutButton.click();

            // Click on 'My Account' dropdown
            WebElement myAccountDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='account-dropdown']")));
            myAccountDropdown.click();

            // Select 'Logout' from dropdown
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
            logoutButton.click();

            // Verify 'Account Logout' heading
            WebElement logoutHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Account Logout')]")));
            if (logoutHeading.isDisplayed()) {
                System.out.println("Successfully logged out.");
            }

            // Click on 'Continue'
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue')]")));
            continueButton.click();

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}


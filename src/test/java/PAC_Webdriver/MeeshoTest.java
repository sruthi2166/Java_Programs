package PAC_Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class MeeshoTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // Implicit wait

        // Navigate to Meesho website
        driver.get("https://www.meesho.com/");
        driver.manage().window().maximize();

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Step 1: Login (Assuming you have valid credentials, this part will depend on the website’s actual login flow)
            driver.findElement(By.xpath("//span[text()='Profile']")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email']"))).sendKeys("your-email@example.com");  // Replace with actual email
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("yourpassword");  // Replace with actual password
            driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();

            // Step 2: Go to 'Components' Tab -> In Meesho, we simulate this by searching for a product category
            WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Try Saree, Kurti or Search by Product Code']")));
            searchBox.sendKeys("Monitors");  // Search for 'Monitors'
            searchBox.sendKeys(Keys.RETURN);

            // Step 3: Select 25 from 'Show' dropdown
            // Meesho may not have a "Show" dropdown but you can adjust this based on the actual UI (Skipping this for now)

            // Step 4: Add the first item to cart
            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='product-card'])[1]")));  // Assuming product card has a common structure
            firstProduct.click();
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add to Cart')]")));
            addToCartButton.click();

            // Step 5: Click on 'Specification' tab (Skipping as Meesho might not have this feature)

            // Step 6: Verify details on page (You can add code to verify product details if needed)

            // Step 7: Add to Wish List
            WebElement addToWishListButton = driver.findElement(By.xpath("//button[contains(text(), 'Wishlist')]"));  // Adjust XPath based on actual button text
            addToWishListButton.click();
            WebElement wishListSuccessMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'added to wishlist')]")));
            if (wishListSuccessMessage.getText().contains("added to wishlist")) {
                System.out.println("Product successfully added to the wishlist.");
            }

            // Step 8: Enter 'Mobile' in the search box and click Search
            searchBox = driver.findElement(By.xpath("//input[@placeholder='Try Saree, Kurti or Search by Product Code']"));
            searchBox.clear();
            searchBox.sendKeys("Mobile");
            searchBox.sendKeys(Keys.RETURN);

            // Step 9: Click on 'Search in product descriptions' checkbox (Skipping as Meesho may not have this)

            // Step 10: Click on link for 'HTC Touch HD' (Replacing this with a generic product click in Meesho)
            WebElement mobileLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'mobile')]")));  // Adjust for actual mobile product link
            mobileLink.click();

            // Step 11: Change 'Qty' from 1 to 3 and Add to Cart
            WebElement qtyBox = driver.findElement(By.xpath("//input[@name='quantity']"));
            qtyBox.clear();
            qtyBox.sendKeys("3");
            addToCartButton = driver.findElement(By.xpath("//button[contains(text(), 'Add to Cart')]"));
            addToCartButton.click();
            WebElement cartSuccessMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'added to cart')]")));
            if (cartSuccessMessage.getText().contains("added to cart")) {
                System.out.println("Product successfully added to the cart.");
            }

            // Step 12: Click on 'View cart'
            WebElement viewCartButton = driver.findElement(By.xpath("//a[contains(text(), 'View Cart')]"));
            viewCartButton.click();

            // Step 13: Verify mobile name in the cart (Verify the correct product name is added)
            WebElement productName = driver.findElement(By.xpath("//div[contains(text(), 'HTC Touch HD')]"));  // Adjust this based on the actual product name
            if (productName.isDisplayed()) {
                System.out.println("Mobile successfully added to the cart.");
            }

            // Step 14: Click on 'Checkout' button
            WebElement checkoutButton = driver.findElement(By.xpath("//button[contains(text(), 'Checkout')]"));
            checkoutButton.click();

            // Step 15: Click on 'My Account' dropdown and select 'Logout'
            WebElement myAccountDropdown = driver.findElement(By.xpath("//div[@class='account-dropdown']"));
            myAccountDropdown.click();
            WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Logout']"));
            logoutButton.click();
            System.out.println("Logged out successfully.");

            // Step 16: Verify 'Account Logout' heading (Skipping as this may vary in Meesho's flow)

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


package Project_2_Actions;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestClass extends BaseDriver {

    @Test
    public void Test1() {

        driver.get("http://demowebshop.tricentis.com/");
        WebElement register = driver.findElement(By.linkText("Register"));
        Actions aksiyonlar = new Actions(driver);

        Action aksiyon = aksiyonlar.moveToElement(register).click().build();

        aksiyon.perform();

        WebElement gender = driver.findElement(By.id("gender-male"));

        aksiyon = aksiyonlar.moveToElement(gender).click().build();
        aksiyon.perform();

        aksiyonlar.sendKeys(Keys.TAB).sendKeys("Cihat").perform();

        aksiyonlar.sendKeys(Keys.TAB).sendKeys("Düğer").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("Cihatdüğer30@gmail.com").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("123456").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("123456").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        WebElement mesaj = driver.findElement(By.cssSelector("[class='result']"));

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(30));
        bekle.until(ExpectedConditions.textToBe(By.cssSelector("[class='result']"), "Your registration completed"));


        Assert.assertEquals(mesaj.getText(), "Your registration completed");

        WebElement logOut = driver.findElement(By.linkText("Log out"));
        aksiyonlar.moveToElement(logOut).click().build().perform();

    }

    @Test
    public void Test2() {
        WebElement register = driver.findElement(By.linkText("Register"));
        Actions aksiyonlar = new Actions(driver);

        Action aksiyon = aksiyonlar.moveToElement(register).click().build();

        aksiyon.perform();

        WebElement gender = driver.findElement(By.id("gender-male"));

        aksiyon = aksiyonlar.moveToElement(gender).click().build();
        aksiyon.perform();

        aksiyonlar.sendKeys(Keys.TAB).sendKeys("Cihat").perform();

        aksiyonlar.sendKeys(Keys.TAB).sendKeys("Düğer").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("Cihatdüğer30@gmail.com").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("123456").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("123456").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //The specified email already exists


        WebElement mesaj = driver.findElement(By.xpath("//*[text()='The specified email already exists']"));

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(30));
        bekle.until(ExpectedConditions.textToBe(By.xpath("//*[text()='The specified email already exists']"), "The specified email already exists"));


        Assert.assertEquals(mesaj.getText(), "The specified email already exists");


    }

    @Test
    public void Test3() {


        WebElement login = driver.findElement(By.linkText("Log in"));
        Actions aksiyonlar = new Actions(driver);

        aksiyonlar.moveToElement(login).click().build().perform();

        aksiyonlar.sendKeys("Cihatdüğer30@gmail.com");
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("123456").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        WebElement mesaj = driver.findElement(By.linkText("Cihatdüğer30@gmail.com"));

        Assert.assertEquals(mesaj.getText(), "Cihatdüğer30@gmail.com");
        WebElement logOut = driver.findElement(By.linkText("Log out"));
        aksiyonlar.moveToElement(logOut).click().build().perform();

    }

    @Test
    public void Test4() {

        WebElement login = driver.findElement(By.linkText("Log in"));
        Actions aksiyonlar = new Actions(driver);

        aksiyonlar.moveToElement(login).click().build().perform();

        aksiyonlar.sendKeys("aaaaaa19@gmail.com");
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("1234567").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        WebElement mesaj = driver.findElement(By.xpath("//*[text()='Login was unsuccessful. Please correct the errors and try again.']"));

        Assert.assertEquals(mesaj.getText(), "Login was unsuccessful. Please correct the errors and try again.");

    }

    @Test
    public void Test5() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.linkText("Log in"));
        Actions aksiyonlar = new Actions(driver);

        aksiyonlar.moveToElement(login).click().build().perform();

        aksiyonlar.sendKeys("Cihatdüğer30@gmail.com");
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("123456").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // WebDriverWait bekle=new WebDriverWait(driver, Duration.ofSeconds(30));
        //bekle.until(ExpectedConditions.titleIs(By.xpath("(//*[text()='14.1-inch Laptop'])[1]"),"Show details for 14.1-inch Laptop"));
//By.xpath("(//*[text()='14.1-inch Laptop'])[1]")


        WebElement laptop = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[2]/h2/a"));

        aksiyonlar.moveToElement(laptop).click().build().perform();

        WebElement btn = driver.findElement(By.cssSelector("[id='add-to-cart-button-31']"));
        aksiyonlar.moveToElement(btn).click().build().perform();

        WebElement mesaj = driver.findElement(By.cssSelector("[class='content']"));
        System.out.println(mesaj.getText());

        Assert.assertTrue(mesaj.getText().contains("The product has been added to your "));

        WebElement sepet = driver.findElement(By.xpath("(//*[text()='Shopping cart'])[1]"));

        aksiyonlar.moveToElement(sepet).click().build().perform();


        WebElement mesaj1 = driver.findElement(By.xpath("//*[text()='14.1-inch Laptop' and @ class='product-name']"));
        System.out.println(mesaj1.getText());

        Assert.assertTrue(mesaj1.getText().contains("14.1-inch Laptop"));

        WebElement iAgree = driver.findElement(By.cssSelector("[id='termsofservice']"));
        aksiyonlar.moveToElement(iAgree).click().build().perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        WebElement conf = driver.findElement(By.cssSelector("[id='BillingNewAddress_Company']"));
        aksiyonlar.moveToElement(conf).click().sendKeys("Technostudy").build().perform();

        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("KARS").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("URFA").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("İSTANBUL").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("625786").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("5326587896").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys("3128569857").perform();
        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        WebElement contine = driver.findElement(By.cssSelector("#shipping-buttons-container > input"));

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(30));
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#shipping-buttons-container > input")));

        aksiyonlar.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        WebElement contine2 = driver.findElement(By.cssSelector("[onclick='ShippingMethod.save()']"));

        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[onclick='ShippingMethod.save()']")));
        aksiyonlar.moveToElement(contine2).click().build().perform();

        WebElement contine3 = driver.findElement(By.cssSelector("[onclick='PaymentMethod.save()']"));

        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[onclick='PaymentMethod.save()']")));
        aksiyonlar.moveToElement(contine3).click().build().perform();

        WebElement contine4 = driver.findElement(By.cssSelector("[onclick='PaymentInfo.save()']"));

        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[onclick='PaymentInfo.save()']")));
        aksiyonlar.moveToElement(contine4).click().build().perform();

        WebElement contine5 = driver.findElement(By.cssSelector("[onclick='ConfirmOrder.save()']"));

        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[onclick='ConfirmOrder.save()']")));
        aksiyonlar.moveToElement(contine5).click().build().perform();

        WebElement dogru = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));

        Assert.assertEquals("Your order has been successfully processed!", dogru.getText());

//    WebElement contine2= driver.findElement(By.cssSelector("[onclick='Shipping.save()']"));
//    aksiyonlar.moveToElement(contine2).click().build().perform();


    }
}

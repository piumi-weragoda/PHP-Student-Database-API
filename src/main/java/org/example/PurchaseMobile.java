package org.example;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PurchaseMobile extends Test {

    private String title;
    public String totalPrice;
    public String items;
    public String qty;
    WebElement firstSearchItem;
    @org.testng.annotations.Test(priority = 7)
    public void chooseFeature() {

        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Model']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Storage dropdown is not available ");
        }
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Carrier']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Carrier dropdown is not available ");
        }
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Storage Capacity'], select[selectboxlabel='Storage']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Storage Capacity not found");
        }
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Color'], select[selectboxlabel='Colour']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Color dropdown not found");
        }
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Cosmetic']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Cosmetic dropdown not found");
        }


    }

    @org.testng.annotations.Test(priority = 8)
    public void getPageTitle(){
        WebElement firstSearchItem = driver.findElement(By.cssSelector("h1.x-item-title__mainTitle"));
        String itemName = firstSearchItem.getText().trim();
        items = itemName;
        System.out.println("Selected item: " + itemName);


    }

    @org.testng.annotations.Test(priority = 9)
    public void getItemPrice(){
        
        WebElement firstSearchItemP = driver.findElement(By.xpath("//span[@itemprop='price']//span[@class='ux-textspans']"));
        String itemPrice = firstSearchItemP.getText().trim();
        totalPrice = itemPrice;
        System.out.println("Selected Price: " + itemPrice);


    }

    @org.testng.annotations.Test(priority = 10)
    public void getItemCondition(){
        WebElement firstSearchItemC = driver.findElement(By.xpath("//div[@class='x-item-condition-text']//span[@class='ux-textspans']"));
        String itemCondition = firstSearchItemC.getText().trim();
        System.out.println("Selected item Condition: " + itemCondition);

    }

    @org.testng.annotations.Test(priority = 11)
    public void getItemQuantity(){
       
        String firstSearchItemQ = driver.findElement(By.id("qtyTextBox")).getAttribute("value");
        String itemQuality = firstSearchItemQ.trim();
        qty = itemQuality;
        System.out.println("Selected item Quantity: " + itemQuality);

    }

    @org.testng.annotations.Test(priority = 12)
    public void addMobItemCart(){
        WebElement addToCartButton = driver.findElement(By.xpath("//a[@class='ux-call-to-action fake-btn fake-btn--fluid fake-btn--primary']//span[@class='ux-call-to-action__text' and text()='Add to cart']"));
        addToCartButton.click();
    }

    @org.testng.annotations.Test(priority = 13)
    public void assertP(){
        String subtotalValue = driver.findElement(By.cssSelector("div[data-test-id='SUBTOTAL']")).getText().trim();
        Assert.assertEquals(subtotalValue, totalPrice);
        String title = driver.findElement(By.className("item-title")).getText().trim();
        Assert.assertEquals(title, items);
    }

    @org.testng.annotations.Test(priority = 14)
    public void assertQ(){
        String itemQuantityInCart = driver.findElement(By.xpath("//div[@class='right-section']/div/div[2]/div/div/span/span/span")).getText();
        System.out.println("The item quantity in cart : " +itemQuantityInCart.substring(6,7));

    }
    @org.testng.annotations.Test(priority = 15)
    public void assertSubTot(){
        String subTot =driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[4]/div[2]/span/span/span")).getText();
        Assert.assertEquals(subTot, totalPrice,"Success");
    }

    @org.testng.annotations.Test(priority = 16)
    public void getShippingValue(){

        WebElement firstSearchItemS = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[2]/div[2]/span/span/span"));

        String totShippingValue = firstSearchItemS.getText().trim();

        System.out.println("Total Shpping cost: " + totShippingValue);

        driver.quit();
    }

}

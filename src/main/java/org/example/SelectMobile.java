package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectMobile extends Test {
    WebElement firstSearchItem;

    @org.testng.annotations.Test(priority = 2)
    public void searchMobPhone() {

        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
        categoryDropdown.click();
        WebElement cellPhonesCategory = driver.findElement(By.xpath("//option[text()='Cell Phones & Accessories']"));
        cellPhonesCategory.click();
    }

    @org.testng.annotations.Test(priority = 3)
    public void searchMobile() {

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Mobile phone");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();
    }

    @org.testng.annotations.Test(priority = 4)
    public void seltBrand() {
        WebElement appleBrandCheckbox = driver.findElement(By.xpath("//input[@aria-label='Apple']"));
        appleBrandCheckbox.click();
    }

    @org.testng.annotations.Test(priority = 5)
    public void firstItem() {
        WebElement firstSearchItem = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div"));
        firstSearchItem.click();


    }

    @org.testng.annotations.Test(priority = 6)
    public void navigateNew() throws InterruptedException {
        String mainWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

    }

}
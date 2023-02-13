package com.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PageObjects {

    By fromAddress = By.xpath("//input[@id='InputFrom']");
    By toAddress = By.xpath("//input[@id='InputTo']");

    By planJourneyButton = By.xpath("//input[@id='plan-journey-button']");
    By fromErrorText = By.xpath("//span[@id='InputFrom-error']");
    By toErrorText = By.xpath("//span[@id='InputTo-error']");

    By invalidJourneyText = By.xpath("//li[@class='field-validation-error']");

    By editJourneyButton = By.xpath("//span[normalize-space()='Edit journey']");

    By homeWidgetButton = By.xpath("//span[normalize-space()='Home']");

    By recentJourneyText  = By.xpath("//div[@id='jp-recent-content-home-']/a");

    By recentsTab = By.xpath("//li[@id='jp-recent-tab-home']//a[@role='tab'][normalize-space()='Recents']");

    By clearToLocationButton =By.xpath("//a[normalize-space()='Clear To location']");

    By turnOnRecents = By.xpath("//div[@id='jp-recent-content-home-']//a[@role='button'][normalize-space()='Turn on recent journeys']");

    public static WebDriver cdriver;
    public static Actions act;

    public static WebDriver getDriver () {

        cdriver = new ChromeDriver();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//      WebDriverManager.chromedriver().setup();
//      ChromeOptions option = new ChromeOptions();
//      option.setHeadless(true);

        return cdriver;
    }




    public void closeWebsite() {

        cdriver.manage().deleteAllCookies();
        System.out.println("Closing Driver");
        cdriver.quit();

    }

    public void enterFromPostcode(String strArg1) {

        cdriver.findElement(fromAddress).sendKeys(strArg1);
        act = new Actions(cdriver);
        act.sendKeys(Keys.TAB).perform();

    }


    public void enterToPostcode(String strArg1) {

        cdriver.findElement(toAddress).sendKeys(strArg1);
        act.sendKeys(Keys.TAB).perform();

    }

    public void clickOnPlanJourneyButton() {

        cdriver.findElement(planJourneyButton).click();

    }

    public String getFromErrorText() {

        return cdriver.findElement(fromErrorText).getText();

    }

    public String getToErrorText() {

        return cdriver.findElement(toErrorText).getText();

    }

    public String invalidErrorText() {

        return cdriver.findElement(invalidJourneyText).getText();

    }

    public void clickOnEditJourneyButton() {

        cdriver.findElement(editJourneyButton).click();

    }

    public void clickOnHomeWidgetButton() {

        cdriver.findElement(homeWidgetButton).click();

    }
    public String recentJourneyText() {

        return cdriver.findElement(recentJourneyText).getText();

    }

    public void clickOnRecentsTab() {

        cdriver.findElement(recentsTab).click();

    }


    public void turnOnRecentButton() {


        try{
            cdriver.findElement(turnOnRecents).click();
        }
        catch (Exception ignored) {
        }

    }


    public void clearToLocation()  {


        try{
            cdriver.findElement(clearToLocationButton).click();
        }
        catch (Exception ignored) {
        }

    }


}

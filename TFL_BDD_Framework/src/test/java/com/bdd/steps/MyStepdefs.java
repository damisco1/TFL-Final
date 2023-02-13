package com.bdd.steps;

import com.bdd.pages.PageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.bdd.pages.PageObjects.getDriver;


public class MyStepdefs {

    WebDriver driver;
    PageObjects a =new PageObjects();
    @Given("^I have arrived at the TFL page")
    public void i_have_arrived_at_the_tfl_page()  {

        driver =getDriver();
        driver.get("https://tfl.gov.uk/");
        try{
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/button[2]/strong[1]")).click();
        }
        catch (Exception ignored) {
        }
        System.out.println("Accepted cookies");
        String a =driver.getTitle();
        String b = "Keeping London moving - Transport for London";
        System.out.println("Page Title is " + a);
        System.out.println("Page Title is " + b);
        Assert.assertEquals(a,b);

    }



    @Then("^I see the journey results page$")
    public void i_see_the_journey_results_page() throws InterruptedException {
        Thread.sleep(5000);
        String a =driver.getTitle();
        String b = "Journey results - Transport for London";
        System.out.println("Page Title is " + a);
        System.out.println("Page Title is " + b);
        Assert.assertEquals(a,b);


    }

    @And("^I enter the following postcode \"([^\"]*)\" into the FROM search bar of the plan journey widget$")
    public void i_enter_the_following_postcode_something_into_the_from_search_bar_of_the_plan_journey_widget(String strArg1){

        a.enterFromPostcode(strArg1);
    }

    @And("I enter the following postcode {string} into the TO search bar of the plan journey widget")
    public void i_Enter_The_Following_Postcode_Into_The_TO_Search_Bar_Of_The_Plan_Journey_Widget(String arg0) {

        a.enterToPostcode(arg0);
    }

    @And("I enter the following postcode {string} into the TO journey search bar of the plan journey widget")
    public void i_Enter_The_Following_Postcode_Into_The_TO_Journey_Search_Bar_Of_The_Plan_Journey_Widget(String arg0) {

         a.clearToLocation();

        a.enterToPostcode(arg0);
    }



    @And("^I click on the plan journey button$")
    public void i_click_on_the_plan_journey_button()  {
       a.clickOnPlanJourneyButton();

    }

    @And("^I close the website$")
    public void i_close_the_website() {

        driver.manage().deleteAllCookies();
        System.out.println("Closing Driver");
        driver.quit();
    }

    @Then("I see an error message within the to search stating {string}")
    public void iSeeAnErrorMessageWithinTheToSearchStating(String arg0) {
        String toErrorText = a.getToErrorText();
        System.out.println("  dshfddf" + toErrorText);
        System.out.println("  dshfddf" + arg0);
        Assert.assertEquals(toErrorText,arg0);
    }

    @Then("I see an error message within the from search stating {string}")
    public void iSeeAnErrorMessageWithinTheFromSearchStating(String arg0) {
        String FromErrorText = a.getFromErrorText();
        Assert.assertEquals(FromErrorText,arg0);
    }

    @And("I am still in the TFL Plan Journey Home Page")
    public void iAmStillInTheTFLPlanJourneyHomePage() {
        String a =driver.getTitle();
        String b = "Keeping London moving - Transport for London";
        System.out.println("Page Title is " + a);
        System.out.println("Page Title is " + b);
        Assert.assertEquals(a,b);
    }

    @Then("I do not see the journey results page")
    public void i_Do_Not_See_The_Journey_Results_Page() {
        String a =driver.getTitle();
        String b = "Journey results - Transport for London";
        System.out.println("Page Title is " + a);
        System.out.println("Page Title is " + b);
        Assert.assertNotEquals(a,b);
    }

    @And("I see the {string} error dialog")
    public void iSeeTheErrorDialog(String arg0) {
        String ErrorText = a.invalidErrorText();
        System.out.println("  dshfddf" + ErrorText);
        System.out.println("  dshfddf" + arg0);
        Assert.assertEquals(ErrorText,arg0);

    }

    @Then("I select the edit journey button")
    public void iSelectTheEditJourneyButton() {

       a.clickOnEditJourneyButton();
    }

    @And("I click on the home widget button")
    public void iClickOnTheHomeWidgetButton()  {

        a.clickOnHomeWidgetButton();

    }

    @And("i see in the {string} as the first entry in the first recent journey")
    public void iSeeInTheAsTheFirstEntryInTheFirstRecentJourney(String arg0) {

        String ErrorText = a.recentJourneyText();
        System.out.println("  dshfddf" + ErrorText);
        System.out.println("  dshfddf" + arg0);
        Assert.assertEquals(ErrorText,arg0);

    }

    @And("I click on the Recents tab")
    public void iClickOnTheRecentsTab() throws InterruptedException {
        Thread.sleep(1000);
        a.turnOnRecentButton();
        a.clickOnRecentsTab();
    }



}


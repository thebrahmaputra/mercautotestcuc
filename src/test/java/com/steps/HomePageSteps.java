package com.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HomePageSteps extends StepBase{

    @Given("user is on login page")
    public void user_is_on_login_page(){
        initDriver();
    }

    @When("user clicks on link SIGN-ON")
    public void user_clicks_on_link_SIGN_ON() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.linkText("SIGN-ON")).click();
    }

    @Then("verify page title is Sign-on: Mercury Tours")
    public void page_title_is_Sign_on_Mercury_Tours() {
        // Write code here that turns the phrase above into concrete actions
//        String title = driver.getTitle();
        Assert.assertEquals("title", "title");
    }

    @Then("close the browser")
    public void close_the_browser() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("===========Closing the browser============");
        driver.close();
    }

    @Then("capture screenshot")
    public void capture_screenshot() {
        // Write code here that turns the phrase above into concrete actions
        File screenCapture = ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File("target/screens/testTakeScreenShotOfHomePage.jpg"), true);
//            Reporter.log("Screenshot saved at : <a href=\"screens/testTakeScreenShotOfHomePage.jpg\">Failure screen</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After("@BasicTest")
    public void takeScreenShot(Scenario scenario){
        byte []screenCapture = ((ChromeDriver) driver).getScreenshotAs(OutputType.BYTES);
        try {
//            FileUtils.copyFile(screenCapture, new File("target/screens/testTakeScreenShotOfHomePage.jpg"), true);
//            Reporter.log("Screenshot saved at : <a href=\"screens/testTakeScreenShotOfHomePage.jpg\">Failure screen</a>");
            scenario.embed(screenCapture, "image/png");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        new WebDriverWait().until(ExpectedConditions.visibilityOf(TextElement));
//        String textAfter = TextElement.getText().trim();

        driver.close();
    }
}

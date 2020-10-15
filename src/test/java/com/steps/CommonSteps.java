package com.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonSteps extends StepBase{
    @Given("user is on \"(.*)\" page")
    public void user_is_on_page(String url) {
        // Write code here that turns the phrase above into concrete actions
//        driver.navigate().to(url);
//        driver.manage().window().maximize();
        initDriver(url);
    }


    @Then("verify page title is \"(.*)\"")
    public void verify_page_title_is(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @Then("enter username \"(.*)\" and password \"(.*)\" and click on \"(.*)\"")
    public void enter_username_and_password_and_click_on_loginBtn(String usernameval, String passwordval, String buttonval) {
        findElm(driver, "username").sendKeys(usernameval);
        findElm(driver, "password").sendKeys(passwordval);
        findElm(driver,"loginButton").click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Then("user clicks on \"(.*)\" link")
    public void user_clicks_on_given_link(String link) {
        // Write code here that turns the phrase above into concrete actions
        findElm(driver, link).click();
    }

    @Then("user clicks on element \"(.*)\"")
    public void user_clicks_on_login_link(String loginButton) {
        // Write code here that turns the phrase above into concrete actions
        findElm(driver, loginButton).click();
    }

    @Then("enter firstname \"(.*)\" and last name \"(.*)\" and position \"(.*)\"")
    public void enter_firstname_and_last_name_and_position(String firstName, String lastName, String position) {
        // Write code here that turns the phrase above into concrete actions
        findElm(driver,"firstName").sendKeys(firstName);
        findElm(driver, "lastName").sendKeys(lastName);
        findElm(driver, "position").sendKeys(position);
    }

    @When("\"(.*)\" link is present on page")
    public void link_is_present_on_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("user clicks on link")
    public void user_clicks_on_link(DataTable links) {
        List<String> dataList = links.asList();
        for (String dataitem : dataList){
            findElm(driver, dataitem).click();
            System.out.println("clicked on --> " +dataitem);
        }
    }
}

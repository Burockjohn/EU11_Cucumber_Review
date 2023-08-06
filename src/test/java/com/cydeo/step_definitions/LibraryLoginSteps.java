package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;

public class LibraryLoginSteps {

    LibraryLoginPage loginPage = new LibraryLoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("I am on the login page")
    public void ı_am_on_the_login_page() {
        Driver.getDriver().get("https://library1.cydeo.com/login.html");
    }

    @When("I enter valid credentials and login")
    public void ı_enter_valid_credentials_and_login() {
        loginPage.userName.sendKeys("student1@library");
        loginPage.password.sendKeys("libraryUser");
        loginPage.loginButton.click();

    }

    @Then("I should be on the dashboard")
    public void ı_should_be_on_the_dashboard() {
        String actualText = dashboardPage.title.getText();
        String expectedText = "Book Management";
        Assert.assertEquals(expectedText, actualText);

    }

    @When("I enter invalid credentials and login")
    public void ıEnterInvalidCredentialsAndLogin() {
        loginPage.userName.sendKeys("student1@libraryincalid");
        loginPage.password.sendKeys("libraryUserInvalid");
        loginPage.loginButton.click();
    }

    @Then("I shouldn't  be on the dashboard")
    public void ıShouldnTBeOnTheDashboard() {
        BrowserUtils.sleep(3);
        String actualMessage = loginPage.message.getText();
        String expectedMessage = "Sorry, Wrong Email or Password";
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @When("I enter {string} credentials and login")
    public void ı_enter_credentials_and_login(String role) {
        String userName = "";
        String password = "";
        switch (role) {
            case "student":
                userName = ConfigurationReader.getProperty("library.student.email");
                password = ConfigurationReader.getProperty("library.student.password");
                break;
            case "librarian":
                userName = ConfigurationReader.getProperty("library.teacher.email");
                password = ConfigurationReader.getProperty("library.teacher.password");
                break;
            default:
                userName = ConfigurationReader.getProperty("library.student.email");
                password = ConfigurationReader.getProperty("library.student.password");
        }

        loginPage.userName.sendKeys(userName);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();


    }

    @Then("I should see {string} page")
    public void ı_should_see_page(String role) {
        BrowserUtils.sleep(3);
        String actualRole = dashboardPage.dropdown.getText();
        switch (role) {
            case "student":
                Assert.assertTrue(actualRole.contains("Student"));
                break;
            case "librarian":
                Assert.assertTrue(actualRole.contains("Librarian"));
                break;
        }

    }

}

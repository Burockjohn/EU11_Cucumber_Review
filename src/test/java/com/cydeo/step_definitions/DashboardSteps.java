package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DashboardSteps {

    LibraryLoginPage loginPage = new LibraryLoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("I logged into app")
    public void ı_logged_into_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("library.student.email"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("library.student.password"));
        loginPage.loginButton.click();
    }

    @When("I check student navigation bar")
    public void ı_check_student_navigation_bar() {
        BrowserUtils.sleep(2);
        if (dashboardPage.dropdown.getText().contains("Student")) {
            System.out.println("This is Student");
        } else {
            System.out.println("This is not Student");
        }
    }

    @Then("I should see navigation options")
    public void ı_should_see_navigation(List<String> expectedList) {
        // Write code here that turns the phrase above into concrete actions
        List<String> actualList = new ArrayList<>();
        for (WebElement navOption : dashboardPage.navOptions) {
            actualList.add(navOption.getText());
        }

        Assert.assertEquals(expectedList, actualList);
    }

    @When("choose classic from book categories")
    public void choose_classic_from_book_categories() {
        Select select = new Select(dashboardPage.bookCategoryDropdown);
        select.selectByVisibleText("Classic");

    }

    @Then("ISBN number should match book name")
    public void ısbn_number_should_match_book_name(Map<String, String> bookMap) {
        for (Map.Entry<String, String> each : bookMap.entrySet()) {
            String actualName = dashboardPage.getBookName(each.getKey());
            String expectedName = each.getValue();
            Assert.assertEquals(expectedName, actualName);
        }
    }

}

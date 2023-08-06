package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "h3")
    public WebElement title;

    @FindBy(xpath = "//a[@id='navbarDropdown']")
    public WebElement dropdown;

    @FindBy(xpath = "//li[@class='nav-item']")
    public List<WebElement> navOptions;

    @FindBy(id = "book_categories")
    public WebElement bookCategoryDropdown;

    public String getBookName(String isbn) {
        String xpath = "//td[.='" + isbn + "']/following-sibling::td[1]";
        WebElement book = Driver.getDriver().findElement(By.xpath(xpath));
        return book.getText();
    }
}

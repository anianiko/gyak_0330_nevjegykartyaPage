package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DataListFilterPage {

    WebDriver driver;

    public DataListFilterPage(WebDriver driver){
        this.driver = driver;
    }

    private final String URL = "https://demo.seleniumeasy.com/data-list-filter-demo.html";

    private final By NAMECARD = By.xpath("//*[@class=\"content\"]//div[@class=\"info-block block-info clearfix\"]");

    public void navigate(){
        driver.navigate().to(URL);
    }

    public String[] getNames(){
        List<WebElement> namecards = driver.findElements(NAMECARD);
        String[] namesList = new String[namecards.size()];
        int counter = 0;
        for(WebElement name : namecards){
            WebElement cardname = name.findElement(By.xpath(".//h4"));  //nem driver.findElement, mert a name-n belül keressük a h4-eket
            namesList[counter] = cardname.getText().replace("Name: ","");
            counter++;
        }
        return namesList;
    }



}

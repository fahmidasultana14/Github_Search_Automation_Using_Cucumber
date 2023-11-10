package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GithubPage {
    @FindBy(xpath = "//span[@class='flex-1']")
    WebElement clickSearch;
    @FindBy(id = "query-builder-test")
    WebElement searchBox;
    @FindBy(className = "qaOIC")
     public List<WebElement> firstMatch;
    @FindBy(xpath = "//a[contains(text(),'About')]")
    WebElement aboutButton;

    @FindBy(className = "octicon-mark-github")
    WebElement githubHome;

    public  GithubPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public void searchAction(String searchName) throws InterruptedException {
        clickSearch.click();
        Thread.sleep(2000);
        searchBox.sendKeys(searchName);
        Thread.sleep(4000);
        searchBox.sendKeys(Keys.ENTER);

    }

public void aboutClick() throws InterruptedException {
        firstMatch.get(0).click();
        Thread.sleep(4000);
        githubHome.click();
        Thread.sleep(1000);
         aboutButton.click();


}

}

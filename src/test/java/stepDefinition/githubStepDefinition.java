package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GithubPage;
import setup.Setup;


public class githubStepDefinition extends Setup {
    GithubPage githubPage;

    @Given("User visit the github site")
    public void user_visit_the_github_site() {
        driver.get("https://github.com/");
    }


    @When("User search by {string}")
    public void user_search_by(String searchName) throws InterruptedException {
        githubPage= new GithubPage(driver);
        githubPage.searchAction(searchName);


    }
    @Then("User verify the {string}")
    public void user_verify_the(String searchResult) throws InterruptedException {

        githubPage=new GithubPage(driver);
        Thread.sleep(1000);
        String ActualSearchResult= githubPage.firstMatch.get(0).getText();
        Assert.assertTrue(ActualSearchResult.contains(searchResult));



    }

    @When("User click on the About button in the landing page footer")
    public void user_click_on_the_about_button_in_the_landing_page_footer() throws InterruptedException {
        githubPage = new GithubPage(driver);
        githubPage.aboutClick();

    }

    @Then("User verify the About page")
    public void user_verify_the_about_page() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("about"));
    }
   @After
    public void teardown(){
        driver.quit();
    }


}



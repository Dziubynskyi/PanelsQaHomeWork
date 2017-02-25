package Home.Work.Tel;

import Home.Work.Tel.TestNgTestBase;
import Home.Work.Tel.pages.CompaniesPage;
import Home.Work.Tel.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginPage extends TestNgTestBase {

    public LoginPage loginPage;
    public CompaniesPage companiesPage;

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        companiesPage = PageFactory.initElements(driver, CompaniesPage.class);
    }

    @Test
    public void negativelogintest() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        loginPage.waitForLoginPageIsLoaded();
        loginPage.fillLoginField("sssss");
        loginPage.fillPasswordField(" ");
        loginPage.pressLoginButton();
        loginPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginPage.isOnLoginPage());

    }

    @Test
    public void positivelogintest() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        loginPage.waitForLoginPageIsLoaded();
        loginPage.fillLoginField("admin");
        loginPage.fillPasswordField("12345");
        loginPage.pressLoginButton();
        companiesPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesPage.isOnCompaniesPage());
        driver.close();


    }
}

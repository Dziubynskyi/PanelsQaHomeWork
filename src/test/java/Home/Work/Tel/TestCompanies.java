package Home.Work.Tel;

import Home.Work.Tel.TestNgTestBase;
import Home.Work.Tel.pages.CompaniesPage;
import Home.Work.Tel.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Comp on 2/19/2017.
 */
public class TestCompanies extends TestNgTestBase {

    public LoginPage loginPage;
    public CompaniesPage companiesPage;

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        companiesPage = PageFactory.initElements(driver, CompaniesPage.class);
    }


    @Test
    public void ChangeLanguageToEnglish() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        loginPage.waitForLoginPageIsLoaded();
        loginPage.fillLoginField("admin");
        loginPage.fillPasswordField("12345");
        loginPage.pressLoginButton();
        companiesPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesPage.isOnCompaniesPage());
        companiesPage.selectEnglishLanguage();
        companiesPage.EnglishLanguageIsSelected();

    }

    @Test
    public void ChangeLanguageToHebrew() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        loginPage.waitForLoginPageIsLoaded();
        loginPage.fillLoginField("admin");
        loginPage.fillPasswordField("12345");
        loginPage.pressLoginButton();
        companiesPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesPage.isOnCompaniesPage());
        companiesPage.selecthebrewLanguage();
        companiesPage.HebrewLanguageIsSelected();
    }
    @Test
        public void CheckLogOutButton() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        loginPage.waitForLoginPageIsLoaded();
        loginPage.fillLoginField("admin");
        loginPage.fillPasswordField("12345");
        loginPage.pressLoginButton();
        companiesPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesPage.isOnCompaniesPage());
        companiesPage.CheckLogOutButton();
        Assert.assertTrue(loginPage.isOnLoginPage());

    }
}

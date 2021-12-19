package org.anymindgroup.ragib.StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.anymindgroup.ragib.factory.DriverFactory;
import org.anymindgroup.ragib.model.User;
import org.anymindgroup.ragib.pages.DepositPage;
import org.anymindgroup.ragib.pages.LoginPage;
import org.anymindgroup.ragib.pages.TransactionPage;
import org.anymindgroup.ragib.pages.WithdrawPage;
import org.anymindgroup.ragib.util.Constant;
import org.junit.Assert;

public class CommonSteps {
    private User user =new User();
    private String title;
    private String transactionFee;
    private String amountAfterFee;
    private String initialBalance;
    private String balance;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private TransactionPage transactionPage = new TransactionPage(DriverFactory.getDriver());
    private DepositPage depositPage = new DepositPage(DriverFactory.getDriver());
    private WithdrawPage withdrawPage = new WithdrawPage(DriverFactory.getDriver());

    @Given("User is already on main Page")
    public void user_is_already_on_main_page() {
        DriverFactory.getDriver()
                .get("https://anylogi-recruitment.web.app/login");
    }

    @Then("User enters {string} and {string}")
    public void user_enters_and(String userName, String password) {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
    }

    @Then("User clicks on {string} button")
    public void user_clicks_on_button(String pageName) {
        if (pageName.equals("signup")) {
            loginPage.clickOnSignup();
        } else if (pageName.equals("login")) {
            loginPage.clickOnLogin();
        } else if (pageName.equals("deposit")) {
            depositPage.clickDepositButton();
            user.setBalanceAfterTransaction(pageName);
        } else if (pageName.equals("withdraw")) {
            loginPage.clickOnLogin();
            user.setBalanceAfterTransaction(pageName);
        }
    }

    @Then("User is on {string} page")
    public void user_is_on_page(String pageURL) throws InterruptedException {
        Thread.sleep(1000);
        if (pageURL.equals("portfolio")) {
            title = loginPage.getPortfolioPage();
            Assert.assertEquals(title, Constant.PORTFOLIO_URL);
        } else if (pageURL.equals("deposit")) {
            System.out.println(title);
            title = transactionPage.getDepositPage();
            Assert.assertEquals(title, Constant.DEPOSIT_URL);
        } else if (pageURL.equals("Withdraw")) {
            System.out.println(title);
            title = transactionPage.getWithdrawPage();
            Assert.assertEquals(title, Constant.WITHDRAQ_URL);
        }
        System.out.println(title);
    }

    @Then("User logout from the system")
    public void user_logout_from_the_system() {
        transactionPage.logout();
    }

    @Then("User performs {string} operation")
    public void user_performs_operation(String operation){
        if (operation.equals("deposit")) {
            transactionPage.goToDepositPage();
        } else if (operation.equals("withdraw")) {
            transactionPage.goToWithdrawPage();
        }
    }

    @Then("User enters {string}")
    public void user_enters(String amount) {
        depositPage.enterAmountForDeposit(amount);
        user.setTransactionAmount(amount);
        System.out.println(user.getTransactionAmount());
    }

    @Then("User checks {string}")
    public void user_checks(String message) throws InterruptedException {
        if (message.equals("fee")) {
            transactionFee=depositPage.getTransactionFee();
            amountAfterFee=depositPage.getFinalDeposit();
            initialBalance=depositPage.getInitialBalance();
            user.setTransactionFee(transactionFee);
            user.setAmountAfterFee(amountAfterFee);
            user.setInitialBalance(initialBalance);

        } else if (message.equals("Balance")) {
            Thread.sleep(10000);
            balance= loginPage.getBalance();
            System.out.println(balance);
            System.out.println(Double.toString(user.getBalanceAfterTransaction()));
            Assert.assertEquals(Double.parseDouble(balance),user.getBalanceAfterTransaction(),0);

        } else if (message.equals("error message")) {

        }

    }

}
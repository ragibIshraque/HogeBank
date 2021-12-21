package org.anymindgroup.ragib.StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.anymindgroup.ragib.factory.DriverFactory;
import org.anymindgroup.ragib.model.User;
import org.anymindgroup.ragib.pages.*;
import org.anymindgroup.ragib.util.Constant;
import org.junit.Assert;

public class CommonSteps {
    private User user =new User();
    private String errorMessage;
    private String title;
    private String transactionFee;
    private String amountAfterFee;
    private String initialBalance;
    private String balance;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private TransactionPage transactionPage = new TransactionPage(DriverFactory.getDriver());
    private DepositPage depositPage = new DepositPage(DriverFactory.getDriver());
    private WithdrawPage withdrawPage = new WithdrawPage(DriverFactory.getDriver());
    private Registration registration = new Registration(DriverFactory.getDriver());

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
            withdrawPage.clickDepositButton();
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
            title = transactionPage.getDepositPage();
            Assert.assertEquals(title, Constant.DEPOSIT_URL);
        } else if (pageURL.equals("withdraw")) {
            title = transactionPage.getWithdrawPage();
            Assert.assertEquals(title, Constant.WITHDRAQ_URL);
        }
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
            Assert.assertEquals(Double.parseDouble(balance),user.getBalanceAfterTransaction(),0);

        } else if (message.equals("userNameBlank")) {
            errorMessage = registration.getErrorMessage();
            Assert.assertEquals(errorMessage, Constant.ERROR_MESSAGE_USER_BLANK);

        }else if (message.equals("userNameWhiteSpace")) {
            errorMessage = registration.getErrorMessage();
            Assert.assertEquals(errorMessage, Constant.ERROR_MESSAGE_USER_WHITESPACE);

        }else if (message.equals("passwordLess")) {
            errorMessage = registration.getErrorMessage();
            Assert.assertEquals(errorMessage, Constant.ERROR_MESSAGE_PASSWORD_LESS);

        }else if (message.equals("passwordMore")) {
            errorMessage = registration.getErrorMessage();
            Assert.assertEquals(errorMessage, Constant.ERROR_MESSAGE_PASSWORD_MORE);

        }else if (message.equals("passwordNumber")) {
            errorMessage = registration.getErrorMessage();
            Assert.assertEquals(errorMessage, Constant.ERROR_MESSAGE_PASSWORD_NUMBER);

        }else if (message.equals("passwordUpperCase")) {
            errorMessage = registration.getErrorMessage();
            Assert.assertEquals(errorMessage, Constant.ERROR_MESSAGE_PASSWORD_UPPER_CASE);

        }else if (message.equals("")) {
            Thread.sleep(1000);
            title = transactionPage.getURL();
            Assert.assertEquals(title, Constant.PORTFOLIO_URL);

        }

    }

}

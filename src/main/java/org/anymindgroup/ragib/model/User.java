package org.anymindgroup.ragib.model;

public class User {
    private Double transactionAmount;
    private Double transactionFee;
    private Double amountAfterFee;
    private Double initialBalance;
    private Double balanceAfterTransaction;

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = Double.parseDouble(transactionAmount);
    }

    public Double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(String transactionFee) {
        this.transactionFee = Double.parseDouble(transactionFee);
    }

    public Double getAmountAfterFee() {
        return amountAfterFee;
    }

    public void setAmountAfterFee(String  amountAfterFee) {
        this.amountAfterFee = Double.parseDouble(amountAfterFee);
    }

    public Double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(String initialBalance) {
        this.initialBalance = Double.parseDouble(initialBalance);
    }

    public Double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public void setBalanceAfterTransaction(String operation) {
        if (operation.equals("deposit")) {
            balanceAfterTransaction=initialBalance+amountAfterFee;
        } else if (operation.equals("withdraw")) {
            balanceAfterTransaction=initialBalance-amountAfterFee;
        }
    }
}

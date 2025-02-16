package model;

public class TransactionModel {

    public String from_account;
    public String to_account;
    public int amount;

    public String getFrom_account() {
        return from_account;
    }

    public void setFrom_account(String from_account) {
        this.from_account = from_account;
    }

    public String getTo_account() {
        return to_account;
    }

    public void setTo_account(String to_account) {
        this.to_account = to_account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TransactionModel(){

    }

    public TransactionModel(String from_account, String to_account, int amount){
        this.from_account = from_account;
        this.to_account = to_account;
        this.amount = amount;
    }
}

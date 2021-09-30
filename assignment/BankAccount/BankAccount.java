import java.util.Random;

public class BankAccount{
    private String userName;
    private double checkingBalance;
    private double savingBalance;

    protected static int numOfAccount;

    public BankAccount(String userName, double checkingBalance, double  savingBalance){
        this.userName = userName;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        
        numOfAccount += 1;

    }

        public String getUserName(){
        return this.userName;
    }


    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingBalance(){
        return this.savingBalance;
    }


    public void deposit(String accountType, int amount){
        if(accountType.equals("Saving Account")){
            savingBalance += amount;
            System.out.println("Your saving account current balance is  " + savingBalance);
        }
        if(accountType.equals("Checking Account")){
            checkingBalance += amount;
            System.out.println("Your checking account current balance is  " + checkingBalance);
        }
    }
    public void withdraw(String accountType, int amount){
        if(accountType.equals("Saving Account")){
            if(savingBalance < amount){
                System.out.println("Insufficent Funds");
                } 
                
                else {
                    savingBalance -= amount;
                    System.out.println("Your saving account current balance is" + savingBalance);
                    }
        }
        if(accountType.equals("Checking Account")){
            if(checkingBalance < amount){
                System.out.println("Insufficent Funds");
                } 
                
                else {
                    checkingBalance -= amount;
                    System.out.println("Your checking account current balance is" + checkingBalance);
                    }
        
        }

    }

}

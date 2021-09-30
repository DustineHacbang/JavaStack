public class BankAccountTest{
    public static void main(String[] args ){
        BankAccount dustineAccount = new BankAccount("Dustine", 0, 0);
        System.out.println("----" + dustineAccount.getUserName() + "----");

        dustineAccount.deposit("Saving Account",50);
        System.out.println(dustineAccount.getCheckingBalance());
        System.out.println(dustineAccount.getSavingBalance());

    }
}
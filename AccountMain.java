import java.util.Scanner;

class Account{
    long accountNo;
    String accountHolderName;
    Double balance;
   
    Account( long accountNo,String accountHolderName, Double balance)
    {
        this.accountNo=accountNo;
        this.accountHolderName=accountHolderName;
        this.balance=balance;
    }
    void printAccountDetails(){
        System.out.println("\n =============== Account Details=================");
    System.out.println("AccountNo= " +accountNo);
    System.out.println("accountHolderName= " +accountHolderName);
    System.out.println("Balance=" +balance);
  
}
    
    double getBalance(){
        return balance;

    }
}
    class SavingsAccount extends Account{
 
        SavingsAccount(long accountNo, String accountHolderName, Double balance) {
			super(accountNo, accountHolderName, balance);
		double rateOfInterest;
            this.rateOfInterest=rateOfInterest;

    }
    void printAccountDetails()
    {
        super.printAccountDetails();
        System.out.println("rate of intrest"+rateOfInterest);
    }
    double getBalance(){
        return ((rateOfInterest/100)*(super.getBalance));

    }
    }
    class SalaryAccount extends Account{
        String companyName;
        double salaryWithdrwan;
    SalaryAccount(String companyName,double salaryWithdrwan,long accountNo, String accountHolderName, Double balance) {
        super(accountNo, accountHolderName, balance);
        this.companyName=companyName;
        this.salaryWithdrwan=salaryWithdrwan;

    }
        void printAccountDetails()
        {
            
        super.printAccountDetails();
        System.out.println("company name"+companyName);
        System.out.println("salaryWithdrawn"+salaryWithdrwan);

    }
    }

    class AccountMain{

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("enter the account details");
            String n1=sc.next();
            if(n1.equals("saving"))
            {
                System.out.println();
            }

        }
    }
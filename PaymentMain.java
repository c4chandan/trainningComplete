
class Payment
{
    double amount;
    Payment(double amount)
    {
        
        this.amount=amount; 
    }

   void paymentDetails()
    {
         System.out.println("amount to be paid"+amount );
    }

}
class Cashpayment extends Payment
{
    Cashpayment(double amount) {
        super(amount);
        
    }

    void CashPaymentDetails()
   
    {
        paymentDetails();
    System.out.println("Mode of Payemtns= ");
  
}

}
class Cardpayment extends Payment
{
    Cardpayment(double amount,String name,long cardno,String expireDate,int cvv)
     {
        super(amount);
        this.name=name;
        this.expireDate=expireDate;
        this.cvv=cvv;
      }  


    String name;
    long cardno;
    String expireDate;
    int cvv;  
    
    void CardPaymentDetails()
    {
    System.out.println("\n =============== Payments Card Details=================");
    System.out.println("Name= " +name);
    System.out.println("Card no= " +cardno);
    System.out.println("Expire Date=" +expireDate);
    System.out.println("CVV=" +cvv);
}
    }

class PaymentMain{
 public static void main(String[] args) 
    {  
        String name=args[2];
        long cardno=Long.parseLong(args[3]);
        String expDate=args[4];
        int cvv=Integer.parseInt(args[5]) ;

        double amo=Double.parseDouble(args[1]) ;
             
if(args[0].equals("cash"))
{
    Cashpayment cash=new Cashpayment(amo);
    cash.CashPaymentDetails();
    System.out.println("Total cash");
}
else if (args[0].equals("card"))
{
    Cardpayment card=new Cardpayment(name, cardno, expDate, cvv, amo);
    card.CardPaymentDetails();
    
}
     }
}
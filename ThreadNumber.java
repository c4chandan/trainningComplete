    import java.util.Random;

    class Mythread implements Runnable
    {
        int num;
        public void run(){
           
        for(int i=0;i<3;i++)
        {
            System.out.println(i);
        }
        }

        public void generateNumaer()
        {
            Random r= new Random();
            for(int i = 0; i < 10; i++)
        {          
                System.out.println("Random Number : "+r.nextInt());
        }
        
        }
        public int calculateFactorial()
        {
            int i,fact=1;  
            int number=r;    
            for(i=1;i<=number;i++){    
                fact=fact*i;    
            }    
            System.out.println("Factorial of "+number+" is: "+fact);    
           }  
        }
    
    class ThreadNumber
    {
        public static void main(String[] args)
        {
        Mythread obj =new Mythread();
       Thread t1=new Thread(obj);
            Thread t2=new Thread(obj);
            t1.setname("Number");
            t2.setName("Factorial");
            t1.start();
            t2.start();
        }
    }
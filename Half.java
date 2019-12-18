import java.util.Scanner;
class Half{
    public static void main(String [] args )
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
            String s1=sc.next();
        int a=(s1.length()/2);
       String Fname=s1.substring(0, a);
       String Lname=s1.substring(a);
        System.out.println(Fname.toLowerCase()+" "+Lname.toUpperCase());
        
    }
    
}
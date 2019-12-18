import java.util.Arrays;
import java.util.Scanner;

class Employee implements Comparable{
    int employeeID;
    String employeeName;

    Employee(int employeeID,String employeeName){
        this.employeeID=employeeID;
        this.employeeName=employeeName;
    }
    public String toString(){
        return employeeID +" "+employeeName;
    } 
    public int compareTo(Object obj)
    {
        /*int id1=employeeID; //current object(directly called)
        
        Employee e2=(Employee)obj;
        int id2=e2.employeeID;
        if(id1>id2) return 1;
        else if (id1<id2) return -1;
        else return 0;
        */
        String name1=employeeName;

        Employee e2=(Employee)obj;
        String name2=e2.employeeName;
        int a=name1.compareTo(name2);
        return a;
    }
}

class EmployeeMain2 {
    public static void main(String [] args)
    {
   /* Employee[] arr={ new Employee(2,"Chandan"),
    new Employee(4,"Etesh"),
    new Employee(1,"abhishek"),
    new Employee(5,"rahul"),
    new Employee(3,"ramesh"),
    };
*/
    Scanner sc= new Scanner(System.in);
    Employee[] arr=new Employee[5];
    for (int i=0;i<arr.length;i++)
    {
    System.out.println("Enter your ID and Name");
    int Id=sc.nextInt();
    String name=sc.next();
    
    Employee employeeobj=new Employee(Id, name);
    arr[i]=employeeobj;
    }    

    System.out.println("=========Before sorting===============");
for (int i=0;i<arr.length;i++)
{
System.out.println(arr[i]);
}

 Arrays.sort(arr);
 
System.out.println("=========After soritng===============");
 for (int i=0;i<arr.length;i++)
{
System.out.println(arr[i]);
}
}
}
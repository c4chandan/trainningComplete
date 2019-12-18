class Employee
{
    String EmpName;
    String dept;
    String designation;
    double basicSalary;

    Employee(String EmpName,String dept,String designation,double basicSalary)
    {
        this.EmpName=EmpName;
        this.dept=dept;
        this.designation=designation;
        this.basicSalary=basicSalary;

    }
void printEmployeeDetails()
{
    System.out.println("\n ===============Employee Details=================");
    System.out.println("employee name="+EmpName);
    System.out.println("employee department="+dept);
    System.out.println("employee desgnation="+designation);
    System.out.println("employee basicSalary="+basicSalary);
}
}
class Manager extends Employee{
    Manager(String ename,String dept, String desig,Double bsalary)
    {
        super(ename,dept,desig,bsalary);
    }
     double calculateSalary()
    {
       return basicSalary*10;
}
}
 
class Clerk extends Employee
{
    
  
    Clerk(String ename,String dept, String desig,Double bsalary)
    {
        super(ename,dept,desig,bsalary);
    }
   double calculateSalary()
    {
        return basicSalary*3;
    }
}


class EmployeeMain{
    public static void main(String[] args)
    {
        String ename=args[0];
        String dept=args[1];
        String desig=args[2];
        Double bsalary=Double.parseDouble(args[3]) ;
        if(args[2].equals("manager"))
        {
            Manager m1=new Manager(ename, dept, desig, bsalary);
            m1.printEmployeeDetails();
            System.out.println("total salary = "+ m1.calculateSalary());
        }
        else if(args[2].equals("clerk"))
       
        {
            Clerk cl=new Clerk(ename, dept, desig, bsalary);
            cl.printEmployeeDetails();
            System.out.println("Total salary= "+cl.calculateSalary());
        }

    }
}
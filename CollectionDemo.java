import java.util.*;

class Person {
    String name;
    int age;

    Person( String name,int age)
    {   
        this.name=name;
        this.age=age;

    }
public String toString()
{
    return "Name :- " +name+ "  " + "Age :- "+age;
}
public boolean equals(Oject obj)
{
    String name1=name;
    int age1=age;
    Person p=(Person)obj;
String name2=name;
String age2=age;
if((age1==age2) && name.equals(name2) )
{
    return true;
}
else return false;
}

}

class CollectionDemo
{
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       LinkedList<Person> l=new LinkedList<>();
 
       System.out.print("=============Details=======================");

       for(int i=0;i<5;i++){
        System.out.print("Enter your Name \n");
        String name=sc.next();
        System.out.print("Enter your Age \n");
        int age=sc.nextInt();
                    
       Person p=new Person(name, age);   
       l.add(p);
       //l.addFirst("Rahul");
         
    }
        System.out.print(l);
        l.add(new Person("CHandan",23));
         
    }
}
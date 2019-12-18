import java.util.*;

class Identifier1 implements Comparable
{
    int id;

    Identifier1(int id){
        this.id=id;
    }
    public String toString()
{
    return "ID :- " +id;
}
 public int compareTo(Object i)
 {
    int id1=id;
    Identifier1 i2=(Identifier1)i;
    int id2=i2.id;
    return id1-id2; 
 }
}
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
}

class MapDemo
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeMap<Identifier1,Person> av=new TreeMap<>();
        System.out.println("===============Elements In Map :==========");
 
        for(int i=0;i<2;i++){
            System.out.print("Enter your Id \n");
            int id=sc.nextInt();
            System.out.print("Enter your Name \n");
            String name=sc.next();
            System.out.print("Enter your Age \n");
            int age=sc.nextInt();
            Identifier1 s = new Identifier1(id);
           Person p=new Person(name, age);   
           av.put(s, p);
        }
           System.out.println(av);
        //     Comparator ps=av.comparator();
    //     System.out.println(ps);
    //   // System.out.println(s+" "+p);
   
    }
}

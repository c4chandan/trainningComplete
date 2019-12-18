    import java.util.*;
    class StoreStringObject 
    {
        String name;


        StoreStringObject(String name){
            this.name=name;
            

        }
    }

    class SetTree
    {
        public static void main(String [] args)
        {
            TreeSet<String> s= new TreeSet<>();
            System.out.println("===============Elements in before Reverse Order:==========");
            s.add("Chandan");
            s.add("Etesh");
            s.add("Abhishek");
            s.add("Raj");
            
            System.out.println(s);
            Iterator<String> it = s.descendingIterator();
            System.out.println("=================Elements After Reverse Order:===============");
            while (it.hasNext()) {
            System.out.println(it.next());
            }
            System.out.println("=================Cheking elements Exists or not:===============");
            boolean bl=s.contains("Chandan");
            System.out.print(bl);
    }
    }

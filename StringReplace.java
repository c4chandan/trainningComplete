class StringReplace
{
    public static void main(String []args)
    {
        String s1="Ali-Al-Ali";
      String s2="Ahmed-Al-Ahmed";
    String[]  f=s1.split("-");
    String[] l=s2.split("-");
   
       
    String sp=f[0]+"-"+f[1]+"-"+l[2];
    String ps=l[0]+"-"+l[1]+"-"+f[2];
    System.out.println(sp);
    System.out.println(ps);
    }
       
      
    //   // 
      // System.out.println(str1(0)+str1(1)+str(2));
        
    }

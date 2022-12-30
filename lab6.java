import java.util.Scanner;
class WrongAge extends Exception
{
WrongAge(){}
String msg=new String();
WrongAge(String s)
{  msg=s; }
public String toString()
{  return msg; }
}
class ErrorAge extends WrongAge
{
String msg1=new String();
ErrorAge(String ss)
{  msg1=ss; }
public String toString()
{  return msg1; }
}
class Father{
    int age;
    Scanner in=new Scanner(System.in);
    Father(){
        System.out.println("Enter the father's age: ");
        age=in.nextInt();
    }
    void ex1() throws WrongAge
    {
        if(age<=0)
         throw new WrongAge("Invalid input. Father's age can not be lesser than 0");
    }


}
class Son extends Father{
    int age;
  Son(){
    System.out.println("Enter the age of son: ");  
    age=in.nextInt();
  }
  void ex2() throws ErrorAge{
      if(age<=0||age>super.age){
         throw new ErrorAge("age of father less than son");
      }
else
  {
System.out.println("FATHER'S AGE:"+super.age+"\nSON'S AGE:"+age);
  }

  }
}

class A_main{
    public static void main(String[] args){
        Son s=new Son();
        try{
            s.ex1();
        }
        catch(WrongAge e){
            System.out.println(e);
        }
        try{
            s.ex2();
        }
        catch(ErrorAge e){
            System.out.println(e);
        }

    }
}
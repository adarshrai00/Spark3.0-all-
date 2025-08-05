import java.sql.Statement;
import java.util.Scanner;

interface utility
{
    public  void getdetails();
    public  void setdetails();
}

public class Main {
 static void menu()
 {
     System.out.println();
     System.out.println("======================= *** Welcome to the Showroom Management System ***====================");
     System.out.println();
     System.out.println("======================= *** Enter Your Choice *** ==============================");
     System.out.println();
     System.out.println("1]. ADD SHOWROOMS \t\t\t 2.]Add Employees \t\t\t  3.] ADD CARS");
     System.out.println();
     System.out.println("4.]GET SHOWROOMS \t\t\t 5.]GET EMPLOYEES \t\t\t  6.] GET CARS");
     System.out.println();
     System.out.println("======================= *** Enter  0 TO EXIT ***===========================");
 }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         Showroom showroom[] = new Showroom[5];
         Cars car[]=new Cars[5];
         Employees employees[]=new Employees[5];
         int choice=100;

           int carCount=0;
           int empCount=0;
           int ShowroomCount=0;

           while(choice!=0 && choice!=9)
           {
               menu();
               choice=sc.nextInt();

               if(choice==9) {
                   menu();
                   break;
               }

               switch(choice)
               {
                   case 1:
                       showroom[ShowroomCount]=new Showroom();
                       showroom[ShowroomCount].setdetails();
                       ShowroomCount++;
                       System.out.println();
                       System.out.println("1].  ADD NEW SHOWROOMS");
                       System.out.println("9]. BACK TO MAIN MENU");
                       break;
                   case 2:
                         employees[empCount]=new Employees();
                         employees[empCount].setdetails();
                         empCount++;
                         System.out.println();
                         System.out.println("1. ADD NEW EMPLOYEES");
                         System.out.println("9. BACK TO MAIN MENU");
                         break;
                   case 3:
                       car[carCount]=new Cars();
                       car[carCount].setdetails();
                       carCount++;
                       System.out.println();
                       System.out.println("2. ADD NEW CARS");
                       System.out.println("9. BACK TO MAIN MENU");
                       break;

                   case 4:
                       for(int i=0;i<ShowroomCount;i++)
                       {
                           showroom[i].getdetails();
                           System.out.println();
                           System.out.println();

                       }
                       System.out.println();
                       System.out.println();
                       System.out.println("9. BACK TO MAIN MENU");
                       System.out.println("0. EXIT");




               }

           }
    }



}




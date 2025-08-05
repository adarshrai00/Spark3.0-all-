import java.util.Scanner;

public class Showroom implements utility{

     String ShowroomName;
     String ShowroomAddress;
     String ManagerName;
     int totalEmployees;
     int totalCarsInStock;


     @Override
     public void getdetails() {
         System.out.println("Showroom Name: " + ShowroomName);
         System.out.println("Showroom Address: " + ShowroomAddress);
         System.out.println("Manager: " + ManagerName);
         System.out.println("Total Employees: " + totalEmployees);
         System.out.println("Total Cars in Stock: " + totalCarsInStock);

     }
@Override
     public void setdetails() {
    Scanner sc = new Scanner(System.in);
    System.out.println("=================== *** Enter Showroom Details ***==============");
    System.out.println();
    System.out.print("Enter Showroom Name: ");
    ShowroomName = sc.nextLine();
    System.out.print("Enter Showroom Address: ");
    ShowroomAddress = sc.nextLine();
    System.out.print("Enter Manager Name: ");
    ManagerName = sc.nextLine();
    System.out.print("Enter Total Employees: ");
    totalEmployees = sc.nextInt();

     }

}

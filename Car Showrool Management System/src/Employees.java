import java.util.Scanner;

public class Employees extends Showroom implements  utility {

    String EmpID;
    String EmpName;
    String EmpAge;
    String EmpDepartment;


    public void getdetails() {
        System.out.println("ID: " + EmpID);
        System.out.println("Name: " + EmpName);
        System.out.println("Age: " + EmpAge);
        System.out.println("Department: " + EmpDepartment);
        System.out.println("Showroom Name: " + ShowroomName )
        ;

    }

    @Override
    public void setdetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("======================= *** Employee Details **********************");
        System.out.println();
        System.out.println("Enter Employee ID:");
        EmpID= sc.nextLine();
        System.out.println("Enter Employee Name:");
        EmpName= sc.nextLine();
        System.out.println("Enter Employee Age:");
        EmpAge= sc.nextLine();
        System.out.println("Enter Employee Department:");
        EmpDepartment= sc.nextLine();
    }
}

import java.util.Scanner;

public class Cars extends Showroom implements utility {

    String car_name;
    String car_type;
    String car_price;
    String car_color;
    String car_Transmission;

    @Override
    public void getdetails() {
        System.out.println("Name: "+car_name);
        System.out.println("Type: "+car_type);
        System.out.println("Price: "+car_price);
        System.out.println("Color: "+car_color);
        System.out.println("Transmission: "+car_Transmission);

    }

    @Override
    public void setdetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================= *** Enter Cars Details ***==============");
        System.out.println("Enter Car Name:");
        car_name= sc.nextLine();
        System.out.println("Enter Car Type:");
        car_type= sc.nextLine();
        System.out.println("Enter Car Price:");
        car_price= sc.nextLine();
        System.out.println("Enter Car Color:");
        car_color= sc.nextLine();
        System.out.println("Enter Car Transmission:");
        car_Transmission= sc.nextLine();


    }
}

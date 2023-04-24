import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Car_Agency Agency=new Car_Agency();

        do {
            System.out.println("Please select the vehicle type:" + "\n" + " 1-Jeep" + "\n" + " 2-Frigate" + "\n" + " 3-Foot Glider" + "\n" + " 4-Game Drone");
            Scanner scanner = new Scanner(System.in);
            int x;
            x = scanner.nextInt();
            System.out.println("please enter model of car: ");
            Scanner scanner1 = new Scanner(System.in);
            String m;
            m = scanner1.next();
            System.out.println("please enter ability to move the vehicle ");
            Scanner scanner2 = new Scanner(System.in);
            int move;
            move = scanner2.nextInt();
            System.out.println("please enter the distance the vehicle traveled during its lifetime");
            Scanner scanner3 = new Scanner(System.in);
            double d;
            d = scanner3.nextDouble();
            System.out.println("please enter the number of passengers the vehicle contains");
            Scanner scanner4 = new Scanner(System.in);
            int p;
            p = scanner4.nextInt();
            System.out.println("Please type the maximum speed of the vehicle");
            Scanner scanner5 = new Scanner(System.in);
            int s;
            s = scanner5.nextInt();

            if (x == 1) {
                Jeep temp = new Jeep(m, move, d, s);
                Agency.add_Vehicle(temp);


            }


        }
    }
}
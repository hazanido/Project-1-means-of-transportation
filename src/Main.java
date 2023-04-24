import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Car_Agency Agency = new Car_Agency();
        int x;

        do {
            System.out.println("Please select the vehicle type:" + "\n" + "0-exit" + "\n" + " 1-Jeep" + "\n" + " 2-Frigate" + "\n" + " 3-Foot Glider" + "\n" + " 4-Game Drone ");
            Scanner scanner = new Scanner(System.in);

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
            if (x == 2) {
                System.out.println("please enter did Frigate sail with the direction of the wind?: ");
                Scanner scanner6 = new Scanner(System.in);
                boolean w;
                w = scanner6.nextBoolean();
                System.out.println("please enter what country did he sail to?: ");
                Scanner scanner7 = new Scanner(System.in);
                String c;
                c = scanner7.next();
                Frigate temp = new Frigate(m, move, d, p, s, w, c);
                Agency.add_Vehicle(temp);
            }
            if (x == 3) {
                System.out.println("Please type the type of military/civilian vehicle?: ");
                Scanner scanner7 = new Scanner(System.in);
                String t;
                t = scanner7.next();

                Foot_Glider temp = new Foot_Glider(m, move, d, p, s, t);
                Agency.add_Vehicle(temp);
            }
            if (x == 4) {
                System.out.println("Please type the type of military/civilian vehicle?: ");
                Scanner scanner8 = new Scanner(System.in);
                String t;
                t = scanner8.next();

                Game_Drone temp = new Game_Drone(m, move, d, p, s, t);
                Agency.add_Vehicle(temp);
            }

        } while (x != 0);

        System.out.println("Please select the desired option:" + "\n" + "0-exit" + "\n" + " 1-Buy a car from the dealership" + "\n" + " 2-Take vehicles for a test drive" + "\n" + " 3-Resetting the distance traveled by all vehicles" + "\n" + " 4-Changing the flag of all vessels to the information entered by the user ");
        Scanner scanner = new Scanner(System.in);
    }
}
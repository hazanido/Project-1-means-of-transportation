// Shiraz Nagaoker 208324194
// Ido hazan-316613769
import Vehicle.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Car_Agency Agency = new Car_Agency();
        int choice=10;
        Scanner scanner0 = new Scanner(System.in);
        //choice = scanner0.nextInt();
        System.out.println("Please select the vehicle type:" + "\n" + "0-exit" + "\n" + " 1-Jeep" + "\n" + " 2-Frigate" + "\n" + " 3-Foot Glider" + "\n" + " 4-Game Drone ");
        Scanner scanner21 = new Scanner(System.in);
        choice = scanner21.nextInt();
        while (choice != 0){

            if (choice==0){
                continue;
            }
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

            if (choice == 1) {
                //Jeep temp = new Jeep(m, move, d, s);
                //Agency.add_Vehicle(temp);
                System.out.println("Please select the vehicle type:" + "\n" + "0-exit" + "\n" + " 1-Jeep" + "\n" + " 2-Frigate" + "\n" + " 3-Foot Glider" + "\n" + " 4-Game Drone ");
                Scanner scanner16 = new Scanner(System.in);

                choice = scanner16.nextInt();


            }
            else if (choice == 2) {
                System.out.println("please enter did Vehicle.Frigate sail with the direction of the wind?: ");
                Scanner scanner6 = new Scanner(System.in);
                boolean w;
                w = scanner6.nextBoolean();
                System.out.println("please enter what country did he sail to?: ");
                Scanner scanner7 = new Scanner(System.in);
                String c;
                c = scanner7.next();
                Frigate temp = new Frigate(m, move, d, p, s, w, c);
                Agency.add_Vehicle(temp);
                System.out.println("Please select the vehicle type:" + "\n" + "0-exit" + "\n" + " 1-Vehicle.Jeep" + "\n" + " 2-Vehicle.Frigate" + "\n" + " 3-Foot Glider" + "\n" + " 4-Game Drone ");
                Scanner scanner17 = new Scanner(System.in);

                choice = scanner17.nextInt();
            }
            else if (choice == 3) {
                System.out.println("Please type the type of military/civilian vehicle?: ");
                Scanner scanner7 = new Scanner(System.in);
                String t;
                t = scanner7.next();

                //Dawn_Rigoli temp = new Dawn_Rigoli(m, move, d, p, s, t);
                //Agency.add_Vehicle(temp);
                System.out.println("Please select the vehicle type:" + "\n" + "0-exit" + "\n" + " 1-Vehicle.Jeep" + "\n" + " 2-Vehicle.Frigate" + "\n" + " 3-Foot Glider" + "\n" + " 4-Game Drone ");
                Scanner scanner18 = new Scanner(System.in);

                choice = scanner18.nextInt();
            }
            else if (choice == 4) {
                System.out.println("Please type the type of military/civilian vehicle?: ");
                Scanner scanner8 = new Scanner(System.in);
                String t;
                t = scanner8.next();

                Game_Drone temp = new Game_Drone(m, move, d, p, s, t);
                Agency.add_Vehicle(temp);
                System.out.println("Please select the vehicle type:" + "\n" + "0-exit" + "\n" + " 1-Vehicle.Jeep" + "\n" + " 2-Vehicle.Frigate" + "\n" + " 3-Foot Glider" + "\n" + " 4-Game Drone ");
                Scanner scanner19 = new Scanner(System.in);

                choice = scanner19.nextInt();
            }

        }


        System.out.println("Please select the desired option:" + "\n" + " 1-Buy a car from the dealership" + "\n" + " 2-Take vehicles for a test drive" + "\n" + " 3-Resetting the distance traveled by all vehicles" + "\n" + " 4-Changing the flag of all vessels to the information entered by the user " + "\n" + " 5-Exit" + "\n");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();

while (choice!=0) {
    switch (choice) {
        case 1: {
            Agency.print();
            System.out.println("Please type the name of the selected model: ");
            Scanner scanner9 = new Scanner(System.in);
            String selected_model;
            selected_model = scanner9.next();
            System.out.println("Please type in the mobility of the selected vehicle: ");
            Scanner scanner10 = new Scanner(System.in);
            int mobility;
            mobility = scanner10.nextInt();
            System.out.println("Please type the distance that the selected vehicle has traveled in its lifetime: ");
            Scanner scanner11 = new Scanner(System.in);
            double distance_selected_vehicle;
            distance_selected_vehicle = scanner11.nextDouble();
            System.out.println("Please type the number of passengers the maximum of the vehicle you : ");
            Scanner scanner12 = new Scanner(System.in);
            int passengers_selected_vehicle;
            passengers_selected_vehicle = scanner12.nextInt();
            System.out.println("Please type the speed the maximum of the vehicle you selected: ");
            Scanner scanner13 = new Scanner(System.in);
            double speed_selected_vehicle;
            speed_selected_vehicle = scanner13.nextDouble();

            if ((Agency.vehicle_exists(selected_model, mobility, distance_selected_vehicle, passengers_selected_vehicle, speed_selected_vehicle)) == true) {
                Agency.remove(selected_model, mobility, distance_selected_vehicle, passengers_selected_vehicle, speed_selected_vehicle);
                System.out.println("The order was successfully placed");
                System.out.println("Please select the desired option:" + "\n" + " 1-Buy a car from the dealership" + "\n" + " 2-Take vehicles for a test drive" + "\n" + " 3-Resetting the distance traveled by all vehicles" + "\n" + " 4-Changing the flag of all vessels to the information entered by the user " + "\n" + " 5-Exit" + "\n");
                Scanner scanner23 = new Scanner(System.in);
                choice = scanner23.nextInt();
                break;
            } else {
                System.out.println("Sorry, the vehicle does not exist in the system");
                System.out.println("Please select the desired option:" + "\n" + " 1-Buy a car from the dealership" + "\n" + " 2-Take vehicles for a test drive" + "\n" + " 3-Resetting the distance traveled by all vehicles" + "\n" + " 4-Changing the flag of all vessels to the information entered by the user " + "\n" + " 5-Exit" + "\n");
                Scanner scanner24 = new Scanner(System.in);
                choice = scanner24.nextInt();
                break;
            }
        }
        case 2: {
            Agency.print();
            System.out.println("Please type the name of the selected model: ");
            Scanner scanner9 = new Scanner(System.in);
            String selected_model;
            selected_model = scanner9.next();
            System.out.println("Please type in the mobility of the selected vehicle: ");
            Scanner scanner10 = new Scanner(System.in);
            int mobility;
            mobility = scanner10.nextInt();
            System.out.println("Please type the distance that the selected vehicle has traveled in its lifetime: ");
            Scanner scanner11 = new Scanner(System.in);
            double distance_selected_vehicle;
            distance_selected_vehicle = scanner11.nextDouble();
            System.out.println("Please type the number of passengers the maximum of the vehicle you : ");
            Scanner scanner12 = new Scanner(System.in);
            int passengers_selected_vehicle;
            passengers_selected_vehicle = scanner12.nextInt();
            System.out.println("Please type the speed the maximum of the vehicle you selected: ");
            Scanner scanner13 = new Scanner(System.in);
            double speed_selected_vehicle;
            speed_selected_vehicle = scanner13.nextDouble();
            if ((Agency.vehicle_exists(selected_model, mobility, distance_selected_vehicle, passengers_selected_vehicle, speed_selected_vehicle)) == true) {


                System.out.println("Please type in the km for the displacement on a test drive: ");
                Scanner scanner14 = new Scanner(System.in);
                int new_mobility;
                new_mobility = scanner14.nextInt();
                int j;
                j = Agency.indexOf(selected_model, mobility, distance_selected_vehicle, passengers_selected_vehicle, speed_selected_vehicle);
                Agency.Adding_km_displacement(Agency.get_vehicle(), j, new_mobility);
                System.out.println("Please select the desired option:" + "\n" + " 1-Buy a car from the dealership" + "\n" + " 2-Take vehicles for a test drive" + "\n" + " 3-Resetting the distance traveled by all vehicles" + "\n" + " 4-Changing the flag of all vessels to the information entered by the user " + "\n" + " 5-Exit" + "\n");
                Scanner scanner25 = new Scanner(System.in);
                choice = scanner25.nextInt();
                break;
            } else {
                System.out.println("Sorry, the vehicle is not in the system");
                System.out.println("Please select the desired option:" + "\n" + " 1-Buy a car from the dealership" + "\n" + " 2-Take vehicles for a test drive" + "\n" + " 3-Resetting the distance traveled by all vehicles" + "\n" + " 4-Changing the flag of all vessels to the information entered by the user " + "\n" + " 5-Exit" + "\n");
                Scanner scanner26 = new Scanner(System.in);
                choice = scanner26.nextInt();
                break;
            }
        }
        case 3: {
            for (int i = 0; i < Agency.get_vehicle().length; i++) {
                Agency.get_vehicle()[i].set_Distance(0);
            }
            System.out.println("Please select the desired option:" + "\n" + " 1-Buy a car from the dealership" + "\n" + " 2-Take vehicles for a test drive" + "\n" + " 3-Resetting the distance traveled by all vehicles" + "\n" + " 4-Changing the flag of all vessels to the information entered by the user " + "\n" + " 5-Exit" + "\n");
            Scanner scanner27 = new Scanner(System.in);
            choice = scanner27.nextInt();
            break;
        }
        case 4: {
            System.out.println("Please type the name of the flag of the country to which the frigate will sail: ");
            Scanner scanner15 = new Scanner(System.in);
            String new_target;
            new_target = scanner15.next();
            for (int i = 0; i < Agency.get_vehicle().length; i++) {
                if ((Agency.get_vehicle()[i] instanceof Marine_transport_vehicle) == true) {

                    ((Marine_transport_vehicle) Agency.get_vehicle()[i]).set_target(new_target);
                }
            }
            System.out.println("Please select the desired option:" + "\n" + " 1-Buy a car from the dealership" + "\n" + " 2-Take vehicles for a test drive" + "\n" + " 3-Resetting the distance traveled by all vehicles" + "\n" + " 4-Changing the flag of all vessels to the information entered by the user " + "\n" + " 5-Exit" + "\n");
            Scanner scanner29 = new Scanner(System.in);
            choice = scanner29.nextInt();
            break;
        }
        case 5: {
            return;
        }
    }
}


    }
}








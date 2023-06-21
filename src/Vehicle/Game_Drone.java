package Vehicle;

import java.io.File;

/**
 * A department representing the air transport vehicle Game Drone
 * Describes their basic features
 */

public class Game_Drone extends Air_transport_vehicles implements Not_motorized_engine {

    /**
     * Default constructor,
     * Calls the default constructor of the class from which it inherits the air transport class
     */
    public Game_Drone() {
        super();
        this.set_Type("toy");
        this.set_Max_Speed(10);
        power_source("manual");
        Energy_score();
    }

    /**
     * Copy constructor,
     * Calls the copy constructor of the class from which it inherits the air transport class
     * @param photo the photo of the Game Drone
     * @param Model_Name-Describes the model name of the vehicle
     * @param move-Describes the ability to move the vehicle
     * @param distance-Describes the distance the vehicle traveled during its lifetime
     * @param Max_Passengers-Describes the maximum number of people that the vehicle can accommodate
     * @param Max_Speed-Describes the maximum speed of the vehicle
     * @param Type-Describes the type of air transport vehicle, whether it is military or civilian
     */
    public Game_Drone(File photo, String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed, String Type,String col) {
        super(photo, Model_Name, move, distance, Max_Passengers, Max_Speed, Type,col);
        power_source("manual");
        Energy_score();

    }

    /**
     * A function that returns the string representing the air transport vehicle Game Drone
     *
     * @return A string that includes the details about the air transport vessel
     * from the toString from which it inherits the air transport vessel class)
     * In addition prints his energy score
     */
    public String toString() {
        return "GAME DRONE: \n" + super.toString() + "The use of the tool: " + get_Type() + ", " + "Model: " + get_Model_Name() + ",  " + "Maximum Passengers: " + get_Max_Passengers() + ", " + "Maximum speed: " + get_Max_Speed() + ", " + "Energy score: " + Energy_score() + "\n";

    }

    /**
     * A function that returns the power source of the air transport vehicle
     *
     * @param x-A variable describing the power source
     * @return A string that is the power source of the air transport vehicle
     */


    public String power_source(String x) {
        return x;
    }

    /**
     * A function that returns the energy score of the air transport vehicle
     *
     * @return Energy score A or B or C
     */
    public String Energy_score() {
        return "A";
    }

    /**
     * Compares this Vehicle.Game_Drone object to another object for equality.
     * Returns true if the other object is also a Vehicle.Game_Drone object and has the same values for all fields, false otherwise.
     * Overrides the equals method of the Object class.
     *
     * @param obj the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Game_Drone)) {
            return false;
        }
        Game_Drone other = (Game_Drone) obj;
        return super.equals(other);
    }

}

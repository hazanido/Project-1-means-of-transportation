package Vehicle;

import Graphic.Maritime;

import java.util.Objects;

public class Cruise_ship extends Marine_transport_vehicle implements Motorized_engine,Commercial_use {
    /**
     * Default constructor,
     * Calls the default constructor of the class from which it inherits the marine transport class
     */

    public Cruise_ship(){
        super();
        set_Because(true);

    }

    /**
     *Copy constructor,
     *Calls the copy constructor of the class from which it inherits the marina transport class
     * @param Model_Name-Describes the model name of the vehicle
     * @param move-Describes the ability to move the vehicle
     * @param distance-Describes the distance the vehicle traveled during its lifetime
     * @param Max_Passengers-Describes the maximum number of people that the vehicle can accommodate
     * @param Max_Speed-Describes the maximum speed of the vehicle
     * @param Because-Describes whether the transport vessel is sailing in the direction of the wind
     * @param target-Describes which country the transport vessel is sailing to
     */
    public Cruise_ship(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,boolean Because,String target){
        super(Model_Name,move,distance,Max_Passengers,Max_Speed,Because,target);
        set_Because(true);
    }
    /**
     *A function that returns the string representing the marine transport vehicle Cruise ship
     *@return A string that includes the details about the marine transport vessel
     * (from the toString from which it inherits the  marine transport vessel class)
     *In addition returns that the Vehicle Cruise ship is Sail downwind
     */

    public String toString(){
        return  "CRUISE SHIP: \n"+ super.toString()+" Sail downwind "+"\n";

    }
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cruise_ship)) {
            return false;
        }
        Cruise_ship other = (Cruise_ship) obj;
        return super.equals(other);
    }





    public float Average_fuel_consumption(){
        return 0;
    }
    public float Average_life_engine(){
        return 0;
    }

    public String license_type(){
        return "Unlimited";
    }
}

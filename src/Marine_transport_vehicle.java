import java.util.Objects;
/**
 *A class that represents the marine transport vehicles
 * and describes their basic features
 */
public class Marine_transport_vehicle extends Vehicle{
    private boolean Because;
    private String target;

    /**
     * Default constructor,
     * Calls the default constructor of the class from which it inherits the transport class
     */

    public Marine_transport_vehicle() {
        super();
        Because = false;
        target = null;
    }

    /**
     *Copy constructor,
     * Calls the copy constructor of the class from which it inherits the transport class
     *@param Model_Name-Describes the model name of the vehicle
     * @param move-Describes the ability to move the vehicle
     * @param distance-Describes the distance the vehicle traveled during its lifetime
     * @param Max_Passengers-Describes the maximum number of people that the vehicle can accommodate
     * @param Max_Speed-Describes the maximum speed of the vehicle
     * @param Because-Describes whether the transport vessel is sailing in the direction of the wind
     * @param target-Describes which country the transport vessel is sailing to
     */


    public Marine_transport_vehicle(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,boolean Because,String target) {
        super(Model_Name, move, distance, Max_Passengers, Max_Speed);
        this.Because = Because;
        this.target = target;
    }


    /**
     * Gets of variables
     */
    public boolean get_Because() {
        return Because;
    }

    public String get_target() {
        return target;
    }

    /**
     * sets of variables
     */
    public void set_Because(boolean Because) {
        this.Because = Because;
    }

    public void set_target(String target) {
        this.target = target;
    }


    /**
     * A function that represents the string of a marine transport object
     * @return A string that includes the details about the transport vessel
     * (from the toString from which it inherits the transport vessel class)
     * In addition whether it is sailing in the direction of the wind
     * and to which country it is sailing
     */
    public String toString(){
        return super.toString()+"Sail with the direction of the wind: "+Because+", "+ "Set sail for the country: "+target+"\n ";
    }

    /**
     *  This function compares two objects for equality.
     *  It overrides the default implementation of the equals method provided by the Object class.
     * @param obj-the object to be compared to the current object
     * @return- boolean
     */


    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Marine_transport_vehicle)) {
            return false;
        }
        Marine_transport_vehicle other = (Marine_transport_vehicle) obj;
        return super.equals(other) &&
                this.Because == other.Because &&
                Objects.equals(this.target, other.target);
    }
}

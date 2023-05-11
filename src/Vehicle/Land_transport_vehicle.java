package Vehicle;

import java.io.File;
import java.util.Objects;
/**
 * A class that represents the land transport vehicles
 * and describes their basic features
 */
public class Land_transport_vehicle extends Vehicle implements Terrestrial_interface{
    private int Number_Wheels;
    private String Kind_Way;

    /**
     * Default constructor,
     * Calls the default constructor of the class from which it inherits the transport class
     */

    public Land_transport_vehicle(){
        super();
        Number_Wheels=0;
        Kind_Way=null;
    }

    /**
     * Copy constructor,
     * Calls the copy constructor of the class from which it inherits the transport class
     *@param Model_Name-Describes the model name of the vehicle
     * @param move-Describes the ability to move the vehicle
     * @param distance-Describes the distance the vehicle traveled during its lifetime
     * @param Max_Passengers-Describes the maximum number of people that the vehicle can accommodate
     * @param Max_Speed-Describes the maximum speed of the vehicle
     * @param Number_Wheels-Describes the number of wheels the car has
     * @param Kind_Way-Describes the type of road the vehicle can travel on
     */
    public Land_transport_vehicle(File photo,String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed, int Number_Wheels, String Kind_Way){
        super(photo,Model_Name,move,distance,Max_Passengers, Max_Speed);
        this.Number_Wheels=Number_Wheels;
        this.Kind_Way=Kind_Way;


    }
    /**
     * Gets of variables
     */
    public int get_Number_Wheels(){
        return Number_Wheels;
    }
    public String get_Kind_Way(){
        return Kind_Way;
    }
    /**
     * sets of variables
     */
    public void set_Number_Wheels(int Number_Wheels){
        this.Number_Wheels=Number_Wheels;
    }
    public void set_Kind_Way(String Kind_Way){
        this.Kind_Way=Kind_Way;
    }

    /**
     * A function that represents the string of a land transport object
     * @return A string that includes the details about the transport vessel
     * (from the toString from which it inherits the transport vessel class)
     * In addition, the number of wheels of the vehicle and the type of road it travels on
     */

    public String toString(){

        return super.toString()+"Number of Wheels: "+Number_Wheels+", "+ "The kind of way: "+Kind_Way+"\n ";
    }

    /**
     *This function is a method of a class that checks whether two objects are equal.
     *  In this case, it checks whether a Vehicle.Vehicle.Land_transport_vehicle object is equal to another object.
     * @param obj-the object to be compared to the current object
     * @return- true if the two objects are equal
     * false if the two objects are not equal
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Land_transport_vehicle)) {
            return false;
        }
        Land_transport_vehicle other = (Land_transport_vehicle) obj;
        return super.equals(obj) &&
                Number_Wheels == other.Number_Wheels &&
                Objects.equals(Kind_Way, other.Kind_Way);
    }

}

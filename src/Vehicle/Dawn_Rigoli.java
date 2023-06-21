package Vehicle;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.util.Objects;
/**
 *A department representing the air transport vehicle Dawn Rigoli
 *Describes their basic features
 */
public class Dawn_Rigoli extends Air_transport_vehicles implements Not_motorized_engine {
    /**
     * A function that returns the power source of the air transport vehicle
     * @param x-A variable describing the power source
     * @return A string that is the power source of the air transport vehicle
     */
    public String power_source(String x){
        return x;
    }

    /**
     *A function that returns the energy score of the air transport vehicle
     * @return Energy score A or B or C
     */
    public String Energy_score(){
        return "C";
    }
    /**
     * Default constructor,
     * Calls the default constructor of the class from which it inherits the air transport class
     */
    public Dawn_Rigoli() {
        super();
        set_Type("Military") ;
        set_Max_Passengers(1);
        set_Model_Name("privileged");
        set_Max_Speed(50);
        Energy_score();
        power_source("manual");
    }



    /**
     * Copy constructor,
     * Calls the copy constructor of the class from which it inherits the air transport class
     * @param photo the photo of the Dawn Rigoli
     *@param Model_Name-Describes the model name of the vehicle
     *@param move-Describes the ability to move the vehicle
     *@param distance-Describes the distance the vehicle traveled during its lifetime
     *@param Max_Passengers-Describes the maximum number of people that the vehicle can accommodate
     *@param Max_Speed-Describes the maximum speed of the vehicle
     *@param Type-Describes the type of air transport vehicle, whether it is military or civilian
     */
    public Dawn_Rigoli(File photo, String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed, String Type,String col) {
        super(photo,Model_Name,move,distance,Max_Passengers,Max_Speed,Type,col);
        set_Type(Type) ;
        set_Max_Passengers(1);
        set_Model_Name(Model_Name);
        set_Max_Speed(Max_Speed);
        Energy_score();
        power_source("manual");
    }

    /**
     *A function that returns the string representing the air transport vehicle Dawn Rigoli
     * @return A string that includes the details about the air transport vessel
     *(from the toString from which it inherits the air transport vessel class)
     * In addition prints his energy score
     */
    public String toString() {
        return "DAWN RIGOLI: \n"+ super.toString()+"The use of the tool: " + get_Type() + ", " + "Model: " + get_Model_Name() + ",  " + "Maximum Passengers: " + get_Max_Passengers() + ", " + "Maximum speed: " + get_Max_Speed() + "km, " + "Energy score: " + Energy_score() +"\n";
    }
    /**

     Compares this Vehicle.Dawn_Rigoli object to another object for equality.
     Returns true if the other object is also a Vehicle.Dawn_Rigoli object and has the same values for all fields, false otherwise.
     Overrides the equals method of the Object class.
     @param obj the object to compare to
     @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Dawn_Rigoli)) {
            return false;
        }
        Dawn_Rigoli other = (Dawn_Rigoli) obj;
        return super.equals(other)
                && Objects.equals(this.Energy_score(), other.Energy_score())
                && Objects.equals(this.power_source("manual"), other.power_source("manual"));
    }

}
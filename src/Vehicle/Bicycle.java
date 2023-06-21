package Vehicle;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public abstract class Bicycle extends Land_transport_vehicle {
    /**
     * Default constructor,
     *Calls the default constructor of the class from which it inherits the land vehicles class
     */

    public Bicycle(){
        super();
        set_Number_Wheels(2);
    }

    /**
     * Copy constructor,
     * Calls the copy constructor of the class from which it inherits the land transport vehicle Vehicle.Bicycle
     * @param photo the photo of the bicycle
     *@param Model_Name-Describes the model name of the vehicle
     *@param move-Describes the ability to move the vehicle
     * @param distance-Describes the distance the vehicle traveled during its lifetime
     * @param Max_Speed-Describes the maximum speed of the vehicle
     * @param Number_Wheels-The number of wheels the car has
     * @param Kind_Way-Describes the type of road the vehicle can travel on
     */
    public Bicycle(File photo,String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed, int Number_Wheels, String Kind_Way,String col){
        super(photo,Model_Name,move,distance,Max_Passengers,Max_Speed,Number_Wheels,Kind_Way,col);
        this.set_Number_Wheels(2);

    }

    public String toString(){
        super.toString();

        return "BICYCLE:\n"+ super.toString()+ ", Number Wheels:" +this.get_Number_Wheels()+"\n ";
    }


    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bicycle)) {
            return false;
        }
        Bicycle other = (Bicycle) obj;
        return super.equals(other) && Objects.equals(this.get_Number_Wheels(), other.get_Number_Wheels());
    }


}

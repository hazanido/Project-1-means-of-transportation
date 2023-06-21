package Vehicle;

import java.io.File;
import java.util.Objects;
/**
 *A department representing the land transport vehicle Vehicle.Jeep
 *Describes their basic features
 */

public class Jeep extends Land_transport_vehicle implements Motorized_engine, Commercial_use {

    /**
     * Default constructor,
     *Calls the default constructor of the class from which it inherits the land vehicles class
     */
    public Jeep()
    {
        super();
        this.set_Number_Wheels(4);
        this.set_Kind_Way("dirt");
        this.set_Max_Passengers(5);

    }
    /**
     *Copy constructor,
     *Calls the copy constructor of the class from which it inherits the land transport vehicle Vehicle.Jeep
     * @param photo the photo of the Jeep
     * @param Model_Name-Describes the model name of the vehicle
     * @param move-Describes the ability to move the vehicle
     * @param distance-Describes the distance the vehicle traveled during its lifetime
     * @param Max_Speed-Describes the maximum speed of the vehicle
     */

    public Jeep(File photo,String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed, int Number_Wheels, String Kind_Way,String col){
        super(photo,Model_Name,move,distance,Max_Passengers,Max_Speed,Number_Wheels,Kind_Way,col);
        this.set_Number_Wheels(4);
        this.set_Kind_Way("dirt");
        this.set_Max_Passengers(5);
    }

    /**
     *
     * @param Model_Name-Describes the model name of the vehicle
     * @param move-Describes the ability to move the vehicle
     * @param distance-Describes the distance the vehicle traveled during its lifetime
     * @param Max_Speed-Describes the maximum speed of the vehicle
     */
    public Jeep (File photo,String Model_Name,int move, double distance,double Max_Speed) {
        this.set_photo(photo);
        this.set_Move(move);
        this.set_Model_Name(Model_Name);
        this.set_Number_Wheels(4);
        this.set_Kind_Way("dirt");
        this.set_Max_Passengers(5);
        this.set_Distance(distance);
        this.set_Max_Speed(Max_Speed);
    }

    /**
     *The function represents a string of the Vehicle.Jeep transport vehicle
     * @return A string that returns the details about the land transportation vehicle jeep
     * (from the toString from which it inherits the land transport vessel class)
     */

    public String toString(){
        super.toString();

        return "JEEP:\n"+ super.toString()+ ", " +license_type()+"\n ";
    }

    /**
     *
     * @return
     */
    public float Average_fuel_consumption() {
        return 0;
    }

    /**
     *
     * @return
     */

    public float Average_life_engine() {
        return 0;
    }

    public String license_type(){
        return "license type: Mini ";

    }
    /**

     Overrides the default equals method inherited from Object class to compare if two Vehicle.Jeep objects have equal values
     for their attributes.
     @param o the object to compare with the current Vehicle.Jeep object
     @return true if the two Vehicle.Jeep objects are equal, false otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Jeep)) {
            return false;
        }
        Jeep jeep = (Jeep) o;
        return Objects.equals(get_Model_Name(), jeep.get_Model_Name()) &&
                get_move() == jeep.get_move() &&
                Double.compare(jeep.get_distance(), get_distance()) == 0 &&
                get_Max_Passengers() == jeep.get_Max_Passengers() &&
                Double.compare(jeep.get_Max_Speed(), get_Max_Speed()) == 0 &&
                get_Number_Wheels() == jeep.get_Number_Wheels() &&
                Objects.equals(get_Kind_Way(), jeep.get_Kind_Way());
    }




}

/**
 *A department representing the land transport vehicle Jeep
 *Describes their basic features
 */

public class Jeep extends Land_transport_vehicle implements Motorized_engine,Commercial_use {
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
     *Calls the copy constructor of the class from which it inherits the land transport vehicle Jeep
     * @param Model_Name-Describes the model name of the vehicle
     * @param move-Describes the ability to move the vehicle
     * @param distance-Describes the distance the vehicle traveled during its lifetime
     * @param Max_Speed-Describes the maximum speed of the vehicle
     */

    public Jeep(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,int Number_Wheels,String Kind_Way){
        super(Model_Name,move,distance,Max_Passengers,Max_Speed,Number_Wheels,Kind_Way);
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
    public Jeep (String Model_Name,int move, double distance,double Max_Speed) {
        this.set_Move(move);
        this.set_Model_Name(Model_Name);
        this.set_Number_Wheels(4);
        this.set_Kind_Way("dirt");
        this.set_Max_Passengers(5);
        this.set_Distance(distance);
        this.set_Max_Speed(Max_Speed);
    }

    /**
     *The function represents a string of the Jeep transport vehicle
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


}

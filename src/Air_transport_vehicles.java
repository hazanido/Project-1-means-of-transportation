/**
 * A class that represents the air transport vehicles and
 * describes their basic features
 */
public class Air_transport_vehicles extends Vehicle{
    private String Type;

    /**
     * Default constructor,
     * Calls the default constructor of the class from which it inherits the transport class
     */

    public Air_transport_vehicles() {
        super();
        Type = null;
    }

    /**
     *Copy constructor,
     *Calls the copy constructor of the class from which it inherits the transport class
     *@param Model_Name-Describes the model name of the vehicle
     *@param move-Describes the ability to move the vehicle
     *@param distance-Describes the distance the vehicle traveled during its lifetime
     *@param Max_Passengers-Describes the maximum number of people that the vehicle can accommodate
     *@param Max_Speed-Describes the maximum speed of the vehicle
     *@param Type-Describes the type of air transport vehicle, whether it is military or civilian
     */
    public Air_transport_vehicles(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,String Type)
    {
        super(Model_Name,move,distance,Max_Passengers,Max_Speed);
        this.Type=Type;
    }

    /**
     *A function that represents the string of an air transport object
     *@return A string that includes the details about the transport vessel
     *(from the toString from which it inherits the transport vessel class)
     *In addition, what type of vehicle is this: military or civilian?
     */

    public String toString() {
        return super.toString() + "The use of the tool: " + Type + "\n ";
    }

    /**
     * get of the type variable
     * @return the variable type
     */
    public String get_Type(){
    return Type;
    }

    /**
     * set of the type variable
     * @param Type-Describes the type of air transport vehicle, whether it is military or civilian
     */
    public void set_Type(String Type){
    this.Type=Type;
    }
}


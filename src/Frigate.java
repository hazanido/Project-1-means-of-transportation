import java.util.Objects;

/**
 *A department representing the marine transport vehicle Frigate
 * Describes their basic features
 */
public class Frigate extends Marine_transport_vehicle implements Motorized_engine {

    private String origin;
    private float Fuel_consumption;
    private float lifetime;

    /**
     * Default constructor,
     * Calls the default constructor of the class from which it inherits the marine transport class
     */
    public Frigate(){
        super();
        origin="Under Israel flag";
        Fuel_consumption= 500;
        lifetime=4;
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
    public Frigate(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,boolean Because,String target){
        super(Model_Name,move,distance,Max_Passengers,Max_Speed,Because,target);
        origin="Under Israel flag";
        Fuel_consumption= 500;
        lifetime=4;
    }

    /**
     *A function that returns the string representing the marine transport vehicle Frigate
     *@return A string that includes the details about the marine transport vessel
     * (from the toString from which it inherits the  marine transport vessel class)
     *In addition returns that the Frigate is under the Israeli flag, with the wind returns average fuel consumption and average life span
     */
    public String toString(){

        return  "FRIGATE: \n"+ super.toString()+"Under Israel flag, with the wind. Engine: "+Fuel_consumption+", "+ ", lifetime of "+lifetime+" years."+"\n";
    }
    public float Average_fuel_consumption(){
        return Fuel_consumption;

    }
    public float Average_life_engine(){
        return lifetime;
    }
    /**

     Compares this Frigate object to another object for equality.
     Returns true if the given object is also a Frigate and all of their fields are equal.
     Overrides the equals method in the Object class.
     @param obj The object to compare this Frigate object against.
     @return True if the given object is also a Frigate and all of their fields are equal,
     arduino
     Copy code
     false otherwise.
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Frigate)) {
            return false;
        }
        Frigate other = (Frigate) obj;
        return super.equals(other)
                && Objects.equals(this.origin, other.origin)
                && Float.compare(this.Fuel_consumption, other.Fuel_consumption) == 0
                && Float.compare(this.lifetime, other.lifetime) == 0;
    }
}

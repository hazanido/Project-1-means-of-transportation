package Vehicle;

import java.io.File;
import java.util.Objects;

public class Amphibious_vehicle extends Marine_transport_vehicle implements Terrestrial_interface,Motorized_engine {
    private Land_transport_vehicle land;

    /**
     * Default constructor for Amphibious_vehicle.
     */
    public Amphibious_vehicle() {
        super();
        land = new Land_transport_vehicle();
        land.set_Kind_Way("paved");
    }

    /**
     * Constructor for Amphibious_vehicle.
     * @param photo         A File object representing a photo of the vehicle.
     * @param Model_Name    A String representing the name of the model.
     * @param move          An int representing the type of movement (land, sea, or air).
     * @param distance      A double representing the distance the vehicle can travel.
     * @param Max_Passengers An int representing the maximum number of passengers the vehicle can hold.
     * @param Max_Speed     A double representing the maximum speed of the vehicle.
     * @param Because       A boolean representing whether the vehicle is used for leisure or not.
     * @param target        A String representing the target of the vehicle.
     */
    public Amphibious_vehicle(File photo, String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed, boolean Because, String target) {
        super(photo, Model_Name, move, distance, Max_Passengers, Max_Speed, Because, target);
        land = new Land_transport_vehicle();
        land.set_Kind_Way("paved");

    }

    /**
     * Returns the number of wheels on the vehicle.
     * @return An int representing the number of wheels.
     */
    public int get_Number_Wheels() {
        return land.get_Number_Wheels();
    }

    /**
     * Returns the kind of way the vehicle is intended to be used on (e.g. paved, dirt).
     * @return A String representing the kind of way.
     */
    public String get_Kind_Way() {
        return land.get_Kind_Way();
    }

    /**
     * Sets the number of wheels on the vehicle.
     * @param Number_Wheels An int representing the new number of wheels.
     */
    public void set_Number_Wheels(int Number_Wheels) {
        this.land.set_Number_Wheels(Number_Wheels);
    }

    /**
     * Sets the kind of way the vehicle is intended to be used on (e.g. paved, dirt).
     * @param Kind_Way A String representing the new kind of way.
     */
    public void set_Kind_Way(String Kind_Way) {
        this.land.set_Kind_Way(Kind_Way);
    }

    /**
     * Returns the average fuel consumption of the vehicle.
     * @return A float representing the average fuel consumption.
     */
    public float Average_fuel_consumption(){
        return 0;
    }

    /**
     * Returns the average life of the engine of the vehicle.
     * @return A float representing the average life of the engine.
     */
    public float Average_life_engine(){
        return 0;
    }


    /**
     * Returns a String representation of the Amphibious_vehicle object.
     * @return A String representing the object.
     */
    public String toString() {
        return "AMPHIBIOUS:\n" + super.toString() + ", " + " Number of Wheels: " + get_Number_Wheels() + ", " + "The kind of way: " + get_Kind_Way() + "\n ";

    }


    /**
     * Compares the Amphibious_vehicle object to another object.
     */

    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Amphibious_vehicle)) {
            return false;
        }
        Amphibious_vehicle other = (Amphibious_vehicle) obj;
        return super.equals(obj) &&
                get_Number_Wheels() == other.get_Number_Wheels() &&
                Objects.equals(get_Kind_Way(), other.get_Kind_Way());
    }
}

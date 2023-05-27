package Vehicle;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;
public abstract class Vehicle {
    private File photo;
    private String Model_Name;
    private int move;
    private double distance;
    private int Max_Passengers;
    private double Max_Speed;

    /**
     * Default constructor
     */

    public Vehicle() {
        photo=null;
        Model_Name = null;
        move = 0;
        distance = 0;
        Max_Passengers = 0;
        Max_Speed = 0;
    }

    /**
     * Copy constructor
     *
     * @param Model_Name-Describes the model name of the vehicle
     * @param move-Describes the ability to move the vehicle
     * @param distance-Describes the distance the vehicle traveled during its lifetime
     * @param Max_Passengers-Describes the maximum number of people that the vehicle can accommodate
     * @param Max_Speed-Describes the maximum speed of the vehicle
     */

    public Vehicle(File photo,String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed) {
        this.photo=photo;
        this.Model_Name = Model_Name;
        this.move = move;
        this.distance = distance;
        this.Max_Passengers = Max_Passengers;
        this.Max_Speed = Max_Speed;
    }

    /**
     * Gets of variables
     */
    public File get_Photo(){return this.photo;}
    public String get_Model_Name() {
        return this.Model_Name;
    }

    public int get_move() {
        return this.move;
    }

    public double get_distance() {
        return this.distance;
    }

    public int get_Max_Passengers() {
        return this.Max_Passengers;
    }

    public double get_Max_Speed() {
        return this.Max_Speed;
    }

    /**
     * sets of variables
     */

    public void set_photo(File photo){this.photo=photo;}
    public void set_Model_Name(String Model_Name) {
        this.Model_Name = Model_Name;
    }

    public void set_Move(int move) {
        this.move = move;
    }

    public void set_Distance(double distance) {
        this.distance = distance;
    }

    public void set_Max_Passengers(int Max_Passengers) {
        this.Max_Passengers = Max_Passengers;
    }

    public void set_Max_Speed(double Max_Speed) {
        this.Max_Speed = Max_Speed;
    }

    /**
     * A function that represents the string of the transport object
     * @return A string that includes the details about the means of transportation:
     * the name of the model, its ability to move,
     * the distance traveled, maximum passenger capacity and maximum speed
     */

    public String toString() {
        return "Model: " + Model_Name + ", " + "move: " + move + "\n " + " traveled: " + distance + " Km" + ",  " + "Maximum Passengers: " + Max_Passengers + ", " + "Max speed: " + Max_Speed +"km, ";
    }

    /**
     * Compares this Vehicle.Vehicle object to another object for equality.
     * Returns true if the other object is also a Vehicle.Vehicle object and has the same values for all fields, false otherwise.
     * Overrides the equals method of the Object class.
     * @param obj the object to compare to
     * @return true if the objects are equal, false otherwise
     */

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return Objects.equals(this.Model_Name, other.Model_Name)
                && this.move == other.move
                && Double.compare(this.distance, other.distance) == 0
                && this.Max_Passengers == other.Max_Passengers
                && Double.compare(this.Max_Speed, other.Max_Speed) == 0;
    }










}
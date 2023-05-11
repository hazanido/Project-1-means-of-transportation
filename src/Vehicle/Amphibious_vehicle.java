package Vehicle;

import java.io.File;
import java.util.Objects;

public class Amphibious_vehicle extends Marine_transport_vehicle implements Terrestrial_interface,Motorized_engine {
    private Land_transport_vehicle land;

    public Amphibious_vehicle() {
        super();
        land = new Land_transport_vehicle();
        land.set_Kind_Way("paved");
    }

    public Amphibious_vehicle(File photo, String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed, boolean Because, String target) {
        super(photo, Model_Name, move, distance, Max_Passengers, Max_Speed, Because, target);


    }


    public int get_Number_Wheels() {
        return land.get_Number_Wheels();
    }

    public String get_Kind_Way() {
        return land.get_Kind_Way();
    }

    public void set_Number_Wheels(int Number_Wheels) {
        this.land.set_Number_Wheels(Number_Wheels);
    }

    public void set_Kind_Way(String Kind_Way) {
        this.land.set_Kind_Way(Kind_Way);
    }

    public float Average_fuel_consumption(){
        return 0;
    }
    public float Average_life_engine(){
        return 0;
    }


    public String toString() {
        return "AMPHIBIOUS:\n" + super.toString() + ", " + " Number of Wheels: " + get_Number_Wheels() + ", " + "The kind of way: " + get_Kind_Way() + "\n ";

    }

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

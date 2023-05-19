package Vehicle;

import java.util.Objects;

public class Hybrid_plane extends Air_transport_vehicles implements Terrestrial_interface,Maritime_interface,Motorized_engine{
    private Land_transport_vehicle land;
    private Marine_transport_vehicle marine;
    public boolean get_Because(){return marine.get_Because();}
    public String get_target(){return marine.get_target();}
    public void set_Because(boolean Because){this.marine.set_Because(Because); }
    public void set_target(String target){this.marine.set_target(target);}
    public int get_Number_Wheels(){return land.get_Number_Wheels();}
    public String get_Kind_Way(){return land.get_Kind_Way();}
    public void set_Number_Wheels(int Number_Wheels){this.land.set_Number_Wheels(Number_Wheels);}
    public void set_Kind_Way(String Kind_Way){this.land.set_Kind_Way(Kind_Way);}
    public float Average_fuel_consumption(){return 0;}
    public float Average_life_engine(){return 0;}
    public String toString(){return "HYBRID PLANE:\n"+super.toString()+", "+"Average fuel consumption: "+Average_fuel_consumption()+", "+ "Average life engine:  "+Average_life_engine()+" years."+", " + " Number of Wheels: " + get_Number_Wheels() + ", " + "The kind of way: " + get_Kind_Way() + "\n ";}
    public boolean equals(Object obj){
        if (obj == this) {
        return true;
    }
        if (!(obj instanceof Hybrid_plane)) {
            return false;
        }
        Hybrid_plane other = (Hybrid_plane) obj;
        return super.equals(obj) &&
                get_Number_Wheels() == other.get_Number_Wheels() &&
                Objects.equals(get_Kind_Way(), other.get_Kind_Way())&&
                get_Because()==other.get_Because() &&
                get_target()==other.get_target() ;

    }

}

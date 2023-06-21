package Vehicle;

import java.io.File;
import java.util.Objects;

public class Hybrid_plane extends Amphibious_vehicle implements Air_interface{

    private Air_transport_vehicles air;

    public Hybrid_plane(){
        super();
        air=new Air_transport_vehicles();
        air.set_Type("military");


    }

    public Hybrid_plane(File photo, String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed, boolean Because, String target,String col){
        super(photo, Model_Name, move, distance, Max_Passengers, Max_Speed, Because, target,col);
        air=new Air_transport_vehicles();
        air.set_Type("military");


    }

    public String get_Type(){return air.get_Type();}
    public void set_Type(String Type){this.air.set_Type(Type);}
    public String toString(){return "HYBRID PLANE:\n"+super.toString()+", "+"Type: "+air.get_Type()+"\n ";}
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

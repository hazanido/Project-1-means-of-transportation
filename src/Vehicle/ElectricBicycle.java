package Vehicle;

import java.io.File;
import java.util.Objects;

public class ElectricBicycle extends Bicycle implements Motorized_engine {


    /**
     * Default constructor,
     *Calls the default constructor of the class from which it inherits the land vehicles class
     */
    public ElectricBicycle(){
        super();

    }
    public ElectricBicycle(File photo, String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed, int Number_Wheels, String Kind_Way,String col){
        super(photo,Model_Name,move,distance,Max_Passengers,Max_Speed,Number_Wheels,Kind_Way,col);

    }
    public String toString(){
        super.toString();

        return "ELECTRIC BICYCLE:\n"+ super.toString()+ ", Average fuel consumption:" +Average_fuel_consumption()+", Average life engine: "+Average_life_engine()+"\n ";
    }


    public float Average_fuel_consumption(){
        return 20;
    }
    public float Average_life_engine(){
        return 0;
    }
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElectricBicycle)) {
            return false;
        }
        ElectricBicycle other = (ElectricBicycle) obj;
        return super.equals(other) && Objects.equals(this.get_Number_Wheels(), other.get_Number_Wheels());
    }
}

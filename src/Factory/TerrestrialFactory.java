package Factory;

import Graphic.Vehicle_gui.Terrestrial;
import Vehicle.*;

public class TerrestrialFactory implements VehicleFactory{
    private Terrestrial terrestrial;
    private Vehicle vehicle;
    public TerrestrialFactory(){
        terrestrial=new Terrestrial(this);
        vehicle=null;
    }
    public Vehicle produceVehicle(){
        String chosenTerrestrial=terrestrial.getSelectedTerrestrial();
        if(chosenTerrestrial.equals("Jeep")){
            vehicle=new Jeep();
        }
        else if(chosenTerrestrial.equals("Amphibious")){
            vehicle=new Amphibious_vehicle();
        }
        else if(chosenTerrestrial.equals("Bicycle")){
            vehicle=new NonMotorizedBicycle();
        }
        else if(chosenTerrestrial.equals("Electric_Bicycle")){
            vehicle=new ElectricBicycle();
        }
        else if (chosenTerrestrial.equals("hybrid_plane")) {
            vehicle = new Hybrid_plane();
        }
        return vehicle;

    }
}

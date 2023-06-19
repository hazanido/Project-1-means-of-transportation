package Factory;

import Graphic.Vehicle_gui.Maritime;
import Vehicle.*;

public class MaritimeFactory implements VehicleFactory {
    private Maritime maritime;
    private Vehicle vehicle;
    public MaritimeFactory(){
        maritime=new Maritime(this);
        vehicle=null;

    }
    public Vehicle produceVehicle(){
        String chosenMaritime=maritime.getSelectedMaritime();
        if (chosenMaritime != null) {
            if(chosenMaritime.equals("Frigate")){
                vehicle=new Frigate();
            }
            else if(chosenMaritime.equals("Cruz")){
                vehicle=new Cruise_ship();
            }
            else if(chosenMaritime.equals("Amphibious")){
                vehicle=new Amphibious_vehicle();
            }
            else if (chosenMaritime.equals("hybrid_plane")) {
                vehicle = new Hybrid_plane();
            }
        }

        return vehicle;


    }
}

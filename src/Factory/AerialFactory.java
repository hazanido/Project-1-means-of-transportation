package Factory;


import Graphic.Vehicle_gui.Aerial;
import Graphic.Vehicle_gui.Type_Vehicle;
import Vehicle.*;

public class AerialFactory implements VehicleFactory{
    //private final String[] aerial={"dawn_rigoli","game_drone","hybrid_plane"};
    private Aerial aerial;
    private Vehicle vehicle;

    public AerialFactory(){
        aerial = new Aerial(this);
        vehicle = null;
    }

    public Vehicle produceVehicle(){
        String chosenAerial = aerial.getSelectedAerial();

        if (chosenAerial.equals("dawn_rigoli")) {
            vehicle = new Dawn_Rigoli();
        }
        else if (chosenAerial.equals("game_drone")) {
            vehicle = new Game_Drone();

        }
        else if (chosenAerial.equals("hybrid_plane")) {
            vehicle = new Hybrid_plane();
        }
        return vehicle;

    }
}


public class Marine_transport_vehicle extends Vehicle{

    private boolean Because;
    private String target;

public Marine_transport_vehicle() {
    super();
    Because=false;
    target=null;
}

public Marine_transport_vehicle(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,boolean Because,String target) {
    super(Model_Name,move,distance,Max_Passengers,Max_Speed);
    this.Because=Because;
    this.target=target;
}
    // Gets of variables
public boolean get_Because(){
    return Because;
}
public String get_target(){
    return target;
}
    // sets of variables
public void set_Because(boolean Because){
    this.Because=Because;
}
public void set_target(String target){
    this.target=target;
}
    public String toString(){

        return "Sail with the direction of the wind: "+Because+"\n "+ "Set sail for the country: "+target+"\n ";
    }
}

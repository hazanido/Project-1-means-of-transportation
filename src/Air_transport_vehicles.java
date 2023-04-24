public class Air_transport_vehicles extends Vehicle{
    private String Type;

public Air_transport_vehicles(){
    super();
    Type=null;
}
    public Air_transport_vehicles(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,String Type)
    {
        super(Model_Name,move,distance,Max_Passengers,Max_Speed);
        this.Type=Type;
    }

    public String toString(){

        return "The use of the tool: "+Type+"\n ";
    }
    public String get_Type(){
    return Type;
    }
    public void set_Type(String Type){
    this.Type=Type;
    }
}

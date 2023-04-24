public class Foot_Glider extends Air_transport_vehicles implements Not_motorized_engine {



    public String power_source(){
        return null;
    }
    public String Energy_score(){
        return "C";
    }
    public Foot_Glider() {
        super();
        set_Type("Military") ;
        set_Max_Passengers(1);
        set_Model_Name("privileged");
        set_Max_Speed(50);
        Energy_score();
    }
    public Foot_Glider(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,String Type) {
        super(Model_Name,move,distance,Max_Passengers,Max_Speed,Type);
        Type = "Military";
        Max_Passengers = 1;
        Model_Name = "privileged";
        Max_Speed = 50;
        Energy_score();
    }

    public String toString() {

        return "The use of the tool: " + get_Type() + "\n " + "Model: " + get_Model_Name() + "\n " + "Maximum Passengers: " + get_Max_Passengers() + "\n " + "Maximum speed: " + get_Max_Speed() + "\n " + "Energy score: " + Energy_score() + "\n";
    }

}
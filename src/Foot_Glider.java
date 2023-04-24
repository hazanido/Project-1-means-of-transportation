public class Foot_Glider extends Air_transport_vehicles implements Not_motorized_engine {



    public String power_source(String x){
        return x;
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
        power_source("manual");
    }
    public Foot_Glider(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,String Type) {
        super(Model_Name,move,distance,Max_Passengers,Max_Speed,Type);
        set_Type("Military") ;
        set_Max_Passengers(1);
        set_Model_Name("privileged");
        set_Max_Speed(50);
        Energy_score();
        power_source("manual");

    }

    public String toString() {
        return "FOOT GLIDER: \n"+ super.toString()+"The use of the tool: " + get_Type() + ", " + "Model: " + get_Model_Name() + ",  " + "Maximum Passengers: " + get_Max_Passengers() + ", " + "Maximum speed: " + get_Max_Speed() + ", " + "Energy score: " + Energy_score() +"\n";
    }

}
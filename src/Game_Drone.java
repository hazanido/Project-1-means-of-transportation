public class Game_Drone extends Air_transport_vehicles implements Not_motorized_engine{

    public Game_Drone(){
        super();
        this.set_Type("toy");
        this.set_Max_Speed(10);
        power_source("manual");
        Energy_score();
    }
    public Game_Drone(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,String Type)
    {
        super(Model_Name,move,distance,Max_Passengers,Max_Speed,Type);
        power_source("manual");
        Energy_score();

    }



    public String power_source(String x){
        return x;
    }
    public String Energy_score(){
        return "A";
    }
}

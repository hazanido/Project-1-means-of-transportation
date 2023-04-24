public class Frigate extends Marine_transport_vehicle{

    private String origin;
    private int Fuel_consumption;
    private int lifetime;

    public Frigate(){
        super();
        origin="Under Israel flag";
        Fuel_consumption= 500;
        lifetime=4;
    }
    public Frigate(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,boolean Because,String target){
        super(Model_Name,move,distance,Max_Passengers,Max_Speed,Because,target);
        origin="Under Israel flag";
        Fuel_consumption= 500;
        lifetime=4;
    }
    public String toString(){

        return  "FRIGATE: \n"+ super.toString()+"Under Israel flag, with the wind. Engine: "+Fuel_consumption+", "+ ", lifetime of "+lifetime+" years."+"\n";
    }
}

public class Jeep extends Land_transport_vehicle implements Motorized_engine {
    public Jeep()
    {
        super();
        this.set_Number_Wheels(4);
        this.set_Kind_Way("dirt");
        this.set_Max_Passengers(5);

    }
    public Jeep(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,int Number_Wheels,String Kind_Way){
        super(Model_Name,move,distance,Max_Passengers,Max_Speed,Number_Wheels,Kind_Way);
        this.set_Number_Wheels(4);
        this.set_Kind_Way("dirt");
        this.set_Max_Passengers(5);
    }
    public Jeep (String Model_Name,int move, double distance,double Max_Speed){
        this.set_Move(move);
        this.set_Model_Name(Model_Name);
        this.set_Number_Wheels(4);
        this.set_Kind_Way("dirt");
        this.set_Max_Passengers(5);
        this.set_Distance(distance);
        this.set_Max_Speed(Max_Speed);
}
    public String toString(){

        return "Number of Wheels: "+get_Number_Wheels()+"\n "+ "The kind of way: "+get_Kind_Way()+"\n "+"Max Passengers: "+ get_Max_Passengers()+"\n ";
    }
    public double Average_fuel_consumption() {
        return 0;
    }


    public double Average_life_engine() {
        return 0;
    }

}

public class Land_transport_vehicle extends Vehicle {
    private int Number_Wheels;
    private String Kind_Way;

    public Land_transport_vehicle(){
        super();
        Number_Wheels=0;
        Kind_Way=null;
    }
    public Land_transport_vehicle(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed,int Number_Wheels,String Kind_Way){
        super(Model_Name,move,distance,Max_Passengers, Max_Speed);
        this.Number_Wheels=Number_Wheels;
        this.Kind_Way=Kind_Way;
    }
    // Gets of variables
    public int get_Number_Wheels(){
        return Number_Wheels;
    }
    public String get_Kind_Way(){
        return Kind_Way;
    }
    // sets of variables
    public void set_Number_Wheels(int Number_Wheels){
        this.Number_Wheels=Number_Wheels;
    }
    public void set_Kind_Way(String Kind_Way){
        this.Kind_Way=Kind_Way;
    }

    public String toString(){

        return "Number of Wheels: "+Number_Wheels+"\n "+ "The kind of way: "+Kind_Way+"\n ";
    }
}

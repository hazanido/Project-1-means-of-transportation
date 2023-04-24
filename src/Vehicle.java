public abstract class Vehicle {
    private String Model_Name;
    private int move;
    private double distance;
    private int Max_Passengers;
    private double Max_Speed;


    public Vehicle() {
        Model_Name = null;
        move = 0;
        distance = 0;
        Max_Passengers = 0;
        Max_Speed = 0;
    }

    public Vehicle(String Model_Name, int move, double distance, int Max_Passengers, double Max_Speed) {
        this.Model_Name = Model_Name;
        this.move = move;
        this.distance = distance;
        this.Max_Passengers = Max_Passengers;
        this.Max_Speed = Max_Speed;
    }
   // Gets of variables
    public String get_Model_Name(){
        return this.Model_Name;
    }
    public int get_move(){
        return this.move;
    }
    public double get_distance(){
        return this.distance;
    }
    public int get_Max_Passengers(){
        return this.Max_Passengers;
    }
    public double get_Max_Speed(){
        return this.Max_Speed;
    }
    // sets of variables
    public void set_Model_Name(String Model_Name){
        this.Model_Name=Model_Name;
    }
    public void set_Move(int move){
        this.move=move;
    }
    public void set_Distance(double distance){
        this.distance=distance;
    }
    public void set_Max_Passengers(int Max_Passengers){
        this.Max_Passengers=Max_Passengers;
    }
    public void set_Max_Speed(double Max_Speed){
        this.Max_Speed=Max_Speed;
    }

    public String toString(){
        return "Model: "+Model_Name+ ", " + "move: " + move+"\n "+" traveled: "+distance+" Km"+",  " +"Maximum Passengers: "+Max_Passengers+", "+"Max speed: "+Max_Speed;
    }
}
public class Car_Agency {
    private int size;
    private Vehicle[] vehicle;

    public Vehicle[] get_vehicle(){
        return vehicle;
    }
    public Car_Agency(){
        vehicle= new Vehicle[size];
        size=0;
    }
    public Car_Agency(int size, Vehicle[] vehicle){
        this.size=size;
        this.vehicle=vehicle;
    }

    public void add_Vehicle(Vehicle car){
        if(size==0){
            size=1;
            vehicle= new Vehicle[size];
            vehicle[0]=car;


        }
        else{
            Vehicle[] temp = new Vehicle[size];
            for(int i = 0 ;i<size;i++)
            {
                temp[i]=vehicle[i];
            }
            size++;
            vehicle=new Vehicle[size];
            for(int i = 0 ;i<this.size-1;i++)
            {
                this.vehicle[i]=temp[i];
            }
            this.vehicle[size-1]=car;

        }
    }
    public void print(){
        for(int i=0;i<size;i++)
        {
            System.out.println(vehicle[i].toString()+"\n");
        }

    }
    public boolean vehicle_exists(String model,int move,double dic,int p_m,double s_m){
        for (int i=0;i<size;i++) {
            if ((vehicle[i].get_Model_Name() == model) && (vehicle[i].get_move() == move) && (vehicle[i].get_distance() == dic) && (vehicle[i].get_Max_Passengers() == p_m) && (vehicle[i].get_Max_Speed() == s_m)) {
                return true;
            }
        }
            return false;

    }

    public int indexOf(String model,int move,double dic,int p_m,double s_m){
        int ans=-1;
        for (int i=0;(i<size)&&(ans==-1);i++) {
            if ((vehicle[i].get_Model_Name() == model) && (vehicle[i].get_move() == move) && (vehicle[i].get_distance() == dic) && (vehicle[i].get_Max_Passengers() == p_m) && (vehicle[i].get_Max_Speed() == s_m)) {
                ans=i;
            }
        }
        return ans;

    }

    public void remove(String model,int move,double dic,int p_m,double s_m) {
        for (int i = 0; i < size; i++) {
            if (vehicle_exists(model, move, dic, p_m, s_m) == true) {
                vehicle[i] = vehicle[size - 1];
                vehicle[size - 1] = null;
                size = size - 1;
            }
        }
    }
    public void Adding_km_displacement(Vehicle[] v,int index,int km){
        int n;
        n= v[index].get_move();
        int Union=n+km;
        v[index].set_Move(Union);
    }







}

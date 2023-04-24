public class Car_Agency {
    private int size;
    private Vehicle[] vehicle;

    public Car_Agency(){
        Vehicle[] vehicle= new Vehicle[size];
        vehicle=null;
        size=0;
    }
    public Car_Agency(int size, Vehicle[] vehicle){
        this.size=size;
        this.vehicle=vehicle;
    }

    public void add_Vehicle(Vehicle car){
        if(size==0){
            size++;
            Vehicle[] vehicle= new Vehicle[size];
            vehicle[size]=car;
        }
        else{

            Vehicle[] new_vehicle= new Vehicle[size];
            for(int i=0;i<size;i++){
                new_vehicle[i]=vehicle[i];
            }
            size++;
            Vehicle[] vehicle= new Vehicle[size];
            for(int i=0;i<size;i++){
                vehicle[i]=new_vehicle[i];
            }
            vehicle[size]=car;



        }
    }


}

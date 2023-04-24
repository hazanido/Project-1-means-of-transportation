public class Car_Agency {
    private int size;
    private Vehicle[] vehicle;

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


}
//Vehicle[] new_vehicle= new Vehicle[size];
//
//                new_vehicle=this.vehicle;
//
//            size++;
//            vehicle= new Vehicle[size];
//
//                this.vehicle=new_vehicle;
//
//            this.vehicle[size-1]=car;
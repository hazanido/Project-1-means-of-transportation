package Vehicle;

import java.util.Arrays;
/**
 * The car agency department contains
 * an array of all the means of transportation
 * that exist in the system
 */
public class Car_Agency {
    private static int size;
    private static Vehicle[] vehicle;

    /**
     * get of the array of transportation vehicles in the system
     * @return the vehicles array
     */

    public Vehicle[] get_vehicle(){
        return vehicle;
    }

    /**
     * Default constructor
     */
    public Car_Agency(){
        vehicle= new Vehicle[size];
        size=0;
    }

    /**
     *
     * @param size-The size of the array
     * @param vehicle-The array of all the means of transportation that exist in the system
     */
    public Car_Agency(int size, Vehicle[] vehicle){
        this.size=size;
        this.vehicle=vehicle;
    }

    /**
     *The function of adding a vehicle to the array
     * @param car-An object from the transport vehicle class, the transport vehicle you want to add
     */

    public static void add_Vehicle(Vehicle car){
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
            for(int i = 0 ;i<size-1;i++)
            {
                vehicle[i]=temp[i];
            }
            vehicle[size-1]=car;
        }
    }

    /**
     *Print function, prints the details of all the means of transportation that exist in the array,
     *  calls the toString function
     */
    public static void  print(){
        for(int i=0;i<size;i++)
        {
            System.out.println(vehicle[i].toString()+"\n");
        }
    }

    /**
     *A function that receives the details of the means of transport and checks if it is in the array
     * @param model-Describes the model name of the vehicle
     * @param move-Describes the ability to move the vehicle
     * @param dic-Describes the distance the vehicle traveled during its lifetime
     * @param p_m-Describes the maximum number of people that the vehicle can accommodate
     * @param s_m-Describes the maximum speed of the vehicle
     * @return Returns true or false if the requested vehicle exists in the array
     */
    public boolean vehicle_exists(String model,int move,double dic,int p_m,double s_m){
        for (int i=0;i<size;i++) {
            if ((vehicle[i].get_Model_Name().equals(model)) && (vehicle[i].get_move()==move) && (vehicle[i].get_distance() == dic) && (vehicle[i].get_Max_Passengers() == p_m) && (vehicle[i].get_Max_Speed() == s_m)) {
                return true;
            }
        }
            return false;
    }

    /**
     *A function that receives the details of the means of transport
     * and looks for the index where it is in the array
     * @param model-Describes the model name of the vehicle
     * @param move-Describes the ability to move the vehicle
     * @param dic-Describes the distance the vehicle traveled during its lifetime
     * @param p_m-Describes the maximum number of people that the vehicle can accommodate
     * @param s_m-Describes the maximum speed of the vehicle
     * @return the index where the vehicle is located in the array
     */

    public int indexOf(String model,int move,double dic,int p_m,double s_m){
        int ans=-1;
        for (int i=0;(i<size)&&(ans==-1);i++) {
            if ((vehicle[i].get_Model_Name().equals(model)) && (vehicle[i].get_move() == move) && (vehicle[i].get_distance() == dic) && (vehicle[i].get_Max_Passengers() == p_m) && (vehicle[i].get_Max_Speed() == s_m)) {
                ans=i;
            }
        }
        return ans;

    }

    /**
     *Removal function, removes a vehicle according to the details
     * @param model-Describes the model name of the vehicle
     * @param move-Describes the ability to move the vehicle
     * @param dic-Describes the distance the vehicle traveled during its lifetime
     * @param p_m-Describes the maximum number of people that the vehicle can accommodate
     * @param s_m-Describes the maximum speed of the vehicle
     */

    public void remove(String model,int move,double dic,int p_m,double s_m) {
        for (int i = 0; i < size; i++) {
            if (vehicle_exists(model, move, dic, p_m, s_m) == true) {
                vehicle[i] = vehicle[size - 1];
                vehicle[size - 1] = null;
                size = size - 1;
            }
        }
    }

    /**
     *A function that receives the array of means of transport
     * and the index where the means of transport is located in the array
     * and adds to that means of transport in the variable "move" km traveled
     * @param v-The array of means of transportation
     * @param index-The index where the vehicle is located
     * @param km-km to be added in the "move" variable
     */
    public void Adding_km_displacement(Vehicle[] v,int index,int km){
        int n;
        n= v[index].get_move();
        int Union=n+km;
        v[index].set_Move(Union);
    }

    /**
     * Compares this Vehicle.Car_Agency object to another object for equality.
     * Returns true if the other object is also a Vehicle.Car_Agency object and has the same values for all fields, false otherwise.
     * Overrides the equals method of the Object class.
     * @param obj the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car_Agency)) {
            return false;
        }
        Car_Agency other = (Car_Agency) obj;
        return this.size == other.size
                && Arrays.equals(this.vehicle, other.vehicle);
    }
}

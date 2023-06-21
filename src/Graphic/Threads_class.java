package Graphic;

import Vehicle.*;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Threads_class  {
    private final Object lock = new Object();

    private AtomicInteger[] index_Test_Array;
    private AtomicInteger[]  buy_Array;
    private static List<Vehicle> vehicles;
    private List<ChangeListener> listeners;
    private static Threads_class singleInstance = null;
    private float totalDistance = 0;
    private float Total_Distance;

    public Threads_class() {

        index_Test_Array = new AtomicInteger[VehicleType.values().length];
        buy_Array = new AtomicInteger[VehicleType.values().length];
        //vehicles = new ArrayList<>(Arrays.asList(vehicle));
        listeners = new ArrayList<>();
        vehicles = new ArrayList<>();
        init_Arr();
        for (ChangeListener listener : listeners) {
            listener.change_listener();
        }
    }

    public static Threads_class get_Instance() {
        if (singleInstance == null) {
            singleInstance = new Threads_class();
        }
        return singleInstance;
    }

    private void init_Arr() {
        for (int i = 0; i < index_Test_Array.length; i++) {
            index_Test_Array[i] = new AtomicInteger(-1);
            buy_Array[i] = new AtomicInteger(-1);
        }
    }
    public List<Vehicle> get_Vehicles(){
        return vehicles;
    }

    public boolean InProgress() {
        for (int i = 0; i < VehicleType.values().length; i++) {
            if ((index_Test_Array[i].get() != -1) || ( buy_Array[i].get() != -1)) {
                return true;
            }
        }
        return false;
    }

    public boolean Inspection_by_type(int index) {
        synchronized (lock) {
            Vehicle vehicle = vehicles.get(index);
            VehicleType type = get_Vehicle_Type(vehicle);
            if ( buy_Array[type.ordinal()].get() == index) {
                JOptionPane.showMessageDialog(null, "This vehicle is currently in buy status - please try again later");
                return true;
            }
            if (index_Test_Array[type.ordinal()].get() == -1) {
                index_Test_Array[type.ordinal()].set(index);
                lock.notifyAll();
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "This vehicle is currently being test driven - please try again later");
                return true;
            }

        }
    }

    public boolean Inspection_by_index(int index) {
        synchronized (lock) {
            Vehicle vehicle = vehicles.get(index);
            VehicleType type = get_Vehicle_Type(vehicle);
            int currentInTest = index_Test_Array[type.ordinal()].get();
            if (currentInTest == -1) {
                return false;
            } else {
                return index == currentInTest;
            }
        }
    }

    private VehicleType get_Vehicle_Type(Vehicle vehicle) {
        if (vehicle instanceof Marine_transport_vehicle) {
            return VehicleType.Marine;
        } else if (vehicle instanceof Land_transport_vehicle) {
            return VehicleType.Terrestrial;
        } else {
            return VehicleType.Air;
        }
    }

    public void addListener(ChangeListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ChangeListener listener) {
        listeners.remove(listener);
    }

    public void addVehicle(JFrame frame, Vehicle vehicle) {
        new Thread(() -> {
            //sleepDBAction(frame);
            synchronized (lock) {
                vehicles.add(vehicle);
                VehicleType type = get_Vehicle_Type(vehicle);
                index_Test_Array[type.ordinal()].set(-1);
                buy_Array[type.ordinal()].set(-1);
                Notice_of_change();
            }

        }).start();
    }

    public void removeVehicle(JFrame frame, int index) {
        if (index >= 0 && index < vehicles.size()) {
            new Thread(() -> {
                Vehicle vehicle = vehicles.get(index);
                VehicleType type = get_Vehicle_Type(vehicle);
                index_Test_Array[type.ordinal()].set(index);
                sleepDBAction(frame);
                synchronized (lock) {
                    vehicles.remove(index);
                    Notice_of_change();
                }
            }).start();
        } else {
            System.out.println("Invalid index");
        }
    }


    private void Notice_of_change() {
        for (ChangeListener listener : listeners) {
            listener.change_listener();
        }
    }

    private void sleepDBAction(JFrame frame) {
        JOptionPane optionPane = new JOptionPane("Updating Database-please wait", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog(frame, "Updating Database-please wait");
        dialog.setModal(false);
        dialog.setVisible(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dialog.dispose();
    }
    private int getVehicleTypeIndex(VehicleType vehicleType) {
        for (int i = 0; i < VehicleType.values().length; i++) {
            if (VehicleType.values()[i] == vehicleType) {
                return i;
            }
        }
        return -1;
    }

    public void Update_distance(int index, float distance, long sleep_time) {
        synchronized (lock) {
            System.out.println(index + ", SleepTime - " + sleep_time);
            try {
                Thread.sleep(sleep_time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (index >= 0 && index <= vehicles.size()) {
                Vehicle vehicleToUpdate = vehicles.get(index);
                vehicleToUpdate.set_Distance(distance);
                totalDistance += distance;
                VehicleType vehicleType = get_Vehicle_Type(vehicleToUpdate);
                int vehicleTypeIndex = getVehicleTypeIndex(vehicleType);
                if (vehicleTypeIndex != -1 && vehicleTypeIndex < index_Test_Array.length) {
                    index_Test_Array[vehicleTypeIndex ].set(-1);
                }
            }
        }
        Notice_of_change();
    }

    public void resetAll(JFrame frame){
        new Thread(()->{
            sleepDBAction(frame);
            synchronized (lock){
                for (Vehicle vehicle : vehicles) {
                    vehicle.set_Model_Name(null);
                    vehicle.set_Move(0);
                    vehicle.set_Distance(0);
                    vehicle.set_Max_Passengers(0);
                    vehicle.set_Max_Speed(0);
                    vehicle.set_Max_Passengers(0);
                    vehicle.set_Max_Speed(0);
                    if(vehicle instanceof Jeep){
                        ((Jeep) vehicle).Average_fuel_consumption();
                        ((Jeep) vehicle).Average_life_engine();
                        ((Jeep) vehicle).set_Number_Wheels(0);
                        ((Jeep) vehicle).license_type();
                        ((Jeep) vehicle).set_Kind_Way(null);

                    }
                    else if(vehicle instanceof NonMotorizedBicycle){
                        ((NonMotorizedBicycle) vehicle).set_Number_Wheels(0);
                        ((NonMotorizedBicycle) vehicle).set_Kind_Way(null);
                        ((NonMotorizedBicycle) vehicle).Energy_score();
                        ((NonMotorizedBicycle) vehicle).power_source(null);
                    }
                    else if(vehicle instanceof Cruise_ship){
                        ((Cruise_ship) vehicle).Average_life_engine();
                        ((Cruise_ship) vehicle).Average_fuel_consumption();
                        ((Cruise_ship) vehicle).set_target(null);
                        ((Cruise_ship) vehicle).set_Because(false);
                        ((Cruise_ship) vehicle).license_type();
                    }
                    else if(vehicle instanceof Dawn_Rigoli){
                        ((Dawn_Rigoli) vehicle).set_Type(null);
                        ((Dawn_Rigoli) vehicle).power_source(null);
                        ((Dawn_Rigoli) vehicle).Energy_score();
                    }
                    else if(vehicle instanceof Frigate){
                        ((Frigate) vehicle).set_Because(false);
                        ((Frigate) vehicle).set_target(null);
                        ((Frigate) vehicle).Average_fuel_consumption();
                        ((Frigate) vehicle).Average_life_engine();
                    }
                    else if(vehicle instanceof Game_Drone){
                        ((Game_Drone) vehicle).power_source(null);
                        ((Game_Drone) vehicle).Energy_score();
                        ((Game_Drone) vehicle).set_Type(null);

                    }
                    else if(vehicle instanceof Amphibious_vehicle){
                        ((Amphibious_vehicle) vehicle).set_target(null);
                        ((Amphibious_vehicle) vehicle).set_Because(false);
                        ((Amphibious_vehicle) vehicle).Average_life_engine();
                        ((Amphibious_vehicle) vehicle).Average_fuel_consumption();
                        ((Amphibious_vehicle) vehicle).set_Kind_Way(null);
                        ((Amphibious_vehicle) vehicle).set_Number_Wheels(0);
                    }
                    else if(vehicle instanceof ElectricBicycle){
                        ((ElectricBicycle) vehicle).set_Number_Wheels(0);
                        ((ElectricBicycle) vehicle).Average_fuel_consumption();
                        ((ElectricBicycle) vehicle).Average_life_engine();
                        ((ElectricBicycle) vehicle).set_Kind_Way(null);
                    }
                    else if(vehicle instanceof Hybrid_plane){
                        ((Hybrid_plane) vehicle).set_Kind_Way(null);
                        ((Hybrid_plane) vehicle).set_Type(null);
                        ((Hybrid_plane) vehicle).Average_life_engine();
                        ((Hybrid_plane) vehicle).Average_fuel_consumption();
                        ((Hybrid_plane) vehicle).set_Because(false);
                        ((Hybrid_plane) vehicle).set_target(null);
                    }
                }
            }
        }).start();
    }
    public void changeFlag(JFrame frame, String flag) {
        new Thread(()-> {
            sleepDBAction(frame);
            synchronized (lock){
                for (Vehicle vehicle:vehicles){
                    if (vehicle instanceof Marine_transport_vehicle){
                        ((Marine_transport_vehicle)vehicle).set_target(flag);
                    }
                }
            }
            Notice_of_change();
        }).start();

    }

    public void run() {
        synchronized (lock) {
            while (true) {
                try {
                    lock.wait();
                    for (ChangeListener listener : listeners) {
                        listener.change_listener();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public float get_Total_Distance() {
        return Total_Distance;
    }

    public void set_Total_Distance(float totalDistance) {
        this.Total_Distance = totalDistance;
    }
}






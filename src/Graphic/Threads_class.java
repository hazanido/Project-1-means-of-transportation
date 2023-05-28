package Graphic;

import Vehicle.*;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Threads_class {
    private final Object lock = new Object();

    private AtomicInteger[] index_Test_Array;
    private AtomicInteger[] buy_Test_Array;
    private List<Vehicle> vehicles;
    private List<ChangeListener> listeners;
    private static Threads_class singleInstance = null;

    private Threads_class() {
        index_Test_Array = new AtomicInteger[VehicleType.values().length];
        buy_Test_Array = new AtomicInteger[VehicleType.values().length];
        vehicles = new ArrayList<>();
        listeners = new ArrayList<>();

        init_Arr();
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
            buy_Test_Array[i] = new AtomicInteger(-1);
        }
    }

    public boolean InProgress() {
        for (int i = 0; i < VehicleType.values().length; i++) {
            if ((index_Test_Array[i].get() != -1) || (buy_Test_Array[i].get() != -1)) {
                return true;
            }

        }
        return false;
    }

    public boolean Inspection_by_type(int index) {
        synchronized (lock) {
            Vehicle vehicle = vehicles.get(index);
            VehicleType type = getVehicleType(vehicle);
            if (buy_Test_Array[type.ordinal()].get() == index) {
                JOptionPane.showMessageDialog(null, "This vehicle is currently in buy status - please try again later");
                return true;
            }
            if (index_Test_Array[type.ordinal()].get() == -1) {
                index_Test_Array[type.ordinal()].set(index);
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
            VehicleType type = getVehicleType(vehicle);
            int currentInTest = index_Test_Array[type.ordinal()].get();
            if (currentInTest == -1) {
                return false;
            } else {
                return index == currentInTest;
            }
        }
    }

    private VehicleType getVehicleType(Vehicle vehicle) {
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
            sleepDBAction(frame);
            synchronized (lock) {
                vehicles.add(vehicle);
            }
            Notice_of_change();
        }).start();
    }

    public void removeVehicle(JFrame frame, int index) {
        new Thread(() -> {
            Vehicle vehicle = vehicles.get(index);
            VehicleType type = getVehicleType(vehicle);
            buy_Test_Array[type.ordinal()].set(index);
            sleepDBAction(frame);
            synchronized (lock) {
                vehicles.remove(index);
            }
            Notice_of_change();
        }).start();
    }

    private void Notice_of_change() {
        for (ChangeListener listener : listeners) {
            listener.change_listener();
        }
    }

    private void sleepDBAction(JFrame frame) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            if (index >= 0 && index < vehicles.size()) {
                Vehicle vehicleToUpdate = vehicles.get(index);
                vehicleToUpdate.set_Distance(distance);
                VehicleType vehicleType = getVehicleType(vehicleToUpdate);
                int vehicleTypeIndex = getVehicleTypeIndex(vehicleType);
                if (vehicleTypeIndex != -1 && vehicleTypeIndex < index_Test_Array.length) {
                    index_Test_Array[vehicleTypeIndex ].set(-1);
                }
            }
        }
        Notice_of_change();
    }

    /**

    public void Reset_distance(JFrame frame){
        new Thread(() -> {
            sleepDBAction(frame);
            synchronized (lock){
            }
        }
    }
    */
}




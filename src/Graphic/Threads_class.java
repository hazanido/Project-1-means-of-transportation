package Graphic;

import Vehicle.*;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Threads_class {
    private final Object lock = new Object();
    private Map<VehicleType, AtomicInteger> index_Test_Map;
    private Map<VehicleType, AtomicInteger> buy_Test_Map;
    private List<Vehicle> vehicles;
    private List<ChangeListener> listeners;
    private static Threads_class singleInstance = null;
    private Threads_class() {
        index_Test_Map = new HashMap<>();
        buy_Test_Map = new HashMap<>();
        vehicles = new ArrayList<>();
        listeners = new ArrayList<>();

        init_Maps();
    }
    public static Threads_class get_Instance() {
        if (singleInstance == null) {
            singleInstance = new Threads_class();
        }
        return singleInstance;
    }
    private void init_Maps() {
        for (VehicleType type : VehicleType.values()) {
            index_Test_Map.put(type, new AtomicInteger(-1));
            buy_Test_Map.put(type, new AtomicInteger(-1));
        }
    }
    public boolean InProgress() {
        for (VehicleType vehicleType : VehicleType.values()) {
            if (index_Test_Map.get(vehicleType).get() != -1) {
                return true;
            }
            if (buy_Test_Map.get(vehicleType).get() != -1) {
                return true;
            }
        }
        return false;
    }
    public boolean Inspection_by_type(int index) {
        synchronized (lock) {
            Vehicle vehicle = vehicles.get(index);
            VehicleType type = getVehicleType(vehicle);
            if (buy_Test_Map.get(type).get() == index) {
                JOptionPane.showMessageDialog(null, "This vehicle is currently in buy status - please try again later");
                return true;
            }
            if (index_Test_Map.get(type).get() == -1) {
                index_Test_Map.get(type).set(index);
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
            int currentInTest = index_Test_Map.get(type).get();
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
            buy_Test_Map.get(type).set(index);
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

}

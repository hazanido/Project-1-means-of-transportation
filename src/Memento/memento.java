package Memento;

import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class memento {

    private  static memento instance = null;
    private Stack<stack_memento> stack;
    private final int save = 3;

    private class stack_memento{
        private List<Vehicle> vehiclesList;
        private int totalDistance;
        public stack_memento(List<Vehicle> vehiclesList,int totalDistance){
            if (stack.size() < save) {
                this.totalDistance = totalDistance;
                this.vehiclesList = new ArrayList<>();
                for (int i = 0; i <vehiclesList.size() ; i++) {
                    this.vehiclesList.add(vehiclesList.get(i));
                }
            }
        }

    }
    private memento(){
        stack=new Stack<>();
    }
    public static memento getInstance() {
        if(instance == null)
            instance = new memento();
        return instance;
    }
    public boolean save(List<Vehicle> vehiclesList){
        if(stack.size() < save) {
            stack_memento ms = new stack_memento(vehiclesList,5);//todo fix
            stack.push(ms);
            return true;
        }
        return false;
    }
    public boolean restore(){
        if(!stack.empty()){
            stack_memento ms = stack.pop();

            return true;
        }
        return false;
    }
}

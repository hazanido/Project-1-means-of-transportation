package Decorator;

import Vehicle.Vehicle;

public class ColoredCarDec implements decorator_Car{

private Vehicle vehicle;
private String color;
public ColoredCarDec(Vehicle vehicle,String col){
    this.vehicle=vehicle;
    this.color=col;
}
    @Override
    public void changeCarColor() {
        String nm = null;
        vehicle.setColor(color);
        String c = color;
        switch(c) {
            case "green":
                color = "green";
                break;
            case "blue":
                color = "blue";
                break;
            case "red":
                color = "red";
                break;
        }
    }
}

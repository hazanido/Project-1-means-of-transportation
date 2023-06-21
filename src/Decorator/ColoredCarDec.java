package Decorator;

import Vehicle.Vehicle;

public class ColoredCarDec implements decorator_Car{

private Vehicle vehicle;
private String color;

    @Override
    public void changeCarColor() {
        String nm = null;
        vehicle.setColor(color);
        String c = color;
        switch(c) {
            case "Natural":
                color = "n_";
                break;
            case "Blue":
                color = "b_";
                break;
            case "Red":
                color = "r_";
                break;
        }
        switch(vehicle.getClass().getSimpleName())
        {
            case "Bear":
                nm = "bea_" + color;
                break;
            case "Elephant":
                nm="elf_" + color;
                break;
            case "Giraffe":
                nm = "grf_" + color;
                break;
            case "Lion":
                nm = "lio_" + color;
                break;
            case "Turtle":
                nm = "trt_" + color;
                break;
        }

    }


}

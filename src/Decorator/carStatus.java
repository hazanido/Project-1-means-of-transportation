package Decorator;

public class carStatus implements Status_car{

    private static String status;

    public carStatus(){
        status="In stock";
    }
    @Override
    public String statusCar() {
        return status;

    }
    public static void changeStatus(String ms) {
        if(ms=="test drive"){
            status="test drive";
        } else if (ms=="buying process") {
            status="buying process";
        } else if (ms=="In stock") {
            status="In stock";

        }


    }

}

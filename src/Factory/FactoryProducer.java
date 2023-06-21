package Factory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vehicle.*;

public class FactoryProducer {
    private VehicleFactory factory;
    private static FactoryProducer instance;

    public void setFactory(VehicleFactory factory) {
        this.factory = factory;
    }

    public VehicleFactory getFactory() {
        return factory;
    }
    public static FactoryProducer getInstance() {
        if (instance == null) {
            instance = new FactoryProducer(); // יצירת האינסטנס היחיד רק במקרה שלא נוצר עד כה
        }
        return instance;
    }
}




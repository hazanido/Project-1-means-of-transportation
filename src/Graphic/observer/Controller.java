package Graphic.observer;

import Graphic.main_window;

import java.util.Observable;
import java.util.Observer;

public class Controller extends Thread implements Observer {
    private boolean run;

    public Controller(){
        run = true;
    }

    public void run() {
        while (run) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            main_window.getInstance();
        }
    }

    /**
     * update method so the observables can notify this thread
     * @param o
     * @param arg
     */
    public synchronized void update(Observable o, Object arg) {
        notify();

    }
}

package com.daredevil.landlordcommunication.thread;



public class RunThread extends Thread {

    private Runnable action;

    @Override
    public void run() {
        super.run();
        action.run();
    }

    public void runTask(Runnable action){
       this.action = action;
    }
}

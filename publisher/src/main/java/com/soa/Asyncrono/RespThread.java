package com.soa.Asyncrono;
    

public class RespThread implements Runnable {
    private final Task task;

    public RespThread(Task task) {
        this.task = task;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Tarea iniciada");
            Thread.sleep(5000); // Equivale a funciones/procedimientos funcionales
            task.sendResponse();
            System.out.println("Tarea Concluida");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Task myTask = new Task();
        RespThread responseRunnable = new RespThread(myTask);
        Thread thread = new Thread(responseRunnable);
        thread.start();
    }
}



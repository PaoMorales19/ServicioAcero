package com.soa.Asyncrono;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.soa.dto.Hub;
import com.soa.dto.PurchaseRequest;
import com.soa.service.HubService;

@Component
public class Task {
    
    @Autowired
    public HubService hubService;
    private final RestTemplate restTemplate = new RestTemplate();
    
    public void sendResponse() {        
        // TODO Invocar cada uno de los callbacks registrados para el servicio que recibe la respuesta. Es decir el que está en el consumer.
        List<Hub> hubs = hubService.getAllHubs();
        
        PurchaseRequest purReq = new PurchaseRequest();
        
        for (Hub hub : hubs) {
            String callback = hub.getCallback() + "/listener/responsePurchase";
            
            HttpEntity<PurchaseRequest> requestEntity = new HttpEntity<>(purReq);
            
            try {
                restTemplate.postForObject(callback, requestEntity, String.class);
                System.out.println("Tarea Enviada a " + callback);
            } catch (Exception e) {
                System.err.println("Error al enviar tarea a " + callback + ": " + e.getMessage());
            }
        }
    }
}

class ResponseRunnable implements Runnable {
    private final Task task;

    public ResponseRunnable(Task task) {
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
        // Suponiendo que Task se inyecta correctamente a través de Spring, se usaría el contexto de la aplicación para obtener el bean
        // Aquí se simplifica para ilustración
        Task myTask = new Task();
        ResponseRunnable responseRunnable = new ResponseRunnable(myTask);
        Thread thread = new Thread(responseRunnable);
        thread.start();
    }
}

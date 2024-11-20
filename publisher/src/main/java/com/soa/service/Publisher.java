package com.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soa.Asyncrono.RespThread;
import com.soa.Asyncrono.Task;
import com.soa.dto.Ack;
import com.soa.dto.Hub;
import com.soa.dto.PurchaseRequest;

@RestController
public class Publisher {
	
	@Autowired
	public HubService hubService;
	@Autowired
	private Task task;
	
	@PostMapping (value = "/hub", consumes = "application/json", produces = "application/json")
	public Ack createSubscription(@RequestBody Hub request) {
		Ack ack = new Ack();
		hubService.createHub(request); //añade el hub a la lista
		ack.setCode(0);
		ack.setDescription("Suscripción creada");;
		return ack;
		
	}
	
	@GetMapping("/hub")
    public List<Hub> getAllOrders() {
        return hubService.getAllHubs();
	
    }
	
	@PostMapping (value = "/purchase", consumes = "application/json", produces = "application/json")
	public Ack createTask(@RequestBody PurchaseRequest request) {
		Ack ack = new Ack();
		ResponseThread thread = new ResponseThread(task);
		thread.start();
		ack.setCode(0);
		ack.setDescription("Se solicitó tarea...");
		return ack;
	}

}

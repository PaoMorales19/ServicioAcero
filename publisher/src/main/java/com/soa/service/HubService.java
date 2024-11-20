package com.soa.service;

import org.springframework.stereotype.Service;

import com.soa.dto.Hub;

import java.util.ArrayList;
import java.util.List;

@Service
public class HubService {

    private List<Hub> hubs = new ArrayList<>();

   
    public List<Hub> getAllHubs() {
        return hubs;
    }


    public Hub createHub(Hub hub) {
        hubs.add(hub);
        return hub;
    }
    

}

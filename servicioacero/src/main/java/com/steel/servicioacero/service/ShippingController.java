package com.steel.servicioacero.service;

import org.springframework.web.bind.annotation.*;
import com.steel.servicioacero.dto.ShippingRequest;
import com.steel.servicioacero.dto.ShippingResponse;

// Elimina el import de ArrayList ya que no se usa
// import java.util.ArrayList;
// import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ShippingResponse createShipping(@RequestBody ShippingRequest shippingRequest) {
        ShippingResponse response = new ShippingResponse();
        response.setOrderId(shippingRequest.getOrderId());
        response.setShippingDetails(shippingRequest.getShippingDetails());
        response.setMessage("Detalles de envío creados exitosamente.");
        return response;
    }

    @GetMapping("/{orderId}")
    public ShippingResponse getShippingDetails(@PathVariable String orderId) {
        // Lógica para recuperar detalles de envío, aquí es solo un ejemplo
        ShippingResponse response = new ShippingResponse();
        response.setOrderId(orderId);
        response.setShippingDetails("Transportista XYZ, entrega el 2023-12-02");
        return response;
    }
}

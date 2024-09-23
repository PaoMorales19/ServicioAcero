package com.steel.servicioacero.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.steel.servicioacero.dto.PurchaseRequest;
import com.steel.servicioacero.dto.PurchaseResponse;
import com.steel.servicioacero.dto.ResponseCode;

@RestController
@RequestMapping("/purchase")
public class ReservationController {
    @PostMapping(consumes = "application/json", produces = "application/json")
    public PurchaseResponse createPurchase(@RequestBody PurchaseRequest purchaseRequest) {
        // Lógica para procesar la compra
        PurchaseResponse response = new PurchaseResponse();
        response.setId("12345");
        response.setMessage("Solicitud de compra creada exitosamente.");
        return response;
    }

    @GetMapping
    public List<PurchaseResponse> getPurchaseOrders() {
        List<PurchaseResponse> orders = new ArrayList<>();
        orders.add(new PurchaseResponse("54321", "En Proceso"));

        // Aquí puedes agregar lógica adicional para recuperar órdenes de compra si es necesario.

        return orders;
    }


    @PutMapping("/purchase")
    public PurchaseResponse updatePurchase(@PathVariable String id, @RequestBody PurchaseRequest purchaseRequest) {
        // Lógica para actualizar la solicitud de compra
        PurchaseResponse response = new PurchaseResponse();
        response.setId(id);
        response.setMessage("Solicitud de compra actualizada exitosamente.");
        return response;
    }

    @DeleteMapping("/purchase")
    public ResponseCode deletePurchase(@PathVariable String id) {
        // Lógica para eliminar la solicitud de compra
        ResponseCode responseCode = new ResponseCode();
        responseCode.setCode(204);
        responseCode.setMessage("Solicitud de compra eliminada exitosamente.");
        return responseCode;
    }
}

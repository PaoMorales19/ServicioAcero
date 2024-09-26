package com.steel.servicioacero.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.steel.servicioacero.dto.SellRequest;
import com.steel.servicioacero.dto.SellResponse;
import com.steel.servicioacero.dto.ResponseCode;

@RestController
@RequestMapping("/sell")
public class SellController {
    @PostMapping(consumes = "application/json", produces = "application/json")
    public SellResponse createPurchase(@RequestBody SellRequest purchaseRequest) {
        // Lógica para procesar la compra
        SellResponse response = new SellResponse();

        response.setId("12345");
        response.setMessage("Solicitud de compra creada exitosamente.");
        return response;
    }

    @GetMapping
    public List<SellResponse> getsellOrders() {
        List<SellResponse> orders = new ArrayList<>();
        orders.add(new SellResponse("54321", "En Proceso"));

        // Aquí puedes agregar lógica adicional para recuperar órdenes de compra si es necesario.

        return orders;
    }


    @PutMapping("/{id}")
    public SellResponse updateShell(@PathVariable String id,  @RequestBody SellRequest sellRequest) {
        // Lógica para actualizar la solicitud de compra
        SellResponse response = new SellResponse();
        response.setId(id);
        response.setMessage("Solicitud de compra actualizada exitosamente.");
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseCode deletePurchase(@PathVariable String id) {
        // Lógica para eliminar la solicitud de compra
        ResponseCode responseCode = new ResponseCode();
        responseCode.setCode(204);
        responseCode.setMessage("Solicitud de compra eliminada exitosamente.");
        return responseCode;
    }
    
}

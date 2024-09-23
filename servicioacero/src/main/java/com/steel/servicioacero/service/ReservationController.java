package com.steel.servicioacero.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.steel.servicioacero.dto.PurchaseRequest;
import com.steel.servicioacero.dto.PurchaseResponse;
import com.steel.servicioacero.dto.ResponseCode;

@RestController
@RequestMapping("/purchase")
public class ReservationController {

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createPurchase(@RequestBody PurchaseRequest purchaseRequest) {
        try {
            // Validación de campos requeridos
            if (purchaseRequest.getProvider() == null || purchaseRequest.getSpecifications() == null) {
                return ResponseEntity.badRequest().body(new ResponseCode(400, "Datos de compra incompletos.")); //400
            }

            // Procesar la compra
            PurchaseResponse response = new PurchaseResponse();
            response.setId("12345");
            response.setMessage("Solicitud de compra creada exitosamente."); //201
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            // Manejo de errores internos del servidor
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseCode(500, "Error interno del servidor: " + e.getMessage())); //500
        }
    }

    @GetMapping
    public ResponseEntity<?> getPurchaseOrders(@RequestParam(required = false) String provider, 
                                                @RequestParam(required = false) String country) {
        try {
            List<PurchaseResponse> orders = new ArrayList<>();

            // Aquí podrías agregar lógica para filtrar órdenes según el proveedor o país
            // Simulación de órdenes de compra
            orders.add(new PurchaseResponse("54321", "En Proceso"));

            // Si no se encuentran órdenes de compra
            if (orders.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ResponseCode(204, "No se encontraron órdenes de compra."));
            }

            // Si se encuentran órdenes, devuélvelas con código 200
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            // Manejo de errores internos del servidor
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseCode(500, "Error interno del servidor: " + e.getMessage()));
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updatePurchase(@PathVariable String id, @RequestBody PurchaseRequest purchaseRequest) {
        try {
            // Validación de campos requeridos
            if (purchaseRequest.getProvider() == null || purchaseRequest.getSpecifications() == null) {
                return ResponseEntity.badRequest().body(new ResponseCode(400, "Datos de compra incompletos."));
            }

            // Lógica para actualizar la solicitud de compra
            // Aquí podrías verificar si la compra existe

            PurchaseResponse response = new PurchaseResponse();
            response.setId(id);
            response.setMessage("Solicitud de compra actualizada exitosamente.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseCode(500, "Error interno del servidor: " + e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseCode> deletePurchase(@PathVariable String id) {
        try {
            // Lógica para verificar si la solicitud de compra existe
            boolean exists = true; // Aquí deberías tener la lógica real
    
            // Ejemplo de lógica para verificar existencia
            // exists = purchaseService.existsById(id); // Ejemplo de llamada a servicio
    
            if (!exists) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseCode(404, "Solicitud de compra no encontrada."));
            }
    
            // Lógica para eliminar la solicitud de compra
            // purchaseService.deleteById(id); // Ejemplo de llamada a servicio
    
            // Retorna la respuesta de éxito con código 204 (No Content) y mensaje
            ResponseCode responseCode = new ResponseCode();
            responseCode.setCode(204);
            responseCode.setMessage("Solicitud de compra eliminada exitosamente.");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseCode); // El cuerpo está presente por razones de claridad, aunque no es típico en 204
        } catch (Exception e) {
            // Manejo de errores internos del servidor
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseCode(500, "Error interno del servidor: " + e.getMessage()));
        }
    }
    
}
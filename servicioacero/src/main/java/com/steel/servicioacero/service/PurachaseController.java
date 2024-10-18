package com.steel.servicioacero.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.steel.servicioacero.dto.PurchaseRequest;
import com.steel.servicioacero.dto.PurchaseResponse;
import com.steel.servicioacero.dto.ResponseCode;

import com.steel.servicioacero.jms.JmsProducer;

@RestController
@RequestMapping("/purchase")
public class PurachaseController {

    private JmsProducer jmsProducer;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createPurchase(@RequestBody PurchaseRequest purchaseRequest) {
        try {

            // Validación de campos requeridos
            if (purchaseRequest.getProvider() == null || purchaseRequest.getSpecification() == null) {
                return ResponseEntity.badRequest().body(new ResponseCode(400, "Datos de compra incompletos.")); // 400
            }

            // Serializar objeto del body a JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBodyJson = objectMapper.writeValueAsString(purchaseRequest);

            // Enviar mensaje a la cola de mensajes
            jmsProducer = new JmsProducer();
            jmsProducer.sendMessage("amq.compras.in", requestBodyJson, 1, 9, 10000L);
            // jmsProducer.close();

            // Procesar la compra
            PurchaseResponse response = new PurchaseResponse();
            response.setId("12345");
            response.setMessage("Solicitud de compra creada exitosamente."); // 201

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {

            // Manejo de errores internos del servidor
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseCode(500, "Error interno del servidor: " + e.getMessage())); // 500

        }
    }

    @GetMapping
    public ResponseEntity<?> getPurchaseOrders(@RequestParam(required = false) String provider,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String date) {
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
            if (purchaseRequest.getProvider() == null || purchaseRequest.getSpecification() == null) {
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
    public ResponseEntity<?> deletePurchase(@PathVariable String id) {
        try {
            // Verificar que el ID tenga exactamente 5 dígitos
            if (id == null || !id.matches("\\d{5}")) {
                // Retornar un 404 si el ID no es válido o no cumple con los 5 dígitos
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseCode(404, "Solicitud de compra no encontrada."));
            }

            // Simulación de la verificación de si la solicitud existe
            boolean exists = id.equals("12345"); // Esta lógica es solo un ejemplo, debes usar la lógica real

            if (!exists) {
                // Si la solicitud no existe, retornar un 404 con un mensaje adecuado
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseCode(404, "Solicitud de compra no encontrada."));
            }

            // Lógica para eliminar la solicitud de compra
            // purchaseService.deleteById(id); // Implementa la lógica real para eliminar la
            // solicitud

            // Si la eliminación fue exitosa, retornar un código 200 con el ID y el mensaje
            // de éxito
            PurchaseResponse response = new PurchaseResponse();
            response.setId(id);
            response.setMessage("Eliminado exitosamente.");

            return ResponseEntity.ok(response); // Retornar 200 OK con el cuerpo de la respuesta
        } catch (Exception e) {
            // Si ocurre un error interno en el servidor, retornar un código 500 con el
            // mensaje de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseCode(500, "Error interno del servidor: " + e.getMessage()));
        }
    }
}
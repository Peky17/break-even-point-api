package com.breakpoint.breakeventpoint.controllers;

import com.breakpoint.breakeventpoint.models.dto.DoubleResponseDto;
import com.breakpoint.breakeventpoint.services.OperacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/operaciones")
public class operacionesController {
    private final OperacionesService operacionesService;
    @Autowired
    public operacionesController(OperacionesService operacionesService) {
        this.operacionesService = operacionesService;
    }

    @GetMapping("/getTotalCV")
    public ResponseEntity<DoubleResponseDto> getTotalCV() {
        double sumaMontos = operacionesService.getTotalCV();
        DoubleResponseDto responseDto = new DoubleResponseDto(sumaMontos);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/getTotalCF")
    public ResponseEntity<DoubleResponseDto> getTotalCF() {
        double sumaMontos = operacionesService.getTotalCF();
        DoubleResponseDto responseDto = new DoubleResponseDto(sumaMontos);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/getCantidadEquilibrio")
    public ResponseEntity<DoubleResponseDto> getEquilibrioQty(@RequestParam("param") double precioUnitarioVenta) {
        double equilibrioQty = operacionesService.getEquilibrioQty(precioUnitarioVenta);
        DoubleResponseDto responseDto = new DoubleResponseDto(equilibrioQty);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/getIngresoEquilibrio")
    public ResponseEntity<DoubleResponseDto> getIngresoEquilibrio(@RequestParam("param") double precioUnitarioVenta) {
        double ingresoEquilibrio = operacionesService.getIngresoEquilibrio(precioUnitarioVenta);
        DoubleResponseDto responseDto = new DoubleResponseDto(ingresoEquilibrio);
        return ResponseEntity.ok(responseDto);
    }
}

package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.entity.TipoMovimientosStock;
import com.sipsoft.licoreria.services.ITipoMovimientosStockService;

@RestController
@RequestMapping("/sipsoft")
public class TipoMovimientosStockController {
    @Autowired
    private ITipoMovimientosStockService serviceTipoMovimientosStock;

    @GetMapping("/tipos-movimientos-stock")
    public List<TipoMovimientosStock> buscarTodos() {
        return serviceTipoMovimientosStock.bucarTodos();
    }
    @PostMapping("/tipos-movimientos-stock")
    public TipoMovimientosStock guardar(@RequestBody TipoMovimientosStock tipoMovimientosStock) {
        serviceTipoMovimientosStock.guardar(tipoMovimientosStock);
        return tipoMovimientosStock;
    }

    @PutMapping("/tipos-movimientos-stock")
    public TipoMovimientosStock modificar(@RequestBody TipoMovimientosStock tipoMovimientosStock) {
        serviceTipoMovimientosStock.modificar(tipoMovimientosStock);
        return tipoMovimientosStock;
    }

    @GetMapping("/tipos-movimientos-stock/{idTipoMovimiento}")
    public Optional<TipoMovimientosStock> buscarId(@PathVariable("idTipoMovimiento") Integer idTipoMovimiento) {
        return serviceTipoMovimientosStock.buscarId(idTipoMovimiento);
    }

    @DeleteMapping("/tipos-movimientos-stock/{idTipoMovimiento}")
    public String eliminar(@PathVariable Integer idTipoMovimiento){
        serviceTipoMovimientosStock.eliminar(idTipoMovimiento);
        return "Tipo Movimiento Stock eliminado";
    }
}

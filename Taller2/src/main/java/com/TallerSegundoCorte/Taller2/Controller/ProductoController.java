package com.TallerSegundoCorte.Taller2.Controller;

import com.TallerSegundoCorte.Taller2.DAO.ConfiguracionDAO;
import com.TallerSegundoCorte.Taller2.DAO.IProductoDAO;
import com.TallerSegundoCorte.Taller2.Model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private IProductoDAO productoDAO;

    public ProductoController() {
        // Configurar para usar MySQL o Oracle a través del método configureAdapterDB
        this.productoDAO = ConfiguracionDAO.configureAdapterDB("Oracle");  // Cambiar a "Oracle" si se requiere
    }

    // Crear un producto
    @PostMapping
    public ResponseEntity<String> createProducto(@RequestBody Producto producto) {
        productoDAO.create(producto);
        return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
    }

    // Leer un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long id) {
        Producto producto = productoDAO.read(id);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getProductos() {
        return new ResponseEntity<>(productoDAO.readAll(), HttpStatus.OK);
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoExistente = productoDAO.read(id);
        if (productoExistente != null) {
            producto.setId(id);  // Asegurarse de que se está actualizando el producto con el mismo ID
            productoDAO.update(producto);
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        Producto producto = productoDAO.read(id);
        if (producto != null) {
            productoDAO.delete(id);
            return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}


package com.TallerSegundoCorte.Taller2.DAO;

import com.TallerSegundoCorte.Taller2.Model.Producto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OracleProductoDAO implements IProductoDAO {

    private Map<Long, Producto> productos;

    public OracleProductoDAO() {
        this.productos = new HashMap<>();
        // Datos de ejemplo
        productos.put(1L, new Producto(123L, "Producto Oracle", 200.0));
        productos.put(2L, new Producto(456L, "Producto O pc", 250.0));
    }

    @Override
    public void create(Producto producto) {
        productos.put(producto.getId(), producto);
        System.out.println("Producto creado en Oracle: " + producto);
    }

    @Override
    public Producto read(Long id) {
        return productos.get(id);
    }
    @Override
    public List<Producto> readAll() {
        return productos.values().stream().collect(Collectors.toList());
    }

    @Override
    public void update(Producto producto) {
        productos.put(producto.getId(), producto);
        System.out.println("Producto actualizado en Oracle: " + producto);
    }

    @Override
    public void delete(Long id) {
        productos.remove(id);
        System.out.println("Producto eliminado en Oracle con ID: " + id);
    }
}



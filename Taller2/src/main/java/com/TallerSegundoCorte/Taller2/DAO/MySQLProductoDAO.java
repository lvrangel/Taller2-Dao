package com.TallerSegundoCorte.Taller2.DAO;
import com.TallerSegundoCorte.Taller2.Model.Producto;
import java.util.ArrayList;
import java.util.List;

public class MySQLProductoDAO implements IProductoDAO {

    private List<Producto> productos;

    public MySQLProductoDAO() {
        this.productos = new ArrayList<>();
        // Datos de ejemplo
        productos.add(new Producto(1L, "Rosas Rojas", 100.0));
        productos.add(new Producto(2L, "Rosas Amarillas",  150.0));
    }

    @Override
    public void create(Producto producto) {
        productos.add(producto);
        System.out.println("Producto creado en MySQL: " + producto);
    }

    @Override
    public Producto read(Long id) {
        return productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Producto> readAll() {
        return productos;
    }


    @Override
    public void update(Producto producto) {
        Producto existingProducto = read(producto.getId());
        if (existingProducto != null) {
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setPrecio(producto.getPrecio());
            System.out.println("Producto actualizado en MySQL: " + producto);
        }
    }

    @Override
    public void delete(Long id) {
        productos.removeIf(producto -> producto.getId().equals(id));
        System.out.println("Producto eliminado en MySQL con ID: " + id);
    }
}




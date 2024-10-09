package com.TallerSegundoCorte.Taller2.DAO;

import com.TallerSegundoCorte.Taller2.Model.Producto;

import java.util.List;

public interface IProductoDAO {
    void create(Producto producto);
    Producto read(Long id);
    List<Producto> readAll();
    void update(Producto producto);
    void delete(Long id);
}


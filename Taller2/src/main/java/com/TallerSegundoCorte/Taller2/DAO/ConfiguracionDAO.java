package com.TallerSegundoCorte.Taller2.DAO;

public class ConfiguracionDAO {

    public static IProductoDAO configureAdapterDB(String dbType) {
        if (dbType.equalsIgnoreCase("MySQL")) {
            return new MySQLProductoDAO();
        } else if (dbType.equalsIgnoreCase("Oracle")) {
            return new OracleProductoDAO();
        } else {
            throw new IllegalArgumentException("Tipo de base de datos no soportada: " + dbType);
        }
    }
}


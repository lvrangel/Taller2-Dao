package com.TallerSegundoCorte.Taller2;

import com.TallerSegundoCorte.Taller2.DAO.ConfiguracionDAO;
import com.TallerSegundoCorte.Taller2.DAO.IProductoDAO;
import com.TallerSegundoCorte.Taller2.DAO.MySQLProductoDAO;
import com.TallerSegundoCorte.Taller2.DAO.OracleProductoDAO;
import com.TallerSegundoCorte.Taller2.Model.Producto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Taller2Application {

	public static void main(String[] args) {
		SpringApplication.run(Taller2Application.class, args);
	}
}

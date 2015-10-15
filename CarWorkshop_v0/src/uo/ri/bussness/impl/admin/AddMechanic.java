package uo.ri.bussness.impl.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uo.ri.common.BusinessException;
import alb.util.jdbc.Jdbc;
import uo.ri.conf.PersistenceFactory;
import uo.ri.persistence.MecanicoGateway;

public class AddMechanic {

	String nombre;
	String apellidos;

	public AddMechanic(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}


	public void execute() throws BusinessException {

        MecanicoGateway mecanicoGateway = PersistenceFactory.getMecanicoGateway();
        Connection connection = null;

        try {
            connection = Jdbc.getConnection();
            mecanicoGateway.setConnection(connection);
        } catch (SQLException e) {
            //No hay base de datos
            //TODO mejorar el error
        }finally {
            Jdbc.close(connection);
        }
        mecanicoGateway.save(nombre,apellidos);



	}

}

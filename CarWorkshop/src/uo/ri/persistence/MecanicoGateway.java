package uo.ri.persistence;

import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Created by UO226566 on 15/10/2015.
 */
public interface MecanicoGateway {

    public void setConnection(Connection c);

    public List<Map<String, Object>> findAll();

    public void update(Long id,String nombre, String apellidos);

    public void save(String nombre, String apellidos) throws BusinessException;

    public void delete(Long id);
}




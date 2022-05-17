package modelo;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alvaro
 */

//EN ESTA INTERFAZ SE LLAMAN A LOS METODOS CREADOS PARA SER UTILIZADOS EN EL PROGRAMA

public interface IntProveedores {
    // Método para obtener todos los registros de la tabla
    List<ProveedoresVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    ProveedoresVO findByPk(int pk) throws SQLException;
    
    // Método para insertar un registro
    int insertProveedor (ProveedoresVO persona) throws SQLException;
    
    // Método para insertar varios registros
    int insertProveedor (List<ProveedoresVO> lista) throws SQLException;
    
    // Método para borrar una persona
    int deleteProveedor (ProveedoresVO p) throws SQLException;
    
    // Método para borrar toda la tabla
    int deleteProveedor() throws SQLException;
    
    // Método para modificar una persona. Se modifica a la persona que tenga esa 'pk'
    // con los nuevos datos que traiga la persona 'nuevosDatos'
    int updateProveedor (int pk, ProveedoresVO nuevosDatos) throws SQLException;
}

package modelo;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alvaro
 */
public interface IntProveedores {
    // Método para obtener todos los registros de la tabla
    List<ProveedoresVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    ProveedoresVO findByPk(int pk) throws SQLException;
    
    // Método para insertar un registro
    int insertPersona (ProveedoresVO persona) throws SQLException;
    
    // Método para insertar varios registros
    int insertPersona (List<ProveedoresVO> lista) throws SQLException;
    
    // Método para borrar una persona
    int deletePersona (ProveedoresVO p) throws SQLException;
    
    // Método para borrar toda la tabla
    int deletePersona() throws SQLException;
    
    // Método para modificar una persona. Se modifica a la persona que tenga esa 'pk'
    // con los nuevos datos que traiga la persona 'nuevosDatos'
    int updatePersona (int pk, ProveedoresVO nuevosDatos) throws SQLException;
}

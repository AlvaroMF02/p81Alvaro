package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvaro
 */

    // EN ESTA CLASE CREAREMOS LOS METODOS CON LOS QUE INTERACTUAREMOS CON LA BASE DE DATOS

public class ProveedoresDAO {
    private Connection con = null;

    public ProveedoresDAO() {
        con = Conexion.getInstance();
    }

    public List<ProveedoresVO> getAll() throws SQLException {
        List<ProveedoresVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from proveedores");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                ProveedoresVO p = new ProveedoresVO();
                // Recogemos los datos de la persona, guardamos en un objeto
                p.setCodproveedor(res.getInt("codproveedor"));
                p.setNomempresa(res.getString("nomempresa"));
                p.setNomcontacto(res.getString("nomcontacto"));
                p.setDireccion(res.getString("direccion"));
                p.setCiudad(res.getString("ciudad"));
                p.setCodpostal(res.getString("codpostal"));
                
                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }

        return lista;
    }

    public ProveedoresVO findByPk(int pk) throws SQLException {

        ResultSet res = null;
        ProveedoresVO persona = new ProveedoresVO();

        String sql = "select * from proveedores where codproveedor=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, pk);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                persona.setCodproveedor(res.getInt("codproveedor"));
                persona.setNomempresa(res.getString("nomempresa"));
                persona.setNomcontacto(res.getString("nomcontacto"));
                persona.setDireccion(res.getString("direccion"));
                persona.setCiudad(res.getString("ciudad"));
                persona.setCodpostal(res.getString("codpostal"));
                persona.setCodpostal(res.getString("telefono"));
                return persona;
            }

            return null;
        }
    }

    public int insertProveedor(ProveedoresVO proveedor) throws SQLException {

        int numFilas = 0;
        String sql = "insert into proveedores values (?,?,?,?,?,?,?)";

        if (findByPk(proveedor.getCodproveedor()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, proveedor.getCodproveedor());
                prest.setString(2, proveedor.getNomempresa());
                prest.setString(3, proveedor.getNomcontacto());
                prest.setString(4, proveedor.getDireccion());
                prest.setString(5, proveedor.getCiudad());
                prest.setString(6, proveedor.getCodpostal());
                prest.setString(7, proveedor.getTelefono());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }

    }

    public int insertProveedor(List<ProveedoresVO> lista) throws SQLException {
        int numFilas = 0;

        for (ProveedoresVO tmp : lista) {
            numFilas += ProveedoresDAO.this.insertProveedor(tmp);
        }

        return numFilas;
    }

    public int deleteProveedor() throws SQLException {

        String sql = "delete from proveedores";

        int nfilas = 0;

        // Preparamos el borrado de datos  mediante un Statement
        // No hay parámetros en la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecución de la sentencia
            nfilas = st.executeUpdate(sql);
        }

        // El borrado se realizó con éxito, devolvemos filas afectadas
        return nfilas;

    }

    public int deleteProveedor(ProveedoresVO proveedor) throws SQLException {
        int numFilas = 0;

        String sql = "delete from proveedores where codproveedor = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, proveedor.getCodproveedor());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    public int updateProveedor(int pk, ProveedoresVO nuevosDatos) throws SQLException {

        int numFilas = 0;
        String sql = "update proveedores set nomempresa = ?, nomcontacto = ?, direccion = ?, ciudad = ?, codpostal = ?, telefono = ? where codproveedor=?";

        if (findByPk(pk) == null) {
            // La persona a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setString(1, nuevosDatos.getNomempresa());
                prest.setString(2, nuevosDatos.getNomcontacto());
                prest.setString(3, nuevosDatos.getDireccion());
                prest.setString(4, nuevosDatos.getCiudad());
                prest.setString(5, nuevosDatos.getCodpostal());
                prest.setString(6, nuevosDatos.getTelefono());
                prest.setInt(7, pk);

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

}

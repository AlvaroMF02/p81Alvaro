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


public class ProveedoresDAO {
    private Connection con = null;

    public ProveedoresDAO() {
        con = Conexion.getInstance();
    }

    //MUESTRA TODOS LOS ELEMENTOS QUE HAY EN LA TABLA DE LA BD
    public List<ProveedoresVO> getAll() throws SQLException {
        List<ProveedoresVO> lista = new ArrayList<>();

        try (Statement st = con.createStatement()) {

            ResultSet res = st.executeQuery("select * from proveedores");

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

    //BUSCA UN ELEMENTO POR SU CLAVE PRIMARIA
    public ProveedoresVO findByPk(int pk) throws SQLException {

        ResultSet res = null;
        ProveedoresVO persona = new ProveedoresVO();

        String sql = "select * from proveedores where codproveedor=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, pk);

            res = prest.executeQuery();

            if (res.next()) {
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

    //INSERTA FILAS EN LA TABLA PASANDOLE TODOS LOS PARAMETROS
    public int insertProveedor(ProveedoresVO proveedor) throws SQLException {

        int numFilas = 0;
        String sql = "insert into proveedores values (?,?,?,?,?,?,?)";

        if (findByPk(proveedor.getCodproveedor()) != null) {
            return numFilas;
        } else {
           
            try (PreparedStatement prest = con.prepareStatement(sql)) {
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
    
    //INSERTA FILAS EN LA TABLA PASANDOLE UNA LISTA DE OBJETOS
    public int insertProveedor(List<ProveedoresVO> lista) throws SQLException {
        int numFilas = 0;

        for (ProveedoresVO tmp : lista) {
            numFilas += ProveedoresDAO.this.insertProveedor(tmp);
        }

        return numFilas;
    }

    //ELIMINA PROVEEDORES
    public int deleteProveedor() throws SQLException {

        String sql = "delete from proveedores";

        int nfilas = 0;

        try (Statement st = con.createStatement()) {
            nfilas = st.executeUpdate(sql);
        }

        return nfilas;

    }
    
    //ELIMINA UNA PROVEEDOR POR SU CLAVE PRIMARIA
    public int deleteProveedor(ProveedoresVO proveedor) throws SQLException {
        int numFilas = 0;

        String sql = "delete from proveedores where codproveedor = ?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, proveedor.getCodproveedor());
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    //EDITA CUALQUIER CAMPO DE UN PROVEEDOR
    public int updateProveedor(int pk, ProveedoresVO nuevosDatos) throws SQLException {

        int numFilas = 0;
        String sql = "update proveedores set nomempresa = ?, nomcontacto = ?, direccion = ?, ciudad = ?, codpostal = ?, telefono = ? where codproveedor=?";

        if (findByPk(pk) == null) {
            return numFilas;
        } else {
            try (PreparedStatement prest = con.prepareStatement(sql)) {

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

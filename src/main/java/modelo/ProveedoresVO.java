package modelo;

/**
 *
 * @author alvaro
 */
public class ProveedoresVO {
    private int codproveedor;
    private String nomempresa;
    private String nomcontacto;
    private String direccion;
    private String ciudad;
    private char codpostal;
    private char telefono;

    public ProveedoresVO(int codproveedor, String nomempresa, String nomcontacto, String direccion, String ciudad, char codpostal, char telefono) {
        this.codproveedor = codproveedor;
        this.nomempresa = nomempresa;
        this.nomcontacto = nomcontacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codpostal = codpostal;
        this.telefono = telefono;
    }
    public ProveedoresVO() {
    }

    public int getCodproveedor() {
        return codproveedor;
    }

    public void setCodproveedor(int codproveedor) {
        this.codproveedor = codproveedor;
    }

    public String getNomempresa() {
        return nomempresa;
    }

    public void setNomempresa(String nomempresa) {
        this.nomempresa = nomempresa;
    }

    public String getNomcontacto() {
        return nomcontacto;
    }

    public void setNomcontacto(String nomcontacto) {
        this.nomcontacto = nomcontacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public char getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(char codpostal) {
        this.codpostal = codpostal;
    }

    public char getTelefono() {
        return telefono;
    }

    public void setTelefono(char telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ProveedoresVO{" + "codproveedor=" + codproveedor + ", nomempresa=" + nomempresa + ", nomcontacto=" + nomcontacto + ", direccion=" + direccion + ", ciudad=" + ciudad + ", codpostal=" + codpostal + ", telefono=" + telefono + '}';
    }
    
    
}

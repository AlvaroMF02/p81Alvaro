package modelo;

/**
 *
 * @author alvaro
 */


//ATRIBUTOS
public class ProveedoresVO {

    private int codproveedor;
    private String nomempresa;
    private String nomcontacto;
    private String direccion;
    private String ciudad;
    private String codpostal;
    private String telefono;

    //CONSTRUCTORES
    public ProveedoresVO(int codproveedor, String nomempresa, String nomcontacto, String direccion, String ciudad, String codpostal, String telefono) {
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

    //GETTER SETTER
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

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //TOOSTRING
    @Override
    public String toString() {
        return "Proveedor{" + "Código= " + codproveedor + ", Empresa= " + nomempresa + ", Propietario= " + nomcontacto + ", Dirección= " + direccion + ", Ciudad= " + ciudad + ", CP= " + codpostal + ", Telefono= " + telefono + '}';
    }

}

package aplicacion;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.ProveedoresDAO;
import modelo.ProveedoresVO;

/**
 *
 * @author alvaro
 */

//realizando inserciones, borrados, modificaciones y consultas. Comenta y explica todo el código.


public class Programa {
    public static void main(String[] args) {
        
        
        ProveedoresDAO daoProveedor = new ProveedoresDAO();
        List<ProveedoresVO> listaProveedores = new ArrayList<>();  
        listaProveedores.add(new ProveedoresVO(8, "Los Ganados", "Alfonso Ramirez", "C/ Huelva 189", "Madrid", "45630", "528467922"));
        listaProveedores.add(new ProveedoresVO(9, "Los Perdidos", "Fernando Ortiz", "C/ Los Pinrreles 56", "Barcelona", "56432", "946735625"));
        listaProveedores.add(new ProveedoresVO(10, "Los Rendidos", "Antonio Juanetes", "C/ Sa matao 34", "Valencia", "12345", "986745286"));
        listaProveedores.add(new ProveedoresVO(11, "Los Subordinados", "Maria Roales", "Avda. Chocolatero 78", "Cadiz", "09876", "674835093"));
        
        
        
        try {
                        
            //INSERCIÓN MEDIANTE UNA LISTA
            System.out.println("________________________________________________________________________________________________________________________________");
            System.out.println("Nº proveedores insertados " + daoProveedor.insertProveedor(listaProveedores));
            System.out.println("\n________________________________________________________________________________________________________________________________");
            List<ProveedoresVO> nuevaLista = daoProveedor.getAll();
            System.out.println("-------------------------------- Lista con datos recogidos desde la BD --------------------------------");
            nuevaLista.forEach(System.out::println);
            
            
            //CONSULTA DE DATOS
            System.out.println("\n________________________________________________________________________________________________________________________________");
            System.out.println("Proveedor con el codigo 8: ");
            System.out.println(daoProveedor.findByPk(8));
            
            
            
            //BORRADO
            System.out.println("\n________________________________________________________________________________________________________________________________");
            System.out.println("\n El proveedor 10 será borrado");
            System.out.println("Proveedor a borrar " + daoProveedor.deleteProveedor(new ProveedoresVO(10, "Los Rendidos", "Antonio Juanetes", "C/ Sa matao 34", "Valencia", "12345", "986745286")));
            System.out.println("\n ---------------------------------- Nueva lista sin el proveedor 10 ----------------------------------");
            nuevaLista = daoProveedor.getAll();
            nuevaLista.forEach(System.out::println);
            
            
            
            //MODIFICACIÓN
            System.out.println("\n________________________________________________________________________________________________________________________________");
            System.out.println("Modificación del proveedor con codigo 5");
            System.out.println("Nº proveedores modificados " + daoProveedor.updateProveedor(5, new ProveedoresVO(5, "Nueva Empresa", "Pepe Garrido", "C/ Poliero 45", "Madrid", "23334", "975467233")));
            nuevaLista = daoProveedor.getAll();
            System.out.println("-------------------------------- Lista después de modificar un proveedor --------------------------------");
            nuevaLista.forEach(System.out::println);
            

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
    }
}

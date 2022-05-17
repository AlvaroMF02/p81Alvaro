package aplicacion;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.ProveedoresVO;

/**
 *
 * @author alvaro
 */

//realizando inserciones, borrados, modificaciones y consultas. Comenta y explica todo el código.


public class Programa {
    public static void main(String[] args) {
        
        
        ProveedoresVO daoProveedor = new ProveedoresVO();
        List<ProveedoresVO> listaPersonas = new ArrayList<>();  
        listaPersonas.add(new ProveedoresVO(8, "Los Ganados", "Alfonso Ramirez", "C/ Huelva 189", "Madrid", "45630", "528467922"));
        listaPersonas.add(new ProveedoresVO(9, "Los Perdidos", "Fernando Ortiz", "C/ Los Pinrreles 56", "Barcelona", "56432", "946735625"));
        listaPersonas.add(new ProveedoresVO(10, "Los Rendidos", "Antonio Juanetes", "C/ Sa matao 34", "Valencia", "12345", "986745286"));
        listaPersonas.add(new ProveedoresVO(11, "Los Subordinados", "Maria Roales", "Avda. Chocolatero 78", "Cadiz", "09876", "674835093"));
        
        
        try {
            
            System.out.println("Nº personas insertadas " + daoProveedor.(listaPersonas));
            System.out.println("-----------------------------------------");
            
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<PersonaVO> nuevaLista = daoProveedor.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            
            System.out.println("-----------------------------------------");
            System.out.println("Persona con primary key 1: ");
            System.out.println(daoProveedor.findByPk(1));
            
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar la persona con pk 3");
            System.out.println("Nº personas borradas " + 
                    daoProveedor.deletePersona(new ProveedoresVO(3,"Pablo Pérez", LocalDate.of(1997, 12, 5))));
            
            System.out.println("-----------------------------------------");
            nuevaLista = daoProveedor.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una persona -------------");
            nuevaLista.forEach(System.out::println);
            
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de la persona con pk 5");
            System.out.println("Nº Personas modificadas " + 
                    daoProveedor.updatePersona(5, new PersonaVO(7,"NuevoNombre", LocalDate.of(2019, 6, 5))));
            
            System.out.println("-----------------------------------------");
            nuevaLista = daoProveedor.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una persona -------------");
            nuevaLista.forEach(System.out::println);
            
            System.out.println("-----------------------------------------");
            System.out.println("Ejecución del procedimiento almacenado");
            System.out.println("Se cambia María Weston por Felipe Román");
            System.out.println("Nombres cambiados " + daoProveedor.cambiarNombres("Felipe Román", "Maria Weston"));
            
            System.out.println("-----------------------------------------");
            nuevaLista = daoProveedor.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de ejecutar proced. -------------");
            nuevaLista.forEach(System.out::println);
            
            System.out.println("-----------------------------------------");
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
        System.out.println();
        listaPersonas.forEach(System.out::println);

    }
}

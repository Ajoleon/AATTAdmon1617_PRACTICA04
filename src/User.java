
import java.net.URL;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Procesa la cadena del nombre DNIe USUARIOC=ES, SERIALNUMBER=26038239P,
 * SURNAME=CUEVAS, GIVENNAME=JUAN CARLOS, CN="CUEVAS MARTINEZ, JUAN CARLOS
 * (FIRMA)"
 *
 * @author Juan Carlos Cuevas Martínez, Pablo Castillo Segura y Antonio José León Sánchez
 */
public class User {

    public static final String NAME="GIVENNAME=";
    public static final String DNI="SERIALNUMBER=";
    public static final String CN="CN=\"";
    String name = "";
    String apellidos = "";
    String dni = "";

    //Constructor vacío
    public User(){};
    
    //Constructor con la cadena de datos
    public User(String data) {

        name = data.substring(data.indexOf(NAME) + NAME.length());
        name = name.substring(0, name.indexOf(","));
        dni = data.substring(data.indexOf(DNI) + DNI.length());
        dni = dni.substring(0, dni.indexOf(","));
        apellidos = data.substring(data.indexOf(CN) + CN.length());
        apellidos = apellidos.substring(0, apellidos.indexOf(","));
    }

    public String getName() {
        return name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }
    
    /**
     * Método para devolver un array de cadenas
     * La cadena 0 devuelve la url para enviar los datos
     * La cadena 1 devuelve la cadena con los datos a firmar
     * 
     * @param url url del servidor a enviar los datos
     * @return Array de cadenas con url y datos sin firmar
     */
    public String[] firma(String url){
        Date date = new Date();
        String[] devolver = new String[2];
        devolver[0] = "name="+name +"&apellidos="+ apellidos+ "&dni="+dni+ "&fecha="+date.toString()+ "&url="+ url ;
        devolver[1] = name+apellidos+dni+date.toString()+url;
        return devolver;
    }

}

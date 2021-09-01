import org.w3c.dom.ls.LSResourceResolver;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x=-1;
        do {
            obtenerDatos ();
            System.out.println("Desea hacer algo mas?[1]Si [2]No");
            x = validarMenu (2);
        }while (x==1);
    }
    public static void obtenerDatos(){
        Scanner sc = new Scanner(System.in);

    }
    public static void llenarArreglo(){

    }
    public static mostrarMenu (){
        System.out.println ("1. Ingresar datos");
        System.out.println ("2. Mostrar sismo de mayor magnitud");
        System.out.println ("3. Contar sismos mayores o iguales a 5.0");
        System.out.println ("4. Enviar SMS por cada sismo mayor o igual a 7.0");
        System.out.println ("5.  Salir (S/N)");
    }
    public static void switchesMenu(int [] arreglo){
        switch (validarMenu (5)){
            case 1:
                System.out.println ("Ingrese sus datos.");
                break;
            case 2:
                System.out.println ("Los sismos de mayor magnitud son ");
                break;
            case 3:
                System.out.println ("Los sismos mayores o iguales a 5.0 son ");
                break;
            case 4:
                System.out.println ("");
            case 5:
                System.out.println ("Programa finalizado");
        }
    }
    //Metodo para validar int en switches.
    public static int validarMenu ( int x){
        int n = -1;
        do {
            //Scanner ponerlo dentro del DO, y dentro de una funcion
            Scanner teclado = new Scanner (System.in);
            //System.out.println("ingrese otro numero");
            try {
                n = teclado.nextInt ();
            } catch (Exception e) {
                System.out.println ("Error");
            }
            if (n < 0 || n > x) {
                System.out.println ("ingrese un numero valido");
            }
        } while (n < 0 || n > x);
        return n;
    }
}

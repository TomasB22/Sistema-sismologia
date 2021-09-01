import java.util.Scanner;
import java.util.Arrays;

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
        double[][] sismos = new double[7][10];
        mostrarMenu ();
        switchesMenu (sismos);
    }

    public static void llenarArreglo(double [][] arreglo){
        for (int i=0; i < arreglo.length; i++){
            for (int j = 0; j < arreglo[i].length; j++) {
                arreglo[i][j] = (double) (Math.random () * 9 + 1);
            }
        }
    }
    public static void mostrarMenu (){
        System.out.println ("------------------------------------------");
        System.out.println ("1. Ingresar datos");
        System.out.println ("2. Mostrar sismo de mayor magnitud");
        System.out.println ("3. Contar sismos mayores o iguales a 5.0");
        System.out.println ("4. Enviar SMS por cada sismo mayor o igual a 7.0");
        System.out.println ("5.  Salir (S/N)");
        System.out.println ("------------------------------------------");
    }
    public static void switchesMenu(double [] arreglo){
        switch (validarMenu (5)){
            case 1:
                System.out.println ("Se llenará la matriz.");
                System.out.println (Arrays.toString (arreglo));
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

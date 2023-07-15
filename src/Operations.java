import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;
import java.util.Scanner;

public class Operations {
    public static void iniciarPrograma(double sismos[][]){
        mostrarMenu(sismos);
    }
    public static void llenarArreglo(double sismos[][]){
        Random random = new Random();
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.#", decimalFormatSymbols);
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                double numero = random.nextDouble()* 9;
                String numeroFormateado = decimalFormat.format(numero);
                sismos[i][j] = Double.parseDouble(numeroFormateado);
            }
        }
        System.out.println("Datos ingresados correctamente");
        mostrarArreglo(sismos);
        mostrarMenu(sismos);
    }
    public static void mostrarArreglo(double sismos [][]){
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                System.out.print(sismos[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void mostrarSismoMayor(double sismos [][]){
        double mayor = 0;
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                if (sismos[i][j] > mayor){
                    mayor = sismos[i][j];
                    fila = i;
                    columna = j;
                }
            }
        }
        System.out.println("El sismo de mayor magnitud fue de " + mayor + " en la fila " + fila + " y columna " + columna);
        mostrarMenu(sismos);
    }
    public static void sismosMayores(double sismos [][]){
        int contador = 0;
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                if (sismos[i][j] >= 5){
                    contador++;
                }
            }
        }
        System.out.println("La cantidad de sismos mayores o iguales a 5.0 es de " + contador);
        mostrarMenu(sismos);
    }
    public static void enviarSMS(double sismos [][]){
        int contador = 0;
        for (int i = 0 ; i < sismos.length; i++){
            for (int j = 0; j < sismos[i].length; j++){
                if (sismos[i][j] >= 7){
                    contador++;
                }
            }
        }
        for (int i = 0 ; i<contador; i++){
            System.out.println("Evacue inmediatamente!");
        }
        System.out.println("Se enviaron " + contador + " SMS.");
        mostrarMenu(sismos);
    }
    public static void mostrarMenu(double sismos[][]) {
        System.out.println("------------------------------------------");
        System.out.println("1. Ingresar datos");
        System.out.println("2. Mostrar sismo de mayor magnitud");
        System.out.println("3. Contar sismos mayores o iguales a 5.0");
        System.out.println("4. Enviar SMS por cada sismo mayor o igual a 7.0");
        System.out.println("5.  Salir (S/N)");
        System.out.println("------------------------------------------");
        switchesMenu(sismos);
    }
    public static void switchesMenu(double sismos[][]){
        int opcion = validarMenu(5);
        switch (opcion) {
            case 1:
                llenarArreglo(sismos);
                break;
            case 2:
                mostrarSismoMayor(sismos);
                break;
            case 3:
                sismosMayores(sismos);
                break;
            case 4:
                enviarSMS(sismos);
                break;
            case 5:
                System.out.println("Gracias por usar el programa");
                break;
            default:
                System.out.println("Opcion no valida");
                mostrarMenu(sismos);
                break;
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

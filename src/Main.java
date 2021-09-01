import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        obtenerDatos ();
        int x = -1;
        do {
            obtenerDatos ();
            System.out.println ("Desea hacer algo mas?[1]Si [2]No");
            x = validarMenu (2);
        } while (x == 1);
    }

    public static void obtenerDatos() {
        double[][] sismos = new double[7][10];
        mostrarMenu ();
        switchesMenu (sismos);
    }


    public static void llenarArreglo(double [][] arreglo){
        for (int i=0; i < arreglo.length; i++){
            for (int j = 0; j < arreglo[i].length; j++) {
                arreglo[i][j] = (Math.random () * 9.9);
                System.out.println ("["+arreglo[i][j]+"]");
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
    public static void switchesMenu(double [][] arreglo){
        switch (validarMenu (5)){
            case 1:
                System.out.println ("Se llenará la matriz.");
                llenarArreglo (arreglo);
                break;
            case 2:
                mostrarMayor (arreglo);
                System.out.println (mostrarMayor (arreglo));
                break;
            case 3:
                System.out.println ("Los sismos mayores o iguales a 5.0 son ");
                break;
            case 4:
                mostrarSMS (arreglo);
                break;
            case 5:
                System.out.println ("Programa finalizado");
        }
    }
    public static double mostrarMayor(double [][] arreglo){
        double mayor = 0;
        for (int i=0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                if(arreglo[i][j] > mayor){
                    mayor = arreglo[i][j];
                }
            }
        }return mayor;
    }
    public static void mostrarSMS(double [][] arreglo) {
        for(int i = 0; i < 10; i++){
            for(int j = 0; j<7; j++){
                if(arreglo[i][j]==7 || arreglo[i][j] > 7){
                    System.out.println ("["+arreglo[i][j]+"]");
                    System.out.println (" ");
                    System.out.println ("Alerta! Evacuar zona costera!");
                    System.out.println (" ");
                }
            }
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

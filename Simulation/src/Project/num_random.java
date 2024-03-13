package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class num_random {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println("------------------------------");
            System.out.println("Numeros pseudo aleatorios:");
            System.out.println("------------------------------");
            System.out.println("1.-Medios cuadrados");
            System.out.println("2.-Newman");
            System.out.println("3.-Salir");
            System.out.println("------------------------------");
            System.out.print("Introduzca la opcion: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    menu2();
                    break;

                case 2:
                    menu3();
                    break;

                default:
                    break;
            }
        } while (opcion != 3);
    }

    public static void menu2() {
        int opcion = 0;
        do {
            System.out.println("------------------------------");
            System.out.println("Medios cuadrados: ");
            System.out.println("------------------------------");
            System.out.println("1.-Semilla con teclado");
            System.out.println("2.-Semilla random");
            System.out.println("3.-Salir");
            System.out.println("------------------------------");
            System.out.print("Introduzca la opcion: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    medios_teclado();
                    break;

                case 2:
                    medios_random();
                    ;
                    break;

                default:
                    break;
            }
        } while (opcion != 3);
    }

    public static void menu3() {
        int opcion = 0;
        do {
            System.out.println("------------------------------");
            System.out.println("Newman: ");
            System.out.println("------------------------------");
            System.out.println("1.-Semilla con teclado");
            System.out.println("2.-Semilla random");
            System.out.println("3.-Salir");
            System.out.println("------------------------------");
            System.out.print("Introduzca la opcion: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    newman_teclado();
                    break;

                case 2:
                    newman_random();
                    break;

                default:
                    break;
            }
        } while (opcion != 3);
    }

    public static void medios_teclado(){
        ArrayList<Integer> numerosGenerados = new ArrayList<>(); //array con todos los numeros generados
        boolean repetido=false,escero=false;//comprobantes de numero repetido 
        int semilla=0,xv=0,xn=0,contadorx=1;
        
        System.out.println("Coloque el numero semilla de 4 digitos:");
        semilla=leer.nextInt();
        xv=semilla;
        System.out.println("-------------------------------");
        System.out.println("El numero semilla es:"+semilla);
        String cadena_xn="";
            do {
                xn=(int)Math.pow(xv,2); //se eleva xn al cuadrado
                cadena_xn= Integer.toString(xn);
                if (cadena_xn.length()<8) {
                cadena_xn=contarDigitos(cadena_xn);
                }
                cadena_xn=cadena_xn.substring(2,6);//toma los digitos del medio
                xn=Integer.valueOf(cadena_xn);//se convierten los digitos del medio de string a int

                System.out.println("x"+contadorx+":"+cadena_xn);//se imprime el numero nuevo generado

                if (!numerosGenerados.contains(xn)) {//comprueba si el numero no esta repetido
                numerosGenerados.add(xn); // Agrega el nuevo número si no está repetido
                }else{
                repetido=true;//el numero es repetido y saldra del do while
                }
                if (cadena_xn=="0000"){//comprobante si los 4 digitos son igual a cero
                escero=true;
                }
                xv=xn;
                contadorx++;
            } while (escero==false&&repetido==false);
     }

    public static void medios_random(){
        ArrayList<Integer> numerosGenerados = new ArrayList<>(); //array con todos los numeros generados
        boolean repetido=false,escero=false;//comprobantes de numero repetido 
        int semilla=(int)(Math.random() * (9999 - 1000 + 1) + 1000),
        xv=semilla;
        int xn=0,contadorx=0;
        System.out.println(semilla);
        String cadena_xn="";
            do {
                xn=(int)Math.pow(xv,2); //se eleva xn al cuadrado
                cadena_xn= Integer.toString(xn);
                if (cadena_xn.length()<8) {
                cadena_xn=contarDigitos(cadena_xn);
                }
                cadena_xn=cadena_xn.substring(2,6);//toma los digitos del medio
                xn=Integer.valueOf(cadena_xn);//se convierten los digitos del medio de string a int

                

                if (!numerosGenerados.contains(xn)) {//comprueba si el numero no esta repetido
                numerosGenerados.add(xn); // Agrega el nuevo número si no está repetido
                }else{
                repetido=true;//el numero es repetido y saldra del do while
                }
                if (cadena_xn=="0000"){//comprobante si los 4 digitos son igual a cero
                escero=true;
                }
                System.out.println("x"+contadorx+":"+cadena_xn);//se imprime el numero nuevo generado
                xv=xn;
                contadorx++;
            } while (escero==false&&repetido==false);
        
     }

    public static void newman_teclado() {
        ArrayList<Long> NewmanList = new ArrayList<>();
        boolean repetido = false, escero = false;
        System.out.print("x0 = ");
        long semilla = leer.nextLong();
        String str = Newman(Long.toString(semilla * semilla));
        NewmanList.add(Long.parseLong(str));
        int cont = 1;
        do {
            long x = Long.parseLong(str);
            System.out.println("x" + cont + " = " + x);
            str = Newman(Long.toString(x * x));
            cont++;
            if (!NewmanList.contains(Long.parseLong(str))) {
                NewmanList.add(Long.parseLong(str));
            } else {
                System.out.println("x" + cont + " = " + str + "   ===REPETIDOOOO===");
                repetido = true;
            }
            if (str.charAt(0) == '0') {
                System.out.println("x" + cont + " = " + str + "   ===ES CEROOOOO===");
                escero = true;
            }
        } while (repetido == false && escero == false);
    }

    public static void newman_random() {
        ArrayList<Long> NewmanList = new ArrayList<>();
        boolean repetido = false, escero = false;
        long semilla = (long) (Math.random() * 9_000_000_000L) + 1_000_000_000L;
        System.out.println("x0 = " + semilla);
        String str = Newman(Long.toString(semilla * semilla));
        NewmanList.add(Long.parseLong(str));
        int cont = 1;
        do {
            long x = Long.parseLong(str);
            System.out.println("x" + cont + " = " + x);
            str = Newman(Long.toString(x * x));
            cont++;
            if (!NewmanList.contains(Long.parseLong(str))) {
                NewmanList.add(Long.parseLong(str));
            } else {
                System.out.println("x" + cont + " = " + str + "   ===REPETIDOOOO===");
                repetido = true;
            }
            if (str.charAt(0) == '0') {
                System.out.println("x" + cont + " = " + str + "   ===ES CEROOOOO===");
                escero = true;
            }
        } while (repetido == false && escero == false);
    }

    public static String Newman(String str) {
        if (str.length() % 2 == 0)
            str = "0" + str;

        StringBuilder sb = new StringBuilder(str);
        while (sb.length() != 5) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static String contarDigitos(String cadenax1) {
        int ceros_faltantes = 0;
        String cadenamejorada = "";
        ceros_faltantes = 8 - cadenax1.length();

        for (int i = 0; i < ceros_faltantes; i++) {
            cadenamejorada = '0' + cadenax1;
        }

        return cadenamejorada;
    }

}

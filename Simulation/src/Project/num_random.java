package Project;

import java.util.Scanner;

public class num_random {
    private static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion=0;
        
        do{
        System.out.println("------------------------------");
        System.out.println("Numeros pseudo aleatorios:");
        System.out.println("------------------------------");
        System.out.println("1.-Medios cuadrados");
        System.out.println("2.-Newman");
        System.out.println("3.-Salir");
        System.out.println("------------------------------");
        System.out.println("Introduzca la opcion:");
        opcion= leer.nextInt();
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
        }while(opcion!=3);
    }

    public static void menu2(){
        int opcion=0;
        do{
            System.out.println("------------------------------");
            System.out.println("Medios cuadrados: ");
            System.out.println("------------------------------");
            System.out.println("1.-Semilla con teclado");
            System.out.println("2.-Semilla random");
            System.out.println("3.-Salir");
            System.out.println("------------------------------");
            System.out.println("Introduzca la opcion:");
            opcion= leer.nextInt();
                switch (opcion) {
                    case 1:
                        medios_teclado();
                        break;
                
                    case 2:
                        medios_random();;
                        break;
    
                    default:
                        break;
                }
            }while(opcion!=3);
    }
        
     public static void menu3(){
        int opcion=0;
        do{
            System.out.println("------------------------------");
            System.out.println("Newman: ");
            System.out.println("------------------------------");
            System.out.println("1.-Semilla con teclado");
            System.out.println("2.-Semilla random");
            System.out.println("3.-Salir");
            System.out.println("------------------------------");
            System.out.println("Introduzca la opcion:");
            opcion= leer.nextInt();
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
            }while(opcion!=3);
        }
     
     public static void medios_teclado(){
        System.out.println("Introduce la semilla");
        int semilla=leer.nextInt();
        int x1=0;
        System.out.println(semilla);
        String cadena_semilla=Integer.toString(semilla),
        cadena_x1="";
       // do {
        x1=(int)Math.pow(semilla,2);
        cadena_x1= Integer.toString(x1);
        contarDigitos(cadena_x1);
        System.out.println(cadena_x1);
       // } while (cadena_x1!="0000");
     }

     public static void medios_random(){
        int semilla=(int)(Math.random() * (9999 - 1000 + 1) + 1000),
        x1=0;
        System.out.println(semilla);
        String cadena_semilla=Integer.toString(semilla),
        cadena_x1="";
       // do {
        x1=(int)Math.pow(semilla,2);
        cadena_x1= Integer.toString(x1);
        String cadena_mejorada=contarDigitos(cadena_x1);
        System.out.println(cadena_mejorada);
       // } while (cadena_x1!="0000");
        
     }

     public static void newman_teclado(){
        
     }

     public static void newman_random(){
        
     }

     public static String contarDigitos(String cadenax1) {
        int contador = 0;
        String cadenamejorada="";
        for (char caracter : cadenax1.toCharArray()) {
            if (Character.isDigit(caracter)) {
                contador++;
            }
        }
        
        if (contador<8){
                System.out.println("ella: ya entro? yo:....");
                cadenax1=
            
        }
        return cadenax1;
    }

    }

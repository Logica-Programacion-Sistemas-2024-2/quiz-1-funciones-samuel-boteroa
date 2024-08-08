
package quiz1sistemas;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //inicializando scanner
        Scanner sc = new Scanner(System.in);

        // Recolectando los datos del usuario
        System.out.println("¿Cuantas Boletas Desea Comprar?");
        int numeroBoletas = sc.nextInt();
        sc.nextLine();
        System.out.println("¿Desea voletas generales o VIP? (V|G)");
        String tipoCliente = sc.nextLine();
        System.out.println("¿Que combo desea comprar? (1|2|3)");
        int tipoCombo = sc.nextInt();
        sc.nextLine();
        System.out.println("¿Cuantos combos desea comprar?");
        int cantidadCombo = sc.nextInt();
        sc.nextLine();

        //Operaciones 
        int precioBoletas = calcularValorBoleta(tipoCliente, numeroBoletas);
        int precioCombo = calcularValorNetoCombo(tipoCombo,cantidadCombo);
        int descuento = calcularDescuentoCombo(tipoCliente, tipoCombo, precioCombo);
        int valorPagar = calcularValorFactura(precioBoletas, precioCombo, descuento);

        //Imprimir la factura en pantalla
        System.out.println("Tipo de Cliente: " + tipoCliente);
        System.out.println("Numero de boletas: " + numeroBoletas);
        System.out.println("Precio Boletas: " + precioBoletas);
        System.out.println("Combo Seleccionado: " + tipoCombo);
        System.out.println("Cantidad de combos comprados: " + cantidadCombo);
        System.out.println("Precio Combos: "+ precioCombo);
        System.out.println("Descuentos: "+descuento);
        System.out.println("---------------");
        System.out.println("Valor a Pagar: "+ valorPagar);
        
    }

    /*
     * Implemente una funcion llamada calcularValorBoleta que cumpla con las
     * siguientes caracteristicas
     * Recibe:
     * - Una cadena de caracteres que representa el tipo de silla comprada (V ó G)
     * - Un entero que representa la cantidad de boletas compradas
     * Retorna:
     * - Un entero representando el valor total de las boletas
     */
    // ------------------------------------------------------------------

    public static int calcularValorBoleta(String silla, int boletas) {
        try {
            int valorBoletas = 0;
            if (boletas >= 1) {
                if (silla.equals("V")) {
                    valorBoletas = boletas * 15000;
                } else if (silla.equals("G")) {
                    valorBoletas = boletas * 10000;
                }
                return valorBoletas;
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    // ------------------------------------------------------------------

    /*
     * Implemente una funcion llamada calcularValorNetoCombo que cumpla con las
     * siguientes caracteristicas
     * Recibe:
     * - Un entero representando el numero de combo selecciondo
     * - Un entero representando la cantidad de combos comprados
     * Retorna:
     * - Un entero representando el valor neto del combo
     */
    // ------------------------------------------------------------------

    public static int calcularValorNetoCombo(int combo, int cantidad) {
        try {
            int valorNeto = 0;
            if (cantidad >= 1) {
                switch (combo) {
                    case 1:
                        valorNeto = 40000 * cantidad;
                        break;
                    case 2:
                        valorNeto = 30000 * cantidad;
                        break;
                    case 3:
                        valorNeto = 42000 * cantidad;
                    default:
                        break;
                }
                return valorNeto;
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    // ------------------------------------------------------------------

    /*
     * Implemente una funcion llamada calcularDescuentoCombo que cumpla con las
     * siguientes caracteristicas
     * Recibe:
     * - Una cadena de caracteres que representa el tipo de silla comprada (V ó G)
     * - Un entero representando el valor neto del combo
     * Retorna:
     * - Un entero representando el valor del descuento
     */
    // ------------------------------------------------------------------

    public static int calcularDescuentoCombo(String silla, int combo, int valorCombo){
        try {
            double valorDescuento = 0.0;
            if (silla.equals("V")){
                switch (combo) {
                    case 1:
                        valorDescuento = valorCombo*0.05;
                        break;
                    case 2:
                        valorDescuento = valorCombo*0.06;
                        break;
                    case 3:
                        valorDescuento = valorCombo*0.03;
                    default:
                        break;
                }
                return (int)valorDescuento;
            }
            else if (silla.equals("G")){
                valorDescuento = 0;
                return (int)valorDescuento;
            }else {
                return -1;
            }
            
        } catch (Exception e) {
            return -1;
        }
    }

    // ------------------------------------------------------------------

    /*
     * Implemente una funcion llamada calcularValorFactura que cumpla con las
     * siguientes caracteristicas
     * Recibe:
     * - Un entero representando el valor neto del combo
     * - Un entero representando el valor de las boletas
     * - Un entero representando el valor del descuento del combo
     * Retorna:
     * - Un entero representando el valor total de la factura
     */
    // ------------------------------------------------------------------

    public static int calcularValorFactura(int valorCombo, int valorBoletas, int descuentoCombo){
        try {
            if (valorBoletas >= 10000){
                int valorFactura = valorBoletas+valorCombo-descuentoCombo;
                return valorFactura;
            }else{
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    // ------------------------------------------------------------------
}

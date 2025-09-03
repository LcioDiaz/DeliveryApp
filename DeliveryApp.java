import java.util.Scanner;

public class DeliveryApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Registro: nombre y correo Gmail
        System.out.println("=== DeliveryApp  ===\n");

        System.out.print("Ingrese su nombre completo: ");
        String nombre = sc.nextLine().trim();

        // Validación simple: debe terminar en @gmail.com
        String email;
        while (true) {
            System.out.print("Ingresa su correo (debe ser Gmail): ");
            email = sc.nextLine().trim().toLowerCase();
            if (email.endsWith("@gmail.com")) {
                break;
            } else {
                System.out.println("Correo inválido. Debe ser una cuenta @gmail.com.\n");
            }
        }

        // Datos de la compra: total y distancia
        int totalCompra = 0;
        int distanciaKm = 0;

        while (true) {
            System.out.print("Ingrese el Total de la compra: ");
            String in = sc.nextLine().trim();
            try {
                totalCompra = Integer.parseInt(in);
                if (totalCompra < 0) {
                    System.out.println("El total no puede ser negativo.\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Intenta nuevamente.\n");
            }
        }

        while (true) {
            System.out.print("Ingrese la Distancia al domicilio en km: ");
            String in = sc.nextLine().trim();
            try {
                distanciaKm = Integer.parseInt(in);
                if (distanciaKm < 0) {
                    System.out.println("La distancia no puede ser negativa.\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Intenta nuevamente.\n");
            }
        }

        // Cálculo del costo de despacho
        int costoDespacho = 0; // <-- DECLARADA

        if (totalCompra > 50000) {
            // Gratis hasta 20 km; si supera 20 km, $150 por km excedente
            if (distanciaKm <= 20) {
                costoDespacho = 0;
            } else {
                costoDespacho = (distanciaKm - 20) * 150;
            }
        } else if (totalCompra >= 25000) { // incluye el caso 50.000
            costoDespacho = distanciaKm * 150;
        } else {
            costoDespacho = distanciaKm * 300;
        }
        
        // Costo total final 

        int totalAPagar = totalCompra + costoDespacho;

        //  Impresiones del resumen final de la orden
        System.out.println("\n=== Resumen de la Orden ===");
        System.out.println("Cliente: " + nombre);
        System.out.println("-------------------------------");
        System.out.println("Correo : " + email);
        System.out.println("Total compra        : $" + totalCompra);
        System.out.println("Distancia (km)      : " + distanciaKm + " km");
        System.out.println("Costo de despacho   : $" + costoDespacho);
        System.out.println("-------------------------------");
        System.out.println("TOTAL A PAGAR       : $" + totalAPagar);
        System.out.println("-------------------------------");
        System.out.println("\nGracias por su compra.");

        sc.close();
    }
}


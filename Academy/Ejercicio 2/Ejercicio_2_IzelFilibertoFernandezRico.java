/*
Ejercicio 2: Validación de Número de Cuenta 

Descripción: 
Verifica si un número de cuenta bancaria (string) es válido. Una cuenta válida tiene exactamente 10 dígitos numéricos. 

Ejercicio 2.1: Pruebas de Validación de Número de Cuenta 

Descripción: 
Probar una función que valida si un número de cuenta contiene exactamente 10 dígitos. 

Objetivo: 
Evaluar la habilidad del tester para identificar condiciones de validación y errores. 

Actividades esperadas: 

Generar un conjunto de casos de prueba con distintos formatos de entrada. 
Identificar valores válidos, inválidos y bordes. 
Indicar resultado esperado y prioridad de prueba. 
*/

import java.util.Scanner;

public class Ejercicio_2_IzelFilibertoFernandezRico {
    public static void main(String[] args) throws Exception {
        String cuentaBancaria = "";
        Scanner a = new Scanner(System.in);
        Integer flag = 0;
        Integer Parsed = 0;
 
        System.out.println("Ingresa el numero de tu cuenta bancaria");
        try {
        String Ingresado = a.nextLine();
        cuentaBancaria = Ingresado;
        } catch (Exception e) {
        System.out.println("Tipo de dato incorrecto");
        flag = 1;
        return;
        }
        if (flag==0) {
            try {
            Parsed = Integer.parseInt(cuentaBancaria);
            } catch (Exception e) {
            System.out.println("Ingresaste una cuenta bancaria incorrecta");
            return;
            }
            
            if(cuentaBancaria.length() == 10){
             System.out.println("Verificacion exitosa Cuenta bancaria " + cuentaBancaria);
             return;
            }
            System.out.println("Tu cuenta bancaria no era de la longitud correcta, su longitud es: " + cuentaBancaria.length());
        }
    }
}

# Pruebas funcionales - Pruebas de Gestión de Clientes Bancarios 

**Ejercicio 3.3 – Tester: Citlaly Lizeth Cruz Gómez**

# Objetivos: 
    - Validar que el sistema de gestión de clientes bancarios responda correctamente a las operaciones principales: consultar saldo, depositar y retirar.
    - Comprobar que el sistema maneje adecuadamente las entradas inválidas.
    - Verificar que el sistema impida operaciones no válidas, como retiros mayores al saldo disponible.
    - Confirmar que el sistema muestre mensajes claros y correctos ante cada tipo de operación.
    - Asegurar que el comportamiento del sistema coincida con los resultados esperados en todos los casos de prueba definidos.

# Casos de prueba:
El case para este caso de prueba es el siguiente:
    1. Consultar saldo. 
    2. Depositar. 
    3. Retirar. 
    4. Salir 
    
1. Consultar saldo.
    Entrada: 1.
    Resultado esperado: Tu saldo es de: 5000.0,
    Resultado obtenido: Tu saldo es de: 5000.0.
    Estado OK.

2. Depositar.
2.1 Deposito de numeros validos:
    Entrada: 2.
    Entrada deposito: 3000. 
    Resultado esperado: Tu saldo es de: 8000.0
    Resultado obtenido: Tu saldo es de: 8000.0
    Estado: Ok.

2.2 Deposito numeros invalidos:
    Entrada: 2.
    Entrada deposito: d. 
    Resultado esperado: Entrada invalida. Solo se permiten numeros.
    Resultado obtenido: Entrada invalida. Solo se permiten numeros.
    Estado: Ok.

3. Retiro.
3.1 Retiro números válidos:
Entrada: 3.
Entrada retiro: 2000.
Resultado esperado: Retiro exitoso. Tu saldo es de: 3000.0
Resultado obtenido: Retiro exitoso. Tu saldo es de: 3000.0
Estado: OK.

3.2 Retiro números inválidos:
Entrada: 3.
Entrada retiro: d.
Resultado esperado: Entrada inválida. Solo se permiten números.
Resultado obtenido: Entrada inválida. Solo se permiten números.
Estado: OK.

3.3 Retiro mayor al saldo disponible:
Entrada: 3.
Saldo actual: 5000.
Entrada retiro: 7000.
Resultado esperado: No puedes retirar más de lo que tienes.
Resultado obtenido: No puedes retirar más de lo que tienes.
Estado: OK.

# Criterios de aceptacion:
1. El sistema debe arrojar entrada invalida en los casos donde la entrada no sea un numero positivo.
2. El sistema debe permitir ingresar saldo y retirar dinero. 

# Conclusiones: 
1. El sistema no presento ningun error en la ejecucion. 
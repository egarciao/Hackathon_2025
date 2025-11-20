# Pruebas funcionales - Pruebas de Gestión de Clientes Bancarios 

**Ejercicio 3.3 – Tester: Citlaly Lizeth Cruz Gómez**

# Objetivos: 
    - Probar listas, eliminacion de lista y modificaciones. 
    - Verificar resultados obtenidos y resultados.
    - Validar correctos resultados.
    - Confirmar que el sistema maneja correctamente listas vacías y modificaciones.

# Casos de prueba:
El case para este caso de prueba es el siguiente:
    1. Listar clientes.
    2. Mostrar cliente con mayor saldo.
    3. Eliminar todos los clientes.
    4. Añadir cliente.
    5. Salir
    
1. Caso de prueba para listar clientes:
1.1 Si hay clientes:
    Entrada: 1.
    Resultado esperado: Lista de clientes.
    Resultado obtenido:
        1
        Actualmente los clientes existentes son:
        Saul con un saldo de 50000.0
        Ian con un saldo de 40000.0
        Ricardo con un saldo de 37800.0
        Fabiola con un saldo de 98000.0
        Ignacio con un saldo de 24000.0
    Estado: OK
1.2 Si no hay clientes.
    Precondición: Se ejecutó primero la opción 3 (eliminar todos los clientes)  
    Entrada: 1.
    Resultado esperado: No hay clientes.
    Resultado obtenido: No hay clientes registrados.
    Estado: OK.

2. Calcular correctamente el cliente con mayor saldo: 
1.1 Si hay clientes:
    Entrada: 2  
    Resultado esperado: Mostrar el cliente con mayor saldo  
        En los datos iniciales: Fabiola – 98000.0 
    Resultado obtenido: Fabiola con un saldo de 98000.0
    Estado: OK 

2.2 Si no hay clientes.
    Precondicion: Se ejecuto primero la opcion 3.
    Entrada: 2.
    Resultado esperado: No hay clientes.
    Resultado obtenido: No hay clientes registrados.
    Estado: Ok. 

# Criterios de aceptacion:
1. El sistema debe manejar correctamente lista vacias.
2. El sistema debe permitir añadir nuevos clientes y eliminar clientes.
3. El sistema debe calcular correctamente el cliente con mayor saldo. 

# Conclusiones: 
1. El sistema no presento ningun error. 
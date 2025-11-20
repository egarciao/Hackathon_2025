# Pruebas funcionales - Pruebas de Validación de Número de Cuenta 

**Ejercicio 2.2 – Tester: Citlaly Lizeth Cruz Gómez**

# Objetivos: 
    - Probar valores validos e invalidos.
    - Verificar resultados obtenidos y resultados.

# Casos de prueba:
| Caso | Valor ingresado | Resultado esperado | Resultado | Estado
1. Validacion de 10 digitos | 1234567890 | Cuenta valida: 1234567890 | OK
2. Validacion de letras | maravilla1 | Cuenta invalida. Debe tener exactamente 10 numeros.| | Cuenta invalida. Debe tener exactamente 10 numeros.|OK
3. Validacion de menos digitos | 12345 | | Cuenta invalida. Debe tener exactamente 10 numeros.| | Cuenta invalida. Debe tener exactamente 10 numeros.| OK
4 Salir al presionar 0 | 0 | Gracias por usar el sistema de validacion! | Gracias por usar el sistema de validacion! | OK

# Criterios de aceptacion:
1. El sistema debe aceptar cuentas con 10 digitos.
2. El sistema debe denegar letras y cuentas con menos de 10 digitos.
3. El sistema debe salirse al presionar 0. 

# Conclusiones: 
1. El sistema acepta cuenta con 10 digitos.
2. El sistema denega cualquier caso donde no sean 10 digitos numeros positivos. 
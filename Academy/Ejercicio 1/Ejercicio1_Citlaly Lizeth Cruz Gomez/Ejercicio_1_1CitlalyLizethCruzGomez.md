# Pruebas funcionales - Calculo de interes simple

**Ejercicio 1.1 – Tester: Citlaly Lizeth Cruz Gómez**

# Objetivos: 
    - Probar valores validos e invalidos.
    - Verificar resultados obtenidos y resultados.

# Casos de prueba:
| Caso | Monto | Interes | Años  | Interes esperado | Monto final Esperado | Resultado | Estado 
1. Valores validos normales | 1000 | 15 | 2 | 300 | 1300 | 1300 | OK
2. Valores negativos | -300 | 2 | 1 | NA | NA | -306 | Fallido
3. Flotantes | 5400.43 | 15.3 | 1.6 | 1322.025 | 6722.45 | 6722.4552 | OK

# Criterios de aceptacion:
1. El sistema debe calcular interes segun la formula.
2. El monto final debe ser correcto.
3. Aceptar valores enteros.
4. No permitir numeros negativos.

# Conclusiones: 
1. El sistema permite numeros negativos.
2. Los valores enteros funcionan correctamente.
3. El monto final esta bien calculado en todos los casos. 
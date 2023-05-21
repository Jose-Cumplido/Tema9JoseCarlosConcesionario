# Tema8JoseCarlosConcesionario
Proyecto Tema 8

Proyecto final de 1º DAM Programacion Construido con Java.

## Este proyecto consiste en diseñar una BBDD y una libreria la cual pueda gestionar dicha BBDD.

En este caso tomaremos como ejemplo una BBDD de un concesionario, la cual contara con 3 tablas las cuales
seran: 
* Cliente, la cual almacenara los datos de dichos clientes asi como su nombre, apellidos,etc...
* Coche, la cual almacenara todos los datosde los diferentes coches asi como su marca, modelo,etc...
* Venta, la cual contendra las compras realizadas por los clientes indicando el coche que compraron y su fecha de compra

## Funcionalidad de la libreria
1. (ce: b) Gestión de la conexión a la bbdd, sólo hay un objeto de conexión instanciado. 
Decidir si se manejan las transacciones de manera manual.

2. Gestor de datos (usa un objeto del tipo conexión). No se puede usar el gestor de datos si no tiene una conexión activa.
Todos los métodos que modifican datos deben devolver algo.

    1. (ce: d,f) Se debe poder consultar los datos de cualquiera de las tablas de la bbdd
    2. (ce: d,f) Se debe poder filtrar los datos de cualquiera de las tablas de la bbdd, al menos por 2 campos
    3.(ce: d,f) Se pueden obtener los datos de una consulta de manera ordenada por alguno de los campos seleccionados
    4. (ce: e) Se debe poder modificar cualquiera de los registros de una tabla
    5. (ce: c) Se debe poder añadir nuevos registros a una tabla, de uno en uno o varios
    6. (ce: e) Se debe poder eliminar registros de una tabla, de uno en uno o varios 

## Integrantes
* [José Carlos Cumplido González](https://github.com/Jose-Cumplido)

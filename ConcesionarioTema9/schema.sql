drop database if exists concesionario;
create database concesionario;
use concesionario;

            CREATE TABLE cliente(
                id INT auto_increment,
                nombre VARCHAR (50),
                apellidouno VARCHAR (50),
                apellidodos VARCHAR (50),
                email VARCHAR (50),
                CONSTRAINT PK_cliente PRIMARY KEY (id)
            );
            
             CREATE TABLE coche(
                id INT auto_increment,
                modelo VARCHAR (50),
                precio DOUBLE,
                fabricante VARCHAR(50),
                anio INT,
                km INT,
                matricula VARCHAR(8),
                CONSTRAINT PK_coche PRIMARY KEY (id)
            );
            
             CREATE TABLE venta(
                id INT auto_increment,
                id_cliente INT not null,
                Id_coche INT not null,
                fecha_de_compra DATE not null,
                CONSTRAINT PK_venta PRIMARY KEY (id,id_cliente,id_coche),
                CONSTRAINT FK_clienteventa FOREIGN KEY (id_cliente) REFERENCES cliente (id),
                CONSTRAINT FK_cocheventa FOREIGN KEY (id_coche) REFERENCES coche (id)
            );
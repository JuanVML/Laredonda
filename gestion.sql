-- Crear la base de datos
CREATE DATABASE Laredonda;
GO

-- Usar la base de datos creada
USE Laredonda;
GO

-- Crear la tabla Usuarios
CREATE TABLE Usuarios (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    NombreUsuario NVARCHAR(50) NOT NULL,
    Correo NVARCHAR(100) NOT NULL,
    Contrasena NVARCHAR(100) NOT NULL,
    DiaNacimiento INT NOT NULL,
    MesNacimiento NVARCHAR(20) NOT NULL,
    AnioNacimiento INT NOT NULL
);
drop table campos
go

CREATE TABLE Reservas (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Nombre NVARCHAR(100) NOT NULL,
    Celular NVARCHAR(20) NOT NULL,
    DNI NVARCHAR(15) NOT NULL,
    Fecha DATE NOT NULL,
    TipoDeDeporte NVARCHAR(50) NOT NULL,
    NumeroCampo INT NOT NULL
);

CREATE TABLE campos (
    id INT PRIMARY KEY IDENTITY(1,1),
    HoraInicio VARCHAR(10),
    HoraFin VARCHAR(10),
    CostoTiempo DECIMAL(10, 2),
    MontoEquipos DECIMAL(10, 2),
    PagoTotal DECIMAL(10, 2)
);

GO
SELECT * FROM Usuarios;
SELECT * FROM campos;
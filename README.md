# Clinica odontológica - proyectoBackendJava - 

### Pre-requisitos 📋

- Java 11
- Maven

### Instalación 🔧

- Ejecutar el pom del proyecto desde un IDE o consola.
- Con maven dar un clean y un package.
- Ejecutar el .jar.

## Construido con 🛠️

* [Spring boot](https://spring.io/) - Manejador de dependencias

## Wiki 📖

### Descripción
El proyecto consiste en el desarrollo de una API Rest para una clinica odontologica, clinica con la caracteristica de estar las 24 horas abierta las siete días de la semana, hay espacio para que todos los odontologos atiendan a cualquier hora.

### Login
Para utilizar la aplicación primero se debe realizar el login
http://localhost:8081/login
##### Usuario administrador (Recomendado todas las funcionalidades)
username = admin@digital.com
password = password 

##### Usuario usuario (Solo turnos)
username = user@digital.com
password = password2

### Odontologo

#### Crear odontologo  (POST)
http://localhost:8081/odontologos/nuevo

{
    "nombre": "Valentina",
    "apellido": "Varela",
    "matricula": "ARG0001"
}

{
    "nombre": "Rodrigo",
    "apellido": "Presacco",
    "matricula": "ARG0002"
}

{
    "nombre": "Rodrigo",
    "apellido": "Tanco",
    "matricula": "ARG0003"
}

#### Buscar todos los odontologos (GET)
http://localhost:8081/odontologos/todos

#### Actualizar odontologo (PUT)
http://localhost:8081/odontologos/actualizar
{
    "id": 3,
    "nombre": "Rodrigo",
    "apellido": "Luna",
    "matricula": "ARG0002"
}

#### Buscar por nombre (GET)
http://localhost:8081/odontologos/buscarPorNombre/Rodrigo

Reemplazar Rodrigo por otros nombres

#### Consultar por Id (GET)
http://localhost:8081/odontologos/buscarPorId/1
Reemplazar el 1 por otros IDs

#### Eliminar por Id (DELETE)
http://localhost:8081/odontologos/eliminar/1
Reemplazar 1 por otros IDs

#### Elimina odontólogo (DELETE)
http://localhost:8081/odontologos/eliminar
{"id": 2,
        "nombre": "Rodrigo",
        "apellido": "Luna",
        "matricula": "ARG0002"
}

### Paciente

#### Crear paciente  (POST)
http://localhost:8081/pacientes/nuevo

{
"nombre": "Jhon",
 "apellido": "Parra",
 "dni": "93201005641",
    "domicilio": {
        "calle": "Calle 70B",
       "numero": "107C",
        "localidad": "Engativa",
        "provincia": "Bogota"
    }
}

#### Buscar todos los pacientes (GET)
http://localhost:8081/pacientes/todos

#### Actualizar paciente (PUT)
http://localhost:8081/pacientes/actualizar

{
  "id": 1,
  "nombre": "Jhon Alexis",
  "apellido": "Parra",
  "dni": "93201005641",
  "domicilio": {
      "id": 1,
      "calle": "Calle 80B",
      "numero": "107C",
    "localidad": "Engativa",
       "provincia": "Bogota"
   }
}

#### Buscar Por Id (GET)
http://localhost:8081/pacientes/buscarPorId/1
Reemplazar 1 por otros IDs

#### Elimiar por ID (DELETE)
http://localhost:8081/pacientes/eliminar/1
Reemplazar 1 por otros IDs

### Turnos

#### Crear Turno  (POST)
http://localhost:8081/turnos/nuevo
{
    "odontologo" : {"id": 1},
    "paciente" : {"id": 1},
    "fechaTurno" : "2021-10-25T18:00:00"
}

#### Listar turnos (GET)
http://localhost:8081/turnos/listarTodos

#### Buscar turno por id (GET)
http://localhost:8081/turnos/buscarPorId/1
Reemplazar 1 por otros IDs

#### Actualizar turno (PUT)
http://localhost:8081/turnos/actualizar
{
    "id" : 1,
    "odontologo" : {"id": 1},
    "paciente" : {"id": 1},
    "fechaTurno" : "2021-10-25T20:00:00"
}

#### Eliminar turno por ID (DELETE)
http://localhost:8081/turnos/eliminar/1
Reemplazar 1 por otros IDs

## Autor

* **Jhon Parra** - *Bogotá-Colombia* - [jhonalexis-parra](https://github.com/jhonalexis-parra)


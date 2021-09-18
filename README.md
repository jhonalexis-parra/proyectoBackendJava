# proyectoBackendJava - Clinica odontológica

### Pre-requisitos 📋

- Java 11
- Maven

### Instalación 🔧

- Ejecutar el pom del proyecto desde un IDE o consola.
- Con maven dar un clean y un package.
- Ejecutar el .jar.

## Construido con 🛠️

* [Maven](https://maven.apache.org/) - Manejador de dependencias

## Wiki 📖

### Odontologo

#### Crear odontologo
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

#### Buscar todos los odontologos
http://localhost:8081/odontologos/todos

#### Actualizar odontologo
http://localhost:8081/odontologos/actualizar
{
    "id": 3,
    "nombre": "Rodrigo",
    "apellido": "Luna",
    "matricula": "ARG0002"
}

#### Buscar por nombre
http://localhost:8081/odontologos/buscarPorNombre/Rodrigo

Reemplazar Rodrigo por otros nombres

### Paciente

#### Crear paciente
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

#### Buscar todos los pacientes
http://localhost:8081/pacientes/todos

#### Actualizar paciente
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


### Domicilio

#### Buscar todos los odontologos
http://localhost:8081/domicilios/todos


**Funcionalidad actual actualizar paciente:** es posible actualizar los pacientes y el domicilio pero se debe enviar el id del domicilio para no crear uno nuevo.
**Funcionalidad actual buscarOdontologoPorNombre:** se construye la consulta de ejemplo de buscar nombre por odontologo.

**Funcionalidades ha realizar:** falta validar los campos de los actualizaciones y agregar el buscar por id y el borrar en todas las entidades.

**Por implementar:**
1. Turnos
2. Log4j
3. Nuevas consultas HQL

## Autor

* **Jhon Parra** - *Bogotá-Colombia* - [jhonalexis-parra](https://github.com/jhonalexis-parra)


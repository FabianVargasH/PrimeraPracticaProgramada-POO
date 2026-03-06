# Primera Práctica Programada POO <img width="110" height="79" alt="Logo Cenfotec Actual (1)" src="https://github.com/user-attachments/assets/03052c25-961a-46ba-af07-3a2c591481ae" />


## Descripción
Aplicación de consola desarrollada en Java que permite registrar mascotas y administrar información de localización mediante dispositivos inteligentes asociados a collares.

## Clases del Dominio

### Mascota
- **Atributos**: id, nombre, especie, estado, dispositivo
- **Métodos**: crearDispositivo(), getters/setters, equals(), toString()

### DispositivoLocalizacion
- **Atributos**: codigo, estado, mascota, registros
- **Métodos**: registrarUbicacion(), getters/setters, equals(), toString()

### RegistroUbicacion
- **Atributos**: id, fechaHora, ubicacion, dispositivo
- **Métodos**: getters/setters, equals(), toString()

## Casos de Uso
1. Registrar mascota
2. Asociar dispositivo a mascota
3. Registrar ubicación manual
4. Consultar información de mascota

## Autor
Fabián Vargas Hidalgo


# Sistema de Gestion Bancaria

### Links de Descarga de Requisitos

- **JDK 17**: [Descargar JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- **MySQL 8**: [Descargar MySQL 8](https://dev.mysql.com/downloads/mysql/)

### Correr Proyecto Local

```bash
mvn clean install
mvn spring-boot:run
mvn clean package
```

---

## Endpoints

### Clientes

**Method GET**

- Listar Clientes: `http://localhost:8080/api/clientes`
- Obtener Cliente por ID: `http://localhost:8080/api/clientes/{id}`

### Cuentas Bancarias

**Method POST**

- Crear una Cuenta Bancaria: `http://localhost:8080/api/cuentas`

  ```json
  {
    "numeroCuenta": "12345",
    "tipoCuenta": "Ahorros",
    "saldo": 1000.00
  }
  ```

### Transacciones

**Method GET**

- Transferir Fondos: `http://localhost:8080/api/transacciones/transferencia?cuentaOrigen={id}&cuentaDestino={id}&monto={monto}`
  
  **Ejemplo:**
  ```
  http://localhost:8080/api/transacciones/transferencia?cuentaOrigen=1&cuentaDestino=2&monto=500.00
  

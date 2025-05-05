# UnitControlMilitary

**Aplicación de escritorio orientada a la gestión militar. Revisión y publicación profesional del proyecto final desarrollado como parte del Grado Superior en Desarrollo de Aplicaciones Multiplataforma (DAM), originalmente presentado en 2023.**

## 📌 Introducción

UnitControlMilitary está diseñada para ser utilizada dentro del ámbito de las fuerzas armadas. Permite realizar operaciones CRUD (crear, leer, actualizar y eliminar) sobre distintas entidades como personal, vehículos, armamento y transmisiones, mejorando la eficiencia y la organización interna.

Esta versión publicada en 2025 supone una revisión estructural del código original, orientado a mostrar el trabajo realizado como desarrollador.

## 🎯 Objetivos de la aplicación

- Digitalizar la gestión de unidades militares.
- Proporcionar una interfaz intuitiva y moderna.
- Integrar funcionalidades como generación de informes en PDF.
- Facilitar futuras mejoras y mantenimiento.

## 🛠 Tecnologías utilizadas

- Java SE
- NetBeans IDE
- Swing 
- JDBC para conexión con bases de datos
- XAMPP 
- IText 5.5.13.3 (para generación de PDFs)
- AbsoluteLayout (para disposición de componentes)

## 📦 Requisitos previos e instalación

1. **Instalar y activar el módulo MySQL.**
  - La aplicación está configurada para conectarse a **localhost** usando el usuario por defecto de MySQL (`root`, sin contraseña).
  - Esto permite que la base de datos se genere automáticamente al iniciar la aplicación, sin intervención manual por parte del usuario.
2. **Instalar un lector de PDF.**
3. **Clonar el repositorio.**
4. **Importar el proyecto en NetBeans.**
5. **Ejecutar la aplicación y asegurarse de que la base de datos se ha creado automáticamente (verificación desde phpMyAdmin).**

## 🔐 Credenciales por defecto
- Usuario: Admin
- Contraseña: 1234

## 🧪 Guía de uso
1. Inicia XAMPP y activar MySQL. 
2. Inicia la aplicacion desde el IDE.
   - La base de datos `unitcontrolmilitary` se generará automáticamente si no existe.
   - No es necesario configurar usuarios, contraseñas ni scripts SQL manualmente.
3. Introduce las credenciales para acceder al menú principal.
4. Desde el menú puedes acceder a:
  - Personal
  - Vehículos
  - Armamento
  - Transmisiones
  - Accede a la sección de Consultas para filtrar datos y generar informes PDF.

## 🧾 Generación de informes
La aplicación permite generar informes en formato PDF con un solo clic, gracias a la integración con la biblioteca iText 5.5.13.3.

## 🚨 Mensajes de error comunes
**"Ya existe ese registro con ese campo TIM":**  
El campo TIM debe ser único.

**"El formato del campo TIM no es correcto":**
Debe tener 11 números y una letra.

**"El formato del campo matrícula no es correcto":**
Formato “ET” + 8 números.

**Asegúrate de introducir correctamente el formato de cada campo. Hay una leyenda al pie de cada tabla.**

## ❓ Preguntas frecuentes
No consigo acceder al sistema: Asegúrate de que MySQL está activo.

No se genera el PDF: Verifica que tienes instalado un lector de PDF.

Error al introducir datos: Verifica el formato requerido para cada campo.

## 🗂 Documentación adicional
docs/Memoria.pdf: Memoria técnica del proyecto.

docs/Manual.pdf: Manual de usuario con capturas y detalles funcionales.

## 📜 Licencia
Distribuido bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.

# 📁 Estructura del proyecto
UnitControlMilitary/
├── docs/                      # Documentación del proyecto
│   ├── Manual.pdf             # Manual de usuario con capturas y explicación detallada
│   └── Memoria.pdf            # Memoria técnica del desarrollo del proyecto
│
├── src/                       # Código fuente de la aplicación
│   ├── clases/                # Clases de la lógica de la aplicación
│   │   ├── Armamento.java
│   │   ├── ArmamentoClass.java
│   │   ├── BDConn.java
│   │   ├── BDCreate.java
│   │   ├── Consultas.java
│   │   ├── Login.java
│   │   ├── LoginClass.java
│   │   ├── Personal.java
│   │   ├── PersonalClass.java
│   │   ├── PersonalVehiculosClass.java
│   │   ├── TelefonosClass.java
│   │   ├── Transmisiones.java
│   │   ├── TransmisionesClass.java
│   │   ├── Vehiculos.java
│   │   └── VehiculosClass.java
│   │
│   ├── interfaz/              # Interfaz gráfica desarrollada con Swing
│   │   ├── ArmamentoUI.java
│   │   ├── ConsultaUI.java
│   │   ├── LoginUI.java
│   │   ├── MenuUI.java
│   │   ├── PersonalUI.java
│   │   ├── TransmisionesUI.java
│   │   └── VehiculosUI.java
│   │
│   ├── lib/                   # Bibliotecas externas utilizadas
│   │   ├── AbsoluteLayout.jar
│   │   ├── itextpdf-5.5.13.3.jar
│   │   └── mysql-connector-java-8.0.18.jar
│   │
│   ├── reportespdf/           # Generación de informes PDF
│   │   └── PlantillaPDF.java
│   │
│   └── UnitControlMilitary/   # Paquete principal de la aplicación
│       └── UnitControlMilitary.java
│
├── .gitignore                 # Archivos ignorados por Git
├── LICENSE                    # Licencia MIT
└── README.md                  # Este archivo




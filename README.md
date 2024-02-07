# Educasen - Aplicación de Registro e Inicio de Sesión

Educasen es una aplicación Android desarrollada en Java que permite a los usuarios registrarse e iniciar sesión. Utiliza Firebase como base de datos para almacenar la información del usuario de manera segura.

## Características

- Registro de usuarios con correo electrónico y contraseña.
- Inicio de sesión para usuarios registrados.
- Autenticación segura mediante Firebase Authentication.
- Almacenamiento de datos del usuario en Firebase Realtime Database.
- Animaciones atractivas con la librería Lottie.

## Requisitos del Sistema

Asegúrate de tener los siguientes requisitos antes de comenzar:

- Android Studio instalado.
- Conexión a internet para la autenticación y almacenamiento en Firebase.

## Configuración

1. Clona este repositorio: `git clone git@github.com:Alfredogc21/Educasen_Java.git`
2. Abre el proyecto en Android Studio.
3. Configura tu proyecto en la Consola de Firebase y obtén el archivo de configuración `google-services.json`. Colócalo en la carpeta `app` del proyecto.
4. Habilita la autenticación por correo electrónico y configura la base de datos en la Consola de Firebase.
5. Añade la librería Lottie a tu proyecto. Puedes descargar las animaciones en formato JSON desde [LottieFiles](https://lottiefiles.com/) e integrarlas en tu aplicación.

## Uso

1. Ejecuta la aplicación en un emulador o dispositivo Android.
2. Regístrate con una dirección de correo electrónico y una contraseña.
3. Inicia sesión con las credenciales registradas.
4. Disfruta de las animaciones atractivas proporcionadas por la librería Lottie.

## Dependencias

La aplicación utiliza las siguientes dependencias principales:

- `com.google.firebase:firebase-auth`: Para la autenticación de usuarios.
- `com.google.firebase:firebase-database`: Para interactuar con la base de datos Firebase Realtime Database.

Educasen fue desarrollada por [Alfredo Gomez Culma](https://www.linkedin.com/in/alfredogc21).

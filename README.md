# Proyecto: Notificaciones en Android

## Qué se ha hecho
En esta práctica se han desarrollado varios ejercicios independientes relacionados con el uso de **notificaciones en Android**, dentro de una misma aplicación.  
Cada pantalla corresponde a un ejercicio distinto, con un botón **“Siguiente”** para pasar al siguiente ejercicio.

### Ejercicio 1 — Toast personalizado
- Se creó una pantalla con un campo de texto (`EditText`) y un botón (`Button`).
- Al pulsar el botón, se muestra un **Toast** con el texto introducido.
- Si el campo está vacío, el mensaje mostrado es: `"Escribe un texto"`.
- Después de mostrar el Toast, el campo se limpia automáticamente.
- Se ha **personalizado el diseño del Toast**, modificando su color, tamaño del texto y posición en pantalla.

### Ejercicio 2 — Snackbar
- Se añadió una segunda pantalla donde se muestra un **Snackbar** al pulsar un botón.
- Incluye una acción adicional (“Deshacer”) y muestra un mensaje temporal en la parte inferior.

### Ejercicio 3 — Notificación del sistema
- En esta pantalla se genera una **notificación del sistema** mediante `NotificationCompat`.
- La notificación muestra un icono, título, texto y abre una actividad al pulsarla.
- Se ha configurado un **canal de notificaciones** para Android 8.0 (Oreo) o superior.

### Navegación
- Cada ejercicio tiene un botón **“Siguiente”** que permite avanzar al siguiente.
- En la última pantalla se incluye un botón para volver al inicio.

---

## Problemas encontrados
1. El **Toast no aparecía** correctamente al inicio debido a que se intentaba acceder al `context` incorrecto.
2. Al cambiar de pantalla con los botones “Siguiente”, en algunos casos la app **se cerraba** por no declarar las actividades en el `AndroidManifest.xml`.
3. La notificación no se mostraba en versiones recientes de Android porque **no se había creado el canal de notificación**.
4. El diseño del Toast aparecía **demasiado arriba** o fuera de la posición deseada.

---

## Cómo se han resuelto
1. Se corrigió el contexto usando `this` o `applicationContext` correctamente en cada `Toast.makeText(...)`.
2. Se añadieron todas las actividades nuevas en el archivo `AndroidManifest.xml` con sus `intent-filters`.
3. Se implementó un canal de notificaciones con `NotificationChannel` y se registró en el `NotificationManager` para las versiones >= Android 8.0.
4. Se ajustó la posición del Toast mediante:
   ```kotlin
   toast.setGravity(Gravity.CENTER, 0, 0)

## Cómo se han resuelto
-Evidencias notificaciones.mp4

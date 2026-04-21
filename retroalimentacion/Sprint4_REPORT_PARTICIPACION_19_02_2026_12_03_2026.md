# Informe de Participación en el Repositorio
## Periodo: 19/02/2026 - 12/03/2026

---

## 📊 Resumen Estadísticas Generales

| Métrica | Valor |
|---------|-------|
| **Total de usuarios activos** | 3 (`IvanAriass`, `michel`, `kalashnibox`) |
| **Periodo analizado** | 19/02/2026 - 12/03/2026 |
| **Días con actividad** | 10 días principales |
| **Total de commits** | 17 |
| **Archivos modificados únicos** | 328 |

---

## 📝 Registro de Actividad Detallado

| Nombre | Fecha | Archivos modificados (Resumen) | Resumen de lo que ha realizado |
| :--- | :--- | :--- | :--- |
| **IvanAriass** | 12/03/2026 | `EcoQuestAPI/*`, `frontend-wpf/...`, `.gitignore` | Integración final de varias líneas de trabajo: fusiona la API REST de EcoQuest con cambios de pantallas/componentes WPF y deja conectada parte de la funcionalidad de tienda. |
| **IvanAriass** | 12/03/2026 | `EcoQuestAPI/pom.xml`, `EcoQuestAPI/src/main/java/com/proyecto/spring/{controladores,dto,modelos,repository,servicios}/*`, `EcoQuestAPI/src/main/resources/*`, `EcoQuestAPI/src/test/*` | Construye la base completa de la nueva API REST en Spring Boot, definiendo modelos, endpoints, DTOs, capa de servicios, repositorios, seguridad y configuración. |
| **michel** | 12/03/2026 | `frontend-android/PrototipadoComunidades/proyectobase2425/app/src/main/java/.../ui/features/*`, `ui/navigation/*`, `models/*`, `AndroidManifest.xml`, `build.gradle.kts` | Reorganiza y amplía el prototipo Android de comunidades, incorporando navegación, nuevas pantallas de inicio, perfil, ajustes y comunidades. |
| **michel** | 09/03/2026 | `frontend-android/PrototipadoComunidades/proyectobase2425/app/src/main/java/.../models/*`, `ui/features/*`, `ui/navigation/*`, varios archivos `.vs` de WPF | Actualiza el prototipado Android con nuevas pantallas, diálogos, estados y viewmodels; además arrastra archivos de entorno de Visual Studio del proyecto WPF. |
| **IvanAriass** | 08/03/2026 | `frontend-wpf/.../Services/NavegacionService.cs`, `ViewModels/AccesoriosUserControlVM.cs`, `Views/MainWindow.xaml`, `Views/UserControl/*` | Cierra la maquetación principal de la tienda WPF, amplía la navegación entre vistas y añade pantallas para listado y eliminación de accesorios. |
| **IvanAriass** | 06/03/2026 | `frontend-wpf/.../Services/NavegacionService.cs`, `ViewModels/MainWindowVM.cs`, `Views/UserControl/AccesoriosUserControl.xaml`, `Views/UserControl/Tienda/ListadoAccesoriosUserControl.*` | Refactoriza la navegación de la tienda en WPF y separa el listado de accesorios en un user control específico con su lógica asociada. |
| **IvanAriass** | 05/03/2026 | `frontend-wpf/.../bin/Debug/*`, `frontend-wpf/.../obj/*` | Resuelve un merge eliminando artefactos compilados y temporales de WPF que estaban versionados. |
| **IvanAriass** | 05/03/2026 | `.gitignore` | Refuerza las reglas de ignorado del repositorio para evitar que vuelvan a entrar archivos de salida, caché y configuración local. |
| **IvanAriass** | 05/03/2026 | `frontend-wpf/.../.vs/*` | Elimina archivos internos de Visual Studio del proyecto WPF para reducir conflictos de trabajo compartido. |
| **IvanAriass** | 05/03/2026 | `frontend-wpf/.../.vs/*` | Segunda limpieza de la carpeta `.vs`, consolidando la eliminación de ficheros de entorno local que seguían presentes. |
| **IvanAriass** | 04/03/2026 | `frontend-wpf/.../PrototipadoEscritorio.csproj`, `Services/NavegacionService.cs`, `Styles/EstilosGeneral.xaml`, `ViewModels/*`, `Views/UserControl/*`, junto con `.vs`, `bin` y `obj` | Avanza de forma amplia en la navegación lateral y en la gestión WPF de tienda, comunidades, eventos y usuarios, incorporando vistas de revisión, eliminación y bloqueo. |
| **kalashnibox** | 03/03/2026 | `ApiRest/demo/*`, `frontend-wpf/.../.vs/*`, `bin/*`, `obj/*` | Levanta casi por completo la primera API REST del proyecto en `ApiRest/demo`, incluyendo documentación de uso, entidades JPA, repositorios y endpoints CRUD. |
| **IvanAriass** | 26/02/2026 | `frontend-wpf/.../Styles/EstilosGeneral.xaml`, `Views/AccesoriosUserControl.xaml`, `Views/ComunidadesUserControl.xaml`, más `.vs`, `bin` y `obj` | Realiza una primera iteración de maquetación de la sección de accesorios en WPF y ajusta estilos base del prototipo de escritorio. |
| **michel** | 23/02/2026 | `frontend-android/PrototipadoComunidades/proyectobase2425/*` | Sube la base completa del prototipo Android de comunidades, con estructura de proyecto, recursos, navegación y primeras pantallas funcionales. |
| **michel** | 23/02/2026 | `docs/Diarios/GarciaMichel.md` | Actualiza su diario individual para documentar trabajo y avances del prototipado Android. |
| **IvanAriass** | 20/02/2026 | `docs/Diarios/Diario-Ivan.txt`, `frontend-wpf/.../App.xaml`, `MainWindow.xaml`, `Services/NavegacionService.cs`, `ViewModels/*`, `Views/*`, más `.vs`, `bin` y `obj` | Merge de la rama de Iván que integra la base de navegación del proyecto WPF, la estructura inicial de vistas y viewmodels, y parte de los artefactos generados en compilación. |
| **IvanAriass** | 20/02/2026 | `docs/Diarios/Diario-Ivan.txt`, `frontend-wpf/.../App.xaml`, `MainWindow.xaml`, `Services/NavegacionService.cs`, `Styles/EstilosGeneral.xaml`, `ViewModels/*`, `Views/*`, más `.vs`, `bin` y `obj` | Crea la estructura inicial de navegación y compilación del prototipo WPF, dejando preparada la ventana principal, servicios de cambio de vista y primeras pantallas. |

---

## 👥 Análisis de Contribuciones Individualizado

| Usuario | Commits | Días activos | Contribución principal | Seguimiento (Diario) | Discrepancias | Valoración global |
| :--- | :---: | :---: | :--- | :--- | :--- | :---: |
| **Iván Arias** | 12 (70,59%) | 7/10 | Desarrollo principal en `frontend-wpf` y arranque e integración de `EcoQuestAPI`; concentra la navegación de escritorio, la tienda y la nueva API Spring. | **Parcialmente alineado**. Su diario sí refleja trabajo previo en WPF, pero el registro visible no cubre con detalle todo el tramo 19/02-12/03 ni el salto a la API REST. | **Media**. Hay bastante más actividad en git que en el diario consultado para este periodo. | 🟢 |
| **Michel García** | 4 (23,53%) | 3/10 | Construcción del prototipo Android de comunidades, incluyendo pantallas, navegación, estado UI y recursos visuales. | **Parcialmente al día**. Su diario incluye al menos una entrada en febrero relacionada con Android, pero no documenta con el mismo nivel los commits más fuertes de marzo. | **Media**. La actividad en git supera lo reflejado en el diario durante marzo. | 🟢 |
| **Abdel** (kalashnibox) | 1 (5,88%) | 1/10 | Implementación casi completa de la API REST en `ApiRest/demo`, con documentación técnica y estructura backend Spring/JPA. | **Incompleto**. No se ha identificado en la revisión un diario actualizado que acompañe esta contribución puntual de backend en el rango analizado. | **Alta**. Commit de impacto alto sin trazabilidad documental equivalente en el periodo. | 🟡 |
| **Saúl Valcárcel** | 0 (0%) | 0/10 | Sin actividad registrada en git durante el periodo analizado. | **Desactualizado para este tramo**. Su diario revisado llega hasta enero de 2026 y no contiene entradas entre el 19/02/2026 y el 12/03/2026. | **Baja**. No hay commits que contrastar, pero tampoco evidencia documental de trabajo en el periodo. | ⚪ |

---

## 📈 Resumen Ejecutivo

### 1. Tendencias y Patrones
**Periodo de aceleración técnica y consolidación de módulos**
La actividad se concentra especialmente entre el 03/03 y el 12/03, con dos líneas de trabajo claras: por un lado, el desarrollo de la interfaz de escritorio en WPF y, por otro, la construcción de backends REST y del prototipo Android de comunidades. El repositorio muestra una fase de integración más que de prototipado inicial.

### 2. Distribución del Trabajo
*   **Iván** lidera claramente el periodo, tanto por volumen de commits como por continuidad, cubriendo la mayor parte del trabajo en WPF y la nueva `EcoQuestAPI`.
*   **Michel** concentra su aportación en Android, con menos frecuencia pero con commits grandes y funcionalmente relevantes.
*   **Abdel** realiza una aportación puntual de bastante tamaño en `ApiRest/demo`, sin continuidad posterior visible en git en este rango.
*   **Saúl** no registra commits en el periodo analizado, por lo que queda fuera de la actividad técnica medida en git.

### 3. Calidad del Trabajo
*   **Aspectos positivos:** Hay avances funcionales reales en tres frentes importantes del proyecto: escritorio WPF, backend REST y Android. El equipo no solo maqueta, sino que integra navegación, estructura técnica y servicios.
*   **Aspectos a vigilar:** En varios commits se siguen incluyendo archivos de entorno (`.vs`) y de compilación (`bin`, `obj`), lo que ensucia el historial y dificulta valorar con precisión el trabajo efectivo sobre código fuente.

### 4. Áreas de Mejora
1.   **Higiene del repositorio:** Es prioritario evitar que vuelvan a entrar `.vs`, `bin` y `obj`, porque inflan artificialmente los commits y generan ruido en merges.
2.   **Trazabilidad individual:** Los diarios deberían reflejar con más precisión el trabajo realizado en febrero y marzo, especialmente en el caso de Iván, Michel y Juan Luís.
3.   **Continuidad del equipo:** Conviene redistribuir mejor la carga para que la actividad no dependa tanto de uno o dos integrantes y para reincorporar a Saúl al flujo visible de trabajo.
4.   **Ritmo de commits:** Se recomienda realizar commits más pequeños y frecuentes para mejorar la trazabilidad y facilitar la revisión de cambios, en lugar de grandes merges que integran muchas modificaciones a la vez.
5. **Diario de Abdel:** Es importante que Abdel actualice su diario para reflejar su contribución en la API REST, ya que actualmente no hay evidencia documental de su trabajo en este periodo, lo que dificulta la evaluación de su participación.
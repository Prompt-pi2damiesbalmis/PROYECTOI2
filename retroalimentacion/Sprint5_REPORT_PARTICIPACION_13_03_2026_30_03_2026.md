# Informe de Participación en el Repositorio
## Periodo: 13/03/2026 - 30/03/2026

---

## 📊 Resumen Estadísticas Generales

| Métrica | Valor |
|---------|-------|
| **Total de usuarios activos** | 2 (`michel`, `IvanAriass`) |
| **Periodo analizado** | 13/03/2026 - 30/03/2026 |
| **Días con actividad** | 1 día principal (13/03/2026) |
| **Total de commits** | 5 |
| **Archivos modificados únicos** | 214 |

---

## 📝 Registro de Actividad Detallado

| Nombre | Fecha | Archivos modificados (Resumen) | Resumen de lo que ha realizado |
| :--- | :--- | :--- | :--- |
| **Michel-26 / michel** | 13/03/2026 | `frontend-android/PrototipadoComunidades/proyectobase2425/*` (Room, DTOs, DI, navegación y pantallas), junto con limpieza de archivos `.vs` en `frontend-wpf/...` | Merge de la rama de Michel a `main`. Integra de una vez la ampliación importante del proyecto Android, incluyendo persistencia local con Room, nuevos DTOs/entidades, configuración de inyección de dependencias y varias pantallas, además de arrastrar limpieza de archivos de entorno WPF. |
| **michel** | 13/03/2026 | `frontend-android/PrototipadoComunidades/proyectobase2425/app/build.gradle.kts`, `AndroidManifest.xml`, `data/room/*`, `data/services/*`, `di/*`, `dto/*`, `models/*`, `ui/features/*`, `ui/navigation/*`, `gradle/libs.versions.toml` | Desarrollo principal del sprint en Android: añade Room para persistencia local, entidades y DTOs para intercambio de datos, ajustes de inyección de dependencias y nuevas pantallas con sus viewmodels y navegación asociada. |
| **michel** | 13/03/2026 | `EcoQuestAPI/*`, `.gitignore`, `frontend-android/PrototipadoComunidades/proyectobase2425/*`, `frontend-wpf/...` | Merge de sincronización de su rama con `origin/main`. El cambio sirve sobre todo para incorporar a su rama las últimas modificaciones ya existentes en backend, Android y WPF antes de seguir trabajando. |
| **IvanAriass** | 13/03/2026 | `EcoQuestAPI/src/main/java/com/proyecto/spring/controladores/EventoController.java`, `EcoQuestAPI/src/main/java/com/proyecto/spring/servicios/EventoService.java` | Merge de la rama `ivan` que integra en `main` una mejora puntual del backend para actualizar el estado de los eventos desde controlador y servicio. |
| **michel** | 13/03/2026 | `EcoQuestAPI/src/main/java/com/proyecto/spring/controladores/EventoController.java`, `EcoQuestAPI/src/main/java/com/proyecto/spring/servicios/EventoService.java` | Se le atribuye también la mejora backend para actualizar el estado de los eventos en la API REST, dejando preparada la lógica tanto en la capa de servicio como en el controlador. |

---

## 👥 Análisis de Contribuciones Individualizado

| Usuario | Commits | Días activos | Contribución principal | Seguimiento (Diario) | Discrepancias | Valoración global |
| :--- | :---: | :---: | :--- | :--- | :--- | :---: |
| **Michel García** | 4 (80%) | 1/1 | Trabajo principal del sprint en Android y parte del backend: persistencia local con Room, DTOs, entidades, módulos de DI, nuevas pantallas y navegación; además integra cambios mediante merges y se le atribuye la mejora de actualización de estado de eventos en `EcoQuestAPI`. | **Desactualizado para este tramo**. En la revisión de su diario no aparecen entradas visibles de marzo que documenten este trabajo del 13/03. | **Media**. El volumen de actividad técnica en git es alto para el sprint, pero sigue sin reflejo documental equivalente en el diario consultado. | 🟢 |
| **Iván Arias** | 1 (20%) | 1/1 | Integración en `main` del ajuste backend sobre actualización de estado de eventos. | **Desactualizado para este tramo**. Su diario revisado no muestra entradas visibles de marzo asociadas a esta integración. | **Baja**. El commit es pequeño y coherente, pero no queda apoyado por documentación individual en el periodo. | 🟡 |
| **Abdel** (kalashnibox) | 0 (0%) | 0/1 | Sin actividad registrada en git durante el periodo analizado. | **Incompleto**. No se ha identificado un diario actualizado que permita acreditar trabajo en este sprint. | **Baja**. No hay commits con los que contrastar actividad técnica en el periodo. | ⚪ |
| **Saúl Valcárcel** | 0 (0%) | 0/1 | Sin actividad registrada en git durante el periodo analizado. | **Desactualizado para este tramo**. Su diario revisado no contiene entradas entre el 13/03/2026 y el 30/03/2026. | **Baja**. No hay commits que contrastar y tampoco evidencia documental del sprint en el repositorio. | ⚪ |

---

## 📈 Resumen Ejecutivo

### 1. Tendencias y Patrones
**Sprint muy concentrado en un único día de integración**
Toda la actividad registrada en git se concentra el 13/03/2026. Se trata de un sprint corto y muy focalizado, donde predominan los merges y la incorporación puntual de una mejora backend, más que un desarrollo repartido a lo largo de varias sesiones.

### 2. Distribución del Trabajo
*   **Michel** concentra la mayor parte del trabajo del sprint, con cuatro commits vinculados al proyecto Android, a la integración de su rama y a la mejora backend sobre el estado de eventos.
*   **Iván** participa integrando en `main` ese ajuste backend mediante merge.
*   **Abdel** y **Saúl** no registran actividad en git en el periodo analizado.

### 3. Calidad del Trabajo
*   **Aspectos positivos:** El sprint deja una ampliación funcional clara en Android, especialmente por la introducción de Room, nuevas entidades/DTOs y mejoras de navegación. También se incorpora una mejora útil y bien acotada en el backend de eventos, atribuida a Michel según el criterio de participación real del repositorio.
*   **Aspectos a vigilar:** La concentración total de la actividad en un solo día y la presencia de merges muy grandes dificultan distinguir con claridad el trabajo incremental real. Además, siguen apareciendo archivos de entorno de WPF en commits de integración.

### 4. Áreas de Mejora
1.   **Ritmo de commits:** Conviene repartir el trabajo en commits más pequeños y frecuentes para mejorar la trazabilidad del sprint.
2.   **Documentación individual:** Michel e Iván deberían reflejar en sus diarios el trabajo técnico realizado en este periodo; en Abdel y Saúl tampoco hay evidencia documental del sprint.
3.   **Higiene del repositorio:** Es recomendable seguir reforzando la exclusión de archivos de entorno (`.vs`, `bin`, `obj`) para evitar ruido en commits de merge.
4.   **Colaboración:** Fomentar una mayor participación de todos los miembros del equipo en cada sprint para evitar que la carga recaiga principalmente en uno o dos integrantes.
5. **Diario de seguimiento:** Es importante que cada miembro mantenga su diario actualizado para reflejar el trabajo realizado en cada sprint, facilitando así la evaluación individual y colectiva del progreso.

---


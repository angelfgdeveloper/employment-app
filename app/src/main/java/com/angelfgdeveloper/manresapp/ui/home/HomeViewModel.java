package com.angelfgdeveloper.manresapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.angelfgdeveloper.manresapp.data.models.Work;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<List<Work>> mWork;

    public HomeViewModel() {
        mWork = new MutableLiveData<>();
        mWork.setValue(workList());
    }

    private List<Work> workList() {
        List<Work> work = new ArrayList<>();
        work.add(new Work(
                1,
                "Apple",
                "Desarrollador web", "Hoy", "Desarrollador web full stack",
                "Requisitos para el puesto\n" +
                        "\n" +
                        "Ing. en Sistemas Computacionales\n" +
                        "Maquetación HTML 5, CSS 3\n" +
                        "Manejo de control de versiones GIT\n" +
                        "Lenguajes de programación: Java, Bootstrap, C++, C#, Python (básico), JavaScript, PHP, HTML y MySQL.\n" +
                        "Programar front-end y back-end\n" +
                        "\n" +
                        "Principales responsabilidades del puesto\n" +
                        "\n" +
                        "Crear landing pages y páginas interactivas.\n" +
                        "Optimizar el sitio web y las landing pages existentes.\n" +
                        "Crear estructura y código, buscando siempre la mejora continua, para la generación de Leads\n" +
                        "Dar soluciones a las necesidades de otras áreas para la optimización de los sitios web.\n" +
                        "Integración de herramientas externas, de acuerdo a las necesidades del sitio web.\n" +
                        "\n" +
                        "Prestaciones y beneficios adicionales\n" +
                        "\n" +
                        "Salario a definir según competencia\n" +
                        "Prestaciones de ley\n" +
                        "Incrementos salariales conforme a las certificaciones obtenidas\n" +
                        "Trabaja de Lunes a Viernes",
                "Durango, Dgo.", "Tecnología", "Mensuales", 12000));
        work.add(new Work(
                2,
                "Go Travel",
                "Desarrollador web", "Hoy", "Programador Web con experiencia en hubspot",
                "EXPERIENCIA LABORAL / HABILIDADES ESPECIALES\n" +
                        "\n" +
                        "Experiencia demostrada como desarrollador de software, ingeniero de softwareo en un puesto similar.\n" +
                        "\n" +
                        "Estar familiarizado y certificado con Hubspot.\n" +
                        "\n" +
                        "Experiencia en diseño y desarrollo de software en un entorno orientado a pruebas\n" +
                        "\n" +
                        "Experiencia con bases de datos y sistemas de mapeo\n" +
                        "\n" +
                        "Excelentes dotes de comunicación\n" +
                        "\n" +
                        "Ingenio y capacidad para solucionar problemas\n" +
                        "\n" +
                        "Atención al detalle\n" +
                        "\n" +
                        "Grado en ciencias informáticas, ingeniería o en un campo relacionado\n" +
                        "\n" +
                        " ACTIVIDADES\n" +
                        "\n" +
                        "Producir un código limpio y eficiente basado en las especificaciones\n" +
                        "\n" +
                        "Verificar y desplegar programas y sistemas\n" +
                        "\n" +
                        "Solucionar problemas, depurar y actualizar el software existente\n" +
                        "\n" +
                        "Recopilar y evaluar los comentarios de los usuarios\n" +
                        "\n" +
                        "Recomendar y realizar mejoras\n" +
                        "\n" +
                        "Crear documentación técnica para referencia e informes\n" +
                        "\n" +
                        "COMPETENCIAS\n" +
                        "\n" +
                        "Orientado/a a los detalles\n" +
                        "\n" +
                        "Resolución de problemas\n" +
                        "\n" +
                        "Automotivación\n" +
                        "\n" +
                        "Habilidades de comunicación\n" +
                        "\n" +
                        "Paciencia\n" +
                        "\n" +
                        "Creatividad\n" +
                        "\n",
                "Solidaridad, Q. Roo, Playa del Carmen", "Tecnología", "Mensuales", 10000));
        work.add(new Work(
                3,
                "Empresa confidencial",
                "Lic. Administración, Psicología (pasante o titulado)",
                "Hoy",
                "Auxiliar de Reclutamiento y Vinculación Universitaria",
                "Analista de Reclutamiento y Vinculación universitaria\n" +
                        "\n" +
                        "Escolaridad: Lic. Administración, Psicología (pasante o titulado)\n" +
                        "Experiencia: 1 año de experiencia en el área de reclutamiento, realizando publicación de vacantes en fuentes de reclutamiento, vinculación con universidades, actividades de posicionamiento en universidades, asistencia ferias de empleo presencial y/o virtual, filtros telefónicos, entrevista, métricas, entre otros.\n" +
                        "Inglés: Intermedio alto - Avanzado (conversacional).\n" +
                        "Deseable conocimiento en perfiles de las áreas económico - administrativo e IT (no operativos).\n" +
                        "\n" +
                        "Habilidades:\n" +
                        "\n" +
                        "Comunicación\n" +
                        "Proactividad\n" +
                        "Sentido de urgencia\n" +
                        "Atención a detalle\n" +
                        "\n" +
                        "Ofrecemos:\n" +
                        "\n" +
                        "Sueldo + PSL\n" +
                        "\n" +
                        "Desarrollo profesional\n" +
                        "\n" +
                        "Integrarse a una empresa con presencia global.\n" +
                        "\n" +
                        "Si cumples con los requisitos aplica a nuestra vacante para conocer más sobre tu perfil (asegúrate de que tu CV y expectativas salariales estén actualizadas).",
                "Guadalajara, Jal.",
                "Administración",
                "Mensuales",
                11500
        ));
        work.add(new Work(
                4,
                "Adecco",
                "Ciencia de Datos",
                "Ayer",
                "Becario Data Science",
                "Importante empresa de Investigación de mercados, Solicita:\n" +
                        "\n" +
                        "BECARIO - DATA SCIENCE\n" +
                        "\n" +
                        "Requisitos:\n" +
                        "\n" +
                        "Estudiantes de últimos semestres de Licenciatura: Actuaria, Estadística, Matemáticas o a Fin\n" +
                        "\n" +
                        "Software: Excel, Programación en Python y/o R.\n" +
                        "\n" +
                        "Ingles: Intermedio Avanzado\n" +
                        "\n" +
                        "Experiencia escolar en:\n" +
                        "\n" +
                        "Análisis de información.\n" +
                        "\n" +
                        "Manejo de Bases de Datos.\n" +
                        "\n" +
                        "Programación en Pyhton y/o R (Indispensable).\n" +
                        "\n" +
                        "Presentaciones a clientes internos.\n" +
                        "\n" +
                        "Forecast.\n" +
                        "\n" +
                        "Automatización de actividades.\n" +
                        "\n" +
                        "Data Visualization.\n" +
                        "\n" +
                        "Ofrecemos:\n" +
                        "\n" +
                        "$5,150.00 brutos al mes\n" +
                        "\n" +
                        "Prestaciones Superiores de Ley\n" +
                        "\n" +
                        "-Vales de despensa\n" +
                        "\n" +
                        "-Fondo de ahorro\n" +
                        "\n" +
                        "-Seguro de Gastos Médicos Mayores\n" +
                        "\n" +
                        "Horario de medio tiempo",
                "Miguel Hidalgo, CDMX",
                "Ciencia de Datos",
                "Mensuales",
                5150
        ));
        work.add(new Work(
                5,
                "Empresa confidencial",
                "Ejecutivo telefonico",
                "Ayer",
                "EJECUTIVO TELEFONICO CON EXPERIENCIA",
                "SOPORTE TECNICO!\n" +
                        "\n" +
                        "Objetivo de la vacante: Brindar SOPORTE vía telefónica y vía chat a clientes que adquirieron algún producto de tecnología de una importante empresa!\n" +
                        "\n" +
                        "Ubicación para laborar: Edificio One Park Marina Nacional (como a 3 cuadras del metro Tacuba) en la delegación Miguel Hidalgo-Trabajo presencial\n" +
                        "\n" +
                        "Requisitos solicitados:\n" +
                        "\n" +
                        "• Mínimo 6 meses de experiencia Reciente y continua en Soporte técnico Call Center o ATC Call Center únicamente Comprobable (cartas laborales expedidas por la empresa donde se laboró)\n" +
                        "\n" +
                        "• edad mínima de 20 años ya cumplidos\n" +
                        "\n" +
                        "• preparatoria concluida con certificado\n" +
                        "\n" +
                        "• no vivir a más de 1:00 hora de la zona a laborar\n" +
                        "\n" +
                        "• LA DISPONIBILIDAD ES IMPORTANTE AUN ASIGNANDOSE HORARIO\n" +
                        "\n" +
                        "• DOCUMENTACIÓN EN REGLA\n" +
                        "\n" +
                        "SIN FALTANTES incluyendo el Certificado de la Prepa\n" +
                        "\n" +
                        "• No haber estado en la empresa hace menos de 1 año\n" +
                        "\n" +
                        "• No haber dejado proceso inconcluso ( se lleva un registro para verificarlo )\n" +
                        "\n" +
                        "• No haber estado en la Campaña anteriormente\n" +
                        "\n" +
                        "• SER RESPONSABLE para el envío y / o entrega de documentación TAL CUAL SE PIDE\n" +
                        "\n" +
                        "• No tener alguna actividad próxima que interfiera con la Capacitación ya que una vez seleccionado (a) si faltamos en automático quedamos fuera.\n" +
                        "\n" +
                        "HERRAMIENTAS:\n" +
                        "\n" +
                        "Contar con computadora o lap top la cual debe incluir cámara o bien tener cámara externa (NO CELULAR)\n" +
                        "\n" +
                        "Internet con una velocidad en descargas de 10 MB\n" +
                        "\n" +
                        "Memoria disponible de 4 GB para descargar aplicaciones como ZOOM Y TEAMS\n" +
                        "\n" +
                        "HABILIDADES\n" +
                        "\n" +
                        "QUE LE GUSTE LEER Y COMPRENDER\n" +
                        "\n" +
                        "Reiteró: FLEXIBILIDAD DE HORARIO AUN CUANDO SE ASIGNA\n" +
                        "\n" +
                        "NO TENER ACTIVIDADES QUE INTERFIERAN CON EL EMPLEO\n" +
                        "\n" +
                        "OFRECEMOS:\n" +
                        "\n" +
                        "CAPACITACIÒN PAGADA\n" +
                        "IMSS\n" +
                        "FONACOT\n" +
                        "INFONAVIT\n" +
                        "VACACIONES\n" +
                        "AGUINALDO\n" +
                        "PRIMA VACACIONAL\n" +
                        "CRECIMIENTO LABORAL\n",
                "Miguel Hidalgo, CDMX",
                "Soporte Tecnico",
                "Mensuales",
                8000
        ));
        work.add(new Work(
                6,
                "Arsum Marketing Empresarial SA de CV",
                "Ejecutivo de ventas",
                "La semana pasada",
                "Ejecutivo de ventas",
                "Beneficios\n" +
                        "\n" +
                        "Excelente esquema de comisiones\n" +
                        "Prestaciones de ley (IMSS, vacaciones, aguinaldo)\n" +
                        "Seguro de vida\n" +
                        "Descripción\n" +
                        "\n" +
                        "¡POR EXPANSION! Estamos contratando Asesores telefónicos de ventas !!\n" +
                        "\n" +
                        "Ofrecemos:\n" +
                        "\n" +
                        "-Sueldo base mensual $6800\n" +
                        "\n" +
                        "-Bonos por puntualidad y asistencia $915\n" +
                        "\n" +
                        "-Prestaciones de ley\n" +
                        "\n" +
                        "-Seguro de gastos médicos\n" +
                        "\n" +
                        "-Comisiones no topadas desde la primera venta en dólares\n" +
                        "\n" +
                        "-Oportunidad de crecimiento\n" +
                        "\n" +
                        "REQUISITOS:\n" +
                        "\n" +
                        "-Contar con Identificación (INE, Licencia, Credencial de la escuela)\n" +
                        "\n" +
                        "-Bachillerato trunco\n" +
                        "\n" +
                        "-Experiencia en Call Center (puesto similar)\n" +
                        "\n" +
                        "-Disponibilidad de lunes a sábado\n" +
                        "\n" +
                        "-Facilidad de palabra\n" +
                        "\n" +
                        "Zona a laborar:\n" +
                        "\n" +
                        "Colonia Álamos, Alcaldía Benito Juárez, CDMX\n" +
                        "\n" +
                        "A unas cuadras de Metro Xola, Metrobús Álamos\n" +
                        "\n" +
                        "Contacto:\n" +
                        "\n" +
                        "Lic. Saúl Mendoza o al teléfono: cincuenta y cinco veintiuno ochenta y uno cero cinco sesenta",
                "Ciudad de México",
                "Finanzas",
                "Mensuales",
                7700
        ));
//        work.add(new Work(
//                7,
//                "",
//                "",
//                "",
//                "",
//                "",
//                "",
//                "",
//                "",
//                0
//        ));

        return work;
    }

    public LiveData<List<Work>> getAllWorks() {
        return mWork;
    }
}
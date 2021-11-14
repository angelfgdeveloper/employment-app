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
                "Desarrollador web", "12/12/2022", "Desarrollador web full stack",
                "Requisitos para el puesto\n" +
                        "\n" +
                        "\n" +
                        "Ing. en Sistemas Computacionales\n" +
                        "Maquetación HTML 5, CSS 3\n" +
                        "Manejo de control de versiones GIT\n" +
                        "Lenguajes de programación: Java, Bootstrap, C++, C#, Python (básico), JavaScript, PHP, HTML y MySQL.\n" +
                        "Programar front-end y back-end\n" +
                        "\n" +
                        "\n" +
                        "Principales responsabilidades del puesto\n" +
                        "\n" +
                        "\n" +
                        "Crear landing pages y páginas interactivas.\n" +
                        "Optimizar el sitio web y las landing pages existentes.\n" +
                        "Crear estructura y código, buscando siempre la mejora continua, para la generación de Leads\n" +
                        "Dar soluciones a las necesidades de otras áreas para la optimización de los sitios web.\n" +
                        "Integración de herramientas externas, de acuerdo a las necesidades del sitio web.\n" +
                        "\n" +
                        "\n" +
                        "Prestaciones y beneficios adicionales\n" +
                        "\n" +
                        "\n" +
                        "Salario a definir según competencia\n" +
                        "Prestaciones de ley\n" +
                        "Incrementos salariales conforme a las certificaciones obtenidas\n" +
                        "Trabaja de Lunes a Viernes",
                "Durango, Dgo.", "Tecnología", "Mensuales", 12000));
        work.add(new Work(
                2,
                "Go Travel",
                "Desarrollador web", "09/02/2022", "Programador Web con experiencia en hubspot",
                "Descripción\n" +
                        "\n" +
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
        return work;
    }

    public LiveData<List<Work>> getAllWorks() {
        return mWork;
    }
}
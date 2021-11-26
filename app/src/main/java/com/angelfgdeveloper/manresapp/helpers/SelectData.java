package com.angelfgdeveloper.manresapp.helpers;

import java.util.ArrayList;
import java.util.List;

public class SelectData {

    public static List<String> nationalityList() {
        List<String> nationality = new ArrayList<>();
        nationality.add("Mexicano");
        nationality.add("Estadounidense");
        return nationality;
    }

    public static List<String> genderList() {
        List<String> gender = new ArrayList<>();
        gender.add("Masculino");
        gender.add("Femenino");
        gender.add("Otro");
        return gender;
    }

    public static List<String> degreesList() {
        List<String> degrees = new ArrayList<>();
        degrees.add("Primaria");
        degrees.add("Secundaria");
        degrees.add("Bachillerato / Preparatoria");
        degrees.add("Profesional (Ing./Lic./Etc.)");
        degrees.add("Posgrado");
        return degrees;
    }

    public static List<String> advanceStudiesList() {
        List<String> advanceStudies = new ArrayList<>();
        advanceStudies.add("En curso");
        advanceStudies.add("Concluido");
        advanceStudies.add("Trunca");
        return advanceStudies;
    }

    public static List<String> monthsList() {
        List<String> months = new ArrayList<>();
        months.add("Enero");
        months.add("Febrero");
        months.add("Marzo");
        months.add("Abril");
        months.add("Mayo");
        months.add("Junio");
        months.add("Julio");
        months.add("Agosto");
        months.add("Septiembre");
        months.add("Octubre");
        months.add("Noviembre");
        months.add("Diciembre");
        return months;
    }

    public static List<String> healthList() {
        List<String> health = new ArrayList<>();
        health.add("Buena");
        health.add("Regular");
        health.add("Mala");
        return health;
    }

    public static List<String> yesAndNotList() {
        List<String> yesAndNot = new ArrayList<>();
        yesAndNot.add("Si");
        yesAndNot.add("No");
        return yesAndNot;
    }

    public static List<String> bloodTypeList() {
        List<String> bloodType = new ArrayList<>();
        bloodType.add("O -");
        bloodType.add("O +");
        bloodType.add("A -");
        bloodType.add("A +");
        bloodType.add("B -");
        bloodType.add("B +");
        bloodType.add("AB -");
        bloodType.add("AB +");
        bloodType.add("No sé");
        return bloodType;
    }

    public static List<String> evidentialDocumentList() {
        List<String> evidentialDocument = new ArrayList<>();
        evidentialDocument.add("Titulo y cedula");
        evidentialDocument.add("Pasante");
        evidentialDocument.add("Certificado");
        return evidentialDocument;
    }
}

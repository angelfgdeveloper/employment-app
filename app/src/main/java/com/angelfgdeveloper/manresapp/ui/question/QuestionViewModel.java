package com.angelfgdeveloper.manresapp.ui.question;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.angelfgdeveloper.manresapp.helpers.SelectData;

import java.util.List;

public class QuestionViewModel extends ViewModel {
    private final MutableLiveData<List<String>> mGender, mNationality, mDegrees, mAdvanceStudies, mMonths, mHealth, mYesAndNot, mBloodType, mEvidentialDocument;

    public QuestionViewModel() {
        mGender = new MutableLiveData<>();
        mNationality = new MutableLiveData<>();
        mDegrees = new MutableLiveData<>();
        mAdvanceStudies = new MutableLiveData<>();
        mMonths = new MutableLiveData<>();
        mHealth = new MutableLiveData<>();
        mYesAndNot = new MutableLiveData<>();
        mBloodType = new MutableLiveData<>();
        mEvidentialDocument = new MutableLiveData<>();

        mGender.setValue(SelectData.genderList());
        mNationality.setValue(SelectData.nationalityList());
        mDegrees.setValue(SelectData.degreesList());
        mAdvanceStudies.setValue(SelectData.advanceStudiesList());
        mMonths.setValue(SelectData.monthsList());
        mHealth.setValue(SelectData.healthList());
        mYesAndNot.setValue(SelectData.yesAndNotList());
        mBloodType.setValue(SelectData.bloodTypeList());
        mEvidentialDocument.setValue(SelectData.evidentialDocumentList());
    }

    public LiveData<List<String>> getAllGender() {
        return mGender;
    }

    public LiveData<List<String>> getAllNationality() {
        return mNationality;
    }

    public LiveData<List<String>> getAllDegrees() {
        return mDegrees;
    }

    public LiveData<List<String>> getAllAdvanceStudies() {
        return mAdvanceStudies;
    }

    public LiveData<List<String>> getAllMonths() {
        return mMonths;
    }

    public LiveData<List<String>> getAllHealth() {
        return mHealth;
    }

    public LiveData<List<String>> getAllYesAndNot() {
        return mYesAndNot;
    }

    public LiveData<List<String>> getAllBloodType() {
        return mBloodType;
    }

    public LiveData<List<String>> getAllEvidentialDocument() {
        return mEvidentialDocument;
    }

}
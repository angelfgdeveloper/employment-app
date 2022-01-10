package com.angelfgdeveloper.manresapp.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import kotlinx.coroutines.flow.Flow;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> mAvatarUser;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mAvatarUser = new MutableLiveData<>();
        mText.setValue("This is profile fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> getAvatarUser() { return mAvatarUser; }

    public void setPhoto(String photoPath) {
        mAvatarUser.setValue(photoPath);
    }
}
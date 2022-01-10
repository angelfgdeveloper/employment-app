package com.angelfgdeveloper.manresapp.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.File;

public class LoadConvertPhotoFileTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView ivPhoto;

    public LoadConvertPhotoFileTask(ImageView ivPhoto) {
        this.ivPhoto = ivPhoto;
    }

    @Override
    protected void onPostExecute(Bitmap myBitmap) {
        super.onPostExecute(myBitmap);
        ivPhoto.setImageBitmap(myBitmap);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String photoPath = strings[0];
        if (!photoPath.isEmpty()) {
            File imgFile = new  File(photoPath);
            if(imgFile.exists()){
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                return myBitmap;
            }
        }
        return null;
    }
}

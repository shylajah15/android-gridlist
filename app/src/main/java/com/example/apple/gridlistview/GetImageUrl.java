package com.example.apple.gridlistview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GetImageUrl extends AsyncTask<String,Void,Bitmap> {

    ImageView imageView;

    public  GetImageUrl(ImageView imageView){
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... url){
        Log.i("ssaf","url"+url[0]);
        String urlOfImage = url[0];
        Bitmap cropImage = null;

        try {
            InputStream inputStream = new URL(urlOfImage).openStream();
            cropImage = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  cropImage;
    }

    protected void onPostExecute(Bitmap result){
        imageView.setImageBitmap(result);
    }
}

package com.example.hiago.exercicio5.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import  com.example.hiago.exercicio5.fw.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by hiago on 22/05/2015.
 */
public class DownloadImagemTask extends AsyncTask<String, Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... params) {

        String url = params[0];

        Bitmap b = obterImagem(url);

        if (b==null){
            try {
                InputStream in = new java.net.URL(url).openStream();
                b = BitmapFactory.decodeStream(in);

            }catch (Exception e){
                b = null;
            }
        }

        return b;
    }

    public void salvarBitmap(Bitmap b, String url)throws Exception{

        String id = Util.md5(url);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/images/";
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdir();
        }
        String fileName = path + id + ".png";

        Log.i("imagem", "Salvando imagem" + fileName);

        FileOutputStream out = new FileOutputStream(fileName);

        b.compress(Bitmap.CompressFormat.JPEG, 100, out);

        out.flush();

        out.close();
    }

    public Bitmap obterImagem(String url){
        String id = Util.md5(url);

        String pathImagem = Environment.getExternalStorageDirectory().getAbsolutePath()+ "/images/";

        File f = new File(pathImagem);

        if (f.exists()){
            Log.i("Imagem", "Obtendo imagem" + pathImagem);
            return BitmapFactory.decodeFile(pathImagem);
        }else {
            return null;
        }
    }

}

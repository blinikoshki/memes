package com.facebook.appevents.internal;

import android.os.AsyncTask;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

public class FileDownloadTask extends AsyncTask<String, Void, Boolean> {
    private File destFile;
    private Callback onSuccess;
    private String uriStr;

    public interface Callback {
        void onComplete(File file);
    }

    public FileDownloadTask(String str, File file, Callback callback) {
        this.uriStr = str;
        this.destFile = file;
        this.onSuccess = callback;
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground(String... strArr) {
        try {
            URL url = new URL(this.uriStr);
            int contentLength = url.openConnection().getContentLength();
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            byte[] bArr = new byte[contentLength];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.destFile));
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            dataOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            this.onSuccess.onComplete(this.destFile);
        }
    }
}

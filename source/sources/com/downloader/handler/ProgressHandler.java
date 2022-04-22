package com.downloader.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.downloader.OnProgressListener;
import com.downloader.Progress;

public class ProgressHandler extends Handler {
    private final OnProgressListener listener;

    public ProgressHandler(OnProgressListener onProgressListener) {
        super(Looper.getMainLooper());
        this.listener = onProgressListener;
    }

    public void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
        } else if (this.listener != null) {
            this.listener.onProgress((Progress) message.obj);
        }
    }
}

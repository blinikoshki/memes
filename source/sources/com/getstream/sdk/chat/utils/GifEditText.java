package com.getstream.sdk.chat.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;

public class GifEditText extends EditText {
    private InputConnectionCompat.OnCommitContentListener callback;

    public GifEditText(Context context) {
        super(context);
    }

    public GifEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GifEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        EditorInfoCompat.setContentMimeTypes(editorInfo, new String[]{"image/gif"});
        InputConnectionCompat.OnCommitContentListener onCommitContentListener = this.callback;
        if (onCommitContentListener != null) {
            return InputConnectionCompat.createWrapper(onCreateInputConnection, editorInfo, onCommitContentListener);
        }
        return null;
    }

    public void setCallback(InputConnectionCompat.OnCommitContentListener onCommitContentListener) {
        this.callback = onCommitContentListener;
    }
}

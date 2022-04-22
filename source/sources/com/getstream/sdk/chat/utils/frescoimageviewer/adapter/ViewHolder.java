package com.getstream.sdk.chat.utils.frescoimageviewer.adapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class ViewHolder {
    private static final String STATE = "ViewHolder";
    public final View itemView;
    boolean mIsAttached;
    int mPosition;

    public ViewHolder(View view) {
        if (view != null) {
            this.itemView = view;
            return;
        }
        throw new IllegalArgumentException("itemView should not be null");
    }

    /* access modifiers changed from: package-private */
    public void attach(ViewGroup viewGroup, int i) {
        this.mIsAttached = true;
        this.mPosition = i;
        viewGroup.addView(this.itemView);
    }

    /* access modifiers changed from: package-private */
    public void detach(ViewGroup viewGroup) {
        viewGroup.removeView(this.itemView);
        this.mIsAttached = false;
    }

    /* access modifiers changed from: package-private */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            String str = STATE;
            SparseArray sparseParcelableArray = bundle.containsKey(str) ? bundle.getSparseParcelableArray(str) : null;
            if (sparseParcelableArray != null) {
                this.itemView.restoreHierarchyState(sparseParcelableArray);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Parcelable onSaveInstanceState() {
        SparseArray sparseArray = new SparseArray();
        this.itemView.saveHierarchyState(sparseArray);
        Bundle bundle = new Bundle();
        bundle.putSparseParcelableArray(STATE, sparseArray);
        return bundle;
    }
}

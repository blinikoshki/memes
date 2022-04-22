package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.IFragmentWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public final class FragmentWrapper extends IFragmentWrapper.Stub {
    private Fragment zziq;

    public static FragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    private FragmentWrapper(Fragment fragment) {
        this.zziq = fragment;
    }

    public final IObjectWrapper zzad() {
        return ObjectWrapper.wrap(this.zziq.getActivity());
    }

    public final Bundle getArguments() {
        return this.zziq.getArguments();
    }

    public final int getId() {
        return this.zziq.getId();
    }

    public final IFragmentWrapper zzae() {
        return wrap(this.zziq.getParentFragment());
    }

    public final IObjectWrapper zzaf() {
        return ObjectWrapper.wrap(this.zziq.getResources());
    }

    public final boolean getRetainInstance() {
        return this.zziq.getRetainInstance();
    }

    public final String getTag() {
        return this.zziq.getTag();
    }

    public final IFragmentWrapper zzag() {
        return wrap(this.zziq.getTargetFragment());
    }

    public final int getTargetRequestCode() {
        return this.zziq.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint() {
        return this.zziq.getUserVisibleHint();
    }

    public final IObjectWrapper zzah() {
        return ObjectWrapper.wrap(this.zziq.getView());
    }

    public final boolean isAdded() {
        return this.zziq.isAdded();
    }

    public final boolean isDetached() {
        return this.zziq.isDetached();
    }

    public final boolean isHidden() {
        return this.zziq.isHidden();
    }

    public final boolean isInLayout() {
        return this.zziq.isInLayout();
    }

    public final boolean isRemoving() {
        return this.zziq.isRemoving();
    }

    public final boolean isResumed() {
        return this.zziq.isResumed();
    }

    public final boolean isVisible() {
        return this.zziq.isVisible();
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        this.zziq.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void setHasOptionsMenu(boolean z) {
        this.zziq.setHasOptionsMenu(z);
    }

    public final void setMenuVisibility(boolean z) {
        this.zziq.setMenuVisibility(z);
    }

    public final void setRetainInstance(boolean z) {
        this.zziq.setRetainInstance(z);
    }

    public final void setUserVisibleHint(boolean z) {
        this.zziq.setUserVisibleHint(z);
    }

    public final void startActivity(Intent intent) {
        this.zziq.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i) {
        this.zziq.startActivityForResult(intent, i);
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.zziq.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}

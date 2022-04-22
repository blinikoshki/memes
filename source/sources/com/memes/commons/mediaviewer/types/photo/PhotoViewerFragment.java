package com.memes.commons.mediaviewer.types.photo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.commons.databinding.MediaViewerPhotoFragmentBinding;
import com.memes.commons.fragment.BaseFragment;
import com.memes.commons.mediaviewer.types.MediaViewerItemTypesAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/commons/mediaviewer/types/photo/PhotoViewerFragment;", "Lcom/memes/commons/fragment/BaseFragment;", "()V", "_binding", "Lcom/memes/commons/databinding/MediaViewerPhotoFragmentBinding;", "assignedFragmentTag", "", "getAssignedFragmentTag", "()Ljava/lang/String;", "binding", "getBinding", "()Lcom/memes/commons/databinding/MediaViewerPhotoFragmentBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PhotoViewerFragment.kt */
public final class PhotoViewerFragment extends BaseFragment {
    private MediaViewerPhotoFragmentBinding _binding;

    public String getAssignedFragmentTag() {
        return "photo-viewer-fragment";
    }

    private final MediaViewerPhotoFragmentBinding getBinding() {
        MediaViewerPhotoFragmentBinding mediaViewerPhotoFragmentBinding = this._binding;
        if (mediaViewerPhotoFragmentBinding != null) {
            return mediaViewerPhotoFragmentBinding;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = MediaViewerPhotoFragmentBinding.inflate(layoutInflater, viewGroup, false);
        ImageView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Bundle arguments = getArguments();
        Object obj = arguments != null ? arguments.get(MediaViewerItemTypesAdapter.ARG_MEDIA_PATH) : null;
        if (obj != null) {
            Glide.with((Fragment) this).load(obj).into(getBinding().photoView);
        }
    }
}

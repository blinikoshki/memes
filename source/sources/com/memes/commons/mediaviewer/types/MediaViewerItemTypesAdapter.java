package com.memes.commons.mediaviewer.types;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.memes.commons.mediaviewer.types.MediaViewerItem;
import com.memes.commons.mediaviewer.types.photo.PhotoViewerFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/commons/mediaviewer/types/MediaViewerItemTypesAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "items", "", "Lcom/memes/commons/mediaviewer/types/MediaViewerItem;", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "setItems", "", "", "Companion", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaViewerItemTypesAdapter.kt */
public final class MediaViewerItemTypesAdapter extends FragmentStateAdapter {
    public static final String ARG_MEDIA_PATH = "arg_media_path";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<MediaViewerItem> items = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaViewerItemTypesAdapter(AppCompatActivity appCompatActivity) {
        super((FragmentActivity) appCompatActivity);
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/commons/mediaviewer/types/MediaViewerItemTypesAdapter$Companion;", "", "()V", "ARG_MEDIA_PATH", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaViewerItemTypesAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void setItems(List<? extends MediaViewerItem> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.items.size();
    }

    public Fragment createFragment(int i) {
        Timber.m300d(this + ".createFragment(" + i + ')', new Object[0]);
        MediaViewerItem mediaViewerItem = this.items.get(i);
        if (mediaViewerItem instanceof MediaViewerItem.Photo) {
            PhotoViewerFragment photoViewerFragment = new PhotoViewerFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ARG_MEDIA_PATH, ((MediaViewerItem.Photo) mediaViewerItem).getPath());
            Unit unit = Unit.INSTANCE;
            photoViewerFragment.setArguments(bundle);
            return photoViewerFragment;
        }
        throw new NoWhenBranchMatchedException();
    }
}

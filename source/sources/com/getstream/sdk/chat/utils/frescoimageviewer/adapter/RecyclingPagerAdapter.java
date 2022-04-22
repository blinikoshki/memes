package com.getstream.sdk.chat.utils.frescoimageviewer.adapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.getstream.sdk.chat.utils.frescoimageviewer.adapter.ViewHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class RecyclingPagerAdapter<VH extends ViewHolder> extends PagerAdapter {
    public static boolean DEBUG = false;
    private static final String STATE = "RecyclingPagerAdapter";
    private static final String TAG = "RecyclingPagerAdapter";
    private SparseArray<RecycleCache> mRecycleTypeCaches = new SparseArray<>();
    private SparseArray<Parcelable> mSavedStates = new SparseArray<>();

    public abstract int getItemCount();

    public int getItemId(int i) {
        return i;
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public abstract void onBindViewHolder(VH vh, int i);

    public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

    /* access modifiers changed from: protected */
    public void onNotifyItemChanged(ViewHolder viewHolder) {
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof ViewHolder) {
            ((ViewHolder) obj).detach(viewGroup);
        }
    }

    public int getCount() {
        return getItemCount();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int itemViewType = getItemViewType(i);
        if (this.mRecycleTypeCaches.get(itemViewType) == null) {
            this.mRecycleTypeCaches.put(itemViewType, new RecycleCache(this));
        }
        ViewHolder freeViewHolder = this.mRecycleTypeCaches.get(itemViewType).getFreeViewHolder(viewGroup, itemViewType);
        freeViewHolder.attach(viewGroup, i);
        onBindViewHolder(freeViewHolder, i);
        freeViewHolder.onRestoreInstanceState(this.mSavedStates.get(getItemId(i)));
        return freeViewHolder;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof ViewHolder) && ((ViewHolder) obj).itemView == view;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        for (ViewHolder onNotifyItemChanged : getAttachedViewHolders()) {
            onNotifyItemChanged(onNotifyItemChanged);
        }
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            String str = STATE;
            SparseArray<Parcelable> sparseParcelableArray = bundle.containsKey(str) ? bundle.getSparseParcelableArray(str) : null;
            if (sparseParcelableArray == null) {
                sparseParcelableArray = new SparseArray<>();
            }
            this.mSavedStates = sparseParcelableArray;
        }
        super.restoreState(parcelable, classLoader);
    }

    public Parcelable saveState() {
        Bundle bundle = new Bundle();
        for (ViewHolder next : getAttachedViewHolders()) {
            this.mSavedStates.put(getItemId(next.mPosition), next.onSaveInstanceState());
        }
        bundle.putSparseParcelableArray(STATE, this.mSavedStates);
        return bundle;
    }

    private List<ViewHolder> getAttachedViewHolders() {
        ArrayList arrayList = new ArrayList();
        int size = this.mRecycleTypeCaches.size();
        for (int i = 0; i < size; i++) {
            SparseArray<RecycleCache> sparseArray = this.mRecycleTypeCaches;
            for (ViewHolder viewHolder : sparseArray.get(sparseArray.keyAt(i)).mCaches) {
                if (viewHolder.mIsAttached) {
                    arrayList.add(viewHolder);
                }
            }
        }
        return arrayList;
    }

    private static class RecycleCache {
        private final RecyclingPagerAdapter mAdapter;
        /* access modifiers changed from: private */
        public final List<ViewHolder> mCaches = new ArrayList();

        RecycleCache(RecyclingPagerAdapter recyclingPagerAdapter) {
            this.mAdapter = recyclingPagerAdapter;
        }

        /* access modifiers changed from: package-private */
        public ViewHolder getFreeViewHolder(ViewGroup viewGroup, int i) {
            int size = this.mCaches.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.mCaches.get(i2);
                if (!viewHolder.mIsAttached) {
                    return viewHolder;
                }
            }
            ViewHolder onCreateViewHolder = this.mAdapter.onCreateViewHolder(viewGroup, i);
            this.mCaches.add(onCreateViewHolder);
            return onCreateViewHolder;
        }
    }
}

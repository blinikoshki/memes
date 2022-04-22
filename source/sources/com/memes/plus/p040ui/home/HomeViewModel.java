package com.memes.plus.p040ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.data.storage.StorageRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bJ\u0006\u0010\f\u001a\u00020\tR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/ui/home/HomeViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "(Lcom/memes/plus/data/storage/StorageRepository;)V", "_profileTabIcon", "Landroidx/lifecycle/MutableLiveData;", "", "loadProfileTabIcon", "", "profileTabIcon", "Landroidx/lifecycle/LiveData;", "refreshProfileTabIcon", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.HomeViewModel */
/* compiled from: HomeViewModel.kt */
public final class HomeViewModel extends BaseViewModel {
    private final MutableLiveData<String> _profileTabIcon = new MutableLiveData<>();
    private final StorageRepository storageRepository;

    public HomeViewModel(StorageRepository storageRepository2) {
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        this.storageRepository = storageRepository2;
        loadProfileTabIcon();
    }

    public final LiveData<String> profileTabIcon() {
        return this._profileTabIcon;
    }

    private final void loadProfileTabIcon() {
        this._profileTabIcon.setValue(this.storageRepository.profilePic());
    }

    public final void refreshProfileTabIcon() {
        loadProfileTabIcon();
    }
}

package com.memes.plus.p040ui.welcome;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.util.OneShotLiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016J\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u0016J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0016J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016J\u0006\u0010\u001b\u001a\u00020\u001cR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo26107d2 = {"Lcom/memes/plus/ui/welcome/WelcomeViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "(Lcom/memes/plus/data/storage/StorageRepository;)V", "_backgroundAlphaChanged", "Lcom/memes/commons/util/SingleLiveEvent;", "", "_foregroundSheetColorChanged", "Lkotlin/Pair;", "", "_prominentTextChanged", "", "_showAuthPrompt", "Lcom/memes/plus/util/OneShotLiveData;", "blurMimicColors1", "", "blurMimicColors2", "feedProminentText", "Lkotlinx/coroutines/Job;", "finishWelcomeTour", "onBackgroundAlphaChanged", "Landroidx/lifecycle/LiveData;", "onForegroundSheetColorChanged", "onProminentTextChanged", "onShowAuthPrompt", "", "start", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.welcome.WelcomeViewModel */
/* compiled from: WelcomeViewModel.kt */
public final class WelcomeViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Float> _backgroundAlphaChanged = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Pair<Long, Long>> _foregroundSheetColorChanged = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<String> _prominentTextChanged = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final OneShotLiveData _showAuthPrompt = new OneShotLiveData();
    /* access modifiers changed from: private */
    public final List<Long> blurMimicColors1 = CollectionsKt.listOf(2868574196L, 2868244458L, 2867914976L, 2867650774L, 2867321292L, 2866991553L, 2866662071L, 2866397869L, 2866068387L, 2865738649L, 2865474703L);
    /* access modifiers changed from: private */
    public final List<Long> blurMimicColors2 = CollectionsKt.listOf(4009424884L, 4009095146L, 4008765664L, 4008501462L, 4008171980L, 4007842241L, 4007512759L, 4007248557L, 4006919075L, 4006589337L, 4006325391L);
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;

    public WelcomeViewModel(StorageRepository storageRepository2) {
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        this.storageRepository = storageRepository2;
    }

    public final LiveData<Boolean> onShowAuthPrompt() {
        return this._showAuthPrompt;
    }

    public final LiveData<String> onProminentTextChanged() {
        return this._prominentTextChanged;
    }

    public final LiveData<Float> onBackgroundAlphaChanged() {
        return this._backgroundAlphaChanged;
    }

    public final LiveData<Pair<Long, Long>> onForegroundSheetColorChanged() {
        return this._foregroundSheetColorChanged;
    }

    public final void start() {
        feedProminentText();
    }

    private final Job feedProminentText() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WelcomeViewModel$feedProminentText$1(this, (Continuation) null), 3, (Object) null);
    }

    public final Job finishWelcomeTour() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WelcomeViewModel$finishWelcomeTour$1(this, (Continuation) null), 3, (Object) null);
    }
}

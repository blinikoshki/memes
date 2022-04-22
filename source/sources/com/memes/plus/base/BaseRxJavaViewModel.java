package com.memes.plus.base;

import com.memes.commons.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.disposables.CompositeDisposable;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/base/BaseRxJavaViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "addDisposable", "", "disposable", "Lio/reactivex/disposables/Disposable;", "onCleared", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseRxJavaViewModel.kt */
public class BaseRxJavaViewModel extends BaseViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public final void addDisposable(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "disposable");
        this.compositeDisposable.add(disposable);
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        if (!this.compositeDisposable.isDisposed()) {
            this.compositeDisposable.clear();
        }
        super.onCleared();
    }
}

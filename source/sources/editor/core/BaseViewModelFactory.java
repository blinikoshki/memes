package editor.core;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J'\u0010\b\u001a\u0002H\u0001\"\n\b\u0001\u0010\u0001*\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000bH\u0016¢\u0006\u0002\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, mo26107d2 = {"Leditor/core/BaseViewModelFactory;", "T", "Landroidx/lifecycle/ViewModelProvider$Factory;", "creator", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "getCreator", "()Lkotlin/jvm/functions/Function0;", "create", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoViewModelFactory.kt */
public final class BaseViewModelFactory<T> implements ViewModelProvider.Factory {
    private final Function0<T> creator;

    public BaseViewModelFactory(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "creator");
        this.creator = function0;
    }

    public final Function0<T> getCreator() {
        return this.creator;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return (ViewModel) this.creator.invoke();
    }
}

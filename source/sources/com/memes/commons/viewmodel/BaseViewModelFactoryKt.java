package com.memes.commons.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0010\b\n\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a3\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00072\u0010\b\n\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, mo26107d2 = {"getViewModel", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "creator", "Lkotlin/Function0;", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "commons_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: BaseViewModelFactory.kt */
public final class BaseViewModelFactoryKt {
    public static /* synthetic */ ViewModel getViewModel$default(Fragment fragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "$this$getViewModel");
        if (function0 == null) {
            ViewModelProvider viewModelProvider = new ViewModelProvider(fragment);
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            ViewModel viewModel = viewModelProvider.get(ViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).get(T::class.java)");
            return viewModel;
        }
        ViewModelProvider viewModelProvider2 = new ViewModelProvider((ViewModelStoreOwner) fragment, (ViewModelProvider.Factory) new BaseViewModelFactory(function0));
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ViewModel viewModel2 = viewModelProvider2.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return viewModel2;
    }

    public static final /* synthetic */ <T extends ViewModel> T getViewModel(Fragment fragment, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(fragment, "$this$getViewModel");
        if (function0 == null) {
            ViewModelProvider viewModelProvider = new ViewModelProvider(fragment);
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            T t = viewModelProvider.get(ViewModel.class);
            Intrinsics.checkNotNullExpressionValue(t, "ViewModelProvider(this).get(T::class.java)");
            return t;
        }
        ViewModelProvider viewModelProvider2 = new ViewModelProvider((ViewModelStoreOwner) fragment, (ViewModelProvider.Factory) new BaseViewModelFactory(function0));
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t2 = viewModelProvider2.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(t2, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return t2;
    }

    public static /* synthetic */ ViewModel getViewModel$default(FragmentActivity fragmentActivity, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(fragmentActivity, "$this$getViewModel");
        if (function0 == null) {
            ViewModelProvider viewModelProvider = new ViewModelProvider(fragmentActivity);
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            ViewModel viewModel = viewModelProvider.get(ViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).get(T::class.java)");
            return viewModel;
        }
        ViewModelProvider viewModelProvider2 = new ViewModelProvider((ViewModelStoreOwner) fragmentActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(function0));
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ViewModel viewModel2 = viewModelProvider2.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return viewModel2;
    }

    public static final /* synthetic */ <T extends ViewModel> T getViewModel(FragmentActivity fragmentActivity, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "$this$getViewModel");
        if (function0 == null) {
            ViewModelProvider viewModelProvider = new ViewModelProvider(fragmentActivity);
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            T t = viewModelProvider.get(ViewModel.class);
            Intrinsics.checkNotNullExpressionValue(t, "ViewModelProvider(this).get(T::class.java)");
            return t;
        }
        ViewModelProvider viewModelProvider2 = new ViewModelProvider((ViewModelStoreOwner) fragmentActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(function0));
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t2 = viewModelProvider2.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(t2, "ViewModelProvider(this, …ator)).get(T::class.java)");
        return t2;
    }
}

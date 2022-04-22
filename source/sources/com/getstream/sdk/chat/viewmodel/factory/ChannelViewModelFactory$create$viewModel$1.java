package com.getstream.sdk.chat.viewmodel.factory;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "T", "Landroidx/lifecycle/ViewModel;", "it", "Ljava/lang/Class;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ChannelViewModelFactory.kt */
final class ChannelViewModelFactory$create$viewModel$1 extends Lambda implements Function1<Class<?>, CharSequence> {
    public static final ChannelViewModelFactory$create$viewModel$1 INSTANCE = new ChannelViewModelFactory$create$viewModel$1();

    ChannelViewModelFactory$create$viewModel$1() {
        super(1);
    }

    public final CharSequence invoke(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "it");
        String simpleName = cls.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "it.simpleName");
        return simpleName;
    }
}

package com.getstream.sdk.chat.viewmodel.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.getstream.sdk.chat.viewmodel.ChannelHeaderViewModel;
import com.getstream.sdk.chat.viewmodel.MessageInputViewModel;
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J%\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\bH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/factory/ChannelViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "cid", "", "messageId", "(Ljava/lang/String;Ljava/lang/String;)V", "factories", "", "Ljava/lang/Class;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModel;", "create", "T", "modelClass", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelViewModelFactory.kt */
public final class ChannelViewModelFactory implements ViewModelProvider.Factory {
    /* access modifiers changed from: private */
    public final String cid;
    private final Map<Class<?>, Function0<ViewModel>> factories;
    /* access modifiers changed from: private */
    public final String messageId;

    public ChannelViewModelFactory(String str) {
        this(str, (String) null, 2, (DefaultConstructorMarker) null);
    }

    public ChannelViewModelFactory(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "cid");
        this.cid = str;
        this.messageId = str2;
        this.factories = MapsKt.mapOf(TuplesKt.m181to(ChannelHeaderViewModel.class, new ChannelViewModelFactory$factories$1(this)), TuplesKt.m181to(MessageInputViewModel.class, new ChannelViewModelFactory$factories$2(this)), TuplesKt.m181to(MessageListViewModel.class, new ChannelViewModelFactory$factories$3(this)));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelViewModelFactory(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        T t;
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Function0 function0 = this.factories.get(cls);
        if (function0 == null || (t = (ViewModel) function0.invoke()) == null) {
            throw new IllegalArgumentException("ChannelViewModelFactory can only create instances of the following classes: " + CollectionsKt.joinToString$default(this.factories.keySet(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ChannelViewModelFactory$create$viewModel$1.INSTANCE, 31, (Object) null));
        }
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }
}

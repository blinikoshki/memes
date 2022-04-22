package com.getstream.sdk.chat.view.messageinput;

import com.getstream.sdk.chat.view.messageinput.InputMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, mo26107d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Delegates.kt */
public final class MessageInputController$$special$$inlined$observable$1 extends ObservableProperty<InputMode> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ MessageInputController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageInputController$$special$$inlined$observable$1(Object obj, Object obj2, MessageInputController messageInputController) {
        super(obj2);
        this.$initialValue = obj;
        this.this$0 = messageInputController;
    }

    /* access modifiers changed from: protected */
    public void afterChange(KProperty<?> kProperty, InputMode inputMode, InputMode inputMode2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        InputMode inputMode3 = inputMode2;
        InputMode inputMode4 = inputMode;
        if (inputMode3 instanceof InputMode.Normal) {
            this.this$0.configureNormalInputMode();
            Unit unit = Unit.INSTANCE;
        } else if (inputMode3 instanceof InputMode.Thread) {
            this.this$0.configureThreadInputMode();
            Unit unit2 = Unit.INSTANCE;
        } else if (inputMode3 instanceof InputMode.Edit) {
            this.this$0.configureEditInputMode(((InputMode.Edit) inputMode3).getOldMessage());
            Unit unit3 = Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}

package com.memes.commons.choices;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/commons/choices/ChoicesAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ChoicesBottomSheet.kt */
final class ChoicesBottomSheet$choicesAdapter$2 extends Lambda implements Function0<ChoicesAdapter> {
    final /* synthetic */ ChoicesBottomSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChoicesBottomSheet$choicesAdapter$2(ChoicesBottomSheet choicesBottomSheet) {
        super(0);
        this.this$0 = choicesBottomSheet;
    }

    public final ChoicesAdapter invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ChoicesAdapter(requireContext, new Function1<Choice, Unit>(this.this$0) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Choice) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Choice choice) {
                Intrinsics.checkNotNullParameter(choice, "p1");
                ((ChoicesBottomSheet) this.receiver).selectChoice(choice);
            }
        });
    }
}

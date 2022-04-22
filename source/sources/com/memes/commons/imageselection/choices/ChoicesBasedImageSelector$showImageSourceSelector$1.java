package com.memes.commons.imageselection.choices;

import com.memes.commons.choices.Choice;
import com.memes.commons.choices.ChoicesBottomSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "selectedChoice", "Lcom/memes/commons/choices/Choice;", "onChoiceSelected"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ChoicesBasedImageSelector.kt */
final class ChoicesBasedImageSelector$showImageSourceSelector$1 implements ChoicesBottomSheet.Callback {
    final /* synthetic */ ChoicesBasedImageSelector this$0;

    ChoicesBasedImageSelector$showImageSourceSelector$1(ChoicesBasedImageSelector choicesBasedImageSelector) {
        this.this$0 = choicesBasedImageSelector;
    }

    public final void onChoiceSelected(Choice choice) {
        Intrinsics.checkNotNullParameter(choice, "selectedChoice");
        if (!this.this$0.onChoiceSelected(choice)) {
            this.this$0.openImageSelector(this.this$0.choiceToImageSource(choice));
        }
    }
}

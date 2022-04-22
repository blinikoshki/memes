package com.memes.commons.imageselection.choices;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.commons.choices.Choice;
import com.memes.commons.imageselection.ImageSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\rH\u0014J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/commons/imageselection/choices/ChoicesBasedImageSelectorWithRemovePhotoOption;", "Lcom/memes/commons/imageselection/choices/ChoicesBasedImageSelector;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "providerAuthority", "", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;)V", "hasImageInput", "", "removePhotoOptionSelectedListener", "Lcom/memes/commons/imageselection/choices/ChoicesBasedImageSelectorWithRemovePhotoOption$RemovePhotoOptionSelectedListener;", "createChoices", "", "Lcom/memes/commons/choices/Choice;", "sources", "", "Lcom/memes/commons/imageselection/ImageSource;", "onChoiceSelected", "choice", "setHasImageInput", "setRemovePhotoOptionSelectedListener", "listener", "Companion", "RemovePhotoOptionSelectedListener", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChoicesBasedImageSelectorWithRemovePhotoOption.kt */
public final class ChoicesBasedImageSelectorWithRemovePhotoOption extends ChoicesBasedImageSelector {
    private static final Choice CHOICE_REMOVE_PHOTO = Choice.Companion.create$default(Choice.Companion, "choice-remove-photo", "Remove Photo", false, Choice.HighlightType.DANGER, 4, (Object) null);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean hasImageInput;
    private RemovePhotoOptionSelectedListener removePhotoOptionSelectedListener;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo26107d2 = {"Lcom/memes/commons/imageselection/choices/ChoicesBasedImageSelectorWithRemovePhotoOption$RemovePhotoOptionSelectedListener;", "", "onRemovePhotoOptionSelected", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChoicesBasedImageSelectorWithRemovePhotoOption.kt */
    public interface RemovePhotoOptionSelectedListener {
        void onRemovePhotoOptionSelected();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChoicesBasedImageSelectorWithRemovePhotoOption(AppCompatActivity appCompatActivity, String str) {
        super(appCompatActivity, str);
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "providerAuthority");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/commons/imageselection/choices/ChoicesBasedImageSelectorWithRemovePhotoOption$Companion;", "", "()V", "CHOICE_REMOVE_PHOTO", "Lcom/memes/commons/choices/Choice;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChoicesBasedImageSelectorWithRemovePhotoOption.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final ChoicesBasedImageSelectorWithRemovePhotoOption setHasImageInput(boolean z) {
        this.hasImageInput = z;
        return this;
    }

    public final ChoicesBasedImageSelectorWithRemovePhotoOption setRemovePhotoOptionSelectedListener(RemovePhotoOptionSelectedListener removePhotoOptionSelectedListener2) {
        Intrinsics.checkNotNullParameter(removePhotoOptionSelectedListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.removePhotoOptionSelectedListener = removePhotoOptionSelectedListener2;
        return this;
    }

    /* access modifiers changed from: protected */
    public List<Choice> createChoices(List<? extends ImageSource> list) {
        Intrinsics.checkNotNullParameter(list, "sources");
        List<Choice> createChoices = super.createChoices(list);
        if (this.hasImageInput) {
            createChoices.add(CHOICE_REMOVE_PHOTO);
        }
        return createChoices;
    }

    /* access modifiers changed from: protected */
    public boolean onChoiceSelected(Choice choice) {
        Intrinsics.checkNotNullParameter(choice, "choice");
        if (!Intrinsics.areEqual((Object) choice.getId(), (Object) CHOICE_REMOVE_PHOTO.getId())) {
            return super.onChoiceSelected(choice);
        }
        RemovePhotoOptionSelectedListener removePhotoOptionSelectedListener2 = this.removePhotoOptionSelectedListener;
        if (removePhotoOptionSelectedListener2 == null) {
            return true;
        }
        removePhotoOptionSelectedListener2.onRemovePhotoOptionSelected();
        return true;
    }
}

package com.memes.commons.imageselection.choices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.memes.commons.choices.Choice;
import com.memes.commons.choices.ChoicesBottomSheet;
import com.memes.commons.imageselection.ImageSelector;
import com.memes.commons.imageselection.ImageSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0015J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0014J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/commons/imageselection/choices/ChoicesBasedImageSelector;", "Lcom/memes/commons/imageselection/ImageSelector;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "providerAuthority", "", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;)V", "choiceToImageSource", "Lcom/memes/commons/imageselection/ImageSource;", "choice", "Lcom/memes/commons/choices/Choice;", "createChoices", "", "sources", "", "imageSourceToChoice", "source", "onChoiceSelected", "", "showImageSourceSelector", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChoicesBasedImageSelector.kt */
public class ChoicesBasedImageSelector extends ImageSelector {
    private final AppCompatActivity activity;

    /* access modifiers changed from: protected */
    public boolean onChoiceSelected(Choice choice) {
        Intrinsics.checkNotNullParameter(choice, "choice");
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChoicesBasedImageSelector(AppCompatActivity appCompatActivity, String str) {
        super(appCompatActivity, str);
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "providerAuthority");
        this.activity = appCompatActivity;
    }

    /* access modifiers changed from: protected */
    public List<Choice> createChoices(List<? extends ImageSource> list) {
        Intrinsics.checkNotNullParameter(list, "sources");
        List<Choice> arrayList = new ArrayList<>();
        for (ImageSource imageSourceToChoice : list) {
            arrayList.add(imageSourceToChoice(imageSourceToChoice));
        }
        return arrayList;
    }

    private final Choice imageSourceToChoice(ImageSource imageSource) {
        return Choice.Companion.create$default(Choice.Companion, imageSource.name(), imageSource.getDisplayName(), false, (Choice.HighlightType) null, 12, (Object) null);
    }

    /* access modifiers changed from: private */
    public final ImageSource choiceToImageSource(Choice choice) {
        return ImageSource.valueOf(choice.getId());
    }

    /* access modifiers changed from: protected */
    public void showImageSourceSelector(List<? extends ImageSource> list) {
        Intrinsics.checkNotNullParameter(list, "sources");
        ChoicesBottomSheet choicesBottomSheet = new ChoicesBottomSheet();
        FragmentManager supportFragmentManager = this.activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        choicesBottomSheet.show(supportFragmentManager, createChoices(list), new ChoicesBasedImageSelector$showImageSourceSelector$1(this));
    }
}

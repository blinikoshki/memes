package com.memes.commons.choices;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.memes.commons.C4144R;
import com.memes.commons.databinding.ChoicesBottomSheetBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J$\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, mo26107d2 = {"Lcom/memes/commons/choices/ChoicesBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "callback", "Lcom/memes/commons/choices/ChoicesBottomSheet$Callback;", "choices", "", "Lcom/memes/commons/choices/Choice;", "choicesAdapter", "Lcom/memes/commons/choices/ChoicesAdapter;", "getChoicesAdapter", "()Lcom/memes/commons/choices/ChoicesAdapter;", "choicesAdapter$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "selectChoice", "choice", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Callback", "Companion", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChoicesBottomSheet.kt */
public class ChoicesBottomSheet extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "choices-bottom-sheet";
    private Callback callback;
    private List<Choice> choices = new ArrayList();
    private final Lazy choicesAdapter$delegate = LazyKt.lazy(new ChoicesBottomSheet$choicesAdapter$2(this));

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/commons/choices/ChoicesBottomSheet$Callback;", "", "onChoiceSelected", "", "choice", "Lcom/memes/commons/choices/Choice;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChoicesBottomSheet.kt */
    public interface Callback {
        void onChoiceSelected(Choice choice);
    }

    private final ChoicesAdapter getChoicesAdapter() {
        return (ChoicesAdapter) this.choicesAdapter$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/commons/choices/ChoicesBottomSheet$Companion;", "", "()V", "TAG", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChoicesBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, C4144R.C4152style.ChoicesBottomSheetTheme);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ChoicesBottomSheetBinding inflate = ChoicesBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ChoicesBottomSheetBindin…flater, container, false)");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        RecyclerView recyclerView = inflate.choicesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.choicesRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = inflate.choicesRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.choicesRecyclerView");
        recyclerView2.setAdapter(getChoicesAdapter());
        getChoicesAdapter().setItems(this.choices);
        inflate.cancelView.setOnClickListener(new ChoicesBottomSheet$onCreateView$1(this));
        return inflate.getRoot();
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }

    public final void show(FragmentManager fragmentManager, List<Choice> list, Callback callback2) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(list, "choices");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            List<Choice> arrayList = new ArrayList<>();
            int i = 0;
            for (Choice add : list) {
                arrayList.add(add);
                if (i != list.size() - 1) {
                    arrayList.add(Choice.Companion.divider());
                }
                i++;
            }
            this.choices = arrayList;
            this.callback = callback2;
            show(fragmentManager, TAG);
        }
    }

    /* access modifiers changed from: private */
    public final void selectChoice(Choice choice) {
        if (!choice.getEnabled()) {
            Timber.m303e("Can't select this choice: " + choice, new Object[0]);
            dismiss();
        } else if (choice.hasSubChoices()) {
            getChoicesAdapter().setItems(choice.getSubChoices());
        } else {
            Callback callback2 = this.callback;
            if (callback2 != null) {
                callback2.onChoiceSelected(choice);
            }
            dismiss();
        }
    }
}

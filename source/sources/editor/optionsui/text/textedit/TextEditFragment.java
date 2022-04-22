package editor.optionsui.text.textedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NTextEditFragmentBinding;
import editor.editor.equipment.text.TextStyle;
import editor.optionsui.text.tabs.TextTabsViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006("}, mo26107d2 = {"Leditor/optionsui/text/textedit/TextEditFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/memes/editor/databinding/NTextEditFragmentBinding;", "textEditViewModel", "Leditor/optionsui/text/textedit/TextEditViewModel;", "getTextEditViewModel", "()Leditor/optionsui/text/textedit/TextEditViewModel;", "textEditViewModel$delegate", "Lkotlin/Lazy;", "textTabsViewModel", "Leditor/optionsui/text/tabs/TextTabsViewModel;", "getTextTabsViewModel", "()Leditor/optionsui/text/tabs/TextTabsViewModel;", "textTabsViewModel$delegate", "applyTextStyle", "", "style", "Leditor/editor/equipment/text/TextStyle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setOtherOptionListeners", "setTextAlignmentListeners", "setTextCapModeListeners", "setTextFontStyleListeners", "showAlignmentSelection", "alignment", "Leditor/optionsui/text/textedit/TextAlignment;", "showCapModeSelection", "capMode", "Leditor/optionsui/text/textedit/TextCapMode;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextEditFragment.kt */
public final class TextEditFragment extends Fragment {
    /* access modifiers changed from: private */
    public NTextEditFragmentBinding binding;
    private final Lazy textEditViewModel$delegate = LazyKt.lazy(new TextEditFragment$textEditViewModel$2(this));
    private final Lazy textTabsViewModel$delegate = LazyKt.lazy(new TextEditFragment$textTabsViewModel$2(this));

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextAlignment.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TextAlignment.LEFT.ordinal()] = 1;
            iArr[TextAlignment.CENTER.ordinal()] = 2;
            iArr[TextAlignment.RIGHT.ordinal()] = 3;
        }
    }

    /* access modifiers changed from: private */
    public final TextEditViewModel getTextEditViewModel() {
        return (TextEditViewModel) this.textEditViewModel$delegate.getValue();
    }

    private final TextTabsViewModel getTextTabsViewModel() {
        return (TextTabsViewModel) this.textTabsViewModel$delegate.getValue();
    }

    public static final /* synthetic */ NTextEditFragmentBinding access$getBinding$p(TextEditFragment textEditFragment) {
        NTextEditFragmentBinding nTextEditFragmentBinding = textEditFragment.binding;
        if (nTextEditFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nTextEditFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NTextEditFragmentBinding inflate = NTextEditFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NTextEditFragmentBinding…flater, container, false)");
        this.binding = inflate;
        setTextFontStyleListeners();
        setTextAlignmentListeners();
        setTextCapModeListeners();
        setOtherOptionListeners();
        NTextEditFragmentBinding nTextEditFragmentBinding = this.binding;
        if (nTextEditFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nTextEditFragmentBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getTextEditViewModel().setOnTextOptionSelectedListener(getTextTabsViewModel());
        getTextEditViewModel().setOnPropertyUpdatedListener(getTextTabsViewModel());
        getTextTabsViewModel().onTextStyleSet().observe(getViewLifecycleOwner(), new TextEditFragment$onViewCreated$1(this));
    }

    private final void setTextFontStyleListeners() {
        NTextEditFragmentBinding nTextEditFragmentBinding = this.binding;
        if (nTextEditFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding.boldOptionView.setOnClickListener(new TextEditFragment$setTextFontStyleListeners$1(this));
        NTextEditFragmentBinding nTextEditFragmentBinding2 = this.binding;
        if (nTextEditFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding2.italicOptionView.setOnClickListener(new TextEditFragment$setTextFontStyleListeners$2(this));
        NTextEditFragmentBinding nTextEditFragmentBinding3 = this.binding;
        if (nTextEditFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding3.underlineOptionView.setOnClickListener(new TextEditFragment$setTextFontStyleListeners$3(this));
    }

    private final void setTextAlignmentListeners() {
        NTextEditFragmentBinding nTextEditFragmentBinding = this.binding;
        if (nTextEditFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding.alignLeftOptionView.setOnClickListener(new TextEditFragment$setTextAlignmentListeners$1(this));
        NTextEditFragmentBinding nTextEditFragmentBinding2 = this.binding;
        if (nTextEditFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding2.alignCenterOptionView.setOnClickListener(new TextEditFragment$setTextAlignmentListeners$2(this));
        NTextEditFragmentBinding nTextEditFragmentBinding3 = this.binding;
        if (nTextEditFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding3.alignRightOptionView.setOnClickListener(new TextEditFragment$setTextAlignmentListeners$3(this));
    }

    private final void setTextCapModeListeners() {
        NTextEditFragmentBinding nTextEditFragmentBinding = this.binding;
        if (nTextEditFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding.allCapsOptionView.setOnClickListener(new TextEditFragment$setTextCapModeListeners$1(this));
        NTextEditFragmentBinding nTextEditFragmentBinding2 = this.binding;
        if (nTextEditFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding2.wordCapsOptionView.setOnClickListener(new TextEditFragment$setTextCapModeListeners$2(this));
        NTextEditFragmentBinding nTextEditFragmentBinding3 = this.binding;
        if (nTextEditFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding3.noCapsOptionView.setOnClickListener(new TextEditFragment$setTextCapModeListeners$3(this));
    }

    private final void setOtherOptionListeners() {
        NTextEditFragmentBinding nTextEditFragmentBinding = this.binding;
        if (nTextEditFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding.adjustOptionView.setOnClickListener(new TextEditFragment$setOtherOptionListeners$1(this));
        NTextEditFragmentBinding nTextEditFragmentBinding2 = this.binding;
        if (nTextEditFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding2.nudgeOptionView.setOnClickListener(new TextEditFragment$setOtherOptionListeners$2(this));
        NTextEditFragmentBinding nTextEditFragmentBinding3 = this.binding;
        if (nTextEditFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding3.spacingOptionView.setOnClickListener(new TextEditFragment$setOtherOptionListeners$3(this));
        NTextEditFragmentBinding nTextEditFragmentBinding4 = this.binding;
        if (nTextEditFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding4.editTextOptionView.setOnClickListener(new TextEditFragment$setOtherOptionListeners$4(this));
        NTextEditFragmentBinding nTextEditFragmentBinding5 = this.binding;
        if (nTextEditFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding5.duplicateOptionView.setOnClickListener(new TextEditFragment$setOtherOptionListeners$5(this));
        NTextEditFragmentBinding nTextEditFragmentBinding6 = this.binding;
        if (nTextEditFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nTextEditFragmentBinding6.deleteOptionView.setOnClickListener(new TextEditFragment$setOtherOptionListeners$6(this));
    }

    /* access modifiers changed from: private */
    public final void applyTextStyle(TextStyle textStyle) {
        TextFontStyle fontStyle = textStyle.getFontStyle();
        NTextEditFragmentBinding nTextEditFragmentBinding = this.binding;
        if (nTextEditFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppCompatImageView appCompatImageView = nTextEditFragmentBinding.boldOptionView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.boldOptionView");
        appCompatImageView.setSelected(fontStyle.getBold());
        NTextEditFragmentBinding nTextEditFragmentBinding2 = this.binding;
        if (nTextEditFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppCompatImageView appCompatImageView2 = nTextEditFragmentBinding2.italicOptionView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "binding.italicOptionView");
        appCompatImageView2.setSelected(fontStyle.getItalic());
        NTextEditFragmentBinding nTextEditFragmentBinding3 = this.binding;
        if (nTextEditFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppCompatImageView appCompatImageView3 = nTextEditFragmentBinding3.underlineOptionView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "binding.underlineOptionView");
        appCompatImageView3.setSelected(fontStyle.getUnderline());
        showAlignmentSelection(textStyle.getAlignment());
        showCapModeSelection(textStyle.getCapMode());
    }

    private final void showAlignmentSelection(TextAlignment textAlignment) {
        NTextEditFragmentBinding nTextEditFragmentBinding = this.binding;
        if (nTextEditFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppCompatImageView appCompatImageView = nTextEditFragmentBinding.alignLeftOptionView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.alignLeftOptionView");
        appCompatImageView.setSelected(false);
        NTextEditFragmentBinding nTextEditFragmentBinding2 = this.binding;
        if (nTextEditFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppCompatImageView appCompatImageView2 = nTextEditFragmentBinding2.alignCenterOptionView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "binding.alignCenterOptionView");
        appCompatImageView2.setSelected(false);
        NTextEditFragmentBinding nTextEditFragmentBinding3 = this.binding;
        if (nTextEditFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppCompatImageView appCompatImageView3 = nTextEditFragmentBinding3.alignRightOptionView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "binding.alignRightOptionView");
        appCompatImageView3.setSelected(false);
        int i = WhenMappings.$EnumSwitchMapping$0[textAlignment.ordinal()];
        if (i == 1) {
            NTextEditFragmentBinding nTextEditFragmentBinding4 = this.binding;
            if (nTextEditFragmentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppCompatImageView appCompatImageView4 = nTextEditFragmentBinding4.alignLeftOptionView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView4, "binding.alignLeftOptionView");
            appCompatImageView4.setSelected(true);
        } else if (i == 2) {
            NTextEditFragmentBinding nTextEditFragmentBinding5 = this.binding;
            if (nTextEditFragmentBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppCompatImageView appCompatImageView5 = nTextEditFragmentBinding5.alignCenterOptionView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView5, "binding.alignCenterOptionView");
            appCompatImageView5.setSelected(true);
        } else if (i == 3) {
            NTextEditFragmentBinding nTextEditFragmentBinding6 = this.binding;
            if (nTextEditFragmentBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppCompatImageView appCompatImageView6 = nTextEditFragmentBinding6.alignRightOptionView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView6, "binding.alignRightOptionView");
            appCompatImageView6.setSelected(true);
        }
    }

    private final void showCapModeSelection(TextCapMode textCapMode) {
        if (textCapMode.getCapAll()) {
            NTextEditFragmentBinding nTextEditFragmentBinding = this.binding;
            if (nTextEditFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppCompatImageView appCompatImageView = nTextEditFragmentBinding.allCapsOptionView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.allCapsOptionView");
            appCompatImageView.setSelected(true);
        } else if (textCapMode.getCapWords()) {
            NTextEditFragmentBinding nTextEditFragmentBinding2 = this.binding;
            if (nTextEditFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppCompatImageView appCompatImageView2 = nTextEditFragmentBinding2.wordCapsOptionView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "binding.wordCapsOptionView");
            appCompatImageView2.setSelected(true);
        } else if (textCapMode.getCapNone()) {
            NTextEditFragmentBinding nTextEditFragmentBinding3 = this.binding;
            if (nTextEditFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppCompatImageView appCompatImageView3 = nTextEditFragmentBinding3.noCapsOptionView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "binding.noCapsOptionView");
            appCompatImageView3.setSelected(true);
        } else {
            NTextEditFragmentBinding nTextEditFragmentBinding4 = this.binding;
            if (nTextEditFragmentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppCompatImageView appCompatImageView4 = nTextEditFragmentBinding4.allCapsOptionView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView4, "binding.allCapsOptionView");
            appCompatImageView4.setSelected(false);
            NTextEditFragmentBinding nTextEditFragmentBinding5 = this.binding;
            if (nTextEditFragmentBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppCompatImageView appCompatImageView5 = nTextEditFragmentBinding5.wordCapsOptionView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView5, "binding.wordCapsOptionView");
            appCompatImageView5.setSelected(false);
            NTextEditFragmentBinding nTextEditFragmentBinding6 = this.binding;
            if (nTextEditFragmentBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppCompatImageView appCompatImageView6 = nTextEditFragmentBinding6.noCapsOptionView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView6, "binding.noCapsOptionView");
            appCompatImageView6.setSelected(false);
        }
    }
}

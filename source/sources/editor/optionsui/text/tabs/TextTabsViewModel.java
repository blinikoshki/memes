package editor.optionsui.text.tabs;

import androidx.lifecycle.LiveData;
import com.memes.commons.util.SingleLiveEvent;
import editor.core.NicoViewModel;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.editor.equipment.property.TextProperty;
import editor.editor.equipment.text.TextStyle;
import editor.editor.equipment.trigger.NicoTrigger;
import editor.optionsui.OnPropertyUpdatedListener;
import editor.optionsui.text.OnTextOptionSelectedListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0011J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011J\u0016\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo26107d2 = {"Leditor/optionsui/text/tabs/TextTabsViewModel;", "Leditor/core/NicoViewModel;", "Leditor/optionsui/text/OnTextOptionSelectedListener;", "Leditor/optionsui/OnPropertyUpdatedListener;", "()V", "_propertyBundleApplied", "Lcom/memes/commons/util/SingleLiveEvent;", "Leditor/editor/equipment/property/NicoPropertyBundle;", "_textOptionSelected", "Leditor/editor/equipment/trigger/NicoTrigger;", "_textStyleSet", "Leditor/editor/equipment/text/TextStyle;", "initialTextStyle", "propertyBundle", "discardChanges", "", "onPropertyBundleApplied", "Landroidx/lifecycle/LiveData;", "onPropertyUpdated", "property", "Leditor/editor/equipment/property/NicoProperty;", "onTextOptionSelected", "targetOption", "", "onTextStyleSet", "setStyle", "token", "", "style", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextTabsViewModel.kt */
public final class TextTabsViewModel extends NicoViewModel implements OnTextOptionSelectedListener, OnPropertyUpdatedListener {
    private final SingleLiveEvent<NicoPropertyBundle> _propertyBundleApplied = new SingleLiveEvent<>();
    private final SingleLiveEvent<NicoTrigger> _textOptionSelected = new SingleLiveEvent<>();
    private final SingleLiveEvent<TextStyle> _textStyleSet = new SingleLiveEvent<>();
    private TextStyle initialTextStyle;
    private NicoPropertyBundle propertyBundle;

    public final LiveData<TextStyle> onTextStyleSet() {
        return this._textStyleSet;
    }

    public final LiveData<NicoPropertyBundle> onPropertyBundleApplied() {
        return this._propertyBundleApplied;
    }

    public final LiveData<NicoTrigger> onTextOptionSelected() {
        return this._textOptionSelected;
    }

    public final void setStyle(String str, TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        this.propertyBundle = new NicoPropertyBundle(str, (List) null, 2, (DefaultConstructorMarker) null);
        TextStyle textStyle2 = new TextStyle();
        this.initialTextStyle = textStyle2;
        if (textStyle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialTextStyle");
        }
        textStyle.copy(textStyle2);
        this._textStyleSet.setValue(textStyle);
    }

    public void onTextOptionSelected(int i) {
        SingleLiveEvent<NicoTrigger> singleLiveEvent = this._textOptionSelected;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(new NicoTrigger(nicoPropertyBundle.getToken(), i));
    }

    public void onPropertyUpdated(NicoProperty nicoProperty) {
        Intrinsics.checkNotNullParameter(nicoProperty, "property");
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._propertyBundleApplied;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(nicoProperty));
    }

    public final void discardChanges() {
        SingleLiveEvent<NicoPropertyBundle> singleLiveEvent = this._propertyBundleApplied;
        NicoPropertyBundle nicoPropertyBundle = this.propertyBundle;
        if (nicoPropertyBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyBundle");
        }
        NicoProperty[] nicoPropertyArr = new NicoProperty[8];
        TextStyle textStyle = this.initialTextStyle;
        if (textStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialTextStyle");
        }
        nicoPropertyArr[0] = new TextProperty.Text(textStyle.getText());
        TextStyle textStyle2 = this.initialTextStyle;
        if (textStyle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialTextStyle");
        }
        nicoPropertyArr[1] = new TextProperty.TextMargin(textStyle2.getMargin());
        TextStyle textStyle3 = this.initialTextStyle;
        if (textStyle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialTextStyle");
        }
        nicoPropertyArr[2] = new TextProperty.Alignment(textStyle3.getAlignment());
        TextStyle textStyle4 = this.initialTextStyle;
        if (textStyle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialTextStyle");
        }
        nicoPropertyArr[3] = new TextProperty.FontStyle(textStyle4.getFontStyle());
        TextStyle textStyle5 = this.initialTextStyle;
        if (textStyle5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialTextStyle");
        }
        nicoPropertyArr[4] = new TextProperty.Caps(textStyle5.getCapMode());
        TextStyle textStyle6 = this.initialTextStyle;
        if (textStyle6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialTextStyle");
        }
        nicoPropertyArr[5] = new TextProperty.TextColor(textStyle6.getColor());
        TextStyle textStyle7 = this.initialTextStyle;
        if (textStyle7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialTextStyle");
        }
        nicoPropertyArr[6] = new NicoProperty.Background(textStyle7.getBackground());
        TextStyle textStyle8 = this.initialTextStyle;
        if (textStyle8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialTextStyle");
        }
        nicoPropertyArr[7] = new TextProperty.Font(textStyle8.getFont());
        singleLiveEvent.setValue(nicoPropertyBundle.setProperties(nicoPropertyArr));
    }
}

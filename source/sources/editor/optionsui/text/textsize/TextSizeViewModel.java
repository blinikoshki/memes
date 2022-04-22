package editor.optionsui.text.textsize;

import androidx.lifecycle.ViewModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import editor.editor.equipment.property.TextProperty;
import editor.optionsui.OnPropertyUpdatedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Leditor/optionsui/text/textsize/TextSizeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "propertyUpdateListener", "Leditor/optionsui/OnPropertyUpdatedListener;", "changeTextAutoSizeEnabled", "", "enabled", "", "changeTextSize", "textSize", "", "setOnPropertyUpdatedListener", "listener", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextSizeViewModel.kt */
public final class TextSizeViewModel extends ViewModel {
    private OnPropertyUpdatedListener propertyUpdateListener;

    public final void setOnPropertyUpdatedListener(OnPropertyUpdatedListener onPropertyUpdatedListener) {
        Intrinsics.checkNotNullParameter(onPropertyUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.propertyUpdateListener = onPropertyUpdatedListener;
    }

    public final void changeTextSize(float f) {
        TextProperty.TextSize textSize = new TextProperty.TextSize(f);
        OnPropertyUpdatedListener onPropertyUpdatedListener = this.propertyUpdateListener;
        if (onPropertyUpdatedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyUpdateListener");
        }
        onPropertyUpdatedListener.onPropertyUpdated(textSize);
    }

    public final void changeTextAutoSizeEnabled(boolean z) {
        TextProperty.TextAutoSize textAutoSize = new TextProperty.TextAutoSize(z);
        OnPropertyUpdatedListener onPropertyUpdatedListener = this.propertyUpdateListener;
        if (onPropertyUpdatedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("propertyUpdateListener");
        }
        onPropertyUpdatedListener.onPropertyUpdated(textAutoSize);
    }
}

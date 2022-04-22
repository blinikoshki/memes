package editor.editor.showcase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NShowcaseActivityBinding;
import editor.trash.ColorAdjustSheet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, mo26107d2 = {"Leditor/editor/showcase/ShowcaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/memes/editor/databinding/NShowcaseActivityBinding;", "getBinding", "()Lcom/memes/editor/databinding/NShowcaseActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "initColorAdjustSliderSheet", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showMessage", "message", "", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ShowcaseActivity.kt */
public final class ShowcaseActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy binding$delegate = LazyKt.lazy(new ShowcaseActivity$binding$2(this));

    private final NShowcaseActivityBinding getBinding() {
        return (NShowcaseActivityBinding) this.binding$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/editor/showcase/ShowcaseActivity$Companion;", "", "()V", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ShowcaseActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, ShowcaseActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(C4175R.C4183style.ShowcaseTheme);
        NShowcaseActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        initColorAdjustSliderSheet();
    }

    private final void initColorAdjustSliderSheet() {
        ColorAdjustSheet colorAdjustSheet = getBinding().colorAdjustSliderSheet;
        colorAdjustSheet.updateOpacitySlider(new C4720x6bc8de07(this));
        colorAdjustSheet.updateShadeSelector(new C4722x6bc8de08(this));
        colorAdjustSheet.updateHeader(new C4724x6bc8de09(this));
        colorAdjustSheet.updateFooter(new C4726x6bc8de0a(this));
    }

    /* access modifiers changed from: private */
    public final void showMessage(String str) {
        NShowcaseActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        Snackbar.make((View) binding.getRoot(), (CharSequence) str, -1).show();
    }
}

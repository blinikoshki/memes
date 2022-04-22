package editor.optionsui.addcontent.text;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.editor.databinding.NAddTextActivityBinding;
import editor.editor.equipment.text.TextConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\nH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/optionsui/addcontent/text/AddTextActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/memes/editor/databinding/NAddTextActivityBinding;", "getBinding", "()Lcom/memes/editor/databinding/NAddTextActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "onCancelButtonTapped", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDoneButtonTapped", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AddTextActivity.kt */
public final class AddTextActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_INPUT_TEXT = "intent_extra_input_text";
    public static final String EXTRA_OUTPUT_TEXT = "intent_extra_output_text";
    private final Lazy binding$delegate = LazyKt.lazy(new AddTextActivity$binding$2(this));

    private final NAddTextActivityBinding getBinding() {
        return (NAddTextActivityBinding) this.binding$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Leditor/optionsui/addcontent/text/AddTextActivity$Companion;", "", "()V", "EXTRA_INPUT_TEXT", "", "EXTRA_OUTPUT_TEXT", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: AddTextActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NAddTextActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        AddTextActivity addTextActivity = this;
        getBinding().footer.setOnDoneButtonClickListener(new AddTextActivity$onCreate$1(addTextActivity));
        getBinding().footer.setOnCancelButtonClickListener(new AddTextActivity$onCreate$2(addTextActivity));
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(EXTRA_INPUT_TEXT) : null;
        CharSequence charSequence = stringExtra;
        if (!(charSequence == null || StringsKt.isBlank(charSequence)) && (!Intrinsics.areEqual((Object) stringExtra, (Object) TextConfig.DEFAULT_TEXT))) {
            getBinding().editText.setText(charSequence);
        }
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText = getBinding().editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        softKeyboardUtil.showKeyboard(editText);
    }

    /* access modifiers changed from: private */
    public final void onCancelButtonTapped() {
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText = getBinding().editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        softKeyboardUtil.hideKeyboard(editText);
        finish();
    }

    /* access modifiers changed from: private */
    public final void onDoneButtonTapped() {
        EditText editText = getBinding().editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        Editable text = editText.getText();
        CharSequence charSequence = text;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            ExtensionsKt.toast((Context) this, "Please add some text");
            return;
        }
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText2 = getBinding().editText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.editText");
        softKeyboardUtil.hideKeyboard(editText2);
        Intent intent = new Intent();
        intent.putExtra(EXTRA_OUTPUT_TEXT, text.toString());
        setResult(-1, intent);
        finish();
    }
}

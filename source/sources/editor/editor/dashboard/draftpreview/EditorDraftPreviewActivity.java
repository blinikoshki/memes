package editor.editor.dashboard.draftpreview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.memes.editor.databinding.NDraftPreviewActivityBinding;
import editor.core.NicoActivity;
import editor.editor.dashboard.drafts.EditorDraftsViewModel;
import editor.util.ExtKt;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, mo26107d2 = {"Leditor/editor/dashboard/draftpreview/EditorDraftPreviewActivity;", "Leditor/core/NicoActivity;", "()V", "binding", "Lcom/memes/editor/databinding/NDraftPreviewActivityBinding;", "getBinding", "()Lcom/memes/editor/databinding/NDraftPreviewActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "draftId", "", "getDraftId", "()Ljava/lang/String;", "draftId$delegate", "draftThumbnailPath", "getDraftThumbnailPath", "draftThumbnailPath$delegate", "viewModel", "Leditor/editor/dashboard/drafts/EditorDraftsViewModel;", "getViewModel", "()Leditor/editor/dashboard/drafts/EditorDraftsViewModel;", "viewModel$delegate", "loadThumbnail", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showThumbnailNotAvailable", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(message = "unused")
/* compiled from: EditorDraftPreviewActivity.kt */
public final class EditorDraftPreviewActivity extends NicoActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_DRAFT_ID = "intent.extra._draft_id";
    private static final String EXTRA_DRAFT_THUMB_PATH = "intent.extra._draft_thumb_path";
    private final Lazy binding$delegate = LazyKt.lazy(new EditorDraftPreviewActivity$binding$2(this));
    private final Lazy draftId$delegate = LazyKt.lazy(new EditorDraftPreviewActivity$draftId$2(this));
    private final Lazy draftThumbnailPath$delegate = LazyKt.lazy(new EditorDraftPreviewActivity$draftThumbnailPath$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new EditorDraftPreviewActivity$viewModel$2(this));

    private final NDraftPreviewActivityBinding getBinding() {
        return (NDraftPreviewActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getDraftId() {
        return (String) this.draftId$delegate.getValue();
    }

    private final String getDraftThumbnailPath() {
        return (String) this.draftThumbnailPath$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditorDraftsViewModel getViewModel() {
        return (EditorDraftsViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Leditor/editor/dashboard/draftpreview/EditorDraftPreviewActivity$Companion;", "", "()V", "EXTRA_DRAFT_ID", "", "EXTRA_DRAFT_THUMB_PATH", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "draftId", "draftThumbnailPath", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorDraftPreviewActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent getStartIntent$default(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.getStartIntent(context, str, str2);
        }

        public final Intent getStartIntent(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "draftId");
            Intent intent = new Intent(context, EditorDraftPreviewActivity.class);
            intent.putExtra("intent.extra._draft_id", str);
            intent.putExtra("intent.extra._draft_thumb_path", str2);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NDraftPreviewActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getViewModel());
        getBinding().closeDraftPreviewView.setOnClickListener(new EditorDraftPreviewActivity$onCreate$1(this));
        getBinding().editDraftView.setOnClickListener(new EditorDraftPreviewActivity$onCreate$2(this));
        getBinding().shareDraftView.setOnClickListener(EditorDraftPreviewActivity$onCreate$3.INSTANCE);
        getBinding().deleteDraftView.setOnClickListener(new EditorDraftPreviewActivity$onCreate$4(this));
        getViewModel().onDraftDeleted().observe(this, new EditorDraftPreviewActivity$onCreate$5(this));
        loadThumbnail();
    }

    private final void loadThumbnail() {
        String draftThumbnailPath = getDraftThumbnailPath();
        CharSequence charSequence = draftThumbnailPath;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            showThumbnailNotAvailable();
            return;
        }
        File file = new File(draftThumbnailPath);
        if (!file.exists()) {
            showThumbnailNotAvailable();
        } else {
            Glide.with((FragmentActivity) this).load(file).into(getBinding().thumbnailImageView);
        }
    }

    private final void showThumbnailNotAvailable() {
        getBinding().thumbnailImageView.setImageResource(0);
        getBinding().thumbnailImageView.setBackgroundColor(ExtKt.nextRgb$default(Random.Default, 0, 1, (Object) null));
    }
}

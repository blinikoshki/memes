package editor.optionsui.addcontent.contentpicker;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AlertDialog;
import com.memes.commons.activity.ContractLauncher;
import com.memes.commons.media.MediaContent;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.editor.databinding.NContentPickerActivityBinding;
import editor.common.mediapicker.GetContentResultContract;
import editor.common.mediapicker.MimeMediaPicker;
import editor.core.NicoActivity;
import editor.tools.videotrim.VideoTrimActivityContract;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0014\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0002J\u0010\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020-H\u0002J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020-H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R*\u0010\t\u001a\u001e\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\r0\r0\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u001e¨\u00062"}, mo26107d2 = {"Leditor/optionsui/addcontent/contentpicker/ContentPickerActivity;", "Leditor/core/NicoActivity;", "()V", "binding", "Lcom/memes/editor/databinding/NContentPickerActivityBinding;", "getBinding", "()Lcom/memes/editor/databinding/NContentPickerActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "getContentResultContractLauncher", "Lcom/memes/commons/activity/ContractLauncher;", "", "kotlin.jvm.PlatformType", "Landroid/net/Uri;", "mimeMediaImporter", "Leditor/common/mediapicker/MimeMediaPicker;", "getMimeMediaImporter", "()Leditor/common/mediapicker/MimeMediaPicker;", "mimeMediaImporter$delegate", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "getOutputTargetGenerator", "()Lcom/memes/commons/output/OutputTargetGenerator;", "outputTargetGenerator$delegate", "pickerTarget", "Leditor/optionsui/addcontent/contentpicker/ContentPickerTarget;", "videoTrimContractLauncher", "viewModel", "Leditor/optionsui/addcontent/contentpicker/ContentPickerViewModel;", "getViewModel", "()Leditor/optionsui/addcontent/contentpicker/ContentPickerViewModel;", "viewModel$delegate", "exit", "", "exitWithError", "error", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "pickContent", "pickGif", "pickPhoto", "pickVideo", "resolveContent", "unresolvedMediaContent", "Lcom/memes/commons/media/MediaContent;", "showVideoTrimTool", "content", "showWrongContentPicked", "pickedContent", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ContentPickerActivity.kt */
public final class ContentPickerActivity extends NicoActivity {
    private final Lazy binding$delegate = LazyKt.lazy(new ContentPickerActivity$binding$2(this));
    private final ContractLauncher<String, Uri> getContentResultContractLauncher = new ContractLauncher<>(new GetContentResultContract());
    private final Lazy mimeMediaImporter$delegate = LazyKt.lazy(new ContentPickerActivity$mimeMediaImporter$2(this));
    private final Lazy outputTargetGenerator$delegate = LazyKt.lazy(ContentPickerActivity$outputTargetGenerator$2.INSTANCE);
    /* access modifiers changed from: private */
    public ContentPickerTarget pickerTarget;
    private final ContractLauncher<String, String> videoTrimContractLauncher = new ContractLauncher<>(new VideoTrimActivityContract());
    private final Lazy viewModel$delegate = LazyKt.lazy(new ContentPickerActivity$viewModel$2(this));

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ContentPickerTarget.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ContentPickerTarget.PHOTO.ordinal()] = 1;
            iArr[ContentPickerTarget.GIF.ordinal()] = 2;
            iArr[ContentPickerTarget.VIDEO.ordinal()] = 3;
            int[] iArr2 = new int[ContentPickerTarget.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ContentPickerTarget.PHOTO.ordinal()] = 1;
            iArr2[ContentPickerTarget.VIDEO.ordinal()] = 2;
        }
    }

    private final NContentPickerActivityBinding getBinding() {
        return (NContentPickerActivityBinding) this.binding$delegate.getValue();
    }

    private final MimeMediaPicker getMimeMediaImporter() {
        return (MimeMediaPicker) this.mimeMediaImporter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final OutputTargetGenerator getOutputTargetGenerator() {
        return (OutputTargetGenerator) this.outputTargetGenerator$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ContentPickerViewModel getViewModel() {
        return (ContentPickerViewModel) this.viewModel$delegate.getValue();
    }

    public static final /* synthetic */ ContentPickerTarget access$getPickerTarget$p(ContentPickerActivity contentPickerActivity) {
        ContentPickerTarget contentPickerTarget = contentPickerActivity.pickerTarget;
        if (contentPickerTarget == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickerTarget");
        }
        return contentPickerTarget;
    }

    /* JADX WARNING: type inference failed for: r3v15, types: [android.os.Parcelable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r3) {
        /*
            r2 = this;
            super.onCreate(r3)
            com.memes.editor.databinding.NContentPickerActivityBinding r3 = r2.getBinding()
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            android.widget.LinearLayout r3 = r3.getRoot()
            android.view.View r3 = (android.view.View) r3
            r2.setContentView((android.view.View) r3)
            r3 = 1
            editor.core.NicoViewModel[] r3 = new editor.core.NicoViewModel[r3]
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r0 = r2.getViewModel()
            editor.core.NicoViewModel r0 = (editor.core.NicoViewModel) r0
            r1 = 0
            r3[r1] = r0
            r2.registerViewModel(r3)
            com.memes.commons.activity.ContractLauncher<java.lang.String, java.lang.String> r3 = r2.videoTrimContractLauncher
            r0 = r2
            androidx.appcompat.app.AppCompatActivity r0 = (androidx.appcompat.app.AppCompatActivity) r0
            r3.register(r0)
            com.memes.commons.activity.ContractLauncher<java.lang.String, android.net.Uri> r3 = r2.getContentResultContractLauncher
            r3.register(r0)
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r3 = r2.getViewModel()
            androidx.lifecycle.LiveData r3 = r3.onContentDownloaded()
            r0 = r2
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            editor.optionsui.addcontent.contentpicker.ContentPickerActivity$onCreate$1 r1 = new editor.optionsui.addcontent.contentpicker.ContentPickerActivity$onCreate$1
            r1.<init>(r2)
            androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
            r3.observe(r0, r1)
            android.content.Intent r3 = r2.getIntent()
            r0 = 0
            if (r3 == 0) goto L_0x0054
            java.lang.String r1 = "intent_extra_picker_target"
            java.io.Serializable r3 = r3.getSerializableExtra(r1)
            goto L_0x0055
        L_0x0054:
            r3 = r0
        L_0x0055:
            boolean r1 = r3 instanceof editor.optionsui.addcontent.contentpicker.ContentPickerTarget
            if (r1 != 0) goto L_0x005a
            r3 = r0
        L_0x005a:
            editor.optionsui.addcontent.contentpicker.ContentPickerTarget r3 = (editor.optionsui.addcontent.contentpicker.ContentPickerTarget) r3
            if (r3 == 0) goto L_0x0064
            r2.pickerTarget = r3
            r2.pickContent()
            return
        L_0x0064:
            android.content.Intent r3 = r2.getIntent()
            if (r3 == 0) goto L_0x0073
            java.lang.String r0 = "intent_extra_target_content"
            android.os.Parcelable r3 = r3.getParcelableExtra(r0)
            r0 = r3
            com.memes.commons.media.MediaContent r0 = (com.memes.commons.media.MediaContent) r0
        L_0x0073:
            if (r0 == 0) goto L_0x0079
            r2.resolveContent(r0)
            return
        L_0x0079:
            r2.exit()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.optionsui.addcontent.contentpicker.ContentPickerActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public final void pickContent() {
        ContentPickerTarget contentPickerTarget = this.pickerTarget;
        if (contentPickerTarget == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickerTarget");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[contentPickerTarget.ordinal()];
        if (i == 1) {
            pickPhoto();
        } else if (i == 2) {
            pickGif();
        } else if (i == 3) {
            pickVideo();
        }
    }

    private final void pickPhoto() {
        getMimeMediaImporter().pickPhoto(this, this.getContentResultContractLauncher, new ContentPickerActivity$pickPhoto$1(this));
    }

    private final void pickGif() {
        getMimeMediaImporter().pickGif(this, this.getContentResultContractLauncher, new ContentPickerActivity$pickGif$1(this));
    }

    private final void pickVideo() {
        getMimeMediaImporter().pickVideo(this, this.getContentResultContractLauncher, new ContentPickerActivity$pickVideo$1(this));
    }

    private final void resolveContent(MediaContent mediaContent) {
        ContentPickerTarget contentPickerTarget;
        int contentType = mediaContent.contentType();
        if (contentType == 1231) {
            contentPickerTarget = ContentPickerTarget.PHOTO;
        } else if (contentType != 1232) {
            exit();
            return;
        } else {
            contentPickerTarget = ContentPickerTarget.VIDEO;
        }
        MimeMediaPicker mimeMediaImporter = getMimeMediaImporter();
        int contentType2 = mediaContent.contentType();
        Uri parse = Uri.parse(mediaContent.getContentUrl());
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(unresolvedMediaContent.contentUrl)");
        mimeMediaImporter.resolveContent(contentType2, parse, new ContentPickerActivity$resolveContent$1(this, contentPickerTarget));
    }

    /* access modifiers changed from: private */
    public final void showVideoTrimTool(MediaContent mediaContent) {
        this.videoTrimContractLauncher.launch(mediaContent.getContentUrl(), new ContentPickerActivity$showVideoTrimTool$1(this, mediaContent));
    }

    /* access modifiers changed from: private */
    public final void showWrongContentPicked(MediaContent mediaContent) {
        ContentPickerTarget contentPickerTarget = this.pickerTarget;
        if (contentPickerTarget == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickerTarget");
        }
        String string = contentPickerTarget.string();
        String[] allowedExtensions = contentPickerTarget.allowedExtensions();
        StringBuilder sb = new StringBuilder();
        sb.append("When you choose to add '");
        sb.append(string);
        sb.append("' content, ");
        sb.append("only files of that type are allowed to be picked. ");
        sb.append("If these files do not end with following extension(s), they can't be picked as '");
        sb.append(string);
        sb.append("' type.");
        sb.append("\n\nAllowed Extension(s): ");
        String arrays = Arrays.toString(allowedExtensions);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        sb.append("\n\nSelected file path: ");
        sb.append(mediaContent.getContentUrl());
        new AlertDialog.Builder(this).setTitle((CharSequence) "Wrong Content Selected").setMessage((CharSequence) sb.toString()).setCancelable(false).setPositiveButton((CharSequence) "Try Again", (DialogInterface.OnClickListener) new ContentPickerActivity$showWrongContentPicked$1(this)).setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) new ContentPickerActivity$showWrongContentPicked$2(this)).show();
    }

    /* access modifiers changed from: private */
    public final void exit() {
        setResult(0, (Intent) null);
        finish();
    }

    static /* synthetic */ void exitWithError$default(ContentPickerActivity contentPickerActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        contentPickerActivity.exitWithError(str);
    }

    /* access modifiers changed from: private */
    public final void exitWithError(String str) {
        Intent intent = new Intent();
        intent.putExtra(ContentPickerActivityContract.EXTRA_PICKER_ERROR, str);
        setResult(0, intent);
        finish();
    }
}

package com.memes.commons.imageselection;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.TypedValue;
import android.widget.ArrayAdapter;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.FileProvider;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.C4144R;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaFile;
import com.memes.commons.media.MediaType;
import com.memes.commons.output.OutputExtension;
import com.memes.commons.util.ActivityResultExtKt;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.Intents;
import com.memes.commons.util.UriResolverHelper;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\b\u0016\u0018\u0000 A2\u00020\u0001:\u0002@AB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\u0000J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u001c\u0010\u0012\u001a\u00020\u00002\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010'\u001a\u00020\u0000J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010-\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010.\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u0005H\u0016J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020\u0019H\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u00109\u001a\u00020\u0016J\u0016\u0010:\u001a\u00020)2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00190<H\u0014J\u0006\u0010=\u001a\u00020)J\b\u0010>\u001a\u00020)H\u0002J\b\u0010?\u001a\u00020)H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006B"}, mo26107d2 = {"Lcom/memes/commons/imageselection/ImageSelector;", "Lcom/memes/commons/util/UriResolverHelper$Callback;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "providerAuthority", "", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;)V", "callback", "Lcom/memes/commons/imageselection/ImageSelector$Callback;", "context", "Landroid/content/Context;", "cropAspects", "Lkotlin/Pair;", "", "cropPhotoContractLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "enableCrop", "", "pickPhotoContractLauncher", "requestIdentifier", "", "selectionSources", "", "Lcom/memes/commons/imageselection/ImageSource;", "selectionSourcesLayoutRes", "takePhotoContractLauncher", "takenPhotoPath", "uriResolverHelper", "Lcom/memes/commons/util/UriResolverHelper;", "getUriResolverHelper", "()Lcom/memes/commons/util/UriResolverHelper;", "uriResolverHelper$delegate", "Lkotlin/Lazy;", "cameraOnly", "createImageFile", "Ljava/io/File;", "storageDirectory", "galleryOnly", "handleCropPhotoActivityResult", "", "result", "Landroidx/activity/result/ActivityResult;", "handlePickPhotoActivityResult", "handleTakePhotoActivityResult", "importUri", "notifyPhotoAvailability", "imageContent", "Lcom/memes/commons/imageselection/ImageContent;", "onUriResolveError", "error", "onUriResolved", "content", "Lcom/memes/commons/media/MediaContent;", "openImageSelector", "source", "layoutRes", "showImageSourceSelector", "sources", "", "start", "triggerPickPhoto", "triggerTakePhoto", "Callback", "Companion", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ImageSelector.kt */
public class ImageSelector implements UriResolverHelper.Callback {
    /* access modifiers changed from: private */
    public static final Pair<Float, Float> CROP_ANY;
    /* access modifiers changed from: private */
    public static final Pair<Float, Float> CROP_SQUARE;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Callback callback;
    /* access modifiers changed from: private */
    public final Context context;
    private Pair<Float, Float> cropAspects = CROP_SQUARE;
    private final ActivityResultLauncher<Intent> cropPhotoContractLauncher;
    private boolean enableCrop;
    private final ActivityResultLauncher<Intent> pickPhotoContractLauncher;
    private final String providerAuthority;
    private int requestIdentifier;
    private final List<ImageSource> selectionSources = ArraysKt.toMutableList((T[]) ImageSource.values());
    private int selectionSourcesLayoutRes = 17367043;
    private final ActivityResultLauncher<Intent> takePhotoContractLauncher;
    private String takenPhotoPath;
    private final Lazy uriResolverHelper$delegate = LazyKt.lazy(new ImageSelector$uriResolverHelper$2(this));

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo26107d2 = {"Lcom/memes/commons/imageselection/ImageSelector$Callback;", "", "onImageFileSelected", "", "requestIdentifier", "", "imageContent", "Lcom/memes/commons/imageselection/ImageContent;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ImageSelector.kt */
    public interface Callback {
        void onImageFileSelected(int i, ImageContent imageContent);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageSource.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ImageSource.CAMERA.ordinal()] = 1;
            iArr[ImageSource.GALLERY.ordinal()] = 2;
        }
    }

    private final UriResolverHelper getUriResolverHelper() {
        return (UriResolverHelper) this.uriResolverHelper$delegate.getValue();
    }

    public ImageSelector(AppCompatActivity appCompatActivity, String str) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "providerAuthority");
        this.providerAuthority = str;
        this.context = appCompatActivity;
        ActivityResultLauncher<Intent> registerForActivityResult = appCompatActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ImageSelector$takePhotoContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "activity.registerForActi…oActivityResult(result) }");
        this.takePhotoContractLauncher = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = appCompatActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ImageSelector$pickPhotoContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "activity.registerForActi…oActivityResult(result) }");
        this.pickPhotoContractLauncher = registerForActivityResult2;
        ActivityResultLauncher<Intent> registerForActivityResult3 = appCompatActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ImageSelector$cropPhotoContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "activity.registerForActi…oActivityResult(result) }");
        this.cropPhotoContractLauncher = registerForActivityResult3;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, mo26107d2 = {"Lcom/memes/commons/imageselection/ImageSelector$Companion;", "", "()V", "CROP_ANY", "Lkotlin/Pair;", "", "getCROP_ANY", "()Lkotlin/Pair;", "CROP_SQUARE", "getCROP_SQUARE", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ImageSelector.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pair<Float, Float> getCROP_ANY() {
            return ImageSelector.CROP_ANY;
        }

        public final Pair<Float, Float> getCROP_SQUARE() {
            return ImageSelector.CROP_SQUARE;
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        CROP_ANY = new Pair<>(valueOf, valueOf);
        Float valueOf2 = Float.valueOf(1.0f);
        CROP_SQUARE = new Pair<>(valueOf2, valueOf2);
    }

    public final ImageSelector cameraOnly() {
        this.selectionSources.clear();
        this.selectionSources.add(ImageSource.CAMERA);
        return this;
    }

    public final ImageSelector galleryOnly() {
        this.selectionSources.clear();
        this.selectionSources.add(ImageSource.GALLERY);
        return this;
    }

    public final ImageSelector requestIdentifier(int i) {
        this.requestIdentifier = i;
        return this;
    }

    public final ImageSelector selectionSourcesLayoutRes(int i) {
        this.selectionSourcesLayoutRes = i;
        return this;
    }

    public static /* synthetic */ ImageSelector enableCrop$default(ImageSelector imageSelector, Pair<Float, Float> pair, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                pair = CROP_ANY;
            }
            return imageSelector.enableCrop(pair);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enableCrop");
    }

    public final ImageSelector enableCrop(Pair<Float, Float> pair) {
        Intrinsics.checkNotNullParameter(pair, "cropAspects");
        this.enableCrop = true;
        this.cropAspects = pair;
        return this;
    }

    public final ImageSelector callback(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
        return this;
    }

    public final void start() {
        int size = this.selectionSources.size();
        if (size == 0) {
            throw new RuntimeException("No image source is found.");
        } else if (size != 1) {
            showImageSourceSelector(this.selectionSources);
        } else {
            openImageSelector((ImageSource) CollectionsKt.first(this.selectionSources));
        }
    }

    /* access modifiers changed from: protected */
    public void showImageSourceSelector(List<? extends ImageSource> list) {
        Intrinsics.checkNotNullParameter(list, "sources");
        Context context2 = this.context;
        int i = this.selectionSourcesLayoutRes;
        Iterable<ImageSource> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ImageSource displayName : iterable) {
            arrayList.add(displayName.getDisplayName());
        }
        new AlertDialog.Builder(this.context).setAdapter(new ArrayAdapter(context2, i, (List) arrayList), new ImageSelector$showImageSourceSelector$1(this, list)).show();
    }

    /* access modifiers changed from: protected */
    public final void openImageSelector(ImageSource imageSource) {
        Intrinsics.checkNotNullParameter(imageSource, "source");
        int i = WhenMappings.$EnumSwitchMapping$0[imageSource.ordinal()];
        if (i == 1) {
            PermissionsManagerKt.runWithPermissions$default(this.context, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new ImageSelector$openImageSelector$1(this), 2, (Object) null);
        } else if (i == 2) {
            PermissionsManagerKt.runWithPermissions$default(this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new ImageSelector$openImageSelector$2(this), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void triggerTakePhoto() {
        File file = null;
        Intent takePhotoIntent$default = Intents.getTakePhotoIntent$default(Intents.INSTANCE, this.context, (Uri) null, 2, (Object) null);
        if (takePhotoIntent$default == null) {
            ExtensionsKt.toast(this.context, C4144R.string.error_missing_camera);
            return;
        }
        try {
            file = createImageFile(this.context.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        } catch (IOException unused) {
        }
        if (file == null || !file.exists()) {
            ExtensionsKt.toast(this.context, C4144R.string.error_storage_access);
            return;
        }
        this.takenPhotoPath = file.getAbsolutePath();
        Uri uriForFile = FileProvider.getUriForFile(this.context, this.providerAuthority, file);
        Intrinsics.checkNotNullExpressionValue(uriForFile, "FileProvider.getUriForFi…thority,\n\t\t\tphotoFile\n\t\t)");
        takePhotoIntent$default.putExtra("output", uriForFile);
        this.takePhotoContractLauncher.launch(takePhotoIntent$default);
    }

    /* access modifiers changed from: private */
    public final void triggerPickPhoto() {
        Intent photoPickerIntent = Intents.INSTANCE.getPhotoPickerIntent(this.context);
        if (photoPickerIntent == null) {
            ExtensionsKt.toast(this.context, C4144R.string.error_missing_eligible_gallery);
        } else {
            this.pickPhotoContractLauncher.launch(photoPickerIntent);
        }
    }

    private final void notifyPhotoAvailability(ImageContent imageContent) {
        if (this.enableCrop) {
            Context contextThemeWrapper = new ContextThemeWrapper(this.context, C4144R.C4152style.UCropTheme);
            int colorFromAttr$default = ExtensionsKt.getColorFromAttr$default(contextThemeWrapper, C4144R.attr.colorPrimary, (TypedValue) null, false, 6, (Object) null);
            int colorFromAttr$default2 = ExtensionsKt.getColorFromAttr$default(contextThemeWrapper, C4144R.attr.colorPrimaryDark, (TypedValue) null, false, 6, (Object) null);
            int colorFromAttr$default3 = ExtensionsKt.getColorFromAttr$default(contextThemeWrapper, C4144R.attr.colorOnPrimary, (TypedValue) null, false, 6, (Object) null);
            UCrop.Options options = new UCrop.Options();
            options.setStatusBarColor(colorFromAttr$default2);
            options.setToolbarColor(colorFromAttr$default);
            options.setToolbarWidgetColor(colorFromAttr$default3);
            UCrop withOptions = UCrop.m1004of(Uri.fromFile(imageContent.getFile()), Uri.fromFile(createImageFile(this.context.getCacheDir()))).withOptions(options);
            if (!Intrinsics.areEqual((Object) this.cropAspects, (Object) CROP_ANY)) {
                withOptions = withOptions.withAspectRatio(this.cropAspects.getFirst().floatValue(), this.cropAspects.getSecond().floatValue());
            }
            this.cropPhotoContractLauncher.launch(withOptions.getIntent(this.context));
            return;
        }
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onImageFileSelected(this.requestIdentifier, imageContent);
        }
    }

    /* access modifiers changed from: private */
    public final void handleTakePhotoActivityResult(ActivityResult activityResult) {
        if (!ActivityResultExtKt.isOk(activityResult)) {
            ExtensionsKt.toast(this.context, C4144R.string.error_image_not_selected);
            return;
        }
        String str = this.takenPhotoPath;
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            ExtensionsKt.toast(this.context, C4144R.string.error_cant_access_taken_picture);
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            ExtensionsKt.toast(this.context, C4144R.string.error_cant_access_taken_picture);
        } else {
            notifyPhotoAvailability(new ImageContent(ImageSource.CAMERA, MediaFile.Companion.from(getUriResolverHelper().createMediaContent(file, MediaType.PHOTO))));
        }
    }

    /* access modifiers changed from: private */
    public final void handlePickPhotoActivityResult(ActivityResult activityResult) {
        if (!ActivityResultExtKt.isOk(activityResult)) {
            ExtensionsKt.toast(this.context, C4144R.string.error_image_not_selected);
            return;
        }
        Intent dataIfOkResult = ActivityResultExtKt.getDataIfOkResult(activityResult);
        if (dataIfOkResult == null) {
            ExtensionsKt.toast(this.context, C4144R.string.error_cant_access_selected_picture);
        } else {
            importUri(String.valueOf(dataIfOkResult.getData()));
        }
    }

    /* access modifiers changed from: private */
    public final void handleCropPhotoActivityResult(ActivityResult activityResult) {
        String str;
        Intent data = activityResult.getData();
        if (data == null) {
            ExtensionsKt.toast(this.context, C4144R.string.error_cant_access_selected_picture);
        } else if (activityResult.getResultCode() == 96) {
            Throwable error = UCrop.getError(data);
            Context context2 = this.context;
            if (error == null || (str = error.getMessage()) == null) {
                str = this.context.getString(C4144R.string.error_image_not_selected);
                Intrinsics.checkNotNullExpressionValue(str, "context.getString(R.stri…error_image_not_selected)");
            }
            ExtensionsKt.toast(context2, str);
        } else if (!ActivityResultExtKt.isOk(activityResult)) {
            ExtensionsKt.toast(this.context, C4144R.string.error_image_not_selected);
        } else {
            String valueOf = String.valueOf(UCrop.getOutput(data));
            this.enableCrop = false;
            importUri(valueOf);
        }
    }

    private final void importUri(String str) {
        MediaContent mediaContent = new MediaContent(MediaType.PHOTO, str, (Integer) null, (Integer) null, 12, (DefaultConstructorMarker) null);
        Uri parse = Uri.parse(str);
        UriResolverHelper uriResolverHelper = getUriResolverHelper();
        Intrinsics.checkNotNullExpressionValue(parse, "contentUri");
        uriResolverHelper.m2572import(parse, mediaContent.contentType(), (UriResolverHelper.Callback) this);
    }

    private final File createImageFile(File file) throws IOException {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"yyyyMM…Locale.US).format(Date())");
        File createTempFile = File.createTempFile("JPEG_" + format + '_', OutputExtension.JPG, file);
        Intrinsics.checkNotNullExpressionValue(createTempFile, "File.createTempFile(\n\t\t\t…y */ storageDirectory\n\t\t)");
        return createTempFile;
    }

    public void onUriResolveError(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        ExtensionsKt.toast(this.context, C4144R.string.error_cant_access_selected_picture);
    }

    public void onUriResolved(MediaContent mediaContent) {
        Intrinsics.checkNotNullParameter(mediaContent, "content");
        if (mediaContent.asFile().exists()) {
            notifyPhotoAvailability(new ImageContent(ImageSource.GALLERY, MediaFile.Companion.from(mediaContent)));
        } else {
            ExtensionsKt.toast(this.context, C4144R.string.error_cant_access_selected_picture);
        }
    }
}

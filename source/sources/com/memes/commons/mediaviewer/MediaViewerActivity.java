package com.memes.commons.mediaviewer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.activity.BaseActivity;
import com.memes.commons.databinding.MediaContentViewerActivityBinding;
import com.memes.commons.mediaviewer.types.MediaViewerItemTypesAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/commons/mediaviewer/MediaViewerActivity;", "Lcom/memes/commons/activity/BaseActivity;", "()V", "binding", "Lcom/memes/commons/databinding/MediaContentViewerActivityBinding;", "getBinding", "()Lcom/memes/commons/databinding/MediaContentViewerActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "mediaViewerViewModel", "Lcom/memes/commons/mediaviewer/MediaViewerViewModel;", "getMediaViewerViewModel", "()Lcom/memes/commons/mediaviewer/MediaViewerViewModel;", "mediaViewerViewModel$delegate", "exploreIntent", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaViewerActivity.kt */
public final class MediaViewerActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String INTENT_EXTRA_PHOTO_PATH = "intent_extra_photo_path";
    private final Lazy binding$delegate = LazyKt.lazy(new MediaViewerActivity$binding$2(this));
    private final Lazy mediaViewerViewModel$delegate = LazyKt.lazy(new MediaViewerActivity$mediaViewerViewModel$2(this));

    private final MediaContentViewerActivityBinding getBinding() {
        return (MediaContentViewerActivityBinding) this.binding$delegate.getValue();
    }

    private final MediaViewerViewModel getMediaViewerViewModel() {
        return (MediaViewerViewModel) this.mediaViewerViewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/commons/mediaviewer/MediaViewerActivity$Companion;", "", "()V", "INTENT_EXTRA_PHOTO_PATH", "", "showPhoto", "", "context", "Landroid/content/Context;", "photoPath", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaViewerActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void showPhoto(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "photoPath");
            Intent intent = new Intent(context, MediaViewerActivity.class);
            intent.putExtra(MediaViewerActivity.INTENT_EXTRA_PHOTO_PATH, str);
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MediaContentViewerActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModels(getMediaViewerViewModel());
        MediaViewerItemTypesAdapter mediaViewerItemTypesAdapter = new MediaViewerItemTypesAdapter(this);
        ViewPager2 viewPager2 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setAdapter(mediaViewerItemTypesAdapter);
        getBinding().exitImageView.setOnClickListener(new MediaViewerActivity$onCreate$1(this));
        getMediaViewerViewModel().items().observe(this, new MediaViewerActivity$onCreate$2(mediaViewerItemTypesAdapter));
        QuickPermissionsOptions quickPermissionsOptions = new QuickPermissionsOptions(false, (String) null, false, (String) null, (Function1) null, (Function1) null, (Function1) null, 127, (DefaultConstructorMarker) null);
        quickPermissionsOptions.setPermissionsDeniedMethod(new MediaViewerActivity$onCreate$$inlined$apply$lambda$1(this));
        quickPermissionsOptions.setPermanentDeniedMethod(quickPermissionsOptions.getPermissionsDeniedMethod());
        Unit unit = Unit.INSTANCE;
        PermissionsManagerKt.runWithPermissions((Context) this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, quickPermissionsOptions, (Function0<Unit>) new MediaViewerActivity$onCreate$4(this));
    }

    /* access modifiers changed from: private */
    public final void exploreIntent() {
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(INTENT_EXTRA_PHOTO_PATH) : null;
        CharSequence charSequence = stringExtra;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            getMediaViewerViewModel().setPhotoPath(stringExtra);
        }
    }
}

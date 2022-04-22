package com.memes.plus.p040ui.create_post.tagpeople;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.media.MediaFile;
import com.memes.commons.recycleradapter.AdapterItemCountChangeListener;
import com.memes.commons.util.ExtensionsKt;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.custom.player.ExoPlayerHelper;
import com.memes.plus.custom.player.PlayerEventListenerAdapter;
import com.memes.plus.databinding.TagPeopleActivityBinding;
import com.memes.plus.p040ui.create_post.catalogueselection.ExportCatalogueSelectionActivity;
import com.memes.plus.p040ui.create_post.catalogueselection.ExportCatalogueType;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0002*+B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0018H\u0014J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0018H\u0014J\b\u0010$\u001a\u00020\u0018H\u0014J\b\u0010%\u001a\u00020\u0018H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\u0011R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015¨\u0006,"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/tagpeople/TagPeopleActivity;", "Lcom/memes/plus/base/BaseActivity;", "Lcom/memes/commons/recycleradapter/AdapterItemCountChangeListener;", "()V", "binding", "Lcom/memes/plus/databinding/TagPeopleActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/TagPeopleActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "exoPlayerHelper", "Lcom/memes/plus/custom/player/ExoPlayerHelper;", "exportCatalogueSelectionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "playerStateCallback", "Lcom/memes/plus/ui/create_post/tagpeople/TagPeopleActivity$PlayerStateCallback;", "taggedPeopleAdapter", "Lcom/memes/plus/ui/create_post/tagpeople/TaggedPeopleAdapter;", "getTaggedPeopleAdapter", "()Lcom/memes/plus/ui/create_post/tagpeople/TaggedPeopleAdapter;", "taggedPeopleAdapter$delegate", "addTaggedPerson", "", "person", "Lcom/memes/plus/ui/create_post/tagpeople/TaggedPerson;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemCountChanged", "newCount", "", "onPause", "onResume", "showPeopleSearchPage", "showPhoto", "path", "", "showVideo", "Companion", "PlayerStateCallback", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.tagpeople.TagPeopleActivity */
/* compiled from: TagPeopleActivity.kt */
public final class TagPeopleActivity extends BaseActivity implements AdapterItemCountChangeListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_MEDIA_PATH = "intent_extra_media_path";
    private static final String EXTRA_MEDIA_THUMBNAIL_PATH = "intent_extra_media_thumbnail_path";
    private static final String EXTRA_MEDIA_TYPE = "intent_extra_media_type";
    public static final String EXTRA_TAGGED_PEOPLE = "intent_extra_tagged_people";
    public static final String EXTRA_TAGGED_PEOPLE_COUNT = "intent_extra_tagged_people_count";
    public static final String EXTRA_TAGGED_PEOPLE_NAME = "intent_extra_people_name";
    public static final String FULL_NAME = "fullName";
    public static final String IMAGE_URL = "imageUrl";
    public static final String IS_PRO_USER = "isProUser";
    /* access modifiers changed from: private */
    public static final int RC_PERSON_SELECTION = 456;
    public static final String USER_ID = "userId";
    public static final String USER_NAME = "userName";
    private final Lazy binding$delegate = LazyKt.lazy(new TagPeopleActivity$binding$2(this));
    /* access modifiers changed from: private */
    public final ExoPlayerHelper exoPlayerHelper = new ExoPlayerHelper(this);
    private final ActivityResultLauncher<Intent> exportCatalogueSelectionLauncher;
    private final PlayerStateCallback playerStateCallback = new PlayerStateCallback();
    private final Lazy taggedPeopleAdapter$delegate = LazyKt.lazy(new TagPeopleActivity$taggedPeopleAdapter$2(this));

    /* access modifiers changed from: private */
    public final TagPeopleActivityBinding getBinding() {
        return (TagPeopleActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TaggedPeopleAdapter getTaggedPeopleAdapter() {
        return (TaggedPeopleAdapter) this.taggedPeopleAdapter$delegate.getValue();
    }

    public TagPeopleActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new TagPeopleActivity$exportCatalogueSelectionLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…\taddTaggedPerson(item)\n\t}");
        this.exportCatalogueSelectionLauncher = registerForActivityResult;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004J7\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/tagpeople/TagPeopleActivity$Companion;", "", "()V", "EXTRA_MEDIA_PATH", "", "EXTRA_MEDIA_THUMBNAIL_PATH", "EXTRA_MEDIA_TYPE", "EXTRA_TAGGED_PEOPLE", "EXTRA_TAGGED_PEOPLE_COUNT", "EXTRA_TAGGED_PEOPLE_NAME", "FULL_NAME", "IMAGE_URL", "IS_PRO_USER", "RC_PERSON_SELECTION", "", "getRC_PERSON_SELECTION", "()I", "USER_ID", "USER_NAME", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "mediaFile", "Lcom/memes/commons/media/MediaFile;", "taggedPeopleJson", "mediaUrl", "mediaType", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Landroid/content/Intent;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.tagpeople.TagPeopleActivity$Companion */
    /* compiled from: TagPeopleActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getRC_PERSON_SELECTION() {
            return TagPeopleActivity.RC_PERSON_SELECTION;
        }

        public static /* synthetic */ Intent getStartIntent$default(Companion companion, Context context, MediaFile mediaFile, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                str = null;
            }
            return companion.getStartIntent(context, mediaFile, str);
        }

        public final Intent getStartIntent(Context context, MediaFile mediaFile, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mediaFile, "mediaFile");
            Intent intent = new Intent(context, TagPeopleActivity.class);
            intent.putExtra(TagPeopleActivity.EXTRA_MEDIA_TYPE, mediaFile.getType());
            intent.putExtra(TagPeopleActivity.EXTRA_MEDIA_PATH, mediaFile.getAbsolutePath());
            intent.putExtra(TagPeopleActivity.EXTRA_MEDIA_THUMBNAIL_PATH, mediaFile.getThumbnail());
            intent.putExtra(TagPeopleActivity.EXTRA_TAGGED_PEOPLE, str);
            return intent;
        }

        public static /* synthetic */ Intent getStartIntent$default(Companion companion, Context context, String str, Integer num, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            return companion.getStartIntent(context, str, num, str2);
        }

        public final Intent getStartIntent(Context context, String str, Integer num, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, TagPeopleActivity.class);
            intent.putExtra(TagPeopleActivity.EXTRA_MEDIA_TYPE, num);
            intent.putExtra(TagPeopleActivity.EXTRA_MEDIA_PATH, str);
            intent.putExtra(TagPeopleActivity.EXTRA_MEDIA_THUMBNAIL_PATH, str);
            intent.putExtra(TagPeopleActivity.EXTRA_TAGGED_PEOPLE, str2);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TagPeopleActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        getBinding().backImageView.setOnClickListener(new TagPeopleActivity$onCreate$1(this));
        getBinding().doneTextView.setOnClickListener(new TagPeopleActivity$onCreate$2(this));
        getBinding().previewImageView.setOnClickListener(new TagPeopleActivity$onCreate$3(this));
        getBinding().previewPlayerView.setOnClickListener(new TagPeopleActivity$onCreate$4(this));
        getBinding().contentLayout.setOnClickListener(new TagPeopleActivity$onCreate$5(this));
        getBinding().tagPeopleLayout.setOnClickListener(new TagPeopleActivity$onCreate$6(this));
        getBinding().tagMorePeopleLayout.setOnClickListener(new TagPeopleActivity$onCreate$7(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = getBinding().taggedPeopleRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.taggedPeopleRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        getTaggedPeopleAdapter().setAdapterItemCountChangeListener(this);
        RecyclerView recyclerView2 = getBinding().taggedPeopleRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.taggedPeopleRecyclerView");
        recyclerView2.setAdapter(getTaggedPeopleAdapter());
        Intent intent = getIntent();
        String str = null;
        Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra(EXTRA_MEDIA_TYPE, -1)) : null;
        Intent intent2 = getIntent();
        String stringExtra = intent2 != null ? intent2.getStringExtra(EXTRA_MEDIA_PATH) : null;
        Intent intent3 = getIntent();
        if (intent3 != null) {
            intent3.getStringExtra(EXTRA_MEDIA_THUMBNAIL_PATH);
        }
        Intent intent4 = getIntent();
        if (intent4 != null) {
            str = intent4.getStringExtra(EXTRA_TAGGED_PEOPLE);
        }
        if (stringExtra != null) {
            PermissionsManagerKt.runWithPermissions$default((Context) this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new TagPeopleActivity$onCreate$8(this, valueOf, stringExtra), 2, (Object) null);
            CharSequence charSequence = str;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                Gson gson = new Gson();
                TypeToken<?> parameterized = TypeToken.getParameterized(List.class, TaggedPerson.class);
                Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…TaggedPerson::class.java)");
                for (TaggedPerson addTaggedPerson : (List) gson.fromJson(str, parameterized.getType())) {
                    addTaggedPerson(addTaggedPerson);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.exoPlayerHelper.pause();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.exoPlayerHelper.resume();
    }

    public void onBackPressed() {
        ImageView imageView = getBinding().previewImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.previewImageView");
        imageView.setVisibility(0);
        supportFinishAfterTransition();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.exoPlayerHelper.release();
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public final void addTaggedPerson(TaggedPerson taggedPerson) {
        for (TaggedPerson taggedPerson2 : getTaggedPeopleAdapter().getItems()) {
            if (Intrinsics.areEqual((Object) taggedPerson2.getUser_id(), (Object) taggedPerson.getUser_id())) {
                ExtensionsKt.toast((Context) this, "User " + taggedPerson2.getUserName() + " is already tagged.");
                return;
            }
        }
        getTaggedPeopleAdapter().addItem(taggedPerson);
    }

    /* access modifiers changed from: private */
    public final void showPeopleSearchPage() {
        this.exportCatalogueSelectionLauncher.launch(ExportCatalogueSelectionActivity.Companion.getStartIntent(this, ExportCatalogueType.PEOPLE));
    }

    /* access modifiers changed from: private */
    public final void showPhoto(String str) {
        Glide.with((FragmentActivity) this).load(str).into(getBinding().previewImageView);
        ImageView imageView = getBinding().previewImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.previewImageView");
        imageView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showVideo(String str) {
        this.exoPlayerHelper.release();
        ExoPlayerHelper exoPlayerHelper2 = this.exoPlayerHelper;
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        PlayerView playerView = getBinding().previewPlayerView;
        Intrinsics.checkNotNullExpressionValue(playerView, "binding.previewPlayerView");
        exoPlayerHelper2.start(parse, playerView, this.playerStateCallback);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/tagpeople/TagPeopleActivity$PlayerStateCallback;", "Lcom/memes/plus/custom/player/PlayerEventListenerAdapter;", "(Lcom/memes/plus/ui/create_post/tagpeople/TagPeopleActivity;)V", "onPlayerError", "", "playbackException", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "", "playbackState", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.tagpeople.TagPeopleActivity$PlayerStateCallback */
    /* compiled from: TagPeopleActivity.kt */
    private final class PlayerStateCallback extends PlayerEventListenerAdapter {
        public PlayerStateCallback() {
        }

        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Intrinsics.checkNotNullParameter(exoPlaybackException, "playbackException");
            TagPeopleActivity.this.getBinding().contentLayout.showContent();
            TagPeopleActivity.this.exoPlayerHelper.release();
        }

        public void onPlayerStateChanged(boolean z, int i) {
            if (i == 2) {
                ContentLayout.showProgress$default(TagPeopleActivity.this.getBinding().contentLayout, (String) null, 1, (Object) null);
            }
            if (i == 3 && z) {
                TagPeopleActivity.this.getBinding().contentLayout.showContent();
                ImageView imageView = TagPeopleActivity.this.getBinding().previewImageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.previewImageView");
                imageView.setVisibility(8);
            }
        }
    }

    public void onItemCountChanged(int i) {
        if (i <= 0) {
            RecyclerView recyclerView = getBinding().taggedPeopleRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.taggedPeopleRecyclerView");
            recyclerView.setVisibility(8);
            LinearLayout linearLayout = getBinding().tagMorePeopleLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.tagMorePeopleLayout");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = getBinding().tagPeopleLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.tagPeopleLayout");
            linearLayout2.setVisibility(0);
            return;
        }
        RecyclerView recyclerView2 = getBinding().taggedPeopleRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.taggedPeopleRecyclerView");
        recyclerView2.setVisibility(0);
        LinearLayout linearLayout3 = getBinding().tagMorePeopleLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.tagMorePeopleLayout");
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = getBinding().tagPeopleLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.tagPeopleLayout");
        linearLayout4.setVisibility(8);
    }
}

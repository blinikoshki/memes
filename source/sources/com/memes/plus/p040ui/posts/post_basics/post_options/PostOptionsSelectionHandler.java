package com.memes.plus.p040ui.posts.post_basics.post_options;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.util.ClipboardUtil;
import com.memes.commons.util.ExtensionsKt;
import com.memes.plus.C4199R;
import com.memes.plus.integrations.facebook.FacebookIntegrationViewModel;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.edit_post.EditPostActivity;
import com.memes.plus.p040ui.posts.edit_post.EditPostInput;
import com.memes.plus.p040ui.posts.post_basics.PostOperationsViewModel;
import com.memes.plus.p040ui.posts.post_basics.post_report.PostReportType;
import com.memes.plus.util.LocalIntents;
import com.memes.plus.util.StyledAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_options/PostOptionsSelectionHandler;", "", "context", "Landroid/content/Context;", "postOperationsViewModel", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "facebookIntegrationViewModel", "Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "(Landroid/content/Context;Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;)V", "handlePostOptionSelected", "", "postOption", "Lcom/memes/plus/ui/posts/post_basics/post_options/PostOption;", "post", "Lcom/memes/plus/ui/posts/Post;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.post_options.PostOptionsSelectionHandler */
/* compiled from: PostOptionsSelectionHandler.kt */
public final class PostOptionsSelectionHandler {
    private final Context context;
    private final FacebookIntegrationViewModel facebookIntegrationViewModel;
    /* access modifiers changed from: private */
    public final PostOperationsViewModel postOperationsViewModel;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_basics.post_options.PostOptionsSelectionHandler$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PostOption.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PostOption.SHARE_TO_FACEBOOK.ordinal()] = 1;
            iArr[PostOption.SHARE.ordinal()] = 2;
            iArr[PostOption.SHARE_PROFILE.ordinal()] = 3;
            iArr[PostOption.SAVE_TO_GALLERY.ordinal()] = 4;
            iArr[PostOption.REPOST.ordinal()] = 5;
            iArr[PostOption.COPY_LINK.ordinal()] = 6;
            iArr[PostOption.REPORT.ordinal()] = 7;
            iArr[PostOption.REPORT_SPAM.ordinal()] = 8;
            iArr[PostOption.REPORT_INAPPROPRIATE.ordinal()] = 9;
            iArr[PostOption.EDIT.ordinal()] = 10;
            iArr[PostOption.DELETE.ordinal()] = 11;
            iArr[PostOption.FOLLOW.ordinal()] = 12;
            iArr[PostOption.UNFOLLOW.ordinal()] = 13;
        }
    }

    public PostOptionsSelectionHandler(Context context2, PostOperationsViewModel postOperationsViewModel2, FacebookIntegrationViewModel facebookIntegrationViewModel2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(postOperationsViewModel2, "postOperationsViewModel");
        Intrinsics.checkNotNullParameter(facebookIntegrationViewModel2, "facebookIntegrationViewModel");
        this.context = context2;
        this.postOperationsViewModel = postOperationsViewModel2;
        this.facebookIntegrationViewModel = facebookIntegrationViewModel2;
    }

    public final void handlePostOptionSelected(PostOption postOption, Post post) {
        Intent shareProfileIntent;
        Intrinsics.checkNotNullParameter(postOption, "postOption");
        Intrinsics.checkNotNullParameter(post, "post");
        boolean z = true;
        switch (WhenMappings.$EnumSwitchMapping$0[postOption.ordinal()]) {
            case 1:
                this.facebookIntegrationViewModel.sharePost(post);
                return;
            case 2:
                PermissionsManagerKt.runWithPermissions$default(this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new PostOptionsSelectionHandler$handlePostOptionSelected$1(this, post), 2, (Object) null);
                return;
            case 3:
                String username = post.getUsername();
                CharSequence charSequence = username;
                if (charSequence != null && !StringsKt.isBlank(charSequence)) {
                    z = false;
                }
                if (!z && (shareProfileIntent = LocalIntents.INSTANCE.getShareProfileIntent(this.context, username)) != null) {
                    this.context.startActivity(shareProfileIntent);
                    return;
                }
                return;
            case 4:
                PermissionsManagerKt.runWithPermissions$default(this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new PostOptionsSelectionHandler$handlePostOptionSelected$2(this, post), 2, (Object) null);
                return;
            case 5:
                PermissionsManagerKt.runWithPermissions$default(this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new PostOptionsSelectionHandler$handlePostOptionSelected$3(this, post), 2, (Object) null);
                return;
            case 6:
                ClipboardUtil.INSTANCE.copy(this.context, post.getShareLink());
                ExtensionsKt.toast(this.context, (int) C4199R.string.link_copied);
                return;
            case 7:
                throw new RuntimeException("Report Reason must be selected.");
            case 8:
                this.postOperationsViewModel.reportPost(post, PostReportType.SPAM);
                return;
            case 9:
                this.postOperationsViewModel.reportPost(post, PostReportType.NUDITY);
                return;
            case 10:
                this.context.startActivity(EditPostActivity.Companion.getStartIntent(this.context, EditPostInput.Companion.from(post)));
                return;
            case 11:
                StyledAlertDialog.INSTANCE.builder(this.context).setTitle(C4199R.string.deletePost).setMessage(C4199R.string.deleteMessage).setCancelable(false).setPositiveButton(C4199R.string.yes, new PostOptionsSelectionHandler$handlePostOptionSelected$4(this, post)).setNegativeButton(C4199R.string.f999no, (DialogInterface.OnClickListener) null).show();
                return;
            case 12:
                String userId = post.getUserId();
                CharSequence charSequence2 = userId;
                if (charSequence2 != null && !StringsKt.isBlank(charSequence2)) {
                    z = false;
                }
                if (!z) {
                    this.postOperationsViewModel.followUser(userId);
                    return;
                }
                return;
            case 13:
                String userId2 = post.getUserId();
                CharSequence charSequence3 = userId2;
                if (charSequence3 != null && !StringsKt.isBlank(charSequence3)) {
                    z = false;
                }
                if (!z) {
                    this.postOperationsViewModel.unfollowUser(userId2);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

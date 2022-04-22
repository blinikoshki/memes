package com.memes.plus.p040ui.posts.edit_post;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.p040ui.create_post.tagpeople.TaggedPerson;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUser;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0019\u001a\u00020\u0018J\u0010\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\tJ\r\u0010\u001c\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015J\b\u0010\u001f\u001a\u0004\u0018\u00010\tJ\u001f\u0010 \u001a\u00020\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\tJ\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070$J\u0010\u0010%\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/edit_post/EditPostViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;)V", "_postEdited", "Landroidx/lifecycle/MutableLiveData;", "", "captionInput", "", "contentType", "", "Ljava/lang/Integer;", "postIdForRepost", "postTaggedUsersLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "getPostTaggedUsersLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "postUri", "Landroid/net/Uri;", "taggedPeopleJson", "captionInputChanged", "", "editMeme", "fetchPostTaggedUsers", "postId", "getContentType", "()Ljava/lang/Integer;", "getPostUri", "getTaggedPeopleJson", "mediaContentChange", "(Landroid/net/Uri;Ljava/lang/Integer;)V", "onPostIdChanged", "postEdited", "Landroidx/lifecycle/LiveData;", "taggedPeopleInputChanged", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.edit_post.EditPostViewModel */
/* compiled from: EditPostViewModel.kt */
public final class EditPostViewModel extends BaseRxJavaViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _postEdited = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public String captionInput = "";
    private Integer contentType = -1;
    /* access modifiers changed from: private */
    public String postIdForRepost;
    private final SingleLiveEvent<List<PostTaggedUser>> postTaggedUsersLiveData = new SingleLiveEvent<>();
    private Uri postUri;
    /* access modifiers changed from: private */
    public final MemesRepository repository;
    private String taggedPeopleJson;

    public EditPostViewModel(MemesRepository memesRepository) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        this.repository = memesRepository;
    }

    public final LiveData<Boolean> postEdited() {
        return this._postEdited;
    }

    public final SingleLiveEvent<List<PostTaggedUser>> getPostTaggedUsersLiveData() {
        return this.postTaggedUsersLiveData;
    }

    public final void taggedPeopleInputChanged(String str) {
        this.taggedPeopleJson = str;
    }

    public final void mediaContentChange(Uri uri, Integer num) {
        this.postUri = uri;
        this.contentType = num;
    }

    public final void captionInputChanged(String str) {
        this.captionInput = str;
    }

    public final void onPostIdChanged(String str) {
        this.postIdForRepost = str;
    }

    public final Uri getPostUri() {
        return this.postUri;
    }

    public final Integer getContentType() {
        return this.contentType;
    }

    public final String getTaggedPeopleJson() {
        return this.taggedPeopleJson;
    }

    public final void editMeme() {
        Gson gson = new Gson();
        String taggedPeopleJson2 = getTaggedPeopleJson();
        TypeToken<?> parameterized = TypeToken.getParameterized(List.class, TaggedPerson.class);
        Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…TaggedPerson::class.java)");
        List list = (List) gson.fromJson(taggedPeopleJson2, parameterized.getType());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        EditPostRequest editPostRequest = new EditPostRequest((String) null, "", (String) null, (String) null, 13, (DefaultConstructorMarker) null);
        editPostRequest.setPostId(this.postIdForRepost);
        editPostRequest.setTaggedUsers(list);
        editPostRequest.setPostText(this.captionInput);
        editPostRequest.setTags("");
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        this.repository.editPost(editPostRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new EditPostViewModel$editMeme$1(this, list));
    }

    public final void fetchPostTaggedUsers(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new EditPostViewModel$fetchPostTaggedUsers$1(this, str, (Continuation) null), 3, (Object) null);
    }
}

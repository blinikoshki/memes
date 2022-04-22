package com.memes.plus.p040ui.create_post;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaFile;
import com.memes.commons.media.MediaScannerUtility;
import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTarget;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.p040ui.apprating.AppRatingRequest;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0015J\u0006\u0010#\u001a\u00020\u001eJ\b\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u0004\u0018\u00010\u0015J\u0006\u0010&\u001a\u00020\rJ\u0006\u0010'\u001a\u00020\rJ\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0010\u0010*\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010\u0015J\u0006\u0010,\u001a\u00020\u001eJ\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0.J\u0006\u0010/\u001a\u00020\u001eJ\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100.J\b\u00101\u001a\u000202H\u0016J\u0019\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u00105J\u0006\u00106\u001a\u00020\u001eJ\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140.J\u000e\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\rJ\u000e\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\rJ\u0014\u0010<\u001a\u00020\u001e2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00100.J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\r0.J\u0010\u0010@\u001a\u00020\u001e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/ExportPostViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "mediaScannerUtility", "Lcom/memes/commons/media/MediaScannerUtility;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;Lcom/memes/commons/output/OutputTargetGenerator;Lcom/memes/commons/media/MediaScannerUtility;Lcom/memes/plus/data/storage/StorageRepository;)V", "_autoSavePost", "Landroidx/lifecycle/MutableLiveData;", "", "_posted", "_previewLiveData", "Ljava/io/File;", "_previewVideoIndicatorLiveData", "_savedTags", "Lcom/memes/commons/util/SingleLiveEvent;", "", "", "_shareExternal", "captionInput", "mediaContent", "Lcom/memes/commons/media/MediaContent;", "outputFile", "postIdForRepost", "taggedPeopleJson", "captionInputChanged", "", "createAppRatingRequest", "Lcom/memes/plus/ui/apprating/AppRatingRequest;", "deleteSavedHashTag", "hashTag", "fetchSavedHashTags", "getOutputTargetFile", "getTaggedPeopleJson", "isAppRatingConfirmed", "isAutoSavePost", "mediaContentChanged", "onAutoSavePostChanged", "onPostIdChanged", "postId", "postMeme", "posted", "Landroidx/lifecycle/LiveData;", "prepareMemeForExternalSharing", "preview", "requireMediaFile", "Lcom/memes/commons/media/MediaFile;", "saveFile", "content", "(Lcom/memes/commons/media/MediaContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveMeme", "savedTags", "setAppRatingConfirmed", "confirmed", "setAutoSavePost", "autoSave", "setSavedHashTags", "items", "shareExternal", "showPreviewVideoIndicator", "taggedPeopleInputChanged", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostViewModel */
/* compiled from: ExportPostViewModel.kt */
public class ExportPostViewModel extends BaseRxJavaViewModel {
    private final MutableLiveData<Boolean> _autoSavePost;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _posted = new MutableLiveData<>();
    private final MutableLiveData<File> _previewLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _previewVideoIndicatorLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<List<String>> _savedTags = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<File> _shareExternal = new MutableLiveData<>();
    private String captionInput;
    /* access modifiers changed from: private */
    public MediaContent mediaContent;
    /* access modifiers changed from: private */
    public final MediaScannerUtility mediaScannerUtility;
    /* access modifiers changed from: private */
    public File outputFile;
    private final OutputTargetGenerator outputTargetGenerator;
    private String postIdForRepost;
    private final MemesRepository repository;
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;
    private String taggedPeopleJson;

    public static final /* synthetic */ MediaContent access$getMediaContent$p(ExportPostViewModel exportPostViewModel) {
        MediaContent mediaContent2 = exportPostViewModel.mediaContent;
        if (mediaContent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
        }
        return mediaContent2;
    }

    public static final /* synthetic */ File access$getOutputFile$p(ExportPostViewModel exportPostViewModel) {
        File file = exportPostViewModel.outputFile;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputFile");
        }
        return file;
    }

    public ExportPostViewModel(MemesRepository memesRepository, OutputTargetGenerator outputTargetGenerator2, MediaScannerUtility mediaScannerUtility2, StorageRepository storageRepository2) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        Intrinsics.checkNotNullParameter(mediaScannerUtility2, "mediaScannerUtility");
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        this.repository = memesRepository;
        this.outputTargetGenerator = outputTargetGenerator2;
        this.mediaScannerUtility = mediaScannerUtility2;
        this.storageRepository = storageRepository2;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._autoSavePost = mutableLiveData;
        this.captionInput = "";
        mutableLiveData.setValue(Boolean.valueOf(storageRepository2.autoSavePost()));
    }

    public final LiveData<File> preview() {
        return this._previewLiveData;
    }

    public final LiveData<Boolean> showPreviewVideoIndicator() {
        return this._previewVideoIndicatorLiveData;
    }

    public final LiveData<List<String>> savedTags() {
        return this._savedTags;
    }

    public final LiveData<File> shareExternal() {
        return this._shareExternal;
    }

    public final LiveData<Boolean> posted() {
        return this._posted;
    }

    public final MutableLiveData<Boolean> onAutoSavePostChanged() {
        return this._autoSavePost;
    }

    public MediaFile requireMediaFile() {
        MediaFile.Companion companion = MediaFile.Companion;
        MediaContent mediaContent2 = this.mediaContent;
        if (mediaContent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
        }
        return companion.from(mediaContent2);
    }

    public final void captionInputChanged(String str) {
        this.captionInput = str;
    }

    public final void taggedPeopleInputChanged(String str) {
        this.taggedPeopleJson = str;
    }

    public final void onPostIdChanged(String str) {
        this.postIdForRepost = str;
    }

    public void mediaContentChanged(MediaContent mediaContent2) {
        Intrinsics.checkNotNullParameter(mediaContent2, "mediaContent");
        this.mediaContent = mediaContent2;
        File asFile = mediaContent2.asFile();
        if (asFile.exists()) {
            this._previewLiveData.setValue(asFile);
        }
        this._previewVideoIndicatorLiveData.setValue(Boolean.valueOf(mediaContent2.isVideo() || mediaContent2.isGifVideo()));
    }

    public final String getTaggedPeopleJson() {
        return this.taggedPeopleJson;
    }

    public final void postMeme() {
        String str = this.captionInput;
        String str2 = this.taggedPeopleJson;
        String str3 = this.postIdForRepost;
        MediaContent mediaContent2 = this.mediaContent;
        if (mediaContent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
        }
        CreatePostRequest createPostRequest = new CreatePostRequest(str, str2, str3, mediaContent2);
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        this.repository.createPost(createPostRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new ExportPostViewModel$postMeme$1(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object saveFile(MediaContent mediaContent2, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ExportPostViewModel$saveFile$2(this, mediaContent2, (Continuation) null), continuation);
    }

    /* access modifiers changed from: private */
    public final File getOutputTargetFile() {
        String str;
        if (this.outputFile == null) {
            MediaContent mediaContent2 = this.mediaContent;
            if (mediaContent2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
            }
            if (mediaContent2.isPhoto()) {
                str = OutputExtension.JPG;
            } else {
                MediaContent mediaContent3 = this.mediaContent;
                if (mediaContent3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
                }
                str = mediaContent3.isVideo() ? OutputExtension.MP4 : OutputExtension.UNKNOWN;
            }
            this.outputFile = OutputTargetGenerator.setDefaultOutputDestination$default(this.outputTargetGenerator, OutputTarget.FOLDER_SAVED_MEMES, (String) null, str, false, false, 10, (Object) null).getOutputFile();
        }
        File file = this.outputFile;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputFile");
        }
        return file;
    }

    public final void fetchSavedHashTags() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ExportPostViewModel$fetchSavedHashTags$1(this, (Continuation) null), 3, (Object) null);
    }

    public final void deleteSavedHashTag(String str) {
        Intrinsics.checkNotNullParameter(str, "hashTag");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new ExportPostViewModel$deleteSavedHashTag$1(this, str, (Continuation) null), 2, (Object) null);
    }

    public final void setSavedHashTags(List<String> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ExportPostViewModel$setSavedHashTags$1(this, list, (Continuation) null), 3, (Object) null);
    }

    public final boolean isAutoSavePost() {
        return this.storageRepository.autoSavePost();
    }

    public final void setAutoSavePost(boolean z) {
        this.storageRepository.setAutoSavePost(z);
        this._autoSavePost.setValue(Boolean.valueOf(z));
    }

    public final boolean isAppRatingConfirmed() {
        return this.storageRepository.appRatingConfirmed();
    }

    public final void setAppRatingConfirmed(boolean z) {
        this.storageRepository.setAppRatingConfirmed(z);
    }

    public final AppRatingRequest createAppRatingRequest() {
        return new AppRatingRequest("Hey " + this.storageRepository.name() + ", thanks for being an \nawesome MEMER 😀", this.storageRepository.profilePic());
    }

    public final void prepareMemeForExternalSharing() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), new C4243xbbe1955c(CoroutineExceptionHandler.Key, this), (CoroutineStart) null, new ExportPostViewModel$prepareMemeForExternalSharing$1(this, (Continuation) null), 2, (Object) null);
    }

    public final void saveMeme() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), new C4244x4b3db66(CoroutineExceptionHandler.Key, this), (CoroutineStart) null, new ExportPostViewModel$saveMeme$1(this, (Continuation) null), 2, (Object) null);
    }
}

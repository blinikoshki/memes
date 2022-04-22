package com.memes.plus.p040ui.profile.edit_profile;

import androidx.lifecycle.MutableLiveData;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.p040ui.profile.self_profile.SelfProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tJ\u0010\u0010*\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010\tJ\u0006\u0010,\u001a\u00020(J\u000e\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\tJ\u0006\u0010/\u001a\u00020(J\u000e\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\tJ\u0010\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u00010\tJ\u0006\u00104\u001a\u00020(J\u000e\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\tR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\u0010R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\u0010R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000b¨\u00067"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/edit_profile/EditProfileViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "memesRepository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;Lcom/memes/plus/data/storage/StorageRepository;)V", "bioLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getBioLiveData", "()Landroidx/lifecycle/MutableLiveData;", "contentLayoutLiveData", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentLayoutLiveData", "setContentLayoutLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "coverImageLiveData", "getCoverImageLiveData", "locationLiveData", "getLocationLiveData", "logoutLiveData", "getLogoutLiveData", "setLogoutLiveData", "nameLiveData", "getNameLiveData", "profileLiveData", "Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "getProfileLiveData", "setProfileLiveData", "profilePicLiveData", "getProfilePicLiveData", "profileSavedLiveData", "getProfileSavedLiveData", "setProfileSavedLiveData", "saveProfileRequest", "Lcom/memes/plus/ui/profile/edit_profile/SaveProfileRequest;", "userNameLiveData", "getUserNameLiveData", "bioInputChanged", "", "bioInput", "coverImageChanged", "coverImagePath", "fetchProfile", "locationInputChanged", "locationInput", "logout", "nameInputChanged", "nameInput", "profilePicChanged", "profilePicPath", "saveProfile", "userNameInputChanged", "userNameInput", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.EditProfileViewModel */
/* compiled from: EditProfileViewModel.kt */
public final class EditProfileViewModel extends BaseRxJavaViewModel {
    private final MutableLiveData<String> bioLiveData;
    private MutableLiveData<ContentVisibilityAction> contentLayoutLiveData;
    private final MutableLiveData<String> coverImageLiveData;
    private final MutableLiveData<String> locationLiveData;
    private MutableLiveData<String> logoutLiveData;
    private final MemesRepository memesRepository;
    private final MutableLiveData<String> nameLiveData;
    private MutableLiveData<SelfProfile> profileLiveData;
    private final MutableLiveData<String> profilePicLiveData;
    private MutableLiveData<SelfProfile> profileSavedLiveData;
    /* access modifiers changed from: private */
    public SaveProfileRequest saveProfileRequest = new SaveProfileRequest();
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;
    private final MutableLiveData<String> userNameLiveData;

    public EditProfileViewModel(MemesRepository memesRepository2, StorageRepository storageRepository2) {
        Intrinsics.checkNotNullParameter(memesRepository2, "memesRepository");
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        this.memesRepository = memesRepository2;
        this.storageRepository = storageRepository2;
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.profilePicLiveData = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this.coverImageLiveData = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this.nameLiveData = mutableLiveData3;
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        this.userNameLiveData = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        this.locationLiveData = mutableLiveData5;
        MutableLiveData<String> mutableLiveData6 = new MutableLiveData<>();
        this.bioLiveData = mutableLiveData6;
        this.profileLiveData = new MutableLiveData<>();
        this.contentLayoutLiveData = new MutableLiveData<>();
        this.profileSavedLiveData = new MutableLiveData<>();
        this.logoutLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(storageRepository2.profilePic());
        mutableLiveData2.setValue(storageRepository2.coverPic());
        mutableLiveData3.setValue(ExtensionsKt.encode(storageRepository2.name()));
        mutableLiveData4.setValue(storageRepository2.userName());
        mutableLiveData5.setValue(storageRepository2.location());
        mutableLiveData6.setValue(ExtensionsKt.encode(storageRepository2.bio()));
    }

    public final MutableLiveData<String> getProfilePicLiveData() {
        return this.profilePicLiveData;
    }

    public final MutableLiveData<String> getCoverImageLiveData() {
        return this.coverImageLiveData;
    }

    public final MutableLiveData<String> getNameLiveData() {
        return this.nameLiveData;
    }

    public final MutableLiveData<String> getUserNameLiveData() {
        return this.userNameLiveData;
    }

    public final MutableLiveData<String> getLocationLiveData() {
        return this.locationLiveData;
    }

    public final MutableLiveData<String> getBioLiveData() {
        return this.bioLiveData;
    }

    public final MutableLiveData<SelfProfile> getProfileLiveData() {
        return this.profileLiveData;
    }

    public final void setProfileLiveData(MutableLiveData<SelfProfile> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.profileLiveData = mutableLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentLayoutLiveData() {
        return this.contentLayoutLiveData;
    }

    public final void setContentLayoutLiveData(MutableLiveData<ContentVisibilityAction> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.contentLayoutLiveData = mutableLiveData;
    }

    public final MutableLiveData<SelfProfile> getProfileSavedLiveData() {
        return this.profileSavedLiveData;
    }

    public final void setProfileSavedLiveData(MutableLiveData<SelfProfile> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.profileSavedLiveData = mutableLiveData;
    }

    public final MutableLiveData<String> getLogoutLiveData() {
        return this.logoutLiveData;
    }

    public final void setLogoutLiveData(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.logoutLiveData = mutableLiveData;
    }

    public final void profilePicChanged(String str) {
        this.saveProfileRequest.setProfilePic(str);
    }

    public final void coverImageChanged(String str) {
        this.saveProfileRequest.setCoverPic(str);
    }

    public final void nameInputChanged(String str) {
        Intrinsics.checkNotNullParameter(str, "nameInput");
        this.saveProfileRequest.setName(str);
    }

    public final void userNameInputChanged(String str) {
        Intrinsics.checkNotNullParameter(str, "userNameInput");
        this.saveProfileRequest.setUserName(str);
    }

    public final void locationInputChanged(String str) {
        Intrinsics.checkNotNullParameter(str, "locationInput");
        this.saveProfileRequest.setLocation(str);
    }

    public final void bioInputChanged(String str) {
        Intrinsics.checkNotNullParameter(str, "bioInput");
        this.saveProfileRequest.setBio(str);
    }

    public final void fetchProfile() {
        BaseViewModel.showProgress$default(this, this.contentLayoutLiveData, (String) null, 2, (Object) null);
        this.memesRepository.fetchSelfProfile().observeOn(AndroidSchedulers.mainThread()).subscribe(new EditProfileViewModel$fetchProfile$1(this));
    }

    public final void saveProfile() {
        CharSequence name = this.saveProfileRequest.getName();
        boolean z = false;
        if (name == null || StringsKt.isBlank(name)) {
            toast((int) C4199R.string.error_name_empty);
            return;
        }
        if (Intrinsics.areEqual((Object) this.storageRepository.userName(), (Object) this.saveProfileRequest.getUserName())) {
            this.saveProfileRequest.setUserName((String) null);
        } else {
            CharSequence userName = this.saveProfileRequest.getUserName();
            if (userName == null || StringsKt.isBlank(userName)) {
                z = true;
            }
            if (z) {
                toast((int) C4199R.string.error_username_empty);
                return;
            }
        }
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        this.memesRepository.saveProfile(this.saveProfileRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new EditProfileViewModel$saveProfile$1(this));
    }

    public final void logout() {
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        this.memesRepository.logout().observeOn(AndroidSchedulers.mainThread()).subscribe(new EditProfileViewModel$logout$1(this));
    }
}

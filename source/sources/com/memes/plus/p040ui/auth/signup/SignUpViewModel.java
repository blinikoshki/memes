package com.memes.plus.p040ui.auth.signup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.plus.C4199R;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.p040ui.auth.signup.selectgender.Gender;
import com.memes.plus.p040ui.auth.signup.stages.SignUpStage;
import com.memes.plus.util.Constants;
import com.memes.plus.util.assetfile.AssetFileProvider;
import com.memes.plus.util.validation.Validations;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0011\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\u001eJ\u001d\u0010\"\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\rJ\u0010\u0010&\u001a\u00020\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\rJ\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0010H\u0002J\u001b\u0010)\u001a\u00020*2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0012\u0010+\u001a\u00020*2\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0002J\u001b\u0010,\u001a\u00020*2\b\u0010\u001c\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010$J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0.J\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0.J\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100.J\f\u00101\u001a\b\u0012\u0004\u0012\u00020\r0.J\u0010\u00102\u001a\u00020\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ\u0006\u00103\u001a\u00020\u001eJ\u0010\u00104\u001a\u00020\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\rJ\u0010\u00105\u001a\u00020\u001e2\b\u0010\u001c\u001a\u0004\u0018\u00010\rR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00066"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/SignUpViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "memesDataSource", "Lcom/memes/network/memes/api/MemesDataSource;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "assetFileProvider", "Lcom/memes/plus/util/assetfile/AssetFileProvider;", "(Lcom/memes/network/memes/api/MemesDataSource;Lcom/memes/plus/data/storage/StorageRepository;Lcom/memes/plus/util/assetfile/AssetFileProvider;)V", "_selectedGender", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/plus/ui/auth/signup/selectgender/Gender;", "_selectedProfilePicture", "", "_signUpResult", "_signUpStageChanged", "Lcom/memes/plus/ui/auth/signup/stages/SignUpStage;", "birthday", "email", "fullName", "<set-?>", "gender", "getGender", "()Lcom/memes/plus/ui/auth/signup/selectgender/Gender;", "password", "picturePath", "signUpExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "username", "birthdayChanged", "", "changeStage", "stage", "completeSignUp", "createProfilePicBase64Encoded", "filePath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emailChanged", "fullNameChanged", "genderChanged", "goToStage", "isEmailValid", "", "isPasswordValid", "isUsernameValid", "onGenderSelected", "Landroidx/lifecycle/LiveData;", "onProfilePictureSelected", "onSignUpStageChanged", "onSignUpSuccessful", "passwordChanged", "performIdentityValidation", "profilePictureChanged", "usernameChanged", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.SignUpViewModel */
/* compiled from: SignUpViewModel.kt */
public final class SignUpViewModel extends BaseViewModel {
    private final SingleLiveEvent<Gender> _selectedGender = new SingleLiveEvent<>();
    private final SingleLiveEvent<String> _selectedProfilePicture = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<String> _signUpResult = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<SignUpStage> _signUpStageChanged = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final AssetFileProvider assetFileProvider;
    /* access modifiers changed from: private */
    public String birthday;
    /* access modifiers changed from: private */
    public String email;
    private String fullName;
    /* access modifiers changed from: private */
    public Gender gender = Gender.NONE;
    /* access modifiers changed from: private */
    public final MemesDataSource memesDataSource;
    /* access modifiers changed from: private */
    public String password;
    /* access modifiers changed from: private */
    public String picturePath;
    private final CoroutineExceptionHandler signUpExceptionHandler = new SignUpViewModel$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;
    /* access modifiers changed from: private */
    public String username;

    public SignUpViewModel(MemesDataSource memesDataSource2, StorageRepository storageRepository2, AssetFileProvider assetFileProvider2) {
        Intrinsics.checkNotNullParameter(memesDataSource2, "memesDataSource");
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        Intrinsics.checkNotNullParameter(assetFileProvider2, "assetFileProvider");
        this.memesDataSource = memesDataSource2;
        this.storageRepository = storageRepository2;
        this.assetFileProvider = assetFileProvider2;
    }

    public final LiveData<SignUpStage> onSignUpStageChanged() {
        return this._signUpStageChanged;
    }

    public final LiveData<Gender> onGenderSelected() {
        return this._selectedGender;
    }

    public final LiveData<String> onProfilePictureSelected() {
        return this._selectedProfilePicture;
    }

    public final LiveData<String> onSignUpSuccessful() {
        return this._signUpResult;
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final void emailChanged(String str) {
        this.email = str;
    }

    public final void usernameChanged(String str) {
        this.username = str;
    }

    public final void passwordChanged(String str) {
        this.password = str;
    }

    public final void fullNameChanged(String str) {
        this.fullName = str;
    }

    public final void genderChanged(Gender gender2) {
        Intrinsics.checkNotNullParameter(gender2, "gender");
        this.gender = gender2;
        this._selectedGender.setValue(gender2);
    }

    public final void birthdayChanged(String str) {
        this.birthday = str;
    }

    public final void profilePictureChanged(String str) {
        this.picturePath = str;
        this._selectedProfilePicture.setValue(str);
    }

    public final void performIdentityValidation() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.signUpExceptionHandler, (CoroutineStart) null, new SignUpViewModel$performIdentityValidation$1(this, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object isEmailValid(String str, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new SignUpViewModel$isEmailValid$2(this, str, (Continuation) null), continuation);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object isUsernameValid(String str, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new SignUpViewModel$isUsernameValid$2(this, str, (Continuation) null), continuation);
    }

    /* access modifiers changed from: private */
    public final boolean isPasswordValid(String str) {
        int forPassword = Validations.INSTANCE.forPassword(str);
        if (forPassword == 5) {
            return true;
        }
        if (forPassword == 1) {
            toast((int) C4199R.string.error_password_empty);
            return false;
        } else if (forPassword != 3) {
            toast(Constants.UNUSUAL_ERROR);
            return false;
        } else {
            toast((int) C4199R.string.error_password_invalid);
            return false;
        }
    }

    public final void completeSignUp() {
        String str = this.email;
        if (str != null) {
            String str2 = this.username;
            if (str2 != null) {
                String str3 = this.password;
                if (str3 != null) {
                    String str4 = this.fullName;
                    int forName = Validations.INSTANCE.forName(str4);
                    if (forName != 5) {
                        if (forName != 1) {
                            toast(Constants.UNUSUAL_ERROR);
                        } else {
                            toast((int) C4199R.string.error_full_name_empty);
                        }
                    } else if (str4 != null) {
                        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.signUpExceptionHandler, (CoroutineStart) null, new SignUpViewModel$completeSignUp$1(this, str, str2, str3, str4, (Continuation) null), 2, (Object) null);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object createProfilePicBase64Encoded(String str, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new SignUpViewModel$createProfilePicBase64Encoded$2(this, str, (Continuation) null), continuation);
    }

    public final void changeStage(SignUpStage signUpStage) {
        Intrinsics.checkNotNullParameter(signUpStage, "stage");
        goToStage(signUpStage);
    }

    private final void goToStage(SignUpStage signUpStage) {
        this._signUpStageChanged.setValue(signUpStage);
    }
}

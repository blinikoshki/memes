package com.google.firebase.auth.ktx;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.ktx.Firebase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a-\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a5\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a-\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a%\u0010\u0016\u001a\u00020\u00172\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001b"}, mo26107d2 = {"LIBRARY_NAME", "", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "Lcom/google/firebase/ktx/Firebase;", "getAuth", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/auth/FirebaseAuth;", "actionCodeSettings", "Lcom/google/firebase/auth/ActionCodeSettings;", "init", "Lkotlin/Function1;", "Lcom/google/firebase/auth/ActionCodeSettings$Builder;", "", "Lkotlin/ExtensionFunctionType;", "oAuthCredential", "Lcom/google/firebase/auth/AuthCredential;", "providerId", "Lcom/google/firebase/auth/OAuthProvider$CredentialBuilder;", "oAuthProvider", "Lcom/google/firebase/auth/OAuthProvider;", "firebaseAuth", "Lcom/google/firebase/auth/OAuthProvider$Builder;", "userProfileChangeRequest", "Lcom/google/firebase/auth/UserProfileChangeRequest;", "Lcom/google/firebase/auth/UserProfileChangeRequest$Builder;", "app", "Lcom/google/firebase/FirebaseApp;", "java.com.google.android.libraries.firebase.firebase_auth_ktx_granule"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* compiled from: com.google.firebase:firebase-auth-ktx@@20.0.2 */
public final class AuthKt {
    public static final String LIBRARY_NAME = "fire-auth-ktx";

    public static final ActionCodeSettings actionCodeSettings(Function1<? super ActionCodeSettings.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        ActionCodeSettings.Builder newBuilder = ActionCodeSettings.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "ActionCodeSettings.newBuilder()");
        function1.invoke(newBuilder);
        ActionCodeSettings build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final FirebaseAuth auth(Firebase firebase, FirebaseApp firebaseApp) {
        Intrinsics.checkNotNullParameter(firebase, "$this$auth");
        Intrinsics.checkNotNullParameter(firebaseApp, "app");
        FirebaseAuth instance = FirebaseAuth.getInstance(firebaseApp);
        Intrinsics.checkNotNullExpressionValue(instance, "FirebaseAuth.getInstance(app)");
        return instance;
    }

    public static final FirebaseAuth getAuth(Firebase firebase) {
        Intrinsics.checkNotNullParameter(firebase, "$this$auth");
        FirebaseAuth instance = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "FirebaseAuth.getInstance()");
        return instance;
    }

    public static final AuthCredential oAuthCredential(String str, Function1<? super OAuthProvider.CredentialBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "providerId");
        Intrinsics.checkNotNullParameter(function1, "init");
        OAuthProvider.CredentialBuilder newCredentialBuilder = OAuthProvider.newCredentialBuilder(str);
        Intrinsics.checkNotNullExpressionValue(newCredentialBuilder, "OAuthProvider.newCredentialBuilder(providerId)");
        function1.invoke(newCredentialBuilder);
        AuthCredential build = newCredentialBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final OAuthProvider oAuthProvider(String str, FirebaseAuth firebaseAuth, Function1<? super OAuthProvider.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "providerId");
        Intrinsics.checkNotNullParameter(firebaseAuth, "firebaseAuth");
        Intrinsics.checkNotNullParameter(function1, "init");
        OAuthProvider.Builder newBuilder = OAuthProvider.newBuilder(str, firebaseAuth);
        Intrinsics.checkNotNullExpressionValue(newBuilder, "OAuthProvider.newBuilder(providerId, firebaseAuth)");
        function1.invoke(newBuilder);
        OAuthProvider build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final UserProfileChangeRequest userProfileChangeRequest(Function1<? super UserProfileChangeRequest.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        UserProfileChangeRequest.Builder builder = new UserProfileChangeRequest.Builder();
        function1.invoke(builder);
        UserProfileChangeRequest build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final OAuthProvider oAuthProvider(String str, Function1<? super OAuthProvider.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "providerId");
        Intrinsics.checkNotNullParameter(function1, "init");
        OAuthProvider.Builder newBuilder = OAuthProvider.newBuilder(str);
        Intrinsics.checkNotNullExpressionValue(newBuilder, "OAuthProvider.newBuilder(providerId)");
        function1.invoke(newBuilder);
        OAuthProvider build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}

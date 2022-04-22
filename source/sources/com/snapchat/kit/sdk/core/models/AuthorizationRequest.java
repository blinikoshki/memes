package com.snapchat.kit.sdk.core.models;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;

public class AuthorizationRequest implements Serializable {
    @SerializedName("mClientId")
    @Expose
    private String mClientId;
    @SerializedName("mCodeChallenge")
    @Expose
    private String mCodeChallenge;
    @SerializedName("mCodeChallengeMethod")
    @Expose
    private String mCodeChallengeMethod;
    @SerializedName("mCodeVerifier")
    @Expose
    private String mCodeVerifier;
    @SerializedName("mFeatures")
    @Expose
    private String mFeatures;
    @SerializedName("mRedirectUri")
    @Expose
    private String mRedirectUri;
    @SerializedName("mResponseType")
    @Expose
    private String mResponseType;
    @SerializedName("mScope")
    @Expose
    private String mScope;
    @SerializedName("mState")
    @Expose
    private String mState;

    public String getResponseType() {
        return this.mResponseType;
    }

    public AuthorizationRequest withResponseType(String str) {
        this.mResponseType = str;
        return this;
    }

    public AuthorizationRequest withClientId(String str) {
        this.mClientId = str;
        return this;
    }

    public AuthorizationRequest withScope(String str) {
        this.mScope = str;
        return this;
    }

    public String getRedirectUri() {
        return this.mRedirectUri;
    }

    public AuthorizationRequest withRedirectUri(String str) {
        this.mRedirectUri = str;
        return this;
    }

    public String getState() {
        return this.mState;
    }

    public AuthorizationRequest withState(String str) {
        this.mState = str;
        return this;
    }

    public String getCodeVerifier() {
        return this.mCodeVerifier;
    }

    public AuthorizationRequest withCodeVerifier(String str) {
        this.mCodeVerifier = str;
        return this;
    }

    public AuthorizationRequest withCodeChallengeMethod(String str) {
        this.mCodeChallengeMethod = str;
        return this;
    }

    public AuthorizationRequest withCodeChallenge(String str) {
        this.mCodeChallenge = str;
        return this;
    }

    public AuthorizationRequest withFeatures(String str) {
        this.mFeatures = str;
        return this;
    }

    public String toJson() {
        return new Gson().toJson((Object) this);
    }

    public Uri toUri(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            str = "https://accounts.snapchat.com/accounts";
        }
        Uri.Builder appendQueryParameter = Uri.parse(str + str2).buildUpon().appendQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, this.mResponseType).appendQueryParameter("client_id", this.mClientId).appendQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.mRedirectUri).appendQueryParameter("scope", this.mScope).appendQueryParameter("state", this.mState).appendQueryParameter("code_challenge_method", this.mCodeChallengeMethod).appendQueryParameter("code_challenge", this.mCodeChallenge);
        if (!TextUtils.isEmpty(str3)) {
            appendQueryParameter.appendQueryParameter("package_name", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            appendQueryParameter.appendQueryParameter("source", str4);
        }
        if (!TextUtils.isEmpty(this.mFeatures)) {
            appendQueryParameter.appendQueryParameter("features", this.mFeatures);
        }
        appendQueryParameter.appendQueryParameter("kit_version", "1.6.8");
        appendQueryParameter.appendQueryParameter("link", this.mClientId);
        return appendQueryParameter.build();
    }

    public String toString() {
        return toJson();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mResponseType, this.mClientId, this.mScope, this.mRedirectUri, this.mState, this.mCodeVerifier, this.mCodeChallengeMethod, this.mCodeChallenge, this.mFeatures});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthorizationRequest)) {
            return false;
        }
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) obj;
        return Objects.equals(this.mResponseType, authorizationRequest.mResponseType) && Objects.equals(this.mClientId, authorizationRequest.mClientId) && Objects.equals(this.mScope, authorizationRequest.mScope) && Objects.equals(this.mRedirectUri, authorizationRequest.mRedirectUri) && Objects.equals(this.mState, authorizationRequest.mState) && Objects.equals(this.mCodeVerifier, authorizationRequest.mCodeVerifier) && Objects.equals(this.mCodeChallengeMethod, authorizationRequest.mCodeChallengeMethod) && Objects.equals(this.mCodeChallenge, authorizationRequest.mCodeChallenge) && Objects.equals(this.mFeatures, authorizationRequest.mFeatures);
    }
}

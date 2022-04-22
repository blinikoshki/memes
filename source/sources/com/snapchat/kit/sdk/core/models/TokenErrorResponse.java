package com.snapchat.kit.sdk.core.models;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public class TokenErrorResponse {
    @SerializedName("error")
    protected String mError;
    @SerializedName("error_description")
    protected String mErrorDescription;
    @SerializedName("message")
    protected String mMessage;

    public TokenErrorResponse(String str) {
        this.mError = str;
    }

    public final String getError() {
        return this.mError;
    }

    public final String getErrorDescription() {
        return this.mErrorDescription;
    }

    public final String getMessage() {
        return this.mMessage;
    }

    public int hashCode() {
        String str = this.mError;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode() * 37) + 17;
        String str2 = this.mErrorDescription;
        int hashCode2 = hashCode + (str2 == null ? 0 : str2.hashCode() * 37);
        String str3 = this.mMessage;
        if (str3 != null) {
            i = str3.hashCode() * 37;
        }
        return hashCode2 + i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof TokenErrorResponse)) {
            TokenErrorResponse tokenErrorResponse = (TokenErrorResponse) obj;
            return Objects.equals(this.mError, tokenErrorResponse.mError) && Objects.equals(this.mErrorDescription, tokenErrorResponse.mErrorDescription) && Objects.equals(this.mMessage, tokenErrorResponse.mMessage);
        }
    }
}

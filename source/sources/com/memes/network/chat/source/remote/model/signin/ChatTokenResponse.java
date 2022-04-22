package com.memes.network.chat.source.remote.model.signin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0011J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/network/chat/source/remote/model/signin/ChatTokenResponse;", "", "success", "", "token", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getSuccess", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getToken", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/memes/network/chat/source/remote/model/signin/ChatTokenResponse;", "equals", "", "other", "hashCode", "isError", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatTokenResponse.kt */
public final class ChatTokenResponse {
    @SerializedName("success")
    @Expose
    private final Integer success;
    @SerializedName("token")
    @Expose
    private final String token;

    public ChatTokenResponse() {
        this((Integer) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChatTokenResponse copy$default(ChatTokenResponse chatTokenResponse, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = chatTokenResponse.success;
        }
        if ((i & 2) != 0) {
            str = chatTokenResponse.token;
        }
        return chatTokenResponse.copy(num, str);
    }

    public final Integer component1() {
        return this.success;
    }

    public final String component2() {
        return this.token;
    }

    public final ChatTokenResponse copy(Integer num, String str) {
        return new ChatTokenResponse(num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatTokenResponse)) {
            return false;
        }
        ChatTokenResponse chatTokenResponse = (ChatTokenResponse) obj;
        return Intrinsics.areEqual((Object) this.success, (Object) chatTokenResponse.success) && Intrinsics.areEqual((Object) this.token, (Object) chatTokenResponse.token);
    }

    public int hashCode() {
        Integer num = this.success;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.token;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChatTokenResponse(success=" + this.success + ", token=" + this.token + ")";
    }

    public ChatTokenResponse(Integer num, String str) {
        this.success = num;
        this.token = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatTokenResponse(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
    }

    public final Integer getSuccess() {
        return this.success;
    }

    public final String getToken() {
        return this.token;
    }

    public final boolean isError() {
        Integer num = this.success;
        return num == null || (num != null && num.intValue() == 0);
    }
}

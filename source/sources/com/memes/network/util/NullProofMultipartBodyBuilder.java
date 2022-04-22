package com.memes.network.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\"\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\f\u001a\u00020\u0000J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/network/util/NullProofMultipartBodyBuilder;", "", "()V", "builder", "Lokhttp3/MultipartBody$Builder;", "addFormDataPart", "key", "", "value", "fileName", "requestBody", "Lokhttp3/RequestBody;", "asForm", "build", "Lokhttp3/MultipartBody;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NullProofMultipartBodyBuilder.kt */
public final class NullProofMultipartBodyBuilder {
    private final MultipartBody.Builder builder = new MultipartBody.Builder();

    public final NullProofMultipartBodyBuilder asForm() {
        this.builder.setType(MultipartBody.FORM);
        return this;
    }

    public final NullProofMultipartBodyBuilder addFormDataPart(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (str2 != null) {
            this.builder.addFormDataPart(str, str2);
        }
        return this;
    }

    public final NullProofMultipartBodyBuilder addFormDataPart(String str, String str2, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!(str2 == null || requestBody == null)) {
            this.builder.addFormDataPart(str, str2, requestBody);
        }
        return this;
    }

    public final MultipartBody build() {
        MultipartBody build = this.builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}

package com.memes.plus.p040ui.auth.signinfb;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "jsonObject", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/facebook/GraphResponse;", "onCompleted"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signinfb.FbAuthViewModel$fetchFbProfile$2$jsonObject$1$1$graphRequest$1 */
/* compiled from: FbAuthViewModel.kt */
final class FbAuthViewModel$fetchFbProfile$2$jsonObject$1$1$graphRequest$1 implements GraphRequest.GraphJSONObjectCallback {
    final /* synthetic */ Continuation $continuation;

    FbAuthViewModel$fetchFbProfile$2$jsonObject$1$1$graphRequest$1(Continuation continuation) {
        this.$continuation = continuation;
    }

    public final void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
        Continuation continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1029constructorimpl(jSONObject));
    }
}

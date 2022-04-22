package com.giphy.sdk.tracking;

import com.giphy.sdk.core.network.api.CompletionHandler;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo26107d2 = {"com/giphy/sdk/tracking/OMTracking$loadLibrary$1", "Lcom/giphy/sdk/core/network/api/CompletionHandler;", "", "onComplete", "", "result", "e", "", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: OMTracking.kt */
public final class OMTracking$loadLibrary$1 implements CompletionHandler<String> {
    OMTracking$loadLibrary$1() {
    }

    public void onComplete(String str, Throwable th) {
        if (str != null) {
            OMTracking.INSTANCE.setVerificationScript(str);
        }
        if (th != null) {
            th.printStackTrace();
        }
    }
}

package com.memes.plus.p040ui.auth.signinfb;

import com.facebook.CallbackManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "Lcom/facebook/CallbackManager;", "kotlin.jvm.PlatformType", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signinfb.FbAuthProvider$callbackManager$2 */
/* compiled from: FbAuthProvider.kt */
final class FbAuthProvider$callbackManager$2 extends Lambda implements Function0<CallbackManager> {
    public static final FbAuthProvider$callbackManager$2 INSTANCE = new FbAuthProvider$callbackManager$2();

    FbAuthProvider$callbackManager$2() {
        super(0);
    }

    public final CallbackManager invoke() {
        return CallbackManager.Factory.create();
    }
}

package com.memes.plus.p040ui.subscription;

import android.content.Intent;
import android.net.Uri;
import androidx.lifecycle.Observer;
import com.memes.plus.util.Constants;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "sku", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreActivity$setupObservers$8 */
/* compiled from: StoreActivity.kt */
final class StoreActivity$setupObservers$8<T> implements Observer<String> {
    final /* synthetic */ StoreActivity this$0;

    StoreActivity$setupObservers$8(StoreActivity storeActivity) {
        this.this$0 = storeActivity;
    }

    public final void onChanged(String str) {
        Timber.m306i("Viewing subscriptions on the Google Play Store", new Object[0]);
        String createPlayStoreSubscriptionsUrl = Constants.INSTANCE.createPlayStoreSubscriptionsUrl(this.this$0, str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(createPlayStoreSubscriptionsUrl));
        this.this$0.startActivity(intent);
    }
}

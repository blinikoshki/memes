package com.memes.plus.p040ui.profile.self_profile;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "profile", "Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfileFragment$onObserversRequested$1 */
/* compiled from: SelfProfileFragment.kt */
final class SelfProfileFragment$onObserversRequested$1<T> implements Observer<SelfProfile> {
    final /* synthetic */ SelfProfileFragment this$0;

    SelfProfileFragment$onObserversRequested$1(SelfProfileFragment selfProfileFragment) {
        this.this$0 = selfProfileFragment;
    }

    public final void onChanged(SelfProfile selfProfile) {
        this.this$0.loadProfile(selfProfile);
    }
}

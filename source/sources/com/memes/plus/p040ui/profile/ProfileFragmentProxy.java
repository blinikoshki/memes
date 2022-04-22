package com.memes.plus.p040ui.profile;

import androidx.fragment.app.Fragment;
import com.memes.network.memes.MemesSession;
import com.memes.plus.p040ui.profile.self_profile.SelfProfileFragment;
import com.memes.plus.p040ui.profile.user_profile.UserProfileFragment;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0005\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/ProfileFragmentProxy;", "", "()V", "TAG", "", "newInstance", "Lcom/memes/plus/ui/profile/self_profile/SelfProfileFragment;", "Landroidx/fragment/app/Fragment;", "targetUserId", "targetUserName", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.ProfileFragmentProxy */
/* compiled from: ProfileFragmentProxy.kt */
public final class ProfileFragmentProxy {
    public static final ProfileFragmentProxy INSTANCE = new ProfileFragmentProxy();
    public static final String TAG = "ProfileFragmentProxy";

    private ProfileFragmentProxy() {
    }

    public final SelfProfileFragment newInstance() {
        return SelfProfileFragment.Companion.newInstance();
    }

    public final Fragment newInstance(String str, String str2) {
        if (MemesSession.INSTANCE.isOf(str) || MemesSession.INSTANCE.isOf(str2)) {
            return newInstance();
        }
        return UserProfileFragment.Companion.newInstance(str, str2);
    }
}

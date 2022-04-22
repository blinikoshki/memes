package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.view.PreviewMessageView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"drawable", "", "Lcom/getstream/sdk/chat/view/PreviewMessageView$Mode;", "getDrawable", "(Lcom/getstream/sdk/chat/view/PreviewMessageView$Mode;)I", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: PreviewMessageView.kt */
public final class PreviewMessageViewKt {

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreviewMessageView.Mode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PreviewMessageView.Mode.EDIT.ordinal()] = 1;
            iArr[PreviewMessageView.Mode.REPLY_TO.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    public static final int getDrawable(PreviewMessageView.Mode mode) {
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            return C1673R.C1676drawable.stream_ic_edit;
        }
        if (i == 2) {
            return C1673R.C1676drawable.stream_ic_reply;
        }
        throw new NoWhenBranchMatchedException();
    }
}

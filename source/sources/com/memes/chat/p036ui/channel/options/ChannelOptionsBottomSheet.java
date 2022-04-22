package com.memes.chat.p036ui.channel.options;

import androidx.fragment.app.FragmentManager;
import com.memes.commons.choices.Choice;
import com.memes.commons.choices.ChoicesBottomSheet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J$\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0004\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/options/ChannelOptionsBottomSheet;", "Lcom/memes/commons/choices/ChoicesBottomSheet;", "Lcom/memes/commons/choices/ChoicesBottomSheet$Callback;", "()V", "callback", "Lcom/memes/chat/ui/channel/options/ChannelOptionsBottomSheet$Callback;", "onChoiceSelected", "", "choice", "Lcom/memes/commons/choices/Choice;", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "channelOptions", "", "Lcom/memes/chat/ui/channel/options/ChannelOption;", "Callback", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.options.ChannelOptionsBottomSheet */
/* compiled from: ChannelOptionsBottomSheet.kt */
public final class ChannelOptionsBottomSheet extends ChoicesBottomSheet implements ChoicesBottomSheet.Callback {
    private Callback callback;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/options/ChannelOptionsBottomSheet$Callback;", "", "onChannelOptionSelected", "", "channelOption", "Lcom/memes/chat/ui/channel/options/ChannelOption;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.options.ChannelOptionsBottomSheet$Callback */
    /* compiled from: ChannelOptionsBottomSheet.kt */
    public interface Callback {
        void onChannelOptionSelected(ChannelOption channelOption);
    }

    public final void show(FragmentManager fragmentManager, List<? extends ChannelOption> list, Callback callback2) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(list, "channelOptions");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        Iterable<ChannelOption> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ChannelOption choice : iterable) {
            arrayList.add(choice.getChoice());
        }
        this.callback = callback2;
        show(fragmentManager, (List) arrayList, this);
    }

    public void onChoiceSelected(Choice choice) {
        Intrinsics.checkNotNullParameter(choice, "choice");
        for (ChannelOption channelOption : ChannelOption.values()) {
            if (Intrinsics.areEqual((Object) choice.getId(), (Object) channelOption.getChoice().getId())) {
                Callback callback2 = this.callback;
                if (callback2 != null) {
                    callback2.onChannelOptionSelected(channelOption);
                    return;
                }
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }
}

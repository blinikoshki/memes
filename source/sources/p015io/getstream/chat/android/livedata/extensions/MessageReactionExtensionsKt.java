package p015io.getstream.chat.android.livedata.extensions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.Reaction;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a&\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\b¨\u0006\u0010"}, mo26107d2 = {"addMyReaction", "", "Lio/getstream/chat/android/client/models/Message;", "reaction", "Lio/getstream/chat/android/client/models/Reaction;", "enforceUnique", "", "clearOwnReactions", "Lio/getstream/chat/android/livedata/extensions/ReactionData;", "userId", "", "removeMyReaction", "updateReactions", "actions", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.extensions.MessageReactionExtensionsKt */
/* compiled from: MessageReactionExtensions.kt */
public final class MessageReactionExtensionsKt {
    public static /* synthetic */ void addMyReaction$default(Message message, Reaction reaction, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        addMyReaction(message, reaction, z);
    }

    private static final void clearOwnReactions(ReactionData reactionData, String str) {
        CollectionsKt.removeAll(reactionData.getLatestReactions(), new MessageReactionExtensionsKt$clearOwnReactions$1(str));
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : reactionData.getOwnReactions()) {
            String type = ((Reaction) next).getType();
            Object obj = linkedHashMap.get(type);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(type, obj);
            }
            ((List) obj).add(next);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            List<Reaction> list = (List) entry.getValue();
            int i = reactionData.getReactionCounts().get(str2);
            int i2 = 0;
            if (i == null) {
                i = 0;
            }
            int intValue = i.intValue() - list.size();
            if (intValue > 0) {
                reactionData.getReactionCounts().put(str2, Integer.valueOf(intValue));
            } else {
                reactionData.getReactionCounts().remove(str2);
            }
            int i3 = reactionData.getReactionScores().get(str2);
            if (i3 == null) {
                i3 = 0;
            }
            int intValue2 = i3.intValue();
            for (Reaction score : list) {
                i2 += score.getScore();
            }
            int i4 = intValue2 - i2;
            if (i4 > 0) {
                reactionData.getReactionScores().put(str2, Integer.valueOf(i4));
            } else {
                reactionData.getReactionScores().remove(str2);
            }
        }
        reactionData.getOwnReactions().clear();
    }

    private static final void updateReactions(Message message, Function1<? super ReactionData, Unit> function1) {
        ReactionData reactionData = new ReactionData(MapsKt.toMutableMap(message.getReactionCounts()), MapsKt.toMutableMap(message.getReactionScores()), CollectionsKt.toMutableList(message.getLatestReactions()), CollectionsKt.toMutableList(message.getOwnReactions()));
        function1.invoke(reactionData);
        message.setReactionCounts(reactionData.getReactionCounts());
        message.setReactionScores(reactionData.getReactionScores());
        message.setLatestReactions(reactionData.getLatestReactions());
        message.setOwnReactions(reactionData.getOwnReactions());
    }

    public static final void addMyReaction(Message message, Reaction reaction, boolean z) {
        Intrinsics.checkNotNullParameter(message, "$this$addMyReaction");
        Intrinsics.checkNotNullParameter(reaction, "reaction");
        ReactionData reactionData = new ReactionData(MapsKt.toMutableMap(message.getReactionCounts()), MapsKt.toMutableMap(message.getReactionScores()), CollectionsKt.toMutableList(message.getLatestReactions()), CollectionsKt.toMutableList(message.getOwnReactions()));
        if (z) {
            clearOwnReactions(reactionData, reaction.getUserId());
        }
        reactionData.getLatestReactions().add(reaction);
        reactionData.getOwnReactions().add(reaction);
        Map<String, Integer> reactionCounts = reactionData.getReactionCounts();
        String type = reaction.getType();
        int i = reactionData.getReactionCounts().get(reaction.getType());
        if (i == null) {
            i = 0;
        }
        reactionCounts.put(type, Integer.valueOf(i.intValue() + 1));
        Map<String, Integer> reactionScores = reactionData.getReactionScores();
        String type2 = reaction.getType();
        int i2 = reactionData.getReactionScores().get(reaction.getType());
        if (i2 == null) {
            i2 = 0;
        }
        reactionScores.put(type2, Integer.valueOf(i2.intValue() + reaction.getScore()));
        message.setReactionCounts(reactionData.getReactionCounts());
        message.setReactionScores(reactionData.getReactionScores());
        message.setLatestReactions(reactionData.getLatestReactions());
        message.setOwnReactions(reactionData.getOwnReactions());
    }

    public static final void removeMyReaction(Message message, Reaction reaction) {
        Intrinsics.checkNotNullParameter(message, "$this$removeMyReaction");
        Intrinsics.checkNotNullParameter(reaction, "reaction");
        ReactionData reactionData = new ReactionData(MapsKt.toMutableMap(message.getReactionCounts()), MapsKt.toMutableMap(message.getReactionScores()), CollectionsKt.toMutableList(message.getLatestReactions()), CollectionsKt.toMutableList(message.getOwnReactions()));
        CollectionsKt.removeAll(reactionData.getLatestReactions(), new C4989x6b0a3cc0(reaction));
        if (CollectionsKt.removeAll(reactionData.getOwnReactions(), new C4990x6b0a3cc1(reaction))) {
            int i = reactionData.getReactionCounts().get(reaction.getType());
            if (i == null) {
                i = 1;
            }
            int intValue = i.intValue() - 1;
            if (intValue > 0) {
                reactionData.getReactionCounts().put(reaction.getType(), Integer.valueOf(intValue));
            } else {
                reactionData.getReactionCounts().remove(reaction.getType());
            }
            int i2 = reactionData.getReactionScores().get(reaction.getType());
            if (i2 == null) {
                i2 = 1;
            }
            int intValue2 = i2.intValue() - reaction.getScore();
            if (intValue2 > 0) {
                reactionData.getReactionScores().put(reaction.getType(), Integer.valueOf(intValue2));
            } else {
                reactionData.getReactionScores().remove(reaction.getType());
            }
        }
        message.setReactionCounts(reactionData.getReactionCounts());
        message.setReactionScores(reactionData.getReactionScores());
        message.setLatestReactions(reactionData.getLatestReactions());
        message.setOwnReactions(reactionData.getOwnReactions());
    }
}

package p015io.getstream.chat.android.livedata.repository.domain.message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentMapperKt;
import p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a}\u0010\u0003\u001a\u00020\u0002*\u00020\u000121\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000523\u0010\r\u001a/\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, mo26107d2 = {"toEntity", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageEntity;", "Lio/getstream/chat/android/client/models/Message;", "toModel", "getUser", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/User;", "", "getMessage", "messageId", "(Lio/getstream/chat/android/livedata/repository/domain/message/MessageEntity;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt */
/* compiled from: MessageMapper.kt */
public final class MessageMapperKt {
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0426, code lost:
        r4 = (p015io.getstream.chat.android.client.models.User) r4;
        r10 = r8.getText();
        r11 = r7.getAttachments();
        r12 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, 10));
        r11 = r11.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0447, code lost:
        if (r11.hasNext() == false) goto L_0x0457;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0449, code lost:
        r12.add(p015io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentMapperKt.toModel((p015io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity) r11.next()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0457, code lost:
        r11 = kotlin.collections.CollectionsKt.toMutableList((java.util.List) r12);
        r12 = r8.getType();
        r13 = r8.getReplyCount();
        r14 = r8.getCreatedAt();
        r15 = r8.getCreatedLocallyAt();
        r17 = r8.getUpdatedAt();
        r20 = r8.getUpdatedLocallyAt();
        r21 = r8.getDeletedAt();
        r22 = r8.getParentId();
        r23 = r8.getCommand();
        r24 = kotlin.collections.MapsKt.toMutableMap(r8.getExtraData());
        r25 = kotlin.collections.MapsKt.toMutableMap(r8.getReactionCounts());
        r26 = kotlin.collections.MapsKt.toMutableMap(r8.getReactionScores());
        r27 = r8.getSyncStatus();
        r28 = r8.getShadowed();
        r9 = r7.getLatestReactions();
        r76 = r0;
        r77 = r1;
        r29 = r2;
        r1 = r9.iterator();
        r2 = r27;
        r9 = r29;
        r27 = r22;
        r29 = r24;
        r22 = r14;
        r24 = r17;
        r14 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, 10));
        r0 = r1;
        r17 = r3;
        r3 = r76;
        r1 = r77;
        r73 = r20;
        r20 = r13;
        r13 = r25;
        r25 = r73;
        r74 = r23;
        r23 = r15;
        r15 = r26;
        r26 = r21;
        r21 = r28;
        r28 = r74;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x04ee, code lost:
        if (r0.hasNext() == false) goto L_0x057d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x04f0, code lost:
        r76 = r13;
        r9.L$0 = r7;
        r9.L$1 = r3;
        r9.L$2 = r6;
        r9.L$3 = r8;
        r9.L$4 = r5;
        r9.L$5 = r1;
        r9.L$6 = r4;
        r9.L$7 = r10;
        r9.L$8 = r14;
        r9.L$9 = r0;
        r9.L$10 = r11;
        r9.L$11 = r12;
        r9.L$12 = r2;
        r9.L$13 = r15;
        r77 = r0;
        r9.L$14 = r76;
        r9.L$15 = r29;
        r9.L$16 = r28;
        r9.L$17 = r27;
        r9.L$18 = r26;
        r9.L$19 = r25;
        r9.L$20 = r24;
        r9.L$21 = r23;
        r9.L$22 = r22;
        r9.L$23 = r14;
        r9.Z$0 = r21;
        r9.I$0 = r20;
        r9.label = 2;
        r0 = p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt.toModel((p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity) r0.next(), r3, r9);
        r13 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x054f, code lost:
        if (r0 != r13) goto L_0x0552;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0551, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0552, code lost:
        r17 = r13;
        r31 = r28;
        r32 = r29;
        r13 = r76;
        r28 = r26;
        r29 = r27;
        r26 = r5;
        r5 = r14;
        r27 = r25;
        r25 = r1;
        r1 = r0;
        r0 = r77;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0568, code lost:
        r5.add((p015io.getstream.chat.android.client.models.Reaction) r1);
        r1 = r25;
        r5 = r26;
        r25 = r27;
        r26 = r28;
        r27 = r29;
        r28 = r31;
        r29 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x057d, code lost:
        r76 = r13;
        r0 = kotlin.collections.CollectionsKt.toMutableList(r14);
        r7 = r7.getOwnReactions();
        r77 = r0;
        r0 = r7.iterator();
        r7 = r6;
        r1 = r1;
        r6 = r3;
        r17 = r17;
        r13 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, 10));
        r14 = r76;
        r3 = r2;
        r2 = r29;
        r29 = r28;
        r28 = r27;
        r27 = r26;
        r26 = r25;
        r25 = r24;
        r24 = r23;
        r23 = r22;
        r22 = r77;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x05c4, code lost:
        if (r0.hasNext() == false) goto L_0x064f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x05c6, code lost:
        r32 = r2;
        r9.L$0 = r6;
        r9.L$1 = r7;
        r9.L$2 = r8;
        r9.L$3 = r5;
        r9.L$4 = r1;
        r9.L$5 = r4;
        r9.L$6 = r10;
        r9.L$7 = r13;
        r9.L$8 = r0;
        r9.L$9 = r11;
        r9.L$10 = r12;
        r9.L$11 = r3;
        r9.L$12 = r15;
        r9.L$13 = r14;
        r76 = r0;
        r9.L$14 = r32;
        r9.L$15 = r29;
        r9.L$16 = r28;
        r9.L$17 = r27;
        r9.L$18 = r26;
        r9.L$19 = r25;
        r9.L$20 = r24;
        r9.L$21 = r23;
        r9.L$22 = r22;
        r9.L$23 = r13;
        r9.Z$0 = r21;
        r9.I$0 = r20;
        r9.label = 3;
        r0 = p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt.toModel((p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity) r0.next(), r6, r9);
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0625, code lost:
        if (r0 != r2) goto L_0x0628;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0627, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0628, code lost:
        r17 = r2;
        r31 = r28;
        r2 = r32;
        r28 = r26;
        r32 = r29;
        r26 = r1;
        r29 = r27;
        r1 = r0;
        r27 = r5;
        r5 = r13;
        r0 = r76;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x063c, code lost:
        r5.add((p015io.getstream.chat.android.client.models.Reaction) r1);
        r1 = r26;
        r5 = r27;
        r26 = r28;
        r27 = r29;
        r28 = r31;
        r29 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x064f, code lost:
        r32 = r2;
        r0 = kotlin.collections.CollectionsKt.toMutableList(r13);
        r13 = r8.getMentionedUsersId();
        r31 = r17;
        r38 = r0;
        r2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, 10));
        r0 = r13.iterator();
        r13 = r9;
        r1 = r1;
        r35 = r20;
        r36 = r21;
        r39 = r22;
        r40 = r23;
        r41 = r24;
        r42 = r25;
        r43 = r26;
        r44 = r27;
        r37 = r28;
        r17 = r29;
        r33 = r31;
        r34 = 0;
        r9 = r7;
        r7 = r6;
        r6 = r3;
        r3 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x06a0, code lost:
        if (r0.hasNext() == false) goto L_0x075c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x06a2, code lost:
        r13.L$0 = r7;
        r13.L$1 = r9;
        r13.L$2 = r8;
        r13.L$3 = r5;
        r13.L$4 = r1;
        r13.L$5 = r4;
        r13.L$6 = r10;
        r13.L$7 = r2;
        r13.L$8 = r0;
        r13.L$9 = r11;
        r13.L$10 = r12;
        r13.L$11 = r6;
        r13.L$12 = r15;
        r13.L$13 = r14;
        r76 = r0;
        r0 = r3;
        r13.L$14 = r0;
        r20 = r9;
        r13.L$15 = r17;
        r9 = r37;
        r13.L$16 = r9;
        r21 = r9;
        r9 = r44;
        r13.L$17 = r9;
        r22 = r9;
        r9 = r43;
        r13.L$18 = r9;
        r23 = r9;
        r9 = r42;
        r13.L$19 = r9;
        r24 = r9;
        r9 = r41;
        r13.L$20 = r9;
        r25 = r9;
        r9 = r40;
        r13.L$21 = r9;
        r26 = r9;
        r9 = r39;
        r13.L$22 = r9;
        r27 = r9;
        r9 = r38;
        r13.L$23 = r9;
        r13.L$24 = r2;
        r28 = r9;
        r9 = r36;
        r13.Z$0 = r9;
        r29 = r9;
        r9 = r35;
        r13.I$0 = r9;
        r31 = r9;
        r9 = r34;
        r13.I$1 = r9;
        r32 = r9;
        r13.label = 4;
        kotlin.jvm.internal.InlineMarker.mark(6);
        r3 = r7.invoke((java.lang.String) r0.next(), r13);
        kotlin.jvm.internal.InlineMarker.mark(7);
        r9 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0729, code lost:
        if (r3 != r9) goto L_0x072c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x072b, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x072c, code lost:
        r33 = r9;
        r37 = r21;
        r44 = r22;
        r43 = r23;
        r42 = r24;
        r41 = r25;
        r40 = r26;
        r39 = r27;
        r38 = r28;
        r36 = r29;
        r35 = r31;
        r34 = r32;
        r28 = r1;
        r1 = r3;
        r9 = r8;
        r31 = r20;
        r3 = r0;
        r8 = r7;
        r0 = r76;
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x074f, code lost:
        r7.add((p015io.getstream.chat.android.client.models.User) r1);
        r7 = r8;
        r8 = r9;
        r1 = r28;
        r9 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x075c, code lost:
        r0 = r3;
        r20 = r9;
        r9 = r33;
        r32 = r34;
        r31 = r35;
        r29 = r36;
        r21 = r37;
        r28 = r38;
        r27 = r39;
        r26 = r40;
        r25 = r41;
        r24 = r42;
        r23 = r43;
        r22 = r44;
        r2 = kotlin.collections.CollectionsKt.toMutableList(r2);
        r3 = r8.getReplyToId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0783, code lost:
        if (r3 == null) goto L_0x083e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0785, code lost:
        r13.L$0 = r7;
        r13.L$1 = r8;
        r13.L$2 = r5;
        r13.L$3 = r1;
        r13.L$4 = r4;
        r13.L$5 = r10;
        r13.L$6 = r11;
        r13.L$7 = r12;
        r13.L$8 = r6;
        r13.L$9 = r15;
        r13.L$10 = r14;
        r13.L$11 = r0;
        r33 = r0;
        r13.L$12 = r17;
        r13.L$13 = r21;
        r13.L$14 = r22;
        r13.L$15 = r23;
        r13.L$16 = r24;
        r13.L$17 = r25;
        r13.L$18 = r26;
        r13.L$19 = r27;
        r13.L$20 = r28;
        r13.L$21 = r2;
        r13.L$22 = null;
        r13.L$23 = null;
        r13.L$24 = null;
        r13.Z$0 = r29;
        r13.I$0 = r31;
        r13.I$1 = r32;
        r13.I$2 = 0;
        r13.label = 5;
        kotlin.jvm.internal.InlineMarker.mark(6);
        r0 = r20.invoke(r3, r13);
        kotlin.jvm.internal.InlineMarker.mark(7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x07ec, code lost:
        if (r0 != r9) goto L_0x07ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x07ee, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x07ef, code lost:
        r3 = r9;
        r9 = r21;
        r20 = r23;
        r19 = 0;
        r21 = r6;
        r23 = r11;
        r11 = r27;
        r6 = r29;
        r27 = r5;
        r5 = r31;
        r73 = r1;
        r1 = r0;
        r0 = r73;
        r74 = r8;
        r8 = r2;
        r2 = r13;
        r13 = r24;
        r24 = r10;
        r10 = r28;
        r28 = r74;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0813, code lost:
        r35 = r5;
        r36 = r6;
        r37 = r9;
        r38 = r10;
        r39 = r11;
        r42 = r13;
        r43 = r20;
        r6 = r21;
        r44 = r22;
        r11 = r23;
        r10 = r24;
        r41 = r25;
        r40 = r26;
        r34 = r32;
        r5 = (p015io.getstream.chat.android.client.models.Message) r1;
        r13 = r2;
        r2 = r8;
        r8 = r28;
        r1 = r0;
        r73 = r33;
        r33 = r3;
        r3 = r73;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x083e, code lost:
        r36 = r29;
        r37 = r21;
        r44 = r22;
        r43 = r23;
        r42 = r24;
        r41 = r25;
        r40 = r26;
        r39 = r27;
        r38 = r28;
        r35 = r31;
        r34 = r32;
        r3 = r0;
        r19 = 0;
        r27 = r5;
        r33 = r9;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0860, code lost:
        r0 = r8.getThreadParticipantsIds();
        r0 = r0.iterator();
        r22 = r2;
        r72 = r5;
        r5 = r12;
        r2 = r15;
        r9 = r17;
        r17 = r33;
        r20 = r34;
        r21 = r35;
        r71 = r36;
        r23 = r38;
        r24 = r39;
        r25 = r40;
        r70 = r41;
        r26 = r42;
        r28 = r44;
        r18 = 0;
        r15 = r4;
        r4 = r6;
        r12 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, 10));
        r6 = r27;
        r8 = r37;
        r27 = r43;
        r73 = r14;
        r14 = r3;
        r3 = r73;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x08b7, code lost:
        if (r0.hasNext() == false) goto L_0x09a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x08b9, code lost:
        r13.L$0 = r7;
        r13.L$1 = r6;
        r13.L$2 = r1;
        r13.L$3 = r15;
        r13.L$4 = r10;
        r13.L$5 = r12;
        r13.L$6 = r0;
        r13.L$7 = r11;
        r13.L$8 = r5;
        r13.L$9 = r4;
        r13.L$10 = r2;
        r13.L$11 = r3;
        r13.L$12 = r14;
        r13.L$13 = r9;
        r76 = r0;
        r0 = r8;
        r13.L$14 = r0;
        r29 = r14;
        r14 = r28;
        r13.L$15 = r14;
        r28 = r15;
        r13.L$16 = r27;
        r15 = r26;
        r13.L$17 = r15;
        r26 = r14;
        r14 = r70;
        r13.L$18 = r14;
        r52 = r14;
        r14 = r25;
        r13.L$19 = r14;
        r25 = r15;
        r15 = r24;
        r13.L$20 = r15;
        r24 = r14;
        r13.L$21 = r23;
        r14 = r22;
        r13.L$22 = r14;
        r22 = r15;
        r15 = r72;
        r13.L$23 = r15;
        r13.L$24 = r12;
        r60 = r15;
        r15 = r71;
        r13.Z$0 = r15;
        r56 = r15;
        r15 = r21;
        r13.I$0 = r15;
        r21 = r5;
        r5 = r20;
        r13.I$1 = r5;
        r20 = r4;
        r4 = r19;
        r13.I$2 = r4;
        r19 = r2;
        r2 = r18;
        r13.I$3 = r2;
        r18 = r3;
        r13.label = 6;
        kotlin.jvm.internal.InlineMarker.mark(6);
        r8 = r7.invoke((java.lang.String) r0.next(), r13);
        kotlin.jvm.internal.InlineMarker.mark(7);
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x094a, code lost:
        if (r8 != r3) goto L_0x094d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x094c, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x094d, code lost:
        r17 = r3;
        r3 = r18;
        r31 = r26;
        r70 = r52;
        r71 = r56;
        r72 = r60;
        r18 = r2;
        r26 = r24;
        r2 = r1;
        r1 = r8;
        r24 = r23;
        r8 = r0;
        r23 = r14;
        r14 = r29;
        r0 = r76;
        r29 = r27;
        r27 = r12;
        r73 = r20;
        r20 = r4;
        r4 = r73;
        r74 = r21;
        r21 = r5;
        r5 = r74;
        r75 = r22;
        r22 = r15;
        r15 = r28;
        r28 = r25;
        r25 = r75;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0982, code lost:
        r12.add((p015io.getstream.chat.android.client.models.User) r1);
        r1 = r2;
        r2 = r19;
        r19 = r20;
        r20 = r21;
        r21 = r22;
        r22 = r23;
        r23 = r24;
        r24 = r25;
        r25 = r26;
        r12 = r27;
        r26 = r28;
        r27 = r29;
        r28 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x09a2, code lost:
        r0 = r8;
        r29 = r14;
        r14 = r22;
        r22 = r24;
        r24 = r25;
        r25 = r26;
        r26 = r28;
        r52 = r70;
        r56 = r71;
        r60 = r72;
        r28 = r15;
        r15 = r21;
        r21 = r5;
        r5 = r20;
        r20 = r4;
        r4 = r19;
        r19 = r2;
        r2 = r18;
        r18 = r3;
        r66 = (java.util.List) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x09d4, code lost:
        if (r5 == 0) goto L_0x09d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x09d6, code lost:
        r55 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x09d9, code lost:
        r55 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x09db, code lost:
        if (r4 == 0) goto L_0x09e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x09dd, code lost:
        r58 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x09e0, code lost:
        r58 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x09e2, code lost:
        if (r2 == 0) goto L_0x09e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x09e4, code lost:
        r62 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x09e7, code lost:
        r62 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0a16, code lost:
        return new p015io.getstream.chat.android.client.models.Message(r1, r6, r10, (java.lang.String) null, r0, r9, r11, (java.util.List) null, r14, r15, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r52, r28, r29, r55, r56, (java.util.Map) null, r58, (p015io.getstream.chat.android.client.models.ChannelInfo) null, r60, (java.lang.String) null, r62, (java.util.Date) null, (java.util.Date) null, (p015io.getstream.chat.android.client.models.User) null, r66, -293601144, 3, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x03c4  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object toModel(p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r76, kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.User>, ? extends java.lang.Object> r77, kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Message>, ? extends java.lang.Object> r78, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Message> r79) {
        /*
            r0 = r77
            r1 = r79
            boolean r2 = r1 instanceof p015io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt$toModel$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt$toModel$1 r2 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt$toModel$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt$toModel$1 r2 = new io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt$toModel$1
            r2.<init>(r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            switch(r4) {
                case 0: goto L_0x03ea;
                case 1: goto L_0x03c4;
                case 2: goto L_0x0316;
                case 3: goto L_0x0263;
                case 4: goto L_0x01a2;
                case 5: goto L_0x0103;
                case 6: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            int r0 = r2.I$3
            int r4 = r2.I$2
            int r5 = r2.I$1
            int r8 = r2.I$0
            boolean r11 = r2.Z$0
            java.lang.Object r12 = r2.L$24
            java.util.Collection r12 = (java.util.Collection) r12
            java.lang.Object r13 = r2.L$23
            io.getstream.chat.android.client.models.Message r13 = (p015io.getstream.chat.android.client.models.Message) r13
            java.lang.Object r14 = r2.L$22
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r15 = r2.L$21
            java.util.List r15 = (java.util.List) r15
            java.lang.Object r10 = r2.L$20
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r6 = r2.L$19
            java.util.Date r6 = (java.util.Date) r6
            java.lang.Object r9 = r2.L$18
            java.util.Date r9 = (java.util.Date) r9
            java.lang.Object r7 = r2.L$17
            java.util.Date r7 = (java.util.Date) r7
            r76 = r0
            java.lang.Object r0 = r2.L$16
            java.util.Date r0 = (java.util.Date) r0
            r77 = r0
            java.lang.Object r0 = r2.L$15
            java.util.Date r0 = (java.util.Date) r0
            r78 = r0
            java.lang.Object r0 = r2.L$14
            java.lang.String r0 = (java.lang.String) r0
            r18 = r0
            java.lang.Object r0 = r2.L$13
            java.lang.String r0 = (java.lang.String) r0
            r19 = r0
            java.lang.Object r0 = r2.L$12
            java.util.Map r0 = (java.util.Map) r0
            r20 = r0
            java.lang.Object r0 = r2.L$11
            java.util.Map r0 = (java.util.Map) r0
            r21 = r0
            java.lang.Object r0 = r2.L$10
            java.util.Map r0 = (java.util.Map) r0
            r22 = r0
            java.lang.Object r0 = r2.L$9
            io.getstream.chat.android.client.utils.SyncStatus r0 = (p015io.getstream.chat.android.client.utils.SyncStatus) r0
            r23 = r0
            java.lang.Object r0 = r2.L$8
            java.lang.String r0 = (java.lang.String) r0
            r24 = r0
            java.lang.Object r0 = r2.L$7
            java.util.List r0 = (java.util.List) r0
            r25 = r0
            java.lang.Object r0 = r2.L$6
            java.util.Iterator r0 = (java.util.Iterator) r0
            r26 = r0
            java.lang.Object r0 = r2.L$5
            java.util.Collection r0 = (java.util.Collection) r0
            r27 = r0
            java.lang.Object r0 = r2.L$4
            java.lang.String r0 = (java.lang.String) r0
            r28 = r0
            java.lang.Object r0 = r2.L$3
            io.getstream.chat.android.client.models.User r0 = (p015io.getstream.chat.android.client.models.User) r0
            r29 = r0
            java.lang.Object r0 = r2.L$2
            java.lang.String r0 = (java.lang.String) r0
            r30 = r0
            java.lang.Object r0 = r2.L$1
            java.lang.String r0 = (java.lang.String) r0
            r31 = r0
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            kotlin.ResultKt.throwOnFailure(r1)
            r17 = r3
            r70 = r9
            r71 = r11
            r72 = r13
            r9 = r19
            r3 = r21
            r19 = r22
            r11 = r25
            r16 = 7
            r13 = r2
            r21 = r5
            r22 = r8
            r25 = r10
            r8 = r18
            r5 = r24
            r10 = r28
            r2 = r30
            r18 = r76
            r28 = r7
            r24 = r15
            r15 = r29
            r29 = r77
            r7 = r0
            r0 = r26
            r26 = r6
            r6 = r31
            r31 = r78
            r73 = r20
            r20 = r4
            r4 = r23
            r23 = r14
            r14 = r73
            goto L_0x0982
        L_0x0103:
            int r0 = r2.I$2
            int r4 = r2.I$1
            int r5 = r2.I$0
            boolean r6 = r2.Z$0
            java.lang.Object r7 = r2.L$21
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r9 = r2.L$20
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r2.L$19
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r2.L$18
            java.util.Date r11 = (java.util.Date) r11
            java.lang.Object r12 = r2.L$17
            java.util.Date r12 = (java.util.Date) r12
            java.lang.Object r13 = r2.L$16
            java.util.Date r13 = (java.util.Date) r13
            java.lang.Object r14 = r2.L$15
            java.util.Date r14 = (java.util.Date) r14
            java.lang.Object r15 = r2.L$14
            java.util.Date r15 = (java.util.Date) r15
            java.lang.Object r8 = r2.L$13
            java.lang.String r8 = (java.lang.String) r8
            r19 = r0
            java.lang.Object r0 = r2.L$12
            java.lang.String r0 = (java.lang.String) r0
            r76 = r0
            java.lang.Object r0 = r2.L$11
            java.util.Map r0 = (java.util.Map) r0
            r77 = r0
            java.lang.Object r0 = r2.L$10
            java.util.Map r0 = (java.util.Map) r0
            r78 = r0
            java.lang.Object r0 = r2.L$9
            java.util.Map r0 = (java.util.Map) r0
            r20 = r0
            java.lang.Object r0 = r2.L$8
            io.getstream.chat.android.client.utils.SyncStatus r0 = (p015io.getstream.chat.android.client.utils.SyncStatus) r0
            r21 = r0
            java.lang.Object r0 = r2.L$7
            java.lang.String r0 = (java.lang.String) r0
            r22 = r0
            java.lang.Object r0 = r2.L$6
            java.util.List r0 = (java.util.List) r0
            r23 = r0
            java.lang.Object r0 = r2.L$5
            java.lang.String r0 = (java.lang.String) r0
            r24 = r0
            java.lang.Object r0 = r2.L$4
            io.getstream.chat.android.client.models.User r0 = (p015io.getstream.chat.android.client.models.User) r0
            r25 = r0
            java.lang.Object r0 = r2.L$3
            java.lang.String r0 = (java.lang.String) r0
            r26 = r0
            java.lang.Object r0 = r2.L$2
            java.lang.String r0 = (java.lang.String) r0
            r27 = r0
            java.lang.Object r0 = r2.L$1
            io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity) r0
            r28 = r0
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            kotlin.ResultKt.throwOnFailure(r1)
            r17 = r76
            r33 = r77
            r32 = r4
            r4 = r25
            r25 = r12
            r12 = r22
            r22 = r15
            r15 = r20
            r20 = r14
            r14 = r78
            r73 = r7
            r7 = r0
            r0 = r26
            r26 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r73
            goto L_0x0813
        L_0x01a2:
            int r0 = r2.I$1
            int r4 = r2.I$0
            boolean r6 = r2.Z$0
            java.lang.Object r7 = r2.L$24
            java.util.Collection r7 = (java.util.Collection) r7
            java.lang.Object r8 = r2.L$23
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r2.L$22
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r2.L$21
            java.util.Date r10 = (java.util.Date) r10
            java.lang.Object r11 = r2.L$20
            java.util.Date r11 = (java.util.Date) r11
            java.lang.Object r12 = r2.L$19
            java.util.Date r12 = (java.util.Date) r12
            java.lang.Object r13 = r2.L$18
            java.util.Date r13 = (java.util.Date) r13
            java.lang.Object r14 = r2.L$17
            java.util.Date r14 = (java.util.Date) r14
            java.lang.Object r15 = r2.L$16
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r5 = r2.L$15
            java.lang.String r5 = (java.lang.String) r5
            r20 = r0
            java.lang.Object r0 = r2.L$14
            java.util.Map r0 = (java.util.Map) r0
            r76 = r0
            java.lang.Object r0 = r2.L$13
            java.util.Map r0 = (java.util.Map) r0
            r77 = r0
            java.lang.Object r0 = r2.L$12
            java.util.Map r0 = (java.util.Map) r0
            r78 = r0
            java.lang.Object r0 = r2.L$11
            io.getstream.chat.android.client.utils.SyncStatus r0 = (p015io.getstream.chat.android.client.utils.SyncStatus) r0
            r21 = r0
            java.lang.Object r0 = r2.L$10
            java.lang.String r0 = (java.lang.String) r0
            r22 = r0
            java.lang.Object r0 = r2.L$9
            java.util.List r0 = (java.util.List) r0
            r23 = r0
            java.lang.Object r0 = r2.L$8
            java.util.Iterator r0 = (java.util.Iterator) r0
            r24 = r0
            java.lang.Object r0 = r2.L$7
            java.util.Collection r0 = (java.util.Collection) r0
            r25 = r0
            java.lang.Object r0 = r2.L$6
            java.lang.String r0 = (java.lang.String) r0
            r26 = r0
            java.lang.Object r0 = r2.L$5
            io.getstream.chat.android.client.models.User r0 = (p015io.getstream.chat.android.client.models.User) r0
            r27 = r0
            java.lang.Object r0 = r2.L$4
            java.lang.String r0 = (java.lang.String) r0
            r28 = r0
            java.lang.Object r0 = r2.L$3
            java.lang.String r0 = (java.lang.String) r0
            r29 = r0
            java.lang.Object r0 = r2.L$2
            io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity) r0
            r30 = r0
            java.lang.Object r0 = r2.L$1
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r31 = r0
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            kotlin.ResultKt.throwOnFailure(r1)
            r33 = r3
            r35 = r4
            r17 = r5
            r36 = r6
            r38 = r8
            r39 = r9
            r40 = r10
            r41 = r11
            r42 = r12
            r43 = r13
            r44 = r14
            r37 = r15
            r34 = r20
            r6 = r21
            r12 = r22
            r11 = r23
            r10 = r26
            r4 = r27
            r5 = r29
            r9 = r30
            r3 = r76
            r14 = r77
            r15 = r78
            r8 = r0
            r13 = r2
            r0 = r24
            r2 = r25
            goto L_0x074f
        L_0x0263:
            int r0 = r2.I$0
            boolean r4 = r2.Z$0
            java.lang.Object r5 = r2.L$23
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r6 = r2.L$22
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r2.L$21
            java.util.Date r7 = (java.util.Date) r7
            java.lang.Object r8 = r2.L$20
            java.util.Date r8 = (java.util.Date) r8
            java.lang.Object r9 = r2.L$19
            java.util.Date r9 = (java.util.Date) r9
            java.lang.Object r10 = r2.L$18
            java.util.Date r10 = (java.util.Date) r10
            java.lang.Object r11 = r2.L$17
            java.util.Date r11 = (java.util.Date) r11
            java.lang.Object r12 = r2.L$16
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r2.L$15
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r2.L$14
            java.util.Map r14 = (java.util.Map) r14
            java.lang.Object r15 = r2.L$13
            java.util.Map r15 = (java.util.Map) r15
            r20 = r0
            java.lang.Object r0 = r2.L$12
            java.util.Map r0 = (java.util.Map) r0
            r76 = r0
            java.lang.Object r0 = r2.L$11
            io.getstream.chat.android.client.utils.SyncStatus r0 = (p015io.getstream.chat.android.client.utils.SyncStatus) r0
            r77 = r0
            java.lang.Object r0 = r2.L$10
            java.lang.String r0 = (java.lang.String) r0
            r78 = r0
            java.lang.Object r0 = r2.L$9
            java.util.List r0 = (java.util.List) r0
            r21 = r0
            java.lang.Object r0 = r2.L$8
            java.util.Iterator r0 = (java.util.Iterator) r0
            r22 = r0
            java.lang.Object r0 = r2.L$7
            java.util.Collection r0 = (java.util.Collection) r0
            r23 = r0
            java.lang.Object r0 = r2.L$6
            java.lang.String r0 = (java.lang.String) r0
            r24 = r0
            java.lang.Object r0 = r2.L$5
            io.getstream.chat.android.client.models.User r0 = (p015io.getstream.chat.android.client.models.User) r0
            r25 = r0
            java.lang.Object r0 = r2.L$4
            java.lang.String r0 = (java.lang.String) r0
            r26 = r0
            java.lang.Object r0 = r2.L$3
            java.lang.String r0 = (java.lang.String) r0
            r27 = r0
            java.lang.Object r0 = r2.L$2
            io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity) r0
            r28 = r0
            java.lang.Object r0 = r2.L$1
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r29 = r0
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            kotlin.ResultKt.throwOnFailure(r1)
            r17 = r3
            r31 = r12
            r32 = r13
            r13 = r23
            r3 = r77
            r12 = r78
            r23 = r7
            r7 = r29
            r29 = r11
            r11 = r21
            r21 = r4
            r4 = r25
            r25 = r9
            r9 = r2
            r2 = r14
            r14 = r15
            r15 = r76
            r73 = r6
            r6 = r0
            r0 = r22
            r22 = r73
            r74 = r24
            r24 = r8
            r8 = r28
            r28 = r10
            r10 = r74
            goto L_0x063c
        L_0x0316:
            int r0 = r2.I$0
            boolean r4 = r2.Z$0
            java.lang.Object r5 = r2.L$23
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r6 = r2.L$22
            java.util.Date r6 = (java.util.Date) r6
            java.lang.Object r7 = r2.L$21
            java.util.Date r7 = (java.util.Date) r7
            java.lang.Object r8 = r2.L$20
            java.util.Date r8 = (java.util.Date) r8
            java.lang.Object r9 = r2.L$19
            java.util.Date r9 = (java.util.Date) r9
            java.lang.Object r10 = r2.L$18
            java.util.Date r10 = (java.util.Date) r10
            java.lang.Object r11 = r2.L$17
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r2.L$16
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r2.L$15
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Object r14 = r2.L$14
            java.util.Map r14 = (java.util.Map) r14
            java.lang.Object r15 = r2.L$13
            java.util.Map r15 = (java.util.Map) r15
            r20 = r0
            java.lang.Object r0 = r2.L$12
            io.getstream.chat.android.client.utils.SyncStatus r0 = (p015io.getstream.chat.android.client.utils.SyncStatus) r0
            r76 = r0
            java.lang.Object r0 = r2.L$11
            java.lang.String r0 = (java.lang.String) r0
            r77 = r0
            java.lang.Object r0 = r2.L$10
            java.util.List r0 = (java.util.List) r0
            r78 = r0
            java.lang.Object r0 = r2.L$9
            java.util.Iterator r0 = (java.util.Iterator) r0
            r21 = r0
            java.lang.Object r0 = r2.L$8
            java.util.Collection r0 = (java.util.Collection) r0
            r22 = r0
            java.lang.Object r0 = r2.L$7
            java.lang.String r0 = (java.lang.String) r0
            r23 = r0
            java.lang.Object r0 = r2.L$6
            io.getstream.chat.android.client.models.User r0 = (p015io.getstream.chat.android.client.models.User) r0
            r24 = r0
            java.lang.Object r0 = r2.L$5
            java.lang.String r0 = (java.lang.String) r0
            r25 = r0
            java.lang.Object r0 = r2.L$4
            java.lang.String r0 = (java.lang.String) r0
            r26 = r0
            java.lang.Object r0 = r2.L$3
            io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity) r0
            r27 = r0
            java.lang.Object r0 = r2.L$2
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r28 = r0
            java.lang.Object r0 = r2.L$1
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r29 = r0
            java.lang.Object r0 = r2.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r0 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r0
            kotlin.ResultKt.throwOnFailure(r1)
            r17 = r3
            r31 = r12
            r32 = r13
            r13 = r14
            r14 = r22
            r3 = r29
            r12 = r77
            r22 = r6
            r29 = r11
            r6 = r28
            r11 = r78
            r28 = r10
            r10 = r23
            r23 = r7
            r7 = r0
            r0 = r21
            r21 = r4
            r4 = r24
            r24 = r8
            r8 = r27
            r27 = r9
            r9 = r2
            r2 = r76
            goto L_0x0568
        L_0x03c4:
            java.lang.Object r0 = r2.L$5
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r4 = r2.L$4
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.L$3
            io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r5 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity) r5
            java.lang.Object r6 = r2.L$2
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            java.lang.Object r7 = r2.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r2.L$0
            io.getstream.chat.android.livedata.repository.domain.message.MessageEntity r8 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageEntity) r8
            kotlin.ResultKt.throwOnFailure(r1)
            r9 = 1
            r73 = r1
            r1 = r0
            r0 = r7
            r7 = r8
            r8 = r5
            r5 = r4
            r4 = r73
            goto L_0x0426
        L_0x03ea:
            kotlin.ResultKt.throwOnFailure(r1)
            io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity r5 = r76.getMessageInnerEntity()
            java.lang.String r1 = r5.getId()
            java.lang.String r4 = r5.getCid()
            java.lang.String r6 = r5.getUserId()
            r7 = r76
            r2.L$0 = r7
            r2.L$1 = r0
            r8 = r78
            r2.L$2 = r8
            r2.L$3 = r5
            r2.L$4 = r4
            r2.L$5 = r1
            r9 = 1
            r2.label = r9
            r10 = 6
            kotlin.jvm.internal.InlineMarker.mark((int) r10)
            java.lang.Object r6 = r0.invoke(r6, r2)
            r10 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r10)
            if (r6 != r3) goto L_0x041f
            return r3
        L_0x041f:
            r73 = r5
            r5 = r4
            r4 = r6
            r6 = r8
            r8 = r73
        L_0x0426:
            io.getstream.chat.android.client.models.User r4 = (p015io.getstream.chat.android.client.models.User) r4
            java.lang.String r10 = r8.getText()
            java.util.List r11 = r7.getAttachments()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r12 = new java.util.ArrayList
            r13 = 10
            int r14 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r13)
            r12.<init>(r14)
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r11 = r11.iterator()
        L_0x0443:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x0457
            java.lang.Object r13 = r11.next()
            io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity r13 = (p015io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity) r13
            io.getstream.chat.android.client.models.Attachment r13 = p015io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentMapperKt.toModel((p015io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity) r13)
            r12.add(r13)
            goto L_0x0443
        L_0x0457:
            java.util.List r12 = (java.util.List) r12
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.List r11 = kotlin.collections.CollectionsKt.toMutableList(r12)
            java.lang.String r12 = r8.getType()
            int r13 = r8.getReplyCount()
            java.util.Date r14 = r8.getCreatedAt()
            java.util.Date r15 = r8.getCreatedLocallyAt()
            java.util.Date r17 = r8.getUpdatedAt()
            java.util.Date r20 = r8.getUpdatedLocallyAt()
            java.util.Date r21 = r8.getDeletedAt()
            java.lang.String r22 = r8.getParentId()
            java.lang.String r23 = r8.getCommand()
            java.util.Map r24 = r8.getExtraData()
            java.util.Map r24 = kotlin.collections.MapsKt.toMutableMap(r24)
            java.util.Map r25 = r8.getReactionCounts()
            java.util.Map r25 = kotlin.collections.MapsKt.toMutableMap(r25)
            java.util.Map r26 = r8.getReactionScores()
            java.util.Map r26 = kotlin.collections.MapsKt.toMutableMap(r26)
            io.getstream.chat.android.client.utils.SyncStatus r27 = r8.getSyncStatus()
            boolean r28 = r8.getShadowed()
            java.util.List r29 = r7.getLatestReactions()
            r9 = r29
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            r76 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r77 = r1
            r29 = r2
            r1 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r1)
            r0.<init>(r2)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r9.iterator()
            r2 = r27
            r9 = r29
            r27 = r22
            r29 = r24
            r22 = r14
            r24 = r17
            r14 = r0
            r0 = r1
            r17 = r3
            r3 = r76
            r1 = r77
            r73 = r20
            r20 = r13
            r13 = r25
            r25 = r73
            r74 = r23
            r23 = r15
            r15 = r26
            r26 = r21
            r21 = r28
            r28 = r74
        L_0x04ea:
            boolean r31 = r0.hasNext()
            if (r31 == 0) goto L_0x057d
            java.lang.Object r31 = r0.next()
            r76 = r13
            r13 = r31
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity r13 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity) r13
            r9.L$0 = r7
            r9.L$1 = r3
            r9.L$2 = r6
            r9.L$3 = r8
            r9.L$4 = r5
            r9.L$5 = r1
            r9.L$6 = r4
            r9.L$7 = r10
            r9.L$8 = r14
            r9.L$9 = r0
            r9.L$10 = r11
            r9.L$11 = r12
            r9.L$12 = r2
            r9.L$13 = r15
            r77 = r0
            r0 = r76
            r9.L$14 = r0
            r0 = r29
            r9.L$15 = r0
            r0 = r28
            r9.L$16 = r0
            r0 = r27
            r9.L$17 = r0
            r0 = r26
            r9.L$18 = r0
            r0 = r25
            r9.L$19 = r0
            r0 = r24
            r9.L$20 = r0
            r0 = r23
            r9.L$21 = r0
            r0 = r22
            r9.L$22 = r0
            r9.L$23 = r14
            r0 = r21
            r9.Z$0 = r0
            r0 = r20
            r9.I$0 = r0
            r0 = 2
            r9.label = r0
            java.lang.Object r0 = p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt.toModel(r13, r3, r9)
            r13 = r17
            if (r0 != r13) goto L_0x0552
            return r13
        L_0x0552:
            r17 = r13
            r31 = r28
            r32 = r29
            r13 = r76
            r28 = r26
            r29 = r27
            r26 = r5
            r5 = r14
            r27 = r25
            r25 = r1
            r1 = r0
            r0 = r77
        L_0x0568:
            io.getstream.chat.android.client.models.Reaction r1 = (p015io.getstream.chat.android.client.models.Reaction) r1
            r5.add(r1)
            r1 = r25
            r5 = r26
            r25 = r27
            r26 = r28
            r27 = r29
            r28 = r31
            r29 = r32
            goto L_0x04ea
        L_0x057d:
            r76 = r13
            r13 = r17
            java.util.List r14 = (java.util.List) r14
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r14)
            java.util.List r7 = r7.getOwnReactions()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r14 = new java.util.ArrayList
            r77 = r0
            r17 = r1
            r0 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r0)
            r14.<init>(r1)
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r0 = r7.iterator()
            r7 = r6
            r1 = r17
            r6 = r3
            r17 = r13
            r13 = r14
            r14 = r76
            r3 = r2
            r2 = r29
            r29 = r28
            r28 = r27
            r27 = r26
            r26 = r25
            r25 = r24
            r24 = r23
            r23 = r22
            r22 = r77
        L_0x05c0:
            boolean r31 = r0.hasNext()
            if (r31 == 0) goto L_0x064f
            java.lang.Object r31 = r0.next()
            r32 = r2
            r2 = r31
            io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity r2 = (p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity) r2
            r9.L$0 = r6
            r9.L$1 = r7
            r9.L$2 = r8
            r9.L$3 = r5
            r9.L$4 = r1
            r9.L$5 = r4
            r9.L$6 = r10
            r9.L$7 = r13
            r9.L$8 = r0
            r9.L$9 = r11
            r9.L$10 = r12
            r9.L$11 = r3
            r9.L$12 = r15
            r9.L$13 = r14
            r76 = r0
            r0 = r32
            r9.L$14 = r0
            r0 = r29
            r9.L$15 = r0
            r0 = r28
            r9.L$16 = r0
            r0 = r27
            r9.L$17 = r0
            r0 = r26
            r9.L$18 = r0
            r0 = r25
            r9.L$19 = r0
            r0 = r24
            r9.L$20 = r0
            r0 = r23
            r9.L$21 = r0
            r0 = r22
            r9.L$22 = r0
            r9.L$23 = r13
            r0 = r21
            r9.Z$0 = r0
            r0 = r20
            r9.I$0 = r0
            r0 = 3
            r9.label = r0
            java.lang.Object r0 = p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt.toModel(r2, r6, r9)
            r2 = r17
            if (r0 != r2) goto L_0x0628
            return r2
        L_0x0628:
            r17 = r2
            r31 = r28
            r2 = r32
            r28 = r26
            r32 = r29
            r26 = r1
            r29 = r27
            r1 = r0
            r27 = r5
            r5 = r13
            r0 = r76
        L_0x063c:
            io.getstream.chat.android.client.models.Reaction r1 = (p015io.getstream.chat.android.client.models.Reaction) r1
            r5.add(r1)
            r1 = r26
            r5 = r27
            r26 = r28
            r27 = r29
            r28 = r31
            r29 = r32
            goto L_0x05c0
        L_0x064f:
            r32 = r2
            r2 = r17
            java.util.List r13 = (java.util.List) r13
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r13)
            java.util.List r13 = r8.getMentionedUsersId()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            r76 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r17 = r1
            r31 = r2
            r1 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r1)
            r0.<init>(r2)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r13.iterator()
            r38 = r76
            r2 = r0
            r0 = r1
            r13 = r9
            r1 = r17
            r35 = r20
            r36 = r21
            r39 = r22
            r40 = r23
            r41 = r24
            r42 = r25
            r43 = r26
            r44 = r27
            r37 = r28
            r17 = r29
            r33 = r31
            r34 = 0
            r9 = r7
            r7 = r6
            r6 = r3
            r3 = r32
        L_0x069c:
            boolean r20 = r0.hasNext()
            if (r20 == 0) goto L_0x075c
            java.lang.Object r20 = r0.next()
            r21 = r3
            r3 = r20
            java.lang.String r3 = (java.lang.String) r3
            r13.L$0 = r7
            r13.L$1 = r9
            r13.L$2 = r8
            r13.L$3 = r5
            r13.L$4 = r1
            r13.L$5 = r4
            r13.L$6 = r10
            r13.L$7 = r2
            r13.L$8 = r0
            r13.L$9 = r11
            r13.L$10 = r12
            r13.L$11 = r6
            r13.L$12 = r15
            r13.L$13 = r14
            r76 = r0
            r0 = r21
            r13.L$14 = r0
            r20 = r9
            r9 = r17
            r13.L$15 = r9
            r9 = r37
            r13.L$16 = r9
            r21 = r9
            r9 = r44
            r13.L$17 = r9
            r22 = r9
            r9 = r43
            r13.L$18 = r9
            r23 = r9
            r9 = r42
            r13.L$19 = r9
            r24 = r9
            r9 = r41
            r13.L$20 = r9
            r25 = r9
            r9 = r40
            r13.L$21 = r9
            r26 = r9
            r9 = r39
            r13.L$22 = r9
            r27 = r9
            r9 = r38
            r13.L$23 = r9
            r13.L$24 = r2
            r28 = r9
            r9 = r36
            r13.Z$0 = r9
            r29 = r9
            r9 = r35
            r13.I$0 = r9
            r31 = r9
            r9 = r34
            r13.I$1 = r9
            r32 = r9
            r9 = 4
            r13.label = r9
            r9 = 6
            kotlin.jvm.internal.InlineMarker.mark((int) r9)
            java.lang.Object r3 = r7.invoke(r3, r13)
            r9 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r9)
            r9 = r33
            if (r3 != r9) goto L_0x072c
            return r9
        L_0x072c:
            r33 = r9
            r37 = r21
            r44 = r22
            r43 = r23
            r42 = r24
            r41 = r25
            r40 = r26
            r39 = r27
            r38 = r28
            r36 = r29
            r35 = r31
            r34 = r32
            r28 = r1
            r1 = r3
            r9 = r8
            r31 = r20
            r3 = r0
            r8 = r7
            r0 = r76
            r7 = r2
        L_0x074f:
            io.getstream.chat.android.client.models.User r1 = (p015io.getstream.chat.android.client.models.User) r1
            r7.add(r1)
            r7 = r8
            r8 = r9
            r1 = r28
            r9 = r31
            goto L_0x069c
        L_0x075c:
            r0 = r3
            r20 = r9
            r9 = r33
            r32 = r34
            r31 = r35
            r29 = r36
            r21 = r37
            r28 = r38
            r27 = r39
            r26 = r40
            r25 = r41
            r24 = r42
            r23 = r43
            r22 = r44
            java.util.List r2 = (java.util.List) r2
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.toMutableList(r2)
            java.lang.String r3 = r8.getReplyToId()
            if (r3 == 0) goto L_0x083e
            r13.L$0 = r7
            r13.L$1 = r8
            r13.L$2 = r5
            r13.L$3 = r1
            r13.L$4 = r4
            r13.L$5 = r10
            r13.L$6 = r11
            r13.L$7 = r12
            r13.L$8 = r6
            r13.L$9 = r15
            r13.L$10 = r14
            r13.L$11 = r0
            r33 = r0
            r0 = r17
            r13.L$12 = r0
            r0 = r21
            r13.L$13 = r0
            r0 = r22
            r13.L$14 = r0
            r0 = r23
            r13.L$15 = r0
            r0 = r24
            r13.L$16 = r0
            r0 = r25
            r13.L$17 = r0
            r0 = r26
            r13.L$18 = r0
            r0 = r27
            r13.L$19 = r0
            r0 = r28
            r13.L$20 = r0
            r13.L$21 = r2
            r0 = 0
            r13.L$22 = r0
            r13.L$23 = r0
            r13.L$24 = r0
            r0 = r29
            r13.Z$0 = r0
            r0 = r31
            r13.I$0 = r0
            r0 = r32
            r13.I$1 = r0
            r0 = 0
            r13.I$2 = r0
            r0 = 5
            r13.label = r0
            r0 = 6
            kotlin.jvm.internal.InlineMarker.mark((int) r0)
            r0 = r20
            java.lang.Object r0 = r0.invoke(r3, r13)
            r3 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r3)
            if (r0 != r9) goto L_0x07ef
            return r9
        L_0x07ef:
            r3 = r9
            r9 = r21
            r20 = r23
            r19 = 0
            r21 = r6
            r23 = r11
            r11 = r27
            r6 = r29
            r27 = r5
            r5 = r31
            r73 = r1
            r1 = r0
            r0 = r73
            r74 = r8
            r8 = r2
            r2 = r13
            r13 = r24
            r24 = r10
            r10 = r28
            r28 = r74
        L_0x0813:
            io.getstream.chat.android.client.models.Message r1 = (p015io.getstream.chat.android.client.models.Message) r1
            r35 = r5
            r36 = r6
            r37 = r9
            r38 = r10
            r39 = r11
            r42 = r13
            r43 = r20
            r6 = r21
            r44 = r22
            r11 = r23
            r10 = r24
            r41 = r25
            r40 = r26
            r34 = r32
            r5 = r1
            r13 = r2
            r2 = r8
            r8 = r28
            r1 = r0
            r73 = r33
            r33 = r3
            r3 = r73
            goto L_0x0860
        L_0x083e:
            r33 = r0
            r36 = r29
            r0 = 0
            r37 = r21
            r44 = r22
            r43 = r23
            r42 = r24
            r41 = r25
            r40 = r26
            r39 = r27
            r38 = r28
            r35 = r31
            r34 = r32
            r3 = r33
            r19 = 0
            r27 = r5
            r33 = r9
            r5 = r0
        L_0x0860:
            java.util.List r0 = r8.getThreadParticipantsIds()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = 10
            int r9 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r9)
            r8.<init>(r9)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r0 = r0.iterator()
            r22 = r2
            r72 = r5
            r5 = r12
            r2 = r15
            r9 = r17
            r17 = r33
            r20 = r34
            r21 = r35
            r71 = r36
            r23 = r38
            r24 = r39
            r25 = r40
            r70 = r41
            r26 = r42
            r28 = r44
            r18 = 0
            r15 = r4
            r4 = r6
            r12 = r8
            r6 = r27
            r8 = r37
            r27 = r43
            r73 = r14
            r14 = r3
            r3 = r73
        L_0x08a3:
            r65 = 0
            r64 = 0
            r63 = 0
            r61 = 0
            r59 = 0
            r57 = 0
            r39 = 0
            r35 = 0
            boolean r29 = r0.hasNext()
            if (r29 == 0) goto L_0x09a2
            java.lang.Object r29 = r0.next()
            r36 = r8
            r8 = r29
            java.lang.String r8 = (java.lang.String) r8
            r13.L$0 = r7
            r13.L$1 = r6
            r13.L$2 = r1
            r13.L$3 = r15
            r13.L$4 = r10
            r13.L$5 = r12
            r13.L$6 = r0
            r13.L$7 = r11
            r13.L$8 = r5
            r13.L$9 = r4
            r13.L$10 = r2
            r13.L$11 = r3
            r13.L$12 = r14
            r13.L$13 = r9
            r76 = r0
            r0 = r36
            r13.L$14 = r0
            r29 = r14
            r14 = r28
            r13.L$15 = r14
            r28 = r15
            r15 = r27
            r13.L$16 = r15
            r15 = r26
            r13.L$17 = r15
            r26 = r14
            r14 = r70
            r13.L$18 = r14
            r52 = r14
            r14 = r25
            r13.L$19 = r14
            r25 = r15
            r15 = r24
            r13.L$20 = r15
            r24 = r14
            r14 = r23
            r13.L$21 = r14
            r14 = r22
            r13.L$22 = r14
            r22 = r15
            r15 = r72
            r13.L$23 = r15
            r13.L$24 = r12
            r60 = r15
            r15 = r71
            r13.Z$0 = r15
            r56 = r15
            r15 = r21
            r13.I$0 = r15
            r21 = r5
            r5 = r20
            r13.I$1 = r5
            r20 = r4
            r4 = r19
            r13.I$2 = r4
            r19 = r2
            r2 = r18
            r13.I$3 = r2
            r18 = r3
            r3 = 6
            r13.label = r3
            kotlin.jvm.internal.InlineMarker.mark((int) r3)
            java.lang.Object r8 = r7.invoke(r8, r13)
            r16 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r16)
            r3 = r17
            if (r8 != r3) goto L_0x094d
            return r3
        L_0x094d:
            r17 = r3
            r3 = r18
            r31 = r26
            r70 = r52
            r71 = r56
            r72 = r60
            r18 = r2
            r26 = r24
            r2 = r1
            r1 = r8
            r24 = r23
            r8 = r0
            r23 = r14
            r14 = r29
            r0 = r76
            r29 = r27
            r27 = r12
            r73 = r20
            r20 = r4
            r4 = r73
            r74 = r21
            r21 = r5
            r5 = r74
            r75 = r22
            r22 = r15
            r15 = r28
            r28 = r25
            r25 = r75
        L_0x0982:
            io.getstream.chat.android.client.models.User r1 = (p015io.getstream.chat.android.client.models.User) r1
            r12.add(r1)
            r1 = r2
            r2 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r23
            r23 = r24
            r24 = r25
            r25 = r26
            r12 = r27
            r26 = r28
            r27 = r29
            r28 = r31
            goto L_0x08a3
        L_0x09a2:
            r0 = r8
            r29 = r14
            r14 = r22
            r22 = r24
            r24 = r25
            r25 = r26
            r26 = r28
            r52 = r70
            r56 = r71
            r60 = r72
            r28 = r15
            r15 = r21
            r21 = r5
            r5 = r20
            r20 = r4
            r4 = r19
            r19 = r2
            r2 = r18
            r18 = r3
            r66 = r12
            java.util.List r66 = (java.util.List) r66
            r67 = -293601144(0xffffffffee800088, float:-1.9807362E28)
            r68 = 3
            r69 = 0
            io.getstream.chat.android.client.models.Message r3 = new io.getstream.chat.android.client.models.Message
            if (r5 == 0) goto L_0x09d9
            r55 = 1
            goto L_0x09db
        L_0x09d9:
            r55 = 0
        L_0x09db:
            if (r4 == 0) goto L_0x09e0
            r58 = 1
            goto L_0x09e2
        L_0x09e0:
            r58 = 0
        L_0x09e2:
            if (r2 == 0) goto L_0x09e7
            r62 = 1
            goto L_0x09e9
        L_0x09e7:
            r62 = 0
        L_0x09e9:
            r31 = r3
            r32 = r1
            r33 = r6
            r34 = r10
            r36 = r0
            r37 = r9
            r38 = r11
            r40 = r14
            r41 = r15
            r42 = r18
            r43 = r19
            r44 = r20
            r45 = r21
            r46 = r22
            r47 = r23
            r48 = r24
            r49 = r25
            r50 = r26
            r51 = r27
            r53 = r28
            r54 = r29
            r31.<init>(r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt.toModel(io.getstream.chat.android.livedata.repository.domain.message.MessageEntity, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final MessageEntity toEntity(Message message) {
        String str;
        Intrinsics.checkNotNullParameter(message, "$this$toEntity");
        String id = message.getId();
        String cid = message.getCid();
        String id2 = message.getUser().getId();
        String text = message.getText();
        SyncStatus syncStatus = message.getSyncStatus();
        String type = message.getType();
        int replyCount = message.getReplyCount();
        Date createdAt = message.getCreatedAt();
        Date createdLocallyAt = message.getCreatedLocallyAt();
        Date updatedAt = message.getUpdatedAt();
        Date updatedLocallyAt = message.getUpdatedLocallyAt();
        Date deletedAt = message.getDeletedAt();
        String parentId = message.getParentId();
        String command = message.getCommand();
        Map<String, Object> extraData = message.getExtraData();
        Map<String, Integer> reactionCounts = message.getReactionCounts();
        Map<String, Integer> reactionScores = message.getReactionScores();
        boolean shadowed = message.getShadowed();
        Iterable<User> mentionedUsers = message.getMentionedUsers();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mentionedUsers, 10));
        for (User id3 : mentionedUsers) {
            arrayList.add(id3.getId());
        }
        List list = (List) arrayList;
        Message replyTo = message.getReplyTo();
        if (replyTo == null || (str = replyTo.getId()) == null) {
            str = message.getReplyMessageId();
        }
        String str2 = str;
        Iterable<User> threadParticipants = message.getThreadParticipants();
        List list2 = list;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(threadParticipants, 10));
        for (User id4 : threadParticipants) {
            arrayList2.add(id4.getId());
        }
        MessageInnerEntity messageInnerEntity = new MessageInnerEntity(id, cid, id2, text, type, syncStatus, replyCount, createdAt, createdLocallyAt, updatedAt, updatedLocallyAt, deletedAt, list2, reactionCounts, reactionScores, parentId, command, shadowed, extraData, str2, (List) arrayList2);
        Iterable<Attachment> attachments = message.getAttachments();
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(attachments, 10));
        for (Attachment entity : attachments) {
            arrayList3.add(AttachmentMapperKt.toEntity(entity, message.getId()));
        }
        List list3 = (List) arrayList3;
        Iterable<Reaction> latestReactions = message.getLatestReactions();
        Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(latestReactions, 10));
        for (Reaction entity2 : latestReactions) {
            arrayList4.add(ReactionMapperKt.toEntity(entity2));
        }
        List list4 = (List) arrayList4;
        Iterable<Reaction> ownReactions = message.getOwnReactions();
        Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(ownReactions, 10));
        for (Reaction entity3 : ownReactions) {
            arrayList5.add(ReactionMapperKt.toEntity(entity3));
        }
        return new MessageEntity(messageInnerEntity, list3, (List) arrayList5, list4);
    }
}

package p015io.getstream.chat.android.client.models;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.CustomObject;
import p015io.getstream.chat.android.client.parser.IgnoreDeserialisation;
import p015io.getstream.chat.android.client.parser.IgnoreSerialisation;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0003\b\u0001\b\b\u0018\u00002\u00020\u0001BÑ\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u0012\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010 \u001a\u00020\u000e\u0012\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0\u0012\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030'\u0012\b\b\u0002\u0010(\u001a\u00020$\u0012\n\b\u0003\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0000\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010-\u001a\u00020$\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e02¢\u0006\u0002\u00103J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0010HÆ\u0003J\u0016\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u0012HÆ\u0003J\u0016\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\nHÆ\u0003J\u0010\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\nHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\n\u0010\u0001\u001a\u00020\u000eHÆ\u0003J\u0016\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020$HÆ\u0003J\n\u0010\u0001\u001a\u00020$HÆ\u0003J\u0016\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030'HÆ\u0003J\n\u0010\u0001\u001a\u00020$HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010*HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010¤\u0001\u001a\u00020$HÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e02HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u0010\u0010­\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u0010\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\nHÆ\u0003JÖ\u0003\u0010¯\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020\u000e2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0\u00122\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030'2\b\b\u0002\u0010(\u001a\u00020$2\n\b\u0003\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010-\u001a\u00020$2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e02HÆ\u0001J\u0015\u0010°\u0001\u001a\u00020$2\t\u0010±\u0001\u001a\u0004\u0018\u00010\"HÖ\u0003J\n\u0010²\u0001\u001a\u00020\u0010HÖ\u0001J\n\u0010³\u0001\u001a\u00020\u0003HÖ\u0001R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R \u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010=\"\u0004\bA\u0010?R \u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER \u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010C\"\u0004\bG\u0010ER \u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER*\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0\u00128\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010=R\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030'8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010KR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010=\"\u0004\bQ\u0010?R$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00105\"\u0004\bS\u00107R$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00105\"\u0004\bU\u00107R$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00105\"\u0004\bW\u00107R$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00105\"\u0004\bY\u00107R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010=\"\u0004\b[\u0010?R \u0010/\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010C\"\u0004\b]\u0010ER\u001a\u0010-\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR \u0010.\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010C\"\u0004\bc\u0010ER \u00100\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR*\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010K\"\u0004\bi\u0010MR*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010K\"\u0004\bk\u0010MR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR \u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010=\"\u0004\bq\u0010?R \u0010+\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001a\u0010%\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010_\"\u0004\bw\u0010aR\u001e\u0010(\u001a\u00020$8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010_\"\u0004\by\u0010aR\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010_\"\u0004\b{\u0010aR\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R\u001c\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010=\"\u0005\b\u0001\u0010?R&\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e028\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u00105\"\u0005\b\u0001\u00107R \u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010=\"\u0005\b\u0001\u0010?R\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\"\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER \u0010 \u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010e\"\u0005\b\u0001\u0010g¨\u0006´\u0001"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Message;", "Lio/getstream/chat/android/client/models/CustomObject;", "id", "", "cid", "text", "html", "parentId", "command", "attachments", "", "Lio/getstream/chat/android/client/models/Attachment;", "mentionedUsersIds", "mentionedUsers", "Lio/getstream/chat/android/client/models/User;", "replyCount", "", "reactionCounts", "", "reactionScores", "syncStatus", "Lio/getstream/chat/android/client/utils/SyncStatus;", "type", "latestReactions", "Lio/getstream/chat/android/client/models/Reaction;", "ownReactions", "createdAt", "Ljava/util/Date;", "updatedAt", "deletedAt", "updatedLocallyAt", "createdLocallyAt", "user", "extraData", "", "silent", "", "shadowed", "i18n", "", "showInChannel", "channelInfo", "Lio/getstream/chat/android/client/models/ChannelInfo;", "replyTo", "replyMessageId", "pinned", "pinnedAt", "pinExpires", "pinnedBy", "threadParticipants", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/util/Map;Ljava/util/Map;Lio/getstream/chat/android/client/utils/SyncStatus;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;Ljava/util/Map;ZZLjava/util/Map;ZLio/getstream/chat/android/client/models/ChannelInfo;Lio/getstream/chat/android/client/models/Message;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;Lio/getstream/chat/android/client/models/User;Ljava/util/List;)V", "getAttachments", "()Ljava/util/List;", "setAttachments", "(Ljava/util/List;)V", "getChannelInfo", "()Lio/getstream/chat/android/client/models/ChannelInfo;", "setChannelInfo", "(Lio/getstream/chat/android/client/models/ChannelInfo;)V", "getCid", "()Ljava/lang/String;", "setCid", "(Ljava/lang/String;)V", "getCommand", "setCommand", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getCreatedLocallyAt", "setCreatedLocallyAt", "getDeletedAt", "setDeletedAt", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "getHtml", "getI18n", "getId", "setId", "getLatestReactions", "setLatestReactions", "getMentionedUsers", "setMentionedUsers", "getMentionedUsersIds", "setMentionedUsersIds", "getOwnReactions", "setOwnReactions", "getParentId", "setParentId", "getPinExpires", "setPinExpires", "getPinned", "()Z", "setPinned", "(Z)V", "getPinnedAt", "setPinnedAt", "getPinnedBy", "()Lio/getstream/chat/android/client/models/User;", "setPinnedBy", "(Lio/getstream/chat/android/client/models/User;)V", "getReactionCounts", "setReactionCounts", "getReactionScores", "setReactionScores", "getReplyCount", "()I", "setReplyCount", "(I)V", "getReplyMessageId", "setReplyMessageId", "getReplyTo", "()Lio/getstream/chat/android/client/models/Message;", "setReplyTo", "(Lio/getstream/chat/android/client/models/Message;)V", "getShadowed", "setShadowed", "getShowInChannel", "setShowInChannel", "getSilent", "setSilent", "getSyncStatus", "()Lio/getstream/chat/android/client/utils/SyncStatus;", "setSyncStatus", "(Lio/getstream/chat/android/client/utils/SyncStatus;)V", "getText", "setText", "getThreadParticipants", "setThreadParticipants", "getType", "setType", "getUpdatedAt", "setUpdatedAt", "getUpdatedLocallyAt", "setUpdatedLocallyAt", "getUser", "setUser", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.Message */
/* compiled from: Message.kt */
public final class Message implements CustomObject {
    private List<Attachment> attachments;
    @SerializedName("channel")
    @IgnoreSerialisation
    private ChannelInfo channelInfo;
    private String cid;
    private String command;
    @SerializedName("created_at")
    @IgnoreSerialisation
    private Date createdAt;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private Date createdLocallyAt;
    @SerializedName("deleted_at")
    @IgnoreSerialisation
    private Date deletedAt;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private Map<String, Object> extraData;
    private final String html;
    @IgnoreSerialisation
    private final Map<String, String> i18n;

    /* renamed from: id */
    private String f1459id;
    @SerializedName("latest_reactions")
    @IgnoreSerialisation
    private List<Reaction> latestReactions;
    @SerializedName("mentioned_users")
    @IgnoreSerialisation
    private List<User> mentionedUsers;
    @SerializedName("mentioned_users")
    @IgnoreDeserialisation
    private List<String> mentionedUsersIds;
    @SerializedName("own_reactions")
    @IgnoreSerialisation
    private List<Reaction> ownReactions;
    @SerializedName("parent_id")
    private String parentId;
    @SerializedName("pin_expires")
    private Date pinExpires;
    private boolean pinned;
    @SerializedName("pinned_at")
    private Date pinnedAt;
    @SerializedName("pinned_by")
    private User pinnedBy;
    @SerializedName("reaction_counts")
    @IgnoreSerialisation
    private Map<String, Integer> reactionCounts;
    @SerializedName("reaction_scores")
    @IgnoreSerialisation
    private Map<String, Integer> reactionScores;
    @SerializedName("reply_count")
    @IgnoreSerialisation
    private int replyCount;
    @SerializedName("quoted_message_id")
    private String replyMessageId;
    @SerializedName("quoted_message")
    private Message replyTo;
    private boolean shadowed;
    @SerializedName("show_in_channel")
    private boolean showInChannel;
    private boolean silent;
    @IgnoreSerialisation
    private SyncStatus syncStatus;
    private String text;
    @SerializedName("thread_participants")
    private List<User> threadParticipants;
    @IgnoreSerialisation
    private String type;
    @SerializedName("updated_at")
    @IgnoreSerialisation
    private Date updatedAt;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private Date updatedLocallyAt;
    @IgnoreSerialisation
    private User user;

    public Message() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (List) null, (List) null, 0, (Map) null, (Map) null, (SyncStatus) null, (String) null, (List) null, (List) null, (Date) null, (Date) null, (Date) null, (Date) null, (Date) null, (User) null, (Map) null, false, false, (Map) null, false, (ChannelInfo) null, (Message) null, (String) null, false, (Date) null, (Date) null, (User) null, (List) null, -1, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Message copy$default(Message message, String str, String str2, String str3, String str4, String str5, String str6, List list, List list2, List list3, int i, Map map, Map map2, SyncStatus syncStatus2, String str7, List list4, List list5, Date date, Date date2, Date date3, Date date4, Date date5, User user2, Map map3, boolean z, boolean z2, Map map4, boolean z3, ChannelInfo channelInfo2, Message message2, String str8, boolean z4, Date date6, Date date7, User user3, List list6, int i2, int i3, Object obj) {
        Message message3 = message;
        int i4 = i2;
        return message.copy((i4 & 1) != 0 ? message3.f1459id : str, (i4 & 2) != 0 ? message3.cid : str2, (i4 & 4) != 0 ? message3.text : str3, (i4 & 8) != 0 ? message3.html : str4, (i4 & 16) != 0 ? message3.parentId : str5, (i4 & 32) != 0 ? message3.command : str6, (i4 & 64) != 0 ? message3.attachments : list, (i4 & 128) != 0 ? message3.mentionedUsersIds : list2, (i4 & 256) != 0 ? message3.mentionedUsers : list3, (i4 & 512) != 0 ? message3.replyCount : i, (i4 & 1024) != 0 ? message3.reactionCounts : map, (i4 & 2048) != 0 ? message3.reactionScores : map2, (i4 & 4096) != 0 ? message3.syncStatus : syncStatus2, (i4 & 8192) != 0 ? message3.type : str7, (i4 & 16384) != 0 ? message3.latestReactions : list4, (i4 & 32768) != 0 ? message3.ownReactions : list5, (i4 & 65536) != 0 ? message3.createdAt : date, (i4 & 131072) != 0 ? message3.updatedAt : date2, (i4 & 262144) != 0 ? message3.deletedAt : date3, (i4 & 524288) != 0 ? message3.updatedLocallyAt : date4, (i4 & 1048576) != 0 ? message3.createdLocallyAt : date5, (i4 & 2097152) != 0 ? message3.user : user2, (i4 & 4194304) != 0 ? message.getExtraData() : map3, (i4 & 8388608) != 0 ? message3.silent : z, (i4 & 16777216) != 0 ? message3.shadowed : z2, (i4 & 33554432) != 0 ? message3.i18n : map4, (i4 & 67108864) != 0 ? message3.showInChannel : z3, (i4 & 134217728) != 0 ? message3.channelInfo : channelInfo2, (i4 & 268435456) != 0 ? message3.replyTo : message2, (i4 & 536870912) != 0 ? message3.replyMessageId : str8, (i4 & 1073741824) != 0 ? message3.pinned : z4, (i4 & Integer.MIN_VALUE) != 0 ? message3.pinnedAt : date6, (i3 & 1) != 0 ? message3.pinExpires : date7, (i3 & 2) != 0 ? message3.pinnedBy : user3, (i3 & 4) != 0 ? message3.threadParticipants : list6);
    }

    public final String component1() {
        return this.f1459id;
    }

    public final int component10() {
        return this.replyCount;
    }

    public final Map<String, Integer> component11() {
        return this.reactionCounts;
    }

    public final Map<String, Integer> component12() {
        return this.reactionScores;
    }

    public final SyncStatus component13() {
        return this.syncStatus;
    }

    public final String component14() {
        return this.type;
    }

    public final List<Reaction> component15() {
        return this.latestReactions;
    }

    public final List<Reaction> component16() {
        return this.ownReactions;
    }

    public final Date component17() {
        return this.createdAt;
    }

    public final Date component18() {
        return this.updatedAt;
    }

    public final Date component19() {
        return this.deletedAt;
    }

    public final String component2() {
        return this.cid;
    }

    public final Date component20() {
        return this.updatedLocallyAt;
    }

    public final Date component21() {
        return this.createdLocallyAt;
    }

    public final User component22() {
        return this.user;
    }

    public final Map<String, Object> component23() {
        return getExtraData();
    }

    public final boolean component24() {
        return this.silent;
    }

    public final boolean component25() {
        return this.shadowed;
    }

    public final Map<String, String> component26() {
        return this.i18n;
    }

    public final boolean component27() {
        return this.showInChannel;
    }

    public final ChannelInfo component28() {
        return this.channelInfo;
    }

    public final Message component29() {
        return this.replyTo;
    }

    public final String component3() {
        return this.text;
    }

    public final String component30() {
        return this.replyMessageId;
    }

    public final boolean component31() {
        return this.pinned;
    }

    public final Date component32() {
        return this.pinnedAt;
    }

    public final Date component33() {
        return this.pinExpires;
    }

    public final User component34() {
        return this.pinnedBy;
    }

    public final List<User> component35() {
        return this.threadParticipants;
    }

    public final String component4() {
        return this.html;
    }

    public final String component5() {
        return this.parentId;
    }

    public final String component6() {
        return this.command;
    }

    public final List<Attachment> component7() {
        return this.attachments;
    }

    public final List<String> component8() {
        return this.mentionedUsersIds;
    }

    public final List<User> component9() {
        return this.mentionedUsers;
    }

    public final Message copy(String str, String str2, String str3, String str4, String str5, String str6, List<Attachment> list, List<String> list2, List<User> list3, int i, Map<String, Integer> map, Map<String, Integer> map2, SyncStatus syncStatus2, String str7, List<Reaction> list4, List<Reaction> list5, Date date, Date date2, Date date3, Date date4, Date date5, User user2, Map<String, Object> map3, boolean z, boolean z2, Map<String, String> map4, boolean z3, @InternalStreamChatApi ChannelInfo channelInfo2, Message message, String str8, boolean z4, Date date6, Date date7, User user3, List<User> list6) {
        String str9 = str;
        Intrinsics.checkNotNullParameter(str9, "id");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, "text");
        Intrinsics.checkNotNullParameter(str4, "html");
        Intrinsics.checkNotNullParameter(list, "attachments");
        Intrinsics.checkNotNullParameter(list2, "mentionedUsersIds");
        Intrinsics.checkNotNullParameter(list3, "mentionedUsers");
        Intrinsics.checkNotNullParameter(map, "reactionCounts");
        Intrinsics.checkNotNullParameter(map2, "reactionScores");
        Intrinsics.checkNotNullParameter(syncStatus2, "syncStatus");
        Intrinsics.checkNotNullParameter(str7, "type");
        Intrinsics.checkNotNullParameter(list4, "latestReactions");
        Intrinsics.checkNotNullParameter(list5, "ownReactions");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(map3, "extraData");
        Intrinsics.checkNotNullParameter(map4, "i18n");
        Intrinsics.checkNotNullParameter(list6, "threadParticipants");
        return new Message(str9, str2, str3, str4, str5, str6, list, list2, list3, i, map, map2, syncStatus2, str7, list4, list5, date, date2, date3, date4, date5, user2, map3, z, z2, map4, z3, channelInfo2, message, str8, z4, date6, date7, user3, list6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return Intrinsics.areEqual((Object) this.f1459id, (Object) message.f1459id) && Intrinsics.areEqual((Object) this.cid, (Object) message.cid) && Intrinsics.areEqual((Object) this.text, (Object) message.text) && Intrinsics.areEqual((Object) this.html, (Object) message.html) && Intrinsics.areEqual((Object) this.parentId, (Object) message.parentId) && Intrinsics.areEqual((Object) this.command, (Object) message.command) && Intrinsics.areEqual((Object) this.attachments, (Object) message.attachments) && Intrinsics.areEqual((Object) this.mentionedUsersIds, (Object) message.mentionedUsersIds) && Intrinsics.areEqual((Object) this.mentionedUsers, (Object) message.mentionedUsers) && this.replyCount == message.replyCount && Intrinsics.areEqual((Object) this.reactionCounts, (Object) message.reactionCounts) && Intrinsics.areEqual((Object) this.reactionScores, (Object) message.reactionScores) && Intrinsics.areEqual((Object) this.syncStatus, (Object) message.syncStatus) && Intrinsics.areEqual((Object) this.type, (Object) message.type) && Intrinsics.areEqual((Object) this.latestReactions, (Object) message.latestReactions) && Intrinsics.areEqual((Object) this.ownReactions, (Object) message.ownReactions) && Intrinsics.areEqual((Object) this.createdAt, (Object) message.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) message.updatedAt) && Intrinsics.areEqual((Object) this.deletedAt, (Object) message.deletedAt) && Intrinsics.areEqual((Object) this.updatedLocallyAt, (Object) message.updatedLocallyAt) && Intrinsics.areEqual((Object) this.createdLocallyAt, (Object) message.createdLocallyAt) && Intrinsics.areEqual((Object) this.user, (Object) message.user) && Intrinsics.areEqual((Object) getExtraData(), (Object) message.getExtraData()) && this.silent == message.silent && this.shadowed == message.shadowed && Intrinsics.areEqual((Object) this.i18n, (Object) message.i18n) && this.showInChannel == message.showInChannel && Intrinsics.areEqual((Object) this.channelInfo, (Object) message.channelInfo) && Intrinsics.areEqual((Object) this.replyTo, (Object) message.replyTo) && Intrinsics.areEqual((Object) this.replyMessageId, (Object) message.replyMessageId) && this.pinned == message.pinned && Intrinsics.areEqual((Object) this.pinnedAt, (Object) message.pinnedAt) && Intrinsics.areEqual((Object) this.pinExpires, (Object) message.pinExpires) && Intrinsics.areEqual((Object) this.pinnedBy, (Object) message.pinnedBy) && Intrinsics.areEqual((Object) this.threadParticipants, (Object) message.threadParticipants);
    }

    public int hashCode() {
        String str = this.f1459id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.html;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.parentId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.command;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        List<Attachment> list = this.attachments;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.mentionedUsersIds;
        int hashCode8 = (hashCode7 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<User> list3 = this.mentionedUsers;
        int hashCode9 = (((hashCode8 + (list3 != null ? list3.hashCode() : 0)) * 31) + this.replyCount) * 31;
        Map<String, Integer> map = this.reactionCounts;
        int hashCode10 = (hashCode9 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, Integer> map2 = this.reactionScores;
        int hashCode11 = (hashCode10 + (map2 != null ? map2.hashCode() : 0)) * 31;
        SyncStatus syncStatus2 = this.syncStatus;
        int hashCode12 = (hashCode11 + (syncStatus2 != null ? syncStatus2.hashCode() : 0)) * 31;
        String str7 = this.type;
        int hashCode13 = (hashCode12 + (str7 != null ? str7.hashCode() : 0)) * 31;
        List<Reaction> list4 = this.latestReactions;
        int hashCode14 = (hashCode13 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<Reaction> list5 = this.ownReactions;
        int hashCode15 = (hashCode14 + (list5 != null ? list5.hashCode() : 0)) * 31;
        Date date = this.createdAt;
        int hashCode16 = (hashCode15 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updatedAt;
        int hashCode17 = (hashCode16 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.deletedAt;
        int hashCode18 = (hashCode17 + (date3 != null ? date3.hashCode() : 0)) * 31;
        Date date4 = this.updatedLocallyAt;
        int hashCode19 = (hashCode18 + (date4 != null ? date4.hashCode() : 0)) * 31;
        Date date5 = this.createdLocallyAt;
        int hashCode20 = (hashCode19 + (date5 != null ? date5.hashCode() : 0)) * 31;
        User user2 = this.user;
        int hashCode21 = (hashCode20 + (user2 != null ? user2.hashCode() : 0)) * 31;
        Map<String, Object> extraData2 = getExtraData();
        int hashCode22 = (hashCode21 + (extraData2 != null ? extraData2.hashCode() : 0)) * 31;
        boolean z = this.silent;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode22 + (z ? 1 : 0)) * 31;
        boolean z3 = this.shadowed;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        Map<String, String> map3 = this.i18n;
        int hashCode23 = (i3 + (map3 != null ? map3.hashCode() : 0)) * 31;
        boolean z4 = this.showInChannel;
        if (z4) {
            z4 = true;
        }
        int i4 = (hashCode23 + (z4 ? 1 : 0)) * 31;
        ChannelInfo channelInfo2 = this.channelInfo;
        int hashCode24 = (i4 + (channelInfo2 != null ? channelInfo2.hashCode() : 0)) * 31;
        Message message = this.replyTo;
        int hashCode25 = (hashCode24 + (message != null ? message.hashCode() : 0)) * 31;
        String str8 = this.replyMessageId;
        int hashCode26 = (hashCode25 + (str8 != null ? str8.hashCode() : 0)) * 31;
        boolean z5 = this.pinned;
        if (!z5) {
            z2 = z5;
        }
        int i5 = (hashCode26 + (z2 ? 1 : 0)) * 31;
        Date date6 = this.pinnedAt;
        int hashCode27 = (i5 + (date6 != null ? date6.hashCode() : 0)) * 31;
        Date date7 = this.pinExpires;
        int hashCode28 = (hashCode27 + (date7 != null ? date7.hashCode() : 0)) * 31;
        User user3 = this.pinnedBy;
        int hashCode29 = (hashCode28 + (user3 != null ? user3.hashCode() : 0)) * 31;
        List<User> list6 = this.threadParticipants;
        if (list6 != null) {
            i = list6.hashCode();
        }
        return hashCode29 + i;
    }

    public String toString() {
        return "Message(id=" + this.f1459id + ", cid=" + this.cid + ", text=" + this.text + ", html=" + this.html + ", parentId=" + this.parentId + ", command=" + this.command + ", attachments=" + this.attachments + ", mentionedUsersIds=" + this.mentionedUsersIds + ", mentionedUsers=" + this.mentionedUsers + ", replyCount=" + this.replyCount + ", reactionCounts=" + this.reactionCounts + ", reactionScores=" + this.reactionScores + ", syncStatus=" + this.syncStatus + ", type=" + this.type + ", latestReactions=" + this.latestReactions + ", ownReactions=" + this.ownReactions + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", deletedAt=" + this.deletedAt + ", updatedLocallyAt=" + this.updatedLocallyAt + ", createdLocallyAt=" + this.createdLocallyAt + ", user=" + this.user + ", extraData=" + getExtraData() + ", silent=" + this.silent + ", shadowed=" + this.shadowed + ", i18n=" + this.i18n + ", showInChannel=" + this.showInChannel + ", channelInfo=" + this.channelInfo + ", replyTo=" + this.replyTo + ", replyMessageId=" + this.replyMessageId + ", pinned=" + this.pinned + ", pinnedAt=" + this.pinnedAt + ", pinExpires=" + this.pinExpires + ", pinnedBy=" + this.pinnedBy + ", threadParticipants=" + this.threadParticipants + ")";
    }

    public Message(String str, String str2, String str3, String str4, String str5, String str6, List<Attachment> list, List<String> list2, List<User> list3, int i, Map<String, Integer> map, Map<String, Integer> map2, SyncStatus syncStatus2, String str7, List<Reaction> list4, List<Reaction> list5, Date date, Date date2, Date date3, Date date4, Date date5, User user2, Map<String, Object> map3, boolean z, boolean z2, Map<String, String> map4, boolean z3, @InternalStreamChatApi ChannelInfo channelInfo2, Message message, String str8, boolean z4, Date date6, Date date7, User user3, List<User> list6) {
        String str9 = str;
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        List<Attachment> list7 = list;
        List<String> list8 = list2;
        List<User> list9 = list3;
        Map<String, Integer> map5 = map;
        Map<String, Integer> map6 = map2;
        SyncStatus syncStatus3 = syncStatus2;
        String str13 = str7;
        List<Reaction> list10 = list4;
        List<Reaction> list11 = list5;
        User user4 = user2;
        Map<String, String> map7 = map4;
        Intrinsics.checkNotNullParameter(str9, "id");
        Intrinsics.checkNotNullParameter(str10, "cid");
        Intrinsics.checkNotNullParameter(str11, "text");
        Intrinsics.checkNotNullParameter(str12, "html");
        Intrinsics.checkNotNullParameter(list7, "attachments");
        Intrinsics.checkNotNullParameter(list8, "mentionedUsersIds");
        Intrinsics.checkNotNullParameter(list9, "mentionedUsers");
        Intrinsics.checkNotNullParameter(map5, "reactionCounts");
        Intrinsics.checkNotNullParameter(map6, "reactionScores");
        Intrinsics.checkNotNullParameter(syncStatus3, "syncStatus");
        Intrinsics.checkNotNullParameter(str13, "type");
        Intrinsics.checkNotNullParameter(list10, "latestReactions");
        Intrinsics.checkNotNullParameter(list11, "ownReactions");
        Intrinsics.checkNotNullParameter(user4, "user");
        Intrinsics.checkNotNullParameter(map3, "extraData");
        Intrinsics.checkNotNullParameter(map4, "i18n");
        Intrinsics.checkNotNullParameter(list6, "threadParticipants");
        this.f1459id = str9;
        this.cid = str10;
        this.text = str11;
        this.html = str12;
        this.parentId = str5;
        this.command = str6;
        this.attachments = list7;
        this.mentionedUsersIds = list8;
        this.mentionedUsers = list9;
        this.replyCount = i;
        this.reactionCounts = map5;
        this.reactionScores = map6;
        this.syncStatus = syncStatus3;
        this.type = str13;
        this.latestReactions = list10;
        this.ownReactions = list11;
        this.createdAt = date;
        this.updatedAt = date2;
        this.deletedAt = date3;
        this.updatedLocallyAt = date4;
        this.createdLocallyAt = date5;
        this.user = user4;
        this.extraData = map3;
        this.silent = z;
        this.shadowed = z2;
        this.i18n = map4;
        this.showInChannel = z3;
        this.channelInfo = channelInfo2;
        this.replyTo = message;
        this.replyMessageId = str8;
        this.pinned = z4;
        this.pinnedAt = date6;
        this.pinExpires = date7;
        this.pinnedBy = user3;
        this.threadParticipants = list6;
    }

    public <T> T getExtraValue(String str, T t) {
        Intrinsics.checkNotNullParameter(str, "key");
        return CustomObject.DefaultImpls.getExtraValue(this, str, t);
    }

    public void putExtraValue(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        CustomObject.DefaultImpls.putExtraValue(this, str, obj);
    }

    public final String getId() {
        return this.f1459id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1459id = str;
    }

    public final String getCid() {
        return this.cid;
    }

    public final void setCid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cid = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final String getHtml() {
        return this.html;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Message(java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.util.List r42, java.util.List r43, java.util.List r44, int r45, java.util.Map r46, java.util.Map r47, p015io.getstream.chat.android.client.utils.SyncStatus r48, java.lang.String r49, java.util.List r50, java.util.List r51, java.util.Date r52, java.util.Date r53, java.util.Date r54, java.util.Date r55, java.util.Date r56, p015io.getstream.chat.android.client.models.User r57, java.util.Map r58, boolean r59, boolean r60, java.util.Map r61, boolean r62, p015io.getstream.chat.android.client.models.ChannelInfo r63, p015io.getstream.chat.android.client.models.Message r64, java.lang.String r65, boolean r66, java.util.Date r67, java.util.Date r68, p015io.getstream.chat.android.client.models.User r69, java.util.List r70, int r71, int r72, kotlin.jvm.internal.DefaultConstructorMarker r73) {
        /*
            r35 = this;
            r0 = r71
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r36
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r37
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r38
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r2
            goto L_0x0024
        L_0x0022:
            r5 = r39
        L_0x0024:
            r6 = r0 & 16
            r7 = 0
            if (r6 == 0) goto L_0x002d
            r6 = r7
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x002f
        L_0x002d:
            r6 = r40
        L_0x002f:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0037
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0039
        L_0x0037:
            r8 = r41
        L_0x0039:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0045
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List r9 = (java.util.List) r9
            goto L_0x0047
        L_0x0045:
            r9 = r42
        L_0x0047:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0053
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            goto L_0x0055
        L_0x0053:
            r10 = r43
        L_0x0055:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0061
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.List r11 = (java.util.List) r11
            goto L_0x0063
        L_0x0061:
            r11 = r44
        L_0x0063:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0069
            r12 = 0
            goto L_0x006b
        L_0x0069:
            r12 = r45
        L_0x006b:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0077
            java.util.LinkedHashMap r14 = new java.util.LinkedHashMap
            r14.<init>()
            java.util.Map r14 = (java.util.Map) r14
            goto L_0x0079
        L_0x0077:
            r14 = r46
        L_0x0079:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0085
            java.util.LinkedHashMap r15 = new java.util.LinkedHashMap
            r15.<init>()
            java.util.Map r15 = (java.util.Map) r15
            goto L_0x0087
        L_0x0085:
            r15 = r47
        L_0x0087:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x008e
            io.getstream.chat.android.client.utils.SyncStatus r13 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            goto L_0x0090
        L_0x008e:
            r13 = r48
        L_0x0090:
            r7 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x0095
            goto L_0x0097
        L_0x0095:
            r2 = r49
        L_0x0097:
            r7 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x00a3
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            goto L_0x00a5
        L_0x00a3:
            r7 = r50
        L_0x00a5:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00b4
            java.util.ArrayList r16 = new java.util.ArrayList
            r16.<init>()
            java.util.List r16 = (java.util.List) r16
            goto L_0x00b6
        L_0x00b4:
            r16 = r51
        L_0x00b6:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00c3
            r17 = 0
            r18 = r17
            java.util.Date r18 = (java.util.Date) r18
            goto L_0x00c7
        L_0x00c3:
            r17 = 0
            r18 = r52
        L_0x00c7:
            r19 = 131072(0x20000, float:1.83671E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00d2
            r19 = r17
            java.util.Date r19 = (java.util.Date) r19
            goto L_0x00d4
        L_0x00d2:
            r19 = r53
        L_0x00d4:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00df
            r20 = r17
            java.util.Date r20 = (java.util.Date) r20
            goto L_0x00e1
        L_0x00df:
            r20 = r54
        L_0x00e1:
            r21 = 524288(0x80000, float:7.34684E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ec
            r21 = r17
            java.util.Date r21 = (java.util.Date) r21
            goto L_0x00ee
        L_0x00ec:
            r21 = r55
        L_0x00ee:
            r22 = 1048576(0x100000, float:1.469368E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00f9
            r22 = r17
            java.util.Date r22 = (java.util.Date) r22
            goto L_0x00fb
        L_0x00f9:
            r22 = r56
        L_0x00fb:
            r17 = 2097152(0x200000, float:2.938736E-39)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0140
            io.getstream.chat.android.client.models.User r17 = new io.getstream.chat.android.client.models.User
            r38 = r17
            r23 = 0
            r39 = r23
            r40 = r23
            r23 = 0
            r41 = r23
            r42 = r23
            r23 = 0
            r43 = r23
            r23 = 0
            r44 = r23
            r23 = 0
            r45 = r23
            r46 = r23
            r47 = r23
            r23 = 0
            r48 = r23
            r49 = r23
            r50 = r23
            r23 = 0
            r51 = r23
            r52 = r23
            r53 = r23
            r54 = r23
            r23 = 65535(0xffff, float:9.1834E-41)
            r55 = r23
            r23 = 0
            r56 = r23
            r38.<init>(r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            goto L_0x0142
        L_0x0140:
            r17 = r57
        L_0x0142:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x0150
            java.util.LinkedHashMap r23 = new java.util.LinkedHashMap
            r23.<init>()
            java.util.Map r23 = (java.util.Map) r23
            goto L_0x0152
        L_0x0150:
            r23 = r58
        L_0x0152:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x015b
            r24 = 0
            goto L_0x015d
        L_0x015b:
            r24 = r59
        L_0x015d:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x0166
            r25 = 0
            goto L_0x0168
        L_0x0166:
            r25 = r60
        L_0x0168:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x0173
            java.util.Map r26 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0175
        L_0x0173:
            r26 = r61
        L_0x0175:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x017e
            r27 = 0
            goto L_0x0180
        L_0x017e:
            r27 = r62
        L_0x0180:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x018d
            r28 = 0
            r29 = r28
            io.getstream.chat.android.client.models.ChannelInfo r29 = (p015io.getstream.chat.android.client.models.ChannelInfo) r29
            goto L_0x0191
        L_0x018d:
            r28 = 0
            r29 = r63
        L_0x0191:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x019c
            r30 = r28
            io.getstream.chat.android.client.models.Message r30 = (p015io.getstream.chat.android.client.models.Message) r30
            goto L_0x019e
        L_0x019c:
            r30 = r64
        L_0x019e:
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x01a9
            r31 = r28
            java.lang.String r31 = (java.lang.String) r31
            goto L_0x01ab
        L_0x01a9:
            r31 = r65
        L_0x01ab:
            r32 = 1073741824(0x40000000, float:2.0)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x01b4
            r32 = 0
            goto L_0x01b6
        L_0x01b4:
            r32 = r66
        L_0x01b6:
            r33 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r33
            if (r0 == 0) goto L_0x01c1
            r0 = r28
            java.util.Date r0 = (java.util.Date) r0
            goto L_0x01c3
        L_0x01c1:
            r0 = r67
        L_0x01c3:
            r33 = r72 & 1
            if (r33 == 0) goto L_0x01cc
            r33 = r28
            java.util.Date r33 = (java.util.Date) r33
            goto L_0x01ce
        L_0x01cc:
            r33 = r68
        L_0x01ce:
            r34 = r72 & 2
            if (r34 == 0) goto L_0x01d5
            io.getstream.chat.android.client.models.User r28 = (p015io.getstream.chat.android.client.models.User) r28
            goto L_0x01d7
        L_0x01d5:
            r28 = r69
        L_0x01d7:
            r34 = r72 & 4
            if (r34 == 0) goto L_0x01e0
            java.util.List r34 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x01e2
        L_0x01e0:
            r34 = r70
        L_0x01e2:
            r36 = r35
            r37 = r1
            r38 = r3
            r39 = r4
            r40 = r5
            r41 = r6
            r42 = r8
            r43 = r9
            r44 = r10
            r45 = r11
            r46 = r12
            r47 = r14
            r48 = r15
            r49 = r13
            r50 = r2
            r51 = r7
            r52 = r16
            r53 = r18
            r54 = r19
            r55 = r20
            r56 = r21
            r57 = r22
            r58 = r17
            r59 = r23
            r60 = r24
            r61 = r25
            r62 = r26
            r63 = r27
            r64 = r29
            r65 = r30
            r66 = r31
            r67 = r32
            r68 = r0
            r69 = r33
            r70 = r28
            r71 = r34
            r36.<init>(r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.models.Message.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.util.List, int, java.util.Map, java.util.Map, io.getstream.chat.android.client.utils.SyncStatus, java.lang.String, java.util.List, java.util.List, java.util.Date, java.util.Date, java.util.Date, java.util.Date, java.util.Date, io.getstream.chat.android.client.models.User, java.util.Map, boolean, boolean, java.util.Map, boolean, io.getstream.chat.android.client.models.ChannelInfo, io.getstream.chat.android.client.models.Message, java.lang.String, boolean, java.util.Date, java.util.Date, io.getstream.chat.android.client.models.User, java.util.List, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final void setParentId(String str) {
        this.parentId = str;
    }

    public final String getCommand() {
        return this.command;
    }

    public final void setCommand(String str) {
        this.command = str;
    }

    public final List<Attachment> getAttachments() {
        return this.attachments;
    }

    public final void setAttachments(List<Attachment> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.attachments = list;
    }

    public final List<String> getMentionedUsersIds() {
        return this.mentionedUsersIds;
    }

    public final void setMentionedUsersIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mentionedUsersIds = list;
    }

    public final List<User> getMentionedUsers() {
        return this.mentionedUsers;
    }

    public final void setMentionedUsers(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mentionedUsers = list;
    }

    public final int getReplyCount() {
        return this.replyCount;
    }

    public final void setReplyCount(int i) {
        this.replyCount = i;
    }

    public final Map<String, Integer> getReactionCounts() {
        return this.reactionCounts;
    }

    public final void setReactionCounts(Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.reactionCounts = map;
    }

    public final Map<String, Integer> getReactionScores() {
        return this.reactionScores;
    }

    public final void setReactionScores(Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.reactionScores = map;
    }

    public final SyncStatus getSyncStatus() {
        return this.syncStatus;
    }

    public final void setSyncStatus(SyncStatus syncStatus2) {
        Intrinsics.checkNotNullParameter(syncStatus2, "<set-?>");
        this.syncStatus = syncStatus2;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final List<Reaction> getLatestReactions() {
        return this.latestReactions;
    }

    public final void setLatestReactions(List<Reaction> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.latestReactions = list;
    }

    public final List<Reaction> getOwnReactions() {
        return this.ownReactions;
    }

    public final void setOwnReactions(List<Reaction> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.ownReactions = list;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public final Date getDeletedAt() {
        return this.deletedAt;
    }

    public final void setDeletedAt(Date date) {
        this.deletedAt = date;
    }

    public final Date getUpdatedLocallyAt() {
        return this.updatedLocallyAt;
    }

    public final void setUpdatedLocallyAt(Date date) {
        this.updatedLocallyAt = date;
    }

    public final Date getCreatedLocallyAt() {
        return this.createdLocallyAt;
    }

    public final void setCreatedLocallyAt(Date date) {
        this.createdLocallyAt = date;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user2) {
        Intrinsics.checkNotNullParameter(user2, "<set-?>");
        this.user = user2;
    }

    public Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public void setExtraData(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraData = map;
    }

    public final boolean getSilent() {
        return this.silent;
    }

    public final void setSilent(boolean z) {
        this.silent = z;
    }

    public final boolean getShadowed() {
        return this.shadowed;
    }

    public final void setShadowed(boolean z) {
        this.shadowed = z;
    }

    public final Map<String, String> getI18n() {
        return this.i18n;
    }

    public final boolean getShowInChannel() {
        return this.showInChannel;
    }

    public final void setShowInChannel(boolean z) {
        this.showInChannel = z;
    }

    public final ChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public final void setChannelInfo(ChannelInfo channelInfo2) {
        this.channelInfo = channelInfo2;
    }

    public final Message getReplyTo() {
        return this.replyTo;
    }

    public final void setReplyTo(Message message) {
        this.replyTo = message;
    }

    public final String getReplyMessageId() {
        return this.replyMessageId;
    }

    public final void setReplyMessageId(String str) {
        this.replyMessageId = str;
    }

    public final boolean getPinned() {
        return this.pinned;
    }

    public final void setPinned(boolean z) {
        this.pinned = z;
    }

    public final Date getPinnedAt() {
        return this.pinnedAt;
    }

    public final void setPinnedAt(Date date) {
        this.pinnedAt = date;
    }

    public final Date getPinExpires() {
        return this.pinExpires;
    }

    public final void setPinExpires(Date date) {
        this.pinExpires = date;
    }

    public final User getPinnedBy() {
        return this.pinnedBy;
    }

    public final void setPinnedBy(User user2) {
        this.pinnedBy = user2;
    }

    public final List<User> getThreadParticipants() {
        return this.threadParticipants;
    }

    public final void setThreadParticipants(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.threadParticipants = list;
    }
}

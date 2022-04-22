package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u00109\u001a\u00020:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010A\u001a\u00020B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010I\u001a\u00020J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0011\u0010M\u001a\u00020N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0011\u0010Q\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0011\u0010U\u001a\u00020V¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0011\u0010Y\u001a\u00020Z¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0011\u0010]\u001a\u00020^¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0011\u0010a\u001a\u00020b¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0011\u0010e\u001a\u00020f¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0011\u0010i\u001a\u00020j¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u0017\u0010m\u001a\u00020n¢\u0006\u000e\n\u0000\u0012\u0004\bo\u0010p\u001a\u0004\bq\u0010rR\u0011\u0010s\u001a\u00020t¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0011\u0010w\u001a\u00020x¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0011\u0010{\u001a\u00020|¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u0014\u0010\u001a\u00030\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0001\u001a\u00030\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0001\u001a\u00030\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0001\u001a\u00030\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/UseCaseHelper;", "", "chatDomainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "cancelMessage", "Lio/getstream/chat/android/livedata/usecase/CancelMessage;", "getCancelMessage", "()Lio/getstream/chat/android/livedata/usecase/CancelMessage;", "createChannel", "Lio/getstream/chat/android/livedata/usecase/CreateChannel;", "getCreateChannel", "()Lio/getstream/chat/android/livedata/usecase/CreateChannel;", "deleteChannel", "Lio/getstream/chat/android/livedata/usecase/DeleteChannel;", "getDeleteChannel", "()Lio/getstream/chat/android/livedata/usecase/DeleteChannel;", "deleteMessage", "Lio/getstream/chat/android/livedata/usecase/DeleteMessage;", "getDeleteMessage", "()Lio/getstream/chat/android/livedata/usecase/DeleteMessage;", "deleteReaction", "Lio/getstream/chat/android/livedata/usecase/DeleteReaction;", "getDeleteReaction", "()Lio/getstream/chat/android/livedata/usecase/DeleteReaction;", "downloadAttachment", "Lio/getstream/chat/android/livedata/usecase/DownloadAttachment;", "getDownloadAttachment", "()Lio/getstream/chat/android/livedata/usecase/DownloadAttachment;", "editMessage", "Lio/getstream/chat/android/livedata/usecase/EditMessage;", "getEditMessage", "()Lio/getstream/chat/android/livedata/usecase/EditMessage;", "getChannelController", "Lio/getstream/chat/android/livedata/usecase/GetChannelController;", "getGetChannelController", "()Lio/getstream/chat/android/livedata/usecase/GetChannelController;", "getThread", "Lio/getstream/chat/android/livedata/usecase/GetThread;", "getGetThread", "()Lio/getstream/chat/android/livedata/usecase/GetThread;", "getTotalUnreadCount", "Lio/getstream/chat/android/livedata/usecase/GetTotalUnreadCount;", "getGetTotalUnreadCount", "()Lio/getstream/chat/android/livedata/usecase/GetTotalUnreadCount;", "getUnreadChannelCount", "Lio/getstream/chat/android/livedata/usecase/GetUnreadChannelCount;", "getGetUnreadChannelCount", "()Lio/getstream/chat/android/livedata/usecase/GetUnreadChannelCount;", "hideChannel", "Lio/getstream/chat/android/livedata/usecase/HideChannel;", "getHideChannel", "()Lio/getstream/chat/android/livedata/usecase/HideChannel;", "keystroke", "Lio/getstream/chat/android/livedata/usecase/Keystroke;", "getKeystroke", "()Lio/getstream/chat/android/livedata/usecase/Keystroke;", "leaveChannel", "Lio/getstream/chat/android/livedata/usecase/LeaveChannel;", "getLeaveChannel", "()Lio/getstream/chat/android/livedata/usecase/LeaveChannel;", "loadMessageById", "Lio/getstream/chat/android/livedata/usecase/LoadMessageById;", "getLoadMessageById", "()Lio/getstream/chat/android/livedata/usecase/LoadMessageById;", "loadNewerMessages", "Lio/getstream/chat/android/livedata/usecase/LoadNewerMessages;", "getLoadNewerMessages", "()Lio/getstream/chat/android/livedata/usecase/LoadNewerMessages;", "loadOlderMessages", "Lio/getstream/chat/android/livedata/usecase/LoadOlderMessages;", "getLoadOlderMessages", "()Lio/getstream/chat/android/livedata/usecase/LoadOlderMessages;", "markAllRead", "Lio/getstream/chat/android/livedata/usecase/MarkAllRead;", "getMarkAllRead", "()Lio/getstream/chat/android/livedata/usecase/MarkAllRead;", "markRead", "Lio/getstream/chat/android/livedata/usecase/MarkRead;", "getMarkRead", "()Lio/getstream/chat/android/livedata/usecase/MarkRead;", "queryChannels", "Lio/getstream/chat/android/livedata/usecase/QueryChannels;", "getQueryChannels", "()Lio/getstream/chat/android/livedata/usecase/QueryChannels;", "queryChannelsLoadMore", "Lio/getstream/chat/android/livedata/usecase/QueryChannelsLoadMore;", "getQueryChannelsLoadMore", "()Lio/getstream/chat/android/livedata/usecase/QueryChannelsLoadMore;", "queryMembers", "Lio/getstream/chat/android/livedata/usecase/QueryMembers;", "getQueryMembers", "()Lio/getstream/chat/android/livedata/usecase/QueryMembers;", "replayEventsForActiveChannels", "Lio/getstream/chat/android/livedata/usecase/ReplayEventsForActiveChannels;", "getReplayEventsForActiveChannels", "()Lio/getstream/chat/android/livedata/usecase/ReplayEventsForActiveChannels;", "searchUsersByName", "Lio/getstream/chat/android/livedata/usecase/SearchUsersByName;", "getSearchUsersByName", "()Lio/getstream/chat/android/livedata/usecase/SearchUsersByName;", "sendGiphy", "Lio/getstream/chat/android/livedata/usecase/SendGiphy;", "getSendGiphy", "()Lio/getstream/chat/android/livedata/usecase/SendGiphy;", "sendMessage", "Lio/getstream/chat/android/livedata/usecase/SendMessage;", "getSendMessage", "()Lio/getstream/chat/android/livedata/usecase/SendMessage;", "sendMessageWithAttachments", "Lio/getstream/chat/android/livedata/usecase/SendMessageWithAttachments;", "getSendMessageWithAttachments$annotations", "()V", "getSendMessageWithAttachments", "()Lio/getstream/chat/android/livedata/usecase/SendMessageWithAttachments;", "sendReaction", "Lio/getstream/chat/android/livedata/usecase/SendReaction;", "getSendReaction", "()Lio/getstream/chat/android/livedata/usecase/SendReaction;", "setMessageForReply", "Lio/getstream/chat/android/livedata/usecase/SetMessageForReply;", "getSetMessageForReply", "()Lio/getstream/chat/android/livedata/usecase/SetMessageForReply;", "showChannel", "Lio/getstream/chat/android/livedata/usecase/ShowChannel;", "getShowChannel", "()Lio/getstream/chat/android/livedata/usecase/ShowChannel;", "shuffleGiphy", "Lio/getstream/chat/android/livedata/usecase/ShuffleGiphy;", "getShuffleGiphy", "()Lio/getstream/chat/android/livedata/usecase/ShuffleGiphy;", "stopTyping", "Lio/getstream/chat/android/livedata/usecase/StopTyping;", "getStopTyping", "()Lio/getstream/chat/android/livedata/usecase/StopTyping;", "threadLoadMore", "Lio/getstream/chat/android/livedata/usecase/ThreadLoadMore;", "getThreadLoadMore", "()Lio/getstream/chat/android/livedata/usecase/ThreadLoadMore;", "watchChannel", "Lio/getstream/chat/android/livedata/usecase/WatchChannel;", "getWatchChannel", "()Lio/getstream/chat/android/livedata/usecase/WatchChannel;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.UseCaseHelper */
/* compiled from: UseCaseHelper.kt */
public final class UseCaseHelper {
    private final CancelMessage cancelMessage;
    private final CreateChannel createChannel;
    private final DeleteChannel deleteChannel;
    private final DeleteMessage deleteMessage;
    private final DeleteReaction deleteReaction;
    private final DownloadAttachment downloadAttachment;
    private final EditMessage editMessage;
    private final GetChannelController getChannelController;
    private final GetThread getThread;
    private final GetTotalUnreadCount getTotalUnreadCount;
    private final GetUnreadChannelCount getUnreadChannelCount;
    private final HideChannel hideChannel;
    private final Keystroke keystroke;
    private final LeaveChannel leaveChannel;
    private final LoadMessageById loadMessageById;
    private final LoadNewerMessages loadNewerMessages;
    private final LoadOlderMessages loadOlderMessages;
    private final MarkAllRead markAllRead;
    private final MarkRead markRead;
    private final QueryChannels queryChannels;
    private final QueryChannelsLoadMore queryChannelsLoadMore;
    private final QueryMembers queryMembers;
    private final ReplayEventsForActiveChannels replayEventsForActiveChannels;
    private final SearchUsersByName searchUsersByName;
    private final SendGiphy sendGiphy;
    private final SendMessage sendMessage;
    private final SendMessageWithAttachments sendMessageWithAttachments;
    private final SendReaction sendReaction;
    private final SetMessageForReply setMessageForReply;
    private final ShowChannel showChannel;
    private final ShuffleGiphy shuffleGiphy;
    private final StopTyping stopTyping;
    private final ThreadLoadMore threadLoadMore;
    private final WatchChannel watchChannel;

    public static /* synthetic */ void getSendMessageWithAttachments$annotations() {
    }

    public UseCaseHelper(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "chatDomainImpl");
        this.replayEventsForActiveChannels = new ReplayEventsForActiveChannelsImpl(chatDomainImpl);
        this.getChannelController = new GetChannelControllerImpl(chatDomainImpl);
        this.watchChannel = new WatchChannelImpl(chatDomainImpl);
        this.queryChannels = new QueryChannelsImpl(chatDomainImpl);
        this.getThread = new GetThreadImpl(chatDomainImpl);
        this.getTotalUnreadCount = new GetTotalUnreadCountImpl(chatDomainImpl);
        this.getUnreadChannelCount = new GetUnreadChannelCountImpl(chatDomainImpl);
        this.loadOlderMessages = new LoadOlderMessagesImpl(chatDomainImpl);
        this.loadNewerMessages = new LoadNewerMessagesImpl(chatDomainImpl);
        this.loadMessageById = new LoadMessageByIdImpl(chatDomainImpl);
        this.queryChannelsLoadMore = new QueryChannelsLoadMoreImpl(chatDomainImpl);
        this.threadLoadMore = new ThreadLoadMoreImpl(chatDomainImpl);
        this.createChannel = new CreateChannelImpl(chatDomainImpl);
        this.sendMessage = new SendMessageImpl(chatDomainImpl);
        this.cancelMessage = new CancelMessageImpl(chatDomainImpl);
        this.shuffleGiphy = new ShuffleGiphyImpl(chatDomainImpl);
        this.sendGiphy = new SendGiphyImpl(chatDomainImpl);
        this.sendMessageWithAttachments = new SendMessageWithAttachmentsImpl(chatDomainImpl);
        this.editMessage = new EditMessageImpl(chatDomainImpl);
        this.deleteMessage = new DeleteMessageImpl(chatDomainImpl);
        this.sendReaction = new SendReactionImpl(chatDomainImpl);
        this.deleteReaction = new DeleteReactionImpl(chatDomainImpl);
        this.keystroke = new KeystrokeImpl(chatDomainImpl);
        this.stopTyping = new StopTypingImpl(chatDomainImpl);
        this.markRead = new MarkReadImpl(chatDomainImpl);
        this.markAllRead = new MarkAllReadImpl(chatDomainImpl);
        this.hideChannel = new HideChannelImpl(chatDomainImpl);
        this.showChannel = new ShowChannelImpl(chatDomainImpl);
        this.leaveChannel = new LeaveChannelImpl(chatDomainImpl);
        this.deleteChannel = new DeleteChannelImpl(chatDomainImpl);
        this.setMessageForReply = new SetMessageForReplyImpl(chatDomainImpl);
        this.downloadAttachment = new DownloadAttachmentImpl(chatDomainImpl);
        this.searchUsersByName = new SearchUsersByName(chatDomainImpl);
        this.queryMembers = new QueryMembers(chatDomainImpl);
    }

    public final ReplayEventsForActiveChannels getReplayEventsForActiveChannels() {
        return this.replayEventsForActiveChannels;
    }

    public final GetChannelController getGetChannelController() {
        return this.getChannelController;
    }

    public final WatchChannel getWatchChannel() {
        return this.watchChannel;
    }

    public final QueryChannels getQueryChannels() {
        return this.queryChannels;
    }

    public final GetThread getGetThread() {
        return this.getThread;
    }

    public final GetTotalUnreadCount getGetTotalUnreadCount() {
        return this.getTotalUnreadCount;
    }

    public final GetUnreadChannelCount getGetUnreadChannelCount() {
        return this.getUnreadChannelCount;
    }

    public final LoadOlderMessages getLoadOlderMessages() {
        return this.loadOlderMessages;
    }

    public final LoadNewerMessages getLoadNewerMessages() {
        return this.loadNewerMessages;
    }

    public final LoadMessageById getLoadMessageById() {
        return this.loadMessageById;
    }

    public final QueryChannelsLoadMore getQueryChannelsLoadMore() {
        return this.queryChannelsLoadMore;
    }

    public final ThreadLoadMore getThreadLoadMore() {
        return this.threadLoadMore;
    }

    public final CreateChannel getCreateChannel() {
        return this.createChannel;
    }

    public final SendMessage getSendMessage() {
        return this.sendMessage;
    }

    public final CancelMessage getCancelMessage() {
        return this.cancelMessage;
    }

    public final ShuffleGiphy getShuffleGiphy() {
        return this.shuffleGiphy;
    }

    public final SendGiphy getSendGiphy() {
        return this.sendGiphy;
    }

    public final SendMessageWithAttachments getSendMessageWithAttachments() {
        return this.sendMessageWithAttachments;
    }

    public final EditMessage getEditMessage() {
        return this.editMessage;
    }

    public final DeleteMessage getDeleteMessage() {
        return this.deleteMessage;
    }

    public final SendReaction getSendReaction() {
        return this.sendReaction;
    }

    public final DeleteReaction getDeleteReaction() {
        return this.deleteReaction;
    }

    public final Keystroke getKeystroke() {
        return this.keystroke;
    }

    public final StopTyping getStopTyping() {
        return this.stopTyping;
    }

    public final MarkRead getMarkRead() {
        return this.markRead;
    }

    public final MarkAllRead getMarkAllRead() {
        return this.markAllRead;
    }

    public final HideChannel getHideChannel() {
        return this.hideChannel;
    }

    public final ShowChannel getShowChannel() {
        return this.showChannel;
    }

    public final LeaveChannel getLeaveChannel() {
        return this.leaveChannel;
    }

    public final DeleteChannel getDeleteChannel() {
        return this.deleteChannel;
    }

    public final SetMessageForReply getSetMessageForReply() {
        return this.setMessageForReply;
    }

    public final DownloadAttachment getDownloadAttachment() {
        return this.downloadAttachment;
    }

    public final SearchUsersByName getSearchUsersByName() {
        return this.searchUsersByName;
    }

    public final QueryMembers getQueryMembers() {
        return this.queryMembers;
    }
}

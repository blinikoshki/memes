package com.getstream.sdk.chat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.DefaultBubbleHelper;
import com.getstream.sdk.chat.adapter.AttachmentViewHolderFactory;
import com.getstream.sdk.chat.adapter.ListenerContainer;
import com.getstream.sdk.chat.adapter.ListenerContainerImpl;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.adapter.MessageListItemAdapter;
import com.getstream.sdk.chat.adapter.MessageViewHolderFactory;
import com.getstream.sdk.chat.databinding.StreamMessageListViewBinding;
import com.getstream.sdk.chat.enums.GiphyAction;
import com.getstream.sdk.chat.utils.DateFormatter;
import com.getstream.sdk.chat.utils.StartStopBuffer;
import com.getstream.sdk.chat.view.messages.MessageListItemWrapper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\u001e³\u0001´\u0001µ\u0001¶\u0001·\u0001¸\u0001¹\u0001º\u0001»\u0001¼\u0001½\u0001¾\u0001¿\u0001À\u0001Á\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010f\u001a\u0002062\u0006\u0010g\u001a\u00020\u0006H\u0002J.\u0010h\u001a\u0002062\u0006\u0010i\u001a\u0002092\u0006\u0010j\u001a\u00020%2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020<0l2\u0006\u0010m\u001a\u00020\tH\u0002J\u000e\u0010n\u001a\u0002062\u0006\u0010j\u001a\u00020%J\b\u0010o\u001a\u00020\tH\u0002J\u0010\u0010p\u001a\u0002062\u0006\u0010j\u001a\u00020%H\u0002J\u0006\u0010q\u001a\u000206J\u0006\u0010r\u001a\u000206J\u001a\u0010s\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010t\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010s\u001a\u0002062\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\b\u0010u\u001a\u000206H\u0002J\b\u0010v\u001a\u000206H\u0002J\b\u0010w\u001a\u000206H\u0002J\b\u0010x\u001a\u000206H\u0002J\b\u0010y\u001a\u000206H\u0002J\b\u0010z\u001a\u000206H\u0002J\b\u0010{\u001a\u000206H\u0002J\b\u0010|\u001a\u00020\tH\u0002J\u001a\u0010}\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010~\u001a\u000206J\u000f\u0010\u001a\u0002062\u0007\u0010\u0001\u001a\u00020TJ\u0012\u0010\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u0001\u001a\u0002062\t\u0010\u0001\u001a\u0004\u0018\u00010\fJ\u000f\u0010\u0001\u001a\u0002062\u0006\u0010\u001d\u001a\u00020\u001eJ\u000f\u0010\u0001\u001a\u0002062\u0006\u0010!\u001a\u00020\"J\u001b\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u0002012\t\b\u0002\u0010\u0001\u001a\u00020+J\u0015\u0010\u0001\u001a\u0002062\f\u00104\u001a\b\u0012\u0004\u0012\u00020605J\u0015\u0010\u0001\u001a\u0002062\f\u0010:\u001a\b\u0012\u0004\u0012\u00020605J\u0010\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u000209J\u001b\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u0002012\t\b\u0002\u0010\u0001\u001a\u00020+J\u0012\u0010\u0001\u001a\u0002062\t\u0010\u0001\u001a\u0004\u0018\u00010\u0010J\u000f\u0010\u0001\u001a\u0002062\u0006\u0010I\u001a\u00020JJ\u0011\u0010\u0001\u001a\u0002062\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u0001\u001a\u0002062\t\u0010\u0001\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0001\u001a\u0002062\t\u0010\u0001\u001a\u0004\u0018\u00010\u0014J\u000f\u0010\u0001\u001a\u0002062\u0006\u0010K\u001a\u00020LJ\u000f\u0010\u0001\u001a\u0002062\u0006\u0010M\u001a\u00020NJ\u001b\u0010\u0001\u001a\u0002062\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SJ\u001b\u0010\u0001\u001a\u0002062\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SJ\u001b\u0010\u0001\u001a\u0002062\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SJ\u001b\u0010\u0001\u001a\u0002062\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SJ!\u0010\u0001\u001a\u0002062\u0018\u0010X\u001a\u0014\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u0002060YJ\u001b\u0010\u0001\u001a\u0002062\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SJ\u001b\u0010\u0001\u001a\u0002062\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SJ\u0012\u0010 \u0001\u001a\u0002062\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u0016J\u0012\u0010¢\u0001\u001a\u0002062\t\u0010£\u0001\u001a\u0004\u0018\u00010\u0018J\u0013\u0010¤\u0001\u001a\u0002062\n\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001J\u0012\u0010§\u0001\u001a\u0002062\t\b\u0001\u0010¨\u0001\u001a\u00020\tJ\u000f\u0010©\u0001\u001a\u0002062\u0006\u0010]\u001a\u00020^J\u0013\u0010ª\u0001\u001a\u0002062\n\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001J\u0012\u0010«\u0001\u001a\u0002062\t\b\u0001\u0010¨\u0001\u001a\u00020\tJ\u0012\u0010¬\u0001\u001a\u0002062\t\u0010­\u0001\u001a\u0004\u0018\u00010\u001aJ\u0011\u0010®\u0001\u001a\u0002062\u0006\u0010K\u001a\u00020LH\u0007J\u0007\u0010¯\u0001\u001a\u000206J\u0007\u0010°\u0001\u001a\u000206J\u0014\u0010±\u0001\u001a\u0002062\t\u0010²\u0001\u001a\u0004\u0018\u00010<H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u000e\u00100\u001a\u000201X.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X.¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020605X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020605X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u000201X.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u000203X.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u000209X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX.¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX.¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX.¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010W\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SX\u000e¢\u0006\u0002\n\u0000R \u0010X\u001a\u0014\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u0002060YX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u0002060SX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X.¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020`X.¢\u0006\u0002\n\u0000R\u001a\u0010a\u001a\u000209X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e¨\u0006Â\u0001"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_ATTACHMENT_CLICK_LISTENER", "Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;", "DEFAULT_GIPHY_SEND_LISTENER", "Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;", "DEFAULT_MESSAGE_CLICK_LISTENER", "Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;", "DEFAULT_MESSAGE_LONG_CLICK_LISTENER", "Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", "DEFAULT_MESSAGE_RETRY_LISTENER", "Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;", "DEFAULT_REACTION_VIEW_CLICK_LISTENER", "Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;", "DEFAULT_READ_STATE_CLICK_LISTENER", "Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;", "DEFAULT_USER_CLICK_LISTENER", "Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;", "adapter", "Lcom/getstream/sdk/chat/adapter/MessageListItemAdapter;", "attachmentViewHolderFactory", "Lcom/getstream/sdk/chat/adapter/AttachmentViewHolderFactory;", "binding", "Lcom/getstream/sdk/chat/databinding/StreamMessageListViewBinding;", "bubbleHelper", "Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", "buffer", "Lcom/getstream/sdk/chat/utils/StartStopBuffer;", "Lcom/getstream/sdk/chat/view/messages/MessageListItemWrapper;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "currentUser", "Lio/getstream/chat/android/client/models/User;", "defaultChildLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "getDefaultChildLayoutParams", "()Landroid/widget/FrameLayout$LayoutParams;", "defaultChildLayoutParams$delegate", "Lkotlin/Lazy;", "emptyStateView", "Landroid/view/View;", "emptyStateViewContainer", "Landroid/view/ViewGroup;", "endRegionReachedHandler", "Lkotlin/Function0;", "", "firstVisiblePosition", "hasScrolledUp", "", "lastMessageReadHandler", "lastSeenMessageInChannel", "Lcom/getstream/sdk/chat/adapter/MessageListItem;", "lastSeenMessageInThread", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "listenerContainer", "Lcom/getstream/sdk/chat/adapter/ListenerContainer;", "loadMoreListener", "Lcom/getstream/sdk/chat/view/EndlessScrollListener;", "loadingView", "loadingViewContainer", "lockScrollUp", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "messageDateFormatter", "Lcom/getstream/sdk/chat/utils/DateFormatter;", "messageViewHolderFactory", "Lcom/getstream/sdk/chat/adapter/MessageViewHolderFactory;", "newMessagesBehaviour", "Lcom/getstream/sdk/chat/view/MessageListView$NewMessagesBehaviour;", "newMessagesTextPlural", "", "newMessagesTextSingle", "onMessageDeleteHandler", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/models/Message;", "onMessageEditHandler", "onMessageFlagHandler", "onMessageRetryHandler", "onSendGiphyHandler", "Lkotlin/Function2;", "Lcom/getstream/sdk/chat/enums/GiphyAction;", "onStartThreadHandler", "onStartThreadListener", "scrollButtonBehaviour", "Lcom/getstream/sdk/chat/view/MessageListView$ScrollButtonBehaviour;", "style", "Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "unseenButtonEnabled", "getUnseenButtonEnabled", "()Z", "setUnseenButtonEnabled", "(Z)V", "configureAttributes", "attributeSet", "continueMessageAdd", "startThreadMode", "listItem", "entities", "", "oldSize", "displayNewMessage", "getLastSeenMessagePosition", "handleNewWrapper", "hideEmptyStateView", "hideLoadingView", "init", "attr", "initAdapter", "initEmptyStateView", "initLoadingView", "initRecyclerView", "initScrollButtonBehaviour", "initUnseenMessagesButton", "initUnseenMessagesView", "lastPosition", "parseAttr", "scrollToBottom", "scrollToMessage", "message", "scrolledBottom", "delta", "setAttachmentClickListener", "attachmentClickListener", "setAttachmentViewHolderFactory", "setBubbleHelper", "setEmptyStateView", "view", "layoutParams", "setEndRegionReachedHandler", "setLastMessageReadHandler", "setLoadingMore", "loadingMore", "setLoadingView", "setMessageClickListener", "messageClickListener", "setMessageDateFormatter", "setMessageListItemAdapter", "setMessageLongClickListener", "messageLongClickListener", "setMessageRetryListener", "messageRetryListener", "setMessageViewHolderFactory", "setNewMessagesBehaviour", "setOnMessageDeleteHandler", "setOnMessageEditHandler", "setOnMessageFlagHandler", "setOnMessageRetryHandler", "setOnSendGiphyHandler", "setOnStartThreadHandler", "setOnStartThreadListener", "setReactionViewClickListener", "reactionViewClickListener", "setReadStateClickListener", "readStateClickListener", "setScrollButtonBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setScrollButtonBackgroundResource", "backgroundRes", "setScrollButtonBehaviour", "setScrollButtonIcon", "setScrollButtonIconResource", "setUserClickListener", "userClickListener", "setViewHolderFactory", "showEmptyStateView", "showLoadingView", "updateLastSeen", "messageListItem", "AttachmentClickListener", "BubbleHelper", "DefaultScrollButtonBehaviour", "GiphySendListener", "HeaderAvatarGroupClickListener", "HeaderOptionsClickListener", "MessageClickListener", "MessageLongClickListener", "MessageLongClickListenerView", "MessageRetryListener", "NewMessagesBehaviour", "ReactionViewClickListener", "ReadStateClickListener", "ScrollButtonBehaviour", "UserClickListener", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
public final class MessageListView extends ConstraintLayout {
    private final AttachmentClickListener DEFAULT_ATTACHMENT_CLICK_LISTENER;
    private final GiphySendListener DEFAULT_GIPHY_SEND_LISTENER;
    private final MessageClickListener DEFAULT_MESSAGE_CLICK_LISTENER;
    private final MessageLongClickListener DEFAULT_MESSAGE_LONG_CLICK_LISTENER;
    private final MessageRetryListener DEFAULT_MESSAGE_RETRY_LISTENER;
    private final ReactionViewClickListener DEFAULT_REACTION_VIEW_CLICK_LISTENER;
    private final ReadStateClickListener DEFAULT_READ_STATE_CLICK_LISTENER;
    private final UserClickListener DEFAULT_USER_CLICK_LISTENER;
    /* access modifiers changed from: private */
    public MessageListItemAdapter adapter;
    /* access modifiers changed from: private */
    public AttachmentViewHolderFactory attachmentViewHolderFactory;
    /* access modifiers changed from: private */
    public StreamMessageListViewBinding binding;
    /* access modifiers changed from: private */
    public BubbleHelper bubbleHelper;
    private final StartStopBuffer<MessageListItemWrapper> buffer = new StartStopBuffer<>();
    /* access modifiers changed from: private */
    public Channel channel;
    /* access modifiers changed from: private */
    public User currentUser;
    private final Lazy defaultChildLayoutParams$delegate = LazyKt.lazy(MessageListView$defaultChildLayoutParams$2.INSTANCE);
    private View emptyStateView;
    private ViewGroup emptyStateViewContainer;
    /* access modifiers changed from: private */
    public Function0<Unit> endRegionReachedHandler = MessageListView$endRegionReachedHandler$1.INSTANCE;
    /* access modifiers changed from: private */
    public int firstVisiblePosition;
    /* access modifiers changed from: private */
    public boolean hasScrolledUp;
    private Function0<Unit> lastMessageReadHandler = MessageListView$lastMessageReadHandler$1.INSTANCE;
    private MessageListItem lastSeenMessageInChannel;
    private MessageListItem lastSeenMessageInThread;
    /* access modifiers changed from: private */
    public LinearLayoutManager layoutManager;
    private final ListenerContainer listenerContainer;
    private EndlessScrollListener loadMoreListener;
    private View loadingView;
    private ViewGroup loadingViewContainer;
    /* access modifiers changed from: private */
    public boolean lockScrollUp = true;
    private final TaggedLogger logger = ChatLogger.Companion.get("MessageListView");
    /* access modifiers changed from: private */
    public DateFormatter messageDateFormatter;
    /* access modifiers changed from: private */
    public MessageViewHolderFactory messageViewHolderFactory;
    private NewMessagesBehaviour newMessagesBehaviour;
    private String newMessagesTextPlural;
    private String newMessagesTextSingle;
    /* access modifiers changed from: private */
    public Function1<? super Message, Unit> onMessageDeleteHandler = MessageListView$onMessageDeleteHandler$1.INSTANCE;
    /* access modifiers changed from: private */
    public Function1<? super Message, Unit> onMessageEditHandler = MessageListView$onMessageEditHandler$1.INSTANCE;
    /* access modifiers changed from: private */
    public Function1<? super Message, Unit> onMessageFlagHandler = MessageListView$onMessageFlagHandler$1.INSTANCE;
    /* access modifiers changed from: private */
    public Function1<? super Message, Unit> onMessageRetryHandler = MessageListView$onMessageRetryHandler$1.INSTANCE;
    /* access modifiers changed from: private */
    public Function2<? super Message, ? super GiphyAction, Unit> onSendGiphyHandler = MessageListView$onSendGiphyHandler$1.INSTANCE;
    /* access modifiers changed from: private */
    public Function1<? super Message, Unit> onStartThreadHandler = MessageListView$onStartThreadHandler$1.INSTANCE;
    /* access modifiers changed from: private */
    public Function1<? super Message, Unit> onStartThreadListener = MessageListView$onStartThreadListener$1.INSTANCE;
    /* access modifiers changed from: private */
    public ScrollButtonBehaviour scrollButtonBehaviour;
    /* access modifiers changed from: private */
    public MessageListViewStyle style;
    private boolean unseenButtonEnabled = true;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;", "", "onAttachmentClick", "", "message", "Lio/getstream/chat/android/client/models/Message;", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface AttachmentClickListener {
        void onAttachmentClick(Message message, Attachment attachment);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH&J&\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J&\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$BubbleHelper;", "", "getDrawableForAttachment", "Landroid/graphics/drawable/Drawable;", "message", "Lio/getstream/chat/android/client/models/Message;", "mine", "", "positions", "", "Lcom/getstream/sdk/chat/adapter/MessageListItem$Position;", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "getDrawableForAttachmentDescription", "getDrawableForMessage", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface BubbleHelper {
        Drawable getDrawableForAttachment(Message message, boolean z, List<? extends MessageListItem.Position> list, Attachment attachment);

        Drawable getDrawableForAttachmentDescription(Message message, boolean z, List<? extends MessageListItem.Position> list);

        Drawable getDrawableForMessage(Message message, boolean z, List<? extends MessageListItem.Position> list);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$GiphySendListener;", "", "onGiphySend", "", "message", "Lio/getstream/chat/android/client/models/Message;", "action", "Lcom/getstream/sdk/chat/enums/GiphyAction;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface GiphySendListener {
        void onGiphySend(Message message, GiphyAction giphyAction);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$HeaderAvatarGroupClickListener;", "", "onHeaderAvatarGroupClick", "", "channel", "Lio/getstream/chat/android/client/models/Channel;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface HeaderAvatarGroupClickListener {
        void onHeaderAvatarGroupClick(Channel channel);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$HeaderOptionsClickListener;", "", "onHeaderOptionsClick", "", "channel", "Lio/getstream/chat/android/client/models/Channel;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface HeaderOptionsClickListener {
        void onHeaderOptionsClick(Channel channel);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$MessageClickListener;", "", "onMessageClick", "", "message", "Lio/getstream/chat/android/client/models/Message;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface MessageClickListener {
        void onMessageClick(Message message);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListener;", "", "onMessageLongClick", "", "message", "Lio/getstream/chat/android/client/models/Message;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface MessageLongClickListener {
        void onMessageLongClick(Message message);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$MessageLongClickListenerView;", "", "onMessageLongClick2", "", "message", "Lio/getstream/chat/android/client/models/Message;", "view", "Landroid/view/View;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface MessageLongClickListenerView {
        void onMessageLongClick2(Message message, View view);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$MessageRetryListener;", "", "onRetryMessage", "", "message", "Lio/getstream/chat/android/client/models/Message;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface MessageRetryListener {
        void onRetryMessage(Message message);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$ReactionViewClickListener;", "", "onReactionViewClick", "", "message", "Lio/getstream/chat/android/client/models/Message;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface ReactionViewClickListener {
        void onReactionViewClick(Message message);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$ReadStateClickListener;", "", "onReadStateClick", "", "reads", "", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface ReadStateClickListener {
        void onReadStateClick(List<ChannelUserRead> list);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$ScrollButtonBehaviour;", "", "onUnreadMessageCountChanged", "", "count", "", "userScrolledToTheBottom", "userScrolledUp", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface ScrollButtonBehaviour {
        void onUnreadMessageCountChanged(int i);

        void userScrolledToTheBottom();

        void userScrolledUp();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$UserClickListener;", "", "onUserClick", "", "user", "Lio/getstream/chat/android/client/models/User;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public interface UserClickListener {
        void onUserClick(User user);
    }

    private final FrameLayout.LayoutParams getDefaultChildLayoutParams() {
        return (FrameLayout.LayoutParams) this.defaultChildLayoutParams$delegate.getValue();
    }

    public static final /* synthetic */ MessageListItemAdapter access$getAdapter$p(MessageListView messageListView) {
        MessageListItemAdapter messageListItemAdapter = messageListView.adapter;
        if (messageListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return messageListItemAdapter;
    }

    public static final /* synthetic */ AttachmentViewHolderFactory access$getAttachmentViewHolderFactory$p(MessageListView messageListView) {
        AttachmentViewHolderFactory attachmentViewHolderFactory2 = messageListView.attachmentViewHolderFactory;
        if (attachmentViewHolderFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attachmentViewHolderFactory");
        }
        return attachmentViewHolderFactory2;
    }

    public static final /* synthetic */ StreamMessageListViewBinding access$getBinding$p(MessageListView messageListView) {
        StreamMessageListViewBinding streamMessageListViewBinding = messageListView.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return streamMessageListViewBinding;
    }

    public static final /* synthetic */ BubbleHelper access$getBubbleHelper$p(MessageListView messageListView) {
        BubbleHelper bubbleHelper2 = messageListView.bubbleHelper;
        if (bubbleHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleHelper");
        }
        return bubbleHelper2;
    }

    public static final /* synthetic */ Channel access$getChannel$p(MessageListView messageListView) {
        Channel channel2 = messageListView.channel;
        if (channel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        }
        return channel2;
    }

    public static final /* synthetic */ User access$getCurrentUser$p(MessageListView messageListView) {
        User user = messageListView.currentUser;
        if (user == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentUser");
        }
        return user;
    }

    public static final /* synthetic */ LinearLayoutManager access$getLayoutManager$p(MessageListView messageListView) {
        LinearLayoutManager linearLayoutManager = messageListView.layoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        return linearLayoutManager;
    }

    public static final /* synthetic */ DateFormatter access$getMessageDateFormatter$p(MessageListView messageListView) {
        DateFormatter dateFormatter = messageListView.messageDateFormatter;
        if (dateFormatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageDateFormatter");
        }
        return dateFormatter;
    }

    public static final /* synthetic */ MessageViewHolderFactory access$getMessageViewHolderFactory$p(MessageListView messageListView) {
        MessageViewHolderFactory messageViewHolderFactory2 = messageListView.messageViewHolderFactory;
        if (messageViewHolderFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewHolderFactory");
        }
        return messageViewHolderFactory2;
    }

    public static final /* synthetic */ ScrollButtonBehaviour access$getScrollButtonBehaviour$p(MessageListView messageListView) {
        ScrollButtonBehaviour scrollButtonBehaviour2 = messageListView.scrollButtonBehaviour;
        if (scrollButtonBehaviour2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollButtonBehaviour");
        }
        return scrollButtonBehaviour2;
    }

    public static final /* synthetic */ MessageListViewStyle access$getStyle$p(MessageListView messageListView) {
        MessageListViewStyle messageListViewStyle = messageListView.style;
        if (messageListViewStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("style");
        }
        return messageListViewStyle;
    }

    public final boolean getUnseenButtonEnabled() {
        return this.unseenButtonEnabled;
    }

    public final void setUnseenButtonEnabled(boolean z) {
        this.unseenButtonEnabled = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageListView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        MessageClickListener messageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1 = new MessageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1(this);
        this.DEFAULT_MESSAGE_CLICK_LISTENER = messageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1;
        MessageLongClickListener messageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1 = new MessageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1(this);
        this.DEFAULT_MESSAGE_LONG_CLICK_LISTENER = messageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1;
        MessageRetryListener messageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1 = new MessageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1(this);
        this.DEFAULT_MESSAGE_RETRY_LISTENER = messageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1;
        AttachmentClickListener messageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1 = new MessageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1(this);
        this.DEFAULT_ATTACHMENT_CLICK_LISTENER = messageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1;
        ReactionViewClickListener messageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1 = new MessageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1(this);
        this.DEFAULT_REACTION_VIEW_CLICK_LISTENER = messageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1;
        UserClickListener userClickListener = MessageListView$DEFAULT_USER_CLICK_LISTENER$1.INSTANCE;
        this.DEFAULT_USER_CLICK_LISTENER = userClickListener;
        ReadStateClickListener messageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1 = new MessageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1(this);
        this.DEFAULT_READ_STATE_CLICK_LISTENER = messageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1;
        GiphySendListener messageListView$DEFAULT_GIPHY_SEND_LISTENER$1 = new MessageListView$DEFAULT_GIPHY_SEND_LISTENER$1(this);
        this.DEFAULT_GIPHY_SEND_LISTENER = messageListView$DEFAULT_GIPHY_SEND_LISTENER$1;
        this.listenerContainer = new ListenerContainerImpl(messageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1, messageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1, messageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1, messageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1, messageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1, userClickListener, messageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1, messageListView$DEFAULT_GIPHY_SEND_LISTENER$1);
        init(context, (AttributeSet) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        MessageClickListener messageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1 = new MessageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1(this);
        this.DEFAULT_MESSAGE_CLICK_LISTENER = messageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1;
        MessageLongClickListener messageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1 = new MessageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1(this);
        this.DEFAULT_MESSAGE_LONG_CLICK_LISTENER = messageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1;
        MessageRetryListener messageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1 = new MessageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1(this);
        this.DEFAULT_MESSAGE_RETRY_LISTENER = messageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1;
        AttachmentClickListener messageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1 = new MessageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1(this);
        this.DEFAULT_ATTACHMENT_CLICK_LISTENER = messageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1;
        ReactionViewClickListener messageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1 = new MessageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1(this);
        this.DEFAULT_REACTION_VIEW_CLICK_LISTENER = messageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1;
        UserClickListener userClickListener = MessageListView$DEFAULT_USER_CLICK_LISTENER$1.INSTANCE;
        this.DEFAULT_USER_CLICK_LISTENER = userClickListener;
        ReadStateClickListener messageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1 = new MessageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1(this);
        this.DEFAULT_READ_STATE_CLICK_LISTENER = messageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1;
        GiphySendListener messageListView$DEFAULT_GIPHY_SEND_LISTENER$1 = new MessageListView$DEFAULT_GIPHY_SEND_LISTENER$1(this);
        this.DEFAULT_GIPHY_SEND_LISTENER = messageListView$DEFAULT_GIPHY_SEND_LISTENER$1;
        this.listenerContainer = new ListenerContainerImpl(messageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1, messageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1, messageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1, messageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1, messageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1, userClickListener, messageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1, messageListView$DEFAULT_GIPHY_SEND_LISTENER$1);
        parseAttr(context, attributeSet);
        init(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        MessageClickListener messageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1 = new MessageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1(this);
        this.DEFAULT_MESSAGE_CLICK_LISTENER = messageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1;
        MessageLongClickListener messageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1 = new MessageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1(this);
        this.DEFAULT_MESSAGE_LONG_CLICK_LISTENER = messageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1;
        MessageRetryListener messageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1 = new MessageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1(this);
        this.DEFAULT_MESSAGE_RETRY_LISTENER = messageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1;
        AttachmentClickListener messageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1 = new MessageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1(this);
        this.DEFAULT_ATTACHMENT_CLICK_LISTENER = messageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1;
        ReactionViewClickListener messageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1 = new MessageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1(this);
        this.DEFAULT_REACTION_VIEW_CLICK_LISTENER = messageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1;
        UserClickListener userClickListener = MessageListView$DEFAULT_USER_CLICK_LISTENER$1.INSTANCE;
        this.DEFAULT_USER_CLICK_LISTENER = userClickListener;
        ReadStateClickListener messageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1 = new MessageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1(this);
        this.DEFAULT_READ_STATE_CLICK_LISTENER = messageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1;
        GiphySendListener messageListView$DEFAULT_GIPHY_SEND_LISTENER$1 = new MessageListView$DEFAULT_GIPHY_SEND_LISTENER$1(this);
        this.DEFAULT_GIPHY_SEND_LISTENER = messageListView$DEFAULT_GIPHY_SEND_LISTENER$1;
        this.listenerContainer = new ListenerContainerImpl(messageListView$DEFAULT_MESSAGE_CLICK_LISTENER$1, messageListView$DEFAULT_MESSAGE_LONG_CLICK_LISTENER$1, messageListView$DEFAULT_MESSAGE_RETRY_LISTENER$1, messageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1, messageListView$DEFAULT_REACTION_VIEW_CLICK_LISTENER$1, userClickListener, messageListView$DEFAULT_READ_STATE_CLICK_LISTENER$1, messageListView$DEFAULT_GIPHY_SEND_LISTENER$1);
        parseAttr(context, attributeSet);
        init(context, attributeSet);
    }

    private final void initLoadingView() {
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = streamMessageListViewBinding.defaultLoadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.defaultLoadingView");
        this.loadingView = progressBar;
        StreamMessageListViewBinding streamMessageListViewBinding2 = this.binding;
        if (streamMessageListViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = streamMessageListViewBinding2.loadingViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingViewContainer");
        this.loadingViewContainer = frameLayout;
    }

    private final void initEmptyStateView() {
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = streamMessageListViewBinding.defaultEmptyStateView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.defaultEmptyStateView");
        this.emptyStateView = textView;
        StreamMessageListViewBinding streamMessageListViewBinding2 = this.binding;
        if (streamMessageListViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = streamMessageListViewBinding2.emptyStateViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.emptyStateViewContainer");
        this.emptyStateViewContainer = frameLayout;
    }

    private final void initScrollButtonBehaviour() {
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ConstraintLayout constraintLayout = streamMessageListViewBinding.scrollBottomBtn;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.scrollBottomBtn");
        ViewGroup viewGroup = constraintLayout;
        StreamMessageListViewBinding streamMessageListViewBinding2 = this.binding;
        if (streamMessageListViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = streamMessageListViewBinding2.newMessagesTV;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.newMessagesTV");
        this.scrollButtonBehaviour = new DefaultScrollButtonBehaviour(viewGroup, textView, this.newMessagesTextSingle, this.newMessagesTextPlural, false, 16, (DefaultConstructorMarker) null);
    }

    private final void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        Unit unit = Unit.INSTANCE;
        this.layoutManager = linearLayoutManager;
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = streamMessageListViewBinding.chatMessagesRV;
        LinearLayoutManager linearLayoutManager2 = this.layoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
    }

    private final void initUnseenMessagesButton() {
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        streamMessageListViewBinding.scrollBottomBtn.setOnClickListener(new MessageListView$initUnseenMessagesButton$1(this));
    }

    private final void initUnseenMessagesView() {
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = streamMessageListViewBinding.newMessagesTV;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.newMessagesTV");
        textView.setVisibility(8);
    }

    private final void parseAttr(Context context, AttributeSet attributeSet) {
        this.style = new MessageListViewStyle(context, attributeSet);
    }

    private final void configureAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1673R.styleable.MessageListView);
        int i = C1673R.styleable.MessageListView_streamLoadMoreThreshold;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.loadMoreListener = new EndlessScrollListener(obtainStyledAttributes.getInteger(i, context.getResources().getInteger(C1673R.integer.stream_load_more_threshold)), new MessageListView$configureAttributes$$inlined$also$lambda$1(this));
        int resourceId = obtainStyledAttributes.getResourceId(C1673R.styleable.MessageListView_streamScrollButtonBackground, C1673R.C1676drawable.stream_shape_round);
        this.unseenButtonEnabled = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageListView_streamDefaultScrollButtonEnabled, true);
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        streamMessageListViewBinding.scrollBottomBtn.setBackgroundResource(resourceId);
        if (!this.unseenButtonEnabled) {
            StreamMessageListViewBinding streamMessageListViewBinding2 = this.binding;
            if (streamMessageListViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ConstraintLayout constraintLayout = streamMessageListViewBinding2.scrollBottomBtn;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.scrollBottomBtn");
            constraintLayout.setVisibility(8);
        }
        this.newMessagesTextSingle = obtainStyledAttributes.getString(C1673R.styleable.MessageListView_streamNewMessagesTextSingle);
        this.newMessagesTextPlural = obtainStyledAttributes.getString(C1673R.styleable.MessageListView_streamNewMessagesTextPlural);
        this.newMessagesBehaviour = NewMessagesBehaviour.Companion.parseValue(obtainStyledAttributes.getInt(C1673R.styleable.MessageListView_streamNewMessagesBehaviour, NewMessagesBehaviour.COUNT_UPDATE.getValue$stream_chat_android_release()));
        ((ImageView) findViewById(C1673R.C1677id.scrollIconIV)).setImageResource(obtainStyledAttributes.getResourceId(C1673R.styleable.MessageListView_streamButtonIcon, C1673R.C1676drawable.stream_bottom_arrow));
        CharSequence text = obtainStyledAttributes.getText(C1673R.styleable.MessageListView_streamMessagesEmptyStateLabelText);
        if (text != null) {
            View view = this.emptyStateView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyStateView");
            }
            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: private */
    public final int lastPosition() {
        MessageListItemAdapter messageListItemAdapter = this.adapter;
        if (messageListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return messageListItemAdapter.getItemCount() - 1;
    }

    public final void setLoadingMore(boolean z) {
        if (z) {
            EndlessScrollListener endlessScrollListener = this.loadMoreListener;
            if (endlessScrollListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadMoreListener");
            }
            endlessScrollListener.disablePagination();
            return;
        }
        EndlessScrollListener endlessScrollListener2 = this.loadMoreListener;
        if (endlessScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreListener");
        }
        endlessScrollListener2.enablePagination();
    }

    public final void scrollToMessage(Message message) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        MessageListItemAdapter messageListItemAdapter = this.adapter;
        if (messageListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        List currentList = messageListItemAdapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
        Iterator it = currentList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            MessageListItem messageListItem = (MessageListItem) obj;
            if (!(messageListItem instanceof MessageListItem.MessageItem) || !Intrinsics.areEqual((Object) ((MessageListItem.MessageItem) messageListItem).getMessage().getId(), (Object) message.getId())) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        MessageListItem messageListItem2 = (MessageListItem) obj;
        if (messageListItem2 != null) {
            MessageListItemAdapter messageListItemAdapter2 = this.adapter;
            if (messageListItemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            int indexOf = messageListItemAdapter2.getCurrentList().indexOf(messageListItem2);
            StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
            if (streamMessageListViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            RecyclerView recyclerView = streamMessageListViewBinding.chatMessagesRV;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.chatMessagesRV");
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            if (layoutManager2 != null) {
                layoutManager2.scrollToPosition(indexOf);
            }
        }
    }

    private final void setMessageListItemAdapter(MessageListItemAdapter messageListItemAdapter) {
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = streamMessageListViewBinding.chatMessagesRV;
        EndlessScrollListener endlessScrollListener = this.loadMoreListener;
        if (endlessScrollListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreListener");
        }
        recyclerView.addOnScrollListener(endlessScrollListener);
        StreamMessageListViewBinding streamMessageListViewBinding2 = this.binding;
        if (streamMessageListViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        streamMessageListViewBinding2.chatMessagesRV.addOnScrollListener(new MessageListView$setMessageListItemAdapter$1(this, messageListItemAdapter));
        addOnLayoutChangeListener(new MessageListView$setMessageListItemAdapter$2(this));
        StreamMessageListViewBinding streamMessageListViewBinding3 = this.binding;
        if (streamMessageListViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = streamMessageListViewBinding3.chatMessagesRV;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.chatMessagesRV");
        recyclerView2.setAdapter(messageListItemAdapter);
    }

    public final void init(Channel channel2, User user) {
        Intrinsics.checkNotNullParameter(channel2, "channel");
        Intrinsics.checkNotNullParameter(user, "currentUser");
        this.currentUser = user;
        this.channel = channel2;
        initAdapter();
    }

    private final void initAdapter() {
        MessageListView messageListView = this;
        boolean z = false;
        if (!(messageListView.attachmentViewHolderFactory != null)) {
            this.attachmentViewHolderFactory = new AttachmentViewHolderFactory();
        }
        if (!(messageListView.messageViewHolderFactory != null)) {
            this.messageViewHolderFactory = new MessageViewHolderFactory();
        }
        if (!(messageListView.bubbleHelper != null)) {
            MessageListViewStyle messageListViewStyle = this.style;
            if (messageListViewStyle == null) {
                Intrinsics.throwUninitializedPropertyAccessException("style");
            }
            BubbleHelper initDefaultBubbleHelper = DefaultBubbleHelper.initDefaultBubbleHelper(messageListViewStyle, getContext());
            Intrinsics.checkNotNullExpressionValue(initDefaultBubbleHelper, "DefaultBubbleHelper.init…bleHelper(style, context)");
            this.bubbleHelper = initDefaultBubbleHelper;
        }
        if (messageListView.messageDateFormatter != null) {
            z = true;
        }
        if (!z) {
            DateFormatter.Companion companion = DateFormatter.Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.messageDateFormatter = companion.from(context);
        }
        AttachmentViewHolderFactory attachmentViewHolderFactory2 = this.attachmentViewHolderFactory;
        if (attachmentViewHolderFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attachmentViewHolderFactory");
        }
        attachmentViewHolderFactory2.setListenerContainer(this.listenerContainer);
        AttachmentViewHolderFactory attachmentViewHolderFactory3 = this.attachmentViewHolderFactory;
        if (attachmentViewHolderFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attachmentViewHolderFactory");
        }
        BubbleHelper bubbleHelper2 = this.bubbleHelper;
        if (bubbleHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleHelper");
        }
        attachmentViewHolderFactory3.setBubbleHelper(bubbleHelper2);
        MessageViewHolderFactory messageViewHolderFactory2 = this.messageViewHolderFactory;
        if (messageViewHolderFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewHolderFactory");
        }
        messageViewHolderFactory2.setListenerContainer$stream_chat_android_release(this.listenerContainer);
        MessageViewHolderFactory messageViewHolderFactory3 = this.messageViewHolderFactory;
        if (messageViewHolderFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewHolderFactory");
        }
        AttachmentViewHolderFactory attachmentViewHolderFactory4 = this.attachmentViewHolderFactory;
        if (attachmentViewHolderFactory4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attachmentViewHolderFactory");
        }
        messageViewHolderFactory3.setAttachmentViewHolderFactory$stream_chat_android_release(attachmentViewHolderFactory4);
        MessageViewHolderFactory messageViewHolderFactory4 = this.messageViewHolderFactory;
        if (messageViewHolderFactory4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewHolderFactory");
        }
        BubbleHelper bubbleHelper3 = this.bubbleHelper;
        if (bubbleHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleHelper");
        }
        messageViewHolderFactory4.setBubbleHelper$stream_chat_android_release(bubbleHelper3);
        MessageViewHolderFactory messageViewHolderFactory5 = this.messageViewHolderFactory;
        if (messageViewHolderFactory5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewHolderFactory");
        }
        DateFormatter dateFormatter = this.messageDateFormatter;
        if (dateFormatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageDateFormatter");
        }
        messageViewHolderFactory5.setMessageDateFormatter$stream_chat_android_release(dateFormatter);
        Channel channel2 = this.channel;
        if (channel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        }
        MessageViewHolderFactory messageViewHolderFactory6 = this.messageViewHolderFactory;
        if (messageViewHolderFactory6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewHolderFactory");
        }
        MessageListViewStyle messageListViewStyle2 = this.style;
        if (messageListViewStyle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("style");
        }
        MessageListItemAdapter messageListItemAdapter = new MessageListItemAdapter(channel2, messageViewHolderFactory6, messageListViewStyle2);
        this.adapter = messageListItemAdapter;
        if (messageListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        messageListItemAdapter.setHasStableIds(true);
        MessageListItemAdapter messageListItemAdapter2 = this.adapter;
        if (messageListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        setMessageListItemAdapter(messageListItemAdapter2);
    }

    public static /* synthetic */ void setLoadingView$default(MessageListView messageListView, View view, FrameLayout.LayoutParams layoutParams, int i, Object obj) {
        if ((i & 2) != 0) {
            layoutParams = messageListView.getDefaultChildLayoutParams();
        }
        messageListView.setLoadingView(view, layoutParams);
    }

    public final void setLoadingView(View view, FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        ViewGroup viewGroup = this.loadingViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewContainer");
        }
        View view2 = this.loadingView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        viewGroup.removeView(view2);
        this.loadingView = view;
        ViewGroup viewGroup2 = this.loadingViewContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewContainer");
        }
        View view3 = this.loadingView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        viewGroup2.addView(view3, layoutParams);
    }

    public final void showLoadingView() {
        ViewGroup viewGroup = this.loadingViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewContainer");
        }
        viewGroup.setVisibility(0);
    }

    public final void hideLoadingView() {
        ViewGroup viewGroup = this.loadingViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewContainer");
        }
        viewGroup.setVisibility(8);
    }

    public static /* synthetic */ void setEmptyStateView$default(MessageListView messageListView, View view, FrameLayout.LayoutParams layoutParams, int i, Object obj) {
        if ((i & 2) != 0) {
            layoutParams = messageListView.getDefaultChildLayoutParams();
        }
        messageListView.setEmptyStateView(view, layoutParams);
    }

    public final void setEmptyStateView(View view, FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        ViewGroup viewGroup = this.emptyStateViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyStateViewContainer");
        }
        View view2 = this.emptyStateView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyStateView");
        }
        viewGroup.removeView(view2);
        this.emptyStateView = view;
        ViewGroup viewGroup2 = this.emptyStateViewContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyStateViewContainer");
        }
        View view3 = this.emptyStateView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyStateView");
        }
        viewGroup2.addView(view3, layoutParams);
    }

    public final void showEmptyStateView() {
        ViewGroup viewGroup = this.emptyStateViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyStateViewContainer");
        }
        viewGroup.setVisibility(0);
    }

    public final void hideEmptyStateView() {
        ViewGroup viewGroup = this.emptyStateViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyStateViewContainer");
        }
        viewGroup.setVisibility(8);
    }

    public final void setScrollButtonBehaviour(ScrollButtonBehaviour scrollButtonBehaviour2) {
        Intrinsics.checkNotNullParameter(scrollButtonBehaviour2, "scrollButtonBehaviour");
        this.scrollButtonBehaviour = scrollButtonBehaviour2;
    }

    public final void setNewMessagesBehaviour(NewMessagesBehaviour newMessagesBehaviour2) {
        Intrinsics.checkNotNullParameter(newMessagesBehaviour2, "newMessagesBehaviour");
        this.newMessagesBehaviour = newMessagesBehaviour2;
    }

    public final void setScrollButtonBackgroundResource(int i) {
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        streamMessageListViewBinding.scrollBottomBtn.setBackgroundResource(i);
    }

    public final void setScrollButtonBackground(Drawable drawable) {
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ConstraintLayout constraintLayout = streamMessageListViewBinding.scrollBottomBtn;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.scrollBottomBtn");
        constraintLayout.setBackground(drawable);
    }

    public final void setScrollButtonIconResource(int i) {
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        streamMessageListViewBinding.scrollIconIV.setImageResource(i);
    }

    public final void setScrollButtonIcon(Drawable drawable) {
        StreamMessageListViewBinding streamMessageListViewBinding = this.binding;
        if (streamMessageListViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        streamMessageListViewBinding.scrollIconIV.setImageDrawable(drawable);
    }

    public final void setAttachmentViewHolderFactory(AttachmentViewHolderFactory attachmentViewHolderFactory2) {
        Intrinsics.checkNotNullParameter(attachmentViewHolderFactory2, "attachmentViewHolderFactory");
        if (!(this.adapter != null)) {
            this.attachmentViewHolderFactory = attachmentViewHolderFactory2;
            return;
        }
        throw new IllegalStateException("Adapter was already initialized, please set AttachmentViewHolderFactory first".toString());
    }

    public final void setMessageViewHolderFactory(MessageViewHolderFactory messageViewHolderFactory2) {
        Intrinsics.checkNotNullParameter(messageViewHolderFactory2, "messageViewHolderFactory");
        if (!(this.adapter != null)) {
            this.messageViewHolderFactory = messageViewHolderFactory2;
            return;
        }
        throw new IllegalStateException("Adapter was already initialized, please set MessageViewHolderFactory first".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the more explicit setMessageViewHolderFactory method instead.", replaceWith = @ReplaceWith(expression = "setMessageViewHolderFactory(messageViewHolderFactory)", imports = {}))
    public final void setViewHolderFactory(MessageViewHolderFactory messageViewHolderFactory2) {
        Intrinsics.checkNotNullParameter(messageViewHolderFactory2, "messageViewHolderFactory");
        setMessageViewHolderFactory(messageViewHolderFactory2);
    }

    public final void setBubbleHelper(BubbleHelper bubbleHelper2) {
        Intrinsics.checkNotNullParameter(bubbleHelper2, "bubbleHelper");
        if (!(this.adapter != null)) {
            this.bubbleHelper = bubbleHelper2;
            return;
        }
        throw new IllegalStateException("Adapter was already initialized; please set BubbleHelper first".toString());
    }

    public final void setMessageDateFormatter(DateFormatter dateFormatter) {
        Intrinsics.checkNotNullParameter(dateFormatter, "messageDateFormatter");
        if (!(this.adapter != null)) {
            this.messageDateFormatter = dateFormatter;
            return;
        }
        throw new IllegalStateException("Adapter was already initialized; please set DateFormatter first".toString());
    }

    public final void displayNewMessage(MessageListItemWrapper messageListItemWrapper) {
        Intrinsics.checkNotNullParameter(messageListItemWrapper, "listItem");
        this.buffer.enqueueData(messageListItemWrapper);
    }

    public final void scrollToBottom() {
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        MessageListItemAdapter messageListItemAdapter = this.adapter;
        if (messageListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        linearLayoutManager.scrollToPosition(messageListItemAdapter.getItemCount() - 1);
    }

    /* access modifiers changed from: private */
    public final void handleNewWrapper(MessageListItemWrapper messageListItemWrapper) {
        this.buffer.hold();
        List<MessageListItem> items = messageListItemWrapper.getItems();
        MessageListItemAdapter messageListItemAdapter = this.adapter;
        if (messageListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        boolean z = !messageListItemAdapter.isThread() && messageListItemWrapper.isThread();
        MessageListItemAdapter messageListItemAdapter2 = this.adapter;
        if (messageListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        messageListItemAdapter2.setThread(messageListItemWrapper.isThread());
        MessageListItemAdapter messageListItemAdapter3 = this.adapter;
        if (messageListItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        int itemCount = messageListItemAdapter3.getItemCount();
        MessageListItemAdapter messageListItemAdapter4 = this.adapter;
        if (messageListItemAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        messageListItemAdapter4.submitList(items, new MessageListView$handleNewWrapper$1(this, z, messageListItemWrapper, items, itemCount));
    }

    /* access modifiers changed from: private */
    public final void continueMessageAdd(boolean z, MessageListItemWrapper messageListItemWrapper, List<? extends MessageListItem> list, int i) {
        MessageListItemAdapter messageListItemAdapter = this.adapter;
        if (messageListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        int itemCount = messageListItemAdapter.getItemCount();
        int i2 = itemCount - i;
        boolean z2 = false;
        if (z) {
            LinearLayoutManager linearLayoutManager = this.layoutManager;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            }
            linearLayoutManager.scrollToPosition(0);
            this.buffer.active();
        } else if (messageListItemWrapper.isTyping() && scrolledBottom(i2 + 2) && !this.hasScrolledUp) {
            MessageListItemAdapter messageListItemAdapter2 = this.adapter;
            if (messageListItemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            int itemCount2 = messageListItemAdapter2.getItemCount() - 1;
            LinearLayoutManager linearLayoutManager2 = this.layoutManager;
            if (linearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            }
            linearLayoutManager2.scrollToPosition(itemCount2);
            this.buffer.active();
        } else if (!messageListItemWrapper.getHasNewMessages()) {
            this.logger.logI("no Scroll no new message");
            this.buffer.active();
        } else {
            if (i == 0 && itemCount != 0) {
                MessageListItemAdapter messageListItemAdapter3 = this.adapter;
                if (messageListItemAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                int itemCount3 = messageListItemAdapter3.getItemCount() - 1;
                LinearLayoutManager linearLayoutManager3 = this.layoutManager;
                if (linearLayoutManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                }
                linearLayoutManager3.scrollToPosition(itemCount3);
                TaggedLogger taggedLogger = this.logger;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Scroll: First load scrolling down to bottom %d", Arrays.copyOf(new Object[]{Integer.valueOf(itemCount3)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                taggedLogger.logI(format);
                this.lastMessageReadHandler.invoke();
            } else if (itemCount == 0) {
                this.buffer.active();
                return;
            } else {
                MessageListItemAdapter messageListItemAdapter4 = this.adapter;
                if (messageListItemAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                int itemCount4 = messageListItemAdapter4.getItemCount() - 1;
                LinearLayoutManager linearLayoutManager4 = this.layoutManager;
                if (linearLayoutManager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                }
                int itemCount5 = linearLayoutManager4.getItemCount();
                TaggedLogger taggedLogger2 = this.logger;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("Scroll: Moving down to %d, layout has %d elements", Arrays.copyOf(new Object[]{Integer.valueOf(itemCount4), Integer.valueOf(itemCount5)}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                taggedLogger2.logI(format2);
                Object lastOrNull = CollectionsKt.lastOrNull(list);
                if (!(lastOrNull instanceof MessageListItem.MessageItem)) {
                    lastOrNull = null;
                }
                MessageListItem.MessageItem messageItem = (MessageListItem.MessageItem) lastOrNull;
                if (messageItem != null) {
                    z2 = messageItem.isMine();
                }
                if (!z2 && this.hasScrolledUp) {
                    NewMessagesBehaviour newMessagesBehaviour2 = this.newMessagesBehaviour;
                    if (newMessagesBehaviour2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("newMessagesBehaviour");
                    }
                    if (newMessagesBehaviour2 != NewMessagesBehaviour.SCROLL_TO_BOTTOM) {
                        int lastSeenMessagePosition = (itemCount - getLastSeenMessagePosition()) - 1;
                        ScrollButtonBehaviour scrollButtonBehaviour2 = this.scrollButtonBehaviour;
                        if (scrollButtonBehaviour2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("scrollButtonBehaviour");
                        }
                        scrollButtonBehaviour2.onUnreadMessageCountChanged(lastSeenMessagePosition);
                        this.lastMessageReadHandler.invoke();
                    }
                }
                LinearLayoutManager linearLayoutManager5 = this.layoutManager;
                if (linearLayoutManager5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                }
                MessageListItemAdapter messageListItemAdapter5 = this.adapter;
                if (messageListItemAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                linearLayoutManager5.scrollToPosition(messageListItemAdapter5.getItemCount() - 1);
                this.lastMessageReadHandler.invoke();
            }
            this.buffer.active();
        }
    }

    private final boolean scrolledBottom(int i) {
        return getLastSeenMessagePosition() + i >= lastPosition();
    }

    /* access modifiers changed from: private */
    public final int getLastSeenMessagePosition() {
        MessageListItem messageListItem;
        MessageListItemAdapter messageListItemAdapter = this.adapter;
        if (messageListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        boolean isThread = messageListItemAdapter.isThread();
        if (isThread) {
            messageListItem = this.lastSeenMessageInThread;
        } else if (!isThread) {
            messageListItem = this.lastSeenMessageInChannel;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Long valueOf = messageListItem != null ? Long.valueOf(messageListItem.getStableId()) : null;
        MessageListItemAdapter messageListItemAdapter2 = this.adapter;
        if (messageListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        List currentList = messageListItemAdapter2.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
        ListIterator listIterator = currentList.listIterator(currentList.size());
        while (listIterator.hasPrevious()) {
            MessageListItem messageListItem2 = (MessageListItem) listIterator.previous();
            if (Intrinsics.areEqual((Object) messageListItem2 != null ? Long.valueOf(messageListItem2.getStableId()) : null, (Object) valueOf)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final void updateLastSeen(MessageListItem messageListItem) {
        MessageListItemAdapter messageListItemAdapter = this.adapter;
        if (messageListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        boolean isThread = messageListItemAdapter.isThread();
        if (isThread) {
            this.lastSeenMessageInThread = messageListItem;
            Unit unit = Unit.INSTANCE;
        } else if (!isThread) {
            this.lastSeenMessageInChannel = messageListItem;
            Unit unit2 = Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setMessageClickListener(MessageClickListener messageClickListener) {
        ListenerContainer listenerContainer2 = this.listenerContainer;
        if (messageClickListener == null) {
            messageClickListener = this.DEFAULT_MESSAGE_CLICK_LISTENER;
        }
        listenerContainer2.setMessageClickListener(messageClickListener);
    }

    public final void setMessageLongClickListener(MessageLongClickListener messageLongClickListener) {
        ListenerContainer listenerContainer2 = this.listenerContainer;
        if (messageLongClickListener == null) {
            messageLongClickListener = this.DEFAULT_MESSAGE_LONG_CLICK_LISTENER;
        }
        listenerContainer2.setMessageLongClickListener(messageLongClickListener);
    }

    public final void setMessageRetryListener(MessageRetryListener messageRetryListener) {
        ListenerContainer listenerContainer2 = this.listenerContainer;
        if (messageRetryListener == null) {
            messageRetryListener = this.DEFAULT_MESSAGE_RETRY_LISTENER;
        }
        listenerContainer2.setMessageRetryListener(messageRetryListener);
    }

    public final void setAttachmentClickListener(AttachmentClickListener attachmentClickListener) {
        ListenerContainer listenerContainer2 = this.listenerContainer;
        if (attachmentClickListener == null) {
            attachmentClickListener = this.DEFAULT_ATTACHMENT_CLICK_LISTENER;
        }
        listenerContainer2.setAttachmentClickListener(attachmentClickListener);
    }

    public final void setReactionViewClickListener(ReactionViewClickListener reactionViewClickListener) {
        ListenerContainer listenerContainer2 = this.listenerContainer;
        if (reactionViewClickListener == null) {
            reactionViewClickListener = this.DEFAULT_REACTION_VIEW_CLICK_LISTENER;
        }
        listenerContainer2.setReactionViewClickListener(reactionViewClickListener);
    }

    public final void setUserClickListener(UserClickListener userClickListener) {
        ListenerContainer listenerContainer2 = this.listenerContainer;
        if (userClickListener == null) {
            userClickListener = this.DEFAULT_USER_CLICK_LISTENER;
        }
        listenerContainer2.setUserClickListener(userClickListener);
    }

    public final void setReadStateClickListener(ReadStateClickListener readStateClickListener) {
        ListenerContainer listenerContainer2 = this.listenerContainer;
        if (readStateClickListener == null) {
            readStateClickListener = this.DEFAULT_READ_STATE_CLICK_LISTENER;
        }
        listenerContainer2.setReadStateClickListener(readStateClickListener);
    }

    public final void setEndRegionReachedHandler(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "endRegionReachedHandler");
        this.endRegionReachedHandler = function0;
    }

    public final void setLastMessageReadHandler(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "lastMessageReadHandler");
        this.lastMessageReadHandler = function0;
    }

    public final void setOnMessageEditHandler(Function1<? super Message, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onMessageEditHandler");
        this.onMessageEditHandler = function1;
    }

    public final void setOnMessageDeleteHandler(Function1<? super Message, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onMessageDeleteHandler");
        this.onMessageDeleteHandler = function1;
    }

    public final void setOnStartThreadHandler(Function1<? super Message, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onStartThreadHandler");
        this.onStartThreadHandler = function1;
    }

    public final void setOnMessageFlagHandler(Function1<? super Message, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onMessageFlagHandler");
        this.onMessageFlagHandler = function1;
    }

    public final void setOnSendGiphyHandler(Function2<? super Message, ? super GiphyAction, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onSendGiphyHandler");
        this.onSendGiphyHandler = function2;
    }

    public final void setOnMessageRetryHandler(Function1<? super Message, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onMessageRetryHandler");
        this.onMessageRetryHandler = function1;
    }

    public final void setOnStartThreadListener(Function1<? super Message, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onStartThreadListener");
        this.onStartThreadListener = function1;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$NewMessagesBehaviour;", "", "value", "", "(Ljava/lang/String;II)V", "getValue$stream_chat_android_release", "()I", "SCROLL_TO_BOTTOM", "COUNT_UPDATE", "Companion", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public enum NewMessagesBehaviour {
        SCROLL_TO_BOTTOM(0),
        COUNT_UPDATE(1);
        
        public static final Companion Companion = null;
        private final int value;

        private NewMessagesBehaviour(int i) {
            this.value = i;
        }

        public final int getValue$stream_chat_android_release() {
            return this.value;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$NewMessagesBehaviour$Companion;", "", "()V", "parseValue", "Lcom/getstream/sdk/chat/view/MessageListView$NewMessagesBehaviour;", "value", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: MessageListView.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final NewMessagesBehaviour parseValue(int i) {
                NewMessagesBehaviour newMessagesBehaviour;
                NewMessagesBehaviour[] values = NewMessagesBehaviour.values();
                int length = values.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        newMessagesBehaviour = null;
                        break;
                    }
                    newMessagesBehaviour = values[i2];
                    if (newMessagesBehaviour.getValue$stream_chat_android_release() == i) {
                        break;
                    }
                    i2++;
                }
                if (newMessagesBehaviour != null) {
                    return newMessagesBehaviour;
                }
                throw new IllegalArgumentException("Unknown behaviour type. It must be either SCROLL_TO_BOTTOM (int 0) or COUNT_UPDATE (int 1)");
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListView$DefaultScrollButtonBehaviour;", "Lcom/getstream/sdk/chat/view/MessageListView$ScrollButtonBehaviour;", "unseenBottomBtn", "Landroid/view/ViewGroup;", "newMessagesTextTV", "Landroid/widget/TextView;", "newMessagesTextSingle", "", "newMessagesTextPlural", "isButtonEnabled", "", "(Landroid/view/ViewGroup;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Z)V", "formatNewMessagesText", "unseenItems", "", "onUnreadMessageCountChanged", "", "count", "userScrolledToTheBottom", "userScrolledUp", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageListView.kt */
    public static final class DefaultScrollButtonBehaviour implements ScrollButtonBehaviour {
        private boolean isButtonEnabled;
        private final String newMessagesTextPlural;
        private final String newMessagesTextSingle;
        private final TextView newMessagesTextTV;
        private final ViewGroup unseenBottomBtn;

        public DefaultScrollButtonBehaviour(ViewGroup viewGroup, TextView textView, String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(viewGroup, "unseenBottomBtn");
            Intrinsics.checkNotNullParameter(textView, "newMessagesTextTV");
            this.unseenBottomBtn = viewGroup;
            this.newMessagesTextTV = textView;
            this.newMessagesTextSingle = str;
            this.newMessagesTextPlural = str2;
            this.isButtonEnabled = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DefaultScrollButtonBehaviour(ViewGroup viewGroup, TextView textView, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(viewGroup, textView, str, str2, (i & 16) != 0 ? true : z);
        }

        public void userScrolledUp() {
            if (!this.unseenBottomBtn.isShown()) {
                this.unseenBottomBtn.setVisibility(0);
            }
        }

        public void userScrolledToTheBottom() {
            if (this.unseenBottomBtn.isShown()) {
                this.unseenBottomBtn.setVisibility(8);
            }
        }

        public void onUnreadMessageCountChanged(int i) {
            if (i <= 0) {
                this.newMessagesTextTV.setVisibility(8);
            } else if (this.isButtonEnabled) {
                this.newMessagesTextTV.setVisibility(0);
                this.newMessagesTextTV.setText(formatNewMessagesText(i));
            }
        }

        private final String formatNewMessagesText(int i) {
            C1739x10331042 messageListView$DefaultScrollButtonBehaviour$formatNewMessagesText$1 = new C1739x10331042(i);
            if (i != 1) {
                return messageListView$DefaultScrollButtonBehaviour$formatNewMessagesText$1.invoke(this.newMessagesTextPlural);
            }
            return messageListView$DefaultScrollButtonBehaviour$formatNewMessagesText$1.invoke(this.newMessagesTextSingle);
        }
    }

    private final void init(Context context, AttributeSet attributeSet) {
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(this)");
        StreamMessageListViewBinding inflate = StreamMessageListViewBinding.inflate(from, this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "StreamMessageListViewBin…ext.inflater, this, true)");
        this.binding = inflate;
        initRecyclerView();
        initUnseenMessagesButton();
        initUnseenMessagesView();
        initLoadingView();
        initEmptyStateView();
        if (attributeSet != null) {
            configureAttributes(attributeSet);
        }
        initScrollButtonBehaviour();
        this.hasScrolledUp = false;
        this.buffer.subscribe(new MessageListView$init$1(this));
        this.buffer.active();
    }
}

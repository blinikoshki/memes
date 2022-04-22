package com.getstream.sdk.chat.view.messageinput;

import android.content.Context;
import android.net.Uri;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.adapter.FileAttachmentSelectedAdapter;
import com.getstream.sdk.chat.adapter.MediaAttachmentAdapter;
import com.getstream.sdk.chat.adapter.MediaAttachmentSelectedAdapter;
import com.getstream.sdk.chat.enums.MessageInputType;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import com.getstream.sdk.chat.utils.AttachmentConstants;
import com.getstream.sdk.chat.utils.PermissionChecker;
import com.getstream.sdk.chat.utils.StorageHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 C2\u00020\u0001:\u0001CBE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J'\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0001¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u001bH\u0002J\r\u0010\"\u001a\u00020\u001bH\u0000¢\u0006\u0002\b#J\u0015\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0011H\u0000¢\u0006\u0002\b&J\u0012\u0010'\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\r\u0010(\u001a\u00020\u001bH\u0000¢\u0006\u0002\b)J\r\u0010*\u001a\u00020\u001bH\u0000¢\u0006\u0002\b+J\u0006\u0010,\u001a\u00020\u001bJ\u0015\u0010-\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J\u0015\u00100\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0000¢\u0006\u0002\b1J\u001b\u00102\u001a\u00020\u001b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0000¢\u0006\u0002\b6J\u0016\u00107\u001a\u00020\u001b2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001504H\u0002J\u0015\u00109\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0000¢\u0006\u0002\b:J\u001b\u0010;\u001a\u00020\u001b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0000¢\u0006\u0002\b<J\b\u0010=\u001a\u00020\u001bH\u0002J\u0012\u0010>\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J.\u0010?\u001a\u00020\u001b2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0015042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u0015042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u001a\u0010A\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u001a\u0010B\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/AttachmentsController;", "", "rootController", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputController;", "permissionChecker", "Lcom/getstream/sdk/chat/utils/PermissionChecker;", "storageHelper", "Lcom/getstream/sdk/chat/utils/StorageHelper;", "view", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputView;", "totalMediaAttachmentAdapter", "Lcom/getstream/sdk/chat/adapter/MediaAttachmentAdapter;", "selectedMediaAttachmentAdapter", "Lcom/getstream/sdk/chat/adapter/MediaAttachmentSelectedAdapter;", "selectedFileAttachmentAdapter", "Lcom/getstream/sdk/chat/adapter/FileAttachmentSelectedAdapter;", "showOpenAttachmentsMenuConfig", "", "(Lcom/getstream/sdk/chat/view/messageinput/MessageInputController;Lcom/getstream/sdk/chat/utils/PermissionChecker;Lcom/getstream/sdk/chat/utils/StorageHelper;Lcom/getstream/sdk/chat/view/messageinput/MessageInputView;Lcom/getstream/sdk/chat/adapter/MediaAttachmentAdapter;Lcom/getstream/sdk/chat/adapter/MediaAttachmentSelectedAdapter;Lcom/getstream/sdk/chat/adapter/FileAttachmentSelectedAdapter;Z)V", "<set-?>", "", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "selectedAttachments", "getSelectedAttachments$stream_chat_android_release", "()Ljava/util/Set;", "totalAttachments", "cancelAttachment", "", "attachment", "messageInputType", "Lcom/getstream/sdk/chat/enums/MessageInputType;", "isMediaAttachment", "cancelAttachment$stream_chat_android_release", "checkPermissions", "clearState", "clearState$stream_chat_android_release", "configAttachmentButtonVisible", "visible", "configAttachmentButtonVisible$stream_chat_android_release", "fillTotalMediaAttachmentsView", "onCameraClick", "onCameraClick$stream_chat_android_release", "onClickCloseAttachmentSelectionMenu", "onClickCloseAttachmentSelectionMenu$stream_chat_android_release", "onClickOpenAttachmentSelectionMenu", "onClickOpenMediaSelectView", "onClickOpenMediaSelectView$stream_chat_android_release", "removeAttachmentFromAdapters", "selectAttachmentFromCamera", "selectAttachmentFromCamera$stream_chat_android_release", "selectAttachmentsFromUriList", "uriList", "", "Landroid/net/Uri;", "selectAttachmentsFromUriList$stream_chat_android_release", "selectFileAttachments", "attachments", "selectMediaAttachment", "selectMediaAttachment$stream_chat_android_release", "setSelectedAttachments", "setSelectedAttachments$stream_chat_android_release", "setSelectedFileAttachmentAdapter", "setSelectedMediaAttachmentAdapter", "setTotalMediaAttachmentAdapter", "totalAttachment", "unselectMediaAttachment", "updateMediaAttachment", "Companion", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentsController.kt */
public final class AttachmentsController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Function1<AttachmentMetaData, Boolean> isFileAttachment = AttachmentsController$Companion$isFileAttachment$1.INSTANCE;
    private static final Function1<AttachmentMetaData, Boolean> isMediaAttachment = AttachmentsController$Companion$isMediaAttachment$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final List<String> listOfMediaTypes = CollectionsKt.listOf("image", "video");
    private final PermissionChecker permissionChecker;
    private final MessageInputController rootController;
    /* access modifiers changed from: private */
    public Set<AttachmentMetaData> selectedAttachments = SetsKt.emptySet();
    private final FileAttachmentSelectedAdapter selectedFileAttachmentAdapter;
    private final MediaAttachmentSelectedAdapter selectedMediaAttachmentAdapter;
    private final boolean showOpenAttachmentsMenuConfig;
    /* access modifiers changed from: private */
    public final StorageHelper storageHelper;
    /* access modifiers changed from: private */
    public Set<AttachmentMetaData> totalAttachments = SetsKt.emptySet();
    private final MediaAttachmentAdapter totalMediaAttachmentAdapter;
    /* access modifiers changed from: private */
    public final MessageInputView view;

    public AttachmentsController(MessageInputController messageInputController, PermissionChecker permissionChecker2, StorageHelper storageHelper2, MessageInputView messageInputView, MediaAttachmentAdapter mediaAttachmentAdapter, MediaAttachmentSelectedAdapter mediaAttachmentSelectedAdapter, FileAttachmentSelectedAdapter fileAttachmentSelectedAdapter, boolean z) {
        Intrinsics.checkNotNullParameter(messageInputController, "rootController");
        Intrinsics.checkNotNullParameter(permissionChecker2, "permissionChecker");
        Intrinsics.checkNotNullParameter(storageHelper2, "storageHelper");
        Intrinsics.checkNotNullParameter(messageInputView, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(mediaAttachmentAdapter, "totalMediaAttachmentAdapter");
        Intrinsics.checkNotNullParameter(mediaAttachmentSelectedAdapter, "selectedMediaAttachmentAdapter");
        Intrinsics.checkNotNullParameter(fileAttachmentSelectedAdapter, "selectedFileAttachmentAdapter");
        this.rootController = messageInputController;
        this.permissionChecker = permissionChecker2;
        this.storageHelper = storageHelper2;
        this.view = messageInputView;
        this.totalMediaAttachmentAdapter = mediaAttachmentAdapter;
        this.selectedMediaAttachmentAdapter = mediaAttachmentSelectedAdapter;
        this.selectedFileAttachmentAdapter = fileAttachmentSelectedAdapter;
        this.showOpenAttachmentsMenuConfig = z;
    }

    public final Set<AttachmentMetaData> getSelectedAttachments$stream_chat_android_release() {
        return this.selectedAttachments;
    }

    public final void setSelectedAttachments$stream_chat_android_release(Set<AttachmentMetaData> set) {
        Intrinsics.checkNotNullParameter(set, "selectedAttachments");
        this.selectedAttachments = SetsKt.plus(this.selectedAttachments, set);
    }

    public final void onClickCloseAttachmentSelectionMenu$stream_chat_android_release() {
        this.view.hideAttachmentsMenu$stream_chat_android_release();
        this.totalAttachments = SetsKt.emptySet();
        this.totalMediaAttachmentAdapter.clear();
        configAttachmentButtonVisible$stream_chat_android_release(true);
    }

    private final void fillTotalMediaAttachmentsView(MessageInputType messageInputType) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, DispatcherProvider.INSTANCE.getMain(), (CoroutineStart) null, new AttachmentsController$fillTotalMediaAttachmentsView$1(this, messageInputType, (Continuation) null), 2, (Object) null);
    }

    public final void configAttachmentButtonVisible$stream_chat_android_release(boolean z) {
        if (this.showOpenAttachmentsMenuConfig) {
            this.view.showOpenAttachmentsMenuButton$stream_chat_android_release(z);
        }
    }

    public final void cancelAttachment$stream_chat_android_release(AttachmentMetaData attachmentMetaData, MessageInputType messageInputType, boolean z) {
        Intrinsics.checkNotNullParameter(attachmentMetaData, MessengerShareContentUtility.ATTACHMENT);
        this.selectedAttachments = SetsKt.minus(this.selectedAttachments, attachmentMetaData);
        removeAttachmentFromAdapters(attachmentMetaData, z);
        this.rootController.configSendButtonEnableState$stream_chat_android_release();
        if (this.selectedAttachments.isEmpty() && MessageInputType.EDIT_MESSAGE == messageInputType) {
            configAttachmentButtonVisible$stream_chat_android_release(true);
        }
    }

    public final void onCameraClick$stream_chat_android_release() {
        PermissionChecker permissionChecker2 = this.permissionChecker;
        Context context = this.view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (!permissionChecker2.isGrantedCameraPermissions(context)) {
            PermissionChecker.checkCameraPermissions$default(this.permissionChecker, this.view, (Function0) null, new AttachmentsController$onCameraClick$1(this), 2, (Object) null);
        } else {
            this.view.showCameraOptions$stream_chat_android_release();
        }
    }

    public final void onClickOpenMediaSelectView$stream_chat_android_release(MessageInputType messageInputType) {
        Intrinsics.checkNotNullParameter(messageInputType, "messageInputType");
        PermissionChecker permissionChecker2 = this.permissionChecker;
        Context context = this.view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (!permissionChecker2.isGrantedStoragePermissions(context)) {
            PermissionChecker.checkStoragePermissions$default(this.permissionChecker, this.view, (Function0) null, new AttachmentsController$onClickOpenMediaSelectView$1(this, messageInputType), 2, (Object) null);
            return;
        }
        setSelectedAttachments$stream_chat_android_release(this.selectedAttachments);
        fillTotalMediaAttachmentsView(messageInputType);
    }

    private final void removeAttachmentFromAdapters(AttachmentMetaData attachmentMetaData, boolean z) {
        if (z) {
            this.selectedMediaAttachmentAdapter.removeAttachment(attachmentMetaData);
            this.totalMediaAttachmentAdapter.unselectAttachment(attachmentMetaData);
            return;
        }
        this.selectedFileAttachmentAdapter.setAttachments(CollectionsKt.toList(this.selectedAttachments));
    }

    /* access modifiers changed from: private */
    public final void setTotalMediaAttachmentAdapter(List<AttachmentMetaData> list, List<AttachmentMetaData> list2, MessageInputType messageInputType) {
        for (AttachmentMetaData attachmentMetaData : list) {
            attachmentMetaData.setSelected(list2.contains(attachmentMetaData));
        }
        MediaAttachmentAdapter mediaAttachmentAdapter = this.totalMediaAttachmentAdapter;
        mediaAttachmentAdapter.setAttachments(list);
        mediaAttachmentAdapter.setListener(new C1747x154b9685(this, list, messageInputType));
        this.view.showTotalMediaAttachments$stream_chat_android_release(this.totalMediaAttachmentAdapter);
    }

    /* access modifiers changed from: private */
    public final void setSelectedMediaAttachmentAdapter(MessageInputType messageInputType) {
        Function1<AttachmentMetaData, Boolean> function1 = isMediaAttachment;
        Collection arrayList = new ArrayList();
        for (Object next : this.selectedAttachments) {
            if (function1.invoke(next).booleanValue()) {
                arrayList.add(next);
            }
        }
        Set<AttachmentMetaData> set = CollectionsKt.toSet((List) arrayList);
        this.selectedAttachments = set;
        this.selectedMediaAttachmentAdapter.setAttachments$stream_chat_android_release(CollectionsKt.toList(set));
        this.selectedMediaAttachmentAdapter.setCancelListener(new AttachmentsController$setSelectedMediaAttachmentAdapter$1(this, messageInputType));
        this.view.showSelectedMediaAttachments$stream_chat_android_release(this.selectedMediaAttachmentAdapter);
        this.selectedFileAttachmentAdapter.clear();
    }

    /* access modifiers changed from: private */
    public final void setSelectedFileAttachmentAdapter() {
        Function1<AttachmentMetaData, Boolean> function1 = isFileAttachment;
        Collection arrayList = new ArrayList();
        for (Object next : this.selectedAttachments) {
            if (function1.invoke(next).booleanValue()) {
                arrayList.add(next);
            }
        }
        this.selectedAttachments = CollectionsKt.toSet((List) arrayList);
        this.selectedFileAttachmentAdapter.setCancelListener(new AttachmentsController$setSelectedFileAttachmentAdapter$1(this));
        this.view.showSelectedFileAttachments$stream_chat_android_release(this.selectedFileAttachmentAdapter);
        this.selectedMediaAttachmentAdapter.clear();
    }

    /* access modifiers changed from: private */
    public final void updateMediaAttachment(AttachmentMetaData attachmentMetaData, MessageInputType messageInputType) {
        boolean isSelected = attachmentMetaData.isSelected();
        if (isSelected) {
            unselectMediaAttachment(attachmentMetaData, messageInputType);
        } else if (!isSelected) {
            selectMediaAttachment$stream_chat_android_release(attachmentMetaData);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void unselectMediaAttachment(AttachmentMetaData attachmentMetaData, MessageInputType messageInputType) {
        attachmentMetaData.setSelected(false);
        this.selectedAttachments = SetsKt.minus(this.selectedAttachments, attachmentMetaData);
        removeAttachmentFromAdapters(attachmentMetaData, true);
        this.rootController.configSendButtonEnableState$stream_chat_android_release();
        if (this.selectedAttachments.isEmpty() && MessageInputType.EDIT_MESSAGE == messageInputType) {
            configAttachmentButtonVisible$stream_chat_android_release(true);
        }
    }

    public final void selectAttachmentFromCamera$stream_chat_android_release(AttachmentMetaData attachmentMetaData) {
        Intrinsics.checkNotNullParameter(attachmentMetaData, MessengerShareContentUtility.ATTACHMENT);
        setSelectedMediaAttachmentAdapter((MessageInputType) null);
        selectMediaAttachment$stream_chat_android_release(attachmentMetaData);
    }

    public final void selectAttachmentsFromUriList$stream_chat_android_release(List<? extends Uri> list) {
        Intrinsics.checkNotNullParameter(list, "uriList");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, DispatcherProvider.INSTANCE.getMain(), (CoroutineStart) null, new AttachmentsController$selectAttachmentsFromUriList$1(this, list, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void selectFileAttachments(List<AttachmentMetaData> list) {
        Collection arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((AttachmentMetaData) next).getSize() > AttachmentConstants.MAX_UPLOAD_FILE_SIZE) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        List list2 = (List) arrayList;
        if (list2.size() < list.size()) {
            this.view.showMessage(C1673R.string.stream_large_size_file_error);
        }
        Iterable<AttachmentMetaData> iterable = list2;
        for (AttachmentMetaData selected : iterable) {
            selected.setSelected(true);
        }
        this.selectedAttachments = SetsKt.plus(this.selectedAttachments, iterable);
        this.view.showFileAttachments$stream_chat_android_release();
        this.rootController.configSendButtonEnableState$stream_chat_android_release();
        this.selectedFileAttachmentAdapter.setAttachments(CollectionsKt.toList(this.selectedAttachments));
    }

    public final void selectMediaAttachment$stream_chat_android_release(AttachmentMetaData attachmentMetaData) {
        Intrinsics.checkNotNullParameter(attachmentMetaData, MessengerShareContentUtility.ATTACHMENT);
        if (attachmentMetaData.getSize() > AttachmentConstants.MAX_UPLOAD_FILE_SIZE) {
            this.view.showMessage(C1673R.string.stream_large_size_file_error);
        } else if (!this.selectedAttachments.contains(attachmentMetaData)) {
            attachmentMetaData.setSelected(true);
            this.selectedAttachments = SetsKt.plus(this.selectedAttachments, attachmentMetaData);
            this.view.showMediaAttachments$stream_chat_android_release();
            this.rootController.configSendButtonEnableState$stream_chat_android_release();
            this.selectedMediaAttachmentAdapter.addAttachment(attachmentMetaData);
            this.totalMediaAttachmentAdapter.selectAttachment(attachmentMetaData);
        }
    }

    private final void checkPermissions() {
        PermissionChecker permissionChecker2 = this.permissionChecker;
        Context context = this.view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (permissionChecker2.isGrantedCameraPermissions(context)) {
            this.view.showMediaPermissions$stream_chat_android_release(false);
            this.view.showCameraPermissions$stream_chat_android_release(false);
            return;
        }
        PermissionChecker permissionChecker3 = this.permissionChecker;
        Context context2 = this.view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        if (permissionChecker3.isGrantedStoragePermissions(context2)) {
            this.view.showMediaPermissions$stream_chat_android_release(false);
            this.view.showCameraPermissions$stream_chat_android_release(true);
            return;
        }
        this.view.showMediaPermissions$stream_chat_android_release(true);
        this.view.showCameraPermissions$stream_chat_android_release(true);
    }

    public final void clearState$stream_chat_android_release() {
        this.view.hideAttachmentsMenu$stream_chat_android_release();
        this.selectedAttachments = SetsKt.emptySet();
        this.totalMediaAttachmentAdapter.clear();
        this.selectedFileAttachmentAdapter.clear();
        this.selectedMediaAttachmentAdapter.clear();
    }

    public final void onClickOpenAttachmentSelectionMenu() {
        this.view.showAttachmentsMenu$stream_chat_android_release();
        checkPermissions();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/AttachmentsController$Companion;", "", "()V", "isFileAttachment", "Lkotlin/Function1;", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "", "isMediaAttachment", "listOfMediaTypes", "", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: AttachmentsController.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

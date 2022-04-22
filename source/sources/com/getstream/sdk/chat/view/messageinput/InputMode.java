package com.getstream.sdk.chat.view.messageinput;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/InputMode;", "", "()V", "Edit", "Normal", "Thread", "Lcom/getstream/sdk/chat/view/messageinput/InputMode$Normal;", "Lcom/getstream/sdk/chat/view/messageinput/InputMode$Thread;", "Lcom/getstream/sdk/chat/view/messageinput/InputMode$Edit;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputController.kt */
public abstract class InputMode {

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/InputMode$Normal;", "Lcom/getstream/sdk/chat/view/messageinput/InputMode;", "()V", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageInputController.kt */
    public static final class Normal extends InputMode {
        public static final Normal INSTANCE = new Normal();

        private Normal() {
            super((DefaultConstructorMarker) null);
        }
    }

    private InputMode() {
    }

    public /* synthetic */ InputMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/InputMode$Thread;", "Lcom/getstream/sdk/chat/view/messageinput/InputMode;", "parentMessage", "Lio/getstream/chat/android/client/models/Message;", "(Lio/getstream/chat/android/client/models/Message;)V", "getParentMessage", "()Lio/getstream/chat/android/client/models/Message;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageInputController.kt */
    public static final class Thread extends InputMode {
        private final Message parentMessage;

        public static /* synthetic */ Thread copy$default(Thread thread, Message message, int i, Object obj) {
            if ((i & 1) != 0) {
                message = thread.parentMessage;
            }
            return thread.copy(message);
        }

        public final Message component1() {
            return this.parentMessage;
        }

        public final Thread copy(Message message) {
            Intrinsics.checkNotNullParameter(message, "parentMessage");
            return new Thread(message);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Thread) && Intrinsics.areEqual((Object) this.parentMessage, (Object) ((Thread) obj).parentMessage);
            }
            return true;
        }

        public int hashCode() {
            Message message = this.parentMessage;
            if (message != null) {
                return message.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Thread(parentMessage=" + this.parentMessage + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Thread(Message message) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(message, "parentMessage");
            this.parentMessage = message;
        }

        public final Message getParentMessage() {
            return this.parentMessage;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/InputMode$Edit;", "Lcom/getstream/sdk/chat/view/messageinput/InputMode;", "oldMessage", "Lio/getstream/chat/android/client/models/Message;", "(Lio/getstream/chat/android/client/models/Message;)V", "getOldMessage", "()Lio/getstream/chat/android/client/models/Message;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MessageInputController.kt */
    public static final class Edit extends InputMode {
        private final Message oldMessage;

        public static /* synthetic */ Edit copy$default(Edit edit, Message message, int i, Object obj) {
            if ((i & 1) != 0) {
                message = edit.oldMessage;
            }
            return edit.copy(message);
        }

        public final Message component1() {
            return this.oldMessage;
        }

        public final Edit copy(Message message) {
            Intrinsics.checkNotNullParameter(message, "oldMessage");
            return new Edit(message);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Edit) && Intrinsics.areEqual((Object) this.oldMessage, (Object) ((Edit) obj).oldMessage);
            }
            return true;
        }

        public int hashCode() {
            Message message = this.oldMessage;
            if (message != null) {
                return message.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Edit(oldMessage=" + this.oldMessage + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Edit(Message message) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(message, "oldMessage");
            this.oldMessage = message;
        }

        public final Message getOldMessage() {
            return this.oldMessage;
        }
    }
}

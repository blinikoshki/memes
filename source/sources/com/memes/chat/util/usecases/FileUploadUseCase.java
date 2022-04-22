package com.memes.chat.util.usecases;

import com.memes.chat.p036ui.startup.ChatCredentialsSharedPref;
import com.memes.network.chat.api.ChatDataSource;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/FileUploadUseCase;", "", "chatDataSource", "Lcom/memes/network/chat/api/ChatDataSource;", "credentialsSharedPref", "Lcom/memes/chat/ui/startup/ChatCredentialsSharedPref;", "(Lcom/memes/network/chat/api/ChatDataSource;Lcom/memes/chat/ui/startup/ChatCredentialsSharedPref;)V", "execute", "", "request", "Lcom/memes/chat/util/usecases/FileUploadUseCase$Request;", "(Lcom/memes/chat/util/usecases/FileUploadUseCase$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Request", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FileUploadUseCase.kt */
public final class FileUploadUseCase {
    /* access modifiers changed from: private */
    public final ChatDataSource chatDataSource;
    /* access modifiers changed from: private */
    public final ChatCredentialsSharedPref credentialsSharedPref;

    public FileUploadUseCase(ChatDataSource chatDataSource2, ChatCredentialsSharedPref chatCredentialsSharedPref) {
        Intrinsics.checkNotNullParameter(chatDataSource2, "chatDataSource");
        Intrinsics.checkNotNullParameter(chatCredentialsSharedPref, "credentialsSharedPref");
        this.chatDataSource = chatDataSource2;
        this.credentialsSharedPref = chatCredentialsSharedPref;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/FileUploadUseCase$Request;", "", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FileUploadUseCase.kt */
    public static final class Request {
        private final File file;

        public static /* synthetic */ Request copy$default(Request request, File file2, int i, Object obj) {
            if ((i & 1) != 0) {
                file2 = request.file;
            }
            return request.copy(file2);
        }

        public final File component1() {
            return this.file;
        }

        public final Request copy(File file2) {
            Intrinsics.checkNotNullParameter(file2, "file");
            return new Request(file2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Request) && Intrinsics.areEqual((Object) this.file, (Object) ((Request) obj).file);
            }
            return true;
        }

        public int hashCode() {
            File file2 = this.file;
            if (file2 != null) {
                return file2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Request(file=" + this.file + ")";
        }

        public Request(File file2) {
            Intrinsics.checkNotNullParameter(file2, "file");
            this.file = file2;
        }

        public final File getFile() {
            return this.file;
        }
    }

    public final Object execute(Request request, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FileUploadUseCase$execute$2(this, request, (Continuation) null), continuation);
    }
}

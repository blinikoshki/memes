package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\tH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "socket", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "", "okio"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: JvmOkio.kt */
final class SocketAsyncTimeout extends AsyncTimeout {
    private final Socket socket;

    public SocketAsyncTimeout(Socket socket2) {
        Intrinsics.checkNotNullParameter(socket2, "socket");
        this.socket = socket2;
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
        try {
            this.socket.close();
        } catch (Exception e) {
            Logger access$getLogger$p = Okio__JvmOkioKt.logger;
            Level level = Level.WARNING;
            access$getLogger$p.log(level, "Failed to close timed out socket " + this.socket, e);
        } catch (AssertionError e2) {
            if (Okio.isAndroidGetsocknameError(e2)) {
                Logger access$getLogger$p2 = Okio__JvmOkioKt.logger;
                Level level2 = Level.WARNING;
                access$getLogger$p2.log(level2, "Failed to close timed out socket " + this.socket, e2);
                return;
            }
            throw e2;
        }
    }
}

package com.google.android.exoplayer2.drm;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Consumer;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

class DefaultDrmSession implements DrmSession {
    private static final int MAX_LICENSE_DURATION_TO_RENEW_SECONDS = 60;
    private static final int MSG_KEYS = 1;
    private static final int MSG_PROVISION = 0;
    private static final String TAG = "DefaultDrmSession";
    final MediaDrmCallback callback;
    private ExoMediaDrm.KeyRequest currentKeyRequest;
    private ExoMediaDrm.ProvisionRequest currentProvisionRequest;
    private final CopyOnWriteMultiset<DrmSessionEventListener.EventDispatcher> eventDispatchers;
    private final boolean isPlaceholderSession;
    private final HashMap<String, String> keyRequestParameters;
    private DrmSession.DrmSessionException lastException;
    /* access modifiers changed from: private */
    public final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private ExoMediaCrypto mediaCrypto;
    private final ExoMediaDrm mediaDrm;
    private final int mode;
    private byte[] offlineLicenseKeySetId;
    private final boolean playClearSamplesWithoutKeys;
    private final ProvisioningManager provisioningManager;
    private int referenceCount;
    private final ReferenceCountListener referenceCountListener;
    private RequestHandler requestHandler;
    private HandlerThread requestHandlerThread;
    final ResponseHandler responseHandler;
    public final List<DrmInitData.SchemeData> schemeDatas;
    private byte[] sessionId;
    private int state;
    final UUID uuid;

    public interface ProvisioningManager {
        void onProvisionCompleted();

        void onProvisionError(Exception exc);

        void provisionRequired(DefaultDrmSession defaultDrmSession);
    }

    public interface ReferenceCountListener {
        void onReferenceCountDecremented(DefaultDrmSession defaultDrmSession, int i);

        void onReferenceCountIncremented(DefaultDrmSession defaultDrmSession, int i);
    }

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(Throwable th) {
            super(th);
        }
    }

    public DefaultDrmSession(UUID uuid2, ExoMediaDrm exoMediaDrm, ProvisioningManager provisioningManager2, ReferenceCountListener referenceCountListener2, List<DrmInitData.SchemeData> list, int i, boolean z, boolean z2, byte[] bArr, HashMap<String, String> hashMap, MediaDrmCallback mediaDrmCallback, Looper looper, LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
        if (i == 1 || i == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.uuid = uuid2;
        this.provisioningManager = provisioningManager2;
        this.referenceCountListener = referenceCountListener2;
        this.mediaDrm = exoMediaDrm;
        this.mode = i;
        this.playClearSamplesWithoutKeys = z;
        this.isPlaceholderSession = z2;
        if (bArr != null) {
            this.offlineLicenseKeySetId = bArr;
            this.schemeDatas = null;
        } else {
            this.schemeDatas = Collections.unmodifiableList((List) Assertions.checkNotNull(list));
        }
        this.keyRequestParameters = hashMap;
        this.callback = mediaDrmCallback;
        this.eventDispatchers = new CopyOnWriteMultiset<>();
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.state = 2;
        this.responseHandler = new ResponseHandler(looper);
    }

    public boolean hasSessionId(byte[] bArr) {
        return Arrays.equals(this.sessionId, bArr);
    }

    public void onMediaDrmEvent(int i) {
        if (i == 2) {
            onKeysRequired();
        }
    }

    public void provision() {
        this.currentProvisionRequest = this.mediaDrm.getProvisionRequest();
        ((RequestHandler) Util.castNonNull(this.requestHandler)).post(0, Assertions.checkNotNull(this.currentProvisionRequest), true);
    }

    public void onProvisionCompleted() {
        if (openInternal(false)) {
            doLicense(true);
        }
    }

    public void onProvisionError(Exception exc) {
        onError(exc);
    }

    public final int getState() {
        return this.state;
    }

    public boolean playClearSamplesWithoutKeys() {
        return this.playClearSamplesWithoutKeys;
    }

    public final DrmSession.DrmSessionException getError() {
        if (this.state == 1) {
            return this.lastException;
        }
        return null;
    }

    public final ExoMediaCrypto getMediaCrypto() {
        return this.mediaCrypto;
    }

    public Map<String, String> queryKeyStatus() {
        byte[] bArr = this.sessionId;
        if (bArr == null) {
            return null;
        }
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    public byte[] getOfflineLicenseKeySetId() {
        return this.offlineLicenseKeySetId;
    }

    public void acquire(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        boolean z = false;
        Assertions.checkState(this.referenceCount >= 0);
        if (eventDispatcher != null) {
            this.eventDispatchers.add(eventDispatcher);
        }
        int i = this.referenceCount + 1;
        this.referenceCount = i;
        if (i == 1) {
            if (this.state == 2) {
                z = true;
            }
            Assertions.checkState(z);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.requestHandlerThread = handlerThread;
            handlerThread.start();
            this.requestHandler = new RequestHandler(this.requestHandlerThread.getLooper());
            if (openInternal(true)) {
                doLicense(true);
            }
        } else if (eventDispatcher != null && isOpen()) {
            eventDispatcher.drmSessionAcquired();
        }
        this.referenceCountListener.onReferenceCountIncremented(this, this.referenceCount);
    }

    public void release(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        Assertions.checkState(this.referenceCount > 0);
        int i = this.referenceCount - 1;
        this.referenceCount = i;
        if (i == 0) {
            this.state = 0;
            ((ResponseHandler) Util.castNonNull(this.responseHandler)).removeCallbacksAndMessages((Object) null);
            ((RequestHandler) Util.castNonNull(this.requestHandler)).removeCallbacksAndMessages((Object) null);
            this.requestHandler = null;
            ((HandlerThread) Util.castNonNull(this.requestHandlerThread)).quit();
            this.requestHandlerThread = null;
            this.mediaCrypto = null;
            this.lastException = null;
            this.currentKeyRequest = null;
            this.currentProvisionRequest = null;
            byte[] bArr = this.sessionId;
            if (bArr != null) {
                this.mediaDrm.closeSession(bArr);
                this.sessionId = null;
            }
            dispatchEvent($$Lambda$1qpsSWLWkfLEr4tUDuC0gKlb8.INSTANCE);
        }
        if (eventDispatcher != null) {
            if (isOpen()) {
                eventDispatcher.drmSessionReleased();
            }
            this.eventDispatchers.remove(eventDispatcher);
        }
        this.referenceCountListener.onReferenceCountDecremented(this, this.referenceCount);
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean openInternal(boolean z) {
        if (isOpen()) {
            return true;
        }
        try {
            byte[] openSession = this.mediaDrm.openSession();
            this.sessionId = openSession;
            this.mediaCrypto = this.mediaDrm.createMediaCrypto(openSession);
            dispatchEvent($$Lambda$FHdePZbX29tMQI2hkEItev2KViw.INSTANCE);
            this.state = 3;
            Assertions.checkNotNull(this.sessionId);
            return true;
        } catch (NotProvisionedException e) {
            if (z) {
                this.provisioningManager.provisionRequired(this);
                return false;
            }
            onError(e);
            return false;
        } catch (Exception e2) {
            onError(e2);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void onProvisionResponse(Object obj, Object obj2) {
        if (obj != this.currentProvisionRequest) {
            return;
        }
        if (this.state == 2 || isOpen()) {
            this.currentProvisionRequest = null;
            if (obj2 instanceof Exception) {
                this.provisioningManager.onProvisionError((Exception) obj2);
                return;
            }
            try {
                this.mediaDrm.provideProvisionResponse((byte[]) obj2);
                this.provisioningManager.onProvisionCompleted();
            } catch (Exception e) {
                this.provisioningManager.onProvisionError(e);
            }
        }
    }

    @RequiresNonNull({"sessionId"})
    private void doLicense(boolean z) {
        if (!this.isPlaceholderSession) {
            byte[] bArr = (byte[]) Util.castNonNull(this.sessionId);
            int i = this.mode;
            if (i == 0 || i == 1) {
                if (this.offlineLicenseKeySetId == null) {
                    postKeyRequest(bArr, 1, z);
                } else if (this.state == 4 || restoreKeys()) {
                    long licenseDurationRemainingSec = getLicenseDurationRemainingSec();
                    if (this.mode == 0 && licenseDurationRemainingSec <= 60) {
                        StringBuilder sb = new StringBuilder(88);
                        sb.append("Offline license has expired or will expire soon. Remaining seconds: ");
                        sb.append(licenseDurationRemainingSec);
                        Log.m352d(TAG, sb.toString());
                        postKeyRequest(bArr, 2, z);
                    } else if (licenseDurationRemainingSec <= 0) {
                        onError(new KeysExpiredException());
                    } else {
                        this.state = 4;
                        dispatchEvent($$Lambda$bKbtDHu_QKCKrOHwO53RHdbHaY.INSTANCE);
                    }
                }
            } else if (i != 2) {
                if (i == 3) {
                    Assertions.checkNotNull(this.offlineLicenseKeySetId);
                    Assertions.checkNotNull(this.sessionId);
                    if (restoreKeys()) {
                        postKeyRequest(this.offlineLicenseKeySetId, 3, z);
                    }
                }
            } else if (this.offlineLicenseKeySetId == null || restoreKeys()) {
                postKeyRequest(bArr, 2, z);
            }
        }
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean restoreKeys() {
        try {
            this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
            return true;
        } catch (Exception e) {
            Log.m355e(TAG, "Error trying to restore keys.", e);
            onError(e);
            return false;
        }
    }

    private long getLicenseDurationRemainingSec() {
        if (!C1844C.WIDEVINE_UUID.equals(this.uuid)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private void postKeyRequest(byte[] bArr, int i, boolean z) {
        try {
            this.currentKeyRequest = this.mediaDrm.getKeyRequest(bArr, this.schemeDatas, i, this.keyRequestParameters);
            ((RequestHandler) Util.castNonNull(this.requestHandler)).post(1, Assertions.checkNotNull(this.currentKeyRequest), z);
        } catch (Exception e) {
            onKeysError(e);
        }
    }

    /* access modifiers changed from: private */
    public void onKeyResponse(Object obj, Object obj2) {
        if (obj == this.currentKeyRequest && isOpen()) {
            this.currentKeyRequest = null;
            if (obj2 instanceof Exception) {
                onKeysError((Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.mode == 3) {
                    this.mediaDrm.provideKeyResponse((byte[]) Util.castNonNull(this.offlineLicenseKeySetId), bArr);
                    dispatchEvent($$Lambda$BcEzLefIcAN2HB1XXErCxeZoNtI.INSTANCE);
                    return;
                }
                byte[] provideKeyResponse = this.mediaDrm.provideKeyResponse(this.sessionId, bArr);
                int i = this.mode;
                if (!((i != 2 && (i != 0 || this.offlineLicenseKeySetId == null)) || provideKeyResponse == null || provideKeyResponse.length == 0)) {
                    this.offlineLicenseKeySetId = provideKeyResponse;
                }
                this.state = 4;
                dispatchEvent($$Lambda$Xjvhz80h6FXicBD5mO_f_e7Cy8M.INSTANCE);
            } catch (Exception e) {
                onKeysError(e);
            }
        }
    }

    private void onKeysRequired() {
        if (this.mode == 0 && this.state == 4) {
            Util.castNonNull(this.sessionId);
            doLicense(false);
        }
    }

    private void onKeysError(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.provisioningManager.provisionRequired(this);
        } else {
            onError(exc);
        }
    }

    private void onError(Exception exc) {
        this.lastException = new DrmSession.DrmSessionException(exc);
        dispatchEvent(new Consumer(exc) {
            public final /* synthetic */ Exception f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                ((DrmSessionEventListener.EventDispatcher) obj).drmSessionManagerError(this.f$0);
            }
        });
        if (this.state != 4) {
            this.state = 1;
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean isOpen() {
        int i = this.state;
        return i == 3 || i == 4;
    }

    private void dispatchEvent(Consumer<DrmSessionEventListener.EventDispatcher> consumer) {
        for (DrmSessionEventListener.EventDispatcher accept : this.eventDispatchers.elementSet()) {
            consumer.accept(accept);
        }
    }

    private class ResponseHandler extends Handler {
        public ResponseHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                DefaultDrmSession.this.onProvisionResponse(obj, obj2);
            } else if (i == 1) {
                DefaultDrmSession.this.onKeyResponse(obj, obj2);
            }
        }
    }

    private class RequestHandler extends Handler {
        public RequestHandler(Looper looper) {
            super(looper);
        }

        /* access modifiers changed from: package-private */
        public void post(int i, Object obj, boolean z) {
            obtainMessage(i, new RequestTask(LoadEventInfo.getNewId(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.exoplayer2.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.google.android.exoplayer2.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.android.exoplayer2.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: byte[]} */
        /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.Throwable, java.lang.Exception] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r6.obj
                com.google.android.exoplayer2.drm.DefaultDrmSession$RequestTask r0 = (com.google.android.exoplayer2.drm.DefaultDrmSession.RequestTask) r0
                int r1 = r6.what     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                if (r1 == 0) goto L_0x0022
                r2 = 1
                if (r1 != r2) goto L_0x001c
                com.google.android.exoplayer2.drm.DefaultDrmSession r1 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                com.google.android.exoplayer2.drm.MediaDrmCallback r1 = r1.callback     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                java.util.UUID r2 = r2.uuid     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                java.lang.Object r3 = r0.request     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest r3 = (com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest) r3     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                byte[] r1 = r1.executeKeyRequest(r2, r3)     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                goto L_0x0044
            L_0x001c:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                r1.<init>()     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                throw r1     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
            L_0x0022:
                com.google.android.exoplayer2.drm.DefaultDrmSession r1 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                com.google.android.exoplayer2.drm.MediaDrmCallback r1 = r1.callback     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                java.util.UUID r2 = r2.uuid     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                java.lang.Object r3 = r0.request     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest r3 = (com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest) r3     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                byte[] r1 = r1.executeProvisionRequest(r2, r3)     // Catch:{ MediaDrmCallbackException -> 0x003c, Exception -> 0x0033 }
                goto L_0x0044
            L_0x0033:
                r1 = move-exception
                java.lang.String r2 = "DefaultDrmSession"
                java.lang.String r3 = "Key/provisioning request produced an unexpected exception. Not retrying."
                com.google.android.exoplayer2.util.Log.m359w(r2, r3, r1)
                goto L_0x0044
            L_0x003c:
                r1 = move-exception
                boolean r2 = r5.maybeRetryRequest(r6, r1)
                if (r2 == 0) goto L_0x0044
                return
            L_0x0044:
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this
                com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r2 = r2.loadErrorHandlingPolicy
                long r3 = r0.taskId
                r2.onLoadTaskConcluded(r3)
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this
                com.google.android.exoplayer2.drm.DefaultDrmSession$ResponseHandler r2 = r2.responseHandler
                int r6 = r6.what
                java.lang.Object r0 = r0.request
                android.util.Pair r0 = android.util.Pair.create(r0, r1)
                android.os.Message r6 = r2.obtainMessage(r6, r0)
                r6.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DefaultDrmSession.RequestHandler.handleMessage(android.os.Message):void");
        }

        private boolean maybeRetryRequest(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            IOException iOException;
            MediaDrmCallbackException mediaDrmCallbackException2 = mediaDrmCallbackException;
            RequestTask requestTask = (RequestTask) message.obj;
            if (!requestTask.allowRetry) {
                return false;
            }
            requestTask.errorCount++;
            if (requestTask.errorCount > DefaultDrmSession.this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(3)) {
                return false;
            }
            LoadEventInfo loadEventInfo = new LoadEventInfo(requestTask.taskId, mediaDrmCallbackException2.dataSpec, mediaDrmCallbackException2.uriAfterRedirects, mediaDrmCallbackException2.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - requestTask.startTimeMs, mediaDrmCallbackException2.bytesLoaded);
            MediaLoadData mediaLoadData = new MediaLoadData(3);
            if (mediaDrmCallbackException.getCause() instanceof IOException) {
                iOException = (IOException) mediaDrmCallbackException.getCause();
            } else {
                iOException = new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause());
            }
            long retryDelayMsFor = DefaultDrmSession.this.loadErrorHandlingPolicy.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, mediaLoadData, iOException, requestTask.errorCount));
            if (retryDelayMsFor == C1844C.TIME_UNSET) {
                return false;
            }
            sendMessageDelayed(Message.obtain(message), retryDelayMsFor);
            return true;
        }
    }

    private static final class RequestTask {
        public final boolean allowRetry;
        public int errorCount;
        public final Object request;
        public final long startTimeMs;
        public final long taskId;

        public RequestTask(long j, boolean z, long j2, Object obj) {
            this.taskId = j;
            this.allowRetry = z;
            this.startTimeMs = j2;
            this.request = obj;
        }
    }
}

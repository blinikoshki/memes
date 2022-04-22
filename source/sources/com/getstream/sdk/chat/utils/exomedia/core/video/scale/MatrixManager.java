package com.getstream.sdk.chat.utils.exomedia.core.video.scale;

import android.graphics.Point;
import android.view.View;
import java.lang.ref.WeakReference;
import p015io.getstream.chat.android.client.logger.ChatLogger;

public class MatrixManager {
    protected static final int QUARTER_ROTATION = 90;
    private static final String TAG = "MatrixManager";
    protected int currentRotation = 0;
    protected ScaleType currentScaleType = ScaleType.FIT_CENTER;
    protected Point intrinsicVideoSize = new Point(0, 0);
    protected WeakReference<View> requestedModificationView = new WeakReference<>((Object) null);
    protected Integer requestedRotation = null;
    protected ScaleType requestedScaleType = null;

    public void reset() {
        setIntrinsicVideoSize(0, 0);
        this.currentRotation = 0;
    }

    public boolean ready() {
        return this.intrinsicVideoSize.x > 0 && this.intrinsicVideoSize.y > 0;
    }

    public void setIntrinsicVideoSize(int i, int i2) {
        boolean z = true;
        if ((this.currentRotation / 90) % 2 != 1) {
            z = false;
        }
        this.intrinsicVideoSize.x = z ? i2 : i;
        Point point = this.intrinsicVideoSize;
        if (!z) {
            i = i2;
        }
        point.y = i;
        if (ready()) {
            applyRequestedModifications();
        }
    }

    public int getCurrentRotation() {
        Integer num = this.requestedRotation;
        return num != null ? num.intValue() : this.currentRotation;
    }

    public ScaleType getCurrentScaleType() {
        ScaleType scaleType = this.requestedScaleType;
        return scaleType != null ? scaleType : this.currentScaleType;
    }

    public void rotate(View view, int i) {
        if (!ready()) {
            this.requestedRotation = Integer.valueOf(i);
            this.requestedModificationView = new WeakReference<>(view);
            return;
        }
        boolean z = false;
        boolean z2 = (i / 90) % 2 == 1;
        if ((this.currentRotation / 90) % 2 == 1) {
            z = true;
        }
        if (z2 != z) {
            int i2 = this.intrinsicVideoSize.x;
            Point point = this.intrinsicVideoSize;
            point.x = point.y;
            this.intrinsicVideoSize.y = i2;
            scale(view, this.currentScaleType);
        }
        this.currentRotation = i;
        view.setRotation((float) i);
    }

    public boolean scale(View view, ScaleType scaleType) {
        if (!ready()) {
            this.requestedScaleType = scaleType;
            this.requestedModificationView = new WeakReference<>(view);
            return false;
        } else if (view.getHeight() == 0 || view.getWidth() == 0) {
            ChatLogger instance = ChatLogger.Companion.getInstance();
            instance.logE((Object) TAG, "Unable to apply scale with a view size of (" + view.getWidth() + ", " + view.getHeight() + ")");
            return false;
        } else {
            this.currentScaleType = scaleType;
            switch (C17181.f165x79b46f34[scaleType.ordinal()]) {
                case 1:
                    applyCenter(view);
                    return true;
                case 2:
                    applyCenterCrop(view);
                    return true;
                case 3:
                    applyCenterInside(view);
                    return true;
                case 4:
                    applyFitCenter(view);
                    return true;
                case 5:
                    applyFitXy(view);
                    return true;
                case 6:
                    setScale(view, 1.0f, 1.0f);
                    return true;
                default:
                    return true;
            }
        }
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.core.video.scale.MatrixManager$1 */
    static /* synthetic */ class C17181 {

        /* renamed from: $SwitchMap$com$getstream$sdk$chat$utils$exomedia$core$video$scale$ScaleType */
        static final /* synthetic */ int[] f165x79b46f34;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType[] r0 = com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f165x79b46f34 = r0
                com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType r1 = com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f165x79b46f34     // Catch:{ NoSuchFieldError -> 0x001d }
                com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType r1 = com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f165x79b46f34     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType r1 = com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f165x79b46f34     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType r1 = com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f165x79b46f34     // Catch:{ NoSuchFieldError -> 0x003e }
                com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType r1 = com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f165x79b46f34     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType r1 = com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType.NONE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.utils.exomedia.core.video.scale.MatrixManager.C17181.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void applyCenter(View view) {
        setScale(view, ((float) this.intrinsicVideoSize.x) / ((float) view.getWidth()), ((float) this.intrinsicVideoSize.y) / ((float) view.getHeight()));
    }

    /* access modifiers changed from: protected */
    public void applyCenterCrop(View view) {
        float width = ((float) view.getWidth()) / ((float) this.intrinsicVideoSize.x);
        float height = ((float) view.getHeight()) / ((float) this.intrinsicVideoSize.y);
        float max = Math.max(width, height);
        setScale(view, max / width, max / height);
    }

    /* access modifiers changed from: protected */
    public void applyCenterInside(View view) {
        if (this.intrinsicVideoSize.x > view.getWidth() || this.intrinsicVideoSize.y > view.getHeight()) {
            applyFitCenter(view);
        } else {
            applyCenter(view);
        }
    }

    /* access modifiers changed from: protected */
    public void applyFitCenter(View view) {
        float width = ((float) view.getWidth()) / ((float) this.intrinsicVideoSize.x);
        float height = ((float) view.getHeight()) / ((float) this.intrinsicVideoSize.y);
        float min = Math.min(width, height);
        setScale(view, min / width, min / height);
    }

    /* access modifiers changed from: protected */
    public void applyFitXy(View view) {
        setScale(view, 1.0f, 1.0f);
    }

    /* access modifiers changed from: protected */
    public void setScale(View view, float f, float f2) {
        boolean z = true;
        if ((this.currentRotation / 90) % 2 != 1) {
            z = false;
        }
        if (z) {
            float height = (f2 * ((float) view.getHeight())) / ((float) view.getWidth());
            f2 = (f * ((float) view.getWidth())) / ((float) view.getHeight());
            f = height;
        }
        view.setScaleX(f);
        view.setScaleY(f2);
    }

    /* access modifiers changed from: protected */
    public void applyRequestedModifications() {
        View view = (View) this.requestedModificationView.get();
        if (view != null) {
            Integer num = this.requestedRotation;
            if (num != null) {
                rotate(view, num.intValue());
                this.requestedRotation = null;
            }
            ScaleType scaleType = this.requestedScaleType;
            if (scaleType != null) {
                scale(view, scaleType);
                this.requestedScaleType = null;
            }
        }
        this.requestedModificationView = new WeakReference<>((Object) null);
    }
}

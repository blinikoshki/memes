package editor.util;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Leditor/util/ViewUtils;", "", "()V", "sNextGeneratedId", "Ljava/util/concurrent/atomic/AtomicInteger;", "generateViewId", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ViewUtils.kt */
public final class ViewUtils {
    public static final ViewUtils INSTANCE = new ViewUtils();
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    private ViewUtils() {
    }

    public final int generateViewId() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            atomicInteger = sNextGeneratedId;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }
}

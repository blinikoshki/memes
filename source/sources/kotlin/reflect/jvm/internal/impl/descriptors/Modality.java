package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: Modality.kt */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    /* compiled from: Modality.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Modality convertFromFlags(boolean z, boolean z2, boolean z3) {
            if (z) {
                return Modality.SEALED;
            }
            if (z2) {
                return Modality.ABSTRACT;
            }
            if (z3) {
                return Modality.OPEN;
            }
            return Modality.FINAL;
        }
    }
}

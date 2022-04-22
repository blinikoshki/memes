package wireframe.language.properties;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo26107d2 = {"Lwireframe/language/properties/WfDimension;", "", "()V", "MatchParent", "Percentage", "WrapContent", "Lwireframe/language/properties/WfDimension$MatchParent;", "Lwireframe/language/properties/WfDimension$WrapContent;", "Lwireframe/language/properties/WfDimension$Percentage;", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfDimension.kt */
public abstract class WfDimension {

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lwireframe/language/properties/WfDimension$MatchParent;", "Lwireframe/language/properties/WfDimension;", "()V", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WfDimension.kt */
    public static final class MatchParent extends WfDimension {
        public static final MatchParent INSTANCE = new MatchParent();

        private MatchParent() {
            super((DefaultConstructorMarker) null);
        }
    }

    private WfDimension() {
    }

    public /* synthetic */ WfDimension(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lwireframe/language/properties/WfDimension$WrapContent;", "Lwireframe/language/properties/WfDimension;", "()V", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WfDimension.kt */
    public static final class WrapContent extends WfDimension {
        public static final WrapContent INSTANCE = new WrapContent();

        private WrapContent() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lwireframe/language/properties/WfDimension$Percentage;", "Lwireframe/language/properties/WfDimension;", "percentage", "", "(I)V", "getPercentage", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WfDimension.kt */
    public static final class Percentage extends WfDimension {
        private final int percentage;

        public static /* synthetic */ Percentage copy$default(Percentage percentage2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = percentage2.percentage;
            }
            return percentage2.copy(i);
        }

        public final int component1() {
            return this.percentage;
        }

        public final Percentage copy(int i) {
            return new Percentage(i);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Percentage) && this.percentage == ((Percentage) obj).percentage;
            }
            return true;
        }

        public int hashCode() {
            return this.percentage;
        }

        public String toString() {
            return "Percentage(percentage=" + this.percentage + ")";
        }

        public final int getPercentage() {
            return this.percentage;
        }

        public Percentage(int i) {
            super((DefaultConstructorMarker) null);
            this.percentage = i;
        }
    }
}

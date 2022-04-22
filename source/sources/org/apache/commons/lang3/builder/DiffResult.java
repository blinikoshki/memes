package org.apache.commons.lang3.builder;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DiffResult implements Iterable<Diff<?>> {
    private static final String DIFFERS_STRING = "differs from";
    public static final String OBJECTS_SAME_STRING = "";
    private final List<Diff<?>> diffs;
    private final Object lhs;
    private final Object rhs;
    private final ToStringStyle style;

    DiffResult(Object obj, Object obj2, List<Diff<?>> list, ToStringStyle toStringStyle) {
        if (obj == null) {
            throw new IllegalArgumentException("Left hand object cannot be null");
        } else if (obj2 == null) {
            throw new IllegalArgumentException("Right hand object cannot be null");
        } else if (list != null) {
            this.diffs = list;
            this.lhs = obj;
            this.rhs = obj2;
            if (toStringStyle == null) {
                this.style = ToStringStyle.DEFAULT_STYLE;
            } else {
                this.style = toStringStyle;
            }
        } else {
            throw new IllegalArgumentException("List of differences cannot be null");
        }
    }

    public List<Diff<?>> getDiffs() {
        return Collections.unmodifiableList(this.diffs);
    }

    public int getNumberOfDiffs() {
        return this.diffs.size();
    }

    public ToStringStyle getToStringStyle() {
        return this.style;
    }

    public String toString() {
        return toString(this.style);
    }

    public String toString(ToStringStyle toStringStyle) {
        if (this.diffs.size() == 0) {
            return "";
        }
        ToStringBuilder toStringBuilder = new ToStringBuilder(this.lhs, toStringStyle);
        ToStringBuilder toStringBuilder2 = new ToStringBuilder(this.rhs, toStringStyle);
        for (Diff next : this.diffs) {
            toStringBuilder.append(next.getFieldName(), next.getLeft());
            toStringBuilder2.append(next.getFieldName(), next.getRight());
        }
        return String.format("%s %s %s", new Object[]{toStringBuilder.build(), DIFFERS_STRING, toStringBuilder2.build()});
    }

    public Iterator<Diff<?>> iterator() {
        return this.diffs.iterator();
    }
}

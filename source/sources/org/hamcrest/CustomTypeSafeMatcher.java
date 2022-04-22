package org.hamcrest;

public abstract class CustomTypeSafeMatcher<T> extends TypeSafeMatcher<T> {
    private final String fixedDescription;

    public CustomTypeSafeMatcher(String str) {
        if (str != null) {
            this.fixedDescription = str;
            return;
        }
        throw new IllegalArgumentException("Description must be non null!");
    }

    public final void describeTo(Description description) {
        description.appendText(this.fixedDescription);
    }
}

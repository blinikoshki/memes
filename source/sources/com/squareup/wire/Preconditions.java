package com.squareup.wire;

import java.util.Objects;

final class Preconditions {
    private Preconditions() {
    }

    static void checkNotNull(Object obj, String str) {
        Objects.requireNonNull(obj, str);
    }
}

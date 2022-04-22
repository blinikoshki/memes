package com.snapchat.kit.sdk.core.metrics.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

public enum LoginRoute implements WireEnum {
    UNKNOWN_LOGIN_ROUTE(0),
    LOGIN_ROUTE(1),
    VERIFY_ROUTE(2);
    
    public static final ProtoAdapter<LoginRoute> ADAPTER = null;
    private final int value;

    static {
        ADAPTER = new ProtoAdapter_LoginRoute();
    }

    private LoginRoute(int i) {
        this.value = i;
    }

    public static LoginRoute fromValue(int i) {
        if (i == 0) {
            return UNKNOWN_LOGIN_ROUTE;
        }
        if (i == 1) {
            return LOGIN_ROUTE;
        }
        if (i != 2) {
            return null;
        }
        return VERIFY_ROUTE;
    }

    public final int getValue() {
        return this.value;
    }

    private static final class ProtoAdapter_LoginRoute extends EnumAdapter<LoginRoute> {
        ProtoAdapter_LoginRoute() {
            super(LoginRoute.class);
        }

        /* access modifiers changed from: protected */
        public final LoginRoute fromValue(int i) {
            return LoginRoute.fromValue(i);
        }
    }
}

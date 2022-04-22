package com.iab.omid.library.giphy;

import android.content.Context;

public final class Omid {
    private static C3961a INSTANCE = new C3961a();

    private Omid() {
    }

    public static boolean activateWithOmidApiVersion(String str, Context context) {
        INSTANCE.mo55882a(context.getApplicationContext());
        return true;
    }

    public static String getVersion() {
        return INSTANCE.mo55881a();
    }

    public static boolean isActive() {
        return INSTANCE.mo55885b();
    }

    public static boolean isCompatibleWithOmidApiVersion(String str) {
        return INSTANCE.mo55884a(str);
    }
}

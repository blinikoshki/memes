package com.google.android.gms.common.internal;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class LibraryVersion {
    private static final GmsLogger zzez = new GmsLogger("LibraryVersion", "");
    private static LibraryVersion zzfa = new LibraryVersion();
    private ConcurrentHashMap<String, String> zzfb = new ConcurrentHashMap<>();

    public static LibraryVersion getInstance() {
        return zzfa;
    }

    protected LibraryVersion() {
    }

    public String getVersion(String str) {
        Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
        if (this.zzfb.containsKey(str)) {
            return this.zzfb.get(str);
        }
        Properties properties = new Properties();
        String str2 = null;
        try {
            InputStream resourceAsStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", new Object[]{str}));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str2 = properties.getProperty(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, (String) null);
                GmsLogger gmsLogger = zzez;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str2).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str2);
                gmsLogger.mo39840v("LibraryVersion", sb.toString());
            } else {
                GmsLogger gmsLogger2 = zzez;
                String valueOf = String.valueOf(str);
                gmsLogger2.mo39842w("LibraryVersion", valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "));
            }
        } catch (IOException e) {
            GmsLogger gmsLogger3 = zzez;
            String valueOf2 = String.valueOf(str);
            gmsLogger3.mo39834e("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "), e);
        }
        if (str2 == null) {
            zzez.mo39831d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            str2 = "UNKNOWN";
        }
        this.zzfb.put(str, str2);
        return str2;
    }
}

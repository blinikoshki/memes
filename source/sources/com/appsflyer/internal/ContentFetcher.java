package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.appsflyer.AFLogger;
import com.appsflyer.AndroidUtils;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class ContentFetcher<T> {
    private final FutureTask<T> $$a = new FutureTask<>(new Callable<T>() {
        public final T call() {
            if (ContentFetcher.this.valid()) {
                return ContentFetcher.this.query();
            }
            return null;
        }
    });
    private final String[] AFDateFormat;
    public final String authority;
    public final Context context;

    /* access modifiers changed from: protected */
    public abstract T query();

    public ContentFetcher(Context context2, String str, String... strArr) {
        this.context = context2;
        this.authority = str;
        this.AFDateFormat = strArr;
    }

    public void start() {
        new Thread(this.$$a).start();
    }

    public T get() {
        try {
            return this.$$a.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            onError(e);
            return null;
        }
    }

    public boolean valid() {
        try {
            ProviderInfo resolveContentProvider = this.context.getPackageManager().resolveContentProvider(this.authority, 128);
            if (resolveContentProvider == null || !Arrays.asList(this.AFDateFormat).contains(AndroidUtils.signature(this.context.getPackageManager(), resolveContentProvider.packageName))) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException | CertificateException e) {
            onError(e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onError(Exception exc) {
        AFLogger.afErrorLog(exc.getMessage(), exc);
    }
}

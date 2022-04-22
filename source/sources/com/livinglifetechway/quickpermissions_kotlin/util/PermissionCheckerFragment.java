package com.livinglifetechway.quickpermissions_kotlin.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AlertBuilder;
import org.jetbrains.anko.AndroidDialogsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ#\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J+\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\bJ\b\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0004J\u0010\u0010!\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Lcom/livinglifetechway/quickpermissions_kotlin/util/PermissionCheckerFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mListener", "Lcom/livinglifetechway/quickpermissions_kotlin/util/PermissionCheckerFragment$QuickPermissionsCallback;", "quickPermissionsRequest", "Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsRequest;", "clean", "", "handlePermissionResult", "permissions", "", "", "grantResults", "", "([Ljava/lang/String;[I)V", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "openAppSettings", "removeListener", "removeRequestPermissionsRequest", "requestPermissionsFromUser", "setListener", "listener", "setRequestPermissionsRequest", "Companion", "QuickPermissionsCallback", "quickpermissions-kotlin_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: PermissionCheckerFragment.kt */
public final class PermissionCheckerFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int PERMISSIONS_REQUEST_CODE = 199;
    private static final String TAG = "QuickPermissionsKotlin";
    private QuickPermissionsCallback mListener;
    /* access modifiers changed from: private */
    public QuickPermissionsRequest quickPermissionsRequest;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, mo26107d2 = {"Lcom/livinglifetechway/quickpermissions_kotlin/util/PermissionCheckerFragment$QuickPermissionsCallback;", "", "onPermissionsDenied", "", "quickPermissionsRequest", "Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsRequest;", "onPermissionsGranted", "onPermissionsPermanentlyDenied", "shouldShowRequestPermissionsRationale", "quickpermissions-kotlin_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: PermissionCheckerFragment.kt */
    public interface QuickPermissionsCallback {
        void onPermissionsDenied(QuickPermissionsRequest quickPermissionsRequest);

        void onPermissionsGranted(QuickPermissionsRequest quickPermissionsRequest);

        void onPermissionsPermanentlyDenied(QuickPermissionsRequest quickPermissionsRequest);

        void shouldShowRequestPermissionsRationale(QuickPermissionsRequest quickPermissionsRequest);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/livinglifetechway/quickpermissions_kotlin/util/PermissionCheckerFragment$Companion;", "", "()V", "PERMISSIONS_REQUEST_CODE", "", "TAG", "", "newInstance", "Lcom/livinglifetechway/quickpermissions_kotlin/util/PermissionCheckerFragment;", "quickpermissions-kotlin_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: PermissionCheckerFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PermissionCheckerFragment newInstance() {
            return new PermissionCheckerFragment();
        }
    }

    public final void setListener(QuickPermissionsCallback quickPermissionsCallback) {
        Intrinsics.checkParameterIsNotNull(quickPermissionsCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = quickPermissionsCallback;
        Log.d(TAG, "onCreate: listeners set");
    }

    private final void removeListener() {
        this.mListener = null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(TAG, "onCreate: permission fragment created");
    }

    public final void setRequestPermissionsRequest(QuickPermissionsRequest quickPermissionsRequest2) {
        this.quickPermissionsRequest = quickPermissionsRequest2;
    }

    private final void removeRequestPermissionsRequest() {
        this.quickPermissionsRequest = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r0 = r0.getDeniedPermissions();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clean() {
        /*
            r2 = this;
            com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsRequest r0 = r2.quickPermissionsRequest
            if (r0 == 0) goto L_0x0021
            if (r0 == 0) goto L_0x000e
            java.lang.String[] r0 = r0.getDeniedPermissions()
            if (r0 == 0) goto L_0x000e
            int r0 = r0.length
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            if (r0 <= 0) goto L_0x001a
            com.livinglifetechway.quickpermissions_kotlin.util.PermissionCheckerFragment$QuickPermissionsCallback r0 = r2.mListener
            if (r0 == 0) goto L_0x001a
            com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsRequest r1 = r2.quickPermissionsRequest
            r0.onPermissionsDenied(r1)
        L_0x001a:
            r2.removeRequestPermissionsRequest()
            r2.removeListener()
            goto L_0x0028
        L_0x0021:
            java.lang.String r0 = "QuickPermissionsKotlin"
            java.lang.String r1 = "clean: QuickPermissionsRequest has already completed its flow. No further callbacks will be called for the current flow."
            android.util.Log.w(r0, r1)
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livinglifetechway.quickpermissions_kotlin.util.PermissionCheckerFragment.clean():void");
    }

    public final void requestPermissionsFromUser() {
        if (this.quickPermissionsRequest != null) {
            Log.d(TAG, "requestPermissionsFromUser: requesting permissions");
            QuickPermissionsRequest quickPermissionsRequest2 = this.quickPermissionsRequest;
            String[] permissions = quickPermissionsRequest2 != null ? quickPermissionsRequest2.getPermissions() : null;
            if (permissions == null) {
                permissions = new String[0];
            }
            requestPermissions(permissions, PERMISSIONS_REQUEST_CODE);
            return;
        }
        Log.w(TAG, "requestPermissionsFromUser: QuickPermissionsRequest has already completed its flow. Cannot request permissions again from the request received from the callback. You can start the new flow by calling runWithPermissions() { } again.");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        Log.d(TAG, "passing callback");
        handlePermissionResult(strArr, iArr);
    }

    private final void handlePermissionResult(String[] strArr, int[] iArr) {
        boolean z;
        boolean z2;
        AlertBuilder<DialogInterface> alert;
        AlertBuilder<DialogInterface> alert2;
        if (strArr.length == 0) {
            Log.w(TAG, "handlePermissionResult: Permissions result discarded. You might have called multiple permissions request simultaneously");
        } else if (PermissionsUtil.INSTANCE.hasSelfPermission(getContext(), strArr)) {
            QuickPermissionsRequest quickPermissionsRequest2 = this.quickPermissionsRequest;
            if (quickPermissionsRequest2 != null) {
                quickPermissionsRequest2.setDeniedPermissions(new String[0]);
            }
            QuickPermissionsCallback quickPermissionsCallback = this.mListener;
            if (quickPermissionsCallback != null) {
                quickPermissionsCallback.onPermissionsGranted(this.quickPermissionsRequest);
            }
            clean();
        } else {
            String[] deniedPermissions = PermissionsUtil.INSTANCE.getDeniedPermissions(strArr, iArr);
            QuickPermissionsRequest quickPermissionsRequest3 = this.quickPermissionsRequest;
            if (quickPermissionsRequest3 != null) {
                quickPermissionsRequest3.setDeniedPermissions(deniedPermissions);
            }
            int length = deniedPermissions.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    z2 = true;
                    break;
                } else if (!shouldShowRequestPermissionRationale(deniedPermissions[i])) {
                    z = true;
                    z2 = false;
                    break;
                } else {
                    i++;
                }
            }
            QuickPermissionsRequest quickPermissionsRequest4 = this.quickPermissionsRequest;
            if (quickPermissionsRequest4 == null || !quickPermissionsRequest4.getHandlePermanentlyDenied() || !z) {
                QuickPermissionsRequest quickPermissionsRequest5 = this.quickPermissionsRequest;
                if (quickPermissionsRequest5 == null || !quickPermissionsRequest5.getHandleRationale() || !z2) {
                    clean();
                    return;
                }
                QuickPermissionsRequest quickPermissionsRequest6 = this.quickPermissionsRequest;
                if (quickPermissionsRequest6 == null || quickPermissionsRequest6.getRationaleMethod$quickpermissions_kotlin_release() == null) {
                    FragmentActivity activity = getActivity();
                    if (activity != null && (alert = AndroidDialogsKt.alert((Context) activity, (Function1<? super AlertBuilder<? extends DialogInterface>, Unit>) new PermissionCheckerFragment$handlePermissionResult$5(this))) != null) {
                        alert.setCancelable(false);
                        if (alert != null) {
                            alert.show();
                            return;
                        }
                        return;
                    }
                    return;
                }
                QuickPermissionsCallback quickPermissionsCallback2 = this.mListener;
                if (quickPermissionsCallback2 != null) {
                    quickPermissionsCallback2.shouldShowRequestPermissionsRationale(this.quickPermissionsRequest);
                    return;
                }
                return;
            }
            QuickPermissionsRequest quickPermissionsRequest7 = this.quickPermissionsRequest;
            if (quickPermissionsRequest7 == null || quickPermissionsRequest7.getPermanentDeniedMethod$quickpermissions_kotlin_release() == null) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && (alert2 = AndroidDialogsKt.alert((Context) activity2, (Function1<? super AlertBuilder<? extends DialogInterface>, Unit>) new PermissionCheckerFragment$handlePermissionResult$2(this))) != null) {
                    alert2.setCancelable(false);
                    if (alert2 != null) {
                        alert2.show();
                        return;
                    }
                    return;
                }
                return;
            }
            QuickPermissionsRequest quickPermissionsRequest8 = this.quickPermissionsRequest;
            if (quickPermissionsRequest8 != null) {
                quickPermissionsRequest8.setPermanentlyDeniedPermissions(PermissionsUtil.INSTANCE.getPermanentlyDeniedPermissions(this, strArr, iArr));
            }
            QuickPermissionsCallback quickPermissionsCallback3 = this.mListener;
            if (quickPermissionsCallback3 != null) {
                quickPermissionsCallback3.onPermissionsPermanentlyDenied(this.quickPermissionsRequest);
            }
        }
    }

    public final void openAppSettings() {
        if (this.quickPermissionsRequest != null) {
            FragmentActivity activity = getActivity();
            startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", activity != null ? activity.getPackageName() : null, (String) null)), PERMISSIONS_REQUEST_CODE);
            return;
        }
        Log.w(TAG, "openAppSettings: QuickPermissionsRequest has already completed its flow. Cannot open app settings");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String[] strArr;
        super.onActivityResult(i, i2, intent);
        if (i == PERMISSIONS_REQUEST_CODE) {
            QuickPermissionsRequest quickPermissionsRequest2 = this.quickPermissionsRequest;
            int i3 = 0;
            if (quickPermissionsRequest2 == null || (strArr = quickPermissionsRequest2.getPermissions()) == null) {
                strArr = new String[0];
            }
            int[] iArr = new int[strArr.length];
            int length = strArr.length;
            int i4 = 0;
            while (i3 < length) {
                String str = strArr[i3];
                int i5 = i4 + 1;
                Context context = getContext();
                iArr[i4] = context != null ? ActivityCompat.checkSelfPermission(context, str) : -1;
                i3++;
                i4 = i5;
            }
            handlePermissionResult(strArr, iArr);
        }
    }
}

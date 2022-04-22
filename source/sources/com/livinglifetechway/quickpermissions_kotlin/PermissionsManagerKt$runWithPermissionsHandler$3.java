package com.livinglifetechway.quickpermissions_kotlin;

import android.util.Log;
import com.livinglifetechway.quickpermissions_kotlin.util.PermissionCheckerFragment;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, mo26107d2 = {"com/livinglifetechway/quickpermissions_kotlin/PermissionsManagerKt$runWithPermissionsHandler$3", "Lcom/livinglifetechway/quickpermissions_kotlin/util/PermissionCheckerFragment$QuickPermissionsCallback;", "onPermissionsDenied", "", "quickPermissionsRequest", "Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsRequest;", "onPermissionsGranted", "onPermissionsPermanentlyDenied", "shouldShowRequestPermissionsRationale", "quickpermissions-kotlin_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: PermissionsManager.kt */
public final class PermissionsManagerKt$runWithPermissionsHandler$3 implements PermissionCheckerFragment.QuickPermissionsCallback {
    final /* synthetic */ Function0 $callback;

    PermissionsManagerKt$runWithPermissionsHandler$3(Function0 function0) {
        this.$callback = function0;
    }

    public void onPermissionsGranted(QuickPermissionsRequest quickPermissionsRequest) {
        Log.d("runWithPermissions", "runWithPermissions: got permissions");
        try {
            this.$callback.invoke();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onPermissionsDenied(QuickPermissionsRequest quickPermissionsRequest) {
        Function1<QuickPermissionsRequest, Unit> permissionsDeniedMethod$quickpermissions_kotlin_release;
        if (quickPermissionsRequest != null && (permissionsDeniedMethod$quickpermissions_kotlin_release = quickPermissionsRequest.getPermissionsDeniedMethod$quickpermissions_kotlin_release()) != null) {
            Unit invoke = permissionsDeniedMethod$quickpermissions_kotlin_release.invoke(quickPermissionsRequest);
        }
    }

    public void shouldShowRequestPermissionsRationale(QuickPermissionsRequest quickPermissionsRequest) {
        Function1<QuickPermissionsRequest, Unit> rationaleMethod$quickpermissions_kotlin_release;
        if (quickPermissionsRequest != null && (rationaleMethod$quickpermissions_kotlin_release = quickPermissionsRequest.getRationaleMethod$quickpermissions_kotlin_release()) != null) {
            Unit invoke = rationaleMethod$quickpermissions_kotlin_release.invoke(quickPermissionsRequest);
        }
    }

    public void onPermissionsPermanentlyDenied(QuickPermissionsRequest quickPermissionsRequest) {
        Function1<QuickPermissionsRequest, Unit> permanentDeniedMethod$quickpermissions_kotlin_release;
        if (quickPermissionsRequest != null && (permanentDeniedMethod$quickpermissions_kotlin_release = quickPermissionsRequest.getPermanentDeniedMethod$quickpermissions_kotlin_release()) != null) {
            Unit invoke = permanentDeniedMethod$quickpermissions_kotlin_release.invoke(quickPermissionsRequest);
        }
    }
}

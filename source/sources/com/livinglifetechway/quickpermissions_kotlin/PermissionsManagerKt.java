package com.livinglifetechway.quickpermissions_kotlin;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.internal.NativeProtocol;
import com.livinglifetechway.quickpermissions_kotlin.util.PermissionCheckerFragment;
import com.livinglifetechway.quickpermissions_kotlin.util.PermissionsUtil;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsRequest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a?\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\r\u001a?\u0010\u000e\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u000f2\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\"\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u0010\u001a?\u0010\u000e\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u00112\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\"\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"TAG", "", "runWithPermissionsHandler", "", "target", "", "permissions", "", "callback", "Lkotlin/Function0;", "", "options", "Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsOptions;", "(Ljava/lang/Object;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsOptions;)Ljava/lang/Void;", "runWithPermissions", "Landroid/content/Context;", "(Landroid/content/Context;[Ljava/lang/String;Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsOptions;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Landroidx/fragment/app/Fragment;", "(Landroid/support/v4/app/Fragment;[Ljava/lang/String;Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsOptions;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "quickpermissions-kotlin_release"}, mo26108k = 2, mo26109mv = {1, 1, 13})
/* compiled from: PermissionsManager.kt */
public final class PermissionsManagerKt {
    private static final String TAG = "runWithPermissions";

    public static /* synthetic */ Object runWithPermissions$default(Context context, String[] strArr, QuickPermissionsOptions quickPermissionsOptions, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            quickPermissionsOptions = new QuickPermissionsOptions(false, (String) null, false, (String) null, (Function1) null, (Function1) null, (Function1) null, 127, (DefaultConstructorMarker) null);
        }
        return runWithPermissions(context, strArr, quickPermissionsOptions, (Function0<Unit>) function0);
    }

    public static final Object runWithPermissions(Context context, String[] strArr, QuickPermissionsOptions quickPermissionsOptions, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        Intrinsics.checkParameterIsNotNull(quickPermissionsOptions, "options");
        Intrinsics.checkParameterIsNotNull(function0, "callback");
        return runWithPermissionsHandler(context, strArr, function0, quickPermissionsOptions);
    }

    public static /* synthetic */ Object runWithPermissions$default(Fragment fragment, String[] strArr, QuickPermissionsOptions quickPermissionsOptions, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            quickPermissionsOptions = new QuickPermissionsOptions(false, (String) null, false, (String) null, (Function1) null, (Function1) null, (Function1) null, 127, (DefaultConstructorMarker) null);
        }
        return runWithPermissions(fragment, strArr, quickPermissionsOptions, (Function0<Unit>) function0);
    }

    public static final Object runWithPermissions(Fragment fragment, String[] strArr, QuickPermissionsOptions quickPermissionsOptions, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        Intrinsics.checkParameterIsNotNull(quickPermissionsOptions, "options");
        Intrinsics.checkParameterIsNotNull(function0, "callback");
        return runWithPermissionsHandler(fragment, strArr, function0, quickPermissionsOptions);
    }

    private static final Void runWithPermissionsHandler(Object obj, String[] strArr, Function0<Unit> function0, QuickPermissionsOptions quickPermissionsOptions) {
        Context context;
        PermissionCheckerFragment permissionCheckerFragment;
        String str;
        String str2;
        Object obj2 = obj;
        String[] strArr2 = strArr;
        Log.d(TAG, "runWithPermissions: start");
        Log.d(TAG, "runWithPermissions: permissions to check: " + strArr2);
        if ((obj2 instanceof AppCompatActivity) || (obj2 instanceof Fragment)) {
            Log.d(TAG, "runWithPermissions: context found");
            if (obj2 instanceof Context) {
                context = (Context) obj2;
            } else {
                context = obj2 instanceof Fragment ? ((Fragment) obj2).getContext() : null;
            }
            if (PermissionsUtil.INSTANCE.hasSelfPermission(context, (String[]) Arrays.copyOf(strArr2, strArr2.length))) {
                Log.d(TAG, "runWithPermissions: already has required permissions. Proceed with the execution.");
                function0.invoke();
            } else {
                Log.d(TAG, "runWithPermissions: doesn't have required permissions");
                boolean z = context instanceof AppCompatActivity;
                if (z) {
                    FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                    permissionCheckerFragment = (PermissionCheckerFragment) (supportFragmentManager != null ? supportFragmentManager.findFragmentByTag(PermissionCheckerFragment.class.getCanonicalName()) : null);
                } else {
                    permissionCheckerFragment = context instanceof Fragment ? (PermissionCheckerFragment) ((Fragment) context).getChildFragmentManager().findFragmentByTag(PermissionCheckerFragment.class.getCanonicalName()) : null;
                }
                if (permissionCheckerFragment == null) {
                    Log.d(TAG, "runWithPermissions: adding headless fragment for asking permissions");
                    permissionCheckerFragment = PermissionCheckerFragment.Companion.newInstance();
                    if (z) {
                        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
                        FragmentTransaction beginTransaction = appCompatActivity.getSupportFragmentManager().beginTransaction();
                        beginTransaction.add((Fragment) permissionCheckerFragment, PermissionCheckerFragment.class.getCanonicalName());
                        beginTransaction.commit();
                        FragmentManager supportFragmentManager2 = appCompatActivity.getSupportFragmentManager();
                        if (supportFragmentManager2 != null) {
                            supportFragmentManager2.executePendingTransactions();
                        }
                    } else if (context instanceof Fragment) {
                        Fragment fragment = (Fragment) context;
                        FragmentTransaction beginTransaction2 = fragment.getChildFragmentManager().beginTransaction();
                        beginTransaction2.add((Fragment) permissionCheckerFragment, PermissionCheckerFragment.class.getCanonicalName());
                        beginTransaction2.commit();
                        fragment.getChildFragmentManager().executePendingTransactions();
                    }
                }
                permissionCheckerFragment.setListener(new PermissionsManagerKt$runWithPermissionsHandler$3(function0));
                QuickPermissionsRequest quickPermissionsRequest = new QuickPermissionsRequest(permissionCheckerFragment, (String[]) Arrays.copyOf(strArr2, strArr2.length), false, (String) null, false, (String) null, (Function1) null, (Function1) null, (Function1) null, (String[]) null, (String[]) null, 2044, (DefaultConstructorMarker) null);
                quickPermissionsRequest.setHandleRationale(quickPermissionsOptions.getHandleRationale());
                quickPermissionsRequest.setHandlePermanentlyDenied(quickPermissionsOptions.getHandlePermanentlyDenied());
                if (StringsKt.isBlank(quickPermissionsOptions.getRationaleMessage())) {
                    str = "These permissions are required to perform this feature. Please allow us to use this feature. ";
                } else {
                    str = quickPermissionsOptions.getRationaleMessage();
                }
                quickPermissionsRequest.setRationaleMessage(str);
                if (StringsKt.isBlank(quickPermissionsOptions.getPermanentlyDeniedMessage())) {
                    str2 = "Some permissions are permanently denied which are required to perform this operation. Please open app settings to grant these permissions.";
                } else {
                    str2 = quickPermissionsOptions.getPermanentlyDeniedMessage();
                }
                quickPermissionsRequest.setPermanentlyDeniedMessage(str2);
                quickPermissionsRequest.setRationaleMethod$quickpermissions_kotlin_release(quickPermissionsOptions.getRationaleMethod());
                quickPermissionsRequest.setPermanentDeniedMethod$quickpermissions_kotlin_release(quickPermissionsOptions.getPermanentDeniedMethod());
                quickPermissionsRequest.setPermissionsDeniedMethod$quickpermissions_kotlin_release(quickPermissionsOptions.getPermissionsDeniedMethod());
                permissionCheckerFragment.setRequestPermissionsRequest(quickPermissionsRequest);
                permissionCheckerFragment.requestPermissionsFromUser();
            }
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Found ");
        if (obj2 == null) {
            Intrinsics.throwNpe();
        }
        sb.append(obj.getClass().getCanonicalName());
        sb.append(" : No support from any classes other than AppCompatActivity/Fragment");
        throw new IllegalStateException(sb.toString());
    }
}

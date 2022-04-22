package com.memes.commons.activity;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J%\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00018\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX.¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/commons/activity/ContractLauncher;", "I", "O", "Landroidx/activity/result/ActivityResultCallback;", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "(Landroidx/activity/result/contract/ActivityResultContract;)V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "resultCallback", "launch", "", "input", "(Ljava/lang/Object;Landroidx/activity/result/ActivityResultCallback;)V", "onActivityResult", "result", "(Ljava/lang/Object;)V", "register", "registrar", "Landroidx/appcompat/app/AppCompatActivity;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ContractLauncher.kt */
public final class ContractLauncher<I, O> implements ActivityResultCallback<O> {
    private final ActivityResultContract<I, O> contract;
    private ActivityResultLauncher<I> launcher;
    private ActivityResultCallback<O> resultCallback;

    public ContractLauncher(ActivityResultContract<I, O> activityResultContract) {
        Intrinsics.checkNotNullParameter(activityResultContract, "contract");
        this.contract = activityResultContract;
    }

    public final void register(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "registrar");
        ActivityResultLauncher<I> registerForActivityResult = appCompatActivity.registerForActivityResult(this.contract, this);
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registrar.registerForAct…ityResult(contract, this)");
        this.launcher = registerForActivityResult;
    }

    public static /* synthetic */ void launch$default(ContractLauncher contractLauncher, Object obj, ActivityResultCallback activityResultCallback, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        contractLauncher.launch(obj, activityResultCallback);
    }

    public final void launch(I i, ActivityResultCallback<O> activityResultCallback) {
        Intrinsics.checkNotNullParameter(activityResultCallback, "resultCallback");
        this.resultCallback = activityResultCallback;
        ActivityResultLauncher<I> activityResultLauncher = this.launcher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("launcher");
        }
        activityResultLauncher.launch(i);
    }

    public void onActivityResult(O o) {
        ActivityResultCallback<O> activityResultCallback = this.resultCallback;
        if (activityResultCallback != null) {
            activityResultCallback.onActivityResult(o);
        }
    }
}

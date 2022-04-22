package com.memes.plus.p040ui.auth.recovery.stages;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/recovery/stages/AccountRecoveryStage;", "", "position", "", "(Ljava/lang/String;II)V", "getPosition", "()I", "REQUEST_OTP", "CONFIRM_OTP", "INPUT_NEW_PASSWORD", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.stages.AccountRecoveryStage */
/* compiled from: AccountRecoveryStage.kt */
public enum AccountRecoveryStage {
    REQUEST_OTP(0),
    CONFIRM_OTP(1),
    INPUT_NEW_PASSWORD(2);
    
    private final int position;

    private AccountRecoveryStage(int i) {
        this.position = i;
    }

    public final int getPosition() {
        return this.position;
    }
}

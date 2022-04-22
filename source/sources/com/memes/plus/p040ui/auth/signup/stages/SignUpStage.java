package com.memes.plus.p040ui.auth.signup.stages;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/stages/SignUpStage;", "", "position", "", "(Ljava/lang/String;II)V", "getPosition", "()I", "EMAIL_INPUT", "PROFILE_INPUT", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.stages.SignUpStage */
/* compiled from: SignUpStage.kt */
public enum SignUpStage {
    EMAIL_INPUT(0),
    PROFILE_INPUT(1);
    
    private final int position;

    private SignUpStage(int i) {
        this.position = i;
    }

    public final int getPosition() {
        return this.position;
    }
}

package com.memes.plus.util.validation;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/util/validation/ValidationResult;", "", "()V", "EMPTY", "", "INVALID", "INVALID_BOUNDS", "MISSING_CHARACTERS", "OK", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ValidationResult.kt */
public final class ValidationResult {
    public static final int EMPTY = 1;
    public static final ValidationResult INSTANCE = new ValidationResult();
    public static final int INVALID = 2;
    public static final int INVALID_BOUNDS = 3;
    public static final int MISSING_CHARACTERS = 4;

    /* renamed from: OK */
    public static final int f1036OK = 5;

    private ValidationResult() {
    }
}

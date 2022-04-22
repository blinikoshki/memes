package com.memes.plus.p040ui.auth.signup.selectbirthday;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import com.memes.plus.C4199R;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/selectbirthday/SelectBirthdayDatePicker;", "Landroid/app/DatePickerDialog$OnDateSetListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callback", "Lcom/memes/plus/ui/auth/signup/selectbirthday/SelectBirthdayDatePicker$Callback;", "datePickerDialog", "Landroid/app/DatePickerDialog;", "onDateSet", "", "view", "Landroid/widget/DatePicker;", "year", "", "month", "dayOfMonth", "showDialog", "Callback", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.selectbirthday.SelectBirthdayDatePicker */
/* compiled from: SelectBirthdayDatePicker.kt */
public final class SelectBirthdayDatePicker implements DatePickerDialog.OnDateSetListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long YEARS_BEFORE = 504576000000L;
    private static final long YEAR_1970 = 0;
    private Callback callback;
    private final DatePickerDialog datePickerDialog;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/selectbirthday/SelectBirthdayDatePicker$Callback;", "", "onBirthDateSelected", "", "calendar", "Ljava/util/Calendar;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.auth.signup.selectbirthday.SelectBirthdayDatePicker$Callback */
    /* compiled from: SelectBirthdayDatePicker.kt */
    public interface Callback {
        void onBirthDateSelected(Calendar calendar);
    }

    public SelectBirthdayDatePicker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "calendar");
        instance.setTimeInMillis(System.currentTimeMillis() - YEARS_BEFORE);
        DatePickerDialog datePickerDialog2 = new DatePickerDialog(context, C4199R.C4207style.AuthDatePicker, this, instance.get(1), instance.get(2), instance.get(5));
        this.datePickerDialog = datePickerDialog2;
        DatePicker datePicker = datePickerDialog2.getDatePicker();
        Intrinsics.checkNotNullExpressionValue(datePicker, "datePickerDialog.datePicker");
        datePicker.setMinDate(0);
        DatePicker datePicker2 = datePickerDialog2.getDatePicker();
        Intrinsics.checkNotNullExpressionValue(datePicker2, "datePickerDialog.datePicker");
        datePicker2.setMaxDate(instance.getTimeInMillis());
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/selectbirthday/SelectBirthdayDatePicker$Companion;", "", "()V", "YEARS_BEFORE", "", "YEAR_1970", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.auth.signup.selectbirthday.SelectBirthdayDatePicker$Companion */
    /* compiled from: SelectBirthdayDatePicker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void showDialog(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
        this.datePickerDialog.show();
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2, i3);
        Callback callback2 = this.callback;
        if (callback2 != null) {
            Intrinsics.checkNotNullExpressionValue(instance, "calendar");
            callback2.onBirthDateSelected(instance);
        }
    }
}

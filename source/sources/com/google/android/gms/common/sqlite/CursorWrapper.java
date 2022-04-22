package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor zzfu;

    public CursorWrapper(Cursor cursor) {
        super(cursor);
        for (int i = 0; i < 10 && (cursor instanceof android.database.CursorWrapper); i++) {
            cursor = ((android.database.CursorWrapper) cursor).getWrappedCursor();
        }
        if (!(cursor instanceof AbstractWindowedCursor)) {
            String valueOf = String.valueOf(cursor.getClass().getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown type: ".concat(valueOf) : new String("Unknown type: "));
        } else {
            this.zzfu = (AbstractWindowedCursor) cursor;
        }
    }

    public CursorWindow getWindow() {
        return this.zzfu.getWindow();
    }

    public void setWindow(CursorWindow cursorWindow) {
        this.zzfu.setWindow(cursorWindow);
    }

    public void fillWindow(int i, CursorWindow cursorWindow) {
        this.zzfu.fillWindow(i, cursorWindow);
    }

    public boolean onMove(int i, int i2) {
        return this.zzfu.onMove(i, i2);
    }

    public /* synthetic */ Cursor getWrappedCursor() {
        return this.zzfu;
    }
}

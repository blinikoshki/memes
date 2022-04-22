package com.memes.plus.data.storage.subscription;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p008db.SupportSQLiteStatement;

public final class SubscriptionDetailDao_Impl implements SubscriptionDetailDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SubscriptionDetail> __insertionAdapterOfSubscriptionDetail;
    private final SharedSQLiteStatement __preparedStmtOfClear;

    public SubscriptionDetailDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSubscriptionDetail = new EntityInsertionAdapter<SubscriptionDetail>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SubscriptionDetail` (`oid`,`otk`,`osk`,`ots`,`oqt`,`rowid`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SubscriptionDetail subscriptionDetail) {
                if (subscriptionDetail.getOrderId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, subscriptionDetail.getOrderId());
                }
                if (subscriptionDetail.getOrderToken() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, subscriptionDetail.getOrderToken());
                }
                if (subscriptionDetail.getProductSku() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, subscriptionDetail.getProductSku());
                }
                if (subscriptionDetail.getEncodedOrderTimestamp() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, subscriptionDetail.getEncodedOrderTimestamp());
                }
                if (subscriptionDetail.getEncodedRecentQueryTimestamp() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, subscriptionDetail.getEncodedRecentQueryTimestamp());
                }
                supportSQLiteStatement.bindLong(6, (long) subscriptionDetail.getStaticId());
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM SubscriptionDetail";
            }
        };
    }

    public void set(SubscriptionDetail subscriptionDetail) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSubscriptionDetail.insert(subscriptionDetail);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void clear() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClear.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClear.release(acquire);
        }
    }

    public SubscriptionDetail get() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SubscriptionDetail LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        SubscriptionDetail subscriptionDetail = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "oid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "otk");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "osk");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "ots");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "oqt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "rowid");
            if (query.moveToFirst()) {
                subscriptionDetail = new SubscriptionDetail(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6));
            }
            return subscriptionDetail;
        } finally {
            query.close();
            acquire.release();
        }
    }
}

package com.downloader.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class AppDbHelper implements DbHelper {
    public static final String TABLE_NAME = "prdownloader";

    /* renamed from: db */
    private final SQLiteDatabase f123db;

    public AppDbHelper(Context context) {
        this.f123db = new DatabaseOpenHelper(context).getWritableDatabase();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.downloader.database.DownloadModel} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0089, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x008a, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008c, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008d, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009f, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0089 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.downloader.database.DownloadModel find(int r6) {
        /*
            r5 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.f123db     // Catch:{ Exception -> 0x0098 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0098 }
            r2.<init>()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = "SELECT * FROM prdownloader WHERE id = "
            r2.append(r3)     // Catch:{ Exception -> 0x0098 }
            r2.append(r6)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0098 }
            android.database.Cursor r1 = r1.rawQuery(r2, r0)     // Catch:{ Exception -> 0x0098 }
            if (r1 == 0) goto L_0x0090
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            if (r2 == 0) goto L_0x0090
            com.downloader.database.DownloadModel r2 = new com.downloader.database.DownloadModel     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            r2.<init>()     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            r2.setId(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            java.lang.String r6 = "url"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            java.lang.String r6 = r1.getString(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            r2.setUrl(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            java.lang.String r6 = "etag"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            java.lang.String r6 = r1.getString(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            r2.setETag(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            java.lang.String r6 = "dir_path"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            java.lang.String r6 = r1.getString(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            r2.setDirPath(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            java.lang.String r6 = "file_name"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            java.lang.String r6 = r1.getString(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            r2.setFileName(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            java.lang.String r6 = "total_bytes"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            long r3 = r1.getLong(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            r2.setTotalBytes(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            java.lang.String r6 = "downloaded_bytes"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            long r3 = r1.getLong(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            r2.setDownloadedBytes(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            java.lang.String r6 = "last_modified_at"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            long r3 = r1.getLong(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            r2.setLastModifiedAt(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0089 }
            r0 = r2
            goto L_0x0090
        L_0x0087:
            r6 = move-exception
            goto L_0x008e
        L_0x0089:
            r6 = move-exception
            r0 = r1
            goto L_0x00a4
        L_0x008c:
            r6 = move-exception
            r2 = r0
        L_0x008e:
            r0 = r1
            goto L_0x009a
        L_0x0090:
            if (r1 == 0) goto L_0x00a3
            r1.close()
            goto L_0x00a3
        L_0x0096:
            r6 = move-exception
            goto L_0x00a4
        L_0x0098:
            r6 = move-exception
            r2 = r0
        L_0x009a:
            r6.printStackTrace()     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x00a2
            r0.close()
        L_0x00a2:
            r0 = r2
        L_0x00a3:
            return r0
        L_0x00a4:
            if (r0 == 0) goto L_0x00a9
            r0.close()
        L_0x00a9:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.downloader.database.AppDbHelper.find(int):com.downloader.database.DownloadModel");
    }

    public void insert(DownloadModel downloadModel) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(downloadModel.getId()));
            contentValues.put("url", downloadModel.getUrl());
            contentValues.put("etag", downloadModel.getETag());
            contentValues.put("dir_path", downloadModel.getDirPath());
            contentValues.put("file_name", downloadModel.getFileName());
            contentValues.put("total_bytes", Long.valueOf(downloadModel.getTotalBytes()));
            contentValues.put("downloaded_bytes", Long.valueOf(downloadModel.getDownloadedBytes()));
            contentValues.put("last_modified_at", Long.valueOf(downloadModel.getLastModifiedAt()));
            this.f123db.insert(TABLE_NAME, (String) null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(DownloadModel downloadModel) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("url", downloadModel.getUrl());
            contentValues.put("etag", downloadModel.getETag());
            contentValues.put("dir_path", downloadModel.getDirPath());
            contentValues.put("file_name", downloadModel.getFileName());
            contentValues.put("total_bytes", Long.valueOf(downloadModel.getTotalBytes()));
            contentValues.put("downloaded_bytes", Long.valueOf(downloadModel.getDownloadedBytes()));
            contentValues.put("last_modified_at", Long.valueOf(downloadModel.getLastModifiedAt()));
            this.f123db.update(TABLE_NAME, contentValues, "id = ? ", new String[]{String.valueOf(downloadModel.getId())});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProgress(int i, long j, long j2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("downloaded_bytes", Long.valueOf(j));
            contentValues.put("last_modified_at", Long.valueOf(j2));
            this.f123db.update(TABLE_NAME, contentValues, "id = ? ", new String[]{String.valueOf(i)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(int i) {
        try {
            SQLiteDatabase sQLiteDatabase = this.f123db;
            sQLiteDatabase.execSQL("DELETE FROM prdownloader WHERE id = " + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: type inference failed for: r7v4, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v6, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00b6, code lost:
        if (r7 == 0) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00b8, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00bb, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x00ad, code lost:
        if (r7 == 0) goto L_0x00bb;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.downloader.database.DownloadModel> getUnwantedModels(int r7) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r7 = r7 * 24
            int r7 = r7 * 60
            int r7 = r7 * 60
            long r1 = (long) r7
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            r7 = 0
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00b2 }
            long r3 = r3 - r1
            android.database.sqlite.SQLiteDatabase r1 = r6.f123db     // Catch:{ Exception -> 0x00b2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2 }
            r2.<init>()     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r5 = "SELECT * FROM prdownloader WHERE last_modified_at <= "
            r2.append(r5)     // Catch:{ Exception -> 0x00b2 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b2 }
            android.database.Cursor r7 = r1.rawQuery(r2, r7)     // Catch:{ Exception -> 0x00b2 }
            if (r7 == 0) goto L_0x00ad
            boolean r1 = r7.moveToFirst()     // Catch:{ Exception -> 0x00b2 }
            if (r1 == 0) goto L_0x00ad
        L_0x0035:
            com.downloader.database.DownloadModel r1 = new com.downloader.database.DownloadModel     // Catch:{ Exception -> 0x00b2 }
            r1.<init>()     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = "id"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x00b2 }
            int r2 = r7.getInt(r2)     // Catch:{ Exception -> 0x00b2 }
            r1.setId(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = "url"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x00b2 }
            r1.setUrl(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = "etag"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x00b2 }
            r1.setETag(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = "dir_path"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x00b2 }
            r1.setDirPath(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = "file_name"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x00b2 }
            r1.setFileName(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = "total_bytes"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x00b2 }
            long r2 = r7.getLong(r2)     // Catch:{ Exception -> 0x00b2 }
            r1.setTotalBytes(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = "downloaded_bytes"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x00b2 }
            long r2 = r7.getLong(r2)     // Catch:{ Exception -> 0x00b2 }
            r1.setDownloadedBytes(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = "last_modified_at"
            int r2 = r7.getColumnIndex(r2)     // Catch:{ Exception -> 0x00b2 }
            long r2 = r7.getLong(r2)     // Catch:{ Exception -> 0x00b2 }
            r1.setLastModifiedAt(r2)     // Catch:{ Exception -> 0x00b2 }
            r0.add(r1)     // Catch:{ Exception -> 0x00b2 }
            boolean r1 = r7.moveToNext()     // Catch:{ Exception -> 0x00b2 }
            if (r1 != 0) goto L_0x0035
        L_0x00ad:
            if (r7 == 0) goto L_0x00bb
            goto L_0x00b8
        L_0x00b0:
            r0 = move-exception
            goto L_0x00bc
        L_0x00b2:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x00b0 }
            if (r7 == 0) goto L_0x00bb
        L_0x00b8:
            r7.close()
        L_0x00bb:
            return r0
        L_0x00bc:
            if (r7 == 0) goto L_0x00c1
            r7.close()
        L_0x00c1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.downloader.database.AppDbHelper.getUnwantedModels(int):java.util.List");
    }

    public void clear() {
        try {
            this.f123db.delete(TABLE_NAME, (String) null, (String[]) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

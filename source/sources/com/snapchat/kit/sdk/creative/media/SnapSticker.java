package com.snapchat.kit.sdk.creative.media;

import android.content.Context;
import android.net.Uri;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class SnapSticker {

    /* renamed from: a */
    private final File f1286a;

    /* renamed from: b */
    private float f1287b = 0.0f;

    /* renamed from: c */
    private float f1288c = 0.5f;

    /* renamed from: d */
    private float f1289d = 0.5f;

    /* renamed from: e */
    private float f1290e = 0.0f;

    /* renamed from: f */
    private float f1291f = 0.0f;

    /* renamed from: g */
    private float f1292g = 0.0f;

    /* renamed from: h */
    private float f1293h = 0.0f;

    /* renamed from: i */
    private boolean f1294i;

    SnapSticker(File file) {
        this.f1286a = file;
    }

    public void setRotationDegreesClockwise(float f) {
        this.f1287b = f;
    }

    public void setPosX(float f) {
        this.f1288c = f;
    }

    public void setPosY(float f) {
        this.f1289d = f;
    }

    @Deprecated
    public void setWidth(float f) {
        this.f1290e = f;
    }

    @Deprecated
    public void setHeight(float f) {
        this.f1291f = f;
    }

    public void setWidthDp(float f) {
        this.f1292g = f;
    }

    public void setHeightDp(float f) {
        this.f1293h = f;
    }

    public JSONObject getJsonForm(Uri uri, Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ShareConstants.MEDIA_URI, uri);
            jSONObject.put("posX", (double) this.f1288c);
            jSONObject.put("posY", (double) this.f1289d);
            jSONObject.put("rotation", (double) this.f1287b);
            float f2 = this.f1292g;
            if (f2 != 0.0f) {
                jSONObject.put("widthDp", (double) f2);
                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, (double) (this.f1292g * f));
            } else {
                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, (double) this.f1290e);
            }
            float f3 = this.f1293h;
            if (f3 != 0.0f) {
                jSONObject.put("heightDp", (double) f3);
                jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, (double) (this.f1293h * f));
            } else {
                jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, (double) this.f1291f);
            }
            jSONObject.put("isAnimated", this.f1294i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public File getStickerFile() {
        return this.f1286a;
    }
}

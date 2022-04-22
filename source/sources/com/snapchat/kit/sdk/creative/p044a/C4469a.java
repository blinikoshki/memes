package com.snapchat.kit.sdk.creative.p044a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.snapchat.kit.sdk.creative.media.SnapSticker;
import com.snapchat.kit.sdk.creative.models.SnapContent;
import com.snapchat.kit.sdk.creative.models.SnapLensContent;
import com.snapchat.kit.sdk.util.SnapUtils;
import java.util.ArrayList;

/* renamed from: com.snapchat.kit.sdk.creative.a.a */
public final class C4469a {

    /* renamed from: a */
    private final SnapContent f1274a;

    /* renamed from: b */
    private final String f1275b;

    public C4469a(String str, SnapContent snapContent) {
        this.f1275b = str;
        this.f1274a = snapContent;
    }

    /* renamed from: a */
    public final Intent mo61743a(Context context) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setDataAndType(Uri.parse(String.format("snapchat://%s?link=%s", new Object[]{this.f1274a.getDeeplinkUrlPath(), this.f1275b})), this.f1274a.getIntentType());
        Uri fileProviderUri = SnapUtils.getFileProviderUri(context, this.f1274a.getMediaFile());
        SnapSticker snapSticker = this.f1274a.getSnapSticker();
        if (snapSticker != null) {
            Uri fileProviderUri2 = SnapUtils.getFileProviderUri(context, snapSticker.getStickerFile());
            intent.putExtra("sticker", snapSticker.getJsonForm(fileProviderUri2, context).toString());
            ArrayList arrayList = new ArrayList();
            if (fileProviderUri != null) {
                arrayList.add(fileProviderUri);
            }
            arrayList.add(fileProviderUri2);
            if (arrayList.size() > 1) {
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                intent.setAction("android.intent.action.SEND_MULTIPLE");
            } else if (!arrayList.isEmpty()) {
                intent.putExtra("android.intent.extra.STREAM", (Parcelable) arrayList.get(0));
            }
        } else if (fileProviderUri != null) {
            intent.putExtra("android.intent.extra.STREAM", fileProviderUri);
        }
        String attachmentUrl = this.f1274a.getAttachmentUrl();
        if (!TextUtils.isEmpty(attachmentUrl)) {
            intent.putExtra("attachmentUrl", attachmentUrl);
        }
        String captionText = this.f1274a.getCaptionText();
        if (!TextUtils.isEmpty(captionText)) {
            intent.putExtra("captionText", captionText);
        }
        SnapContent snapContent = this.f1274a;
        if (snapContent instanceof SnapLensContent) {
            SnapLensContent snapLensContent = (SnapLensContent) snapContent;
            String lensId = snapLensContent.getLensId();
            if (!TextUtils.isEmpty(lensId)) {
                intent.putExtra("lensId", lensId);
                String snapLensLaunchDataString = snapLensContent.getSnapLensLaunchDataString();
                if (!TextUtils.isEmpty(snapLensLaunchDataString)) {
                    intent.putExtra("lensLaunchData", snapLensLaunchDataString);
                }
            }
        }
        return intent;
    }
}

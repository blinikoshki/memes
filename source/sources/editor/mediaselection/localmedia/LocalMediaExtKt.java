package editor.mediaselection.localmedia;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, mo26107d2 = {"toIdBasedMedia", "Leditor/mediaselection/localmedia/IdBasedMedia;", "Leditor/mediaselection/localmedia/LocalMedia;", "editor_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: LocalMediaExt.kt */
public final class LocalMediaExtKt {
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        if ((r9.getMediaTye() == 3) != false) goto L_0x0031;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final editor.mediaselection.localmedia.IdBasedMedia toIdBasedMedia(editor.mediaselection.localmedia.LocalMedia r9) {
        /*
            java.lang.String r0 = "$this$toIdBasedMedia"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r9.isPhoto()
            r1 = 1232(0x4d0, float:1.726E-42)
            r2 = 1231(0x4cf, float:1.725E-42)
            if (r0 != 0) goto L_0x0022
            boolean r0 = r9.isVideo()
            if (r0 != 0) goto L_0x0022
            int r0 = r9.getMediaTye()
            r3 = 3
            if (r0 != r3) goto L_0x001e
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            if (r0 == 0) goto L_0x0028
            goto L_0x0031
        L_0x0022:
            boolean r0 = r9.isPhoto()
            if (r0 == 0) goto L_0x002b
        L_0x0028:
            r3 = 1231(0x4cf, float:1.725E-42)
            goto L_0x0033
        L_0x002b:
            boolean r0 = r9.isVideo()
            if (r0 == 0) goto L_0x006e
        L_0x0031:
            r3 = 1232(0x4d0, float:1.726E-42)
        L_0x0033:
            java.lang.String r4 = r9.getSource()
            int r0 = r9.getWidth()
            if (r0 <= 0) goto L_0x0059
            int r0 = r9.getHeight()
            if (r0 <= 0) goto L_0x0059
            com.memes.commons.media.MediaContent r0 = new com.memes.commons.media.MediaContent
            int r1 = r9.getWidth()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r2 = r9.getHeight()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.<init>(r3, r4, r1, r2)
            goto L_0x0064
        L_0x0059:
            com.memes.commons.media.MediaContent r0 = new com.memes.commons.media.MediaContent
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
        L_0x0064:
            editor.mediaselection.localmedia.IdBasedMedia r1 = new editor.mediaselection.localmedia.IdBasedMedia
            java.lang.String r9 = r9.getIdentifier()
            r1.<init>(r9, r0)
            return r1
        L_0x006e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected local-media-content: "
            r1.append(r2)
            int r2 = r9.getMediaTye()
            r1.append(r2)
            r2 = 32
            r1.append(r2)
            int r3 = r9.getMimeType()
            r1.append(r3)
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.localmedia.LocalMediaExtKt.toIdBasedMedia(editor.mediaselection.localmedia.LocalMedia):editor.mediaselection.localmedia.IdBasedMedia");
    }
}

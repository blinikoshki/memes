package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.Locale;

public class ImageRequest {
    private static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String HEIGHT_PARAM = "height";
    private static final String MIGRATION_PARAM = "migration_overrides";
    private static final String MIGRATION_VALUE = "{october_2012:true}";
    private static final String PATH = "%s/%s/picture";
    public static final int UNSPECIFIED_DIMENSION = 0;
    private static final String WIDTH_PARAM = "width";
    private boolean allowCachedRedirects;
    private Callback callback;
    private Object callerTag;
    private Context context;
    private Uri imageUri;

    public interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    public static Uri getProfilePictureUri(String str, int i, int i2) {
        return getProfilePictureUri(str, i, i2, "");
    }

    public static Uri getProfilePictureUri(String str, int i, int i2, String str2) {
        Validate.notNullOrEmpty(str, TagPeopleActivity.USER_ID);
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (max == 0 && max2 == 0) {
            throw new IllegalArgumentException("Either width or height must be greater than 0");
        }
        Uri.Builder path = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon().path(String.format(Locale.US, PATH, new Object[]{FacebookSdk.getGraphApiVersion(), str}));
        if (max2 != 0) {
            path.appendQueryParameter("height", String.valueOf(max2));
        }
        if (max != 0) {
            path.appendQueryParameter("width", String.valueOf(max));
        }
        path.appendQueryParameter(MIGRATION_PARAM, MIGRATION_VALUE);
        if (!Utility.isNullOrEmpty(str2)) {
            path.appendQueryParameter("access_token", str2);
        } else if (Utility.isNullOrEmpty(FacebookSdk.getClientToken()) || Utility.isNullOrEmpty(FacebookSdk.getApplicationId())) {
            Log.d("ImageRequest", "Needs access token to fetch profile picture. Without an access token a default silhoutte picture is returned");
        } else {
            path.appendQueryParameter("access_token", FacebookSdk.getApplicationId() + "|" + FacebookSdk.getClientToken());
        }
        return path.build();
    }

    private ImageRequest(Builder builder) {
        this.context = builder.context;
        this.imageUri = builder.imageUrl;
        this.callback = builder.callback;
        this.allowCachedRedirects = builder.allowCachedRedirects;
        this.callerTag = builder.callerTag == null ? new Object() : builder.callerTag;
    }

    public Context getContext() {
        return this.context;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public Callback getCallback() {
        return this.callback;
    }

    public boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }

    public Object getCallerTag() {
        return this.callerTag;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean allowCachedRedirects;
        /* access modifiers changed from: private */
        public Callback callback;
        /* access modifiers changed from: private */
        public Object callerTag;
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public Uri imageUrl;

        public Builder(Context context2, Uri uri) {
            Validate.notNull(uri, "imageUri");
            this.context = context2;
            this.imageUrl = uri;
        }

        public Builder setCallback(Callback callback2) {
            this.callback = callback2;
            return this;
        }

        public Builder setCallerTag(Object obj) {
            this.callerTag = obj;
            return this;
        }

        public Builder setAllowCachedRedirects(boolean z) {
            this.allowCachedRedirects = z;
            return this;
        }

        public ImageRequest build() {
            return new ImageRequest(this);
        }
    }
}

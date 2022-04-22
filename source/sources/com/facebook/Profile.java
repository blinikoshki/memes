package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        public Profile createFromParcel(Parcel parcel) {
            return new Profile(parcel);
        }

        public Profile[] newArray(int i) {
            return new Profile[i];
        }
    };
    private static final String FIRST_NAME_KEY = "first_name";
    private static final String ID_KEY = "id";
    private static final String LAST_NAME_KEY = "last_name";
    private static final String LINK_URI_KEY = "link_uri";
    private static final String MIDDLE_NAME_KEY = "middle_name";
    private static final String NAME_KEY = "name";
    /* access modifiers changed from: private */
    public static final String TAG = "Profile";
    private final String firstName;

    /* renamed from: id */
    private final String f129id;
    private final String lastName;
    private final Uri linkUri;
    private final String middleName;
    private final String name;

    public int describeContents() {
        return 0;
    }

    public static Profile getCurrentProfile() {
        return ProfileManager.getInstance().getCurrentProfile();
    }

    public static void setCurrentProfile(Profile profile) {
        ProfileManager.getInstance().setCurrentProfile(profile);
    }

    public static void fetchProfileForCurrentAccessToken() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (!AccessToken.isCurrentAccessTokenActive()) {
            setCurrentProfile((Profile) null);
        } else {
            Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new Utility.GraphMeRequestWithCacheCallback() {
                public void onSuccess(JSONObject jSONObject) {
                    String optString = jSONObject.optString("id");
                    if (optString != null) {
                        String optString2 = jSONObject.optString("link");
                        Profile.setCurrentProfile(new Profile(optString, jSONObject.optString(Profile.FIRST_NAME_KEY), jSONObject.optString(Profile.MIDDLE_NAME_KEY), jSONObject.optString(Profile.LAST_NAME_KEY), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
                    }
                }

                public void onFailure(FacebookException facebookException) {
                    String access$000 = Profile.TAG;
                    Log.e(access$000, "Got unexpected exception: " + facebookException);
                }
            });
        }
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        Validate.notNullOrEmpty(str, "id");
        this.f129id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
    }

    public Uri getProfilePictureUri(int i, int i2) {
        return ImageRequest.getProfilePictureUri(this.f129id, i, i2, AccessToken.isCurrentAccessTokenActive() ? AccessToken.getCurrentAccessToken().getToken() : "");
    }

    public String getId() {
        return this.f129id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.name;
    }

    public Uri getLinkUri() {
        return this.linkUri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        String str = this.f129id;
        if (str != null ? str.equals(profile.f129id) : profile.f129id == null) {
            String str2 = this.firstName;
            if (str2 != null ? str2.equals(profile.firstName) : profile.firstName == null) {
                String str3 = this.middleName;
                if (str3 != null ? str3.equals(profile.middleName) : profile.middleName == null) {
                    String str4 = this.lastName;
                    if (str4 != null ? str4.equals(profile.lastName) : profile.lastName == null) {
                        String str5 = this.name;
                        if (str5 != null ? str5.equals(profile.name) : profile.name == null) {
                            Uri uri = this.linkUri;
                            Uri uri2 = profile.linkUri;
                            if (uri == null) {
                                if (uri2 == null) {
                                    return true;
                                }
                            } else if (uri.equals(uri2)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = 527 + this.f129id.hashCode();
        String str = this.firstName;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        String str2 = this.middleName;
        if (str2 != null) {
            hashCode = (hashCode * 31) + str2.hashCode();
        }
        String str3 = this.lastName;
        if (str3 != null) {
            hashCode = (hashCode * 31) + str3.hashCode();
        }
        String str4 = this.name;
        if (str4 != null) {
            hashCode = (hashCode * 31) + str4.hashCode();
        }
        Uri uri = this.linkUri;
        return uri != null ? (hashCode * 31) + uri.hashCode() : hashCode;
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f129id);
            jSONObject.put(FIRST_NAME_KEY, this.firstName);
            jSONObject.put(MIDDLE_NAME_KEY, this.middleName);
            jSONObject.put(LAST_NAME_KEY, this.lastName);
            jSONObject.put("name", this.name);
            Uri uri = this.linkUri;
            if (uri == null) {
                return jSONObject;
            }
            jSONObject.put(LINK_URI_KEY, uri.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    Profile(JSONObject jSONObject) {
        Uri uri = null;
        this.f129id = jSONObject.optString("id", (String) null);
        this.firstName = jSONObject.optString(FIRST_NAME_KEY, (String) null);
        this.middleName = jSONObject.optString(MIDDLE_NAME_KEY, (String) null);
        this.lastName = jSONObject.optString(LAST_NAME_KEY, (String) null);
        this.name = jSONObject.optString("name", (String) null);
        String optString = jSONObject.optString(LINK_URI_KEY, (String) null);
        this.linkUri = optString != null ? Uri.parse(optString) : uri;
    }

    private Profile(Parcel parcel) {
        Uri uri;
        this.f129id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String readString = parcel.readString();
        if (readString == null) {
            uri = null;
        } else {
            uri = Uri.parse(readString);
        }
        this.linkUri = uri;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f129id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.name);
        Uri uri = this.linkUri;
        parcel.writeString(uri == null ? null : uri.toString());
    }
}

package p015io.noties.markwon;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

/* renamed from: io.noties.markwon.LinkResolverDef */
public class LinkResolverDef implements LinkResolver {
    private static final String DEFAULT_SCHEME = "https";

    public void resolve(View view, String str) {
        Uri parseLink = parseLink(str);
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW", parseLink);
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Log.w("LinkResolverDef", "Actvity was not found for the link: '" + str + "'");
        }
    }

    private static Uri parseLink(String str) {
        Uri parse = Uri.parse(str);
        return TextUtils.isEmpty(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : parse;
    }
}

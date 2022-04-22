package com.facebook.appevents.aam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class MetadataRule {
    private static final String FIELD_K = "k";
    private static final String FIELD_K_DELIMITER = ",";
    private static final String FIELD_V = "v";
    private static final String TAG = "com.facebook.appevents.aam.MetadataRule";
    private static final Set<MetadataRule> rules = new HashSet();
    private List<String> keyRules;
    private String name;
    private String valRule;

    private MetadataRule(String str, List<String> list, String str2) {
        this.name = str;
        this.keyRules = list;
        this.valRule = str2;
    }

    static Set<MetadataRule> getRules() {
        return new HashSet(rules);
    }

    /* access modifiers changed from: package-private */
    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    public List<String> getKeyRules() {
        return new ArrayList(this.keyRules);
    }

    /* access modifiers changed from: package-private */
    public String getValRule() {
        return this.valRule;
    }

    static void updateRules(String str) {
        try {
            rules.clear();
            constructRules(new JSONObject(str));
        } catch (JSONException unused) {
        }
    }

    private static void constructRules(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(FIELD_K);
                String optString2 = optJSONObject.optString("v");
                if (!optString.isEmpty()) {
                    rules.add(new MetadataRule(next, Arrays.asList(optString.split(",")), optString2));
                }
            }
        }
    }

    public static Set<String> getEnabledRuleNames() {
        HashSet hashSet = new HashSet();
        for (MetadataRule name2 : rules) {
            hashSet.add(name2.getName());
        }
        return hashSet;
    }
}

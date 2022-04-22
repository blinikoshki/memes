package com.snapchat.kit.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import javax.inject.Inject;

public class SnapKitActivity extends Activity {
    @Inject

    /* renamed from: a */
    C4475d f1055a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        SnapKitComponent component = SnapKit.getComponent(this);
        if (component == null) {
            finish();
            return;
        }
        component.inject(this);
        if (this.f1055a.mo61788a(intent)) {
            this.f1055a.mo61786a(intent.getData());
        }
        finish();
    }
}

package com.memes.commons.activity;

import com.kaopiz.kprogresshud.KProgressHUD;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BaseActivity.kt */
final /* synthetic */ class BaseActivity$showBlockingProgressDialog$1 extends MutablePropertyReference0Impl {
    BaseActivity$showBlockingProgressDialog$1(BaseActivity baseActivity) {
        super(baseActivity, BaseActivity.class, "blockingProgressDialog", "getBlockingProgressDialog()Lcom/kaopiz/kprogresshud/KProgressHUD;", 0);
    }

    public Object get() {
        return BaseActivity.access$getBlockingProgressDialog$p((BaseActivity) this.receiver);
    }

    public void set(Object obj) {
        ((BaseActivity) this.receiver).blockingProgressDialog = (KProgressHUD) obj;
    }
}

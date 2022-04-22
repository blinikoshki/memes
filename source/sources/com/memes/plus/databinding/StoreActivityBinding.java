package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.tabs.TabLayout;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

public final class StoreActivityBinding implements ViewBinding {
    public final LinearLayout containerTop;
    public final LinearLayout continuePurchaseLayout;
    public final ImageView crownImageView;
    public final TextView goProTextView;
    public final Guideline guidelineHorizontal18;
    public final Guideline guidelineHorizontal60;
    public final Guideline guidelineVertical15;
    public final Guideline guidelineVertical85;
    public final TextView monthlyPriceTextView;
    public final LinearLayout monthlySubscriptionLayout;
    public final TextView offerDealTextView;
    public final TextView privacyPolicyTextView;
    public final DiscreteScrollView promoScrollView;
    public final TextView promoTextView;
    public final RadioButton radioButtonForMonthlySubscription;
    public final RadioButton radioButtonForYearlySubscription;
    public final TextView restorePurchaseTextView;
    private final LinearLayout rootView;
    public final TabLayout scrollerTabLayout;
    public final ContentLayout storeInfoContentLayout;
    public final TextView termsUseTextView;
    public final TextView trialDaysTextView;
    public final TextView tryForFreeButton;
    public final TextView yearlyPriceTextView;
    public final LinearLayout yearlySubscriptionLayout;

    private StoreActivityBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView, TextView textView, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, TextView textView2, LinearLayout linearLayout4, TextView textView3, TextView textView4, DiscreteScrollView discreteScrollView, TextView textView5, RadioButton radioButton, RadioButton radioButton2, TextView textView6, TabLayout tabLayout, ContentLayout contentLayout, TextView textView7, TextView textView8, TextView textView9, TextView textView10, LinearLayout linearLayout5) {
        this.rootView = linearLayout;
        this.containerTop = linearLayout2;
        this.continuePurchaseLayout = linearLayout3;
        this.crownImageView = imageView;
        this.goProTextView = textView;
        this.guidelineHorizontal18 = guideline;
        this.guidelineHorizontal60 = guideline2;
        this.guidelineVertical15 = guideline3;
        this.guidelineVertical85 = guideline4;
        this.monthlyPriceTextView = textView2;
        this.monthlySubscriptionLayout = linearLayout4;
        this.offerDealTextView = textView3;
        this.privacyPolicyTextView = textView4;
        this.promoScrollView = discreteScrollView;
        this.promoTextView = textView5;
        this.radioButtonForMonthlySubscription = radioButton;
        this.radioButtonForYearlySubscription = radioButton2;
        this.restorePurchaseTextView = textView6;
        this.scrollerTabLayout = tabLayout;
        this.storeInfoContentLayout = contentLayout;
        this.termsUseTextView = textView7;
        this.trialDaysTextView = textView8;
        this.tryForFreeButton = textView9;
        this.yearlyPriceTextView = textView10;
        this.yearlySubscriptionLayout = linearLayout5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StoreActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StoreActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.store_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StoreActivityBinding bind(View view) {
        View view2 = view;
        int i = C4199R.C4203id.container_top;
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(C4199R.C4203id.container_top);
        if (linearLayout != null) {
            i = C4199R.C4203id.continue_purchase_layout;
            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C4199R.C4203id.continue_purchase_layout);
            if (linearLayout2 != null) {
                i = C4199R.C4203id.crown_image_view;
                ImageView imageView = (ImageView) view2.findViewById(C4199R.C4203id.crown_image_view);
                if (imageView != null) {
                    i = C4199R.C4203id.go_pro_text_view;
                    TextView textView = (TextView) view2.findViewById(C4199R.C4203id.go_pro_text_view);
                    if (textView != null) {
                        i = C4199R.C4203id.guideline_horizontal_18;
                        Guideline guideline = (Guideline) view2.findViewById(C4199R.C4203id.guideline_horizontal_18);
                        if (guideline != null) {
                            i = C4199R.C4203id.guideline_horizontal_60;
                            Guideline guideline2 = (Guideline) view2.findViewById(C4199R.C4203id.guideline_horizontal_60);
                            if (guideline2 != null) {
                                i = C4199R.C4203id.guideline_vertical_15;
                                Guideline guideline3 = (Guideline) view2.findViewById(C4199R.C4203id.guideline_vertical_15);
                                if (guideline3 != null) {
                                    i = C4199R.C4203id.guideline_vertical_85;
                                    Guideline guideline4 = (Guideline) view2.findViewById(C4199R.C4203id.guideline_vertical_85);
                                    if (guideline4 != null) {
                                        i = C4199R.C4203id.monthly_price_text_view;
                                        TextView textView2 = (TextView) view2.findViewById(C4199R.C4203id.monthly_price_text_view);
                                        if (textView2 != null) {
                                            i = C4199R.C4203id.monthly_subscription_layout;
                                            LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(C4199R.C4203id.monthly_subscription_layout);
                                            if (linearLayout3 != null) {
                                                i = C4199R.C4203id.offer_deal_text_view;
                                                TextView textView3 = (TextView) view2.findViewById(C4199R.C4203id.offer_deal_text_view);
                                                if (textView3 != null) {
                                                    i = C4199R.C4203id.privacy_policy__text_view;
                                                    TextView textView4 = (TextView) view2.findViewById(C4199R.C4203id.privacy_policy__text_view);
                                                    if (textView4 != null) {
                                                        i = C4199R.C4203id.promo_scroll_view;
                                                        DiscreteScrollView discreteScrollView = (DiscreteScrollView) view2.findViewById(C4199R.C4203id.promo_scroll_view);
                                                        if (discreteScrollView != null) {
                                                            i = C4199R.C4203id.promo_text_view;
                                                            TextView textView5 = (TextView) view2.findViewById(C4199R.C4203id.promo_text_view);
                                                            if (textView5 != null) {
                                                                i = C4199R.C4203id.radio_button_for_monthly_subscription;
                                                                RadioButton radioButton = (RadioButton) view2.findViewById(C4199R.C4203id.radio_button_for_monthly_subscription);
                                                                if (radioButton != null) {
                                                                    i = C4199R.C4203id.radio_button_for_yearly_subscription;
                                                                    RadioButton radioButton2 = (RadioButton) view2.findViewById(C4199R.C4203id.radio_button_for_yearly_subscription);
                                                                    if (radioButton2 != null) {
                                                                        i = C4199R.C4203id.restore_purchase__text_view;
                                                                        TextView textView6 = (TextView) view2.findViewById(C4199R.C4203id.restore_purchase__text_view);
                                                                        if (textView6 != null) {
                                                                            i = C4199R.C4203id.scroller_tab_layout;
                                                                            TabLayout tabLayout = (TabLayout) view2.findViewById(C4199R.C4203id.scroller_tab_layout);
                                                                            if (tabLayout != null) {
                                                                                i = C4199R.C4203id.store_info_content_layout;
                                                                                ContentLayout contentLayout = (ContentLayout) view2.findViewById(C4199R.C4203id.store_info_content_layout);
                                                                                if (contentLayout != null) {
                                                                                    i = C4199R.C4203id.terms_use_text_view;
                                                                                    TextView textView7 = (TextView) view2.findViewById(C4199R.C4203id.terms_use_text_view);
                                                                                    if (textView7 != null) {
                                                                                        i = C4199R.C4203id.trial_days_text_view;
                                                                                        TextView textView8 = (TextView) view2.findViewById(C4199R.C4203id.trial_days_text_view);
                                                                                        if (textView8 != null) {
                                                                                            i = C4199R.C4203id.try_for_free_button;
                                                                                            TextView textView9 = (TextView) view2.findViewById(C4199R.C4203id.try_for_free_button);
                                                                                            if (textView9 != null) {
                                                                                                i = C4199R.C4203id.yearly_price_text_view;
                                                                                                TextView textView10 = (TextView) view2.findViewById(C4199R.C4203id.yearly_price_text_view);
                                                                                                if (textView10 != null) {
                                                                                                    i = C4199R.C4203id.yearly_subscription_layout;
                                                                                                    LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(C4199R.C4203id.yearly_subscription_layout);
                                                                                                    if (linearLayout4 != null) {
                                                                                                        return new StoreActivityBinding((LinearLayout) view2, linearLayout, linearLayout2, imageView, textView, guideline, guideline2, guideline3, guideline4, textView2, linearLayout3, textView3, textView4, discreteScrollView, textView5, radioButton, radioButton2, textView6, tabLayout, contentLayout, textView7, textView8, textView9, textView10, linearLayout4);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

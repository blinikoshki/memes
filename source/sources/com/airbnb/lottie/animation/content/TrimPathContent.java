package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {
    private final BaseKeyframeAnimation<?, Float> endAnimation;
    private final List<BaseKeyframeAnimation.AnimationListener> listeners = new ArrayList();
    private final String name;
    private final BaseKeyframeAnimation<?, Float> offsetAnimation;
    private final BaseKeyframeAnimation<?, Float> startAnimation;
    private final ShapeTrimPath.Type type;

    public void setContents(List<Content> list, List<Content> list2) {
    }

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.type = shapeTrimPath.getType();
        BaseKeyframeAnimation<Float, Float> createAnimation = shapeTrimPath.getStart().createAnimation();
        this.startAnimation = createAnimation;
        BaseKeyframeAnimation<Float, Float> createAnimation2 = shapeTrimPath.getEnd().createAnimation();
        this.endAnimation = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = shapeTrimPath.getOffset().createAnimation();
        this.offsetAnimation = createAnimation3;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
    }

    public void onValueChanged() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onValueChanged();
        }
    }

    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.listeners.add(animationListener);
    }

    /* access modifiers changed from: package-private */
    public ShapeTrimPath.Type getType() {
        return this.type;
    }

    public BaseKeyframeAnimation<?, Float> getStart() {
        return this.startAnimation;
    }

    public BaseKeyframeAnimation<?, Float> getEnd() {
        return this.endAnimation;
    }

    public BaseKeyframeAnimation<?, Float> getOffset() {
        return this.offsetAnimation;
    }
}

package com.airbnb.lottie.utils;

public class MeanCalculator {

    /* renamed from: n */
    private int f94n;
    private float sum;

    public void add(float f) {
        float f2 = this.sum + f;
        this.sum = f2;
        int i = this.f94n + 1;
        this.f94n = i;
        if (i == Integer.MAX_VALUE) {
            this.sum = f2 / 2.0f;
            this.f94n = i / 2;
        }
    }

    public float getMean() {
        int i = this.f94n;
        if (i == 0) {
            return 0.0f;
        }
        return this.sum / ((float) i);
    }
}

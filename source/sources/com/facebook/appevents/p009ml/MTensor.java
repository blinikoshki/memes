package com.facebook.appevents.p009ml;

/* renamed from: com.facebook.appevents.ml.MTensor */
public class MTensor {
    private int capacity;
    private float[] data;
    private int[] shape;

    public MTensor(int[] iArr) {
        this.shape = iArr;
        int capacity2 = getCapacity(iArr);
        this.capacity = capacity2;
        this.data = new float[capacity2];
    }

    public float[] getData() {
        return this.data;
    }

    public int getShape(int i) {
        return this.shape[i];
    }

    public void reshape(int[] iArr) {
        this.shape = iArr;
        int capacity2 = getCapacity(iArr);
        float[] fArr = new float[capacity2];
        System.arraycopy(this.data, 0, fArr, 0, Math.min(this.capacity, capacity2));
        this.data = fArr;
        this.capacity = capacity2;
    }

    public int getShapeSize() {
        return this.shape.length;
    }

    private static int getCapacity(int[] iArr) {
        int i = 1;
        for (int i2 : iArr) {
            i *= i2;
        }
        return i;
    }
}

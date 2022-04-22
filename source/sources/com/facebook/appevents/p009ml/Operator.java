package com.facebook.appevents.p009ml;

/* renamed from: com.facebook.appevents.ml.Operator */
final class Operator {
    Operator() {
    }

    static void addmv(MTensor mTensor, MTensor mTensor2) {
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        int shape3 = mTensor.getShape(2);
        float[] data = mTensor.getData();
        float[] data2 = mTensor2.getData();
        for (int i = 0; i < shape; i++) {
            for (int i2 = 0; i2 < shape2; i2++) {
                for (int i3 = 0; i3 < shape3; i3++) {
                    int i4 = (i * shape2 * shape3) + (i2 * shape3) + i3;
                    data[i4] = data[i4] + data2[i3];
                }
            }
        }
    }

    static MTensor mul(MTensor mTensor, MTensor mTensor2) {
        int shape = mTensor.getShape(0);
        int shape2 = mTensor2.getShape(0);
        int shape3 = mTensor2.getShape(1);
        MTensor mTensor3 = new MTensor(new int[]{shape, shape3});
        float[] data = mTensor.getData();
        float[] data2 = mTensor2.getData();
        float[] data3 = mTensor3.getData();
        for (int i = 0; i < shape; i++) {
            for (int i2 = 0; i2 < shape3; i2++) {
                int i3 = (i * shape3) + i2;
                data3[i3] = 0.0f;
                for (int i4 = 0; i4 < shape2; i4++) {
                    data3[i3] = data3[i3] + (data[(i * shape2) + i4] * data2[(i4 * shape3) + i2]);
                }
            }
        }
        return mTensor3;
    }

    static void relu(MTensor mTensor) {
        float[] data = mTensor.getData();
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0.0f) {
                data[i] = 0.0f;
            }
        }
    }

    static void flatten(MTensor mTensor, int i) {
        if (i < mTensor.getShapeSize()) {
            int i2 = 1;
            for (int i3 = i; i3 < mTensor.getShapeSize(); i3++) {
                i2 *= mTensor.getShape(i3);
            }
            int[] iArr = new int[(i + 1)];
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = mTensor.getShape(i4);
            }
            iArr[i] = i2;
            mTensor.reshape(iArr);
        }
    }

    static MTensor concatenate(MTensor[] mTensorArr) {
        int shape = mTensorArr[0].getShape(0);
        int i = 0;
        for (MTensor shape2 : mTensorArr) {
            i += shape2.getShape(1);
        }
        MTensor mTensor = new MTensor(new int[]{shape, i});
        float[] data = mTensor.getData();
        for (int i2 = 0; i2 < shape; i2++) {
            int i3 = i2 * i;
            for (int i4 = 0; i4 < mTensorArr.length; i4++) {
                float[] data2 = mTensorArr[i4].getData();
                int shape3 = mTensorArr[i4].getShape(1);
                System.arraycopy(data2, i2 * shape3, data, i3, shape3);
                i3 += shape3;
            }
        }
        return mTensor;
    }

    static void softmax(MTensor mTensor) {
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        float[] data = mTensor.getData();
        for (int i = 0; i < shape; i++) {
            int i2 = i * shape2;
            int i3 = i2 + shape2;
            float f = Float.MIN_VALUE;
            float f2 = 0.0f;
            for (int i4 = i2; i4 < i3; i4++) {
                if (data[i4] > f) {
                    f = data[i4];
                }
            }
            for (int i5 = i2; i5 < i3; i5++) {
                data[i5] = (float) Math.exp((double) (data[i5] - f));
            }
            for (int i6 = i2; i6 < i3; i6++) {
                f2 += data[i6];
            }
            while (i2 < i3) {
                data[i2] = data[i2] / f2;
                i2++;
            }
        }
    }

    static MTensor dense(MTensor mTensor, MTensor mTensor2, MTensor mTensor3) {
        int shape = mTensor.getShape(0);
        int shape2 = mTensor3.getShape(0);
        MTensor mul = mul(mTensor, mTensor2);
        float[] data = mTensor3.getData();
        float[] data2 = mul.getData();
        for (int i = 0; i < shape; i++) {
            for (int i2 = 0; i2 < shape2; i2++) {
                int i3 = (i * shape2) + i2;
                data2[i3] = data2[i3] + data[i2];
            }
        }
        return mul;
    }

    static MTensor embedding(String[] strArr, int i, MTensor mTensor) {
        int length = strArr.length;
        int shape = mTensor.getShape(1);
        MTensor mTensor2 = new MTensor(new int[]{length, i, shape});
        float[] data = mTensor2.getData();
        float[] data2 = mTensor.getData();
        for (int i2 = 0; i2 < length; i2++) {
            int[] vectorize = Utils.vectorize(strArr[i2], i);
            for (int i3 = 0; i3 < i; i3++) {
                System.arraycopy(data2, vectorize[i3] * shape, data, (shape * i * i2) + (shape * i3), shape);
            }
        }
        return mTensor2;
    }

    static MTensor transpose2D(MTensor mTensor) {
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        MTensor mTensor2 = new MTensor(new int[]{shape2, shape});
        float[] data = mTensor.getData();
        float[] data2 = mTensor2.getData();
        for (int i = 0; i < shape; i++) {
            for (int i2 = 0; i2 < shape2; i2++) {
                data2[(i2 * shape) + i] = data[(i * shape2) + i2];
            }
        }
        return mTensor2;
    }

    static MTensor transpose3D(MTensor mTensor) {
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        int shape3 = mTensor.getShape(2);
        MTensor mTensor2 = new MTensor(new int[]{shape3, shape2, shape});
        float[] data = mTensor.getData();
        float[] data2 = mTensor2.getData();
        for (int i = 0; i < shape; i++) {
            for (int i2 = 0; i2 < shape2; i2++) {
                for (int i3 = 0; i3 < shape3; i3++) {
                    data2[(i3 * shape * shape2) + (i2 * shape) + i] = data[(i * shape2 * shape3) + (i2 * shape3) + i3];
                }
            }
        }
        return mTensor2;
    }

    static MTensor conv1D(MTensor mTensor, MTensor mTensor2) {
        MTensor mTensor3 = mTensor;
        MTensor mTensor4 = mTensor2;
        int i = 0;
        int shape = mTensor3.getShape(0);
        int shape2 = mTensor3.getShape(1);
        int shape3 = mTensor3.getShape(2);
        int shape4 = mTensor4.getShape(0);
        int i2 = (shape2 - shape4) + 1;
        int shape5 = mTensor4.getShape(2);
        MTensor mTensor5 = new MTensor(new int[]{shape, i2, shape5});
        float[] data = mTensor.getData();
        float[] data2 = mTensor5.getData();
        float[] data3 = mTensor2.getData();
        int i3 = 0;
        while (i3 < shape) {
            int i4 = 0;
            while (i4 < shape5) {
                int i5 = 0;
                while (i5 < i2) {
                    float f = 0.0f;
                    int i6 = 0;
                    while (i6 < shape4) {
                        while (i < shape3) {
                            f += data[(shape2 * shape3 * i3) + ((i6 + i5) * shape3) + i] * data3[(((i6 * shape3) + i) * shape5) + i4];
                            i++;
                        }
                        i6++;
                        i = 0;
                    }
                    data2[(i2 * shape5 * i3) + (i5 * shape5) + i4] = f;
                    i5++;
                    i = 0;
                }
                i4++;
                i = 0;
            }
            i3++;
            i = 0;
        }
        return mTensor5;
    }

    static MTensor maxPool1D(MTensor mTensor, int i) {
        MTensor mTensor2 = mTensor;
        int i2 = i;
        int shape = mTensor2.getShape(0);
        int shape2 = mTensor2.getShape(1);
        int shape3 = mTensor2.getShape(2);
        int i3 = (shape2 - i2) + 1;
        MTensor mTensor3 = new MTensor(new int[]{shape, i3, shape3});
        float[] data = mTensor.getData();
        float[] data2 = mTensor3.getData();
        for (int i4 = 0; i4 < shape; i4++) {
            for (int i5 = 0; i5 < shape3; i5++) {
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = i6 * shape3;
                    int i8 = (i4 * i3 * shape3) + i7 + i5;
                    int i9 = (i4 * shape2 * shape3) + i7 + i5;
                    data2[i8] = Float.MIN_VALUE;
                    for (int i10 = 0; i10 < i2; i10++) {
                        data2[i8] = Math.max(data2[i8], data[i9 + (i10 * shape3)]);
                    }
                }
            }
        }
        return mTensor3;
    }
}

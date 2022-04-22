package editor.signature.utils;

public class Bezier {
    public TimedPoint control1;
    public TimedPoint control2;
    public TimedPoint endPoint;
    public TimedPoint startPoint;

    public double point(float f, float f2, float f3, float f4, float f5) {
        double d = (double) f;
        double d2 = 1.0d - d;
        return (((double) f2) * d2 * d2 * d2) + (((double) f3) * 3.0d * d2 * d2 * d) + (((double) f4) * 3.0d * d2 * d * d) + ((double) (f5 * f * f * f));
    }

    public Bezier set(TimedPoint timedPoint, TimedPoint timedPoint2, TimedPoint timedPoint3, TimedPoint timedPoint4) {
        this.startPoint = timedPoint;
        this.control1 = timedPoint2;
        this.control2 = timedPoint3;
        this.endPoint = timedPoint4;
        return this;
    }

    public float length() {
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        int i = 0;
        while (i <= 10) {
            float f2 = ((float) i) / ((float) 10);
            double point = point(f2, this.startPoint.f1440x, this.control1.f1440x, this.control2.f1440x, this.endPoint.f1440x);
            double point2 = point(f2, this.startPoint.f1441y, this.control1.f1441y, this.control2.f1441y, this.endPoint.f1441y);
            if (i > 0) {
                double d3 = point - d;
                double d4 = point2 - d2;
                f = (float) (((double) f) + Math.sqrt((d3 * d3) + (d4 * d4)));
            }
            i++;
            d2 = point2;
            d = point;
        }
        return f;
    }
}

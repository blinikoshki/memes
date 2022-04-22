package editor.signature.utils;

import org.apache.commons.lang3.StringUtils;

public class SvgPathBuilder {
    public static final Character SVG_MOVE = 'M';
    public static final Character SVG_RELATIVE_CUBIC_BEZIER_CURVE = 'c';
    private SvgPoint mLastPoint;
    private final SvgPoint mStartPoint;
    private final StringBuilder mStringBuilder;
    private final Integer mStrokeWidth;

    public SvgPathBuilder(SvgPoint svgPoint, Integer num) {
        this.mStrokeWidth = num;
        this.mStartPoint = svgPoint;
        this.mLastPoint = svgPoint;
        StringBuilder sb = new StringBuilder();
        this.mStringBuilder = sb;
        sb.append(SVG_RELATIVE_CUBIC_BEZIER_CURVE);
    }

    public final Integer getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public final SvgPoint getLastPoint() {
        return this.mLastPoint;
    }

    public SvgPathBuilder append(SvgPoint svgPoint, SvgPoint svgPoint2, SvgPoint svgPoint3) {
        this.mStringBuilder.append(makeRelativeCubicBezierCurve(svgPoint, svgPoint2, svgPoint3));
        this.mLastPoint = svgPoint3;
        return this;
    }

    public String toString() {
        return "<path " + "stroke-width=\"" + this.mStrokeWidth + "\" " + "d=\"" + SVG_MOVE + this.mStartPoint + this.mStringBuilder + "\"/>";
    }

    private String makeRelativeCubicBezierCurve(SvgPoint svgPoint, SvgPoint svgPoint2, SvgPoint svgPoint3) {
        String str = svgPoint.toRelativeCoordinates(this.mLastPoint) + StringUtils.SPACE + svgPoint2.toRelativeCoordinates(this.mLastPoint) + StringUtils.SPACE + svgPoint3.toRelativeCoordinates(this.mLastPoint) + StringUtils.SPACE;
        return "c0 0 0 0 0 0".equals(str) ? "" : str;
    }
}

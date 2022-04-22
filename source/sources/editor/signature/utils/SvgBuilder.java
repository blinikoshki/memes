package editor.signature.utils;

import org.apache.commons.lang3.StringUtils;

public class SvgBuilder {
    private SvgPathBuilder mCurrentPathBuilder = null;
    private final StringBuilder mSvgPathsBuilder = new StringBuilder();

    public void clear() {
        this.mSvgPathsBuilder.setLength(0);
        this.mCurrentPathBuilder = null;
    }

    public String build(int i, int i2) {
        if (isPathStarted()) {
            appendCurrentPath();
        }
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" + "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.2\" baseProfile=\"tiny\" " + "height=\"" + i2 + "\" " + "width=\"" + i + "\" " + "viewBox=\"" + 0 + StringUtils.SPACE + 0 + StringUtils.SPACE + i + StringUtils.SPACE + i2 + "\">" + "<g " + "stroke-linejoin=\"round\" " + "stroke-linecap=\"round\" " + "fill=\"none\" " + "stroke=\"black\"" + ">" + this.mSvgPathsBuilder + "</g>" + "</svg>";
    }

    public SvgBuilder append(Bezier bezier, float f) {
        Integer valueOf = Integer.valueOf(Math.round(f));
        SvgPoint svgPoint = new SvgPoint(bezier.startPoint);
        SvgPoint svgPoint2 = new SvgPoint(bezier.control1);
        SvgPoint svgPoint3 = new SvgPoint(bezier.control2);
        SvgPoint svgPoint4 = new SvgPoint(bezier.endPoint);
        if (!isPathStarted()) {
            startNewPath(valueOf, svgPoint);
        }
        if (!svgPoint.equals(this.mCurrentPathBuilder.getLastPoint()) || !valueOf.equals(this.mCurrentPathBuilder.getStrokeWidth())) {
            appendCurrentPath();
            startNewPath(valueOf, svgPoint);
        }
        this.mCurrentPathBuilder.append(svgPoint2, svgPoint3, svgPoint4);
        return this;
    }

    private void startNewPath(Integer num, SvgPoint svgPoint) {
        this.mCurrentPathBuilder = new SvgPathBuilder(svgPoint, num);
    }

    private void appendCurrentPath() {
        this.mSvgPathsBuilder.append(this.mCurrentPathBuilder);
    }

    private boolean isPathStarted() {
        return this.mCurrentPathBuilder != null;
    }
}

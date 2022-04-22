package p015io.noties.markwon.image;

import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.RenderProps;
import p015io.noties.markwon.SpanFactory;

/* renamed from: io.noties.markwon.image.ImageSpanFactory */
public class ImageSpanFactory implements SpanFactory {
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new AsyncDrawableSpan(markwonConfiguration.theme(), new AsyncDrawable(ImageProps.DESTINATION.require(renderProps), markwonConfiguration.asyncDrawableLoader(), markwonConfiguration.imageSizeResolver(), ImageProps.IMAGE_SIZE.get(renderProps)), 0, ImageProps.REPLACEMENT_TEXT_IS_LINK.get(renderProps, false).booleanValue());
    }
}

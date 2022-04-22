package p015io.noties.markwon.image;

import p015io.noties.markwon.Prop;

/* renamed from: io.noties.markwon.image.ImageProps */
public abstract class ImageProps {
    public static final Prop<String> DESTINATION = Prop.m157of("image-destination");
    public static final Prop<ImageSize> IMAGE_SIZE = Prop.m157of("image-size");
    public static final Prop<Boolean> REPLACEMENT_TEXT_IS_LINK = Prop.m157of("image-replacement-text-is-link");

    private ImageProps() {
    }
}

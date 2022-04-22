package p015io.noties.markwon.image;

import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.widget.TextView;
import java.util.concurrent.ExecutorService;
import org.commonmark.node.Image;
import p015io.noties.markwon.AbstractMarkwonPlugin;
import p015io.noties.markwon.MarkwonConfiguration;
import p015io.noties.markwon.MarkwonSpansFactory;

/* renamed from: io.noties.markwon.image.ImagesPlugin */
public class ImagesPlugin extends AbstractMarkwonPlugin {
    private final AsyncDrawableLoaderBuilder builder;

    /* renamed from: io.noties.markwon.image.ImagesPlugin$ErrorHandler */
    public interface ErrorHandler {
        Drawable handleError(String str, Throwable th);
    }

    /* renamed from: io.noties.markwon.image.ImagesPlugin$ImagesConfigure */
    public interface ImagesConfigure {
        void configureImages(ImagesPlugin imagesPlugin);
    }

    /* renamed from: io.noties.markwon.image.ImagesPlugin$PlaceholderProvider */
    public interface PlaceholderProvider {
        Drawable providePlaceholder(AsyncDrawable asyncDrawable);
    }

    public static ImagesPlugin create() {
        return new ImagesPlugin();
    }

    public static ImagesPlugin create(ImagesConfigure imagesConfigure) {
        ImagesPlugin imagesPlugin = new ImagesPlugin();
        imagesConfigure.configureImages(imagesPlugin);
        return imagesPlugin;
    }

    ImagesPlugin() {
        this(new AsyncDrawableLoaderBuilder());
    }

    ImagesPlugin(AsyncDrawableLoaderBuilder asyncDrawableLoaderBuilder) {
        this.builder = asyncDrawableLoaderBuilder;
    }

    public ImagesPlugin executorService(ExecutorService executorService) {
        this.builder.executorService(executorService);
        return this;
    }

    public ImagesPlugin addSchemeHandler(SchemeHandler schemeHandler) {
        this.builder.addSchemeHandler(schemeHandler);
        return this;
    }

    public ImagesPlugin addMediaDecoder(MediaDecoder mediaDecoder) {
        this.builder.addMediaDecoder(mediaDecoder);
        return this;
    }

    public ImagesPlugin defaultMediaDecoder(MediaDecoder mediaDecoder) {
        this.builder.defaultMediaDecoder(mediaDecoder);
        return this;
    }

    public ImagesPlugin removeSchemeHandler(String str) {
        this.builder.removeSchemeHandler(str);
        return this;
    }

    public ImagesPlugin removeMediaDecoder(String str) {
        this.builder.removeMediaDecoder(str);
        return this;
    }

    public ImagesPlugin placeholderProvider(PlaceholderProvider placeholderProvider) {
        this.builder.placeholderProvider(placeholderProvider);
        return this;
    }

    public ImagesPlugin errorHandler(ErrorHandler errorHandler) {
        this.builder.errorHandler(errorHandler);
        return this;
    }

    public void configureConfiguration(MarkwonConfiguration.Builder builder2) {
        builder2.asyncDrawableLoader(this.builder.build());
    }

    public void configureSpansFactory(MarkwonSpansFactory.Builder builder2) {
        builder2.setFactory(Image.class, new ImageSpanFactory());
    }

    public void beforeSetText(TextView textView, Spanned spanned) {
        AsyncDrawableScheduler.unschedule(textView);
    }

    public void afterSetText(TextView textView) {
        AsyncDrawableScheduler.schedule(textView);
    }
}

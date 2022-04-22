package p015io.noties.markwon.image.destination;

/* renamed from: io.noties.markwon.image.destination.ImageDestinationProcessor */
public abstract class ImageDestinationProcessor {
    public abstract String process(String str);

    public static ImageDestinationProcessor noOp() {
        return new NoOp();
    }

    /* renamed from: io.noties.markwon.image.destination.ImageDestinationProcessor$NoOp */
    private static class NoOp extends ImageDestinationProcessor {
        public String process(String str) {
            return str;
        }

        private NoOp() {
        }
    }
}

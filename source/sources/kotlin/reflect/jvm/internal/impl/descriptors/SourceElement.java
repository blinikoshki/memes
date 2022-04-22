package kotlin.reflect.jvm.internal.impl.descriptors;

public interface SourceElement {
    public static final SourceElement NO_SOURCE = new SourceElement() {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"}));
        }

        public String toString() {
            return "NO_SOURCE";
        }

        public SourceFile getContainingFile() {
            SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
            if (sourceFile == null) {
                $$$reportNull$$$0(0);
            }
            return sourceFile;
        }
    };

    SourceFile getContainingFile();
}

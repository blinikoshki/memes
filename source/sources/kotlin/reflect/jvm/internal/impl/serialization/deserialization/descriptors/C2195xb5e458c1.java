package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1 */
/* compiled from: DeserializedMemberScope.kt */
final class C2195xb5e458c1 extends Lambda implements Function0<M> {
    final /* synthetic */ ByteArrayInputStream $inputStream;
    final /* synthetic */ Parser<M> $parser;
    final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2195xb5e458c1(Parser<M> parser, ByteArrayInputStream byteArrayInputStream, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.$parser = parser;
        this.$inputStream = byteArrayInputStream;
        this.this$0 = deserializedMemberScope;
    }

    public final M invoke() {
        return (MessageLite) this.$parser.parseDelimitedFrom(this.$inputStream, this.this$0.getC().getComponents().getExtensionRegistryLite());
    }
}

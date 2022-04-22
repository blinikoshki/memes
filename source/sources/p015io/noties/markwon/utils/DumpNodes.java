package p015io.noties.markwon.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.lang3.StringUtils;
import org.commonmark.node.Node;
import org.commonmark.node.Visitor;

/* renamed from: io.noties.markwon.utils.DumpNodes */
public abstract class DumpNodes {

    /* renamed from: io.noties.markwon.utils.DumpNodes$NodeProcessor */
    public interface NodeProcessor {
        String process(Node node);
    }

    public static String dump(Node node) {
        return dump(node, (NodeProcessor) null);
    }

    public static String dump(Node node, final NodeProcessor nodeProcessor) {
        if (nodeProcessor == null) {
            nodeProcessor = new NodeProcessorToString();
        }
        final Indent indent = new Indent();
        final StringBuilder sb = new StringBuilder();
        node.accept((Visitor) Proxy.newProxyInstance(Visitor.class.getClassLoader(), new Class[]{Visitor.class}, new InvocationHandler() {
            public Object invoke(Object obj, Method method, Object[] objArr) {
                Node node = objArr[0];
                Indent.this.appendTo(sb);
                sb.append(nodeProcessor.process(node));
                if (node.getFirstChild() != null) {
                    sb.append(" [\n");
                    Indent.this.increment();
                    DumpNodes.visitChildren((Visitor) obj, node);
                    Indent.this.decrement();
                    Indent.this.appendTo(sb);
                    sb.append("]\n");
                    return null;
                }
                sb.append(StringUtils.f466LF);
                return null;
            }
        }));
        return sb.toString();
    }

    private DumpNodes() {
    }

    /* renamed from: io.noties.markwon.utils.DumpNodes$Indent */
    private static class Indent {
        private int count;

        private Indent() {
        }

        /* access modifiers changed from: package-private */
        public void increment() {
            this.count++;
        }

        /* access modifiers changed from: package-private */
        public void decrement() {
            this.count--;
        }

        /* access modifiers changed from: package-private */
        public void appendTo(StringBuilder sb) {
            for (int i = 0; i < this.count; i++) {
                sb.append(' ');
                sb.append(' ');
            }
        }
    }

    /* access modifiers changed from: private */
    public static void visitChildren(Visitor visitor, Node node) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            firstChild.accept(visitor);
            firstChild = next;
        }
    }

    /* renamed from: io.noties.markwon.utils.DumpNodes$NodeProcessorToString */
    private static class NodeProcessorToString implements NodeProcessor {
        private NodeProcessorToString() {
        }

        public String process(Node node) {
            return node.toString();
        }
    }
}

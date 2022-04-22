package p015io.noties.markwon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Node;

/* renamed from: io.noties.markwon.MarkwonReducer */
public abstract class MarkwonReducer {
    public abstract List<Node> reduce(Node node);

    public static MarkwonReducer directChildren() {
        return new DirectChildren();
    }

    /* renamed from: io.noties.markwon.MarkwonReducer$DirectChildren */
    static class DirectChildren extends MarkwonReducer {
        DirectChildren() {
        }

        public List<Node> reduce(Node node) {
            Node firstChild = node.getFirstChild();
            if (firstChild == null) {
                return Collections.singletonList(node);
            }
            ArrayList arrayList = new ArrayList();
            while (firstChild != null) {
                if (!(firstChild instanceof LinkReferenceDefinition)) {
                    arrayList.add(firstChild);
                }
                Node next = firstChild.getNext();
                firstChild.unlink();
                firstChild = next;
            }
            return arrayList;
        }
    }
}

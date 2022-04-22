package org.junit.internal.runners.statements;

import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class RunAfters extends Statement {
    private final List<FrameworkMethod> afters;
    private final Statement next;
    private final Object target;

    public RunAfters(Statement statement, List<FrameworkMethod> list, Object obj) {
        this.next = statement;
        this.afters = list;
        this.target = obj;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void evaluate() throws java.lang.Throwable {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            org.junit.runners.model.Statement r2 = r7.next     // Catch:{ all -> 0x002a }
            r2.evaluate()     // Catch:{ all -> 0x002a }
            java.util.List<org.junit.runners.model.FrameworkMethod> r2 = r7.afters
            java.util.Iterator r2 = r2.iterator()
        L_0x0011:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x004d
            java.lang.Object r3 = r2.next()
            org.junit.runners.model.FrameworkMethod r3 = (org.junit.runners.model.FrameworkMethod) r3
            java.lang.Object r4 = r7.target     // Catch:{ all -> 0x0025 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0025 }
            r3.invokeExplosively(r4, r5)     // Catch:{ all -> 0x0025 }
            goto L_0x0011
        L_0x0025:
            r3 = move-exception
            r0.add(r3)
            goto L_0x0011
        L_0x002a:
            r2 = move-exception
            r0.add(r2)     // Catch:{ all -> 0x0051 }
            java.util.List<org.junit.runners.model.FrameworkMethod> r2 = r7.afters
            java.util.Iterator r2 = r2.iterator()
        L_0x0034:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x004d
            java.lang.Object r3 = r2.next()
            org.junit.runners.model.FrameworkMethod r3 = (org.junit.runners.model.FrameworkMethod) r3
            java.lang.Object r4 = r7.target     // Catch:{ all -> 0x0048 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0048 }
            r3.invokeExplosively(r4, r5)     // Catch:{ all -> 0x0048 }
            goto L_0x0034
        L_0x0048:
            r3 = move-exception
            r0.add(r3)
            goto L_0x0034
        L_0x004d:
            org.junit.runners.model.MultipleFailureException.assertEmpty(r0)
            return
        L_0x0051:
            r2 = move-exception
            java.util.List<org.junit.runners.model.FrameworkMethod> r3 = r7.afters
            java.util.Iterator r3 = r3.iterator()
        L_0x0058:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0071
            java.lang.Object r4 = r3.next()
            org.junit.runners.model.FrameworkMethod r4 = (org.junit.runners.model.FrameworkMethod) r4
            java.lang.Object r5 = r7.target     // Catch:{ all -> 0x006c }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x006c }
            r4.invokeExplosively(r5, r6)     // Catch:{ all -> 0x006c }
            goto L_0x0058
        L_0x006c:
            r4 = move-exception
            r0.add(r4)
            goto L_0x0058
        L_0x0071:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.internal.runners.statements.RunAfters.evaluate():void");
    }
}

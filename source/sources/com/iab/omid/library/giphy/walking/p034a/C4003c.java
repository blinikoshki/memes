package com.iab.omid.library.giphy.walking.p034a;

import com.iab.omid.library.giphy.walking.p034a.C4000b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iab.omid.library.giphy.walking.a.c */
public class C4003c implements C4000b.C4001a {

    /* renamed from: a */
    private final BlockingQueue<Runnable> f900a;

    /* renamed from: b */
    private final ThreadPoolExecutor f901b;

    /* renamed from: c */
    private final ArrayDeque<C4000b> f902c = new ArrayDeque<>();

    /* renamed from: d */
    private C4000b f903d = null;

    public C4003c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f900a = linkedBlockingQueue;
        this.f901b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    /* renamed from: a */
    private void m784a() {
        C4000b poll = this.f902c.poll();
        this.f903d = poll;
        if (poll != null) {
            poll.mo56028a(this.f901b);
        }
    }

    /* renamed from: a */
    public void mo56030a(C4000b bVar) {
        this.f903d = null;
        m784a();
    }

    /* renamed from: b */
    public void mo56033b(C4000b bVar) {
        bVar.mo56026a((C4000b.C4001a) this);
        this.f902c.add(bVar);
        if (this.f903d == null) {
            m784a();
        }
    }
}

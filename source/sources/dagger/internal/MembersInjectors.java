package dagger.internal;

import dagger.MembersInjector;

public final class MembersInjectors {
    public static <T> T injectMembers(MembersInjector<T> membersInjector, T t) {
        membersInjector.injectMembers(t);
        return t;
    }

    public static <T> MembersInjector<T> noOp() {
        return NoOpMembersInjector.INSTANCE;
    }

    private enum NoOpMembersInjector implements MembersInjector<Object> {
        INSTANCE;

        public void injectMembers(Object obj) {
            MembersInjectors.checkInstanceNotNull(obj);
        }
    }

    public static void checkInstanceNotNull(Object obj) {
        Preconditions.checkNotNull(obj, "Cannot inject members into a null reference");
    }

    private MembersInjectors() {
    }
}

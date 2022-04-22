package org.junit.experimental.theories;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

public class Theories extends BlockJUnit4ClassRunner {
    public Theories(Class<?> cls) throws InitializationError {
        super(cls);
    }

    /* access modifiers changed from: protected */
    public void collectInitializationErrors(List<Throwable> list) {
        super.collectInitializationErrors(list);
        validateDataPointFields(list);
        validateDataPointMethods(list);
    }

    private void validateDataPointFields(List<Throwable> list) {
        for (Field field : getTestClass().getJavaClass().getDeclaredFields()) {
            if (field.getAnnotation(DataPoint.class) != null || field.getAnnotation(DataPoints.class) != null) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be static"));
                }
                if (!Modifier.isPublic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be public"));
                }
            }
        }
    }

    private void validateDataPointMethods(List<Throwable> list) {
        for (Method method : getTestClass().getJavaClass().getDeclaredMethods()) {
            if (method.getAnnotation(DataPoint.class) != null || method.getAnnotation(DataPoints.class) != null) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be static"));
                }
                if (!Modifier.isPublic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be public"));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void validateConstructor(List<Throwable> list) {
        validateOnlyOneConstructor(list);
    }

    /* access modifiers changed from: protected */
    public void validateTestMethods(List<Throwable> list) {
        for (FrameworkMethod next : computeTestMethods()) {
            if (next.getAnnotation(Theory.class) != null) {
                next.validatePublicVoid(false, list);
                next.validateNoTypeParametersOnArgs(list);
            } else {
                next.validatePublicVoidNoArg(false, list);
            }
            Iterator<ParameterSignature> it = ParameterSignature.signatures(next.getMethod()).iterator();
            while (it.hasNext()) {
                ParametersSuppliedBy parametersSuppliedBy = (ParametersSuppliedBy) it.next().findDeepAnnotation(ParametersSuppliedBy.class);
                if (parametersSuppliedBy != null) {
                    validateParameterSupplier(parametersSuppliedBy.value(), list);
                }
            }
        }
    }

    private void validateParameterSupplier(Class<? extends ParameterSupplier> cls, List<Throwable> list) {
        Constructor[] constructors = cls.getConstructors();
        if (constructors.length != 1) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " must have only one constructor (either empty or taking only a TestClass)"));
            return;
        }
        Class[] parameterTypes = constructors[0].getParameterTypes();
        if (parameterTypes.length != 0 && !parameterTypes[0].equals(TestClass.class)) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " constructor must take either nothing or a single TestClass instance"));
        }
    }

    /* access modifiers changed from: protected */
    public List<FrameworkMethod> computeTestMethods() {
        ArrayList arrayList = new ArrayList(super.computeTestMethods());
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Theory.class);
        arrayList.removeAll(annotatedMethods);
        arrayList.addAll(annotatedMethods);
        return arrayList;
    }

    public Statement methodBlock(FrameworkMethod frameworkMethod) {
        return new TheoryAnchor(frameworkMethod, getTestClass());
    }

    public static class TheoryAnchor extends Statement {
        private List<AssumptionViolatedException> fInvalidParameters = new ArrayList();
        private int successes = 0;
        private final TestClass testClass;
        private final FrameworkMethod testMethod;

        public TheoryAnchor(FrameworkMethod frameworkMethod, TestClass testClass2) {
            this.testMethod = frameworkMethod;
            this.testClass = testClass2;
        }

        private TestClass getTestClass() {
            return this.testClass;
        }

        public void evaluate() throws Throwable {
            runWithAssignment(Assignments.allUnassigned(this.testMethod.getMethod(), getTestClass()));
            boolean z = this.testMethod.getAnnotation(Theory.class) != null;
            if (this.successes == 0 && z) {
                Assert.fail("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.fInvalidParameters);
            }
        }

        /* access modifiers changed from: protected */
        public void runWithAssignment(Assignments assignments) throws Throwable {
            if (!assignments.isComplete()) {
                runWithIncompleteAssignment(assignments);
            } else {
                runWithCompleteAssignment(assignments);
            }
        }

        /* access modifiers changed from: protected */
        public void runWithIncompleteAssignment(Assignments assignments) throws Throwable {
            for (PotentialAssignment assignNext : assignments.potentialsForNextUnassigned()) {
                runWithAssignment(assignments.assignNext(assignNext));
            }
        }

        /* access modifiers changed from: protected */
        public void runWithCompleteAssignment(final Assignments assignments) throws Throwable {
            new BlockJUnit4ClassRunner(getTestClass().getJavaClass()) {
                /* access modifiers changed from: protected */
                public void collectInitializationErrors(List<Throwable> list) {
                }

                public Statement methodBlock(FrameworkMethod frameworkMethod) {
                    final Statement methodBlock = super.methodBlock(frameworkMethod);
                    return new Statement() {
                        public void evaluate() throws Throwable {
                            try {
                                methodBlock.evaluate();
                                TheoryAnchor.this.handleDataPointSuccess();
                            } catch (AssumptionViolatedException e) {
                                TheoryAnchor.this.handleAssumptionViolation(e);
                            } catch (Throwable th) {
                                TheoryAnchor.this.reportParameterizedError(th, assignments.getArgumentStrings(TheoryAnchor.this.nullsOk()));
                            }
                        }
                    };
                }

                /* access modifiers changed from: protected */
                public Statement methodInvoker(FrameworkMethod frameworkMethod, Object obj) {
                    return TheoryAnchor.this.methodCompletesWithParameters(frameworkMethod, assignments, obj);
                }

                public Object createTest() throws Exception {
                    Object[] constructorArguments = assignments.getConstructorArguments();
                    if (!TheoryAnchor.this.nullsOk()) {
                        Assume.assumeNotNull(constructorArguments);
                    }
                    return getTestClass().getOnlyConstructor().newInstance(constructorArguments);
                }
            }.methodBlock(this.testMethod).evaluate();
        }

        /* access modifiers changed from: private */
        public Statement methodCompletesWithParameters(final FrameworkMethod frameworkMethod, final Assignments assignments, final Object obj) {
            return new Statement() {
                public void evaluate() throws Throwable {
                    Object[] methodArguments = assignments.getMethodArguments();
                    if (!TheoryAnchor.this.nullsOk()) {
                        Assume.assumeNotNull(methodArguments);
                    }
                    frameworkMethod.invokeExplosively(obj, methodArguments);
                }
            };
        }

        /* access modifiers changed from: protected */
        public void handleAssumptionViolation(AssumptionViolatedException assumptionViolatedException) {
            this.fInvalidParameters.add(assumptionViolatedException);
        }

        /* access modifiers changed from: protected */
        public void reportParameterizedError(Throwable th, Object... objArr) throws Throwable {
            if (objArr.length == 0) {
                throw th;
            }
            throw new ParameterizedAssertionError(th, this.testMethod.getName(), objArr);
        }

        /* access modifiers changed from: private */
        public boolean nullsOk() {
            Theory theory = (Theory) this.testMethod.getMethod().getAnnotation(Theory.class);
            if (theory == null) {
                return false;
            }
            return theory.nullsAccepted();
        }

        /* access modifiers changed from: protected */
        public void handleDataPointSuccess() {
            this.successes++;
        }
    }
}

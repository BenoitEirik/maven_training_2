package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {
    Class<?> testClass;

    public TestClassDescription(Class<?> myClass) {
        this.testClass = myClass;
    }

    public List<Method> listTestMethods() {
        Method[] methods = testClass.getDeclaredMethods();
        List<Method> rightMethods = new ArrayList<Method>();

        for (int i = 0; i < methods.length; i++) {
            if (Modifier.isPublic(methods[i].getModifiers())
                && methods[i].getReturnType().equals(Void.TYPE)
                && methods[i].getParameterCount() == 0
                && methods[i].isAnnotationPresent(TestMethod.class))
            {
                rightMethods.add(methods[i]);
            }
        }
        return rightMethods;
    }
}

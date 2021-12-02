package fr.lernejo.tester.internal;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

public class TestClassDiscoverer {
    public TestClassDiscoverer(String packageName) {
    }

    static List<TestClassDescription> listTestClasses() {
        Reflections reflections = new Reflections("fr.lernejo", new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);

        List<TestClassDescription> tCD = new ArrayList<TestClassDescription>();
        for (Iterator<Class<?>> iterator = allTypes.iterator(); iterator.hasNext(); ) {
            Class<?> pc = iterator.next();
            TestClassDescription p = new TestClassDescription(pc);
            if (p.listTestMethods().size() >= 0) {
                tCD.add(p);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(listTestClasses());
    }
}

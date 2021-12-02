package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.internal.TestClassDescription;
import org.junit.jupiter.api.Test;

public class TestClassDescriptionLernejoTests {

    static void check_listTestMethods() {
        Class<SomeLernejoTests> testClass = SomeLernejoTests.class;
        TestClassDescription test = new TestClassDescription(testClass);
        System.out.println("Result=" + test.listTestMethods());
    }

    public static void main(String[] args) {
        check_listTestMethods();
    }
}

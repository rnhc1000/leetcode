/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.ferreiras.LeetCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeetCodeTest {
    @Test void appHasAGreeting() {
        LeetCode classUnderTest = new LeetCode();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
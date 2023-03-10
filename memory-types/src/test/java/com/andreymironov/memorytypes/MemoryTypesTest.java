package com.andreymironov.memorytypes;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemoryTypesTest {
    private SoftAssertions softAssertions;
    private int times;

    @BeforeEach
    void beforeEach() {
        softAssertions = new SoftAssertions();
    }

    @AfterEach
    void afterEach() {
        softAssertions.assertAll();
    }

    @Test
    public void testStackOverflowException() {
        System.out.println("The number before Stack overflowing: " + times);
        softAssertions.assertThatThrownBy(this::recursiveInvoke).isInstanceOf(StackOverflowError.class);
        System.out.println("The number after Stack overflowing: " + times);
    }

    private void recursiveInvoke() {
        this.times++;
        recursiveInvoke();
    }

}
package com.cesar31;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramTest {

    private Anagram anagram;

    @BeforeEach
    public void setUp() {
        anagram = new Anagram();
    }

    @Test
    void shouldThrowExceptionIllegalExceptionWhenAnyArgIsNull() {
        String s1 = null;
        String s2 = "pesada";
        assertThrows(IllegalArgumentException.class, () -> {
            anagram.isAnagram(s1, s2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            anagram.isAnagram(s2, s1);
        });
    }

    @Test
    void shouldReturnIllegalExceptionWhenBothArgsAreEmpty() {
        final var message = "Arguments should not be null";

        var ex = assertThrows(IllegalArgumentException.class, () -> {
            anagram.isAnagram(null, null);
        });

        assertEquals(message, ex.getMessage());
    }

    @Test
    void shouldReturnFalseWhenAnyOrBothArgsAreEmpty() {
        final var s1 = "";
        final var s2 = "espada";
        final var s3 = "";

        assertAll(
                () -> assertFalse(anagram.isAnagram(s1, s2)),
                () -> assertFalse(anagram.isAnagram(s2, s3)),
                () -> assertFalse(anagram.isAnagram(s3, s1))
        );
    }

    @Test
    void shouldReturnFalseIfTheLengthOfBothStringsAreNotEqual() {
        final var s1 = "pesada";
        final var s2 = "espadaa";

        assertAll(
                () -> assertFalse(anagram.isAnagram(s1, s2)),
                () -> assertFalse(anagram.isAnagram(s2, s1))
        );
    }

    @Test
    void shouldReturnFalseIfBothsArgsAreNotAnAnagram() {
        final var s1 = "pisada";
        final var s2 = "espada";

        assertAll(
                () -> assertFalse(anagram.isAnagram(s1, s2)),
                () -> assertFalse(anagram.isAnagram(s2, s1))
        );
    }

    @Test
    void shouldReturnTrueIfBothArgsAreAnagram() {
        final var s1 = "espada";
        final var s2 = "pesada";

        assertAll(
                () -> assertTrue(anagram.isAnagram(s1, s2)),
                () -> assertTrue(anagram.isAnagram(s2, s1))
        );
    }
}

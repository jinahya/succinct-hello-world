package com.github.jinahya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * A class for testing {@link HelloWorld} class.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
class HelloWorldTest {

    /**
     * Tests {@link HelloWorld#main(String...)} method.
     *
     * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
     */
    @Test
    void main__() {
        final var out = System.out;
        try {
            // --------------------------------------------------------------------------------------------------- given
            final var buffer = new ByteArrayOutputStream();
            System.setOut(new PrintStream(buffer));
            // ---------------------------------------------------------------------------------------------------- when
            HelloWorld.main();
            // ---------------------------------------------------------------------------------------------------- then
            final var actual = buffer.toByteArray();
            final var expected = ("hello, world" + System.lineSeparator()).getBytes(StandardCharsets.US_ASCII);
            Assertions.assertArrayEquals(actual, expected);
        } finally {
            System.setOut(out);
        }
    }
}
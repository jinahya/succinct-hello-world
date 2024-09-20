package com.github.jinahya.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;

/**
 * A class for testing {@link HelloWorld} class.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
class HelloWorldTest {

    @Test
    void __() throws NoSuchMethodException {
        final var constructor = HelloWorld.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        final var thrown = Assertions.assertThrows(
                InvocationTargetException.class,
                constructor::newInstance
        );
        final var cause = thrown.getCause();
        Assertions.assertInstanceOf(AssertionError.class, cause);
        Assertions.assertEquals("instantiation is not allowed", cause.getMessage());
    }

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
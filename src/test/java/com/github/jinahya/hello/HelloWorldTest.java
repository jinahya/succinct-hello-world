package com.github.jinahya.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.stream.Stream;

/**
 * A class for testing {@link HelloWorld} class.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a
 * href="https://stackoverflow.com/questions/79005325/what-is-the-proper-charset-for-decoding-systemlineseparator">What
 * is the proper charset for decoding System#lineSeparator?</a> (Stackoverflow.com)
 * @see <a href="https://github.com/junit-team/junit5/issues/2482">Add Assumptions.assumeDoesNotThrow</a>
 * (github.com/junit-team/junit5/issues/2482)
 */
@SuppressWarnings({
        "java:S5786" // JUnit5 test classes and methods should have default package visibility
})
public class HelloWorldTest {

    /**
     * Creates a new instance.
     */
    HelloWorldTest() {
        super();
    }

    /**
     * Asserts that the private constructor of the {@link HelloWorld} class throws an {@link AssertionError}.
     *
     * @throws NoSuchMethodException when failed to get the private constructor.
     */
    @Test
    public void __() throws NoSuchMethodException {
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
     * Verifies that the {@link HelloWorld#main(String...)} method prints {@code hello, world}, to the
     * {@link System#out}, followed by a system-dependent line separator.
     *
     * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
     * @see System#lineSeparator()
     */
    @DisplayName("main(args) prints 'hello, world' followed by a system-dependent line separator")
    @Test
    public void main_PrintHelloWorld_() {
        final var out = System.out;
        try {
            // --------------------------------------------------------------------------------------------------- given
            final var buffer = new ByteArrayOutputStream();
            final var charset = Charset.defaultCharset();
            System.setOut(new PrintStream(buffer, true, charset));
            // ---------------------------------------------------------------------------------------------------- when
            HelloWorld.main();
            // ---------------------------------------------------------------------------------------------------- then
            final var actual = buffer.toByteArray();
            final var expected = (HelloWorld.STRING + System.lineSeparator()).getBytes(charset);
            Assertions.assertArrayEquals(actual, expected);
        } finally {
            System.setOut(out);
        }
    }

    /**
     * Returns a stream of {@link Charset} which each {@link Charset#canEncode() can encode}.
     *
     * @return a stream of {@link Charset}.
     */
    private static Stream<Charset> getCharsetStream() {
        return Charset.availableCharsets().values().stream().filter(Charset::canEncode);
    }

    /**
     * Tests the {@link HelloWorld#main(String...)} method with specified charset.
     *
     * @param charset the charset to test with.
     */
    @DisplayName("main(args) prints 'hello, world' followed by a system-dependent line separator")
    @MethodSource("getCharsetStream")
    @ParameterizedTest
    public void main_PrintHelloWorld_(final Charset charset) {
        final var out = System.out;
        try {
            // --------------------------------------------------------------------------------------------------- given
            final var buffer = new ByteArrayOutputStream();
            System.setOut(new PrintStream(buffer, true, charset));
            // ---------------------------------------------------------------------------------------------------- when
            HelloWorld.main();
            // ---------------------------------------------------------------------------------------------------- then
            final var actual = buffer.toByteArray();
            final var expected = (HelloWorld.STRING + System.lineSeparator()).getBytes(charset);
            Assertions.assertArrayEquals(actual, expected);
        } finally {
            System.setOut(out);
        }
    }
}
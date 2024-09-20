package com.github.jinahya.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/**
 * A class for testing {@link HelloWorld} class.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
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
     * @see <a
     * href="https://stackoverflow.com/questions/79005325/what-is-the-proper-charset-for-decoding-systemlineseparator">What
     * is the proper charset for decoding System#lineSeparator?</a> (Stackoverflow.com)
     */
    @DisplayName("main(args) prints 'hello, world' followed by a system-dependent line separator")
    @Test
    public void main_PrintHelloWorld_() {
        final var out = System.out;
        try {
            // --------------------------------------------------------------------------------------------------- given
            final var buffer = new ByteArrayOutputStream();
            System.setOut(new PrintStream(buffer));
            // ---------------------------------------------------------------------------------------------------- when
            HelloWorld.main();
            // ---------------------------------------------------------------------------------------------------- then
            final var actual = buffer.toByteArray();
            final var expected = (HelloWorld.STRING + System.lineSeparator()).getBytes(Charset.defaultCharset());
            Assertions.assertArrayEquals(actual, expected);
        } finally {
            System.setOut(out);
        }
    }
}
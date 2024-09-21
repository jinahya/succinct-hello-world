package com.github.jinahya.hello;

/**
 * The main program of this module whose {@link #main(String...)} method prints {@code hello, world}, to the
 * {@link System#out}, followed by a system dependent line separator.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class HelloWorld {

    /**
     * The string of {@value} to print.
     */
    static final String STRING = "hello, world";

    /**
     * Prints {@code hello, world}, to the {@link System#out}, followed by a system dependent line separator.
     *
     * @param args command line arguments.
     */
    @SuppressWarnings({
            "java:S106" // Standard outputs should not be used directly to log anything
    })
    public static void main(String... args) {
        System.out.printf("%1$s%n", STRING);
    }

    /**
     * Creates a new instance, my ass.
     */
    private HelloWorld() {
        throw new AssertionError("instantiation is not allowed");
    }
}

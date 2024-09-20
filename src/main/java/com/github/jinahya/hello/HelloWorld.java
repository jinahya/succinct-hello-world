package com.github.jinahya.hello;

/**
 * The main program of this module whose {@link #main(String...)} method prints {@code hello, world}, to the
 * {@link System#out}, followed by a system dependent line separator.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class HelloWorld {

    static final String STRING = "hello, world";

    /**
     * Prints {@code hello, world}, to the {@link System#out}, followed by a system dependent line separator.
     *
     * @param args command line arguments.
     */
    public static void main(String... args) {
        System.out.printf("$1$s%n", STRING);
    }

    /**
     * Creates a new instance, my ass.
     */
    private HelloWorld() { // $COVERAGE-IGNORE$
        throw new AssertionError("instantiation is not allowed");
    }
}

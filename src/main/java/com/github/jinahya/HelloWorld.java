package com.github.jinahya;

/**
 * The main program of this module whose {@link #main(String...)} method prints {@code hello, world}, to the
 * {@link System#out}, followed by a system dependency line separator.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class HelloWorld {

    /**
     * Prints {@code hello, world}, to the {@link System#out}, followed by a system dependency line separator.
     *
     * @param args command line arguments.
     */
    public static void main(String... args) {
        System.out.printf("hello, world%n");
    }

    private HelloWorld() {
        throw new AssertionError("instantiation is not allowed");
    }
}

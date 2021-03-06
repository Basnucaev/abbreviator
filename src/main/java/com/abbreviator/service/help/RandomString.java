package com.abbreviator.service.help;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

public class RandomString {

    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String lower = upper.toLowerCase(Locale.ROOT);

    public static final String digits = "0123456789";

    public static final String alphanumeric = upper + lower + digits;

    private final Random random;

    private final char[] symbols;

    private final char[] buf;

    public RandomString(int length, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = new SecureRandom();
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    public RandomString(int length) {
        this(length, alphanumeric);
    }

    public RandomString() {
        this(21);
    }

    public String getRandomString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }
}

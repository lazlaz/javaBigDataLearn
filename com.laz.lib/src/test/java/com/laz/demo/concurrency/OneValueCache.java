package com.laz.demo.concurrency;

import java.math.BigInteger;
import java.util.*;

import jdk.nashorn.internal.ir.annotations.Immutable;

import com.laz.demo.concurrency.*;

/**
 * OneValueCache
 * <p/>
 * Immutable holder for caching a number and its factors
 *
 * @author Brian Goetz and Tim Peierls
 */
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i,
                         BigInteger[] factors) {
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i))
            return null;
        else
            return Arrays.copyOf(lastFactors, lastFactors.length);
    }
}

package gad.dynamicarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArrayTest {
    @Test
    void example() {
        Interval i;

        DynamicArray d = new DynamicArray(3, 4);
        assertEquals("[]", d.toString());

        i = d.reportUsage(Interval.EmptyInterval.getEmptyInterval(), 1);
        assertEquals("[0, 0, 0]", d.toString());
        assertEquals("[]", i.toString());

        d.set(2,1);
        assertEquals(0, d.get(1));
        d.set(0,3);
        assertEquals("[3, 0, 1]", d.toString());

        i = d.reportUsage(new Interval.NonEmptyInterval(1,2), 4);
        assertEquals("[0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]", d.toString());
        assertEquals("[0; 1]", i.toString());

        i = d.reportUsage(new Interval.NonEmptyInterval(3,6), 4);
        assertEquals("[0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]", d.toString());
        assertEquals("[3; 6]", i.toString());

        i = d.reportUsage(new Interval.NonEmptyInterval(1,1), 1);
        assertEquals("[1, 0, 0]", d.toString());
        assertEquals("[0; 0]", i.toString());

        i = d.reportUsage(Interval.EmptyInterval.getEmptyInterval(), 2);
        assertEquals("[1, 0, 0]", d.toString());
        assertEquals("[]", i.toString());

        i = d.reportUsage(new Interval.NonEmptyInterval(2,0), 4);
        assertEquals("[0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]", d.toString());
        assertEquals("[0; 1]", i.toString());

        i = d.reportUsage(new Interval.NonEmptyInterval(5,1), 9);
        assertEquals("[0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]", d.toString());
        assertEquals("[5; 1]", i.toString());

        i = d.reportUsage(Interval.EmptyInterval.getEmptyInterval(), 0);
        assertEquals("[]", d.toString());
        assertEquals("[]", i.toString());
    }
}

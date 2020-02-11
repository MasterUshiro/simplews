package ua.com.simplews;

import org.junit.jupiter.api.Test;
import ua.com.simplews.testtdd.AgagaConverter;

import static org.junit.Assert.assertEquals;

public class ArabicTest {
    @Test
    public void convertToTo() {

        AgagaConverter converter = new AgagaConverter();
        assertEquals("1", converter.convert(1));

    }
}

package javase.generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularBufferTest {

    private CircularBuffer buffer = new CircularBuffer(2);

    @Test
    public void shouldOfferPollableElement(){
        assertTrue(buffer.offer(1));
        assertEquals(1, buffer.poll());
        assertNull(buffer.poll());
    }
}
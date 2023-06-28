package nl.suriani.tis400asm.runtime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortTest {
    @Test
    void noPreviousData_read() {
        var port = new Port();
        assertTrue(port.read().isEmpty());
    }

    @Test
    void noPreviousData_writeOnce_readOnce() {
        var port = new Port();
        port.write(3);
        var maybeValue = port.read();
        assertTrue(maybeValue.isPresent());
        assertEquals(3, maybeValue.get());
    }

    @Test
    void noPreviousData_writeOnce_readTwice() {
        var port = new Port();
        port.write(3);
        port.read();
        assertTrue(port.read().isEmpty());
    }

    @Test
    void previousData_writeAgain() {
        var port = new Port();
        port.write(3);
        assertThrows(PortIsLockedException.class, () -> port.write(3));
    }
}
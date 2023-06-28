package nl.suriani.tis400asm.runtime;

import java.util.*;

public class Port {
    private Deque<Data> data;

    public Port() {
        data = new ArrayDeque<>();
    }

    public Optional<Integer> read() {
        if (data.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(data.pop().value());
    }

    public void write(Integer value) {
        if (!data.isEmpty()) {
            throw new PortIsLockedException();
        }
        data.push(new Data(value));
    }
}

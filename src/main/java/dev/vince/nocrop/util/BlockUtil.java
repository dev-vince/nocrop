package dev.vince.nocrop.util;

import net.minecraftforge.event.world.BlockEvent;

import java.util.concurrent.atomic.AtomicInteger;

public final class BlockUtil {
    private BlockUtil() {}

    public static int getAge(final BlockEvent.BreakEvent event) {
        final AtomicInteger age = new AtomicInteger();
        event.state.getProperties().forEach((property, comparable) -> {
            if (property.getName().equals("age")) {
                age.set((Integer) comparable);
            }
        });
        return age.get();
    }
}

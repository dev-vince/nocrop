package dev.vince.nocrop.block;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public final class BlockFilter {
    private final Builder builder;

    private BlockFilter(final Builder builder) {
        this.builder = builder;

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onBlockBreak(final BlockEvent.BreakEvent event) {
        for (final AbstractBlockHandler blockHandler : this.builder.blockHandlers) {
            blockHandler.execute(event);
        }
    }

    public static class Builder {
        private final List<AbstractBlockHandler> blockHandlers;

        private Builder() {
            this.blockHandlers = new ArrayList<AbstractBlockHandler>();
        }

        public Builder withHandler(final AbstractBlockHandler blockHandler) {
            this.blockHandlers.add(blockHandler);
            return this;
        }

        public BlockFilter build() {
            return new BlockFilter(this);
        }
    }

    public static Builder Builder() {
        return new Builder();
    }
}
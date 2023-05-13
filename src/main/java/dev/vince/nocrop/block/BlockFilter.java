package dev.vince.nocrop.block;

import dev.vince.nocrop.util.ChatUtil;
import dev.vince.nocrop.util.PlayerUtil;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public final class BlockFilter {
    private static final int MAX_COUNTER = 3;
    private final Builder builder;
    private int counter;

    private BlockFilter(final Builder builder) {
        this.builder = builder;
        this.counter = 0;

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onBlockBreak(final BlockEvent.BreakEvent event) {
        final boolean holdingTool = PlayerUtil.isPlayerHoldingTool();

        if (!holdingTool) {
            if (this.counter < MAX_COUNTER) {
                this.counter++;
                int remaining = MAX_COUNTER - this.counter;

                if (remaining != 0)
                    ChatUtil.addChatMessage("Break the block " + remaining + " more times to break it");
            }

            if (this.counter >= MAX_COUNTER) {
                this.counter = 0;
                return;
            }
        }

        for (final AbstractBlockHandler blockHandler : this.builder.blockHandlers) {
            blockHandler.execute(event);
        }
    }

    public static class Builder {
        private final List<AbstractBlockHandler> blockHandlers;

        private Builder() {
            this.blockHandlers = new ArrayList<>();
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
package dev.vince.nocrop.block.impl;

import dev.vince.nocrop.block.AbstractBlockHandler;
import dev.vince.nocrop.util.BlockUtil;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent;

public final class NetherWartHandler extends AbstractBlockHandler {
    public NetherWartHandler() {
        super(Blocks.nether_wart);
    }

    @Override
    public void execute(final BlockEvent.BreakEvent event) {
        if (event.state.getBlock() == block) {
            int age = BlockUtil.getAge(event);
            if (age < 7)
                cancelBreak(event);
        }
    }
}

package dev.vince.nocrop;

import dev.vince.nocrop.block.BlockFilter;
import dev.vince.nocrop.block.impl.MelonBlockHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = NoCropMod.MODID, version = NoCropMod.VERSION)
public class NoCropMod
{
    public static final String MODID = "nocrop";
    public static final String VERSION = "1.0";

    private static final NoCropMod INSTANCE = new NoCropMod();

    public NoCropMod() {
        BlockFilter.Builder().withHandler(new MelonBlockHandler()).build();
    }

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {
        System.out.println("Loaded " + MODID + " version " + VERSION);
    }

    public static NoCropMod getInstance() {
        return NoCropMod.INSTANCE;
    }
}

package dev.vince.nocrop;

import dev.vince.nocrop.block.BlockFilter;
import dev.vince.nocrop.block.impl.MelonStemHandler;
import dev.vince.nocrop.block.impl.PumpkinStemHandler;
import dev.vince.nocrop.block.impl.WheatHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = NoCropMod.MODID, version = NoCropMod.VERSION)
public class NoCropMod
{
    public static final String MODID = "nocrop";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {
        BlockFilter.Builder()
                .withHandler(new MelonStemHandler())
                .withHandler(new PumpkinStemHandler())
                .withHandler(new WheatHandler())
                .build();
        System.out.println("Loaded " + MODID + " version " + VERSION);
    }
}

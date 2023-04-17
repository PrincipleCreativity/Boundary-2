package org.principlecreativity.boundary2;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.principlecreativity.boundary2.common.init.BlockRegistry;
import org.principlecreativity.boundary2.common.init.ItemRegistry;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "boundary2";

    //Creative Tabs
    public static final CreativeModeTab BLOCK_TAB = new BlockTab();
    public static final CreativeModeTab MISC_TAB = new MiscTab();

    public Main(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.ITEMS.register(bus);
        BlockRegistry.BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static class BlockTab extends CreativeModeTab {

        public BlockTab() {
            super(MODID + ".block");
        }

        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(BlockRegistry.BLAST_FURNACE_BRICKS.get());
        }
    }

    public static class MiscTab extends CreativeModeTab {

        public MiscTab() {
            super(MODID + ".misc");
        }

        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.BLAST_FURNACE_BRICK.get());
        }
    }
}

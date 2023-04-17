package org.principlecreativity.boundary2.common.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.principlecreativity.boundary2.Main;
import org.principlecreativity.boundary2.common.block.ModBlock;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    //Buildings
    public static final RegistryObject<Block> BLAST_FURNACE_BRICKS;

    static {
        BLAST_FURNACE_BRICKS = registerModBlock("blast_furnace_bricks", BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 12.0F).requiresCorrectToolForDrops().sound(SoundType.STONE));
    }
    private static RegistryObject<Block> registerModBlock(String name, BlockBehaviour.Properties p){
        return BLOCKS.register(name, () -> new ModBlock(p, name));
    }
}

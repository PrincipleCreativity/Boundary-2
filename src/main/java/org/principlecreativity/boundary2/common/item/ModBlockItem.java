package org.principlecreativity.boundary2.common.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.principlecreativity.boundary2.Main;

public class ModBlockItem extends BlockItem {
    public ModBlockItem(Block block) {
        super(block, new Properties().tab(Main.BLOCK_TAB));
    }
}

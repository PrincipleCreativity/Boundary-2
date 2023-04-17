package org.principlecreativity.boundary2.common.block;

import net.minecraft.world.level.block.Block;
import org.principlecreativity.boundary2.common.init.ItemRegistry;
import org.principlecreativity.boundary2.common.item.ModBlockItem;

public class ModBlock extends Block {
    public ModBlock(Properties properties, String name) {
        super(properties);
        ItemRegistry.ITEMS.register(name, () -> new ModBlockItem(this));
    }
}

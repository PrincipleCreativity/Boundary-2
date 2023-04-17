package org.principlecreativity.boundary2.common.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.principlecreativity.boundary2.common.init.ItemRegistry;

public class BasedBlock extends Block {
    public BasedBlock(Properties properties, Item.Properties itemProperties) {
        super(properties);
        ItemRegistry.ITEMS.register(this.getName().getString(), () -> new BlockItem(this, itemProperties));
    }
}

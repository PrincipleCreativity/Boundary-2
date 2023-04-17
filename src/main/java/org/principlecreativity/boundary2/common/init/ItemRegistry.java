package org.principlecreativity.boundary2.common.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.principlecreativity.boundary2.Main;
import org.principlecreativity.boundary2.common.item.ModMiscItem;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    //Misc Item
    public static final RegistryObject<Item> BLAST_FURNACE_BRICK;
    public static final RegistryObject<Item> COKE;
    public static final RegistryObject<Item> PIG_IRON_INGOT;
    public static final RegistryObject<Item> CARBON_STEEL_INGOT;
    public static final RegistryObject<Item> STEEL_INGOT;
    public static final RegistryObject<Item> EXCELLENT_STEEL_INGOT;
    public static final RegistryObject<Item> DARK_STEEL_INGOT;
    public static final RegistryObject<Item> ELECTRIC_STEEL_INGOT;
    public static final RegistryObject<Item> ELECTRIC_DARK_STEEL_INGOT;
    public static final RegistryObject<Item> NETHERITE_STEEL_INGOT;
    public static final RegistryObject<Item> ANCIENT_STEEL_INGOT;

    //combats


    //tools


    static {
        BLAST_FURNACE_BRICK = ITEMS.register("blast_furnace_brick", ModMiscItem::new);
        COKE = ITEMS.register("coke", ModMiscItem::new);
        PIG_IRON_INGOT = ITEMS.register("pig_iron_ingot", ModMiscItem::new);
        CARBON_STEEL_INGOT = ITEMS.register("carbon_steel_ingot", ModMiscItem::new);
        STEEL_INGOT = ITEMS.register("steel_ingot", ModMiscItem::new);
        EXCELLENT_STEEL_INGOT = ITEMS.register("excellent_steel_ingot", ModMiscItem::new);
        DARK_STEEL_INGOT = ITEMS.register("dark_steel_ingot", ModMiscItem::new);
        ELECTRIC_STEEL_INGOT = ITEMS.register("electric_steel_ingot", ModMiscItem::new);
        ELECTRIC_DARK_STEEL_INGOT = ITEMS.register("electric_dark_steel_ingot", ModMiscItem::new);
        NETHERITE_STEEL_INGOT = ITEMS.register("netherite_steel_ingot", ModMiscItem::new);
        ANCIENT_STEEL_INGOT = ITEMS.register("ancient_steel_ingot", ModMiscItem::new);
    }
}

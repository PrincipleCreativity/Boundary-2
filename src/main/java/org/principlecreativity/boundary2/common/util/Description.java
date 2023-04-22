package org.principlecreativity.boundary2.common.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import org.principlecreativity.boundary2.common.interfaces.Material;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Description{
    private static final Map<Integer, String> LEVELS = new HashMap<>();
    private final Material material;
    private final String descriptionKey;
    public Description (Material material, String descriptionKey){
        this.material = material;
        this.descriptionKey = descriptionKey;
    }

    public void init(List<Component> components){
        components.add(Component.translatable("desc.boundary2.attributes").withStyle(Style.EMPTY.withBold(true).withUnderlined(true).withColor(ChatFormatting.RED)));
        components.add(Component.translatable("desc.boundary2.uses", material.getUses()).withStyle(ChatFormatting.DARK_GREEN, ChatFormatting.GREEN));
        components.add(Component.translatable("desc.boundary2.level", this.getLevel()).withStyle(ChatFormatting.YELLOW, ChatFormatting.GOLD));
        components.add(Component.translatable(descriptionKey).withStyle(ChatFormatting.GRAY));

        LEVELS.put(0, "Wood/Gold");
        LEVELS.put(1, "Stone");
        LEVELS.put(2, "Iron");
        LEVELS.put(3, "Diamond");
        LEVELS.put(4, "Netherite");
    }


    @SuppressWarnings("deprecation")
    private String getLevel(){
        for(Map.Entry<Integer, String> entry: LEVELS.entrySet()) {
            if (this.material.getLevel() == entry.getKey()) {
                return entry.getValue();
            }
        }
        return "Unknown";
    }

    public static void addLevel(int level, String name){
        LEVELS.put(level, name);
    }
}

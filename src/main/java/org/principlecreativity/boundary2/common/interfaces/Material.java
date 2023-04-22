package org.principlecreativity.boundary2.common.interfaces;

import net.minecraft.world.item.Tier;
import org.principlecreativity.boundary2.common.util.Ability;

public interface Material extends Tier {
    Ability getAbility();
}

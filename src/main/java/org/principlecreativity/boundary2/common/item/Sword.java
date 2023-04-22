package org.principlecreativity.boundary2.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.principlecreativity.boundary2.common.interfaces.Describable;
import org.principlecreativity.boundary2.common.interfaces.Material;
import org.principlecreativity.boundary2.common.util.Ability;

import java.util.List;

public abstract class Sword extends SwordItem implements Describable {
    private final Material material;
    public Sword(Material material, int attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
        this.material = material;
    }

    public abstract boolean attack(Player player, Entity entity);

    public abstract void abilityUse(Level world, Player player, Ability ability);

    public abstract void abilityRelease(Level world, LivingEntity entity, Ability ability);

    /**
     *Use the attack
     */
    @Override
    @Deprecated
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        return attack(player, entity);
    }

    /**
     *Use the abilityUse
     */
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        abilityUse(world, player, material.getAbility());
        return InteractionResultHolder.success(new ItemStack(this));
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return this.material.getAbility().getAnim();
    }

    @Override
    public void releaseUsing(@NotNull ItemStack stack, @NotNull Level world, @NotNull LivingEntity entity, int p_41415_) {
        abilityRelease(world, entity, this.material.getAbility());
        super.releaseUsing(stack, world, entity, p_41415_);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level world, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        getDesc().init(components);
        super.appendHoverText(stack, world, components, flag);
    }
}

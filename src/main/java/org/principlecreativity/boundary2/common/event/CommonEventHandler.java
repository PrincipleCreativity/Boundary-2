package org.principlecreativity.boundary2.common.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.principlecreativity.boundary2.common.util.DamageSources;
import org.principlecreativity.boundary2.common.util.ModTimer;

import java.util.Comparator;

@Mod.EventBusSubscriber
public class CommonEventHandler {
    @SubscribeEvent
    public static void onEntityStruckByLightning(EntityStruckByLightningEvent event) {
        shock(event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
    }


    private static void shock(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity entity1) {
            entity1.hurt(DamageSources.ELECTRIC_SHOCK.bypassArmor(), 3);
        }
        if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.WATER) {
            LivingEntity entities = world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().min(new Object() {
                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                    return Comparator.comparingDouble(entcnd -> entcnd.distanceToSqr(_x, _y, _z));
                }
            }.compareDistOf(x, y, z)).orElse(null);
            if (entities != null) {
                if (entities.isInWaterRainOrBubble() ){
                    hurt(entities);
                }
            }
        }
    }

    private static void hurt(LivingEntity entity){
        ModTimer ti = new ModTimer();
        final boolean[] recover = {false};
        ti.schedule(() -> recover[0] = true, 9000);
        if(!recover[0]){
            ti.schedule(() -> entity.hurt(DamageSources.ELECTRIC_SHOCK.bypassArmor(), 5), 3000, 3000);
        }
    }
}

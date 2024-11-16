package icu.hakuchya.idk.Effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class Fracture extends MobEffect {

    public Fracture(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {


        if (!entity.level().isClientSide) {
            // 获取玩家的移动速度属性
            var movementSpeedAttribute = entity.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED);
            if (movementSpeedAttribute != null) {
                final String UUID_KEY = "fracture_slowdown";
                var modifier = movementSpeedAttribute.getModifier(java.util.UUID.fromString("11111111-1111-1111-1111-111111111111"));

                if (modifier == null) {
                    // 添加缓慢 III 修正：减少 60% 移动速度
                    movementSpeedAttribute.addTransientModifier(
                            new net.minecraft.world.entity.ai.attributes.AttributeModifier(
                                    java.util.UUID.fromString("11111111-1111-1111-1111-111111111111"),
                                    "Fracture Slowdown",
                                    -0.6, // 减速比例，缓慢 III 减少 60% 移动速度
                                    net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.MULTIPLY_TOTAL
                            )
                    );
                }
            }
        }
    }
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Buff 持续生效，每秒检查
        return duration % 20 == 0;
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int pAmplifier ) {
        // 获取实体的移动速度属性
        var movementSpeedAttribute = attributeMap.getInstance(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED);
        if (movementSpeedAttribute != null) {
            // 移除之前添加的缓慢效果修正
            movementSpeedAttribute.removeModifier(java.util.UUID.fromString("11111111-1111-1111-1111-111111111111"));
        }
        super.removeAttributeModifiers(entity, attributeMap, pAmplifier);
    }
}

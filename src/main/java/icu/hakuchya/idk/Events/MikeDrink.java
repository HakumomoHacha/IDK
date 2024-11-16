package icu.hakuchya.idk.Events;

import icu.hakuchya.idk.Effects.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MikeDrink {
    public MikeDrink(){

    }

    @SubscribeEvent
    public void onMilkDrink(LivingEntityUseItemEvent.Finish event) {
        // 检查玩家是否喝了牛奶
        if (event.getItem().is(Items.MILK_BUCKET)) {
            LivingEntity entity = event.getEntity();
            if (entity != null) {
                // 重新添加自定义 Buff
                entity.addEffect(new MobEffectInstance(
                        ModEffects.FRACTURE.get(),
                        200, // Buff 持续时间
                        0,   // 等级
                        false, // 是否为环境效果
                        true   // 是否显示粒子效果
                ));
            }
        }
    }
}

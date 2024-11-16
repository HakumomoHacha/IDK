package icu.hakuchya.idk.Events;

import icu.hakuchya.idk.Effects.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FallDamage {
    @SubscribeEvent
    public void onPlayerFallDamage(LivingHurtEvent event) {
        // 确保是玩家
        if (!(event.getEntity() instanceof Player player)) return;

        // 检查伤害类型是否为摔落
        if ("fall".equals(event.getSource().getMsgId())) {
            // 检查摔落伤害是否大于 6
            if (event.getAmount() > 6.0f) {
                // 添加缓慢效果（缓慢 II，时长无限）
                MobEffectInstance fractureEffect = new MobEffectInstance(ModEffects.FRACTURE.get(), Integer.MAX_VALUE, 1, false, false);
                player.addEffect(fractureEffect);
                //验证
                System.out.println("玩家受到摔落伤害 > 6，添加缓慢效果！");
            }
        }
    }
}

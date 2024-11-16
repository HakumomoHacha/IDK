package icu.hakuchya.idk.Effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "idk");

    public static final RegistryObject<MobEffect> FRACTURE = EFFECTS.register("fracture",
            () -> new Fracture(MobEffectCategory.BENEFICIAL, 0xFF0000)); // Buff 的颜色为绿色
}

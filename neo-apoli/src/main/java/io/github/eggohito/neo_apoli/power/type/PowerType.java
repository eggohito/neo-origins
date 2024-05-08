package io.github.eggohito.neo_apoli.power.type;

import com.mojang.serialization.MapCodec;
import io.github.eggohito.neo_apoli.power.Power;
import io.github.eggohito.neo_apoli.registry.NeoApoliRegistries;
import io.github.eggohito.neo_calio.data.Configuration;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.ApiStatus;

public abstract class PowerType {

    public static final MapCodec<PowerType> DISPATCH_CODEC = NeoApoliRegistries.POWER_TYPE
        .getCodec()
        .dispatchMap("type", PowerType::configuration, Configuration::mapCodec);

    private LivingEntity holder;
    private Power power;

    @ApiStatus.Internal
    public final void init(LivingEntity holder, Power power) {
        this.holder = holder;
        this.power = power;
    }

    public final LivingEntity holder() {
        return holder;
    }

    public final Power power() {
        return power;
    }

    public abstract Configuration<? extends PowerType> configuration();

}

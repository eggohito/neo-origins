package io.github.eggohito.neo_apoli.power.type;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.eggohito.neo_apoli.content.NeoApoliPowerTypes;
import io.github.eggohito.neo_apoli.power.Power;
import io.github.eggohito.neo_calio.data.Factory;
import net.minecraft.util.Identifier;

import java.util.Map;

public class MultiplePowerType extends PowerType {

    public static final MapCodec<PowerType> NON_RECURSIVE_DISPATCH_CODEC = PowerType.DISPATCH_CODEC.flatXmap(
        powerType -> powerType instanceof MultiplePowerType
            ? DataResult.error(() -> "Usage of the 'multiple' power type within a power that uses the 'multiple' power type is not allowed!")
            : DataResult.success(powerType),
        DataResult::success
    );
    public static final MapCodec<MultiplePowerType> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
        Codec.unboundedMap(Identifier.CODEC, Power.SUB_CODEC).fieldOf("subpowers").forGetter(MultiplePowerType::subPowers)
    ).apply(instance, MultiplePowerType::new));

    private final Map<Identifier, Power> subPowers;

    public MultiplePowerType(Map<Identifier, Power> subPowers) {
        this.subPowers = ImmutableMap.copyOf(subPowers);
    }

    public Map<Identifier, Power> subPowers() {
        return subPowers;
    }

    @Override
    public Factory<? extends PowerType> factory() {
        return NeoApoliPowerTypes.MULTIPLE;
    }

}

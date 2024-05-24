package io.github.eggohito.neo_apoli.power.type;

import com.mojang.serialization.MapCodec;
import io.github.eggohito.neo_apoli.content.NeoApoliPowerTypes;
import io.github.eggohito.neo_calio.data.Factory;

public class DummyPowerType extends PowerType {

    public static final MapCodec<DummyPowerType> CODEC = MapCodec.unit(DummyPowerType::new);

    @Override
    public Factory<? extends PowerType> factory() {
        return NeoApoliPowerTypes.DUMMY;
    }

}

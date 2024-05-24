package io.github.eggohito.neo_calio.data;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.Identifier;

public record Factory<T>(Identifier id, MapCodec<T> mapCodec) {

}

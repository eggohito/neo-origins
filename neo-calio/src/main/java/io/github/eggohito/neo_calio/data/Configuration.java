package io.github.eggohito.neo_calio.data;

import com.mojang.serialization.MapCodec;

public record Configuration<T>(MapCodec<T> mapCodec) {

}

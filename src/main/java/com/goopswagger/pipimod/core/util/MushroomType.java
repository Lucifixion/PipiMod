package com.goopswagger.pipimod.core.util;

import net.minecraft.util.DyeColor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

public enum MushroomType {

    ORANGE(0, "orange");

//    private static final IntFunction<MushroomType> BY_ID = ValueLists.createIdToValueFunction(MushroomType::getId, values(), ValueLists.OutOfBoundsHandling.ZERO);

    private static final MushroomType[] VALUES = Arrays.stream(values()).sorted(Comparator.comparingInt(MushroomType::getId)).toArray(MushroomType[]::new);

    private final int id;
    private final String name;

    MushroomType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

//    public static MushroomType byId(int id) {
//        return BY_ID.apply(id);
//    }

    public static MushroomType byId(int id) {
        if (id < 0 || id >= VALUES.length) {
            id = 0;
        }

        return VALUES[id];
    }

}

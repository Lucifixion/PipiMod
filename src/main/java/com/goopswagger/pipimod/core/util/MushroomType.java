package com.goopswagger.pipimod.core.util;

import net.minecraft.util.function.ValueLists;

import java.util.function.IntFunction;

public enum MushroomType {

    ORANGE(0, "orange");

    private static final IntFunction<MushroomType> BY_ID = ValueLists.createIdToValueFunction(MushroomType::getId, values(), ValueLists.OutOfBoundsHandling.ZERO);

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

    public static MushroomType byId(int id) {
        return BY_ID.apply(id);
    }

}

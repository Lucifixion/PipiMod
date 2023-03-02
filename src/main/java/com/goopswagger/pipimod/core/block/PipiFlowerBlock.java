package com.goopswagger.pipimod.core.block;

import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.DyeColor;

import java.util.HashMap;

public class PipiFlowerBlock extends FlowerBlock {

    public static HashMap<DyeColor, PipiFlowerBlock> DYE_COLOR_TO_FLOWER = new HashMap<>();

    public final DyeColor dyeColor;

    public PipiFlowerBlock(StatusEffect suspiciousStewEffect, int effectDuration, DyeColor color, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
        DYE_COLOR_TO_FLOWER.put(color, this);
        this.dyeColor = color;
    }

}

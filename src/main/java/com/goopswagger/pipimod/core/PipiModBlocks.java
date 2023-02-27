package com.goopswagger.pipimod.core;

import com.goopswagger.pipimod.PipiMod;
import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PipiModBlocks {

    public static Block PINK_DAISY = new FlowerBlock(StatusEffects.ABSORPTION, 45, FabricBlockSettings.copyOf(Blocks.DANDELION));

    public static void init() {
        Registry.register(Registries.BLOCK, new Identifier(PipiMod.MODID, "pink_daisy"), PINK_DAISY);
        Registry.register(Registries.ITEM, new Identifier(PipiMod.MODID, "pink_daisy"), new BlockItem(PINK_DAISY, new FabricItemSettings().equipmentSlot(stack -> EquipmentSlot.HEAD)));
    }

}

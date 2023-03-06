package com.goopswagger.pipimod.core;

import com.goopswagger.pipimod.PipiMod;
import com.goopswagger.pipimod.core.block.PipiFlowerBlock;
import com.goopswagger.pipimod.core.block.PipiMushroomBlock;
import com.goopswagger.pipimod.core.util.MushroomType;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class PipiModBlocks {

    public static FlowerBlock WHITE_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.WHITE, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock ORANGE_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.ORANGE, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock MAGENTA_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.MAGENTA, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock LIGHT_BLUE_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.LIGHT_BLUE, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock YELLOW_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.YELLOW, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock LIME_DAISY = new PipiFlowerBlock(StatusEffects.LUCK, 20, DyeColor.LIME, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock PINK_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.PINK, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock GRAY_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.GRAY, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock LIGHT_GRAY_DAISY = new PipiFlowerBlock(StatusEffects.LUCK, 20, DyeColor.LIGHT_GRAY, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock CYAN_DAISY = new PipiFlowerBlock(StatusEffects.LUCK, 20, DyeColor.CYAN, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock PURPLE_DAISY = new PipiFlowerBlock(StatusEffects.LUCK, 20, DyeColor.PURPLE, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock BLUE_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.BLUE, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock BROWN_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.BROWN, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock GREEN_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.GREEN, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock RED_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.RED, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerBlock BLACK_DAISY = new PipiFlowerBlock(StatusEffects.REGENERATION, 20, DyeColor.BLACK, FabricBlockSettings.copyOf(Blocks.DANDELION));

    public static FlowerPotBlock POTTED_WHITE_DAISY = new FlowerPotBlock(WHITE_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_ORANGE_DAISY = new FlowerPotBlock(ORANGE_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_MAGENTA_DAISY = new FlowerPotBlock(MAGENTA_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_LIGHT_BLUE_DAISY = new FlowerPotBlock(LIGHT_BLUE_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_YELLOW_DAISY = new FlowerPotBlock(YELLOW_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_LIME_DAISY = new FlowerPotBlock(LIME_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_PINK_DAISY = new FlowerPotBlock(PINK_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_GRAY_DAISY = new FlowerPotBlock(GRAY_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_LIGHT_GRAY_DAISY = new FlowerPotBlock(LIGHT_GRAY_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_CYAN_DAISY = new FlowerPotBlock(CYAN_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_PURPLE_DAISY = new FlowerPotBlock(PURPLE_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_BLUE_DAISY = new FlowerPotBlock(BLUE_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_BROWN_DAISY = new FlowerPotBlock(BROWN_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_GREEN_DAISY = new FlowerPotBlock(GREEN_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_RED_DAISY = new FlowerPotBlock(RED_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));
    public static FlowerPotBlock POTTED_BLACK_DAISY = new FlowerPotBlock(BLACK_DAISY, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));

    public static FlowerBlock ORANGE_MUSHROOM = new PipiMushroomBlock(StatusEffects.REGENERATION, 20, MushroomType.ORANGE, FabricBlockSettings.copyOf(Blocks.DANDELION));
    public static FlowerPotBlock POTTED_ORANGE_MUSHROOM = new FlowerPotBlock(ORANGE_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION));

    public static void init() {
        registerFlower(new Identifier(PipiMod.MODID, "white_daisy"), WHITE_DAISY, POTTED_WHITE_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "orange_daisy"), ORANGE_DAISY, POTTED_ORANGE_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "magenta_daisy"), MAGENTA_DAISY, POTTED_MAGENTA_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "light_blue_daisy"), LIGHT_BLUE_DAISY, POTTED_LIGHT_BLUE_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "yellow_daisy"), YELLOW_DAISY, POTTED_YELLOW_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "lime_daisy"), LIME_DAISY, POTTED_LIME_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "pink_daisy"), PINK_DAISY, POTTED_PINK_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "gray_daisy"), GRAY_DAISY, POTTED_GRAY_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "light_gray_daisy"), LIGHT_GRAY_DAISY, POTTED_LIGHT_GRAY_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "cyan_daisy"), CYAN_DAISY, POTTED_CYAN_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "purple_daisy"), PURPLE_DAISY, POTTED_PURPLE_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "blue_daisy"), BLUE_DAISY, POTTED_BLUE_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "brown_daisy"), BROWN_DAISY, POTTED_BROWN_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "green_daisy"), GREEN_DAISY, POTTED_GREEN_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "red_daisy"), RED_DAISY, POTTED_RED_DAISY);
        registerFlower(new Identifier(PipiMod.MODID, "black_daisy"), BLACK_DAISY, POTTED_BLACK_DAISY);

        registerMushroom(new Identifier(PipiMod.MODID, "orange_mushroom"), ORANGE_MUSHROOM, POTTED_ORANGE_MUSHROOM);
    }

    private static void registerFlower(Identifier identifier, FlowerBlock flowerBlock, FlowerPotBlock flowerPotBlock) {
        Registry.register(Registries.BLOCK, identifier, flowerBlock);
        Registry.register(Registries.ITEM, identifier, new BlockItem(flowerBlock, new FabricItemSettings().equipmentSlot(stack -> EquipmentSlot.HEAD)));
        Registry.register(Registries.BLOCK, new Identifier(identifier.getNamespace(), "potted_" + identifier.getPath()), flowerPotBlock);
    }

    private static void registerMushroom(Identifier identifier, FlowerBlock flowerBlock, FlowerPotBlock flowerPotBlock) {
        Registry.register(Registries.BLOCK, identifier, flowerBlock);
        Registry.register(Registries.ITEM, identifier, new BlockItem(flowerBlock, new FabricItemSettings().food((new FoodComponent.Builder()).hunger(2).saturationModifier(0.1F).snack().build()).equipmentSlot(stack -> EquipmentSlot.HEAD)));
        Registry.register(Registries.BLOCK, new Identifier(identifier.getNamespace(), "potted_" + identifier.getPath()), flowerPotBlock);
    }

}

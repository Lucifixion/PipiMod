package com.goopswagger.pipimod.core;

import com.goopswagger.pipimod.PipiMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PipiModItems {

    public static SpawnEggItem PIPI_SPAWN_EGG = new SpawnEggItem(PipiModEntities.PIPI, 6505260, 8372053, new FabricItemSettings().maxCount(16));
    public static SpawnEggItem MUSHROOM_PIPI_SPAWN_EGG = new SpawnEggItem(PipiModEntities.MUSHROOM_PIPI, 16711680, 16777215, new FabricItemSettings().maxCount(16));

    public static void init() {
        Registry.register(Registries.ITEM, new Identifier(PipiMod.MODID, "pipi_spawn_egg"), PIPI_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(PipiMod.MODID, "mushroom_pipi_spawn_egg"), MUSHROOM_PIPI_SPAWN_EGG);
    }
}

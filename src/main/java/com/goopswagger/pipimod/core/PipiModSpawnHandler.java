package com.goopswagger.pipimod.core;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.tag.BiomeTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;

import java.util.function.Predicate;

public class PipiModSpawnHandler { // i took this from https://github.com/KaiAF/ottahmod/blob/1.19.3/src/main/java/net/livzmc/ottah/gen/OtterSpawn.java i just really couldnt do it

    public static void init() {
        registerSpawn(tag(BiomeTags.IS_FOREST).and(BiomeSelectors.foundInOverworld()), PipiModEntities.PIPI.getSpawnGroup(), new SpawnSettings.SpawnEntry(PipiModEntities.PIPI, 6, 2, 2));
        registerSpawn(BiomeSelectors.includeByKey(BiomeKeys.MUSHROOM_FIELDS), PipiModEntities.MUSHROOM_PIPI.getSpawnGroup(), new SpawnSettings.SpawnEntry(PipiModEntities.MUSHROOM_PIPI, 6, 2, 2));
    }

    public static void registerSpawn(Predicate<BiomeSelectionContext> biomeSelector, SpawnGroup spawnGroup, SpawnSettings.SpawnEntry se) {
        BiomeModifications.create(Registry.ENTITY_TYPE.getId(se.type)).add(ModificationPhase.ADDITIONS, biomeSelector, context -> context.getSpawnSettings().addSpawn(spawnGroup, se));
    }

    private static Predicate<BiomeSelectionContext> tag(TagKey<Biome> tag) {
        return BiomeSelectors.tag(tag);
    }
}
package com.goopswagger.pipimod.core;

import com.goopswagger.pipimod.PipiMod;
import com.goopswagger.pipimod.core.entity.PipiEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PipiModEntities {

    public static final EntityType<PipiEntity> PIPI = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(PipiMod.MODID, "pipi"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PipiEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static void init() {
        FabricDefaultAttributeRegistry.register(PIPI, PipiEntity.createMobAttributes());
    }

}

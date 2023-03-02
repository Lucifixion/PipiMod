package com.goopswagger.pipimod.core.entity;

import com.goopswagger.pipimod.core.PipiModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MushroomPipiEntity extends PipiEntity {
    public MushroomPipiEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Block getFlower() {
        return Blocks.RED_MUSHROOM;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        MushroomPipiEntity mushroomPipiEntity = PipiModEntities.MUSHROOM_PIPI.create(world);
        mushroomPipiEntity.setBaby(true);
        return mushroomPipiEntity;
    }
}

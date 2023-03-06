package com.goopswagger.pipimod.core.entity;

import com.goopswagger.pipimod.core.block.PipiMushroomBlock;
import com.goopswagger.pipimod.core.util.MushroomType;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public class MushroomPipiEntity extends PipiEntity {
    public MushroomPipiEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    private static final TrackedData<Byte> MUSHROOM = DataTracker.registerData(MushroomPipiEntity.class, TrackedDataHandlerRegistry.BYTE);

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(MUSHROOM, ((byte) 0));
    }

    public void setMushroomType(MushroomType type) {
        this.dataTracker.set(MUSHROOM, ((byte) type.getId()));
    }

    public MushroomType getMushroomType() {
        return MushroomType.byId(this.dataTracker.get(MUSHROOM));
    }

    @Override
    public Block getFlower() {
        return PipiMushroomBlock.MUSHROOM_TYPE_TO_MUSHROOM.get(this.getMushroomType());
    }
}

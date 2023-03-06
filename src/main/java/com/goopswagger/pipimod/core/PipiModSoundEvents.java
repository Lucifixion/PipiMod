package com.goopswagger.pipimod.core;

import com.goopswagger.pipimod.PipiMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class PipiModSoundEvents {

    public static SoundEvent ENTITY_PIPI_AMBIENT = SoundEvent.of(Identifier.of(PipiMod.MODID, "entity.pipi.ambient"));
    public static SoundEvent ENTITY_PIPI_HURT = SoundEvent.of(Identifier.of(PipiMod.MODID, "entity.pipi.hurt"));

}

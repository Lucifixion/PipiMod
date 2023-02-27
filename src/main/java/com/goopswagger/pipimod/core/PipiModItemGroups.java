package com.goopswagger.pipimod.core;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class PipiModItemGroups {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> content.addAfter(Items.LILY_OF_THE_VALLEY, PipiModBlocks.PINK_DAISY));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.addAfter(Items.PILLAGER_SPAWN_EGG, PipiModItems.PIPI_SPAWN_EGG));
    }

}

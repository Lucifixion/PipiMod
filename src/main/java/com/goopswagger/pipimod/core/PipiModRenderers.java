package com.goopswagger.pipimod.core;

import com.goopswagger.pipimod.PipiMod;
import com.goopswagger.pipimod.core.entity.model.PipiEntityModel;
import com.goopswagger.pipimod.core.entity.render.MushroomPipiEntityRenderer;
import com.goopswagger.pipimod.core.entity.render.PipiEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class PipiModRenderers {

    public static final EntityModelLayer MODEL_PIPI_LAYER = new EntityModelLayer(new Identifier(PipiMod.MODID, "pipi"), "main");
    public static final EntityModelLayer MODEL_MUSHROOM_PIPI_LAYER = new EntityModelLayer(new Identifier(PipiMod.MODID, "mushroom_pipi"), "main");

    public static void init() {
        EntityRendererRegistry.register(PipiModEntities.PIPI, PipiEntityRenderer::new);
        EntityRendererRegistry.register(PipiModEntities.MUSHROOM_PIPI, MushroomPipiEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_PIPI_LAYER, PipiEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_MUSHROOM_PIPI_LAYER, PipiEntityModel::getTexturedModelData);
    }

}

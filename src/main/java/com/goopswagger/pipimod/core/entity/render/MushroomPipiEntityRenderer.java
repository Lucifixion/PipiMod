package com.goopswagger.pipimod.core.entity.render;

import com.goopswagger.pipimod.PipiMod;
import com.goopswagger.pipimod.core.PipiModRenderers;
import com.goopswagger.pipimod.core.entity.MushroomPipiEntity;
import com.goopswagger.pipimod.core.entity.model.MushroomPipiEntityModel;
import com.goopswagger.pipimod.core.entity.render.feature.PipiFlowerFeatureRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MushroomPipiEntityRenderer extends MobEntityRenderer<MushroomPipiEntity, MushroomPipiEntityModel<MushroomPipiEntity>> {

    public MushroomPipiEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new MushroomPipiEntityModel(context.getPart(PipiModRenderers.MODEL_MUSHROOM_PIPI_LAYER)), 0.5f);
        this.addFeature(new PipiFlowerFeatureRenderer(this, context.getBlockRenderManager()));
    }

    @Override
    public Identifier getTexture(MushroomPipiEntity entity) {
        return new Identifier(PipiMod.MODID, "textures/entity/pipi/mushroom_pipi.png");
    }
}

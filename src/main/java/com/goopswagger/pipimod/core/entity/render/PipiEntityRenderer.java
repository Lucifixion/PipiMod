package com.goopswagger.pipimod.core.entity.render;

import com.goopswagger.pipimod.PipiMod;
import com.goopswagger.pipimod.core.PipiModRenderers;
import com.goopswagger.pipimod.core.entity.PipiEntity;
import com.goopswagger.pipimod.core.entity.model.PipiEntityModel;
import com.goopswagger.pipimod.core.entity.render.feature.PipiFlowerFeatureRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PipiEntityRenderer extends MobEntityRenderer<PipiEntity, PipiEntityModel<PipiEntity>> {

    public PipiEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PipiEntityModel(context.getPart(PipiModRenderers.MODEL_PIPI_LAYER)), 0.5f);
        this.addFeature(new PipiFlowerFeatureRenderer(this, context.getBlockRenderManager()));
    }

    @Override
    public Identifier getTexture(PipiEntity entity) {
        return new Identifier(PipiMod.MODID, "textures/entity/pipi/pipi.png");
    }
}

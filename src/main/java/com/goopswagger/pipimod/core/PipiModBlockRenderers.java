package com.goopswagger.pipimod.core;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class PipiModBlockRenderers {

    public static void init() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PipiModBlocks.PINK_DAISY);
    }

}

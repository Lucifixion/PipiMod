package com.goopswagger.pipimod.core.entity.render.feature;

import com.goopswagger.pipimod.core.PipiModBlocks;
import com.goopswagger.pipimod.core.entity.PipiEntity;
import com.goopswagger.pipimod.core.entity.model.PipiEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class PipiFlowerFeatureRenderer<T extends PipiEntity> extends FeatureRenderer<T, PipiEntityModel<T>> {
    private final BlockRenderManager blockRenderManager;

    public PipiFlowerFeatureRenderer(FeatureRendererContext<T, PipiEntityModel<T>> context, BlockRenderManager blockRenderManager) {
        super(context);
        this.blockRenderManager = blockRenderManager;
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T pipiEntity, float f, float g, float h, float j, float k, float l) {
        if (pipiEntity.hasFlower()) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            boolean bl = minecraftClient.hasOutline(pipiEntity) && pipiEntity.isInvisible();
            if (!pipiEntity.isInvisible() || bl) {
                BlockState blockState = PipiModBlocks.PINK_DAISY.getDefaultState();
                int m = LivingEntityRenderer.getOverlay(pipiEntity, 0.0F);
                BakedModel bakedModel = this.blockRenderManager.getModel(blockState);
                matrixStack.push();
                this.getContextModel().getHead().rotate(matrixStack);
                matrixStack.translate(0.0F, -0.7F, 0.0F);
                matrixStack.scale(-1.0F, -1.0F, 1.0F);
                matrixStack.translate(-0.5F, -0.5F, -0.5F);
                this.renderFlower(matrixStack, vertexConsumerProvider, i, bl, blockState, m, bakedModel);
                matrixStack.pop();
            }
        }
    }

    private void renderFlower(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, boolean renderAsModel, BlockState flowerState, int overlay, BakedModel flowerModel) {
        if (renderAsModel) {
            this.blockRenderManager.getModelRenderer().render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getOutline(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE)), flowerState, flowerModel, 0.0F, 0.0F, 0.0F, light, overlay);
        } else {
            this.blockRenderManager.renderBlockAsEntity(flowerState, matrices, vertexConsumers, light, overlay);
        }

    }
}

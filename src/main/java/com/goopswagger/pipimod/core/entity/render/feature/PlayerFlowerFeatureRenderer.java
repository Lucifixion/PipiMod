package com.goopswagger.pipimod.core.entity.render.feature;

import com.goopswagger.pipimod.core.PipiModBlocks;
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
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class PlayerFlowerFeatureRenderer<T extends PlayerEntity> extends FeatureRenderer<T, PlayerEntityModel<T>> {
    private final BlockRenderManager blockRenderManager;

    public PlayerFlowerFeatureRenderer(FeatureRendererContext<T, PlayerEntityModel<T>> context, BlockRenderManager blockRenderManager) {
        super(context);
        this.blockRenderManager = blockRenderManager;
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T playerEntity, float f, float g, float h, float j, float k, float l) {
        ItemStack itemStack = playerEntity.getEquippedStack(EquipmentSlot.HEAD);
        if (!(itemStack.isEmpty()) && (itemStack.getItem() == PipiModBlocks.PINK_DAISY.asItem())) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            boolean bl = minecraftClient.hasOutline(playerEntity) && playerEntity.isInvisible();
            if (!playerEntity.isInvisible() || bl) {
                BlockState blockState = PipiModBlocks.PINK_DAISY.getDefaultState();
                int m = LivingEntityRenderer.getOverlay(playerEntity, 0.0F);
                BakedModel bakedModel = this.blockRenderManager.getModel(blockState);
                matrixStack.push();
                this.getContextModel().getHead().rotate(matrixStack);
                matrixStack.translate(0.0F, -1.0F, 0.0F);
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-78.0F));
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

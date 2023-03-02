package com.goopswagger.pipimod.core.entity.model;

import com.goopswagger.pipimod.core.entity.PipiEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class PipiEntityModel<T extends PipiEntity> extends EntityModel<T> {
    private final ModelPart front_right_leg;
    private final ModelPart back_right_leg;
    private final ModelPart head;
    private final ModelPart front_left_leg;
    private final ModelPart back_left_leg;

    private float jumpProgress;

    public PipiEntityModel(ModelPart root) {
        this.front_right_leg = root.getChild("front_right_leg");
        this.back_right_leg = root.getChild("back_right_leg");
        this.head = root.getChild("head");
        this.front_left_leg = root.getChild("front_left_leg");
        this.back_left_leg = root.getChild("back_left_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData front_right_leg = modelPartData.addChild("front_right_leg", ModelPartBuilder.create().uv(0, 20).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.5F, 20.0F, -3.0F));
        ModelPartData back_right_leg = modelPartData.addChild("back_right_leg", ModelPartBuilder.create().uv(36, 20).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.5F, 20.0F, 4.0F));
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -4.0F, -6.0F, 16.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, 0.5F));
        ModelPartData front_left_leg = modelPartData.addChild("front_left_leg", ModelPartBuilder.create().uv(12, 20).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(4.5F, 20.0F, -3.0F));
        ModelPartData back_left_leg = modelPartData.addChild("back_left_leg", ModelPartBuilder.create().uv(24, 20).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(5.5F, 20.0F, 4.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        if (this.child) {
            matrices.push();
            matrices.scale(0.56666666F, 0.56666666F, 0.56666666F);
            matrices.translate(0.0F, 1.20F, 0.0F);
            front_right_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            front_left_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            back_right_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            back_left_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            matrices.pop();
        } else {
            front_right_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            front_left_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            back_right_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            back_left_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
            head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        }
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
//        if (entity.getFrolicing()) {
//            float tickDelta = animationProgress - (float)entity.age;
//            this.jumpProgress = MathHelper.sin(entity.getJumpProgress(tickDelta) * 3.1415927F);
//            this.front_right_leg.pitch = -(this.jumpProgress * 50.0F * 0.017453292F);
//            this.front_left_leg.pitch = -(this.jumpProgress * 50.0F * 0.017453292F);
//            this.back_right_leg.pitch = this.jumpProgress * 50.0F * 0.017453292F;
//            this.back_left_leg.pitch = this.jumpProgress * 50.0F * 0.017453292F;
//        } else {
            this.back_right_leg.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
            this.back_left_leg.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
            this.front_right_leg.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
            this.front_left_leg.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
//        }
    }

    public ModelPart getHead() {
        return head;
    }
}

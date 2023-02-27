package com.goopswagger.pipimod.core.entity.model;

import com.goopswagger.pipimod.core.entity.PipiEntity;
import net.minecraft.client.render.entity.model.EntityModel;

import com.google.common.collect.ImmutableList;
import com.goopswagger.pipimod.core.entity.PipiEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class PipiEntityModelNew extends EntityModel<PipiEntity> {
	private final ModelPart frontLegs;
	private final ModelPart backLegs;
	private final ModelPart head;
//	private final ModelPart flower2_r1;
//	private final ModelPart flower1_r1;
	public PipiEntityModelNew(ModelPart root) {
		this.frontLegs = root.getChild("frontLegs");
		this.backLegs = root.getChild("backLegs");
		this.head = root.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData frontLegs = modelPartData.addChild("frontLegs", ModelPartBuilder.create().uv(0, 0).cuboid(3.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 19.0F, -4.0F));

		ModelPartData backLegs = modelPartData.addChild("backLegs", ModelPartBuilder.create().uv(0, 0).cuboid(4.0F, -5.0F, 2.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-6.0F, -5.0F, 2.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -3.0F, -5.5F, 16.0F, 6.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, -0.5F));

		ModelPartData flower2_r1 = head.addChild("flower2_r1", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -4.0F, -4.0F, 0.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, 0.5F, 0.0F, -2.3562F, 0.0F));

		ModelPartData flower1_r1 = head.addChild("flower1_r1", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -4.0F, -4.0F, 0.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, 0.5F, 0.0F, -0.7854F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(PipiEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		frontLegs.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		backLegs.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
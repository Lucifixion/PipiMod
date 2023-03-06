package com.goopswagger.pipimod.core.block;

import com.goopswagger.pipimod.core.PipiModEntities;
import com.goopswagger.pipimod.core.PipiModGamerules;
import com.goopswagger.pipimod.core.entity.MushroomPipiEntity;
import com.goopswagger.pipimod.core.util.MushroomType;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.HashMap;

public class PipiMushroomBlock extends FlowerBlock {

    public static final BooleanProperty GROWS = BooleanProperty.of("grows");
    public static final BooleanProperty READY_TO_GROW = BooleanProperty.of("ready_to_grow");

    public static HashMap<MushroomType, FlowerBlock> MUSHROOM_TYPE_TO_MUSHROOM = new HashMap<>();

    public final MushroomType type;

    public PipiMushroomBlock(StatusEffect suspiciousStewEffect, int effectDuration, MushroomType type, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
        MUSHROOM_TYPE_TO_MUSHROOM.put(type, this);
        this.type = type;
        this.setDefaultState(this.stateManager.getDefaultState().with(GROWS, true).with(READY_TO_GROW, false));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(GROWS, READY_TO_GROW);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.SHEARS)) {
            world.playSound(null, pos, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.PLAYERS, 1.0F, 1.0F);
            world.setBlockState(pos, state.with(GROWS, false), 3);
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.get(GROWS) || !world.getGameRules().getBoolean(PipiModGamerules.PIPI_FLOWERS_GROW))
            return;

        if (!state.get(READY_TO_GROW)) {
            world.setBlockState(pos, state.with(READY_TO_GROW, true), 3);
            return;
        }

        BlockPos blockBeneathPos = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
        if (world.getBlockState(blockBeneathPos).getBlock() instanceof GrassBlock) {
            world.breakBlock(pos, false);
            world.breakBlock(blockBeneathPos, false);
            world.setBlockState(blockBeneathPos, Blocks.DIRT.getDefaultState());
            MushroomPipiEntity pipiEntity = PipiModEntities.MUSHROOM_PIPI.create(world);
            pipiEntity.setMushroomType(this.type);
            pipiEntity.teleport(blockBeneathPos.getX()+0.5,pos.getY()+0.5,blockBeneathPos.getZ()+0.5);
            world.spawnEntity(pipiEntity);
        }
    }
}

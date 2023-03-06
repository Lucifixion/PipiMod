package com.goopswagger.pipimod.core;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class PipiModGamerules {

    public static final GameRules.Key<GameRules.BooleanRule> PIPI_FLOWERS_GROW = GameRuleRegistry.register("pipiFlowersGrow", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));

    public static void init() {}

}

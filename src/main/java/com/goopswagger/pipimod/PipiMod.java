package com.goopswagger.pipimod;

import com.goopswagger.pipimod.core.*;
import com.goopswagger.pipimod.core.block.PipiMushroomBlock;
import com.goopswagger.pipimod.core.util.MushroomType;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomPlantBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PipiMod implements ModInitializer {

	public static final String MODID = "pipimod";
	public static final Logger LOGGER = LoggerFactory.getLogger("PipiMod");

	@Override
	public void onInitialize() {
		LOGGER.info("Its pipi ing time");

		PipiModSpawnHandler.init();
		PipiModItems.init();
		PipiModBlocks.init();
		PipiModEntities.init();
		PipiModGamerules.init();
	}
}

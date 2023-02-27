package com.goopswagger.pipimod;

import com.goopswagger.pipimod.core.PipiModBlocks;
import com.goopswagger.pipimod.core.PipiModEntities;
import com.goopswagger.pipimod.core.PipiModItems;
import com.goopswagger.pipimod.core.entity.PipiEntity;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PipiMod implements ModInitializer {

	public static final String MODID = "pipimod";
	public static final Logger LOGGER = LoggerFactory.getLogger("PipiMod");

	@Override
	public void onInitialize() {
		LOGGER.info("Its pipi ing time");
		PipiModItems.init();
		PipiModBlocks.init();
		PipiModEntities.init();
	}
}

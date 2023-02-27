package com.goopswagger.pipimod;

import com.goopswagger.pipimod.core.PipiModBlockRenderers;
import com.goopswagger.pipimod.core.PipiModItemGroups;
import com.goopswagger.pipimod.core.PipiModRenderers;
import net.fabricmc.api.ClientModInitializer;

public class PipiModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PipiModItemGroups.init();
        PipiModBlockRenderers.init();
        PipiModRenderers.init();
    }
}

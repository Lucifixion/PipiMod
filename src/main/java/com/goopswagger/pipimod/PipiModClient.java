package com.goopswagger.pipimod;

import com.goopswagger.pipimod.core.PipiModRenderers;
import net.fabricmc.api.ClientModInitializer;

public class PipiModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PipiModRenderers.init();
    }
}

package org.liabri.tila;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.liabri.tila.screens.Screens;

@Environment(EnvType.CLIENT)
public class TilaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Screens.init();
    }
}

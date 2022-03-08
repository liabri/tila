package org.liabri.tila.screens;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import org.liabri.tila.screenhandlers.ScreenHandlers;

public class Screens {
    public static void init() {
        ScreenRegistry.register(ScreenHandlers.EASEL_SCREEN_HANDLER, EaselScreen::new);
    }
}

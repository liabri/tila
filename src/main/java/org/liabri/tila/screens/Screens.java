package org.liabri.tila.screens;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.registry.Registry;
import org.liabri.tila.screenhandlers.ScreenHandlers;

public class Screens {
    public static void init() {}

    static {
        ScreenRegistry.register(ScreenHandlers.EASEL_SCREEN_HANDLER, EaselScreen::new);
    }
}

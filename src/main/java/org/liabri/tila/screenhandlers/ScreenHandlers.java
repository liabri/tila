package org.liabri.tila.screenhandlers;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;

import static org.liabri.tila.Tila.id;

public class ScreenHandlers {
    public static void init() {}

    public static final ScreenHandlerType<EaselScreenHandler> EASEL_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(id("easel"), EaselScreenHandler::new);
}

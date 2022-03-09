package org.liabri.tila.paintings;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.registry.Registry;

public class Paintings {
    public static final PaintingMotive MALAKA = register("malaka", 16, 16);

    private static PaintingMotive register(String name, int width, int height) {
        return (PaintingMotive)Registry.register(Registry.PAINTING_MOTIVE, name, new PaintingMotive(width, height));
    }
}

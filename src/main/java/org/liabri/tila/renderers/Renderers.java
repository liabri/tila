package org.liabri.tila.renderers;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.liabri.tila.blocks.Blocks;

public class Renderers {
    public static void init() {}

    static {
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.EASEL.getLeft(), RenderLayer.getCutout());

    }
}

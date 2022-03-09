package org.liabri.tila.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import static org.liabri.tila.Tila.PAINTING_ITEM_GROUP;

public class PaintingItem extends Item {
    public PaintingItem() {
        super(new FabricItemSettings().group(PAINTING_ITEM_GROUP));
    }
}

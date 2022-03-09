package org.liabri.tila.items;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

import static org.liabri.tila.Tila.PAINTING_ITEM_GROUP;

public class CanvasItem extends Item {
    private final String SIZE;

    public CanvasItem(String size) {
        super(new FabricItemSettings().group(PAINTING_ITEM_GROUP));
        this.SIZE = size;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText(this.SIZE));
    }
}

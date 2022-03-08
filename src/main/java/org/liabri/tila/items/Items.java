package org.liabri.tila.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.liabri.tila.Tila;

public class Items {

    public static void init() {}

    public static Item register(String path, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Tila.MOD_ID, path), item);
    }

    public static BlockItem registerBlockItem(Block block, ItemGroup itemGroup) {
        BlockItem item = new BlockItem(block, new Item.Settings().group(itemGroup));
        item.appendBlocks(Item.BLOCK_ITEMS, item);
        return Registry.register(Registry.ITEM, Tila.id(Registry.BLOCK.getId(block).getPath()), item);
    }

    public static Item registerBlockItem(Block block, Item item) {
        return Registry.register(Registry.ITEM, Tila.id(Registry.BLOCK.getId(block).getPath()), item);
    }
}

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

    public static final Item TINY_SQUARE_CANVAS = register("tiny_square_canvas", new CanvasItem("1x1"));
    public static final Item SMALL_SQUARE_CANVAS = register("small_square_canvas", new CanvasItem("2x2"));
    public static final Item MEDIUM_SQUARE_CANVAS = register("medium_square_canvas", new CanvasItem("3x3"));
    public static final Item LARGE_SQUARE_CANVAS = register("large_square_canvas", new CanvasItem("4x4"));
    public static final Item TINY_RECTANGULAR_CANVAS = register("tiny_rectangular_canvas", new CanvasItem("1x2"));
    public static final Item SMALL_RECTANGULAR_CANVAS = register("small_rectangular_canvas", new CanvasItem("2x3"));
    public static final Item MEDIUM_RECTANGULAR_CANVAS = register("medium_rectangular_canvas", new CanvasItem("3x4"));

//    public static final Item MALAKA_PAINTING = register("malaka_painting", new PaintingItem("malaka", 16, 16));
}

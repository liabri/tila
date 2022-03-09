package org.liabri.tila.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;
import org.liabri.tila.Tila;
import org.liabri.tila.items.Items;

import static org.liabri.tila.Tila.PAINTING_ITEM_GROUP;

public class Blocks {
    public static void init() {}

    public static Block register(String path, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(Tila.MOD_ID, path), block);
    }

    public static Pair<Block, Item> register(String path, Block block, Item item) {
        return new Pair<>(Registry.register(Registry.BLOCK, new Identifier(Tila.MOD_ID, path), block), Items.registerBlockItem(block, item));
    }

    public static Pair<Block, Item> register(String path, Block block, ItemGroup itemGroup) {
        return new Pair<>(Registry.register(Registry.BLOCK, new Identifier(Tila.MOD_ID, path), block), Items.registerBlockItem(block, itemGroup));
    }

    public static final Pair<Block, Item> EASEL = (Pair<Block, Item>) register("easel", new EaselBlock(), PAINTING_ITEM_GROUP);
}

package org.liabri.tila.recipes;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.liabri.tila.Tila;

import java.util.ArrayList;

public class EaselRecipe implements Recipe<Inventory> {
    private final Identifier ID;

    private final Ingredient CANVAS;
    private final ArrayList<Ingredient> DYES;
    private final Ingredient TOOL;
    private final Ingredient binding_agent;

    public EaselRecipe(Identifier id, Ingredient canvas, ArrayList<Ingredient> dyes, Ingredient tool, Ingredient binding_agent) {
        ID = id;
        CANVAS = canvas;
        DYES = dyes;
        TOOL = tool;
        this.binding_agent = binding_agent;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return false;
    }

    @Override
    public ItemStack craft(Inventory inventory) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getOutput() {
        return null;
    }

    @Override
    public Identifier getId() {
        return ID;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return EaselRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }

    public static class Type implements RecipeType<EaselRecipe> {
        private Type() {}

        public static final Identifier ID = Tila.id("painting");
        public static final Type INSTANCE = new Type();
    }
}
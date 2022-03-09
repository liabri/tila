package org.liabri.tila.recipes;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.registry.Registry;

public class Recipes {
    public static void init() {}

    public static final RecipeType<EaselRecipe> EASEL_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, EaselRecipe.Type.ID, EaselRecipe.Type.INSTANCE);
    public static final RecipeSerializer<EaselRecipe> EASEL_RECIPE_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, EaselRecipe.Type.ID, EaselRecipeSerializer.INSTANCE);
}

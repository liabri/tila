package org.liabri.tila.recipes;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;

public class Recipes {
//        Registry.register(Registry.RECIPE_TYPE, EaselRecipe.Type.ID, EaselRecipe.Type.INSTANCE);
//        Registry.register(Registry.RECIPE_SERIALIZER, EaselRecipe.Type.ID, EaselRecipeSerializer.INSTANCE);

    public static final RecipeType<EaselRecipe> EASEL_RECIPE_TYPE = RecipeType.register(EaselRecipe.Type.ID.toString());
    public static final RecipeSerializer<EaselRecipe> EASEL_RECIPE_SERIALIZER = RecipeSerializer.register(EaselRecipe.Type.ID.toString(), EaselRecipeSerializer.INSTANCE);
}

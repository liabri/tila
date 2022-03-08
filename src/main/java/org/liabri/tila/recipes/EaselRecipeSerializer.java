package org.liabri.tila.recipes;

import com.google.gson.JsonObject;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class EaselRecipeSerializer implements RecipeSerializer<EaselRecipe> {
    public static final EaselRecipeSerializer INSTANCE = new EaselRecipeSerializer();

    @Override
    public EaselRecipe read(Identifier id, JsonObject json) {
        return null;
    }

    @Override
    public EaselRecipe read(Identifier id, PacketByteBuf buf) {
        return null;
    }

    @Override
    public void write(PacketByteBuf buf, EaselRecipe recipe) {

    }
}

package org.liabri.tila;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.liabri.tila.items.Items;
import org.liabri.tila.items.PaintingItem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class PaintingsLoader extends JsonDataLoader implements IdentifiableResourceReloadListener {
    public PaintingsLoader() {
        super(new Gson(), "paintings");
    }

    @Override
    public Identifier getFabricId() {
        return Tila.id("paintings_loader");
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> prepared, ResourceManager manager, Profiler profiler) {
//        for(Identifier id : manager.findResources("paintings", path -> path.endsWith(".json"))) {
//            try (InputStream stream = manager.getResource(id).getInputStream()) {
//                Gson gson = new Gson();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//                ArrayList<PaintingItem> paintings = gson.fromJson(reader, (Type) PaintingItem.class);
//                for (PaintingItem paintingItem : paintings) {
//                    Items.register(paintingItem.getRefName() + "_painting", paintingItem);
//                }
//            } catch (Exception e) {
//                Tila.LOGGER.error("Tila encountered an error while loading" + id.toString(), e);
//            }
//        }

        Gson gson = new Gson();
        prepared.forEach((identifier, jsonElement) -> {
            PaintingItem paintingItem = gson.fromJson(jsonElement, PaintingItem.class);
            Items.register(paintingItem.getRefName() + "_painting", paintingItem);
        });
    }
}

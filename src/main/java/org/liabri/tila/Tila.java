package org.liabri.tila;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.liabri.tila.blocks.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tila implements ModInitializer {
	public static final String MOD_ID = "tila";
	public static final Logger LOGGER = LoggerFactory.getLogger("tila");

	public static Identifier id(String id) {
		return new Identifier(MOD_ID, id);
	}

	@Override
	public void onInitialize() {
		Blocks.init();

//		ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
//			@Override
//			public Identifier getFabricId() {
//				return new Identifier("tila", "paintings");
//			}
//
//			@Override
//			public void reload(ResourceManager manager) {
//				for(Identifier id : manager.findResources("assets/tila/textures/paintings/paintings.json", path -> path.endsWith(".json"))) {
//					try(InputStream stream = manager.getResource(id).getInputStream()) {
//						Gson gson = new Gson();
//						BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//						ArrayList<Painting> paintings = gson.fromJson(reader, (Type) Painting.class);
//						for (Painting p : paintings) {
//							LOGGER.info("LOOK: " + p.getRefName());
//						}
//					} catch(Exception e) {
//						LOGGER.error("Tila encountered an error while loading" + id.toString(), e);
//					}
//				}
//			}
//		});
	}
}

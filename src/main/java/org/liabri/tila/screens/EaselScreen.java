package org.liabri.tila.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.liabri.tila.screenhandlers.EaselScreenHandler;

@Environment(EnvType.CLIENT)
public class EaselScreen extends HandledScreen<EaselScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("textures/gui/container/stonecutter.png");

    public EaselScreen(EaselScreenHandler container, PlayerInventory inventory, Text title) {
        super(container, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        renderBackground(matrices);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

//        final var slot = handler.slots.get(0);
//        if (!slot.hasStack()) return;
//        drawTexture(matrices, x + slot.x - 1, y + slot.y - 1, 208, 0, 18, 18);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        this.titleX = backgroundWidth / 2 - textRenderer.getWidth(title) / 2;
    }
}
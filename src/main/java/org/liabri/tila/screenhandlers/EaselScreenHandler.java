package org.liabri.tila.screenhandlers;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.Property;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import org.liabri.tila.recipes.EaselRecipe;

import java.util.List;

public class EaselScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;

    private final Property selectedRecipe;
    private List<EaselRecipe> availableRecipes;
    final CraftingResultInventory output;
    final Slot outputSlot;

    public EaselScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, new SimpleInventory(1), new ArrayPropertyDelegate(2));
    }

    public EaselScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ScreenHandlers.EASEL_SCREEN_HANDLER, syncId);

        this.selectedRecipe = Property.create();
        this.availableRecipes = Lists.newArrayList();
        this.output = new CraftingResultInventory();
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.addProperties(propertyDelegate);
        this.addProperty(this.selectedRecipe);

        // inventory slot (canvasses)
        this.addSlot(new Slot(inventory, 0, 20, 33));

        // painting output slot
        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            @Override public boolean canInsert(ItemStack stack) { return false; }
        });

        this.addSlot(this.outputSlot);

        int i;
        // player inventory slots
        for(i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // player hotbar slots
        for(i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < this.availableRecipes.size();
    }

    void populateResult() {
        if (!this.availableRecipes.isEmpty() && this.isInBounds(this.selectedRecipe.get())) {
            EaselRecipe easelRecipe = (EaselRecipe)this.availableRecipes.get(this.selectedRecipe.get());
            this.output.setLastRecipe(easelRecipe);
//            this.outputSlot.setStack(easelRecipe.craft(this.inventory)); //TODO
        } else {
            this.outputSlot.setStack(ItemStack.EMPTY);
        }

        this.sendContentUpdates();
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
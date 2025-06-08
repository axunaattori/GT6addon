package com.axunaattori.gt6addon.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import gregapi.data.*;

public class vanilla {

    public static void addRecipes() {
        // GameRegistry.addRecipe(new ItemStack(circuitTier0), new Object[]{
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(Blocks.chest),
                new Object[] { // its easier to remove with minetweaker
                    "SPK", "RWR", "PPP", 'S', "craftingToolHardHammer", 'K', "craftingToolKnife", 'P', "plankAnyWood",
                    'W', "stickAnyWood", 'R', "ringAnyWood" }));
    }
}

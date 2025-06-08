package com.axunaattori.gt6addon.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.axunaattori.gt6addon.GT6addon;

import cpw.mods.fml.common.registry.GameRegistry;
import gregapi.data.*;

public class custom {

    public static void addRecipes() {
        // GameRegistry.addRecipe(new ItemStack(circuitTier0), new Object[]{
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(GT6addon.circuitTier0),
                new Object[] { "   ", " SW", "TTT", 'T', "wireGt02Tin", 'S', "plateAnySilicon", 'W',
                    "craftingToolWireCutter", }));

        // add welding machine recipe for somewhat cheaper FIX FIX FIX
        RM.Welder.addRecipe2(
            true,
            16,
            20,
            OP.plate.mat(MT.Si, 1),
            OP.wireFine.mat(MT.Sn, 8),
            new ItemStack(GT6addon.circuitTier0));
    }
}

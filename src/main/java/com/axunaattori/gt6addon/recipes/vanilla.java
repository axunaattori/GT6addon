package com.axunaattori.gt6addon.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

import gregapi.data.*;
import gregapi.data.CS;
import gregapi.util.CR;
import gregapi.util.ST;

public class vanilla {

    public static void addRecipes() {
        CR.delate(ST.make(Blocks.crafting_table, 1, 0));
        CR.delate(ST.make(Blocks.chest, 1, 0));
        CR.delate(ST.make(Items.ender_eye, 1, 0));
        CR.remove(ST.make(Blocks.hopper, 1, 0));
        CR.remove(ST.make(Blocks.piston, 1, 0));
        //TODO: override or remove the gt6 recipe for pistons completely.

        CR.delate(ST.make(Items.diamond_boots, 1, 0));
        CR.delate(ST.make(Items.diamond_leggings, 1, 0));
        CR.delate(ST.make(Items.diamond_chestplate, 1, 0));
        CR.delate(ST.make(Items.diamond_helmet, 1, 0));

        // You should not even use these...
        CR.delate(ST.make(Items.diamond_sword, 1, 0));
        CR.delate(ST.make(Items.diamond_axe, 1, 0));
        CR.delate(ST.make(Items.diamond_hoe, 1, 0));
        CR.delate(ST.make(Items.diamond_shovel, 1, 0));
        CR.delate(ST.make(Items.diamond_pickaxe, 1, 0));

        CR.shaped(ST.make(Blocks.crafting_table, 1, 0), CR.DEF_NCC, "FF", "WW", 'F', OD.itemFlint, 'W', OD.logWood);
        CR.shaped(
            ST.make(Blocks.chest, 1, 0),
            CR.DEF_NCC,
            "hWk",
            "RSR",
            "WWW",
            'W',
            OD.plankAnyWood,
            'R',
            OP.ring.dat(ANY.Wood),
            'S',
            OD.stickAnyWood);
        CR.shaped(
            ST.make(Blocks.ender_chest, 1, 0),
            CR.DEF | CR.DEL_OTHER_RECIPES,
            "hPw",
            "RCR",
            "PPP",
            'P',
            OP.plate.dat(MT.ObsidianSteel),
            'R',
            OP.ring.dat(MT.ObsidianSteel),
            'C',
            IL.Circuit_Enderium);
        CR.shaped(
            ST.make(Blocks.hopper, 1, 0),
            CR.DEF | CR.DEL_OTHER_RECIPES,
            "PwP",
            "ICI",
            " Ih",
            'P',
            OP.plate.dat(ANY.Iron),
            'I',
            OP.plateCurved.dat(ANY.Iron),
            'C',
            OD.craftingChest);
        CR.shaped(
            ST.make(Blocks.piston, 1, 0),
            CR.DEF_NCC,
            "PPP",
            "RFR",
            "COC",
            'P',
            OD.plankAnyWood,
            'R',
            OP.plate.dat(MT.RedAlloy),
            'F',
            ST.make(Blocks.fence, 1, 0),
            'C',
            OP.cobblestone,
            'O',
            IL.Electric_Piston_ULV);
        RM.Bath.addRecipe1(
            true,
            0,
            16,
            ST.make(Items.ender_pearl, 1, 0),
            MT.Blaze.liquid(144, true),
            CS.NF,
            ST.make(Items.ender_eye, 1, 0));
    }
}

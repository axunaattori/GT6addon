package com.axunaattori.gt6addon.Material;

import com.axunaattori.gt6addon.Config;
import com.axunaattori.gt6addon.GT6addon;

import gregapi.data.CS;
import gregapi.data.TC;
import gregapi.render.TextureSet;

// import com.axunaattori.gt6addon.GT6addon;

public class CustomMaterial {

    private static final int[][] colors = { { 255, 0, 255, 0 }, // 0 ULV
        { 0, 255, 0, 0 }, // 1 LV
        { 0, 0, 0, 0 }, // 2 MV
        { 0, 0, 0, 0 }, // 3 HV
        { 0, 0, 0, 0 }, // 4 EV
        { 0, 0, 0, 0 }, // 5 IV
        { 0, 0, 0, 0 }, // 6 LuV <3
        { 0, 0, 0, 0 }, // 7 ZPM
        { 0, 0, 0, 0 }, // 8 UV
        { 0, 0, 0, 0 }, // 9 PUV1
        { 0, 0, 0, 0 }, // 10 PUV2
        { 0, 0, 0, 0 }, // 11 PUV3
        { 0, 0, 0, 0 }, // 12 PUV4
        { 0, 0, 0, 0 }, // 13 PUV5
        { 0, 0, 0, 0 } // 14 XV
    };

    public static void MaterialPreinit() {
        gregapi.oredict.OreDictMaterial[] superconductors = new gregapi.oredict.OreDictMaterial[15];

        for (int i = 0; i < 15; i++) {
            superconductors[i] = gregapi.oredict.OreDictMaterial.createMaterial(
                Config.MaterialID + i,
                CS.VN[i] + "superConductorBase",
                CS.VN[i] + " Superconductor Base");
        }

        for (int i = 0; i < 15; i++) {
            superconductors[i].setTextures(TextureSet.SET_METALLIC);
            superconductors[i].setRGBa(colors[i][0], colors[i][1], colors[i][2], colors[i][3]);
            superconductors[i].heat(2000, 4000);
            superconductors[i].aspects(TC.METALLUM, 1);
            superconductors[i].setOriginalMod(GT6addon.MOD_DATA);
        }

        new gregapi.item.multiitem.MultiItemRandom(GT6addon.MODID, "gt6addon.multiitem.resources") {

            @Override
            public void addItems() {
                // Did you know that you can use a variable from outside this Block by just making it "final"? I didn't,
                // but now I know more and use tExamplium, even though it wouldn't be accessible otherwise.
                // And yes you can use all the 32766 possible Meta-IDs of this Item.
                for (int i = 0; i < 15; i++) {
                    addItem(
                        i * 4,
                        "Tiny Pile of " + CS.VN[i] + " Superconductor Base Dust",
                        "",
                        gregapi.data.OP.dustTiny.dat(superconductors[i]));
                    addItem(
                        1 + i * 4,
                        "Small Pile of " + CS.VN[i] + " Superconductor Base Dust",
                        "",
                        gregapi.data.OP.dustSmall.dat(superconductors[i]));
                    addItem(
                        2 + i * 4,
                        CS.VN[i] + " Superconductor Base Dust",
                        "",
                        gregapi.data.OP.dust.dat(superconductors[i]));
                    addItem(
                        3 + i * 3,
                        CS.VN[i] + " Superconductor Base Ingot",
                        "",
                        gregapi.data.OP.ingot.dat(superconductors[i]));
                }
                // Here would be a right place to add Crafting Recipes or Machine Recipes using your new Items.
            }
        };

        new gregapi.block.multitileentity.MultiTileEntityRegistry("gt6addon.multitileentity");

        gregapi.block.multitileentity.MultiTileEntityBlock.getOrCreate(
            GT6addon.MODID,
            "machine",
            gregapi.block.MaterialMachines.instance,
            net.minecraft.block.Block.soundTypeMetal,
            gregapi.data.CS.TOOL_cutter,
            0,
            0,
            15,
            false,
            false);
    }

    public static void MaterialInit() {
        gregapi.block.multitileentity.MultiTileEntityRegistry tgt6addonRegistry = gregapi.block.multitileentity.MultiTileEntityRegistry
            .getRegistry("gt6addon.multitileentity");

        gregapi.oredict.OreDictMaterial[] superconductors = new gregapi.oredict.OreDictMaterial[15];
        for (int i = 0; i < 15; i++) {
            superconductors[i] = gregapi.oredict.OreDictMaterial.get(CS.VN[i] + "superConductorBase");
        }

        gregapi.block.multitileentity.MultiTileEntityBlock tWireBlock = gregapi.block.multitileentity.MultiTileEntityBlock
            .getOrCreate(
                GT6addon.MODID,
                "machine",
                gregapi.block.MaterialMachines.instance,
                net.minecraft.block.Block.soundTypeMetal,
                gregapi.data.CS.TOOL_cutter,
                0,
                0,
                15,
                false,
                false);
        for (int i = 0; i < 15; i++) {
            gregapi.tileentity.connectors.MultiTileEntityWireElectric.addElectricWires(
                i * 16,
                0,
                CS.VREC[i],
                4,
                0,
                0,
                false,
                false,
                false,
                tgt6addonRegistry,
                tWireBlock,
                gregapi.tileentity.connectors.MultiTileEntityWireElectric.class,
                superconductors[i]);
            // it has to be UPPED by 16 because it creates 16 different wires, HOLY FUCK THIS TOOK TOO LONG TO FIGURE
            // OUT IM STUPID
        }
    }
}

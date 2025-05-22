package com.axunaattori.gt6addon;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.axunaattori.gt6addon.Items.*;
import com.axunaattori.gt6addon.Material.CustomMaterial;
import com.axunaattori.gt6addon.recipes.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import gregapi.data.CS;

@Mod(
    modid = "gt6addon",
    version = "0.01",
    name = "GregTech 6 Addon",
    acceptedMinecraftVersions = "[1.7.10]",
    dependencies = "required-after:gregapi_post")
public class GT6addon {

    public void customRegisterItem(Item item) {
        GameRegistry.registerItem(
            item,
            item.getUnlocalizedName()
                .substring(5));
    }

    public static final String MODID = "gt6addon";
    public static final Logger LOG = LogManager.getLogger(MODID);

    public static gregapi.code.ModData MOD_DATA = new gregapi.code.ModData(MODID, "Unnamed GregTech 6 Addon");

    @SidedProxy(
        clientSide = "com.axunaattori.gt6addon.ClientProxy",
        serverSide = "com.axunaattori.gt6addon.CommonProxy")
    public static CommonProxy proxy;

    public static Item circuitTier0;
    public static Item circuitTier7;
    public static Item circuitTier8;
    public static Item circuitTier9;
    public static Item unfiredClay;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        circuitTier0 = new CircuitTier0().setUnlocalizedName("CircuitTier0")
            .setTextureName("gt6addon:CircuitTier0");
        circuitTier7 = new CircuitTier7().setUnlocalizedName("CircuitTier7")
            .setTextureName("gt6addon:CircuitTier7");
        circuitTier8 = new CircuitTier8().setUnlocalizedName("CircuitTier8")
            .setTextureName("gt6addon:CircuitTier8");
        circuitTier9 = new CircuitTier9().setUnlocalizedName("CircuitTier9")
            .setTextureName("gt6addon:CircuitTier9");
        unfiredClay = new CircuitTier9().setUnlocalizedName("UnfiredClay")
            .setTextureName("gt6addon:UnfiredClay");

        customRegisterItem(circuitTier0);
        customRegisterItem(circuitTier7);
        customRegisterItem(circuitTier8);
        customRegisterItem(circuitTier9);
        customRegisterItem(unfiredClay);

        OreDictionary.registerOre(CS.OD_CIRCUITS[0], circuitTier0); //there's nothing past t9 in the OD_CIRCUITS array
        for (int i = 0; i < 8; i++) {
            OreDictionary.registerOre(CS.OD_CIRCUITS[i], circuitTier7);
        }
        for (int i = 0; i < 9; i++) {
            OreDictionary.registerOre(CS.OD_CIRCUITS[i], circuitTier8);
        }
        for (int i = 0; i < 10; i++) {
            OreDictionary.registerOre(CS.OD_CIRCUITS[i], circuitTier9);
        }
        CustomMaterial.MaterialPreinit();
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        CustomMaterial.MaterialInit();
        GameRegistry.addSmelting(new ItemStack(unfiredClay), new ItemStack(Items.brick), 0.5f);
        vanilla.addRecipes();
        custom.addRecipes();
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}

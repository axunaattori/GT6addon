package com.axunaattori.gt6addon;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static int MaterialID = 32000;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        MaterialID = configuration.getInt("MaterialID", Configuration.CATEGORY_GENERAL, 32000, 0, 36000, "Change if you want to use it for your own stuff for some reason (there shouldn't really be a reason???)");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}

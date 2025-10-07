package de.scholle.potionusingdisabler;

import de.scholle.potionusingdisabler.listeners.PotionUseListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class PotionUsingDisabler extends JavaPlugin {

    private static PotionUsingDisabler instance;
    private List<String> disabledPotions;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        disabledPotions = getConfig().getStringList("disabled-potions");
        getServer().getPluginManager().registerEvents(new PotionUseListener(), this);
        getLogger().info("PotionUsingDisabler enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PotionUsingDisabler disabled!");
    }

    public static PotionUsingDisabler getInstance() {
        return instance;
    }

    public List<String> getDisabledPotions() {
        return disabledPotions;
    }
}

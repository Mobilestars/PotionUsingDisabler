package de.scholle.potionusingdisabler.listeners;

import de.scholle.potionusingdisabler.PotionUsingDisabler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.List;

public class PotionUseListener implements Listener {

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (item == null) return;
        if (!(item.getItemMeta() instanceof PotionMeta meta)) return;

        List<String> disabledPotions = PotionUsingDisabler.getInstance().getDisabledPotions();

        try {
            PotionData potionData = meta.getBasePotionData();
            PotionType type = potionData.getType();
            if (disabledPotions.contains(type.name())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage("§cYou cannot use this potion!");
                return;
            }
        } catch (Exception ignored) {}

        for (PotionEffect effect : meta.getCustomEffects()) {
            PotionEffectType type = effect.getType();
            if (disabledPotions.contains(type.getName())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage("§cYou cannot use this potion!");
                return;
            }
        }
    }

    @EventHandler
    public void onSplash(PotionSplashEvent event) {
        ItemStack item = event.getPotion().getItem();
        if (item == null) return;
        if (!(item.getItemMeta() instanceof PotionMeta meta)) return;

        List<String> disabledPotions = PotionUsingDisabler.getInstance().getDisabledPotions();

        try {
            PotionData potionData = meta.getBasePotionData();
            PotionType type = potionData.getType();
            if (disabledPotions.contains(type.name())) {
                event.getAffectedEntities().stream()
                        .filter(e -> e instanceof Player)
                        .map(e -> (Player) e)
                        .forEach(p -> event.setIntensity(p, 0f));
                return;
            }
        } catch (Exception ignored) {}

        for (PotionEffect effect : meta.getCustomEffects()) {
            PotionEffectType type = effect.getType();
            if (disabledPotions.contains(type.getName())) {
                event.getAffectedEntities().stream()
                        .filter(e -> e instanceof Player)
                        .map(e -> (Player) e)
                        .forEach(p -> event.setIntensity(p, 0f));
                return;
            }
        }
    }
}

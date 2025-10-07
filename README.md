# PotionUsingDisabler

**Version:** 1.0.0  
**Minecraft Version:** 1.18+  
Website: [Modrinth](https://modrinth.com/plugin/potionusingdisabler)

---

## Description
**PotionUsingDisabler** allows server admins to disable certain potions for use. Players can still have the potions in their inventory, but if a potion is disabled in the configuration, they cannot use it or gain its effects. This works for both drinkable potions and splash potions.

---

## Installation
1. Place the `PotionUsingDisabler.jar` in your server's `plugins` folder.
2. Start the server to generate the default configuration.
3. Edit `config.yml` to disable the potions you want.
4. Restart the server to apply the changes.

---

## Configuration

```yaml
# List of disabled potions for usage
# Use PotionType names from the Bukkit API
# Example: HARMING, HEALING, POISON, STRONG_HEALING, LONG_REGENERATION
# See all available PotionType names here: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/potion/PotionType.html
disabled-potions:
  - HARMING
  - STRONG_HARMING

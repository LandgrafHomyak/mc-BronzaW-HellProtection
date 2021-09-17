package net.landgrafhomyak.BronzaW_HellProtection;

import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Logger;

public class BronzaW_HellProtection extends JavaPlugin implements Listener {
    private final Logger log = getLogger();

    @Override
    public void onEnable() {
        super.onEnable();

        this.getServer().getPluginManager().registerEvents(new HellListener(), this);
        log.info("Event listener for protecting hell registered successful");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        log.info("Hell in dangerous!");
    }
}
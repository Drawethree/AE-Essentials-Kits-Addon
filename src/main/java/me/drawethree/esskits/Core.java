package me.drawethree.esskits;

import com.earth2me.essentials.Essentials;
import me.drawethree.esskits.commands.KitsCommand;
import me.drawethree.esskits.handlers.CooldownManager;
import me.drawethree.esskits.handlers.KitsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    private static JavaPlugin instance;

    private static CooldownManager cooldownManager;
    private static KitsManager kitsManager;

    private static Essentials ess;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        ess = (Essentials) Essentials.getProvidingPlugin(Essentials.class);

        cooldownManager = new CooldownManager(this);
        kitsManager = new KitsManager(this);

        getCommand("kit").setExecutor(new KitsCommand());
    }

    @Override
    public void onDisable() {
        getCooldownManager().save();
    }

    public static JavaPlugin getInstance() {
        return instance;
    }

    public static CooldownManager getCooldownManager() {
        return cooldownManager;
    }

    public static KitsManager getKitsManager() {
        return kitsManager;
    }

    public static Essentials getEss() {
        return ess;
    }
}

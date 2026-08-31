package fr.cozyhouse.legacyCombat.commands;

import fr.cozyhouse.legacyCombat.LegacyCombat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player player))
            return false;

        if (strings.length == 1){
            switch (strings[0]) {
                case "toggle-cooldown":
                    LegacyCombat.cooldownModule.changeState(!LegacyCombat.cooldownModule.getState());
                    break;
                default:
                    return false;
            }
        } else {
            player.sendMessage("Welcome in admin sevice !");
        }
        return true;
    }
}

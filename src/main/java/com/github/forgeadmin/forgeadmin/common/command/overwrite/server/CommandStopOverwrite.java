package com.github.forgeadmin.forgeadmin.common.command.overwrite.server;

import com.github.forgeadmin.forgeadmin.api.permissions.Permissible;
import com.github.forgeadmin.forgeadmin.api.permissions.PermissonHandler;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.server.CommandStop;
import net.minecraft.entity.player.EntityPlayer;

public class CommandStopOverwrite extends CommandStop implements Permissible {
  @Override
  public int getRequiredPermissionLevel() {
    return 0;
  }

  @Override
  public String getPermissionNode() {
    return "minecraft.command." + getCommandName();
  }

  @Override
  public boolean canCommandSenderUseCommand(ICommandSender sender) {
    return !(sender instanceof EntityPlayer) || PermissonHandler.getPermissionHandler().hasPermission ((EntityPlayer) sender, this);
  }
}

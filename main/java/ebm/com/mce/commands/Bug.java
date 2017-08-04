package ebm.com.mce.commands;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class Bug extends CommandBase {
	public int compareTo(Object o) {
		return 0;
	}

	public String getCommandName() {
		return "ebmbug";
	}

	public String getCommandUsage(ICommandSender cmd) {
		return "/ebmbug";
	}

	public List getCommandAliases() {
		return null;
	}

	public void processCommand(ICommandSender cmd, String[] s) {
		func_152373_a(cmd, this, "command.ebmbug");
	}

	public boolean canCommandSenderUseCommand(ICommandSender cmd) {
		return true;
	}

	public List addTabCompletionOptions(ICommandSender cmd, String[] s) {
		return null;
	}

	public boolean isUsernameIndex(String[] s, int i) {
		return false;
	}
}

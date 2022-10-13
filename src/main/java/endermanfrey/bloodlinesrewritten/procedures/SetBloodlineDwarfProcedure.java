package endermanfrey.bloodlinesrewritten.procedures;

import endermanfrey.bloodlinesrewritten.network.BloodlinesRewrittenModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class SetBloodlineDwarfProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "Dwarf";
			entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Bloodline = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
		{
			double _setval = 1;
			entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BloodlineLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}

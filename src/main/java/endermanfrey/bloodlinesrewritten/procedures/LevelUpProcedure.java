package endermanfrey.bloodlinesrewritten.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import endermanfrey.bloodlinesrewritten.network.BloodlinesRewrittenModVariables;

public class LevelUpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr
				? _plr.experienceLevel
				: 0) >= (entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).XPToLevelUp) {
			if (entity instanceof Player _player)
				_player.giveExperiencePoints(-((int) (entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).XPToLevelUp));
			{
				double _setval = 1 + (entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel;
				entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BloodlineLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

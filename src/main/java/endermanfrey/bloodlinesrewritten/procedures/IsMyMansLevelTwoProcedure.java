package endermanfrey.bloodlinesrewritten.procedures;

import net.minecraft.world.entity.Entity;

import endermanfrey.bloodlinesrewritten.network.BloodlinesRewrittenModVariables;

public class IsMyMansLevelTwoProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (2 == (entity.getCapability(BloodlinesRewrittenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BloodlinesRewrittenModVariables.PlayerVariables())).BloodlineLevel) {
			return true;
		}
		return false;
	}
}

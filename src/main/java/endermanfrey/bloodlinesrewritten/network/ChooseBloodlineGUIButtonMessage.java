
package endermanfrey.bloodlinesrewritten.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

import endermanfrey.bloodlinesrewritten.world.inventory.ChooseBloodlineGUIMenu;
import endermanfrey.bloodlinesrewritten.procedures.SetBloodlineMerProcedure;
import endermanfrey.bloodlinesrewritten.procedures.SetBloodlineFaeProcedure;
import endermanfrey.bloodlinesrewritten.procedures.SetBloodlineEnderProcedure;
import endermanfrey.bloodlinesrewritten.procedures.SetBloodlineDraconicProcedure;
import endermanfrey.bloodlinesrewritten.procedures.SetBloodlineDwarfProcedure;
import endermanfrey.bloodlinesrewritten.procedures.SetBloodlineAasimarProcedure;
import endermanfrey.bloodlinesrewritten.BloodlinesRewrittenMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChooseBloodlineGUIButtonMessage {
	private final int buttonID, x, y, z;

	public ChooseBloodlineGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ChooseBloodlineGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ChooseBloodlineGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ChooseBloodlineGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = ChooseBloodlineGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetBloodlineMerProcedure.execute(entity);
		}
		if (buttonID == 1) {

			SetBloodlineAasimarProcedure.execute(entity);
		}
		if (buttonID == 2) {

			SetBloodlineDraconicProcedure.execute(entity);
		}
		if (buttonID == 3) {

			SetBloodlineFaeProcedure.execute(entity);
		}
		if (buttonID == 4) {

			SetBloodlineEnderProcedure.execute(entity);
		}
		if (buttonID == 5) {

			SetBloodlineDwarfProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BloodlinesRewrittenMod.addNetworkMessage(ChooseBloodlineGUIButtonMessage.class, ChooseBloodlineGUIButtonMessage::buffer,
				ChooseBloodlineGUIButtonMessage::new, ChooseBloodlineGUIButtonMessage::handler);
	}
}

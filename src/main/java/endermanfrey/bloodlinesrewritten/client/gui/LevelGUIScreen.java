
package endermanfrey.bloodlinesrewritten.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import endermanfrey.bloodlinesrewritten.world.inventory.LevelGUIMenu;
import endermanfrey.bloodlinesrewritten.procedures.IsMyMansLevelTwoProcedure;
import endermanfrey.bloodlinesrewritten.procedures.IsMyMansLevelThreeProcedure;
import endermanfrey.bloodlinesrewritten.procedures.IsMyMansLevelOneProcedure;
import endermanfrey.bloodlinesrewritten.network.LevelGUIButtonMessage;
import endermanfrey.bloodlinesrewritten.BloodlinesRewrittenMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class LevelGUIScreen extends AbstractContainerScreen<LevelGUIMenu> {
	private final static HashMap<String, Object> guistate = LevelGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public LevelGUIScreen(LevelGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("bloodlines_rewritten:textures/screens/level_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Bloodline Level", 6, 7, -12829636);
		if (IsMyMansLevelOneProcedure.execute(entity))
			this.font.draw(poseStack, "1", 87, 7, -12829636);
		if (IsMyMansLevelTwoProcedure.execute(entity))
			this.font.draw(poseStack, "2", 87, 7, -12829636);
		if (IsMyMansLevelThreeProcedure.execute(entity))
			this.font.draw(poseStack, "3", 87, 7, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 51, this.topPos + 115, 72, 20, new TextComponent("Level Up!"), e -> {
			if (true) {
				BloodlinesRewrittenMod.PACKET_HANDLER.sendToServer(new LevelGUIButtonMessage(0, x, y, z));
				LevelGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}

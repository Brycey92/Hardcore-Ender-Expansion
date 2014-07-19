package chylex.hee.proxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderLightningBolt;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.RenderEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import chylex.hee.entity.block.EntityBlockEnderCrystal;
import chylex.hee.entity.block.EntityBlockEnhancedTNTPrimed;
import chylex.hee.entity.block.EntityBlockFallingDragonEgg;
import chylex.hee.entity.block.EntityBlockFallingObsidian;
import chylex.hee.entity.block.EntityBlockTempleDragonEgg;
import chylex.hee.entity.boss.EntityBossDragon;
import chylex.hee.entity.boss.EntityBossEnderDemon;
import chylex.hee.entity.boss.EntityMiniBossEnderEye;
import chylex.hee.entity.boss.EntityMiniBossFireFiend;
import chylex.hee.entity.item.EntityItemAltar;
import chylex.hee.entity.item.EntityItemIgneousRock;
import chylex.hee.entity.item.EntityItemInstabilityOrb;
import chylex.hee.entity.mob.EntityMobAngryEnderman;
import chylex.hee.entity.mob.EntityMobBabyEnderman;
import chylex.hee.entity.mob.EntityMobCorporealMirage;
import chylex.hee.entity.mob.EntityMobEnderGuardian;
import chylex.hee.entity.mob.EntityMobFireGolem;
import chylex.hee.entity.mob.EntityMobInfestedBat;
import chylex.hee.entity.mob.EntityMobParalyzedEnderman;
import chylex.hee.entity.mob.EntityMobScorchingLens;
import chylex.hee.entity.mob.EntityMobVampiricBat;
import chylex.hee.entity.projectile.EntityProjectileCorporealMirageOrb;
import chylex.hee.entity.projectile.EntityProjectileDragonFireball;
import chylex.hee.entity.projectile.EntityProjectileDragonFreezeball;
import chylex.hee.entity.projectile.EntityProjectileFlamingBall;
import chylex.hee.entity.projectile.EntityProjectileGolemFireball;
import chylex.hee.entity.projectile.EntityProjectilePotionOfInstability;
import chylex.hee.entity.projectile.EntityProjectileSpatialDash;
import chylex.hee.entity.weather.EntityWeatherLightningBoltDemon;
import chylex.hee.entity.weather.EntityWeatherLightningBoltSafe;
import chylex.hee.gui.GuiItemViewer;
import chylex.hee.item.ItemList;
import chylex.hee.mechanics.knowledge.fragment.CraftingKnowledgeFragment;
import chylex.hee.mechanics.knowledge.fragment.EnhancementKnowledgeFragment;
import chylex.hee.mechanics.temple.TeleportParticleTickEvent;
import chylex.hee.render.OverlayManager;
import chylex.hee.render.RenderNothing;
import chylex.hee.render.block.RenderBlockEndFlowerPot;
import chylex.hee.render.block.RenderBlockEnhancedTNTPrimed;
import chylex.hee.render.block.RenderBlockObsidianSpecial;
import chylex.hee.render.block.RenderBlockSpookyLeaves;
import chylex.hee.render.entity.RenderBossDragon;
import chylex.hee.render.entity.RenderBossEnderDemon;
import chylex.hee.render.entity.RenderMiniBossEnderEye;
import chylex.hee.render.entity.RenderMiniBossFireFiend;
import chylex.hee.render.entity.RenderMobAngryEnderman;
import chylex.hee.render.entity.RenderMobBabyEnderman;
import chylex.hee.render.entity.RenderMobCorporealMirage;
import chylex.hee.render.entity.RenderMobInfestedBat;
import chylex.hee.render.entity.RenderMobParalyzedEnderman;
import chylex.hee.render.entity.RenderTexturedMob;
import chylex.hee.render.model.ModelEnderGuardian;
import chylex.hee.render.model.ModelEndermanHeadBiped;
import chylex.hee.render.model.ModelFireGolem;
import chylex.hee.render.model.ModelScorchingLens;
import chylex.hee.render.projectile.RenderProjectilePotionOfInstability;
import chylex.hee.render.tileentity.RenderTileCustomSpawner;
import chylex.hee.render.tileentity.RenderTileEndermanHead;
import chylex.hee.render.tileentity.RenderTileEssenceAltar;
import chylex.hee.render.tileentity.RenderTileLaserBeam;
import chylex.hee.render.weather.RenderWeatherLightningBoltPurple;
import chylex.hee.system.ConfigHandler;
import chylex.hee.system.ReflectionPublicizer;
import chylex.hee.system.sound.MusicManager;
import chylex.hee.system.update.UpdateNotificationManager;
import chylex.hee.tileentity.TileEntityCustomSpawner;
import chylex.hee.tileentity.TileEntityEndermanHead;
import chylex.hee.tileentity.TileEntityEssenceAltar;
import chylex.hee.tileentity.TileEntityLaserBeam;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ModClientProxy extends ModCommonProxy{
	public static final ModelEndermanHeadBiped endermanHeadModelBiped = new ModelEndermanHeadBiped();
	
	@Override
	public void loadConfiguration(){
		super.loadConfiguration();
		ConfigHandler.loadClient();
	}
	
	@Override
	public EntityPlayer getClientSidePlayer(){
		return Minecraft.getMinecraft().thePlayer;
	}
	
	@Override
	public void registerRenderers(){
		renderIdObsidianSpecial = (short)RenderingRegistry.getNextAvailableRenderId();
		renderIdFlowerPot = (short)RenderingRegistry.getNextAvailableRenderId();
		renderIdSpookyLeaves = (short)RenderingRegistry.getNextAvailableRenderId();
		renderIdInfestationRemedyCauldron = (short)RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(new RenderBlockObsidianSpecial());
		RenderingRegistry.registerBlockHandler(new RenderBlockEndFlowerPot());
		RenderingRegistry.registerBlockHandler(new RenderBlockSpookyLeaves());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEssenceAltar.class, new RenderTileEssenceAltar());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEndermanHead.class, new RenderTileEndermanHead());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomSpawner.class, new RenderTileCustomSpawner());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLaserBeam.class, new RenderTileLaserBeam());

		RenderingRegistry.registerEntityRenderingHandler(EntityBossDragon.class, new RenderBossDragon());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMiniBossEnderEye.class, new RenderMiniBossEnderEye());
		RenderingRegistry.registerEntityRenderingHandler(EntityMiniBossFireFiend.class, new RenderMiniBossFireFiend());
		RenderingRegistry.registerEntityRenderingHandler(EntityBossEnderDemon.class, new RenderBossEnderDemon());
		RenderingRegistry.registerEntityRenderingHandler(EntityMobAngryEnderman.class, new RenderMobAngryEnderman());
		RenderingRegistry.registerEntityRenderingHandler(EntityMobBabyEnderman.class, new RenderMobBabyEnderman());
		RenderingRegistry.registerEntityRenderingHandler(EntityMobParalyzedEnderman.class, new RenderMobParalyzedEnderman());
		RenderingRegistry.registerEntityRenderingHandler(EntityMobEnderGuardian.class, new RenderTexturedMob(new ModelEnderGuardian(), 0.3F, "ender_guardian.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityMobVampiricBat.class, new RenderTexturedMob(new ModelBat(), 0.25F, "bat_vampiric.png", 0.35F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMobInfestedBat.class, new RenderMobInfestedBat());
		RenderingRegistry.registerEntityRenderingHandler(EntityMobFireGolem.class, new RenderTexturedMob(new ModelFireGolem(), 0.3F, "fire_golem.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityMobScorchingLens.class, new RenderTexturedMob(new ModelScorchingLens(), 0.3F, "scorching_lens.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityMobCorporealMirage.class, new RenderMobCorporealMirage());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBlockEnderCrystal.class, new RenderEnderCrystal());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlockFallingObsidian.class, new RenderFallingBlock());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlockFallingDragonEgg.class, new RenderFallingBlock());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlockTempleDragonEgg.class, new RenderFallingBlock());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlockEnhancedTNTPrimed.class, new RenderBlockEnhancedTNTPrimed());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityItemIgneousRock.class, new RenderItem());
		RenderingRegistry.registerEntityRenderingHandler(EntityItemInstabilityOrb.class, new RenderItem());
		RenderingRegistry.registerEntityRenderingHandler(EntityItemAltar.class, new RenderItem());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityProjectileFlamingBall.class, new RenderFireball(0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityProjectileGolemFireball.class, new RenderFireball(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityProjectileDragonFireball.class, new RenderFireball(1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityProjectileDragonFreezeball.class, new RenderSnowball(Items.snowball));
		RenderingRegistry.registerEntityRenderingHandler(EntityProjectileCorporealMirageOrb.class, new RenderSnowball(ItemList.corporeal_mirage_orb));
		RenderingRegistry.registerEntityRenderingHandler(EntityProjectilePotionOfInstability.class, new RenderProjectilePotionOfInstability());
		RenderingRegistry.registerEntityRenderingHandler(EntityProjectileSpatialDash.class, new RenderNothing());

		RenderingRegistry.registerEntityRenderingHandler(EntityWeatherLightningBoltSafe.class, new RenderLightningBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityWeatherLightningBoltDemon.class, new RenderWeatherLightningBoltPurple());
		
		CraftingKnowledgeFragment.initClient();
		EnhancementKnowledgeFragment.initClient();
	}
	
	@Override
	public void registerSidedEvents(){
		ReflectionPublicizer.loadClient();
		
		FMLCommonHandler.instance().bus().register(new UpdateNotificationManager());
		OverlayManager.register();
		TeleportParticleTickEvent.register();
		MusicManager.register();
	}
	
	@Override
	public void openGui(String type){
		if (type.equals("itemviewer"))Minecraft.getMinecraft().displayGuiScreen(new GuiItemViewer());
	}
}
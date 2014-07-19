package chylex.hee.block;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.FluidRegistry;
import chylex.hee.system.creativetab.CreativeTabItemList;

public final class BlockList{
	public static final CreativeTabItemList tabOrderedList = new CreativeTabItemList();
	
	public static Block obsidian_end;
	public static Block obsidian_stairs;
	public static Block obsidian_special;
	public static Block obsidian_special_glow;
	public static Block essence_altar;
	public static Block enhanced_brewing_stand;
	public static Block enhanced_tnt;
	public static Block decomposition_table;
	public static Block energy_extraction_table;
	public static Block end_powder_ore;
	public static Block stardust_ore;
	public static Block igneous_rock_ore;
	public static Block instability_orb_ore;
	public static Block ender_goo;
	public static Block end_terrain;
	public static Block crossed_decoration;
	public static Block spooky_log;
	public static Block spooky_leaves;
	public static Block soul_charm;
	public static Block death_flower;
	public static Block death_flower_pot;
	public static Block enderman_head;
	//public static Block infestation_cauldron;
	public static Block sphalerite;
	public static Block ravaged_brick;
	public static Block dungeon_puzzle;
	public static Block energy_cluster;
	public static Block corrupted_energy_high;
	public static Block corrupted_energy_low;
	public static Block laser_beam;
	public static Block custom_spawner;
	public static Block temple_end_portal;
	public static Block biome_core;
	
	public static void loadBlocks(){
		FluidRegistry.registerFluid(BlockEnderGoo.fluid);
		
		obsidian_end = (new BlockObsidianEnd())
		.setHardness(50F).setResistance(2000F).setStepSound(Block.soundTypeStone)
		.setBlockName("obsidianEnd").setBlockTextureName("obsidian");
	
		obsidian_stairs = new BlockObsidianStairs(Blocks.obsidian,0)
		.setHardness(25F).setResistance(1000F)
		.setBlockName("obsidianStairs");
	
		obsidian_special = new BlockObsidianSpecial(false)
		.setHardness(28F).setResistance(2000F).setStepSound(Block.soundTypeStone)
		.setBlockName("obsidianSpecial").setBlockTextureName("hardcoreenderexpansion:obsidian_smooth");
		
		obsidian_special_glow = new BlockObsidianSpecial(true)
		.setHardness(28F).setResistance(2000F).setLightLevel(1F).setStepSound(Block.soundTypeStone)
		.setBlockName("obsidianSpecial").setBlockTextureName("hardcoreenderexpansion:obsidian_smooth");
	
		essence_altar = new BlockEssenceAltar()
		.setHardness(8F).setResistance(20F).setLightOpacity(0).setLightLevel(0.4F).setStepSound(Block.soundTypeMetal)
		.setBlockName("essenceAltar").setBlockTextureName("hardcoreenderexpansion:essence_altar");
	
		enhanced_brewing_stand = new BlockEnhancedBrewingStand()
		.setHardness(0.65F).setLightLevel(0.125F)
		.setBlockName("brewingStand").setBlockTextureName("hardcoreenderexpansion:enhanced_brewing_stand");
		
		enhanced_tnt = new BlockEnhancedTNT()
		.setHardness(0F).setStepSound(Block.soundTypeGrass)
		.setBlockName("tnt").setBlockTextureName("tnt");
	
		decomposition_table = new BlockDecompositionTable()
		.setHardness(4F).setResistance(2000F)
		.setBlockName("decompositionTable");
		
		energy_extraction_table = new BlockEnergyExtractionTable()
		.setHardness(4F).setResistance(2000F)
		.setBlockName("energyExtractionTable");
		
		end_powder_ore = new BlockEndPowderOre()
		.setHardness(3F).setResistance(12F).setStepSound(Block.soundTypeStone)
		.setBlockName("endPowderOre").setBlockTextureName("hardcoreenderexpansion:end_powder_ore");

		stardust_ore = new BlockStardustOre()
		.setHardness(7F).setResistance(4F).setStepSound(Block.soundTypeStone)
		.setBlockName("stardustOre").setBlockTextureName("hardcoreenderexpansion:stardust_ore");
		
		igneous_rock_ore = new BlockIgneousRockOre()
		.setHardness(2F).setResistance(5F).setStepSound(Block.soundTypeStone)
		.setBlockName("igneousRockOre").setBlockTextureName("hardcoreenderexpansion:igneous_rock_ore");
		
		instability_orb_ore = new BlockInstabilityOrbOre()
		.setHardness(5.5F).setResistance(3F).setStepSound(Block.soundTypeStone)
		.setBlockName("instabilityOrbOre").setBlockTextureName("hardcoreenderexpansion:instability_orb_ore");
		
		ender_goo = new BlockEnderGoo()
		.setHardness(150F).setLightOpacity(2)
		.setBlockName("enderGoo").setBlockTextureName("hardcoreenderexpansion:endergoo_flow");
		
		end_terrain = new BlockEndstoneTerrain()
		.setHardness(2.5F).setResistance(15F).setStepSound(Block.soundTypeStone)
		.setBlockName("endStoneTerrain");
		
		crossed_decoration = new BlockCrossedDecoration()
		.setHardness(0F).setStepSound(Block.soundTypeGrass).setCreativeTab(null)
		.setBlockName("crossedDecoration");
	
		spooky_log = new BlockSpookyLog()
		.setHardness(0.7F).setStepSound(Block.soundTypeWood)
		.setBlockName("spookyLog");
		
		spooky_leaves = new BlockSpookyLeaves()
		.setHardness(0.1F).setStepSound(Block.soundTypeGrass)
		.setBlockName("spookyLeaves").setBlockTextureName("hardcoreenderexpansion:spooky_leaves");
		
		soul_charm = new BlockSoulCharm()
		.setHardness(-1F).setResistance(6000000F)
		.setBlockName("soulCharm").setBlockTextureName("hardcoreenderexpansion:empty");
		
		death_flower = new BlockEndFlower()
		.setHardness(0F).setResistance(4F).setStepSound(Block.soundTypeGrass).setCreativeTab(null)
		.setBlockName("endFlower").setBlockTextureName("hardcoreenderexpansion:end_flower");
		
		death_flower_pot = new BlockEndFlowerPot()
		.setHardness(0F).setStepSound(Block.soundTypeStone)
		.setBlockName("flowerPot").setBlockTextureName("flower_pot");
	
		enderman_head = new BlockEndermanHead()
		.setHardness(1F).setStepSound(Block.soundTypeStone)
		.setBlockName("endermanHead").setBlockTextureName("hardcoreenderexpansion:enderman_head");
		
		/*infestation_cauldron = new BlockInfestationRemedyCauldron()
		.setHardness(2F)
		.setBlockName("cauldron").setBlockTextureName("cauldron");*/
		
		sphalerite = new BlockSphalerite()
		.setHardness(1.8F).setResistance(40F)
		.setBlockName("sphalerite").setBlockTextureName("hardcoreenderexpansion:sphalerite");
		
		ravaged_brick = new BlockRavagedBrick()
		.setHardness(2.5F).setResistance(15F).setStepSound(Block.soundTypePiston)
		.setBlockName("ravagedBrick");
		
		dungeon_puzzle = new BlockDungeonPuzzle()
		.setBlockUnbreakable().setResistance(6000000F).setStepSound(Block.soundTypeMetal)
		.setBlockName("dungeonPuzzle");
		
		energy_cluster = new BlockEnergyCluster()
		.setHardness(0.7F).setResistance(0.2F).setStepSound(BlockEnergyCluster.soundTypeEnergyCluster)
		.setBlockName("energyCluster").setBlockTextureName("hardcoreenderexpansion:energy_cluster");
		
		corrupted_energy_high = new BlockCorruptedEnergy(true)
		.setBlockUnbreakable().setResistance(6000000F);
		
		corrupted_energy_low = new BlockCorruptedEnergy(false)
		.setBlockUnbreakable().setResistance(6000000F);
		
		laser_beam = new BlockLaserBeam()
		.setBlockUnbreakable().setLightLevel(1F).setResistance(6000000F)
		.setBlockName("laserBeam").setBlockTextureName("hardcoreenderexpansion:laser_beam");
		
		custom_spawner = new BlockCustomSpawner()
		.setHardness(5F).setStepSound(Block.soundTypeMetal)
		.setBlockName("mobSpawner").setBlockTextureName("mob_spawner");

		temple_end_portal = new BlockTempleEndPortal()
		.setHardness(-1F).setResistance(6000000F)
		.setBlockName("templeEndPortal");
				
		biome_core = new BlockBiomeIslandCore()
		.setBlockUnbreakable().setStepSound(Block.soundTypeStone)
		.setBlockName("biomeIslandCore").setBlockTextureName("bedrock");
		
		tabOrderedList.addBlocks(
			obsidian_end,obsidian_special,obsidian_special_glow,obsidian_stairs,
			essence_altar,decomposition_table,energy_extraction_table,
			end_powder_ore,stardust_ore,igneous_rock_ore,instability_orb_ore,energy_cluster,
			sphalerite,end_terrain,spooky_log,spooky_leaves,ravaged_brick,dungeon_puzzle,
			crossed_decoration,death_flower
		);
	}
	
	private BlockList(){} // static class
}
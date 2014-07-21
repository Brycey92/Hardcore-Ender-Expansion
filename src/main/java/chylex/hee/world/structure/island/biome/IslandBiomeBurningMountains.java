package chylex.hee.world.structure.island.biome;
import java.util.Random;
import chylex.hee.block.BlockEndstoneTerrain;
import chylex.hee.entity.mob.EntityMobFireGolem;
import chylex.hee.entity.mob.EntityMobScorchingLens;
import chylex.hee.mechanics.knowledge.data.KnowledgeRegistration;
import chylex.hee.world.structure.island.biome.data.BiomeContentVariation;
import chylex.hee.world.structure.island.biome.decorator.BiomeDecoratorBurningMountains;
import chylex.hee.world.structure.island.biome.decorator.IslandBiomeDecorator;
import chylex.hee.world.structure.util.pregen.LargeStructureWorld;
import chylex.hee.world.util.SpawnEntry;

public class IslandBiomeBurningMountains extends IslandBiomeBase{
	/*public static enum RareVariationMountains implements IRareVariationEnum{
		EXTRA_LILYFIRES, MORE_CAVES
	}
	*/
	
	public static final BiomeContentVariation SCORCHING = new BiomeContentVariation(8);
	public static final BiomeContentVariation MINE = new BiomeContentVariation(5);
	
	private final BiomeDecoratorBurningMountains decorator = new BiomeDecoratorBurningMountains();
	
	protected IslandBiomeBurningMountains(int biomeID, KnowledgeRegistration knowledgeRegistration){
		super(biomeID,knowledgeRegistration);
		spawnEntries.add(new SpawnEntry(EntityMobFireGolem.class,14,10));
		spawnEntries.add(new SpawnEntry(EntityMobScorchingLens.class,10,6));
	}

	@Override
	protected void decorate(LargeStructureWorld world, Random rand, int centerX, int centerZ){
		if (data.content == SCORCHING)decorator.genScorching();
		else if (data.content == MINE)decorator.genMine();
	}
	
	// TODO
	/*@Override
	public void decorateIsland(World world, Random rand, int centerX, int bottomY, int centerZ){
		

		if (rand.nextInt(5) <= 1)new StructureMountainResourcePit().generateInWorld(world,rand,centerX,bottomY,centerZ,this);
		new StructureMountainPuzzle().generateInWorld(world,rand,centerX,bottomY,centerZ,this);
	}*/
	
	@Override
	public float getIslandSurfaceHeightMultiplier(){
		return data.content == SCORCHING ? 7F : 8F;
	}
	
	@Override
	public float getIslandMassHeightMultiplier(){
		return data.content == SCORCHING ? 0.9F : 1F;
	}
	
	@Override
	public float getCaveAmountMultiplier(){
		return data.content == MINE ? 2.2F : 1.75F;
	}
	
	@Override
	public float getCaveBranchingChance(){
		return data.content == MINE ? 0.05F : 0.04F;
	}
	
	@Override
	public float getOreAmountMultiplier(){
		return data.content == MINE ? 1.4F : 1.15F;
	}

	@Override
	protected IslandBiomeDecorator getDecorator(){
		return decorator;
	}
	
	@Override
	public int getTopBlockMeta(){
		return BlockEndstoneTerrain.metaBurned;
	}
}

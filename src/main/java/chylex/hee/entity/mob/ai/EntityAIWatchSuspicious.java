package chylex.hee.entity.mob.ai;
import javax.annotation.Nullable;
import chylex.hee.entity.mob.ai.base.EntityAIAbstractWatching;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;

public class EntityAIWatchSuspicious extends EntityAIAbstractWatching{
	private final IWatchSuspiciousEntities entityHandler;
	
	public EntityAIWatchSuspicious(EntityCreature owner, IWatchSuspiciousEntities entityHandler){
		super(owner);
		this.entityHandler = entityHandler;
	}
	
	@Override
	protected float getHeadRotationSpeed(){
		return 30F;
	}
	
	@Override
	protected EntityLivingBase findTarget(){
		return entityHandler.getSuspiciousEntity();
	}
	
	public static interface IWatchSuspiciousEntities{
		@Nullable EntityLivingBase getSuspiciousEntity();
	}
}

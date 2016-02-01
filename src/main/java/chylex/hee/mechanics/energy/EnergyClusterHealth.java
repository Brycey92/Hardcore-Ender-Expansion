package chylex.hee.mechanics.energy;

public enum EnergyClusterHealth{
	HEALTHY (0x54FF54, 1.0F,  1.5F, 0F,     "energy.status.healthy"),
	WEAKENED(0xFFC454, 0.9F,  1.2F, 0F,     "energy.status.weakened"),
	TIRED   (0xFF7A54, 0.6F,  0.8F, 0F,     "energy.status.tired"),
	DAMAGED (0xFF5454, 0.4F,  0.5F, 0.007F, "energy.status.damaged"),
	UNSTABLE(0x8F8F8F, 0.15F, 0.2F, 0.015F, "energy.status.unstable");
	
	public static final EnergyClusterHealth[] values = values();
	
	public final int color;
	public final float regenAmountMp;
	public final float regenSpeedMp;
	public final float leakChance;
	public final String translationText;
	
	EnergyClusterHealth(int color, float regenAmountMp, float regenSpeedMp, float leakChance, String translationText){
		this.color = color;
		this.regenAmountMp = regenAmountMp;
		this.regenSpeedMp = regenSpeedMp;
		this.leakChance = leakChance;
		this.translationText = translationText;
	}
}

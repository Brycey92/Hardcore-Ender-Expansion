package chylex.hee.proxy;
import net.minecraft.entity.player.EntityPlayer;
import chylex.hee.game.ConfigHandler;
import chylex.hee.game.save.types.player.CompendiumFile;

public class ModCommonProxy{
	public static boolean opMobs, hardcoreEnderbacon;
	public static int achievementStartId;
	public static int renderIdObsidianSpecial, renderIdFlowerPot, renderIdSpookyLeaves, renderIdCrossedDecoration;
	
	public void loadConfiguration(){
		ConfigHandler.loadGeneral();
	}
	
	public EntityPlayer getClientSidePlayer(){
		return null;
	}
	
	public CompendiumFile getClientCompendium(){
		return null;
	}
	
	public void registerRenderers(){}
	public void registerSidedEvents(){}
	public void openGui(String type){}
	public void sendMessage(MessageType msgType, int[] data){}
	
	public static enum MessageType{
		DEBUG_TITLE_SET
	}
}
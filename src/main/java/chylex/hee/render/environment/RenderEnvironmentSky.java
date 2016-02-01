package chylex.hee.render.environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IRenderHandler;
import org.lwjgl.opengl.GL11;
import chylex.hee.system.util.MathUtil;
import chylex.hee.world.end.EndTerritory;
import chylex.hee.world.end.TerritoryEnvironment;
import chylex.hee.world.providers.WorldProviderHardcoreEnd;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEnvironmentSky extends IRenderHandler{
	public enum SkyTexture{
		DEFAULT("end_default"),
		BLUR("end_blur");
		
		final ResourceLocation resource;
		
		SkyTexture(String name){
			resource = new ResourceLocation("hardcoreenderexpansion:textures/environment/"+name+".png");
		}
	}
	
	@Override
	public void render(float partialTickTime, WorldClient world, Minecraft mc){
		final TerritoryEnvironment environment = ((WorldProviderHardcoreEnd)world.provider).getEnvironment(mc);
		final double voidFactor = EndTerritory.getVoidFactor(mc.thePlayer);
		
		GL11.glDisable(GL11.GL_FOG);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		
		OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA,1,0);
		RenderHelper.disableStandardItemLighting();
		GL11.glDepthMask(false);
		
		mc.renderEngine.bindTexture(environment.getSkyTexture().resource);
		
		Tessellator tessellator = Tessellator.instance;
		int color = environment.getSkyColor();
		int alpha = MathUtil.floor(255F-255F*MathUtil.clamp(voidFactor,0F,1F));

		for(int side = 0; side < 6; side++){
			GL11.glPushMatrix();
			
			switch(side){
				case 1: GL11.glRotatef(90F,1F,0F,0F); break;
				case 2: GL11.glRotatef(-90F,1F,0F,0F); break;
				case 3: GL11.glRotatef(180F,1F,0F,0F); break;
				case 4: GL11.glRotatef(90F,0F,0F,1F); break;
				case 5: GL11.glRotatef(-90F,0F,0F,1F); break;
			}
			
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_I(color,alpha);
			tessellator.addVertexWithUV(-100D,-100D,-100D,0D,0D);
			tessellator.addVertexWithUV(-100D,-100D,100D,0D,16D);
			tessellator.addVertexWithUV(100D,-100D,100D,16D,16D);
			tessellator.addVertexWithUV(100D,-100D,-100D,16D,0D);
			tessellator.draw();
			GL11.glPopMatrix();
		}

		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
	}
}

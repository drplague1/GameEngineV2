package com.raycaster.Renderer;

import java.io.IOException;
import com.raycaster.IO.IGameFile;
import com.raycaster.Bitmap.IBitmap;

public class EpicRayRenderingAttributes implements IRenderingAttributes {
	public int m_wallColor;
	public int m_floorColor;
	public int m_ceilColor;
	
	public boolean m_textured;
	
	public IBitmap<Integer> m_wallTexture;
	public IBitmap<Integer> m_floorTexture;
	public IBitmap<Integer> m_ceilTexture;

	public EpicRayRenderingAttributes(){
		m_wallColor = -1;
		m_floorColor = -1;
		m_ceilColor = -1;
		
		m_textured = false;
		
		m_wallTexture = null;
		m_floorTexture = null;
		m_ceilTexture = null;
	}
	
	public EpicRayRenderingAttributes(EpicRayRenderingAttributes ra) {
		m_wallColor = ra.m_wallColor;
		m_floorColor = ra.m_floorColor;
		m_ceilColor = ra.m_ceilColor;
		
		m_textured = ra.m_textured;
		
		m_wallTexture = ra.m_wallTexture;
		m_floorTexture = ra.m_floorTexture;
		m_ceilTexture = ra.m_ceilTexture;
	}

	public IBitmap<Integer> getWallTexture(){
		return m_wallTexture;
	}
	
	public IBitmap<Integer> getFloorTexture(){
		return m_floorTexture;
	}
	
	public IBitmap<Integer> getCeilingTexture(){
		return m_ceilTexture;
	}
	
	@Override
	public boolean saveToFile(IGameFile gameFile) throws IOException {
		gameFile.writeInt(m_wallColor);
		gameFile.writeInt(m_floorColor);
		gameFile.writeInt(m_ceilColor);
		
		gameFile.writeBoolean(m_textured);
		return true;
	}

	@Override
	public boolean loadFromFile(IGameFile gameFile) throws IOException {
		m_wallColor = gameFile.readInt();
		m_floorColor = gameFile.readInt();
		m_ceilColor = gameFile.readInt();
		
		m_textured = gameFile.readBoolean();
		return true;
	}

	@Override
	public String getTag() {
		return "ERRAttribs";
	}
}

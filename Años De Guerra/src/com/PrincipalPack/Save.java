package com.PrincipalPack;

import java.io.Serializable;

import org.andengine.engine.camera.BoundCamera;
import org.andengine.entity.scene.Scene;

public class Save implements Serializable{

	// WHAT TO SAVE:
	private BoundCamera mBoundChaseCamera;
	private Scene mMainScene;
	private volatile Map mMap;
	private volatile Player mPlayer;
	private String mapaName;
	private Maps mapas;
	public Save(BoundCamera mBoundChaseCamera, Scene mMainScene, Map mMap,
			Player mPlayer, String mapaName, Maps mapas) {
		
	}
	public BoundCamera getmBoundChaseCamera() {
		return mBoundChaseCamera;
	}
	public Scene getmMainScene() {
		return mMainScene;
	}
	public Map getmMap() {
		return mMap;
	}
	public Player getmPlayer() {
		return mPlayer;
	}
	public String getMapaName() {
		return mapaName;
	}
	public Maps getMapas() {
		return mapas;
	}
}

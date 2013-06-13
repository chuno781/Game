package com.PrincipalPack;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.andengine.engine.camera.hud.controls.AnalogOnScreenControl;
import org.andengine.engine.camera.hud.controls.AnalogOnScreenControl.IAnalogOnScreenControlListener;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.andengine.extension.physics.box2d.PhysicsWorld;

public class Player extends Character {
	private IAnalogOnScreenControlListener mIOnScreenControlListener;
	private ArrayList<Boolean> enemys;
	private boolean alive;
	public Player(float x, float y, String image,final Game app) {
		super(x, y, image, app);
		setStatistics(1000,1000, 1000);
		enemys=new ArrayList<Boolean>();
		alive=true;
		mIOnScreenControlListener=new IAnalogOnScreenControlListener() {
	
			@Override
			public void onControlChange(final BaseOnScreenControl pBaseOnScreenControl,  float pValueX,  float pValueY) {
				move(pValueX*1.2f,pValueY*1.2f);
			}

			@Override
			public void onControlClick(AnalogOnScreenControl arg0) {
				
			};
		};
	}
	@Override
	public void detach(final PhysicsWorld mPhysicsWorld) {
		mPhysicsWorld.destroyBody(mBody);
		enemys=new ArrayList<Boolean>();
		mAnimatedSprite.detachSelf();
	}
	@Override
	public void restVida(float f) {
		cVida-=f;
		app.setVida(cVida);
		if (cVida<=0){
			cVida=0;
			app.setVida(cVida);
			mAnimatedSprite.setAlpha(0.5f);
			attack=false;
			setAlive(false);
			app.mMap.cargarCharacters();
			new Timer().schedule(new TimerTask(){

				@Override
				public void run() {
					cVida=15;
					attack=true;
					setAlive(true);
					app.setVida(cVida);
					mAnimatedSprite.setAlpha(1);
				}
				
			}, 15000);
		}
	}
	@Override
	public void sumVida(float f) {
		cVida+=f;
		if (cVida>100){
			cVida=100;
		}
		app.setVida(cVida);
	}
	public IAnalogOnScreenControlListener getIOnScreenControlListener() {
		return mIOnScreenControlListener;
	}

	@Override
	public String toString(){
		return "player";
	}
	public int addEnemy() {
		int enem=enemys.size();
		enemys.add(true);
		return enem;
	}
	public int setEnemy(int id, boolean b) {
		if (id>=0&&id<enemys.size()){
			enemys.set(id, b);
		}else{
			id=enemys.size();
			enemys.add(b);
		}
		return id;
	}
	public boolean isFollowed() {
		boolean b=false;
		for(boolean b1 :enemys){
			b=b||b1;
		}
		return b;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}




	
}

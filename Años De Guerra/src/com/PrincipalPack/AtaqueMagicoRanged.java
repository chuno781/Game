package com.PrincipalPack;

import org.andengine.entity.sprite.AnimatedSprite.IAnimationListener;

public class AtaqueMagicoRanged extends Ataque {
	public AtaqueMagicoRanged(float x, float y,int direction,float velocidad,float da�o,IAnimationListener listener,Character creador,Game app1){
		super(x,y,direction,velocidad,da�o,"BlueFire.png",listener,creador,app1);
		type="magicRanged";
	}
	
}

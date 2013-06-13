package com.PrincipalPack;

import org.andengine.entity.sprite.AnimatedSprite.IAnimationListener;

public class AtaqueMagicoRanged extends Ataque {
	public AtaqueMagicoRanged(float x, float y,int direction,float velocidad,float daño,IAnimationListener listener,Character creador,Game app1){
		super(x,y,direction,velocidad,daño,"BlueFire.png",listener,creador,app1);
		type="magicRanged";
	}
	
}

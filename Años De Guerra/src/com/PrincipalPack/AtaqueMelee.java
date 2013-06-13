package com.PrincipalPack;

import org.andengine.entity.sprite.AnimatedSprite.IAnimationListener;

public class AtaqueMelee extends Ataque{
	public AtaqueMelee(float x, float y,int direction,float daño,IAnimationListener listener,Character creador,Game app1){
		super(x,y,direction,0,daño,"AtaqueCerca.png",listener,creador,app1);
		type="melee";
	}
}


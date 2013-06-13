package com.PrincipalPack;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.extension.tmx.TMXObject;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class MapItem {
	Item item;
	private Body mBody;
	private Sprite mSprite;

	public MapItem(TMXObject object, Game app, Map mMap) {
		int w=40,h=40;
		BitmapTextureAtlas texture = new BitmapTextureAtlas(app.getTextureManager(), w, h, TextureOptions.BILINEAR);
		ITextureRegion region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(texture, app, object.getTMXObjectProperties().get(2).getValue(), 0, 0);
		texture.load();
		this.mSprite= new Sprite(object.getX(), object.getY(),w,h,region,app.getVertexBufferObjectManager());
   		mMap.getMapScene().attachChild(mSprite);
        this.mBody=PhysicsFactory.createBoxBody(mMap.getmPhysicsWorld(), mSprite, BodyType.KinematicBody, app.ZERO_FIXTURE_DEF);
        mBody.setUserData(this);
        mMap.getmPhysicsWorld().registerPhysicsConnector(new PhysicsConnector(mSprite, mBody, false, false));
        item=new Item(object.getTMXObjectProperties().get(2).getValue(), object.getName(), Integer.valueOf(object.getTMXObjectProperties().get(0).getValue()), Integer.valueOf(object.getTMXObjectProperties().get(1).getValue()), object.getType());

	}

	public Item getItem() {
		// TODO Auto-generated method stub
		return item;
	}

	public void detach(final PhysicsWorld mPhysicsWorld) {
		mSprite.registerUpdateHandler(new IUpdateHandler(){

			@Override
			public void onUpdate(float arg0) {
				// TODO Auto-generated method stub
				if(!mBody.isActive()){
					if(!mSprite.isVisible()){
						mPhysicsWorld.destroyBody(mBody);
						mSprite.detachSelf();
						mSprite.unregisterUpdateHandler(this);
						return;
					}
					mSprite.setVisible(false);
					return;
				}
				mBody.setActive(false);
		
	
			}

			@Override
			public void reset() {
				// TODO Auto-generated method stub
				
			}
			
		});	}
	@Override
	public String toString(){
		return "object";	
	}
}

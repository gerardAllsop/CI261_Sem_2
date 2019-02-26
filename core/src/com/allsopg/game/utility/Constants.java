package com.allsopg.game.utility;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by gerard on 09/11/2016.
 * Updated 17/02/18
 */

public class Constants {
    //Screen Size
    public static final float VIRTUAL_WIDTH = Gdx.graphics.getWidth();
    public static final float VIRTUAL_HEIGHT = Gdx.graphics.getHeight();
    public static final float CAMERASPEED = 0.15f;
    public static final float CAMERAOFFSET = 250f;

    //Animation Speed
    public static final float FRAME_DURATION = 1.0f / 30.0f;

    //World to screen scale
    public static final float TILE_SIZE   = 32;
    public static final float UNITSCALE = 1.0f / TILE_SIZE;

    public static final float TIME_STEP=1/60f;

    public static final int VELOCITY_ITERATIONS = 6;
    public static final int POSITION_ITERATIONS = 2;

    public static final String BACKGROUND = "tileData/assignment_two.tmx";
    public static final String PHYSICS_MATERIALS_PATH = "tileData/physicsData.json";

    public static final float DENSITY=.5f;
    public static final float FRICTION=.5f;
    public static final float RESTITUTION=.5f;
    //player body
    public static float PLAYER_OFFSET=60;
    public static float BODY_WIDTH_OFFSET=1;
    //player graphics
    public static final String PLAYER_ATLAS_PATH = "atlas/smurf_assets.atlas";
    public static final Texture MEDIUM = new Texture(Gdx.files.internal("gfx/mediumSize.png"));
    public static final Texture SMALL = new Texture(Gdx.files.internal("gfx/smallSize.png"));
    public static final Texture TINY = new Texture(Gdx.files.internal("gfx/tinySize.png"));
    //Speed
    public static final float MAX_VELOCITY = 2f;
    public static final float MAX_HEIGHT = 15;
    //player body
    public static final float FORCE_X=30f;
    public static final float FORCE_Y=30f;
    public static int PLAYER_WIDTH= 3;
    public static int PLAYER_HEIGHT=4;
    public static float PLAYER_OFFSET_Y=2.15f;
    public static float PLAYER_OFFSET_X=1.5f;

    //player start position
    public static final Vector2 START_POSITION = new Vector2(10,10);

}

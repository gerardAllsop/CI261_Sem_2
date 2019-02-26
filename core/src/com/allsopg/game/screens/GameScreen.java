package com.allsopg.game.screens;

import com.allsopg.game.TBWGame;
import com.allsopg.game.bodies.PlayerCharacter;
import com.allsopg.game.gameInterface.GameControl;
import com.allsopg.game.physics.WorldManager;
import com.allsopg.game.utility.CameraControl;
import com.allsopg.game.utility.Constants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

import static com.allsopg.game.utility.Constants.PLAYER_ATLAS_PATH;
import static com.allsopg.game.utility.Constants.SMALL;
import static com.allsopg.game.utility.Constants.START_POSITION;
import static com.allsopg.game.utility.Constants.UNITSCALE;
import static com.allsopg.game.utility.Constants.VIRTUAL_HEIGHT;
import static com.allsopg.game.utility.Constants.VIRTUAL_WIDTH;

/**
 * Created by gerard on 12/02/2017
 * updated Feb 2019
 */

public class GameScreen extends ScreenAdapter {
    private TBWGame game;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private GameControl control;
    private PlayerCharacter smif;
    private float frameDelta = 0;

    public GameScreen(TBWGame tbwGame){this.game = tbwGame;}

    @Override
    public void show() {
        super.show();
        tiledMap = game.getAssetManager().get(Constants.BACKGROUND);
        orthogonalTiledMapRenderer = new OrthogonalTiledMapRenderer(this.tiledMap,UNITSCALE);
        orthogonalTiledMapRenderer.setView(CameraControl.getInstance().getCamera());
        if(!WorldManager.isInitialised()){WorldManager.initialise(tiledMap);}
        game.viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, CameraControl.getInstance().getCamera());
        game.batch.setProjectionMatrix(CameraControl.getInstance().getCamera().combined);
        smif = new PlayerCharacter(PLAYER_ATLAS_PATH,SMALL,START_POSITION);
        control = new GameControl();
        Gdx.input.setInputProcessor(control);
    }

    @Override
    public void render(float delta) {
        frameDelta += delta;
        smif.update(frameDelta);
        clearScreen();
        control.update();
        draw();
        WorldManager.getInstance().doPhysicsStep(delta);
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g,
                Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void draw() {
       orthogonalTiledMapRenderer.setView(CameraControl.getInstance().getCamera());
       orthogonalTiledMapRenderer.render();
        game.batch.begin();
         smif.draw(game.batch);
        game.batch.end();
        WorldManager.getInstance().debugRender(game);
    }

    @Override
    public void resize(int width, int height) {
        CameraControl.getInstance().getCamera().setToOrtho(false, VIRTUAL_WIDTH * UNITSCALE, VIRTUAL_HEIGHT * UNITSCALE);
        game.batch.setProjectionMatrix(CameraControl.getInstance().getCamera().combined);
    }
}
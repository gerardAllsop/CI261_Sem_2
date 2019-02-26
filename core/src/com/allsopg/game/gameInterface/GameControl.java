package com.allsopg.game.gameInterface;

/**
 * Created by gerard on 17/02/2017
 * Update Feb 2019
 *
 */

import com.allsopg.game.utility.CameraControl;
import com.allsopg.game.utility.CurrentDirection;
import com.badlogic.gdx.scenes.scene2d.Stage;
import static com.allsopg.game.utility.CurrentDirection.STOP;

public class GameControl extends Stage {
    private CurrentDirection direction = STOP;
    private boolean mousePressed = false;

    public GameControl() { }

    public void update() {
        if(mousePressed){
            CameraControl.getInstance().moveMainCamera();
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        CameraControl.getInstance().storeCameraPos();
        mousePressed=true;
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        mousePressed=false;
        return false;
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }
    @Override
    public boolean keyTyped(char character) {
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
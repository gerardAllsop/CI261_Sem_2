package com.allsopg.game.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

import static com.allsopg.game.utility.Constants.CAMERAOFFSET;
import static com.allsopg.game.utility.Constants.CAMERASPEED;


public class CameraControl {
    // a camera
    private OrthographicCamera camera;
    //which direction is the main camera going?
    private CurrentDirection cameraDirection = CurrentDirection.STOP;
    //what was the position of the camera when the mouse was clicked
    private Vector2 cameraPressPos;
    //static ref required for singleton access
    private static CameraControl instance;

    //constructor
    private CameraControl() {
        camera = new OrthographicCamera();
        camera.position.set(Constants.VIRTUAL_WIDTH / 2, Constants.VIRTUAL_HEIGHT / 2, 0);
        camera.update();
        cameraPressPos = new Vector2();
    }
    //Singleton access
    public static CameraControl getInstance() {
        if (instance == null)
            instance = new CameraControl();
        return instance;
    }
    //return a ref to the camera
    public OrthographicCamera getCamera() {
        return camera;
    }
    //store the current camera position
    public void storeCameraPos() {
        cameraPressPos.x = camera.position.x;
        cameraPressPos.y = camera.position.y;
    }
    //move the main camera
    public void moveMainCamera(){
        if (Gdx.input.getX() - cameraPressPos.x-CAMERAOFFSET > 0) {
            camera.translate(CAMERASPEED, 0);
            cameraDirection = CurrentDirection.RIGHT;
        } else {
            camera.translate(-CAMERASPEED, 0);
            cameraDirection = CurrentDirection.LEFT;
        }
        camera.update();
    }
}



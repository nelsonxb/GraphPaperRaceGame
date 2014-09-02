package io.github.nelsoncrosby.gprg

import io.github.nelsoncrosby.gprg.entity.Camera
import io.github.nelsoncrosby.gprg.track.Track
import org.newdawn.slick.*

/**
 *
 */
class GPRGame extends BasicGame {
    Input input
    Camera camera
    Track track
    GPRGame() {
        super(CONST.TITLE)
    }

    @Override
    void init(GameContainer gc) throws SlickException {
        gc.showFPS = false
        input = new Input(gc.getHeight())
        track = new Track(Track.getResourceAsStream('test1.track'))
        float aspectRatio = gc.getWidth() / gc.getHeight()
        camera = new Camera(gc, track, aspectRatio)
    }

    @Override
    void update(GameContainer gc, int delta) throws SlickException {
        if (input.isKeyDown(Input.KEY_W)) {camera.moveY(CONST.DOWN)}
        if (input.isKeyDown(Input.KEY_S)) {camera.moveY(CONST.UP)}
        if (input.isKeyDown(Input.KEY_A)) {camera.moveX(CONST.LEFT)}
        if (input.isKeyDown(Input.KEY_D)) {camera.moveX(CONST.RIGHT)}
    }

    @Override
    void render(GameContainer gc, Graphics gx) throws SlickException {
        track.render(gx)
    }

    /**
     * Entry point.
     * @param args Command-line arguments
     */
    static void main(String[] args) {
        // Stops your system yelling if game controllers aren't found
        Input.disableControllers()

        // Initialize the game
        // May throw SlickException
        AppGameContainer appgc = new AppGameContainer(new GPRGame())
        appgc.setDisplayMode(640, 480, false)
        appgc.start()
    }
}

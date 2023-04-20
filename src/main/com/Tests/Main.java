package com.Tests;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import com.Entities.Player;
import com.utils.App;
import com.utils.Button;

public class Main extends App {
    private MainMenu menu = new MainMenu();
    private Player p = new Player(0, 0);
    //
    public Main(String title, int width, int height, int desiredFps, Integer frameBuffer/*, Camera cam*/) {
        super(title, width, height, desiredFps, frameBuffer/*, cam*/);
        //
        addCustomKey("Q", KeyEvent.VK_Q); // Example of how to add a new key other than the defaults -> [w,a,s,d,esc,spc(space)]
    }

    private BufferedImage img;
    private Color color = new Color(0, 0, 0);
    private int[][] pixels;

    @Override
    public void render() {
        img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        //
        Random r = new Random();
        //
        int[] sp = p.sprite.getPixels(); // sp (sprite pixels)
        //
        for(int row = 0; row < img.getWidth(); row++) {
            for(int col = 0; col < img.getHeight(); col++) {
                color = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255));
                img.setRGB(row, col, color.getRGB());
            }
        }
        //
        g.drawImage(img, 0, 0, null);
        //
    }

    @Override
    public void update(float delta) { // delta is the time between now and the last frame or the FPS
        if(gameState == GameState.Menu) { menu.show(); }
        else { menu.hide(); }
    }
    //
    public static void main(String[] args) {
        new Main("Test Application", 800, 600, 60, 10/*, cam*/).run();
    }
    //
    public GameState gameState = GameState.Game;
    //
    public enum GameState {
        Game,
        Menu
    }
    //
    @Override
    public void input() { // an elagent solution such as if( keypressed( "{KEY}" ) ) {KEY} being the name / letter of the key
        if(keypressed("w")) {
            p.x += p.dx*5;
            p.y += p.dy*5;
        }
        if(keypressed("a")) {
            p.angle += 2;
            FixAng(p.angle);
        }
        if(keypressed("s")) {
            p.x -= p.dx*5;
            p.y -= p.dy*5;
        }
        if(keypressed("d")) {
            p.angle -= 2;
            FixAng(p.angle);
        }
        if(keypressed("esc")) {
            gameState = GameState.Menu;
        }
    }
    //
    private void FixAng(double a) {
        if(a < 0) a += 360;
        if(a > 359) a -= 360;
    }
    //
    @SuppressWarnings("unused")
    private double DegToRad(double a) {
        return a * Math.PI/180.0;
    }
    //
    public class MainMenu {
        private Button btn;
        //
        public MainMenu() {
            btn = new Button("Play",40, 100, 100, 100);
            //
            btn.addActionListener((e) -> {
                gameState = GameState.Game;
            });
            //
            add(btn);
            btn.setVisible(false);
        }
        //
        public void show() {
            btn.setVisible(true);
            btn.setSize(btn.width, btn.height);
            btn.setLocation(btn.x, btn.y);
            //
        }
        //
        public void hide() {
            btn.setVisible(false);
        }
    }
    //
}
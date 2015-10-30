package com.mygdx.click;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
public class MyGdxGame extends ApplicationAdapter {

	final Game game;
	Skin skin;
	Stage stage;
	TextButton newGameButton;
	BitmapFont font;
	SpriteBatch batch;
	BitmapFontCache creators;

	public MyGdxGame(final Game game) {
		this.game = game;

		batch = new SpriteBatch();
		stage = new Stage();


		//soTheme = Gdx.audio.newSound(Gdx.files.internal("Professor Layton and the Mask of Miracle Theme"));

		createBasicSkin();
		stage.addActor(newGameButton);

	}
	@Override
	public void create() {
		font = new BitmapFont(Gdx.files.internal("fonts/8-BIT_WONDER.fnt"));

		creators = new BitmapFontCache(font);
		creators.addText("k9 and shizeni", Gdx.graphics.getWidth() - (font.getXHeight() * 15), 0 + font.getXHeight() * font.getScaleY());

		skin = new Skin();
		skin.add("default", font);

		//Create a texture
		Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 10, Pixmap.Format.RGB888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("background", new Texture(pixmap));

		//Create a button style
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("background", Color.BLACK);
		textButtonStyle.down = skin.newDrawable("background", Color.BLACK);
		textButtonStyle.checked = skin.newDrawable("background", Color.BLACK);
		textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle);

		/*newGameButton = new TextButton("Begin", skin); // Use the initialized skin
		newGameButton.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2);
		newGameButton.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				VibeoGam.soSelect.play();
				game.setScreen(new Choices(game));*/
	}
}
@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
		batch.begin();
		creators.draw(batch);
		batch.end();
	}
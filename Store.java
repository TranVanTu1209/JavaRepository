import java.awt.*;
public class Store {
	public static int shopWidth = 8;
	public static int buttonSize = 52;
	public static int cellSpace = 3;
	public static int awayFromeRoom = 29;
	public static int iconSize = 20;
	public static int iconSpace = 7;
	public static int iconTextY = 16;
	public Rectangle[] button = new Rectangle[shopWidth];
	public Rectangle buttonHealth;
	public Rectangle buttonCoins;

	public Store(){
		define();
	}
	public void define(){
		for(int i = 0; i < button.length; i++){
		button[i] = new Rectangle( Screen.myWidth/2 - (shopWidth*(buttonSize + cellSpace))/2  + (buttonSize + cellSpace )*i
		,Screen.room.blocks[Screen.room.worldHeight - 1][0].y + awayFromeRoom + Screen.room.blockSize
		,buttonSize, buttonSize);
		}
	buttonHealth = new Rectangle(Screen.room.blocks[0][0].x - 1, button[0].y, iconSize, iconSize);
	buttonCoins = new Rectangle(Screen.room.blocks[0][0].x - 1, button[0].y + button[0].height - iconSize, iconSize, iconSize);
	}
	public void draw(Graphics g){
		for(int i = 0; i < button.length; i++){
//			if(button[i].contains(Screen.mse)){
//				g.setColor(new Color(255,255,255,100));
//				g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);
//			}
			g.drawImage(Screen.titleset_res[2] ,button[i].x, button[i].y, button[i].width, button[i].height, null);
		}
		g.drawImage(Screen.titleset_res[1],buttonHealth.x,  buttonHealth.y, buttonHealth.width, buttonHealth.height, null);
		g.drawImage(Screen.titleset_res[0],buttonCoins.x,  buttonCoins.y, buttonCoins.width, buttonCoins.height, null);
		g.setColor(Color.white);
		g.setFont(new Font("Time New Roman", Font.BOLD, 16 ));
		g.drawString("" + Screen.health, buttonHealth.x + buttonHealth.width + iconSpace , buttonHealth.y + iconTextY );
		g.drawString("" + Screen.money, buttonCoins.x + buttonCoins.width + iconSpace , buttonCoins.y + iconTextY );

	}

}

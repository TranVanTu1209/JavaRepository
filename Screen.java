import java.awt.*;
import java.awt.image.*;

import javax.swing.*;

import java.io.*;
public class Screen extends JPanel implements Runnable {
	public Thread thread = new Thread(this);
	public static int myWidth, myHeight;
	public static boolean isFirst = true;
	public static Room room ;
	public static Save save;
	public static Store store;
	public static Point mse = new Point(0, 0);
	public static Image[] titleset_ground = new Image[50];
	public static Image[] titleset_air = new Image[50];
	public static Image[] titleset_res = new Image[50];
	public static Image[] monster_image = new Image[50];
	public static int money = 10, health = 100;
	
	public static Monster[] monster = new Monster[50];
	 public Screen(Frame frame){
		 frame.addMouseListener(new KeyHandle());
		 frame.addMouseMotionListener(new KeyHandle());
		 thread.start();
	 }
	 public void define() throws FileNotFoundException{
		 room = new Room();
		 save =  new Save();
		 store = new Store();
		 
		 
		 for(int i = 0; i < titleset_ground.length; i++){
			 titleset_ground[i] = new ImageIcon("resourses/titleset_ground.jpg").getImage();
			 titleset_ground[i] = createImage(new FilteredImageSource(titleset_ground[i].getSource(),
					 new CropImageFilter(0, 26*i, 26, 26)));
		 }
		 for(int i = 0; i < titleset_air.length; i++){
			 titleset_air[i] = new ImageIcon("resourses/titleset_air.jpg").getImage();
			 titleset_air[i] = createImage(new FilteredImageSource(titleset_air[i].getSource(),
					 new CropImageFilter(0, 26*i, 26, 26)));
		 }
		
		titleset_res[0] = new ImageIcon("resourses/coin.png").getImage();
		titleset_res[1] = new ImageIcon("resourses/heart.png").getImage();
		titleset_res[2] = new ImageIcon("resourses/cell.png").getImage();
		monster_image[0] = new ImageIcon("resourses/monster.png").getImage();
		save.loadSave(new File("save/mission1.text"));
		for(int i = 0; i < monster.length; i++){
			 monster[i] = new Monster();
			 monster[i].spawnMonster(0);
		 }

	 }
	 public void paintComponent(Graphics g){
		 if(isFirst){
			 myWidth = getWidth();
			 myHeight = getHeight();
			 //System.out.println("my width = " + myWidth);
			 //System.out.println("my height = " + myHeight);
			 try {
				define();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			 isFirst = false;
		 }
		g.setColor(new Color(50,  50,  50));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.CYAN);
		room.draw(g);   // drawing the room.
		for(int i = 0; i < monster.length; i++){
			if(monster[i].inGame == true){
				monster[i].draw(g);
			}
		}
		
		store.draw(g); //drawing the store
	 }

	public static int fpsFrame = 0, fps = 1000000;
	public int spawnTime  = 1500, spawnFrame = 0;
	public void monsterSpawner(){
		if(spawnFrame >= spawnTime){
			for(int i = 0; i < monster.length; i++){
				if(!monster[i].inGame){
					monster[i].spawnMonster(0);
					break;
				}
			}
			spawnFrame = 0;
		}else{
			spawnFrame++;
		}
	}
	 public void run(){
		 while(true){
			 if(!isFirst){ 
				 room.physic();
				 monsterSpawner();
				 for(int i = 0; i < monster.length; i++){
					 if(monster[i].inGame){
						 monster[i].physic();
					 }
				 }
			 }
			 repaint();
			 try{
				 Thread.sleep(100);
			 }catch(Exception e){
				 
			 }
		 }
	 }
}

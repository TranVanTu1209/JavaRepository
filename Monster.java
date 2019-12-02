import java.awt.*;
public class Monster extends Rectangle {
	public int xC, yC;
	public int monSize = 52;
	public int monID = Value.monsterAir;
	public boolean inGame = false;
	public Monster(){
		
	}
	public void spawnMonster(int monID){
		for(int y = 0; y < Screen.room.blocks.length; y++){
			if(Screen.room.blocks[y][0].groundId == Value.groundRoad){
				setBounds(Screen.room.blocks[y][0].x, Screen.room.blocks[y][0].y, monSize, monSize);
				xC = 0;
				yC = y;
			}
		}
		this.monID = monID;
		inGame = true;
	}
	public int walkFrame = 0, walkSpeed = 1000;
	public void draw(Graphics g){
		if(inGame == true){
			g.drawImage(Screen.monster_image[monID], x, y, width, height, null);
		}
	}
	public void physic() {
		if(walkFrame >= walkSpeed){
			x++;
			walkFrame++;
		}
		else{
			walkFrame++;
		}
			
		
	}
}

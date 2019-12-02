import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Save {
	public void loadSave(File loadPath) throws FileNotFoundException{
		Scanner loadScanner  = new Scanner(loadPath);
		while(loadScanner.hasNext()){
			for(int y = 0; y < Screen.room.blocks.length; y++){
				for(int x = 0; x < Screen.room.blocks[0].length; x++){
					Screen.room.blocks[y][x].groundId = loadScanner.nextInt(); 
				}
			}
			
			for(int y = 0; y < Screen.room.blocks.length; y++){
				for(int x = 0; x < Screen.room.blocks[0].length; x++){
					Screen.room.blocks[y][x].airId = loadScanner.nextInt(); 

				}
			}
		}
		loadScanner.close();
	}
}

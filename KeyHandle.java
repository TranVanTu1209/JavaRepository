import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class KeyHandle implements MouseMotionListener, MouseListener{

	
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Screen.mse = new Point(e.getX() - (Frame.size.width - Screen.myWidth)/2,
				e.getY() + (Frame.size.height - Screen.myHeight )/2  );
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Screen.mse = new Point(e.getX() - (Frame.size.width - Screen.myWidth)/2,
				e.getY() - (Frame.size.height - Screen.myHeight )/2  );
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	


	
	
		
}

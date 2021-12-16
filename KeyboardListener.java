import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class KeyboardListener extends JPanel {
	
	public KeyboardListener() {
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}
	
}


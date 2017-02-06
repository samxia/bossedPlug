package applet;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class AppApplet extends Applet implements ActionListener {
	JButton button = null;

	public void paint(Graphics g) {

		g.drawRect(0, 0, 499, 149);
		g.drawString("Hello World", 5, 70);
	}

	public void init() {
		button = new JButton();
		this.add(button);
		button.addActionListener(this);
		button.setText("calculator");
		button.setActionCommand("calc");

	}

	/** * 通过applet调用本地的计算器 */
	public void openApp() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				String url = "C:\\WINDOWS\\system32\\calc.exe";
				System.out.println("url=" + url);
				try {
					Runtime.getRuntime().exec(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("calc".equals(cmd)) {
			this.openApp();
		}

	}

}

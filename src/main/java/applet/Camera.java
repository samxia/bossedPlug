package applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoDataSourceException;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.protocol.DataSource;
import javax.media.protocol.SourceCloneable;
import javax.media.util.BufferToImage;
import javax.swing.JOptionPane;

public class Camera extends Applet implements ItemListener, ActionListener {

	Player player = null;
	Button buttonPlay = null, buttonTakePhoto = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public void init() {
		this.resize(500, 400);
		this.add(new Label("hello"));
		CaptureDeviceInfo[] cdis = this.getVideoDevices();
		String count = String.valueOf(cdis.length);
		this.add(new Label(count));
		Choice c = new Choice();

		System.out.println(cdis.length);
		
		for (int i = 0; i < cdis.length; i++) {
			CaptureDeviceInfo cdi = cdis[i];
			// this.add(new Label(cdi.getName()));
			c.add(cdi.getName());
		}
		c.addItemListener(this);
		this.add(c);

		this.add(new Label("end"));

		// if there is only one device,just play
		if (cdis.length == 1) {
			this.showCameraByDeviceName(cdis[0].getName());
		}
	}

	public String testInvoke() {
		return "this msg come from applet";

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (!(e.getSource() instanceof java.awt.Choice)) {
			return;
		}
		System.out.println(e.getItem());
		// show camera by device name
		this.showCameraByDeviceName(e.getItem().toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == buttonPlay) {
			Button b = (Button) obj;
			this.playAndPause(b);
			return;
		}
		if (obj == buttonTakePhoto) {
			this.takePhoto();
		}
	}

	private void takePhoto() {
		Component comp = player.getVisualComponent();
		comp.getGraphics();
		FrameGrabbingControl fgc = (FrameGrabbingControl) player
				.getControl("javax.media.control.FrameGrabbingControl");
		Buffer buffer = fgc.grabFrame();

		BufferToImage bufferToImage = new BufferToImage(
				(VideoFormat) buffer.getFormat());
		Image image = bufferToImage.createImage(buffer);
		if (image == null || image.equals("null") || image.equals(null)) {
			JOptionPane.showMessageDialog(null, "请先拍照再保存");
		} else {
			try {
				ImageIO.write((RenderedImage) image, "GIF", new File(
						"g:\\2.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void playAndPause(Button b) {
		String label = b.getLabel();
		// System.out.println(label);
		if (label.equals("暂停")) {
			player.stop();
			b.setLabel("播放");
			return;
		}
		if (label.equals("播放")) {
			player.start();
			b.setLabel("暂停");
			return;
		}
	}

	private void showCameraByDeviceName(String deviceName) {
		//in case,show twice.
		if(this.player!=null)
		{
			return;
		}
		// 根据设备名称返回component，并加入到panel
		Component comp = this.getCameraComponentByDeviceName(deviceName);
		if (comp != null) {
			this.add(comp);
			buttonPlay = new Button("暂停");
			buttonPlay.addActionListener(this);
			this.add(buttonPlay);

			buttonTakePhoto = new Button("拍照");
			buttonTakePhoto.addActionListener(this);
			this.add(buttonTakePhoto);

		}
		this.resize(500, 400 + 2);// for refresh.
	}

	private Component getCameraComponentByDeviceName(String deviceName) {
		// CaptureDeviceInfo device =
		// CaptureDeviceManager.getDevice("vfw:Microsoft WDM Image Capture (Win32):0");
		CaptureDeviceInfo device = CaptureDeviceManager.getDevice(deviceName);
		// 取得当前设备的MediaLocator
		MediaLocator ml = device.getLocator();// //从已知设备中取所有视频设备的列表
		DataSource datasource = null;

		try {
			datasource = Manager.createDataSource(ml);

			DataSource cloneabledatasource = Manager
					.createCloneableDataSource(datasource);
			DataSource cloneddatasource = ((SourceCloneable) cloneabledatasource)
					.createClone();

			// 用已经取得的MediaLocator得到一个Player

			player = Manager.createRealizedPlayer(cloneabledatasource);
		} catch (NoPlayerException | CannotRealizeException | IOException
				| NoDataSourceException e) {
			e.printStackTrace();
			return new Label(e.getMessage());
		}

		player.start();

		// 取得Player的AWT Component
		Component comp = player.getVisualComponent();
		// 如果是音频设备这个方法将返回null,这里要再判断一次
		if (comp != null) {
			// 将Component加到窗体
			return comp;
		}
		return null;
	}

	// 取系统所有可采集的硬件设备列表
	private CaptureDeviceInfo[] getDevices() {
		Vector devices = CaptureDeviceManager.getDeviceList(null);
		// System.out.println(" CaptureDeviceManager.getDeviceList(null)=:"+devices.size());
		CaptureDeviceInfo[] info = new CaptureDeviceInfo[devices.size()];
		for (int i = 0; i < devices.size(); i++) {
			info[i] = (CaptureDeviceInfo) devices.get(i);
		}
		return info;
	}

	// 从已知设备中取所有视频设备的列表
	public CaptureDeviceInfo[] getVideoDevices() {
		CaptureDeviceInfo[] info = getDevices();
		CaptureDeviceInfo[] videoDevInfo;
		Vector vc = new Vector();
		for (int i = 0; i < info.length; i++) {
			// 取设备支持的格式，如果有一个是视频格式，则认为此设备为视频设备
			Format[] fmt = info[i].getFormats();
			for (int j = 0; j < fmt.length; j++) {
				// System.out.println(fmt[j].toString());
				if (fmt[j] instanceof VideoFormat) {
					vc.add(info[i]);
				}
				break;
			}
		}
		videoDevInfo = new CaptureDeviceInfo[vc.size()];
		for (int i = 0; i < vc.size(); i++) {
			videoDevInfo[i] = (CaptureDeviceInfo) vc.get(i);
		}
		return videoDevInfo;
	}

}

package view;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainWindow extends JFrame{
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu editJMenu;
	private JMenuItem menuItemTextDocument;
	private JMenuItem menuItemSpreadSheet;
	private JMenuItem menuItemSave;
	private MenuItem menuAbout;
	private MenuItem menuOpen;
	private MenuItem menuClose;
	private TrayIcon trayIcon;
	private PopupMenu popup;
	
	
	
	
	public MainWindow(){
		initializeComponent();
		addMenuItemsToPopup();
		addMenuItemsToMenu();
		addMenusToMenuBar();
		addComponentsToWindow();
		registerListeners();
		setWindowProperties();
	}

	public void initializeComponent() {
		desktopPane = new JDesktopPane();
		menuBar = new JMenuBar();
		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_A);
		editJMenu = new JMenu("Edit");
		editJMenu.setMnemonic(KeyEvent.VK_S);
		menuItemTextDocument = new JMenuItem("Text Document");
		menuItemSpreadSheet = new JMenuItem("SpreadSheet");
		menuItemSave = new JMenuItem("Save Item");
		menuItemSave.setToolTipText("Saves the active document");
		menuAbout = new MenuItem("About");
		menuOpen = new MenuItem("Open");
		menuClose = new MenuItem("Close");
		popup = new PopupMenu("Popup");
		trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage("images/app.png"), "Application Name", popup);
		trayIcon.setPopupMenu(popup); 
		
	}
	
	public void addMenuItemsToPopup() {
		popup.add(menuAbout);
		popup.add(menuOpen);
		popup.add(menuClose);
	}
	
	public void addMenuItemsToMenu() {
		file.add(menuItemTextDocument);
		file.add(menuItemSpreadSheet);
		editJMenu.add(menuItemSave);
	}
	
	public void addMenusToMenuBar() {
		menuBar.add(file);
		menuBar.add(editJMenu);
	}
	
	public void addComponentsToWindow() {
		this.add(desktopPane);
	}
	
	public void registerListeners() {
		
		menuItemTextDocument.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desktopPane.add(new TextDocumentFrame());
			}
		});
		
		menuItemSpreadSheet.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desktopPane.add(new SpreadSheetDocumentFrame());
			}
		});
		
		menuClose.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SystemTray.getSystemTray().remove(trayIcon);
				System.exit(0); 
			}
		});
		
		menuAbout.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "info about this awsome app");
			}
		});
		
		menuOpen.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SystemTray.getSystemTray().remove(trayIcon);
				setVisible(true); 
			}
		});
		
		this.addWindowListener( new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					SystemTray.getSystemTray().add(trayIcon);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}); 
		
	}
	
	public void setWindowProperties() {
		this.setJMenuBar(menuBar);
		this.setSize(1020, 700);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
}

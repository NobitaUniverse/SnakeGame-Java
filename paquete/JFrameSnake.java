package paquete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class JFrameSnake extends JFrame implements KeyListener {

	private JPanel contentPane;
	public PanelSnake snake;
	private JLabel lblNewLabel;
	public static JLabel lblPuntaje;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameSnake frame = new JFrameSnake();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameSnake() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameSnake.class.getResource("/img/snake.png")));
		setTitle("Snake_Basilio");
		addKeyListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/** Panel Principal ----------------------------------------------------- */
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(100, 130, 2));
		panelPrincipal.setBounds(0, 0, 559, 606);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
	
		
		/** Panel Snake */
		snake = new PanelSnake(506,23);
		panelPrincipal.add(snake);
		
		int bordeSup = ( panelPrincipal.getHeight() - snake.tam ) / 2;
		int bordeLat = ( panelPrincipal.getWidth() - snake.tam ) / 2;

		snake.setBounds(bordeLat,bordeSup,505,505);
		snake.setLayout(null);
		snake.setOpaque(false);
		
		/** Panel Fondo */
		PanelFondo fondo = new PanelFondo(506,23); // 506 pixeles de lado y 23 cuadrados de lado
		panelPrincipal.add(fondo);
		fondo.setBounds(bordeLat,bordeSup,505,505);
		fondo.setLayout(null);
		fondo.setOpaque(false);
		
		lblNewLabel = new JLabel("Puntaje :");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 22));
		lblNewLabel.setBounds(337, 15, 119, 20);
		panelPrincipal.add(lblNewLabel);
		
		lblPuntaje = new JLabel( "0" ); // <--------------- CONTADOR
		lblPuntaje.setFont(new Font("Consolas", Font.BOLD, 22));
		lblPuntaje.setBounds(458, 15, 27, 20);
		panelPrincipal.add(lblPuntaje);
		
	}
	/** Boton para avanzar **/

	public void keyPressed(KeyEvent e) { // Evento en el JFrame
		if (e.getSource() == this) {
			keyPressedThis(e);
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	protected void keyPressedThis(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D ) { // ambos devuelven int: el codigo de la tecla
			snake.cambiarDireccion("de");
		}
		else if(e.getKeyCode() == KeyEvent.VK_A ) {
			snake.cambiarDireccion("iz");
		}
		else if(e.getKeyCode() == KeyEvent.VK_W ) {
			snake.cambiarDireccion("ar");
		}
		else if(e.getKeyCode() == KeyEvent.VK_S ) {
			snake.cambiarDireccion("ab");
		}
	}
}





















// aa
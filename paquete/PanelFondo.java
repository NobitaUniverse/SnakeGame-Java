package paquete;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {

	int tam;  // --> tamaño del lado del panel en pixeles
	int cant; // --> cantidad de cuadrados por lado
	int tamC; // --> tamaño de cada cuadrado en pixeles
	
	public PanelFondo(int tam, int cant) {
		this.tam = tam;
		this.cant = cant;
		this.tamC = tam / cant;

	}
	
	public void paint(Graphics dibujo) {
		
		super.paint(dibujo);
		dibujo.setColor(new Color(114, 144, 7));
		
		for (int i = 0; i < cant; i++) {
			for (int j = 0; j < cant; j++) {
				dibujo.fillRect(tamC*i, tamC*j, tamC-1, tamC-1);
			}
		}
	}
}

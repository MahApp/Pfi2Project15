package se.mah.k3.pfi2.project.main.controller;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;

import se.mah.k3.pfi2.project.main.view.Fullscreen;

public class Setup {

	public static void main(String[] args) {
		 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    GraphicsDevice[] gs = ge.getScreenDevices();
		    
		    GraphicsDevice gd = gs[gs.length-1]; //ALways show on last screen
		    System.out.println("Numer of screens "+ gs.length);
		    Fullscreen  frame = new Fullscreen();
		    frame.setVisible(true);
	}
}

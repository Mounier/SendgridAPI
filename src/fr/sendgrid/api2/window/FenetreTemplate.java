package fr.sendgrid.api2.window;


//Les imports habituels
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jdk.nashorn.internal.ir.Labels;
 
public class FenetreTemplate extends JFrame{
	
  private int compteur = 0;
  private boolean animated = true;
  private boolean backX, backY;
  private int x, y;
  private Thread t;  

  private JPanel container = new JPanel();
  private JLabel label = new JLabel("Un JTextField");
  
  private JFormattedTextField jtf = new JFormattedTextField();
  private JFormattedTextField jtf2 = new JFormattedTextField();
  private JFormattedTextField jtf3 = new JFormattedTextField();
  private JFormattedTextField jtf4 = new JFormattedTextField();
  private JFormattedTextField jtf5 = new JFormattedTextField();
  
  private JLabel labelNameVersion = new JLabel("Nom de la version :");
  private JLabel labelHtmlContent = new JLabel("Html content:");
  private JLabel labelPlainContent = new JLabel("Plain content:");
  private JLabel labelTemplateId = new JLabel("Template id:");
  private JLabel labelMailSubject = new JLabel("Objet du mail");
  
  
  public FenetreTemplate() {


	    this.setTitle("Template");
	    this.setSize(300, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    container.setLayout(new BorderLayout());
	    container.setBorder( BorderFactory.createBevelBorder(1));
	    container.setBackground(Color.white);
	    
	    Dimension preferedSize = new Dimension(150, 30);
	    Color color = Color.BLUE;
	    Font police = new Font("Arial", Font.BOLD, 14);
	    
	    JPanel top = new JPanel();
	    JPanel top2 = new JPanel();
	    JPanel top3 = new JPanel();
	    
	    jtf.setPreferredSize(new Dimension(150, 30));
	    jtf2.setPreferredSize(new Dimension(150, 30));
	    jtf3.setPreferredSize(new Dimension(150, 30));
	    jtf4.setPreferredSize(new Dimension(150, 30));
	    jtf5.setPreferredSize(new Dimension(150, 30));
	    
	    top.add(labelNameVersion);
	    top.add(labelHtmlContent);
	    top.add(labelPlainContent);
		top.add(labelTemplateId).setLocation(200, 200);
		top.add(labelMailSubject).setLocation(199, -200);;
		
	    top.add(jtf);
	    top.add(jtf2);
	    top.add(jtf3);
		top.add(jtf4);
		top.add(jtf5);
		this.setContentPane(top);
	    this.setVisible(true);
	    
//	    container.add(top, BorderLayout.CENTER);
//	    container.add(middle, BorderLayout.BEFORE_LINE_BEGINS);
//	    container.add(bottom, BorderLayout.PAGE_END);
	    
//	    jtfNameVersion.setFont(police);
//	    jtfNameVersion.setPreferredSize(new Dimension(150, 30));
//	    jtfNameVersion.setForeground(Color.BLUE);
//	    
//	    jtfHtmlContent.setFont(police);
//	    jtfHtmlContent.setPreferredSize(new Dimension(150, 30));
//	    jtfHtmlContent.setForeground(Color.BLUE);
//	    
//	    jtfPlainContent.setFont(police);
//	    jtfPlainContent.setPreferredSize(new Dimension(150, 30));
//	    jtfPlainContent.setForeground(Color.BLUE);
//	    
//	    jtfTemplateId.setFont(police);
//	    jtfTemplateId.setPreferredSize(new Dimension(150, 30));
//	    jtfTemplateId.setForeground(Color.BLUE);
//	    
//	    jtfSubject.setFont(police);
//	    jtfSubject.setPreferredSize(new Dimension(150, 30));
//	    jtfSubject.setForeground(Color.BLUE);
//	    
//	    top.add(jtfNameVersion);
//	    top.add(jtfHtmlContent);
//	    top.add(jtfPlainContent);
//	    top.add(jtfTemplateId);
//	    top.add(jtfSubject);
	    

	  
  } 
}
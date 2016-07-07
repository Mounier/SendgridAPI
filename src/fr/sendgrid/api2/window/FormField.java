package fr.sendgrid.api2.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormField extends JPanel {

	private JLabel label;
	private JTextField field;
	private Font fieldFont;
	private Dimension fieldDimension;
	private Color fieldColor;

	public FormField() {
		// TODO Auto-generated constructor stub
	}

	public FormField(String labelText, String fieldText, Font fieldFont, Dimension fieldDimension, Color fieldColor) {
		super();
		this.label = new JLabel(labelText);
		this.field = new JTextField(fieldText);
		this.fieldFont = fieldFont;
		this.fieldDimension = fieldDimension;
		this.fieldColor = fieldColor;
		
		this.setBorder( BorderFactory.createBevelBorder(1));
		this.add( this.label );
		this.add( this.field );
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JTextField getField() {
		return field;
	}

	public void setField(JTextField field) {
		this.field = field;
	}

	public Font getFieldFont() {
		return fieldFont;
	}

	public void setFieldFont(Font fieldFont) {
		this.fieldFont = fieldFont;
	}

	public Dimension getFieldDimension() {
		return fieldDimension;
	}

	public void setFieldDimension(Dimension fieldDimension) {
		this.fieldDimension = fieldDimension;
	}

	public Color getFieldColor() {
		return fieldColor;
	}

	public void setFieldColor(Color fieldColor) {
		this.fieldColor = fieldColor;
	}
}

import javax.swing.*;
import java.math.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bmical extends JFrame implements ActionListener
{
	JButton b1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField t1,t2;
	JSlider sli;
	JPanel p1;
	
bmical()
{
	getContentPane().setBackground(Color.BLUE);
	setSize(900,600);

	l3= new JLabel("BODY MASS INDEX CALCULATOR");
	l3.setBounds(210, 30,500 , 50);
	l3.setFont(new Font("System",Font.BOLD,30));
	l3.setBackground(Color.white);
	l3.setForeground(Color.white);
	add(l3);
	
	l1= new JLabel("Enter the Weight");
	l1.setBounds(140, 110,300 , 50);
	l1.setFont(new Font("System",Font.BOLD,30));
	l1.setBackground(Color.white);
	l1.setForeground(Color.white);
	add(l1);
	
	l2= new JLabel("Enter the Height");
	l2.setBounds(510,110,300,50);
	l2.setFont(new Font("System",Font.BOLD,30));
	l2.setBackground(Color.WHITE);
	l2.setForeground(Color.white);
	add(l2);
	
	t1 = new JTextField();
	t1.setBounds(110,170,300,40);
	t1.setFont(new Font("System",Font.BOLD,20));
	t1.setBackground(Color.white);
	t1.setForeground(Color.BLACK);
	add(t1);
	
	t2 = new JTextField();
	t2.setBounds(480,170,300,40);
	t2.setFont(new Font("System",Font.BOLD,20));
	t2.setBackground(Color.white);
	t2.setForeground(Color.black);
	add(t2);
	
	b1 = new JButton("CALCULATE");
	b1.setBounds(350,290,200,30);
	b1.setFont(new Font("System",Font.BOLD,20));
	b1.setBackground(Color.white);
	b1.setForeground(Color.black);
	add(b1);
	
	sli=new JSlider(JSlider.HORIZONTAL,0,70,20);
	sli.setMinorTickSpacing(1);
	sli.setMajorTickSpacing(10);
	sli.setPaintTicks(true);
	sli.setPaintLabels(true);
	sli.setBounds(130,400,640,60);
	sli.setBackground(Color.gray);
	sli.setAutoscrolls(true);
	getContentPane().add(sli);
	
	l4 = new JLabel("Normal");
	l4.setBounds(300,450,400,35);
	l4.setBackground(Color.white);
	l4.setFont(new Font("System",Font.BOLD,10));
	l4.setForeground(Color.white);
	getContentPane().add(l4);									

	l5 = new JLabel("Severe Thickness");
	l5.setBounds(140,450,400,35);
	l5.setBackground(Color.white);
	l5.setFont(new Font("System",Font.BOLD,10));
	l5.setForeground(Color.white);
	getContentPane().add(l5);

	l6 = new JLabel("Thickness");
	l6.setBounds(240,450,400,35);
	l6.setBackground(Color.white);
	l6.setFont(new Font("System",Font.BOLD,10));
	l6.setForeground(Color.white);
	getContentPane().add(l6);			

	l7 = new JLabel("Overweight");
	l7.setBounds(355,450,400,35);
	l7.setBackground(Color.white);
	l7.setFont(new Font("System",Font.BOLD,10));
	l7.setForeground(Color.white);	
	getContentPane().add(l7);									
	
	l8 = new JLabel("Obesity");
	l8.setBounds(440,450,400,35);
	l8.setBackground(Color.white);
	l8.setFont(new Font("System",Font.BOLD,10));
	l8.setForeground(Color.white);
	getContentPane().add(l8);			
	
	l9 = new JLabel();
	l9.setBounds(380,330,300,40);
	l9.setFont(new Font("System",Font.BOLD,18));
	l9.setForeground(Color.white);
	getContentPane().add(l9);
	
	b1.addActionListener(this);
	setLocation(390,100);
	getContentPane().setLayout(null);
	setVisible(true);
}
public static void main(String[] args) {
	new bmical().setVisible(true);
}
double bmi=0.0,height,weight;
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==b1)
	{
		String str1=t1.getText();
		String str2=t2.getText();
		weight=Double.parseDouble(str1);
		height=Double.parseDouble(str2);
		height=height/100;
		bmi=weight/(Math.pow(height, 2));
		bmi=Math.round(bmi*100.00/100.00);
		int d=(int)bmi;
		if(bmi<16.00)
		{
			l9.setText(String.valueOf(bmi) + "  Severe Thickness");
			sli.setValue(d);

		}
		else if(bmi>=16.00 && bmi<=18.50)
		{
			l9.setText(String.valueOf(bmi) + "  Thickness");
			sli.setValue(d);			
			
		}
		else if(bmi>18.50 && bmi<=25.0)
		{
			l9.setText(String.valueOf(bmi) + "  Normal");	
			sli.setValue(d);
		}
		else if(bmi>25.0 && bmi<=30.0)
		{
			l9.setText(String.valueOf(bmi) + "  Overweight");			
			sli.setValue(d);
		}
		else
		{
			l9.setText(String.valueOf(bmi) + "  Obesity");			
			if(d<=69)
			{
				sli.setValue(d);
			}
			else
			{
				sli.setValue(69);
			}
		}
	}
}
}

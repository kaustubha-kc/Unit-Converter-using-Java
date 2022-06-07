import java.awt.*;
import java.awt.event.*;
public class Demo2 extends Frame implements ItemListener
{
	TextField tf1, tf2, tf3;   
	Choice b1, b2, b3;    
	Label l1, l2, l3, l4, l5, l6;    
	public Demo2()  
	{
		tf1 = new TextField();  
		tf2 = new TextField();  
		tf3 = new TextField();  
		l1 = new Label("Input:");  
		l2 = new Label("Output:");  
		l3 = new Label("Unit of input:");  
		l4 = new Label("Unit of output:");  
		l5 = new Label("Breakdown unit Output:");  
		l6 = new Label("Breakdown unit Input:");   
		b1 = new Choice();  
		b2 = new Choice();  
		b3 = new Choice();  
		    
		l1.setBounds(20,40,50,50);    
		tf1.setBounds(80,50,50,30);  
		l2.setBounds(20,100,50,50);  
		tf2.setBounds(80,110,100,30);  
		l3.setBounds(20,170,80,50);  
		b1.setBounds(110,170,90,40);  
		l4.setBounds(20,230,80,50);  
		b2.setBounds(110,230,90,40);  
		l5.setBounds(20,280,150,40);  
		tf3.setBounds(180,280,300,40);  
		l6.setBounds(20,340,150,40);   
		b3.setBounds(180,340,150,40); 
		   
		b1.add("feet");  
		b1.add("inch");  
		b1.add("centimeter");  
		b1.add("meter");  
		b1.add("kilometer");
		
		b2.add("feet");  
		b2.add("inch");  
		b2.add("centimeter");  
		b2.add("meter");  
		b2.add("kilometer");
		
		b3.add("Feet and inch.");  
		b3.add("Meter and centimeter");  
		b3.add("Kilometer and meter");
		   
		b1.addItemListener(this);  
		b2.addItemListener(this);  
		b3.addItemListener(this);
		   
		add(b1);  
		add(b2);  
		add(tf1);  
		add(tf2);  
		add(tf3);  
		add(l1);  
		add(l2);   
		add(l3);  
		add(l4);  
		add(l5);  
		add(l6);  
		add(b3);    
		setSize(400, 400);  
		setLayout(null);  
		setVisible(true);   
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)  
			{
				System.exit(0);  
			} 
		});   
		}    
		public void itemStateChanged(ItemEvent e) 
		{
			String temp1 = new String();  
			String temp2 = new String();  
			double ip = 0, op = 0;   
			int i=b1.getSelectedIndex();  
			int o=b2.getSelectedIndex();  
			int c = b3.getSelectedIndex();  
			ip=Double.parseDouble(tf1.getText());  
			switch(i)  
			{
				case 0:
				    ip=ip*0.3048;
				    break;   
				case 1:
				    ip=(ip*2.54)/100;
					break;   
				case 2:ip=ip/100;
				    break;   
				case 4:ip=ip*1000;    
			}    
			
			switch(o)  
			{
				case 0:op=ip*3.2808;
				    break;   
				case 1:op=ip*39.37;
				    break;   
				case 2:op=ip*100;
				    break;   
				case 3:op=ip;
				    break;   
				case 4:op=ip/1000;  
			}  
			temp1 = " " + op;  
			tf2.setText(temp1);    
			switch(c)  
			{
				case 0: double feet = ip * 3.28084;
				        int feet1 = (int)feet;
				        double inch = ip * 39.3701;
				        inch = inch - (feet1 * 12);
				        int inch1 = (int)inch;
				        temp2 = feet1 + " feet " + inch1 + " inch";
				        break;
				case 1: int met = (int)ip;
				        double centi = ip * 100;
				        centi = centi - (met * 100);
				        int centi1 = (int)centi;
				        temp2 = met + " meters " + centi1 + " centimeters";
				        break;     
				case 2: double km = ip / 1000;
				        int km1 = (int)km;
				        double met1 = ip - (km1 * 1000);
				        int met2 = (int)met1;
				        temp2 = km1 + " kilometers " + met2 + " meters";
			}
			tf3.setText(temp2);
		}
		public static void main(String arg[])   
		{
			new Demo2();
		}
}
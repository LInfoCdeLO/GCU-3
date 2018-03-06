import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import java.util.Hashtable;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Graphics;


public class Fenetre extends JFrame implements ActionListener,ChangeListener{
	JPanel conteneur1;
	JPanel conteneur2;
	JPanel conteneur3;
	JLabel budget;
	JLabel texte1;
	JLabel texte2;
	JLabel texte3;
	JLabel texte4;
	JPanel conteneurTotal;
	JButton start;
	JButton creer;
	JButton effacer;
	JRadioButton boutonRoute;
	JRadioButton boutonBois;
	JRadioButton boutonMetal;
	JRadioButton boutonPlastique;
	ButtonGroup materiaux;
	JSlider selectVehicule;
	JSlider selectPoids;
	JSlider selectVitesse;
	
	
	public Fenetre(){
		super("On construit des ponts");
		setResizable(false);
		setSize(1800,1000);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Les JLabel
		budget = new JLabel("Budget = T povr!",JLabel.CENTER);
		Font policeBudget = new Font(" Comic Sans MS ",Font.BOLD,30);
		budget.setFont(policeBudget);
		budget.setBounds(60,20,350,70);
		budget.setOpaque(true);
		budget.setBackground(Color.black);
		budget.setForeground(Color.white);
		
		
		texte1 = new JLabel("Choisissez votre materiaux",JLabel.CENTER);
		Font policeTexte1 = new Font(" Comic Sans MS ",Font.BOLD,20);
		texte1.setFont(policeTexte1);
		texte1.setBounds(450,10,400,50);
		texte1.setForeground(Color.black);
		
		texte2 = new JLabel("Choisissez votre véhicule",JLabel.CENTER);
		Font policeTexte2 = new Font(" Comic Sans MS ",Font.BOLD,20);
		texte2.setFont(policeTexte2);
		texte2.setBounds(10,150,450,50);
		texte2.setForeground(Color.black);
		
		texte3 = new JLabel("Choisissez votre multiplicateur de poids",JLabel.CENTER);
		texte3.setFont(policeTexte2);
		texte3.setBounds(10,305,450,50);
		texte3.setForeground(Color.black);
		
		texte4 = new JLabel("Choisissez votre vitesse en km/h",JLabel.CENTER);
		texte4.setFont(policeTexte2);
		texte4.setBounds(10,460,450,50);
		texte4.setForeground(Color.black);
		//FIN JLabel
		
		//Les JButton
		start = new JButton("START");
		Font policeStart = new Font(" Comic Sans MS ",Font.BOLD,40);
		start.setFont(policeStart);
		start.setBounds(10,800,450,110);
		start.setBackground(Color.green);
		start.setForeground(Color.white);
		
		creer = new JButton("CREER");
		Font policeCreerEffacer = new Font(" Comic Sans MS ",Font.BOLD,30);
		creer.setFont(policeCreerEffacer);
		creer.setBounds(1020,20,250,70);
		creer.setBackground(Color.green);
		creer.setForeground(Color.black);
		
		effacer = new JButton("EFFACER");
		effacer.setFont(policeCreerEffacer);
		effacer.setBounds(1020,110,250,70);
		effacer.setBackground(Color.red);
		effacer.setForeground(Color.black);
		
		
		start.addActionListener(this);
		creer.addActionListener(this);
		effacer.addActionListener(this);
		//FIN JButton
		
		//Les JRadioButton
		boutonRoute=new JRadioButton("Route");
		boutonRoute.setBounds(100,70,100,60);
		
		boutonBois=new JRadioButton("Bois");
		boutonBois.setBounds(300,70,100,60);
		
		boutonMetal=new JRadioButton("Metal");
		boutonMetal.setBounds(500,70,100,60);
		
		boutonPlastique=new JRadioButton("Plastique");
		boutonPlastique.setBounds(700,70,100,60);
	
		materiaux = new ButtonGroup();
		
		materiaux.add(boutonRoute);
		materiaux.add(boutonBois);
		materiaux.add(boutonMetal);
		materiaux.add(boutonPlastique);
		
		boutonRoute.addActionListener(this);
		boutonBois.addActionListener(this);
		boutonMetal.addActionListener(this);
		boutonPlastique.addActionListener(this);
		//FIN JRAdioButton
		
		//Les JSlider
		
		selectVehicule = new JSlider(JSlider.HORIZONTAL,1,3,1);
		selectVehicule.setBounds(20,205,430,50);
		selectVehicule.setMajorTickSpacing(1);
		selectVehicule.setPaintTicks(true);
		
		Hashtable labelTable1 = new Hashtable();
		labelTable1.put( new Integer( 1 ), new JLabel("Pieton") );
		labelTable1.put( new Integer( 2 ), new JLabel("Voiture") );
		labelTable1.put( new Integer( 3 ), new JLabel("Camion") );
		selectVehicule.setLabelTable( labelTable1 );
		selectVehicule.setPaintLabels(true);
		
		
		selectPoids = new JSlider(JSlider.HORIZONTAL,1,10,2);//Attention pour le multiplieur de poids, le diviser par 2!!
		selectPoids.setBounds(20,360,430,50);
		selectPoids.setMajorTickSpacing(1);
		selectPoids.setMinorTickSpacing(1);
		selectPoids.setPaintTicks(true);
		
		Hashtable labelTable2 = new Hashtable();
		labelTable2.put( new Integer( 2 ), new JLabel("X 1") );
		labelTable2.put( new Integer( 4 ), new JLabel("X 2") );
		labelTable2.put( new Integer( 6 ), new JLabel("X 3") );
		labelTable2.put( new Integer( 8 ), new JLabel("X 4") );
		labelTable2.put( new Integer( 10 ), new JLabel("X 5") );
		selectPoids.setLabelTable( labelTable2 );
		selectPoids.setPaintLabels(true);
		
		
		selectVitesse = new JSlider(JSlider.HORIZONTAL,6,26,10);
		selectVitesse.setBounds(20,515,430,50);
		selectVitesse.setMajorTickSpacing(4);
		selectVitesse.setMinorTickSpacing(1);
		selectVitesse.setPaintTicks(true);
		
		Hashtable labelTable3 = new Hashtable();
		labelTable3.put( new Integer( 6 ), new JLabel("30") );
		labelTable3.put( new Integer( 10 ), new JLabel("50") );
		labelTable3.put( new Integer( 14 ), new JLabel("70") );
		labelTable3.put( new Integer( 18 ), new JLabel("90") );
		labelTable3.put( new Integer( 22 ), new JLabel("110") );
		labelTable3.put( new Integer( 26 ), new JLabel("130") );
		selectVitesse.setLabelTable( labelTable3 );
		selectVitesse.setPaintLabels(true);
		
		
		selectPoids.addChangeListener(this);
		selectVehicule.addChangeListener(this);
		selectVitesse.addChangeListener(this);
		//FIN JSlider
		
		//Les Panel
		conteneur1 = new JPanel();
		conteneur1.setLayout(null);
		
		conteneur1.setBounds(10,10,1300,740);
		conteneur1.setBackground(Color.gray);
		
		
		
		conteneur2 = new JPanel();
		conteneur2.setLayout(null);
		conteneur2.add(start);
		conteneur2.add(budget);
		conteneur2.add(texte2);
		conteneur2.add(texte3);
		conteneur2.add(texte4);
		conteneur2.add(selectPoids);
		conteneur2.add(selectVehicule);
		conteneur2.add(selectVitesse);
		
		conteneur2.setBounds(1320,10,470,950);
		conteneur2.setBackground(Color.gray);
		
		
		conteneur3 = new JPanel();
		conteneur3.setLayout(null);
		conteneur3.add(texte1);
		conteneur3.add(creer);
		conteneur3.add(effacer);
		conteneur3.add(boutonBois);
		conteneur3.add(boutonMetal);
		conteneur3.add(boutonPlastique);
		conteneur3.add(boutonRoute);
		
		conteneur3.setBounds(10,760,1300,200);
		conteneur3.setBackground(Color.gray);
		
		
		conteneurTotal = new JPanel();
		conteneurTotal.setLayout(null);
		conteneurTotal.add(conteneur1);
		conteneurTotal.add(conteneur2);
		conteneurTotal.add(conteneur3);
		conteneurTotal.setBackground(Color.white);
		
		setContentPane(conteneurTotal);
		//FIN JPanel
		
		setVisible(true);
	}	
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == boutonBois){
			System.out.println("Bois");
		}
		else if(e.getSource() == boutonMetal){
			System.out.println("Metal");
		}
		else if(e.getSource() == boutonPlastique){
			System.out.println("Plastique");
		}
		else if(e.getSource() == boutonRoute){
			System.out.println("Route");
		}
		else if(e.getSource() == start){
			System.out.println("START");
		}	
		else if(e.getSource() == creer){
			System.out.println("creer");
		}	
		else if(e.getSource() == effacer){
			System.out.println("effacer");
		}	
	}
	
	
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
			if(source == selectVehicule){
				int val = (int)source.getValue();
				System.out.println("vehicule= "+val);
			}
			else if(source == selectPoids){
				double val = (double)source.getValue()/2.0;
				System.out.println("poids= X "+val);
			}
			else if(source == selectVitesse){
				int val = (int)source.getValue()*5;
				System.out.println("Vitesse= "+val+" km/h");
			}
		}
	}
	
}

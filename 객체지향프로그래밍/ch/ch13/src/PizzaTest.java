import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

// 주문 완료 화면을 담당하는 프레임
class MyFrame2 extends JFrame implements ActionListener {
    private JButton confirmButton, exitButton;
    private JPanel downPanel;
    private JLabel message;

    public MyFrame2() {
        // 주문 내용 및 가격을 가져옴
        String txt = MyFrame.text2.getText();
        int price = MyFrame.getPrice();

        // 프레임 설정
        this.setSize(450, 100);
        this.setTitle("피자 주문");
        this.setVisible(true);
        this.setResizable(false);

        // 메시지 레이블 생성
        message = new JLabel(txt + " 주문이 완료되었습니다. 가격은 " + price + "원입니다.");
        downPanel = new JPanel();

        // 확인 및 나가기 버튼 생성 및 이벤트 리스너 등록
        this.confirmButton = new JButton("확인");
        this.confirmButton.addActionListener(this);
        this.exitButton = new JButton("나가기");
        this.exitButton.addActionListener(this);

        // 프레임 레이아웃 설정
        this.setLayout(new BorderLayout());
        this.add(message, BorderLayout.NORTH);
        this.add(downPanel, BorderLayout.SOUTH);

        // 하단 패널에 버튼 추가
        downPanel.add(this.confirmButton);
        downPanel.add(this.exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 버튼 이벤트 처리
        if (e.getSource() == this.confirmButton || e.getSource() == this.exitButton) {
            this.setVisible(false);
        }
    }
}

class MyFrame extends JFrame implements ActionListener{
	private JButton order_button, cancle_button; 
	private JPanel down_panel, down_panel2, set1;
	private JTextField text;
	public static JTextField text2;
	private static int totalPrice = 0;
	private int toppingsPrice = 0;
	private int extrasPrice = 0;
	private int sizePrice = 0;

	WelcomePanel welcom_panel = new WelcomePanel(); 
	TypePanel TypePanel = new TypePanel();
	
	ToppingPanel ToppingPanel = new ToppingPanel();
	SizePanel SizePanel = new SizePanel();
	
	public static int getPrice()
	{
		return totalPrice;
	}

	public MyFrame() { 

		this.setSize(500, 400); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setTitle("피자 주문"); 

		this.order_button = new JButton("주문"); 
		this.order_button.addActionListener(this); 
		this.cancle_button = new JButton("취소"); 
		this.cancle_button.addActionListener(this); 
		
		this.text = new JTextField(); 
		text.setEditable(false); 
		text.setColumns(6); 
		

		down_panel = new JPanel(); 
		down_panel2 = new JPanel();
		set1 = new JPanel();
		
		down_panel.add(this.order_button); 
		down_panel.add(this.cancle_button);
		down_panel.add(this.text);
		set1.add(down_panel2);
		set1.add(down_panel);
		
		set1.setLayout(new BorderLayout()); 
		set1.add(down_panel2, BorderLayout.NORTH); 
		set1.add(down_panel, BorderLayout.SOUTH); 
		
		this.setLayout(new BorderLayout()); 

		this.add(welcom_panel, BorderLayout.NORTH); 
		this.add(set1, BorderLayout.SOUTH); 
		this.add(SizePanel, BorderLayout.EAST); 
		this.add(TypePanel, BorderLayout.WEST); 
		this.add(ToppingPanel, BorderLayout.CENTER); 
		
		pack();	
		this.setVisible(true); 
		this.setResizable(false); 
	}

	public void actionPerformed(ActionEvent e) { 

	    
	    totalPrice=toppingsPrice + sizePrice + extrasPrice;
	    
	    if (e.getSource() == this.order_button) { 
			this.text.setText(""+ getPrice()); 
		}
	    if (e.getSource() == this.cancle_button) { 
			this.text.setText(""); 
			this.text2.setText("먀아");
		}

	    
	}

	class WelcomePanel extends JPanel { 
		private JLabel message; 

		public WelcomePanel() { 
			message = new JLabel("자바 피자에 오신것을 환영합니다.");
			add(message); 
		}
	}

	class TypePanel extends JPanel implements ActionListener{
		private JRadioButton combo, potato, bulgogi; 
		private ButtonGroup bg; 
		
		public TypePanel() { 
			setLayout(new GridLayout(3, 1)); 

			combo = new JRadioButton("콤보"); 
			potato = new JRadioButton("포테이토");
			bulgogi = new JRadioButton("불고기");

			bg = new ButtonGroup(); 
			bg.add(combo);
			bg.add(potato);
			bg.add(bulgogi);
			
			combo.addActionListener(this);
			potato.addActionListener(this);
			bulgogi.addActionListener(this);
			
			setBorder(BorderFactory.createTitledBorder("종류")); 

			add(combo); 
			add(potato);
			add(bulgogi);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

		    if (source == combo)
		    {
		    	extrasPrice = 10000;
		    }
		    else if (source == potato)
		    {
		    	extrasPrice = 11000;
		    }
		    else if (source == bulgogi)
		    {
		    	extrasPrice = 11000;
		    }
			
		}

		
	}

	class ToppingPanel extends JPanel implements ItemListener{ 
		private JRadioButton pepper, cheese, peperoni, bacon; 

		public ToppingPanel() { 
			setLayout(new GridLayout(4, 1)); 

			pepper = new JRadioButton("피망                                                          "); 
			cheese = new JRadioButton("치즈                                                          ");
			peperoni = new JRadioButton("페퍼로니                                                          ");
			bacon = new JRadioButton("베이컨                                                          ");

			setBorder(BorderFactory.createTitledBorder("추가토핑"));

			add(pepper); 
			add(cheese);
			add(peperoni);
			add(bacon);
			pepper.addItemListener(this);
			cheese.addItemListener(this);
			peperoni.addItemListener(this);
			bacon.addItemListener(this);
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object source = e.getItemSelectable();
		    if (source == pepper)
		    {
		    	if (e.getStateChange() == ItemEvent.SELECTED)
		    	{
		    		toppingsPrice += 1000;
		        }
		    	else
		    	{
		    		toppingsPrice -= 1000;
		        }
		    }
		    else if (source == cheese){
		    	if (e.getStateChange() == ItemEvent.SELECTED)
		    	{
		    		toppingsPrice += 1000;
		        }
		    	else{
		    		toppingsPrice -= 1000;
		        }
		    }
		    else if (source == peperoni)
		    {
		    	if (e.getStateChange() == ItemEvent.SELECTED)
		    	{
		    		toppingsPrice += 1500;
		        }
		    	else
		    	{
		    		toppingsPrice -= 1500;
		        }
		    }
		    else if (source == bacon)
		    {
		    	if (e.getStateChange() == ItemEvent.SELECTED)
		    	{
		    		toppingsPrice += 2000;
		        }
		    	else
		    	{
		    		toppingsPrice -= 2000;
		        }
			}
			
		}
	}


	class SizePanel extends JPanel implements ActionListener{ 
		private JRadioButton small, medium, large; 
		private ButtonGroup bg; 

		public SizePanel() { 
			setLayout(new GridLayout(3, 1)); 

			small = new JRadioButton("Small"); 
			medium = new JRadioButton("Medium");
			large = new JRadioButton("Large");

			bg = new ButtonGroup(); 
			bg.add(small);
			bg.add(medium);
			bg.add(large);
	
			
			setBorder(BorderFactory.createTitledBorder("크기"));

			add(small); 
			add(medium);
			add(large);
			
			small.addActionListener(this);
			medium.addActionListener(this);
			large.addActionListener(this);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

		    if (source == small)
		    {
		    	sizePrice = -1000;
		    }
		    else if (source == medium)
		    {
		    	sizePrice = 0;
		    }
		    else if (source == large)
		    {
		    	sizePrice = 1000;
		    }
			
		}
	}
	}
public class PizzaTest { 
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}
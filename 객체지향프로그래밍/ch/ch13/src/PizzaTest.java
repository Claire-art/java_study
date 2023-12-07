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

// JFrame 클래스를 상속받아 피자 주문 창을 나타내는 MyFrame 클래스 정의
class MyFrame extends JFrame implements ActionListener {
    // 주문, 취소 버튼 및 패널, 텍스트 필드 등을 선언
    private JButton order_button, cancle_button; 
    private JPanel down_panel, down_panel2, set1;
    private JTextField text;
    public static JTextField text2;
    private static int totalPrice = 0;
    private int toppingsPrice = 0;
    private int extrasPrice = 0;
    private int sizePrice = 0;

    // 환영 멘트, 피자 종류, 토핑, 크기 패널을 담당하는 클래스의 인스턴스 생성
    WelcomePanel welcom_panel = new WelcomePanel(); 
    TypePanel TypePanel = new TypePanel();
    ToppingPanel ToppingPanel = new ToppingPanel();
    SizePanel SizePanel = new SizePanel();

    // 주문 가격을 반환하는 정적 메서드
    public static int getPrice() {
        return totalPrice;
    }

    // MyFrame 클래스의 생성자
    public MyFrame() { 
        // JFrame 속성 설정
        this.setSize(500, 400); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setTitle("피자 주문"); 

        // 주문, 취소 버튼 생성 및 리스너 등록
        this.order_button = new JButton("주문"); 
        this.order_button.addActionListener(this); 
        this.cancle_button = new JButton("취소"); 
        this.cancle_button.addActionListener(this); 
        
        // 주문 가격을 표시할 텍스트 필드 생성
        this.text = new JTextField(); 
        text.setEditable(false); 
        text.setColumns(6); 

        // 패널들을 담을 JPanel 생성
        down_panel = new JPanel(); 
        down_panel2 = new JPanel();
        set1 = new JPanel();
        
        // 생성한 컴포넌트들을 패널에 추가
        down_panel.add(this.order_button); 
        down_panel.add(this.cancle_button);
        down_panel.add(this.text);
        set1.add(down_panel2);
        set1.add(down_panel);
        
        // 패널들의 배치 설정
        set1.setLayout(new BorderLayout()); 
        set1.add(down_panel2, BorderLayout.NORTH); 
        set1.add(down_panel, BorderLayout.SOUTH); 
        
        // 전체 화면의 배치 설정
        this.setLayout(new BorderLayout()); 

        // 생성한 컴포넌트들을 전체 화면에 추가
        this.add(welcom_panel, BorderLayout.NORTH); 
        this.add(set1, BorderLayout.SOUTH); 
        this.add(SizePanel, BorderLayout.EAST); 
        this.add(TypePanel, BorderLayout.WEST); 
        this.add(ToppingPanel, BorderLayout.CENTER); 
        
        // 화면을 자동으로 맞추고 보여주도록 설정
        pack();	
        this.setVisible(true); 
        this.setResizable(false); 
    }

    // 주문, 취소 버튼에 대한 액션 이벤트 처리
    public void actionPerformed(ActionEvent e) { 
        // 현재 선택된 토핑, 사이즈, 종류에 따른 총 주문 가격 계산
        totalPrice = toppingsPrice + sizePrice + extrasPrice;
        
        // 주문 버튼 클릭 시 주문 가격을 텍스트 필드에 표시
        if (e.getSource() == this.order_button) { 
            this.text.setText("" + getPrice()); 
        }
        // 취소 버튼 클릭 시 텍스트 필드 초기화 및 안내 메시지 표시
        if (e.getSource() == this.cancle_button) { 
            this.text.setText(""); 
        }
    }

    // 환영 멘트를 담당하는 JPanel 클래스
    class WelcomePanel extends JPanel { 
        private JLabel message; 

        public WelcomePanel() { 
            message = new JLabel("자바 피자에 오신 것을 환영합니다.");
            add(message); 
        }
    }


	// JPanel을 상속받아 종류를 선택하는 TypePanel 클래스 정의
	class TypePanel extends JPanel implements ActionListener {
		// 콤보, 포테이토, 불고기에 대한 라디오 버튼과 버튼 그룹 선언
		private JRadioButton combo, potato, bulgogi; 
		private ButtonGroup bg; 
		
		// TypePanel 클래스의 생성자
		public TypePanel() { 
			// GridLayout을 사용하여 세 개의 라디오 버튼을 세로로 배치
			setLayout(new GridLayout(3, 1)); 

			// 각각의 라디오 버튼 생성
			combo = new JRadioButton("콤보"); 
			potato = new JRadioButton("포테이토");
			bulgogi = new JRadioButton("불고기");

			// 버튼 그룹에 라디오 버튼 추가
			bg = new ButtonGroup(); 
			bg.add(combo);
			bg.add(potato);
			bg.add(bulgogi);
			
			// 각 라디오 버튼에 ActionListener 등록
			combo.addActionListener(this);
			potato.addActionListener(this);
			bulgogi.addActionListener(this);
			
			// 패널에 경계선과 함께 종류를 나타내는 제목을 설정
			setBorder(BorderFactory.createTitledBorder("종류")); 

			// 각 라디오 버튼을 패널에 추가
			add(combo); 
			add(potato);
			add(bulgogi);
		}

		// ActionListener 인터페이스의 actionPerformed 메서드를 구현
		@Override
		public void actionPerformed(ActionEvent e) {
			// 이벤트가 발생한 소스를 가져옴
			Object source = e.getSource();

			// 선택된 라디오 버튼에 따라 추가 가격 설정
			if (source == combo) {
				extrasPrice = 10000;
			} else if (source == potato) {
				extrasPrice = 11000;
			} else if (source == bulgogi) {
				extrasPrice = 11000;
			}
		}
	}

	// JPanel을 상속받아 토핑을 선택하는 ToppingPanel 클래스 정의
	class ToppingPanel extends JPanel implements ItemListener { 
		// 피망, 치즈, 페퍼로니, 베이컨에 대한 체크 박스 선언
		private JRadioButton pepper, cheese, peperoni, bacon; 

		// ToppingPanel 클래스의 생성자
		public ToppingPanel() { 
			// GridLayout을 사용하여 네 개의 체크 박스를 세로로 배치
			setLayout(new GridLayout(4, 1)); 

			// 각각의 체크 박스 생성
			pepper = new JRadioButton("피망                                                          "); 
			cheese = new JRadioButton("치즈                                                          ");
			peperoni = new JRadioButton("페퍼로니                                                          ");
			bacon = new JRadioButton("베이컨                                                          ");

			// 체크 박스 그룹에 체크 박스 추가
			setBorder(BorderFactory.createTitledBorder("추가토핑"));

			// 각 체크 박스에 ItemListener 등록
			add(pepper); 
			add(cheese);
			add(peperoni);
			add(bacon);
			pepper.addItemListener(this);
			cheese.addItemListener(this);
			peperoni.addItemListener(this);
			bacon.addItemListener(this);
		}


// ItemListener 인터페이스의 itemStateChanged 메서드를 구현
		@Override
		public void itemStateChanged(ItemEvent e) {
			// 이벤트가 발생한 아이템을 가져옴
			Object source = e.getItemSelectable();

			// 각 체크 박스에 따라 토핑의 추가 가격을 설정
			if (source == pepper) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					toppingsPrice += 1000;
				} else {
					toppingsPrice -= 1000;
				}
			} else if (source == cheese) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					toppingsPrice += 1000;
				} else {
					toppingsPrice -= 1000;
				}
			} else if (source == peperoni) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					toppingsPrice += 1500;
				} else {
					toppingsPrice -= 1500;
				}
			} else if (source == bacon) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					toppingsPrice += 2000;
				} else {
					toppingsPrice -= 2000;
				}
			}
		}

	}


			// SizePanel 클래스는 피자의 크기를 선택하는 라디오 버튼을 가지고 있으며 ActionListener를 구현합니다.
		class SizePanel extends JPanel implements ActionListener { 
			private JRadioButton small, medium, large; // Small, Medium, Large 크기 라디오 버튼
			private ButtonGroup bg; // 라디오 버튼 그룹

			public SizePanel() { 
				setLayout(new GridLayout(3, 1)); // 3행 1열의 그리드 레이아웃 설정

				small = new JRadioButton("Small"); // Small 크기 라디오 버튼
				medium = new JRadioButton("Medium"); // Medium 크기 라디오 버튼
				large = new JRadioButton("Large"); // Large 크기 라디오 버튼

				bg = new ButtonGroup(); // 라디오 버튼 그룹 생성
				bg.add(small); // 그룹에 Small 추가
				bg.add(medium); // 그룹에 Medium 추가
				bg.add(large); // 그룹에 Large 추가

				setBorder(BorderFactory.createTitledBorder("크기")); // 패널에 테두리와 제목 "크기" 추가

				add(small); // 패널에 Small 라디오 버튼 추가
				add(medium); // 패널에 Medium 라디오 버튼 추가
				add(large); // 패널에 Large 라디오 버튼 추가

				small.addActionListener(this); // 각 라디오 버튼에 ActionListener 등록
				medium.addActionListener(this);
				large.addActionListener(this);
			}


		// ActionListener의 actionPerformed 메서드 구현
			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource(); // 이벤트의 소스(어떤 라디오 버튼인지)를 가져옴

				// 선택된 라디오 버튼에 따라 피자의 크기에 대한 추가 가격을 설정
				if (source == small) {
					sizePrice = -1000; // Small일 경우 -1000 추가 가격
				} else if (source == medium) {
					sizePrice = 0; // Medium일 경우 추가 가격 없음
				} else if (source == large) {
					sizePrice = 1000; // Large일 경우 +1000 추가 가격
				}
			}
		}
	}

	
// PizzaTest 클래스는 MyFrame을 실행하는 메인 클래스입니다.
public class PizzaTest { 
    public static void main(String[] args) {
        MyFrame mf = new MyFrame(); // MyFrame 인스턴스 생성
    }
}
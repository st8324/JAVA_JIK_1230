package day22.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex01_SwingComponent {

	public static void main(String[] args) {
		/* 컴포넌트 
		 *  - 메인창
		 *  	- JFrame
		 *  - 버튼
		 *  	- JButton
		 *  - 텍스트
		 *  	- JLabel
		 *  - 텍스트 입력창
		 *  	- 한줄
		 *  		- JTextField
		 *  	- 여러줄
		 *  		- JTextArea
		 *  - 패널
		 *   - 컴포넌트를 묶어서 관리
		 *   - JPanel
		 * */
		JFrame frame = new JFrame("애플리케이션 예제");
		
		//frame.setLayout(new FlowLayout());
		
		frame.setSize(400, 500); //프레임 크기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 버튼
		
		JButton btn = new JButton("버튼");
		//frame.add(btn);
		
		JLabel label = new JLabel("라벨");
		//frame.add(label);
		
		JTextField textField = new JTextField(30);
		//frame.add(textField);
		
		JTextArea textarea = new JTextArea(20, 30);
		textarea.append("안녕하세요\n");
		textarea.append("제 이름은 홍길동입니다.\n");
		textarea.setEditable(false); //읽기 전용
		//frame.add(textarea);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(btn);
		panel.add(label);
		panel.add(textField);
		panel.add(textarea);
		
		frame.add(panel);
		
		frame.setVisible(true); //화면에 보여줄지 말지

	}

}

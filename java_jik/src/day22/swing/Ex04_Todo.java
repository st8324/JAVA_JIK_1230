package day22.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex04_Todo {

	public static void main(String[] args) {
		/* 오늘의 할일을 입력받아 엔터를 치거나 버튼을 클릭하면
		 * 오늘의 할일이 추가되는 코드를 작성하세요.
		 * */

		JFrame frame = new JFrame("애플리케이션 예제");
		
		frame.setLayout(new FlowLayout());
		frame.setSize(400, 500); //프레임 크기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 버튼
		
		JTextArea textArea = new JTextArea(30, 30);
		
		JButton btn = new JButton("버튼");
		
		JTextField textField = new JTextField(20);

		btn.addActionListener(e->{
			String text = textField.getText();//텍스트 창에 입력된 텍스트 값을 가져옴
			textField.setText("");
			textArea.append(text + "\n");
		});
		
		textField.addActionListener(e->{
			String text = textField.getText();//텍스트 창에 입력된 텍스트 값을 가져옴
			textField.setText("");
			textArea.append(text + "\n");
		});
		
		
		frame.add(textField);
		frame.add(btn);
		
		textArea.setEditable(false);
		frame.add(textArea);
		frame.setVisible(true);
	}

}

package org.sp.model1board.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.sp.model1board.domain.Board;
import org.sp.model1board.model.BoardDAO;

//웹기반이 아닌, javaSE의 응용프로그램 기반으로 클라이언트 정의
public class RegistForm extends JFrame{
	JTextField t_title;
	JTextField t_writer;
	JTextArea area;
	JButton bt;
	BoardDAO boardDAO;
	
	public RegistForm() {
		t_title=new JTextField();
		t_writer=new JTextField();
		area=new JTextArea();
		bt=new JButton("등록");
		boardDAO=new BoardDAO();
		
		this.setLayout(new FlowLayout());
		
		//style
		t_title.setPreferredSize(new Dimension(280, 45));
		t_writer.setPreferredSize(new Dimension(280, 45));
		area.setPreferredSize(new Dimension(280, 100));
		
		add(t_title);
		add(t_writer);
		add(area);
		add(bt);
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener((e)->{
			regist();
		});
		
	}
	
	public void regist() {
		Board board=new Board(); //빈 DTO 생성
		board.setTitle(t_title.getText());
		board.setWriter(t_writer.getText());
		board.setContent(area.getText());
		
		//DAO는 디자인 영역과는 상관없는 model영역이므로, alert창을 띄우거나
		//디자인적 판단을 해서는 안됨. 오직 자신이 제대로 insert했는지 여부만 반환하면됨 (->중립적이기 위해, 즉 재사용성을 극대화!)
		int result=boardDAO.insert(board);
		if(result>0){
			JOptionPane.showMessageDialog(this, "등록성공");
		}else {
			JOptionPane.showMessageDialog(this, "등록실패");
		}
		
	}
	
	public static void main(String[] args) {
		new RegistForm();
	}
}

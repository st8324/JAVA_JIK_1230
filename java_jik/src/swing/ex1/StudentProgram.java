package swing.ex1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

public class StudentProgram {
    private static final List<Student> stds = new ArrayList<>();
    private static DefaultListModel<String> listModel = new DefaultListModel<>();
    private static CardLayout cardLayout;
    private static JFrame frame;
    private static JTextField gradeText, classText, numText, nameText;

    public static void main(String[] args) {
        initUI();
    }

    private static void initUI() {
        frame = new JFrame("학생 관리 프로그램");
        cardLayout = new CardLayout();
        frame.setLayout(cardLayout);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(createMainPanel(), "main");
        frame.add(createInsertPanel(), "insert");
        frame.add(createSearchPanel(), "search");

        frame.setVisible(true);
    }

    private static JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        JButton btnAdd = new JButton("학생 추가");
        JButton btnSearch = new JButton("학생 조회");
        JButton btnExit = new JButton("종료");

        btnAdd.addActionListener(e -> switchPanel("insert"));
        btnSearch.addActionListener(e -> switchPanel("search"));
        btnExit.addActionListener(e -> exitProgram());

        mainPanel.add(btnAdd);
        mainPanel.add(btnSearch);
        mainPanel.add(btnExit);
        return mainPanel;
    }

    private static JPanel createInsertPanel() {
        JPanel insertPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gradeText = new JTextField();
        classText = new JTextField();
        numText = new JTextField();
        nameText = new JTextField();
        JButton btnRegister = new JButton("등록");

        btnRegister.addActionListener(e -> registerStudent());

        addComponent(insertPanel, new JLabel("학년"), 0, 0, gbc);
        addComponent(insertPanel, gradeText, 1, 0, gbc);
        addComponent(insertPanel, new JLabel("반"), 0, 1, gbc);
        addComponent(insertPanel, classText, 1, 1, gbc);
        addComponent(insertPanel, new JLabel("번호"), 0, 2, gbc);
        addComponent(insertPanel, numText, 1, 2, gbc);
        addComponent(insertPanel, new JLabel("이름"), 0, 3, gbc);
        addComponent(insertPanel, nameText, 1, 3, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        insertPanel.add(btnRegister, gbc);
        return insertPanel;
    }

    private static JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        JList<String> list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);
        JButton btnBack = new JButton("뒤로");

        btnBack.addActionListener(e -> switchPanel("main"));

        gbc.gridx = 0; gbc.gridy = 0; gbc.weighty = 10;
        searchPanel.add(scrollPane, gbc);
        gbc.gridy = 1; gbc.weighty = 1;
        searchPanel.add(btnBack, gbc);
        return searchPanel;
    }

    private static void addComponent(JPanel panel, Component comp, int x, int y, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(comp, gbc);
    }

    private static void switchPanel(String panelName) {
        cardLayout.show(frame.getContentPane(), panelName);
    }

    private static void exitProgram() {
        int result = JOptionPane.showConfirmDialog(frame, "정말 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private static void registerStudent() {
        try {
            Student std = new Student(gradeText.getText(), classText.getText(), numText.getText(), nameText.getText());
            if (stds.contains(std)) throw new Exception("이미 등록된 학생입니다.");
            
            stds.add(std);
            listModel.addElement(std.toString());

            gradeText.setText("");
            classText.setText("");
            numText.setText("");
            nameText.setText("");
            
            switchPanel("main");
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(frame, exception.getMessage());
        }
    }
}

@Data
@AllArgsConstructor
class Student {
    private int grade, classNum, num;
    private String name;

    public Student(String grade, String classNum, String num, String name) throws Exception {
        try { this.grade = Integer.parseInt(grade); } catch (Exception e) { throw new Exception("학년은 숫자만 입력해야 합니다."); }
        try { this.classNum = Integer.parseInt(classNum); } catch (Exception e) { throw new Exception("반은 숫자만 입력해야 합니다."); }
        try { this.num = Integer.parseInt(num); } catch (Exception e) { throw new Exception("번호는 숫자만 입력해야 합니다."); }
        this.name = name;
    }

    @Override
    public String toString() {
        return grade + "학년 " + classNum + "반 " + num + "번 " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return classNum == other.classNum && grade == other.grade && num == other.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classNum, grade, num);
    }
}

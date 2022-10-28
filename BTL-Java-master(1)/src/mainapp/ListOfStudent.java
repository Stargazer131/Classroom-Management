package mainapp;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import entity.Student;

public class ListOfStudent extends JFrame
{
    private ArrayList<Student> students;

    private JPanel mainPanel;
    private JScrollPane spForPanel;
    private JLabel lblListOfStudent;

    private GridBagConstraints gbc;

    public ListOfStudent(ArrayList<Student> listOfStudent)
    {
        this.students = listOfStudent;
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0,5, 0);

        initFrame();

        initMainPanel();
        this.setVisible(true);
    }


    private void initFrame()
    {
        this.setBounds(200, 50, 1200, 750);
        this.setResizable(false);
        this.setTitle("E-Classroom");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(null);
        ImageIcon icon = new ImageIcon("resources\\images\\Logo\\logo.png");
        this.setIconImage(icon.getImage());
    }


    private void initMainPanel() // tao main panel
    {
        lblListOfStudent = new JLabel("Danh sach hoc sinh");
        lblListOfStudent.setFont(new Font("Arial",100,30));
        lblListOfStudent.setBounds(0, 20, 400, 40);
        this.add(lblListOfStudent);


        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        initListOfStudentPanel();

        spForPanel = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spForPanel.setBounds(0, 75, 1185, 625);
        spForPanel.getVerticalScrollBar().setUnitIncrement(15);
        spForPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(spForPanel);
    }

    
    private void initListOfStudentPanel() // khoi tao tat ca cac panel chua thong tin sinh vien
    {
        for(int i = 0; i < 15; i++)
        {
            initStudentInfoPanel(i, null);
        }
    }
    
    private void initStudentInfoPanel(int index, Student student) // tao 1 panel chua thong tin cua sinh vien
    {
        gbc.gridx = 0;
        gbc.gridy = index;
        
        JPanel temp = new JPanel();
        temp.setPreferredSize(new Dimension(1185, 50));
        temp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        temp.setLayout(null);
        
        JLabel lblAvatar = createLabel("resources\\images\\Avatar\\Male.png", ""); // avatar gioi tinh
        lblAvatar.setBounds(0, 0, 50, 50);

        JLabel lblId = createLabel("resources\\images\\ProfileIcon\\Id.png", String.format("B20DCCN%03d", index)); // ma sinh vien
        lblId.setBounds(50, 0, 200, 50);

        JLabel lblName = createLabel("resources\\images\\ProfileIcon\\Name.png", String.format("Nguyen Van %02d", index)); // ho ten
        lblName.setBounds(250, 0, 275, 50);

        JLabel lblGroup = createLabel("resources\\images\\ProfileIcon\\Group.png", String.format("D20CQCN-%02db", index)); // lop
        lblGroup.setBounds(525, 0, 200, 50);

        JLabel lblPhone = createLabel("resources\\images\\ProfileIcon\\PhoneNumber.png", String.format("%09d", index));  // so dien thoai
        lblPhone.setBounds(725, 0, 150, 50);

        JLabel lblEmail = createLabel("resources\\images\\ProfileIcon\\Email.png", String.format("Nguyen Van %02d@gmail.com", index));  // email
        lblEmail.setBounds(875, 0, 325, 50);


        temp.add(lblAvatar);
        temp.add(lblId);
        temp.add(lblName);
        temp.add(lblGroup);
        temp.add(lblPhone);
        temp.add(lblEmail);

        mainPanel.add(temp, gbc);
    }

    private static JLabel createLabel(String url, String name)
    {
        ImageIcon iconId = new ImageIcon(url);         
        JLabel lbl = new JLabel(name, resizeImage(iconId), JLabel.LEFT);                  
        lbl.setVerticalTextPosition(JLabel.CENTER);
        lbl.setHorizontalTextPosition(JLabel.RIGHT);
        lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return lbl;
    }

    private static ImageIcon resizeImage(ImageIcon imageIcon)  // resize icon to fit in the frame
    {
        Image image = imageIcon.getImage(); // transform it 
        Image newImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // scale it the smooth way  
        return new ImageIcon(newImage);
    }
    
    public static void main(String[] args) {
        new ListOfStudent(null);    
    }
}
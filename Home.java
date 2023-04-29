//author: MD Saifullah

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame
{
    Container container;
    JButton mounthlyExpenseBtn;
    JButton weeklyTrendBtn;
    JButton addExpenseBtn;
    
    

    MyFrame()
    {
        container = this.getContentPane();
        container.setLayout(null);
        Color color = new Color(0, 30, 50);
        container.setBackground(color);

        ImageIcon backButtonIcon = new ImageIcon("images/backButton.png");
        backButtonIcon = new ImageIcon(backButtonIcon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        JButton backButtonBtn = new JButton(backButtonIcon);
        backButtonBtn.setBounds(20, 45, backButtonIcon.getIconWidth(), backButtonIcon.getIconHeight());
        backButtonBtn.setBackground(color);
        backButtonBtn.setBorderPainted(false);
        
        // container.add(backButtonBtn);
     
        ImageIcon icon = new ImageIcon(new ImageIcon("images/icon.png").getImage().getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH));
        Font HFont = new Font("Calibri", Font.BOLD, 25);
        Color hColor = new Color(255, 255, 255);
        JLabel HeadingLabel = new JLabel("Budget Management System");
        HeadingLabel.setIcon(icon);
        HeadingLabel.setBounds(120, 30, 400, 100);
        HeadingLabel.setBackground(color);
        HeadingLabel.setFont(HFont);
        HeadingLabel.setForeground(hColor);
        container.add(HeadingLabel);

        ImageIcon mounthlyExpenseIcon = new ImageIcon("images/MounthlyExpense.png");
        mounthlyExpenseIcon = new ImageIcon(mounthlyExpenseIcon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
        mounthlyExpenseBtn = new JButton("Expense Report", mounthlyExpenseIcon);
        mounthlyExpenseBtn.setBounds(150, 150, mounthlyExpenseIcon.getIconWidth()+200, mounthlyExpenseIcon.getIconHeight());
        container.add(mounthlyExpenseBtn);

        //adding action to the Monthly Expense Button
        mounthlyExpenseBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisposeWindow();
                JFrame monthlyExpenseframe = new JFrame();
                monthlyExpenseframe.setVisible(true);
                monthlyExpenseframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                monthlyExpenseframe.setTitle("Budget Management System");
                monthlyExpenseframe.setBounds(50, 50, 600, 700);
                ImageIcon icon = new ImageIcon("images/icon2.png");
                monthlyExpenseframe.setIconImage(icon.getImage());

                //setting up container of the frame
                Container monthlyExpenseContainer = monthlyExpenseframe.getContentPane();
                monthlyExpenseContainer.setLayout(null);
                monthlyExpenseContainer.setBackground(color);

                Label MEHeadingLabel = new Label("Yearly Expense Report");
                MEHeadingLabel.setBounds(90, 20, 300, 100);
                MEHeadingLabel.setFont(HFont);
                MEHeadingLabel.setForeground(hColor);
                monthlyExpenseContainer.add(MEHeadingLabel);
                // MEHeadingLabel.setVisible(false);
                monthlyExpenseContainer.add(backButtonBtn);
                backButtonBtn.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                        ShowWindow();
                        monthlyExpenseframe.setVisible(false);
                    }
                });
                
                ImageIcon graphImageIcon = new ImageIcon(new ImageIcon("images/lastYearExpense.png").getImage().getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH));
                JLabel graph = new JLabel(graphImageIcon);
                graph.setBounds(90, 100, 400, 600);
                monthlyExpenseContainer.add(graph);

                String options[] = {"Monthly", "Weekly", "Yearly"};
                JComboBox option = new JComboBox<String>(options);
                option.setBounds(400, 50, 120, 40);
                // option.addActionListener(new java.awt.event.actionList);
                monthlyExpenseContainer.add(option);
                option.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // System.out.println("Selected option: " + option.getSelectedItem());
                        if((String)option.getSelectedItem() == "Weekly")
                        {
                            graph.setIcon(new ImageIcon(new ImageIcon("images/lastWeekExpense.png").getImage().getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH)));
                            // System.out.println("Graph CHanged");
                            MEHeadingLabel.setText("Weekly Expense Report");
                        }
                        else if((String)option.getSelectedItem() == "Monthly")
                        {
                            graph.setIcon(new ImageIcon(new ImageIcon("images/lastYearExpense.png").getImage().getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH)));
                            // System.out.println("Graph CHanged");
                            MEHeadingLabel.setText("Monthly Expense Report");
                        }
                        else
                        {
                            graph.setIcon(new ImageIcon(new ImageIcon("images/YearlyExpense.png").getImage().getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH)));
                            // System.out.println("Graph CHanged");
                            MEHeadingLabel.setText("Yearly Expense Report");
                        }
                    }
                });
                
                // backButtonBtn
                

            }
        });
        
        // ImageIcon backButtonIcon = new ImageIcon("backButton.jpg");
        // backButtonIcon = new ImageIcon(backButtonIcon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
        
        ImageIcon weeklyTrendIcon = new ImageIcon("images/weeklyTrends.png");
        weeklyTrendIcon = new ImageIcon(weeklyTrendIcon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
        weeklyTrendBtn = new JButton("Trend Report ", weeklyTrendIcon);
        weeklyTrendBtn.setBounds(150, 270, weeklyTrendIcon.getIconWidth()+200, weeklyTrendIcon.getIconHeight());
        container.add(weeklyTrendBtn);
        weeklyTrendBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisposeWindow();
                JFrame Trendframe = new JFrame();
                Trendframe.setVisible(true);
                Trendframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Trendframe.setTitle("Budget Management System");
                Trendframe.setBounds(50, 50, 600, 700);
                ImageIcon icon = new ImageIcon("images/icon2.png");
                Trendframe.setIconImage(icon.getImage());

                //setting up container of the frame
                Container TrendContainer = Trendframe.getContentPane();
                TrendContainer.setLayout(null);
                TrendContainer.setBackground(color);

                Label MEHeadingLabel = new Label("Trend Report");
                MEHeadingLabel.setBounds(90, 20, 300, 100);
                MEHeadingLabel.setFont(HFont);
                MEHeadingLabel.setForeground(hColor);
                TrendContainer.add(MEHeadingLabel);
                // MEHeadingLabel.setVisible(false);
                TrendContainer.add(backButtonBtn);
                backButtonBtn.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                        ShowWindow();
                        Trendframe.setVisible(false);
                    }
                });
                
                // ImageIcon graphImageIcon = new ImageIcon(new ImageIcon("images/lastYearExpense.png").getImage().getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH));
                // JLabel graph = new JLabel(graphImageIcon);
                // graph.setBounds(90, 100, 400, 600);
                // monthlyExpenseContainer.add(graph);
                int px = 150, py = 200;
                JProgressBar progressBar1 = new JProgressBar(0, 100);
                progressBar1.setValue(10);
                progressBar1.setStringPainted(true);
                progressBar1.setBounds(px, py, 300, 50);
                TrendContainer.add(progressBar1);

                JLabel item1 = new JLabel("Electricity Bill");
                item1.setForeground(new Color(255, 255, 255));
                item1.setBounds(px-90, py-50, 200, 150);
                TrendContainer.add(item1);

                JProgressBar progressBar2 = new JProgressBar(0, 100);
                progressBar2.setValue(30);
                progressBar2.setStringPainted(true);
                progressBar2.setBounds(px, py+70, 300, 50);
                TrendContainer.add(progressBar2);

                JLabel item2 = new JLabel("Gas Bill");
                item2.setForeground(new Color(255, 255, 255));
                item2.setBounds(px-90, py+15, 200, 150);
                TrendContainer.add(item2);

                JProgressBar progressBar3 = new JProgressBar(0, 100);
                progressBar3.setValue(43);
                progressBar3.setStringPainted(true);
                progressBar3.setBounds(px, py+140, 300, 50);
                TrendContainer.add(progressBar3);

                JLabel item3 = new JLabel("Grocery");
                item3.setForeground(new Color(255, 255, 255));
                item3.setBounds(px-90, py+80, 200, 150);
                TrendContainer.add(item3);

                JProgressBar progressBar4 = new JProgressBar(0, 100);
                progressBar4.setValue(25);
                progressBar4.setStringPainted(true);
                progressBar4.setBounds(px, py+210, 300, 50);
                TrendContainer.add(progressBar4);

                JLabel item4 = new JLabel("Travels");
                item4.setForeground(new Color(255, 255, 255));
                item4.setBounds(px-90, py+145, 200, 150);
                TrendContainer.add(item4);
                
                JProgressBar progressBar5 = new JProgressBar(0, 100);
                progressBar5.setValue(7);
                progressBar5.setStringPainted(true);
                progressBar5.setBounds(px, py+280, 300, 50);
                TrendContainer.add(progressBar5);

                JLabel item5 = new JLabel("other");
                item5.setForeground(new Color(255, 255, 255));
                item5.setBounds(px-90, py+210, 200, 150);
                TrendContainer.add(item5);
                // Add the progress bar to the frame

                String options[] = {"Monthly", "Weekly", "Yearly"};
                JComboBox option = new JComboBox<String>(options);
                option.setBounds(400, 50, 120, 40);
                // option.addActionListener(new java.awt.event.actionList);
                TrendContainer.add(option);
                option.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // System.out.println("Selected option: " + option.getSelectedItem());
                        if((String)option.getSelectedItem() == "Weekly")
                        {
                            MEHeadingLabel.setText("Weekly Expense Report");
                            progressBar1.setValue(10);
                            progressBar2.setValue(30);
                            progressBar3.setValue(43);
                            progressBar4.setValue(25);
                            progressBar5.setValue(7);
                            // progressB
                        }
                        else if((String)option.getSelectedItem() == "Monthly")
                        {
                            MEHeadingLabel.setText("Monthly Expense Report");
                            progressBar1.setValue(30);
                            progressBar2.setValue(5);
                            progressBar3.setValue(54);
                            progressBar4.setValue(26);
                            progressBar5.setValue(10);
                            System.out.println("Graph CHanged");
                        }
                        else
                        {
                            MEHeadingLabel.setText("Yearly Expense Report");
                            progressBar1.setValue(53);
                            progressBar2.setValue(5);
                            progressBar3.setValue(12);
                            progressBar4.setValue(25);
                            progressBar5.setValue(5);
                            System.out.println("Graph CHanged");
                        }
                    }
                });
                
                // backButtonBtn
                

            }
        });



        ImageIcon addExpenseIcon = new ImageIcon("images/addExpense.png");
        addExpenseIcon = new ImageIcon(addExpenseIcon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
        addExpenseBtn = new JButton("Add Expense", addExpenseIcon);
        addExpenseBtn.setBounds(150, 390, addExpenseIcon.getIconWidth()+200, addExpenseIcon.getIconHeight());
        container.add(addExpenseBtn);
        addExpenseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // ExpenseFrame ef = new ExpenseFrame();
                // ef.setVisible(true);
                DisposeWindow();
                JFrame AddExpenseframe = new JFrame();
                AddExpenseframe.setVisible(true);
                AddExpenseframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                AddExpenseframe.setTitle("Budget Management System");
                AddExpenseframe.setBounds(50, 50, 600, 700);
                ImageIcon icon = new ImageIcon("images/icon2.png");
                AddExpenseframe.setIconImage(icon.getImage());

                //setting up container of the frame
                Container AddExpenseContainer = AddExpenseframe.getContentPane();
                AddExpenseContainer.setLayout(null);
                AddExpenseContainer.setBackground(color);

                Label MEHeadingLabel = new Label("Add Expense");
                MEHeadingLabel.setBounds(90, 20, 300, 100);
                MEHeadingLabel.setFont(HFont);
                MEHeadingLabel.setForeground(hColor);
                AddExpenseContainer.add(MEHeadingLabel);
                // MEHeadingLabel.setVisible(false);
                AddExpenseContainer.add(backButtonBtn);
                backButtonBtn.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                        ShowWindow();
                        AddExpenseframe.setVisible(false);
                    }
                });
                
                JTextField titleField = new JTextField("ex. Electricity Bill", 20);
                titleField.setBounds(160, 200, 300, 50);
                AddExpenseContainer.add(titleField);
                JLabel titleLabel = new JLabel("Enter Title        :");
                titleLabel.setForeground(Color.WHITE);
                titleLabel.setBounds(50, 200, 100, 50);
                AddExpenseContainer.add(titleLabel);

                JTextField amountField = new JTextField("ex. 5769", 20);
                amountField.setBounds(160, 275, 300, 50);
                AddExpenseContainer.add(amountField);
                JLabel ExpenseLabel = new JLabel("Enter Expense :");
                ExpenseLabel.setForeground(Color.WHITE);
                ExpenseLabel.setBounds(50, 270, 100, 50);
                AddExpenseContainer.add(ExpenseLabel);


                JButton addButton = new JButton("Add");
                addButton.setBounds(250, 350, 100, 50);
                AddExpenseContainer.add(addButton);

                JDialog dialog = new JDialog(AddExpenseframe, "Expense Added", null, getGraphicsConfiguration());
                dialog.setBounds(200, 200, 450, 230);
                dialog.setLayout(null);
                dialog.setBackground(color);

                Container d = dialog.getContentPane();
                d.setBackground(color);

                JLabel msgLabel = new JLabel();
                msgLabel.setBounds(30, 50, 400, 50);
                msgLabel.setForeground(Color.GREEN);
                d.add(msgLabel);

                JButton okButton = new JButton("ok");
                okButton.setBounds(150, 125, 75, 30);
                d.add(okButton);

                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ev)
                    {
                        // d.setVisible(false);
                        dialog.dispose();
                    }
                });
                addButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ev)
                    {
                        if(titleField.getText().length() == 0 || amountField.getText().length() == 0){
                            msgLabel.setForeground(Color.RED);
                            msgLabel.setText("Please fill required Filed correctly");
                            dialog.setVisible(true);
                        }
                        else if(!(amountField.getText().chars().allMatch( Character::isDigit )))
                        {
                            msgLabel.setForeground(Color.RED);
                            msgLabel.setText("amount should be a real Number");
                            dialog.setVisible(true);
                        }
                        else
                        {
                            msgLabel.setForeground(Color.GREEN);
                            msgLabel.setText("Your expense of Rs." + amountField.getText() + " for " + titleField.getText() + " Has been added!!");
                            dialog.setVisible(true);
                        }
                        
                    }
                });
            }
        });
        

    }
    public void DisposeWindow()
    {
        this.setVisible(false);
        // this.dispose();
    }
    public void ShowWindow()
    {
        this.setVisible(true);
    }
}
public class Home
{
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Budget Management System");
        frame.setBounds(50, 50, 600, 700);
        ImageIcon icon = new ImageIcon("images/icon2.png");
        frame.setIconImage(icon.getImage());
       

    }
}
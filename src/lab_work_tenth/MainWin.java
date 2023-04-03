package lab_work_tenth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class MainWin {

	private JFrame frame;
	private JTextField textField;
	private VisualArray visualArray = new VisualArray(new String("0"));
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin window = new MainWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1047, 779);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(10, 11, 684, 718);
		frame.getContentPane().add(textArea);

		JLabel lblNewLabel = new JLabel("Введите массив через \",\" например: 5,7,6,3,2,1");
		lblNewLabel.setBounds(704, 11, 317, 27);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(704, 37, 317, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton pbReady = new JButton("Готово");
		pbReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty())
					return;
				visualArray = new VisualArray(textField.getText());
			}
		});
		pbReady.setBounds(704, 75, 317, 32);
		frame.getContentPane().add(pbReady);
		
		JButton pbDisplaySourceArr = new JButton("Отобразить исходный массив");
		pbDisplaySourceArr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(visualArray.displaySourceArr()); 
			}
		});
		pbDisplaySourceArr.setBounds(704, 118, 317, 32);
		frame.getContentPane().add(pbDisplaySourceArr);
		
		JButton pbDisplaySortArr = new JButton("Отобразить отсортированный массив");
		pbDisplaySortArr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(visualArray.displaySortArr());
			}
		});
		pbDisplaySortArr.setBounds(704, 161, 317, 32);
		frame.getContentPane().add(pbDisplaySortArr);
		
		JButton pbStepByStepSorting = new JButton("Пошаговая Сортировка");
		pbStepByStepSorting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(visualArray.displayStepByStepSort());
			}
		});
		pbStepByStepSorting.setBounds(704, 204, 317, 37);
		frame.getContentPane().add(pbStepByStepSorting);
	}
}

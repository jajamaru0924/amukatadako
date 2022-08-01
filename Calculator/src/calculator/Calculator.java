package calculator;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import calcLogic.CalcLogic;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
					frame.setSize(450, 650);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		CalcLogic calcLogic = new CalcLogic();
		//入力履歴兼数式ラベル
		JLabel formulaLabel = new JLabel("");
		contentPane.add(formulaLabel);
		formulaLabel.setPreferredSize(new Dimension(420, 20));//コンテンツ自体のサイズ
		formulaLabel.setFont(new Font("ＭＳ ゴシック", Font.LAYOUT_LEFT_TO_RIGHT, 20));//(フォント名,文字スタイル,フォントサイズ)
		formulaLabel.setHorizontalAlignment(JLabel.RIGHT);//右寄せ
		//計算結果表示ラベル
		JLabel resultLabel = new JLabel("0");
		contentPane.add(resultLabel);
		resultLabel.setPreferredSize(new Dimension(420, 90));
		resultLabel.setFont(new Font("ＭＳ ゴシック", Font.LAYOUT_LEFT_TO_RIGHT, 60));
		resultLabel.setHorizontalAlignment(JLabel.RIGHT);
		
	//------------------------ここからボタン----------------------------------------------
	//ACボタン
		JButton allClearButton = new JButton("AC");
		//イベントハンドラ
		allClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText("0");
				formulaLabel.setText("");
			}
		});
		contentPane.add(allClearButton);
		allClearButton.setPreferredSize(new Dimension(90, 90));
		allClearButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
			
	//Cボタン
		JButton clearButton = new JButton("C");
		//イベントハンドラ
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText("0");
			}
		});
		contentPane.add(clearButton);
		clearButton.setPreferredSize(new Dimension(90, 90));
		clearButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
	
	//一文字削除ボタン
		ImageIcon icon = new ImageIcon("./images/button.png");
		JButton backButton = new JButton("＜");
		//イベントハンドラ
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder(resultLabel.getText());
				if(sb.length() == 1) {
					resultLabel.setText("0");
				}else {
					resultLabel.setText(sb.deleteCharAt(sb.length()-1).toString());
				}
			}
		});
		contentPane.add(backButton);
		backButton.setPreferredSize(new Dimension(90, 90));
		backButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//÷ボタン
		JButton divisionButton = new JButton("÷");
		//イベントハンドラ
		divisionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formulaLabel.setText(resultLabel.getText() + "÷");
			//resultLabelがEだった場合初期状態に戻す
				if(resultLabel.getText().equals("E")) {
					formulaLabel.setText("");
				}
				resultLabel.setText("0");
			}
		});
		contentPane.add(divisionButton);
		divisionButton.setPreferredSize(new Dimension(120, 90));
		divisionButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//7ボタン
		JButton sevenButton = new JButton("7");
		//イベントハンドラ
		sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText(calcLogic.setResultLabel(sevenButton, resultLabel, formulaLabel));
			}
		});
		contentPane.add(sevenButton);
		sevenButton.setPreferredSize(new Dimension(90, 90));
		sevenButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//8ボタン
		JButton eightButton = new JButton("8");
		//イベントハンドラ
		eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText(calcLogic.setResultLabel(eightButton, resultLabel, formulaLabel));
			}
		});
		contentPane.add(eightButton);
		eightButton.setPreferredSize(new Dimension(90, 90));
		eightButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//9ボタン
		JButton nineButton = new JButton("9");
		//イベントハンドラ
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText(calcLogic.setResultLabel(nineButton, resultLabel, formulaLabel));
			}
		});
		contentPane.add(nineButton);
		nineButton.setPreferredSize(new Dimension(90, 90));
		nineButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//×ボタン
		JButton multiplicationButton = new JButton("×");
		//イベントハンドラ
		multiplicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formulaLabel.setText(resultLabel.getText() + "×");
			//resultLabelがEだった場合初期状態に戻す
				if(resultLabel.getText().equals("E")) {
					formulaLabel.setText("");
				}
				resultLabel.setText("0");
			}
		});
		contentPane.add(multiplicationButton);
		multiplicationButton.setPreferredSize(new Dimension(120, 90));
		multiplicationButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//4ボタン
		JButton fourButton = new JButton("4");
		//イベントハンドラ
		fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText(calcLogic.setResultLabel(fourButton, resultLabel, formulaLabel));
			}
		});
		contentPane.add(fourButton);
		fourButton.setPreferredSize(new Dimension(90, 90));
		fourButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//5ボタン
		JButton fiveButton = new JButton("5");
		//イベントハンドラ
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText(calcLogic.setResultLabel(fiveButton, resultLabel, formulaLabel));
			}
		});
		contentPane.add(fiveButton);
		fiveButton.setPreferredSize(new Dimension(90, 90));
		fiveButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//6ボタン
		JButton sixButton = new JButton("6");
		//イベントハンドラ
		sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText(calcLogic.setResultLabel(sixButton, resultLabel, formulaLabel));
			}
		});
		contentPane.add(sixButton);
		sixButton.setPreferredSize(new Dimension(90, 90));
		sixButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//-ボタン
		JButton subtractionButton = new JButton("-");
		//イベントハンドラ
		subtractionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formulaLabel.setText(resultLabel.getText() + "-");
			//resultLabelがEだった場合初期状態に戻す
				if(resultLabel.getText().equals("E")) {
					formulaLabel.setText("");
				}
				resultLabel.setText("0");
			}
		});
		contentPane.add(subtractionButton);
		subtractionButton.setPreferredSize(new Dimension(120, 90));
		subtractionButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//1ボタン
		JButton oneButton = new JButton("1");
		//イベントハンドラ
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText(calcLogic.setResultLabel(oneButton, resultLabel, formulaLabel));
			}
		});
		contentPane.add(oneButton);
		oneButton.setPreferredSize(new Dimension(90, 90));
		oneButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//2ボタン
		JButton twoButton = new JButton("2");
		//イベントハンドラ
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText(calcLogic.setResultLabel(twoButton, resultLabel, formulaLabel));
			}
		});
		contentPane.add(twoButton);
		twoButton.setPreferredSize(new Dimension(90, 90));
		twoButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//3ボタン
		JButton threeButton = new JButton("3");
		//イベントハンドラ
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText(calcLogic.setResultLabel(threeButton, resultLabel, formulaLabel));
			}
		});
		contentPane.add(threeButton);
		threeButton.setPreferredSize(new Dimension(90, 90));
		threeButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//+ボタン
		JButton additionButton = new JButton("+");
		//イベントハンドラ
		additionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formulaLabel.setText(resultLabel.getText() + "+");
			//resultLabelがEだった場合初期状態に戻す
				if(resultLabel.getText().equals("E")) {
					formulaLabel.setText("");
				}
				resultLabel.setText("0");
			}
		});
		contentPane.add(additionButton);
		additionButton.setPreferredSize(new Dimension(120, 90));
		additionButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//小数点ボタン
		JButton decimalButton = new JButton(".");
		//イベントハンドラ
		decimalButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				//resultLabelがEだった場合初期状態に戻す
					if(resultLabel.getText().equals("E")) {
						formulaLabel.setText("");
						resultLabel.setText("0");
					}	
				//resultLabelに小数点が入っていなかった場合のみ小数点を打つことができるように
					if(!resultLabel.getText().contains(".")) {
						resultLabel.setText(resultLabel.getText() + decimalButton.getText());
					}
				}
			});
		contentPane.add(decimalButton);
		decimalButton.setPreferredSize(new Dimension(90, 90));
		decimalButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//0ボタン
		JButton zeroButton = new JButton("0");
		//イベントハンドラ
		zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText(calcLogic.setResultLabel(zeroButton, resultLabel, formulaLabel));
			}
		});
		contentPane.add(zeroButton);
		zeroButton.setPreferredSize(new Dimension(90, 90));
		zeroButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	//=ボタン
		JButton equalButton = new JButton("=");
		//イベントハンドラ
		equalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText(calcLogic.calc(formulaLabel, resultLabel));
				formulaLabel.setText(resultLabel.getText());
			//エラーの状態で＝が入力されたとき
				if(formulaLabel.getText().equals("0")) {
					formulaLabel.setText("");
				}
			}
		});
		contentPane.add(equalButton);
		equalButton.setPreferredSize(new Dimension(215, 90));
		equalButton.setFont(new Font("ＭＳ ゴシック", Font.CENTER_BASELINE, 40));
		
	}
}

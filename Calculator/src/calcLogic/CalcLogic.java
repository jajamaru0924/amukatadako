package calcLogic;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CalcLogic {
//数字のボタンが押されたときに文字列に連結してresultLabelに表示するためのメソッド（０～９ボタン共通の処理）
	public String setResultLabel(JButton button, JLabel resultLabel, JLabel formulaLabel) {
		String buttonNum = button.getText();
		String getLabel = resultLabel.getText().replaceAll(",", "");
	//ERRORから1文字削除して数字を入れると入力できてしまうのでそれを避ける
		if(getLabel.matches("[+-]?\\d+")) {
			if(resultLabel.getText().length() <= 13) {
				resultLabel.setFont(new Font("ＭＳ ゴシック", Font.LAYOUT_LEFT_TO_RIGHT, 60));
			}else if(resultLabel.getText().length() > 13){
				resultLabel.setFont(new Font("ＭＳ ゴシック", Font.LAYOUT_LEFT_TO_RIGHT, 40));
				if(resultLabel.getText().length() >= 20){
					System.out.println("[エラー]入力されたボタン：" + buttonNum);
					System.out.println("[エラー]resultLabelの値：" + getLabel);
					System.out.println("[エラー]resultLabelの桁数：" + resultLabel.getText().length());
					formulaLabel.setText("");
					return "E";
				}
			}
			if(resultLabel.getText() == "0") {
				return buttonNum;
			}
		//ここでformat関数を使う際にint型に変換してしまうと2147483647以上の数字の場合NumberformatExceptionが出てしまうのでLong型に変換する
			return String.format("%,d",Long.parseLong(getLabel + buttonNum));
		//少数が入力された場合の処理
		}else if(getLabel.contains(".")){
			if(resultLabel.getText().length() <= 13) {
				resultLabel.setFont(new Font("ＭＳ ゴシック", Font.LAYOUT_LEFT_TO_RIGHT, 60));
			}else if(resultLabel.getText().length() > 13){
				resultLabel.setFont(new Font("ＭＳ ゴシック", Font.LAYOUT_LEFT_TO_RIGHT, 40));
				if(resultLabel.getText().length() >= 20){
					System.out.println("[エラー]入力されたボタン：" + buttonNum);
					System.out.println("[エラー]resultLabelの値：" + getLabel);
					System.out.println("[エラー]resultLabelの桁数：" + resultLabel.getText().length());
					formulaLabel.setText("");
					return "E";
				}
			}
			String result = Double.toString(Double.parseDouble(getLabel + buttonNum));
			char[] ch = result.toCharArray();
			for(int i = 0; i < ch.length; i++) {
				if(ch[i] == '.') {
				String seisu = 	String.format("%,d",Integer.parseInt(result.substring(0, result.indexOf(ch[i]))));
				String syosu = result.substring(result.indexOf(ch[i]) + 1,result.length());
				return seisu + "." + syosu;
				}
				
			}
		}
		System.out.println("[エラー]入力されたボタン：" + buttonNum);
		System.out.println("[エラー]resultLabelの値：" + getLabel);
		return "E";
	}
	
	public String calc(JLabel formulaLabel, JLabel resultLabel) {
	//Labelどうしの文字列を連結させてから1文字ごとに分けて配列に格納する
		String formula = formulaLabel.getText().replaceAll(",", "") + resultLabel.getText().replaceAll(",", "");
		char[] ch = formula.toCharArray();
	//連結させた文字列の中から数字ではない文字を探し出して、その文字の演算子ごとの処理をした後その答えを文字列にして返す
		for(int i = 0; i < ch.length; i++) {
			if(!Character.isDigit(ch[i]) && ch[i] != '.' && ch[i] != 'E'){
				System.out.println(ch[i]);
				if(ch[i] == '÷' && ch[i] != '-') {
				//演算子から見て前にあるか後ろにあるかで2つの値を判断する
					double value1 = Double.parseDouble(formula.substring(0, formula.indexOf(ch[i])));
					double value2 = Double.parseDouble(formula.substring(formula.indexOf(ch[i]) + 1,formula.length())); 
				//計算結果をStringにキャストして1文字ずつ配列に入れる
					String result = Float.toString((float) (value1 / value2));
					char[] chResult = result.toCharArray();
				//数字ではない文字（小数点）の場所を利用して整数と少数に分け、フォーマット関数で整数の3桁ごとにカンマをつたあと1つに戻して返す
					for(int r = 0; r < chResult.length; r++) {
						if(!Character.isDigit(chResult[r])){
							if(chResult[r] == '.') {
							String seisu = 	String.format("%,d",Integer.parseInt(result.substring(0, result.indexOf(chResult[r]))));
							String syosu = result.substring(result.indexOf(chResult[r]) + 1,result.length());
							//少数が０の場合は整数のみ返す
								if(syosu.equals("0")) {
									return seisu;
								}else {
									return seisu + "." + syosu;
								}
							}
						}
					}
					
				}
				if(ch[i] == '×' && ch[i] != 'E') {
				//演算子から見て前にあるか後ろにあるかで2つの値を判断する
					double value1 = Double.parseDouble(formula.substring(0, formula.indexOf(ch[i])));
					double value2 = Double.parseDouble(formula.substring(formula.indexOf(ch[i]) + 1,formula.length())); 
					String result = Float.toString((float)(value1 * value2));
					char[] chResult = result.toCharArray();
					
					for(int r = 0; r < chResult.length; r++) {
						if(!Character.isDigit(chResult[r])){
							if(chResult[r] == '.') {
							String seisu = 	String.format("%,d",Integer.parseInt(result.substring(0, result.indexOf(chResult[r]))));
							String syosu = result.substring(result.indexOf(chResult[r]) + 1,result.length());
							System.out.println(seisu);
							System.out.println(syosu);
								if(syosu.equals("0")) {
									return seisu;
								}else {
									return seisu + "." + syosu;
								}
							}
						}
					}
					
				}
				if(ch[i] == '-' && ch[0] != '-' && ch[i] != 'E') {
				//演算子から見て前にあるか後ろにあるかで2つの値を判断する
					double value1 = Double.parseDouble(formula.substring(0, formula.indexOf(ch[i])));
					double value2 = Double.parseDouble(formula.substring(formula.indexOf(ch[i]) + 1,formula.length())); 
					String result = Double.toString(value1 - value2);
					char[] chResult = result.toCharArray();
					
					for(int r = 0; r < chResult.length; r++) {
						if(!Character.isDigit(chResult[r])){
							if(chResult[r] == '.') {
							String seisu = 	String.format("%,d",Integer.parseInt(result.substring(0, result.indexOf(chResult[r]))));
							String syosu = result.substring(result.indexOf(chResult[r]) + 1,result.length());
								if(syosu.equals("0")) {
									return seisu;
								}else {
									return seisu + "." + syosu;
								}
							}
						}
					}
					
				}
				if(ch[i] == '+' && ch[0] != '0' && ch[i] != 'E') {
				//演算子から見て前にあるか後ろにあるかで2つの値を判断する
					double value1 = Double.parseDouble(formula.substring(0, formula.indexOf(ch[i])));
					double value2 = Double.parseDouble(formula.substring(formula.indexOf(ch[i]) + 1,formula.length())); 
					String result = Double.toString(value1 + value2);
					char[] chResult = result.toCharArray();
					
					for(int r = 0; r < chResult.length; r++) {
						if(!Character.isDigit(chResult[r])){
							if(chResult[r] == '.') {
							String seisu = 	String.format("%,d",Integer.parseInt(result.substring(0, result.indexOf(chResult[r]))));
							String syosu = result.substring(result.indexOf(chResult[r]) + 1,result.length());
								if(syosu.equals("0")) {
									return seisu;
								}else {
									return seisu + "." + syosu;
								}
							}
						}
					}
					
				}		
			}
		}
		return "0";
	}
	
}
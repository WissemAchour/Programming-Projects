package com.mvc.portlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Wissem
 */
public class pdf_reader {
	
int page;
private static String filePath;

public pdf_reader(String filePath,int PdfPage){
	
	this.filePath=filePath;
	this.page=PdfPage;
}
	/**
	 * @param args
	 *            the command line arguments
	 */
	

	private boolean isValid(Cell c) {
		return c.isValid();
	}

	private boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	public void addCell(Cell c, List<Cell> cells) {
		int n = (cells.size() + 1);
		int col = (n - 1) % 6 + 1;
		int row = (n - 1) / 6 + 1;
		//System.out.println("------------------>> added Cell n=" + n + "/c="
		//		+ col + "/r=" + row + " :: " + c);
		cells.add(c);
	}

	public List<Cell> getCells() {
		List<Token> tokens = getTokens();
		List<Cell> cells = new ArrayList<Cell>();
		Cell current = new Cell();
		String lastHour = null;

		for (int i = 0; i < tokens.size(); i++) {
			Token t = tokens.get(i);
			current.hour = lastHour;
			//System.out.println(">> [" + tokens.get(i) + "]  " + current);

			switch (t.getType()) {

			case TEACHER: {
				
				String[] next_tab = new String[2];
				String[] tab = new String[2];
				tab = tokens.get(i).getValue().split(";", 3);
				for (String s : tab) {
					if (isEmpty(current.teacher1)) {
						current.teacher1 = s;
					} else if (isEmpty(current.teacher2)) {
						current.teacher2 = s;
					}
				}
				break;
			}
			case HOUR: {

				String[] tim_tab = new String[2];
				current.hour = tokens.get(i).getValue().trim();
				lastHour = current.hour;
				// System.out.println(tim_tab[0].trim());
				// seance.setHeure(tim_tab[0].trim().trim());
				// em.persist(seance);
				break;
			}
			case COURSE: {

				

				String course = tokens.get(i).getValue();

				String[] tab1 = new String[2];
				String[] tab_err = new String[2];

				if (course.matches(".*(TP).*")){
					tab1 = course.trim().split("\\(TP\\)", 2);
				}
				else if (course.replaceAll("(1\15)", " ") != null)
					{
					tab_err = course.trim().split("(1.15)", 3);
			for (int j = 0; j < tab_err.length-1; j++) {
				tab_err[j]=tab_err[j].replaceAll("\\(", " ").trim();
				tab_err[j]=tab_err[j].replaceAll("\\)", " ").trim();
			}
			
			
					}

				if (tab1.length != 0) {
					// if (tab1.length == 2) {
					for (int k = 0; k < tab1.length; k++) {
						String v = tab1[k].trim();
						if (!isEmpty(v)) {
							if (isEmpty(current.course1)) {
								current.course1 = v + " (TP)";
							} else if (isEmpty(current.course2)) {
								current.course2 = v /*+ " (TP)"*/;
							}
						}
					}
					// }

				}

				else if (tab_err.length >= 2) {
					
					for (int k = 0; k < tab_err.length ; k++) {
						
						String v = tab_err[k].trim();
						if (!isEmpty(v)) {
							if (isEmpty(current.course1)) {
								current.course1 = v+  " (1/15)" ;
							} else if (isEmpty(current.course2)) {
								current.course2 = v + " (1/15)";
							}
						}
					}

				}

				else {
					//mat.setNomMat(course.trim());
					current.course1 = course.trim();
					
					// System.out.println(course.trim());

				}

				break;
			}
			case ROOM: {
				String room_tab = tokens.get(i).getValue();
				if (isEmpty(current.room1)) {
					current.room1 = room_tab.trim();
					
				} else {
				
					current.room2 = room_tab.trim();
				}

				break;
			}
			case SUBCLASS: {

				String[] inter = t.getValue().split(" ");
				for (int m = 0; m < inter.length; m++) {
					if (current.subclass1 == null
							|| current.subclass1.isEmpty()) {
						current.subclass1 = inter[m];
					} else {
						current.subclass2 = inter[m];
					}
				}
				break;
			}
			}

			if (t.getType() == TokenType.EMPTY
					|| i == tokens.size() - 1
					|| 
					(t.getType() == TokenType.ROOM && (
							tokens.get(i + 1).getType() == TokenType.SUBCLASS 
							|| tokens.get(i + 1).getType() == TokenType.COURSE
							|| tokens.get(i + 1).getType() == TokenType.EMPTY
							||tokens.get(i + 1).getType() == TokenType.HOUR
							)
							)
							) {
				addCell(current, cells);
				current=new Cell();
			}
		}
		return cells;
	}

	public List<Token> getTokens() {
		// public static void main(String[] args) {
		// TODO code application logic here
		String concat="";
		List<Token> cell = new ArrayList<Token>();
		List<Integer> end_index = new ArrayList<Integer>();
		String[] pause = new String[6];
		pdf_reader ok = new pdf_reader(this.filePath,this.page);
		try {

			PdfReader reader = new PdfReader(this.filePath);
			int n = reader.getNumberOfPages();
			TextExtractionStrategy strategy;
			PdfReaderContentParser parser = new PdfReaderContentParser(reader);
			for (int i =page; i <= page; i++) {
				strategy = parser.processContent(i,
						new SimpleTextExtractionStrategy());

				String text = strategy.getResultantText();
				text = text.trim();
				String[] subtext = text.split("\n");

				for (int j = 4; j < subtext.length -1; j++) {
					
					// Temps
					if (ok.isTime(subtext[j])) {
						
						String[] tim = new String[2];
						tim=subtext[j].trim().split(" ");
						
						if(tim.length==2){
							cell.add(new Token(tim[0], TokenType.HOUR));
							 //System.out.println(tim[0] + " ***Time");
							 cell.add(new Token(tim[1], TokenType.EMPTY));
							// System.out.println(tim[1] + " ***empty");
						}
						else{
						cell.add(new Token(subtext[j], TokenType.HOUR));
						// System.out.println(subtext[j] + " ***Time");
						}
					} // Salle
					else if (ok.isRoom(subtext[j])) {

						if (subtext[j].length() > 6) {

							boolean parenthese = false;
							for (int k = 0; k < subtext[j].length(); k++) {
								if (subtext[j].charAt(k) == '(') {
									parenthese = true;
								}
								else if (subtext[j].charAt(k) == ')') {
									parenthese = false;
								}

							}
							if (parenthese) {
								int index = 0;
								for (int k = 0; k < subtext[j].length(); k++) {
									if (subtext[j].charAt(k) == '(') {

										index = k;

									}

								}
								// System.out.println(subtext[j].substring(0,
							//	 index) + " ***Room");
								cell.add(new Token(subtext[j].substring(0,
										index), TokenType.ROOM));
								end_index.add((cell.size() - 1));
								//if(!ok.isTeacher(subtext[j-1]))
								
								j++;

							} else {
								String c1;
								String c2;
								boolean exist=false;
                                for (int k = 0; k < subtext[j].length(); k++) {
									if(subtext[j].charAt(k)==':'){
										exist=true;
									}
								}
                                if(exist){
                                	c1 = subtext[j].substring(0, 5);
                                	cell.add(new Token(c1, TokenType.ROOM));
                                }
                                else{
                                c1 = subtext[j].substring(0, subtext[j].length() / 2 - 1);
                                c2 = subtext[j].substring(subtext[j].length() / 2, subtext[j].length());
                                cell.add(new Token(c1, TokenType.ROOM));
                                cell.add(new Token(c2, TokenType.ROOM));
                                }
								/*cell.add(new Token(c1, TokenType.ROOM));
								cell.add(new Token(c2, TokenType.ROOM));
								end_index.add((cell.size() - 1));*/

							}

						} else {
							cell.add(new Token(subtext[j], TokenType.ROOM));
							end_index.add((cell.size() - 1));
							// System.out.println(subtext[j] + " ***Room");

						}
								//Teacher
					} else if (ok.isTeacher(subtext[j])) {
						cell.add(new Token(subtext[j], TokenType.TEACHER));
					//	 System.out.println(subtext[j] + " ***teacher");
						 //Upper
					} else if (ok.allUpper(subtext[j])) {
						//String[] sub_upp = new String[2];
						//sub_upp=subtext[j].split(" ",1);
						//System.out.println("++++++++++++++++++++++"+subtext[j+1]);
						if(ok.isRoom(subtext[j+1])){
							
							cell.add(new Token(subtext[j],TokenType.TEACHER));
							cell.add(new Token(subtext[j + 1],TokenType.ROOM));
					//		 System.out.println(subtext[j] + subtext[j + 1]+ " ***room");
							 
						}
						else{
						cell.add(new Token(subtext[j] + subtext[j + 1],
								TokenType.TEACHER));
						// System.out.println(subtext[j] + subtext[j + 1]
						// + " ***upper");
						}
						j = j + 1;
						//subclass
					} else if (ok.isSubclass(subtext[j])) {
						cell.add(new Token(subtext[j], TokenType.SUBCLASS));
					//	 System.out.println(subtext[j] + " ***subclass");
						 //course
					} else if ((ok.isRoom(subtext[j - 1])
							||ok.isRoom(subtext[j - 2]) 
							||ok.isTime(subtext[j - 1])
							||ok.isRoom(subtext[j - 3])
							||ok.isRoom(subtext[j - 4]) 
							|| ok.isSubclass(subtext[j - 1])
							|| ok.isTeacher(subtext[j + 1])
							|| ok.allUpper(subtext[j + 1])
						   || ok.allUpper(subtext[j + 2])))
						  
							{

						if (ok.isCourse(subtext[j])) {
							while (!ok.isTeacher(subtext[j])
									&& !ok.allUpper(subtext[j])
									&& !(subtext[j].charAt(0) == ' ')
									&& !(ok.isRoom(subtext[j]))) {
								//cell.add(new Token(subtext[j], TokenType.COURSE));
								concat+=subtext[j];
								
								j++;
							}
							cell.add(new Token(concat, TokenType.COURSE));
						//	 System.out.println(concat +
						//			 " ***course");
							concat="";
							j--;
						}
						/*
						 * if(!Character.isSpaceChar(subtext[j].charAt(j))){
						 * //prevent spaces
						 * while(!ok.isTeacher(subtext[j])||!ok.
						 * allUpper(subtext[j])){ System.out.println(subtext[j]
						 * +" ***Course"); j++; } }
						 */

					}
					if (subtext[j].charAt(0) == '-'
							&& subtext[j].charAt(1) == '-'
							&& subtext[j].charAt(2) == '-') {
						pause = subtext[j].split(" ");
						for (int k = 0; k < pause.length; k++) {
							cell.add(new Token("", TokenType.EMPTY));
							end_index.add((cell.size() - 1));
						//	 System.out.println("empty");

						}
					}
				}

			}

		} catch (Exception e) {
			//System.out.println(e);
		}
		for (int i = 0; i < cell.size(); i++) {
		//	System.out.println(cell.get(i));
		}
		return cell;
	}

	public boolean isTime(String time) {

		if (Character.isDigit(time.charAt(0))
				&& Character.isDigit(time.charAt(1)) && time.charAt(2) == ':'
				&& Character.isDigit(time.charAt(3))
				&& Character.isDigit(time.charAt(4)) /* && time.length() == 6 */) {

			return true;
		}
		return false;
	}

	public boolean isRoom(String room) {
		if (Character.isLetter(room.charAt(0))
				&& Character.isSpaceChar(room.charAt(1))
				&& Character.isDigit(room.charAt(2)) && room.charAt(3) == '-'
				&& Character.isDigit(room.charAt(4))) {

			return true;
		}
		  else if(room.charAt(0)=='H'  && room.charAt(1)=='M')
      		return true;
		return false;

	}

	public boolean isTeacher(String teacher) {

		for (int i = 0; i < teacher.length(); i++) {

			if (teacher.charAt(i) == ';') {
				return true;
			}
		}
		return false;

	}

	public boolean allUpper(String word) {
		boolean test = false;
		if (isTeacher(word)) {
			return false;
		}
		if (isRoom(word)) {
			return false;
		}
		if (isTime(word)) {
			return false;
		}

		for (int i = 0; i < word.length(); i++) {

			if (Character.isSpaceChar(word.charAt(i))) {
				break;
			}

			if (word.charAt(i) == ';') {
				return false;
			}
			if (Character.isUpperCase(word.charAt(i))) {
				test = true;
			} else {
				return false;
			}
		}
		return test;
	}

	public boolean isSubclass(String subclass) {
		int compt = 0;

		if (!Character.isUpperCase(subclass.charAt(0))) {
			return false;
		}
		for (int i = 0; i < subclass.length(); i++) {
			if (subclass.charAt(i) == '-') {
				compt++;
			}
		}
		if (compt == 3 || compt == 6) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isCourse(String course) {
		int i = 0;
		for (int j = 0; j < course.length(); j++) {

			if (course.charAt(j) == '(' || course.charAt(j) == ')') {
				i++;
			}
		}
		if (i == 1) {
			return false;
		}
		if (Character.isUpperCase(course.charAt(0))
				&& !Character.isSpaceChar(course.charAt(1))
				&& !course.trim().isEmpty()
				&& Character.isLowerCase(course.charAt(1))
				&& Character.isLowerCase(course.charAt(2))
				) {
			return true;
		} else {
			return false;
		}
	}
}

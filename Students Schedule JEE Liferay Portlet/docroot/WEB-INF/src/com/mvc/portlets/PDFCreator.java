package com.mvc.portlets;

import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFCreator {


	public void create(ArrayList<Cell> cells,String fileName,String className,int nbpage){
		cells = new ArrayList<Cell>();
		ArrayList<String> horaire = new ArrayList<String>();
		ReadFromDB RD = new ReadFromDB();
		cells=RD.getList((nbpage-2)*36);
		
		
		String[] jours={"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
			
		for(int i=0;i<cells.size();i++){
			if(cells.get(i).getHour().equals("empty")){
				
			}
			else if(horaire.isEmpty()){
				horaire.add(cells.get(i).getHour());
			}
			else if(!cells.get(i).getHour().equals(horaire.get(horaire.size()-1))){
				horaire.add(cells.get(i).getHour());
				
			}
			}
			
		
		// System.out.println(horaire.size());
			 try {
		            Document iText_Create_Table = new Document();
		            String dirName = System.getProperty("user.home");
		            PdfWriter.getInstance(iText_Create_Table, new FileOutputStream(dirName+"\\"+fileName+".pdf"));
		            iText_Create_Table.open();
		            
		                     
		            PdfPTable my_second_table = new PdfPTable(1); 
		            my_second_table.setHorizontalAlignment(0);
		            my_second_table.setWidthPercentage(288 / 2.8f);
		            my_second_table.setWidths(new int[]{3, 12, 12, 12, 12, 12, 12});
		            PdfPCell table_cell2;
		            table_cell2=new PdfPCell();
		            my_second_table.addCell(table_cell2);//p
		            table_cell2.setColspan(0); 
		            table_cell2.setRowspan(2);

		            my_second_table.addCell("                                                                Eniso");
		            my_second_table.addCell("                                                                "+className);

		           
		            PdfPTable my_first_table = new PdfPTable(horaire.size()+1);
		            
		            my_first_table.setHorizontalAlignment(0);
		            my_first_table.setWidthPercentage(288 / 2.8f);
		            my_first_table.setWidths(new int[]{3, 12, 12, 12, 12, 12, 12});
		            
		            PdfPCell table_cell; 
		            table_cell=new PdfPCell();
		            table_cell.setColspan(7); 
		            table_cell.setRowspan(cells.size()/horaire.size()+1); 
		            my_first_table.addCell(table_cell);
		            
		           //my_first_table.setTotalWidth(50);

		            
		            my_first_table.addCell("");
		           for (int i = 0; i < cells.size()/horaire.size(); i++) {
		        	   my_first_table.addCell(jours[i]);
				}
		           
		            for (int i = 0; i < horaire.size(); i++) {
		            	my_first_table.addCell(new Paragraph(horaire.get(i), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7)));
		            	for (int j = 0; j <cells.size()/horaire.size(); j++) {
		            		String build="";
		            		String subclass=cells.get(j+i*horaire.size()).getSubclass1();
		            		String course=cells.get(j+i*horaire.size()).getCourse1();
		            		String teacher=cells.get(j+i*horaire.size()).getTeacher1();
		            		String room=cells.get(j+i*horaire.size()).getRoom1();

		            		
		            		if(!subclass.equals("empty")){
		            			build+=subclass+"\n";
		            		}
		            		if(!course.equals("empty")){
		            			build+=course+"\n";
		            		}
		            		if(!teacher.equals("empty")){
		            			build+=teacher+"\n";
		            		}
		            		if(!room.equals("empty")){
		            			build+=room+"\n";
		            		}
		            		
		            		if((cells.get(j+i*horaire.size()).getCourse1().equals("empty"))){
		            			
		            			my_first_table.addCell(new Paragraph("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 6)));
		            			
		            		}else{
		            			
		            			my_first_table.addCell(new Paragraph(build, FontFactory.getFont(FontFactory.TIMES_ROMAN, 6)));
		            	
		            		}
						}
					}
		      
		            iText_Create_Table.add(my_second_table);
		            iText_Create_Table.add(my_first_table);    
	  
		            iText_Create_Table.close();
		        }
		       catch (Exception i)
		        {
		            System.out.println(i);
		        }
			
		}
	

	
}


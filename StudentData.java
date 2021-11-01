package swingmvclab;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/*
 * A hallgatók adatait tároló osztály.
 */
public class StudentData extends AbstractTableModel{

    /*
     * Ez a tagváltozó tárolja a hallgatói adatokat.
     * NE MÓDOSÍTSD!
     */
    List<Student> students = new ArrayList<Student>();

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return students.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student = students.get(rowIndex);
		 switch(columnIndex) {
		 	case 0: return student.getName();
		 	case 1: return student.getNeptun();
		 	case 2: return student.hasSignature();
		 	default: return student.getGrade();
		 }
	}
	 public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	 }
	 public String getColumnName(int col) {
		 String[] cols = {"Név", "Neptun", "Aláírás", "Jegy"};  
		 return cols[col];
    }
	public boolean isCellEditable(int row, int col) {
		if(col==2 || col==3) {
			return true;
		}
		else {
			return false;
		}
	}
	public void setValueAt(Object value, int row, int col) {
        Student s=students.get(row);
        if(col==2) {
        	s.setSignature((Boolean)value);
        }
        else if(col==3) {
        	s.setGrade((Integer)value);
        }
        students.set(row, s);
        
        this.fireTableRowsUpdated(row, row);
    }
	public void addStudent(String name, String neptun) {
		students.add(new Student(name, neptun, false, 0));
		this.fireTableDataChanged();
	}
}

package student;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main 
{
	static ArrayList<Student> studentList = new ArrayList<Student>();
	
	public static void main(String[] args) 
	{
		new main().getStudent();
		new main().addNewStudent();
		try {
			new main().createFile(studentList);
			for(int i=0; i< studentList.size();i++){
				System.out.println(studentList.get(i).getFirstName());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getStudent()
	{		
		try {
			String fileName = "database.txt";
			String line = null;
			// FileReader reads text files in the default encoding.
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			boolean isLastLine999 = false;

			while ((line = bufferedReader.readLine()) != null) {

				if (isLastLine999) 
				{
					System.out.println("after -999:" + line);
					isLastLine999 = false;
				} 
				else
				{
					Student student = addStudent(line); // CREATE A D
					isLastLine999 = false;
					while ((line = bufferedReader.readLine()) != null && !line.equals("-999")) 
					{
						System.out.println("[Before adding-course length: " + student.CoursesList.size() );
						addCourseToStudent(line,student);
						System.out.println("[After adding-course length: " + student.CoursesList.size() );
					}
					studentList.add(student);
					if (line.equals("-999")) 
					{
						isLastLine999 = true;
					}				
				}
			}
			bufferedReader.close();
			display();
		} 
		catch (FileNotFoundException ex) 
		{
			System.out.println("Unable to open file ");
		} 
		catch (IOException ex) 
		{
			System.out.println("Error reading file ");
		}
		catch (ArrayIndexOutOfBoundsException ex) 
		{
			System.out.println(" ArrayIndexOutOfBoundsException");
		}
	}

	public Student addStudent(String lineToParse) 
	{
		Student stu = new Student();
		System.out.println("line" + ": " + lineToParse);

		String[] data = lineToParse.split(",");
		stu.setLastName(data[0]);
		stu.setFirstName(data[1]);
		stu.setID(data[2]);

		System.out.println(stu.getLastName());
		System.out.println(stu.getFirstName());
		System.out.println(stu.getID());
		return stu;
	}

	public void addCourseToStudent(String lineToParse, Student stu) 
	{
		course cs = new course();
		System.out.println("line" + ": " + lineToParse + "," + lineToParse.length());

		String[] data = lineToParse.split(",");
		cs.setNumber(data[0]);
		cs.setCredit(Double.parseDouble(data[1]));
		cs.setGrade(data[2]);
		System.out.println(cs.getNumber());
		System.out.println(cs.getCredit());
		System.out.println(cs.getGrade());
		stu.CoursesList.add(cs);
	}

	public void display() 
	{
		double averageGPA=0;
		for(int i=0; i< studentList.size();i++){
			
			Student student = studentList.get(i); 
			System.out.println("Student"+i+"\n"+student.toString());
	
			for(int j=0; j<student.CoursesList.size();j++){
				course cs = student.CoursesList.get(j); 
				System.out.println("Courses"+j+"\n"+cs.toString());
			}	
			averageGPA = student.studentTotalGPA()/student.CoursesList.size();
			System.out.print("totalCredit = "+ student.studentTotalCredits()+" GPA = ");
			System.out.printf("%.2f",averageGPA);
			System.out.println("\n");
			System.out.println("---------------------------------------------------------");
		}	
	}
	
	public String addNewStudent(){
		String name = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter stuent name: ");
		try {
			name = br.readLine();
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return name;
	}
	
	private void createFile( ArrayList<Student> arrData)
            throws IOException {
        FileWriter writer = new FileWriter("outputs.txt");
        int size = arrData.size();
        for (int i=0;i<size;i++) {
            String str = arrData.get(i).toString(); 
            writer.write(str);
            System.out.println("\n");
            if(i < size-1)
            	//This prevent creating a blank like at the end of the file**
                writer.write("\n");
        }
        writer.close();
    }
}

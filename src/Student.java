
public class Student implements Comparable {
	String s_name;
	String s_number;
	String s_sex;
	int s_grade;
	
	public Student() {
		super();
	}

	public Student(String s_name, String s_no, String s_sex, int s_grade) {
		super();
		this.s_name = s_name;
		this.s_number = s_no;
		this.s_sex = s_sex;
		this.s_grade = s_grade;
	}

	@Override
	public int compareTo(Object b) {
		Student st=(Student)b;
		if((st.s_grade-this.s_grade)==0)
		{
			return 1;
		}
		return (st.s_grade-this.s_grade);
	}

	
	

}
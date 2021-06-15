package ex;

	import java.lang.Comparable;
//	import java.util.Arrays;
//	import java.util.Comparator; //Comparator ����ϱ� ���� import

	class Student implements Comparable<Student> {
		String name; //�̸�
		int id; //�й�
		double score; //����
		public Student(String name, int id, double score){
			this.name = name;
			this.id = id;
			this.score = score;
		}
		public String toString(){
			return "�̸�: "+name+", �й�: "+id+", ����: "+score;
		}
		/* �⺻ ���� ����: �й� �������� */
		public int compareTo(Student anotherStudent) {
			return Integer.compare(id, anotherStudent.id);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getScore() {
			return score;
		}
		public void setScore(double score) {
			this.score = score;
		}
		
		
		
	}

	public class Ex{
		public static void main(String[] args) {
			Student student[] = new Student[5];
			//������� "�̸�", �й�, ����
			student[0] = new Student("Dave", 20120001, 4.2);
			student[1] = new Student("Amie", 20150001, 4.5);
			student[2] = new Student("Emma", 20110001, 3.5);
			student[3] = new Student("Brad", 20130001, 2.8);
			student[4] = new Student("Cara", 20140001, 4.2);
			for(int j=0;j<4;j++) {
				for(int i=0;i<4;i++) {
					if(student[i].getScore()<student[i+1].getScore()) {
						Student temp = student[i];
						student[i]=student[i+1];
						student[i+1]=temp;
					}
				}
			}
			for(int i=0;i<5;i++) {
				System.out.println(student[i]);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			}
}	

	
	
	
//			Arrays.sort(student, new Comparator<Student>(){
//				public int compare(Student s1, Student s2) {
//					double s1Score = s1.score;
//					double s2Score = s2.score;
//					if(s1Score == s2Score){ //������ ������
//						return Double.compare(s1.id, s2.id); //�й� ��������
//					}
//					return Double.compare(s2Score, s1Score);//��������
//				}
//			});
//			for(int i=0;i<5;i++)
//				System.out.println(student[i]);



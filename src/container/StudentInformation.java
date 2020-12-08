package container;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;
//2���ɿ���̨���չ̶���ʽ����ѧ����Ϣ������ѧ�ţ�������������Ϣ�������������Ϊexit�˳���
// �������ѧ����Ϣ�ֱ��װ��һ��Student�����У�
// �ٽ�ÿ��Student������뵽һ�������У�
// Ҫ�󼯺��е�Ԫ�ذ��������С��������
// ���������ϣ���������ѧ����Ϣд�뵽���±���ÿ��ѧ������ռ����һ��
public class StudentInformation {
    static class Student implements Comparable{
        String index;//ѧ��
        String name;//����
        int age;//������Ϣ
        public Student(String index,String name,int age){
            this.index = index;//���
            this.name = name;//����
            this.age = age;//����
        }
        public String getIndex(){
            return this.index;
        }
        public void setIndex(String index){
            this.index = index;
        }
        public String getName(){
            return this.name;
        }
        public void setName(String name){
            this.name = name;
        }
        public int getAge(){
            return this.age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public int compareTo(Object o) {
            if(!(o instanceof Student)){
                throw new RuntimeException("����Student����");
            }
            Student p = (Student) o;
            if(this.age > p.age){
                return 1;
            }else if(this.age == p.age){
                return this.name.compareTo(p.name);
            }else{
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<Student> students = new TreeSet<Student>();
        while(true){
            String index = input.next();
            if("exit".equals(index)){
                break;
            }
            String name = input.next();
            int age = input.nextInt();
            Student x = new Student(index,name,age);
            students.add(x);
        }
        Iterator<Student> it = students.iterator();
        while(it.hasNext()){
            Student student = (Student)it.next();
            System.out.println("name:" + student.getName()+" "+student.getAge()+" "+student.getIndex());
        }
    }
}

//3212313  Mike  10
//1231546  Joe   24
//7897451  Betty 15
//5665456  Kiki  19
//8798456  Biliy 15

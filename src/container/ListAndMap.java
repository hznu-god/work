package container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map;

//ʹ�������ӳ���Ŷ��ͼ����Ϣ�������������������Ʒ���ԣ���ţ����ƣ����ۣ������磻ʹ����Ʒ�����Ϊӳ���е�key��

class book{
	private String id;
	private String name;
	private double price;
	private String press;
	public book(){};
	public book(String id,String name,double price,String press) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.press=press;
	}
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}
	public String getPress() {
		return this.press;
	}
}
public class ListAndMap {

	public static void main(String[] args) {
		List<book> list=new ArrayList<book>();
		list.add(new book("#001","����������������",0.99,"�ְֳ�����"));
		list.add(new book("#002","����Ȩ����������",1.99,"�ְֳ�����"));
		list.add(new book("#003","�����Ƕ�һ�����������塷",38.4,"hz"));
		list.add(new book("#004","�������ȫ����·����",14.38,"bj"));
		list.add(new book("#005","����л�Լ��Ĳ�������",52.8,"nj"));
		list.add(new book("#006","���ҵ����벻�����Լ���",37.84,"sz"));
		Iterator<book> it=list.iterator();
		while(it.hasNext()) {
			book temp=(book)it.next();
			System.out.println(temp.getId()+" "+temp.getName()+" "+temp.getPrice()+" "+temp.getPress());
		}
		System.out.println("---------------------------------------------------------------");
		Map<String,book> mp=new HashMap<String,book>();
		mp.put("#001",new book("#001","����������������",0.99,"�ְֳ�����"));
		mp.put("#002",new book("#002","����Ȩ����������",1.99,"�ְֳ�����"));
		mp.put("#003",new book("#003","�����Ƕ�һ�����������塷",38.4,"hz"));
		mp.put("#004",new book("#004","�������ȫ����·����",14.38,"bj"));
		mp.put("#005",new book("#005","����л�Լ��Ĳ�������",52.8,"nj"));
		mp.put("#006",new book("#006","���ҵ����벻�����Լ���",37.84,"sz"));
		Iterator iter=mp.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry entry=(Map.Entry)iter.next();
			System.out.println("next:"+entry.getKey()+" "+((book)entry.getValue()).getName()
								+" "+((book)entry.getValue()).getPrice()+" "+((book)entry.getValue()).getPress());
		}
		
	}

}

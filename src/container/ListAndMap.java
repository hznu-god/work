package container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map;

//使用链表和映射存放多个图书信息，遍历并输出。其中商品属性：编号，名称，单价，出版社；使用商品编号作为映射中的key。

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
		list.add(new book("#001","《《狗子人生》》",0.99,"爸爸出版社"));
		list.add(new book("#002","《《权哥人生》》",1.99,"爸爸出版社"));
		list.add(new book("#003","《我们都一样年轻又彷徨》",38.4,"hz"));
		list.add(new book("#004","《从你的全世界路过》",14.38,"bj"));
		list.add(new book("#005","《感谢自己的不完美》",52.8,"nj"));
		list.add(new book("#006","《找到意想不到的自己》",37.84,"sz"));
		Iterator<book> it=list.iterator();
		while(it.hasNext()) {
			book temp=(book)it.next();
			System.out.println(temp.getId()+" "+temp.getName()+" "+temp.getPrice()+" "+temp.getPress());
		}
		System.out.println("---------------------------------------------------------------");
		Map<String,book> mp=new HashMap<String,book>();
		mp.put("#001",new book("#001","《《狗子人生》》",0.99,"爸爸出版社"));
		mp.put("#002",new book("#002","《《权哥人生》》",1.99,"爸爸出版社"));
		mp.put("#003",new book("#003","《我们都一样年轻又彷徨》",38.4,"hz"));
		mp.put("#004",new book("#004","《从你的全世界路过》",14.38,"bj"));
		mp.put("#005",new book("#005","《感谢自己的不完美》",52.8,"nj"));
		mp.put("#006",new book("#006","《找到意想不到的自己》",37.84,"sz"));
		Iterator iter=mp.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry entry=(Map.Entry)iter.next();
			System.out.println("next:"+entry.getKey()+" "+((book)entry.getValue()).getName()
								+" "+((book)entry.getValue()).getPrice()+" "+((book)entry.getValue()).getPress());
		}
		
	}

}

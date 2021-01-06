package termhomework;
/**
 * 
 * @author wily
 * @describe Record notification related data, such as notification name, notification content, etc
 * @version 1.0
 * 
 */
public class Notice {
	/**
	 * Notification name
	 */
	private String name=null;
	
	/**
	 * Notice content
	 */
	private String content=null;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}

package servlet.assist;

public class GetEquipmentName {
	private String name = null;
	public String getRquimentName(String i){
		int num = Integer.valueOf(i);
		switch(num){
			case 1:
				name = "乒乓球";
				break;
			case 2:
				name= "羽毛球";
				break;
			case 3:
				name = "保龄球";
				break;
			case 4:
				name = "哑铃";
				break;
			case 5:
				name = "毽球";
				break;
			case 6:
				name = "篮球";
				break;
		}
		return name;
	}
}

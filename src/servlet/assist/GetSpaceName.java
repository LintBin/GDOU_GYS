package servlet.assist;

public class GetSpaceName {
	String name = null;
	public String getSpaceName(String i){
		int num = Integer.valueOf(i);
		switch(num){
			case 0:
				name="";
				break;
			case 1:
				name="兵乓球场";
				break;
			case 2:
				name="羽毛球场";
				break;
			case 3:
				name="保龄球场";
				break;
			case 4:
				name="健身室场";
				break;
			case 5:
				name="毽球场";
				break;
			case 6:
				name="篮球场";
				break;
		}
		return name;
	}
	
	
	
}

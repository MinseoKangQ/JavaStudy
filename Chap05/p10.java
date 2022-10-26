import java.util.Scanner;

// p10

abstract class PairMap {
	
	// 필드 
	protected String keyArray[]; // key 들을 저장하는 배열
	protected String valueArray[]; // value 들을 저장하는 배열
	
	// 추상 메소드, 서브 클래스에서 구현해야함 
	abstract String get(String key); // key값을 가진 value 리턴, 없으면 null 리턴
	abstract void put(String key, String value);// key와 value를 쌍으로 저장, 기전에 key가 있으면 ,값을 value로 수정
	abstract String delete(String key); // key 값을 가진 아이템 삭제, 삭제된 value 값 리턴 
	abstract int length(); // 현재 저장된 아이템의 개수 리턴 
	
}

class Dictionary extends PairMap{	
	
	// 필드 
	private int num;
	
	// 생성자 메소드
	public Dictionary(int num) {
		
		this.num = num;
		super.keyArray = new String[num];
		super.valueArray = new String[num];

	}
	
	@Override
	public String get(String key) {
		
		// 반복해서 매개변수로 입력받은 key 존재하는지 확인
		for (int i = 0; i<num; i++) {
			if (key.equals(super.keyArray[i])) 
				return super.valueArray[i];
		}
		return null;
	}
	
	@Override
	public void put(String key, String value) {
		
		int i;
		for (i = 0; i<this.num; i++) { // 이미 같은 key 값이 존재한다면 
			if (key.equals(super.keyArray[i])) {
				super.valueArray[i] = value;
				break; 
			}
			else if (super.keyArray[i]==null){
				super.keyArray[i] = key;
				super.valueArray[i] = value;
				break;
			}
		}
		
	}
	
	@Override
	public String delete(String key) {
		
		String save = null;
		
		for (int i = 0; i<keyArray.length; i++) {
			if (super.keyArray[i].equals(key)) {
				save = super.valueArray[i];
				super.keyArray[i] = null;
				super.valueArray[i] = null;
				break;
			}
		}
		return save;
	}
	
	@Override
	public int length() {
		
		int count = 0;
		for (int i = 0; i<num; i++) {
			if(super.keyArray[i] != null) count++;
		}
		return count;
		
	}
		
	
}

public class DictionaryApp {
	
	public static void main(String [] args) {
		
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이선");
		dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정
		System.out.println("이재문의 값은 " + dic.get("이재문"));
		System.out.println("황기태의 값은 " + dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 " + dic.get("황기타"));
		
	}
}

class Song {
	
	// 필드
	private String title; // 제목 
	private String artist; // 가수 
	private int year; // 발표 년도 
	private String country; // 국적 
	
	// 생성자 메소드 (매개변수 없음)
	public Song() {}

	// 생성자 메소드 (매개변수 있음)
	public Song(int year, String country, String artist, String title ) {
		this.year = year;
		this.country = country;
		this.artist = artist;
		this.title = title;
	}
	
	// Getter 메소드
	public String getTitle() { return title; }
	public String getArtist() { return artist; }
	public int getYear() { return year; }
	public String getCountry() { return country; }
	
	// 노래 정보를 출력하는 메소드
	public void show() {
		System.out.println(getYear() + "년 " + getCountry() + "국적의 " + getArtist() + "가 부른 " + getTitle());
	}
	
}
public class p3 {
	
	public static void main(String [] args) {
		Song mysong = new Song(1978, "스웨덴", "ABBA", "Dancing Queen");
		mysong.show();
	}
	
}

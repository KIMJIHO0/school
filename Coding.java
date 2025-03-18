import java.util.*;

public class Coding {
    private String str;
    private HashMap<Character, Integer> map = new HashMap<>();
    private char[] chr;

    public Coding(String input) {
        this.str = input.toUpperCase(); // 입력된 문자열을 대문자로 변환
        this.chr = str.toCharArray();
    }

    // 빈도수 계산
    void putFrequency() {
        for (char c : chr) {
            if (c >= 'A' && c <= 'Z') { // A~Z 범위 내 알파벳만 카운트
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        sortingWithValues();
    }

    // 빈도수 내림차순 정렬
    void sortingWithValues() {
        List<Character> keyList = new ArrayList<>(map.keySet());

        keyList.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1))); // 내림차순 정렬

        System.out.println("\n🔹 문자 빈도수 분석:");
        for (Character chr : keyList) {
            System.out.print(chr + ":" + map.get(chr) + " ");
        }
        System.out.println("\n");
    }

    // 암호 해독 (빈도수 기반 문자 치환)
    void decryption() {
        String dstr = str
                .replace('P', 'e')
                .replace('S', 't')
                .replace('O', 'h')

                .replace('K', 'i')
                .replace('H', 'a')

                .replace('M', 'o')

                .replace('V', 'm')
                .replace('X', 'r')
                .replace('T', 'w')

                .replace('A', 'l')
                .replace('D', 'g')
                .replace('B', 'n')
                .replace('U', 's')
                .replace('E', 'c')
                .replace('L', 'd')
                .replace('J', 'y')
                .replace('Z', 'u')
                .replace('Q', 'f')
                .replace('W', 'p')

                .replace('C', 'v')
                .replace('G', 'q')
                .replace('I', 'b')
                .replace('F', 'j')
                .replace('R', 'k');

        System.out.println("🔹 해독된 문장:");
        System.out.println(dstr);
    }

    public void myMain() {
        putFrequency();
        decryption();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔹 암호를 입력하세요:");
        String input = scanner.nextLine(); // 사용자로부터 암호문 입력받기

        Coding decoding = new Coding(input); // 입력값을 생성자에 전달
        decoding.myMain(); // 빈도수 분석 및 해독 실행

        scanner.close();
    }
}


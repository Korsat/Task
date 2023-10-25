public class Main {
    public static void main(String[] args) {
        MyString test = new MyString("Первый второй третий");
        MyString test2 = new MyString("четвертый");
        MyString[] test3 = test.split(test, ' ');
        for (int i = 0; i < test3.length; i++) {
            MyString.print(test3[i]);
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyString test = new MyString("Первый второй третий");
        MyString test2 = new MyString("четвертый");
        MyString[] test3 = MyString.split(test, ' ');
        for (int i = 0; i < test3.length; i++) {
            MyString.print(test3[i]);
            System.out.println();
        }
        MyString test4 = MyString.join(test, test2, ' ');

        MyString search = new MyString("второй");
        MyString replacement = new MyString("пятый");
        MyString test6 = MyString.replace(test, search, replacement);
        MyString.print(test6);

//        MyString test5 = MyString.concat(test, test2);
//        MyString.print(test4);
//        System.out.println();
//        MyString.print(test5);
//        System.out.println(MyString.equals(test, test2));
//        System.out.println(MyString.join(test, test2, ' '));
    }
}

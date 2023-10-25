import java.util.ArrayList;

public class MyString {
    private char[] str;

    public MyString(String s) {
        this.str = s.toCharArray();
    }

    public int length() {
        return this.str.length;
    }

    public char charAt(int index) {
        if (index >= 0 && index < this.str.length) {
            return this.str[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void print(MyString s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }
    }


    // соединение строк
    public static MyString concat(MyString s1, MyString s2) {
        char[] newString = new char[s1.str.length + s2.length()];
        System.arraycopy(s1.str, 0, newString, 0, s1.str.length);
        System.arraycopy(s2.str, 0, newString, s1.str.length, s2.length());
        return new MyString(new String(newString));
    }

    public static MyString join(MyString s1, MyString s2, char delimiter) {
        char[] newString = new char[s1.length() + s2.length() + 1];
        int length = s1.length() + s2.length() + 1;

        for (int i = 0; i < s1.length(); i++) {
            newString[i] = s1.charAt(i);
        }
        newString[s1.length()] = delimiter;
        for (int i = s1.length()+1; i < length; i++) {
            newString[i] = s2.charAt(i-s1.length()-1);
        }

        MyString res = new MyString(new String(newString));
        return res;
    }

    public static MyString[] split(MyString s, char delimiter) {
        ArrayList<MyString> preres = new ArrayList<>();
        int i = 0;
        int pi = 0;
        while (i < s.length()) {
            if (s.charAt(i) == delimiter) {
                preres.add(s.substring(pi, i));
                pi = i+1;
                i++;
            }
            i++;
        }
        preres.add(s.substring(pi, s.length()));
        MyString[] res = new MyString[preres.size()];
        for (int j = 0; j < preres.size(); j++) {
            res[j] = preres.get(j);
        }
        return res;
    }


    // сравнение двух строк
    public static boolean equals(MyString s1, MyString s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // проверка на пустую строку
    public boolean isEmpty() {
        return this.str.length == 0;
    }


    // индекс передаваемого элемента
    public static int indexOf(MyString s ,char c) {
        for (int i = 0; i < s.str.length; i++) {
            if (s.str[i] == c) {
                return i;
            }
        }

        return -1;
    }


    // кусок строки с "beginIndex" до "endIndex"
    public MyString substring(int beginIndex, int endIndex) {
        char[] newString = new char[endIndex - beginIndex];
        System.arraycopy(this.str, beginIndex, newString, 0, endIndex - beginIndex);
        return new MyString(new String(newString));
    }
}
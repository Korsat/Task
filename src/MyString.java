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
    public MyString concat(MyString s) {
        char[] newString = new char[this.str.length + s.length()];
        System.arraycopy(this.str, 0, newString, 0, this.str.length);
        System.arraycopy(s.str, 0, newString, this.str.length, s.length());
        return new MyString(new String(newString));
    }

    public MyString join(MyString s1, MyString s2, char delimiter) {
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

    public MyString[] split(MyString s, char delimiter) {
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
    public boolean equals(MyString s) {
        if (this.str.length != s.length()) {
            return false;
        }

        for (int i = 0; i < this.str.length; i++) {
            if (this.str[i] != s.charAt(i)) {
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
    public int indexOf(char c) {
        for (int i = 0; i < this.str.length; i++) {
            if (this.str[i] == c) {
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
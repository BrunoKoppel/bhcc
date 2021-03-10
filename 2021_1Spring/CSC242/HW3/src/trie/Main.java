package trie;

public class Main {

    public static void main(String[] args) {

        Trie one = new Trie();
        one.insert("Mother");
        System.out.println(one.contains("Mother"));

    }
}

package trie;

public class Main {

    public static void main(String[] args) {

        Trie one = new Trie();
        one.insert("Mother");
//        one.printTrie(one.root.children);
        System.out.println(one.getAllWords("Mo"));

    }
}

package org.kaidzen.study.codesignal;

public class VariableName {

    public static void main(String[] args) {
        VariableName name = new VariableName();

        System.out.println(name.solution("2w2"));
    }

    boolean solution(String name) {
        return name.matches("[a-zA-Z_]+[\\w]*");
    }
}

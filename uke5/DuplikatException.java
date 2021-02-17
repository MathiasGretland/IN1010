package uke5;

class DuplikatException extends Exception {
public DuplikatException (String id) {
        super("Duplikat: " + id);
        }
}
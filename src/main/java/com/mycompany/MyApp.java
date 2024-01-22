package com.mycompany;

import com.mycompany.notes.NoteManager;

public class MyApp {
    public static void main(String[] args) {
        NoteManager noteManager = new NoteManager();
        noteManager.addNote("Hello, world!");
        noteManager.printNotes();
    }
}

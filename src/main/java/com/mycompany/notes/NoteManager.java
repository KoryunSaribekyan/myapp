package com.mycompany.notes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteManager {
    private List<Note> notes;

    public NoteManager() {
        this.notes = new ArrayList<>();
    }

    public void addNote(String text) {
        Note note = new Note(text);
        notes.add(note);
        writeToExternalFile(note);
    }

    public void printNotes() {
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    private void writeToExternalFile(Note note) {
        String fileName = "notes.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String timestamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            writer.write(timestamp + " -> " + note.getText());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл.");
            e.printStackTrace();
        }
    }
}

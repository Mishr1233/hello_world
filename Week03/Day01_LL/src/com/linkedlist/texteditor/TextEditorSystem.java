package com.linkedlist.texteditor;


public class TextEditorSystem {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Simulate user actions
        editor.addTextState("Hello");
        editor.addTextState("Hello, World");
        editor.addTextState("Hello, World!");
        editor.addTextState("Hello, World! How are you?");

        // Display the current state
        editor.displayCurrentState(); // Should display "Hello, World! How are you?"

        // Perform undo operations
        editor.undo(); // Undo: "Hello, World!"
        editor.undo(); // Undo: "Hello, World"
        editor.undo(); // Undo: "Hello"
        editor.undo(); // No more undo history

        // Perform redo operations
        editor.redo(); // Redo: "Hello, World"
        editor.redo(); // Redo: "Hello, World!"
        editor.redo(); // Redo: "Hello, World! How are you?"
        editor.redo(); // No more redo history

        // Display current state again
        editor.displayCurrentState(); // Should display "Hello, World! How are you?"
    }
}

package com.linkedlist.texteditor;

public class TextEditor {
    private class TextState {
        String text;
        TextState next;
        TextState prev;

        public TextState(String text) {
            this.text = text;
            this.next = null;
            this.prev = null;
        }
    }

    private TextState currentState;
    private int historyLimit = 10;
    private int historySize = 0;

    public TextEditor() {
        this.currentState = null;
    }

    // Add a new text state to the history
    public void addTextState(String text) {
        TextState newState = new TextState(text);

        if (currentState != null) {
            if (historySize >= historyLimit) {
                // Remove the oldest state if history exceeds the limit
                currentState.prev = null;
                historySize--;
            }
            currentState.next = newState;
            newState.prev = currentState;
        }
        currentState = newState;
        historySize++;
    }

    // Undo functionality (move to the previous state)
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.text);
        } else {
            System.out.println("No more undo history.");
        }
    }

    // Redo functionality (move to the next state)
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.text);
        } else {
            System.out.println("No more redo history.");
        }
    }

    // Display the current text state
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.text);
        } else {
            System.out.println("No text in the editor.");
        }
    }

    // Set the history limit (optional)
    public void setHistoryLimit(int limit) {
        this.historyLimit = limit;
    }
}

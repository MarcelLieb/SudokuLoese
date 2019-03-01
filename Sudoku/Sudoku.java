class Sudoku
{
    SudokuTech Tech;
    Sudoku()
    {
        Tech = new SudokuTech();
    }
    /**
     * W1 bedeulktet Werte der 1. Zeile von oben,W2 der 2.Zeile etc.
     * Die Werte der Zeilen bitte von links nach rechts eingeben
     * Für die leeren Felder bitte 0 eingeben
     */
    void Input(int W1,int W2,int W3,int W4,int W5,int W6,int W7,int W8,int W9)
    {
        Tech.loeschen();
        Tech.Input(W1,W2,W3,W4,W5,W6,W7,W8,W9);
        Tech.anzeigenGrafik();
    }
    void Zeilenedit (int Zeile,int Werte)
    {
        Tech.InputZeile(Zeile,Werte);
        Tech.anzeigenGrafik();
    }
    void lösen()
    {
        Tech.loesen();
    }
    
}

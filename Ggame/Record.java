package Ggame;

class Record {
    private int win;
    private int lose;
    private int draw;

    public Record(int win, int lose, int draw) {
        this.win = win;
        this.lose = lose;
        this.draw = draw;
    }

    public void addWin() { win++; }
    public void addLose() { lose++; }
    public void addDraw() { draw++; }

    public double getRate() {
        int total = win + lose + draw;
        return total == 0 ? 0 : (win * 100.0) / total;
    }

    public int getWin() { return win; }
    public int getLose() { return lose; }
    public int getDraw() { return draw; }
}
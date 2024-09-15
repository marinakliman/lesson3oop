class УчебнаяГруппа {
    private String название;

    public УчебнаяГруппа(String название) {
        this.название = название;
    }

    public String getНазвание() {
        return название;
    }

    @Override
    public String toString() {
        return название;
    }
}

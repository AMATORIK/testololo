public enum NoteKind {
    PERMANENT("permanent"),
    LITERATURE("literature");

    private final String kind;

    NoteKind(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public static NoteKind fromString(String text) {
        for (NoteKind noteKind : NoteKind.values()) {
            if (noteKind.getKind().equals(text)) {
                return noteKind;
            }
        }
        return null;
    }
}

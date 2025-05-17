public interface PermanentNote extends Note{
    String getId();

    String getContent();

    String getDate();

    void setId(String id);

    void setContent(String content);

    void setDate(String date);

    @Override
    String toString();
}

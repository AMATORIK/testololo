import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractNote implements Note {
    protected final String id;
    protected LocalDate date;
    protected String content;
    protected final List<Tag> tags = new ArrayList<>();
    protected final List<String> links = new ArrayList<>();

    public AbstractNote(String id, LocalDate date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
        extractLinks();
    }

    @Override public String getId() { return id; }
    @Override public LocalDate getDate() { return date; }
    @Override public String getContent() { return content; }

    /**
     * Возвращает копию списка тегов.
     */
    @Override public List<Tag> getTags() {
        return Collections.unmodifiableList(new ArrayList<>(tags));
    }

    /**
     * Возвращает копию списка ссылок.
     */
    @Override public List<String> getLinks() {
        return Collections.unmodifiableList(new ArrayList<>(links));
    }

    @Override public boolean addTag(Tag tag) {
        for (Tag existing : tags) {
            if (existing.getId().equals(tag.getId())) {
                return false;
            }
        }
        tags.add(tag);
        return true;
    }

    @Override public boolean removeTag(Tag tag) {
        Iterator<Tag> iter = tags.iterator();
        while (iter.hasNext()) {
            if (iter.next().getId().equals(tag.getId())) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Извлекает метки-ссылки формата [[NoteID]] из текста content.
     */
    protected void extractLinks() {
        links.clear();
        var pattern = java.util.regex.Pattern.compile("\\[\\[(.+?)\\]\\]");
        var matcher = pattern.matcher(content);
        while (matcher.find()) {
            String ref = matcher.group(1);
            if (!links.contains(ref)) {
                links.add(ref);
            }
        }
    }

    /**
     * Обновление содержимого заметки (перепарсинг ссылок).
     */
    public void updateContent(String newContent, LocalDate newDate) {
        this.content = newContent;
        this.date = newDate;
        extractLinks();
    }
}
package misc; /**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 27/06/14
 * Time: 13.47
 */
public class VCS {

    private int head;

    public String checkout(String filename) {
        return checkout(filename, -1);
    }

    public String checkout(String filename, int revision) {

        if (revision == -1) {
            revision = head;
        }
        VersionedFile file = new VersionedFile(filename, revision);
        return file.getContent();
    }

    public void commit(String filename, int revision, String content) {
        head = revision;
        VersionedFile file = new VersionedFile(filename, revision);
        file.saveFile(content);
    }

    class VersionedFile {

        String filename;
        String content;
        int revision;

        VersionedFile(String filename, int revision) {
            this.revision = revision;
            this.filename = filename;
        }

        public void saveFile(String content) {
            // saves content on disk
        }

        public String getContent() {
            // loads file from disk
            return null;
        }


        public String getCompleteName() {
            return new StringBuilder(filename).append("-").append(revision).toString();
        }
    }
}

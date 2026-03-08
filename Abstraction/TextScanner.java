public class TextScanner {

    Yello obj;

    public TextScanner( Yello obj) {
            this.obj = obj;
    }

    void scan() {




        String text = "Scanned text 100% complete";
        obj.onText(text);
    }
}
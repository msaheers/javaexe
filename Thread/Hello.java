public class Hello {
    public static void main(String[] args) {
        SampleThread st = new SampleThread();
        SampleThread st1 = new SampleThread();
        SampleThread st2 = new SampleThread();

        st.start();
        st1.start();
        st2.start();
    }
}
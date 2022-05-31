package inheritance;

@FunctionalInterface
public interface PrintableExt {
    String print(String pref, String suff);

    static void sayboo() {
        System.out.println("boo");
    }

}
